# Mozilla Django Tutorial -- Notes

I will take notes on the tutorial that is provided by the [Mozilla Docs](https://developer.mozilla.org/en-US/docs/Learn/Server-side/Django)

## Introduction

Django web applications typically group the code that handles each of these steps into seperate files: 

<img src="/web-development/level-1/django/assets/basic-django.png" height="400px" alt="django-request-structure">

- **URLs** : It is always logical to seperate urls from views for maintainability. That is why django uses url mappers. A URL mapper is used to redirect the HTTP requests to the appropirate views based on that URL.
- **View** :  Views are at the heart of django applications. A view is a request handler function. Which recieves HTTP requests and return HTTP responses. Views accsess data that is requested via models and formats the layout with templates.
- **Models** : Models are python objects that define the structure of an applications data and provide mechanisms to modify or query the data (CRUD, etc.) in the database.
- **Templates** : A template is the layout of your app. Usually your site will have a static template and will dynamically update parts of it depending on the request.

*Note: Django refers to this organisation as the "Model View Template(MVT)" architecture. It has many similarities to the more familiar "Model View Controller(MVC) architercture.*

The core elements of every dynamic web applications are urls, views, models and templates. Yet, django provides us much more than just the basic core elements, such as :

- Forms: Used to collect data from the user.
- User authentcation and permissions: To secure your site.
- Caching: Your pages does not get re-rendered unless if you want to.
- Administration site: django provides a fine admin panel with felixabilty to change the panel.
- Serialising data: django makes it easy to serialise your data to serve as XML or JSON

---

## Creating Skeleton

For each of the feature in your projects built with django you should start with creating the skelton for it and than add the desired parts of the body(models, views, templates). The proceeding of the skeleton is like this:

**1)** If you dont have the main project folder structre start with : (if you have it skip to the next step )
```
$ django-admin startproject `project-name` .
```
**2)** Use `manage.py` to create the desired app. (* Of course do not create apps for every bit of feature that you have, catogrize them such as, eg. main site, blog, wiki, download are, messageing ..etc.
```
$ python manage.py startapp `app-name`
```
**3)** Register the new applications to include them in the project (via settings in `INSTALLED_APPS` list). (after this point it is usually the time to specify your database weather it be sqlite, postgresql, mysql ..etc . Yet, however you dont have to since django comes shipped with sqlite as default.

entry-folder/settings.py 
```python
INSTALLED_APPS = [
  # other application regisitrations
  'app-name',
]
```
**4)** Hook up the url/path mapper for each application. In your porjects main entry urls file. You can create url hooks via `path()`. However since it is kinda difficult to hook everything only from the entry folder we can just create `path()`s in seperate apps and just `include()` all of the paths of that app with a single line of code.

Leaving the first string parameter of the path function blank -> `path('')` makes that app your roots index route.

entry-folder/urls.py
```python
from django.contrib import admin
from django.urls import path, include

urlpatterns = [
	path('admin/', admin.site.urls),
  #including all of the paths of the targeted app
  path('', include('app-name.urls')),
]
```

However, leaving paths first argument blank is not the best way to go, there  can be conlficts so to eliminate that there is a much more sophisticated and simple approach. Just import RedirectView and use it.

Yet, this is not necessary if you think you are good with your hooks skip this.

```python
#same thing
from django.contrib import admin
from django.urls import path, include
#new
from django.views.generic import RedirectView

urlpatterns = [
	path('admin/', admin.site.urls),
  #including all of the paths of the targeted app
  path('', include('app-name.urls')),
  #new
  path('', RedirectView.as_view(url='/app-name/')),
  
]
```

Lastly, to hook your paths with the views as they are the heartbeat of django you will need to hook `path`s in your apps urls to its views.

app-name/urls.py
```python
from django.urls import path, include
from . import views

urlpatterns = [
  #example
  path('', views.index, name='app-index-page'),
]
```


**5)** Run migrations to add/hook your finished app to the database
```
$ python manage.py makemigrations
$ python manage.py migrate
```

**You will need to run these two commands everytime you make a change in the structure of your models**

---

## Using Models
