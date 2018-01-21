# Django -- Notes

These are very simplified general info about common tasks that are done in Django.

## Basics

### Creating a project

To start a django project **cd** into a directory where you'd like to store your code, then run the following: 

```
$ django-admin startproject <projectname-generally-mysite>
```
### Running the server

To start the development server on your local machine run:

```
$ python manage.py runserver
```

### Creating apps

To create apps in your project use the following :

```
$ python manage.py startapp <app_name>
```

### Writing Views

Views are the pages your app contains. Most simplest view in Django is the following:

```python
from django.http import HttpResponse

def index(request):
    return HttpResponse('Hello world. you are at the index page'
```

To call the view you need to map it to a URL- and for this you need a URLconf .

To create a URLconf in your <app>'s directory, create a file called `urls.py`

In the `<your_app>/urls.py` include the following:

```python
from django.urls import path
from . import views

urlpatterns = [
    path('', views.index),
]
```

The last step is to point the root URLconf at the `<app_name>.urls` module. In `<porject_name>/urls.py` include your apps vies

```python
from django.urls import include, path
from django.contrib import admin

urlpatterns = [
    path('admin/', admin.site.urls),
    path('polls/', include('<app_name>.urls'),
]
```

---

## Intermediate

