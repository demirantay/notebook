# Django -- Notes

These are very simplified general info about common tasks that are done in Django. For more info visit [Django official docs](https://docs.djangoproject.com/en/2.0/)

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

## Basic -- Intermediate

### Database setup
Before setting up any db schemes run the following command to include all the standart databases django gives you before any customazation : 

```
$ python manage.py migrate
```

#### Creating Tables

In django to crate tables in your database you need to model them in your apps folder under the `models.py` file.
Tables are formed with python classes. 

A basic user database scheme is written below : 

```python
from django.db import models

class User(models.Model):
        user_name = models.CharField(max_length=200)
        user_lastname = models.CharField(max_length=200)
        user_age = models.IntegerField(default=0)
        
class Post(models.Model):
        #the connection between tables is done by a foreign key
        user = models.ForeignKey(User, on_delete=models.CASCADE)
        post_content = models.TextField()
        pub_date = models.DateTimeField('date published')
       
```

#### Activating Models

Django framework does the heavylifting for us (creates the database schema) but it needs to be directed to the models.

In you `<project_name>/settings.py` you need to add your app to the `INSTALLED_APPS` in order to direct django to see your models in that app.

After including your app in the configuration file run the command:

```
$python manage.py makemigrations <app_name>
```

Migrations are very powerful and lets you change your models over time as you develop your project.

Always remember this 3-step guide:
- Change your models(in `models.py`)
- Run `python manage.py makemigrations` to create migrations for those changes
- Run `python manage.py migrate` to apply those changes in the stash zone to the database

---

### Django Admin







