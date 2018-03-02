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
---

## Using Models

Django web applications accsess and manage data through python objects reffered to as models. Models define the structure of stored data, including *field types*  and also their maximum size, default value, selecton list options, help text for documentation, labels for forms and etc.

It is not wise to add all of your fields in one big chunk of table(model). It is always useful to seperate your model tables by their object nature. For example if you were modeling a simple bookshop it would be wise to seperate them via books, authors, cataloged shelves. 

Once you are finished with the structure of your seperated models you need to think about their relationship. They cannot be wandering around themselves it does not make any sense. Django allows you to establish a one to one(`OneToOneField`), one to many(`ForeignKey`)and many to many(`ManyToManyField`) relationship between models .

A model structure can consist **Fields, Metadata and Methods** and we will go over each of them

Example:
```python
from django.db import models

#my table
class MyModelTableName(models.Model):

	#fields
	example_field = models.CharField(max_length=20)
	
	#meta-data
	class Meta:
		example_meta = [-'example_field']
		
	#methods
	def __str__(self):
		return self.example_field
```

### Fields

A model can have infinite number of fields, of any type each one represents a column of data we want to store in our database tables. Each database row of one of each field value. 

Lets look at this example:
```python
example_field_name = models.CharField(max_length=20, help_text='Enter field documentation')
```
above field example called `example_field_name` has a `models.CharField` type which means the data will be consisted from alphanumeric characters. The field types can also take arguments that further specify how the data is stored. In the case above we have two arguments:

- `max_length=20` : states that the maximum length of a value in this field is no more than 20 characters
- `help_text='Enter field documentation'` : provides a text label to display to help users know what value to provide for the html forms.

The templates or queries can access to fields via their name. Example from above is `example_field_name` is the fields name.

There are many argument types and you can look them up from the official documentation however these are the most common ones. But you can change it with verbose name argument

**`Common Field Arguments`**
- [help_text](https://docs.djangoproject.com/en/2.0/ref/models/fields/#help-text) : Provides a text label for html forms(eg. in admin site)
- [verbose_name](https://docs.djangoproject.com/en/2.0/ref/models/fields/#verbose-name) : A human readable name for the field used in field labels
- [default](https://docs.djangoproject.com/en/2.0/ref/models/fields/#default) : The default value for the field. 
- [null](https://docs.djangoproject.com/en/2.0/ref/models/fields/#null) : If `True` Django will store blank values of `NULL` in the database for fields where this is apropirate(a CharField will be an empty string). The default is `False`.
- [blank](https://docs.djangoproject.com/en/2.0/ref/models/fields/#blank) : If `True` the field is allowed to be blank in your forms. The default is `False` which means Django's form validation will forece you to enter a value. This is often used with `null=True`, because if you are going to allow blank values you also want the database to be able to represent them appropriately.
- [choices](https://docs.djangoproject.com/en/2.0/ref/models/fields/#choices) : a group of choices for this field. If this is provided the default corresponding form widget will be a select box with these choices instead of the standart text field.
- [primary_key](https://docs.djangoproject.com/en/2.0/ref/models/fields/#primary-key) : If `True`, sets the current field as the primary key for the model (a primary key is a special database column designated to uniqely identfiy all the different table records). If no field is specified as the primary key then Django will automatically add a field for this purpose.

there are more options view them all [here](https://docs.djangoproject.com/en/2.0/ref/models/fields/#field-options)

**`Common Field Types`**




