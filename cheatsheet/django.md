## Django Cheatsheet

### Set-up

- `pip install django` -- installs django's package

### Creating a project

- 1 - `cd <main_folder>` -- change directory to the main home folder that you want to establish your project
- 2 - `django-admin startproject <project_name>` -- Creates a new django project. (Mostly name it "config")
- 3 - `python manage.py runserver` -- Run this to see if the setup is done and the porject is running correctly.

### Creating an app

- 1 - `python manage.py startapp <app_name>` -- This command creates an new app for the project
- 2 - `cd <app_name> && touch urls.py` -- Create a urls folder to add it to the __config__ folder
- 3 - Add this new app to the `INSTALLED_APPS = []` located int he settings.py file in the "config"

### Views

- 1 - First import these:
  ```python
  from django.shortcuts import render
  from django.http import HttpResponse
  ```
- 2 - You can either create an view with HttpResponse or a render, we mostly use HttpResponse for placeholder:
  ```python
  def index(request): return HttpResponse("<h1>Hello World</h1>")
  ```
  Or you can use the render to render a template 
  ```python
  def index(request):
    return render(request, "template_name.html", data)
  ```

### URL Mapping

- 1 - Firsly, before implementing any url mappings always include all of the urls.py file of the app witihin the config urls:
  ```python
  from django.contrib import admin
  from django.urls import include, path

  urlpatterns = [
      path('app/', include('app_name.urls')),
      path('admin/', admin.site.urls),
  ]
  ```
- 2 - Secondly, always add the url mapping within the app for their respective views:
  ```python 
  from django.urls import path
  from . import views

  urlpatterns = [
      path('', views.index, name='index'),
  ]
  ```

### Models

- 1 - `python manage.py makemigrations` -- always run this command and add migrations after you make an addition to the models
- 2 - `python manage.py migrate` -- finally migrate your new additions to the database everythime.
- 3 - The basic syntax for models is this:
  ```python
  class Musician(models.Model):
    id = models.AutoField(primary_key=True)
    first_name = models.CharField(max_length=50)
    last_name = models.CharField(max_length=50)
  ```
- You can have a lot of fields and parameters to the fields in django models:
  - `AutoField` -- autoincrementing field
  - `BigIntegerField` -- big integer field for storing big ints
  - `BinaryField` -- for storing binary values
  - `BooleanField` -- stores boolean values
  - `CharField` -- stores strigns and chatacters
  - `DateField` -- stores dates you can add
  - `DateTimeField` -- stores datea and its sepcific time
  - `DecimalField` -- stores float values
  - `EmailField` -- stores email
  - `FileField` -- stores file, imgs ... etc.
  - `FloatField` -- use this for your float values instead of decimal field
  - `ImageField` -- stores your images, use this for images intead of fileField
  - `IntegerField` -- stores integer values
  - `TextField` -- stores big text values not like char field where there is a max limit
  - `ForeignKey` -- creates realtions one-to-many
  - `ManyToManyField` - creates relations with many-to-many
  - `OneToOneField` -- creats realtions with 1-2-1
  

- Field options:
  - `max_length`, `auto_now`, `max_digits` , `upload_to` , `storage`, `height_field`, `width_field` , `model` , `null`, `blank`, `choices` , `db_column` , `db_index` , `db_tablespace` , `default`, `editable` , `primary_key`, `unique`, `help_text`, `verbose_name` ... etc.
  
- Query Set API:
  - `foo.objects.all()` -- returns all of the objects
  - `get()` -- returns you a specific record
  - `filter(args*)` --  filters the dataset with the given args
  - `exclude(args*)` -- filters and excludes the records with given args
  - `order_by()` -- orders the records
  - `reverse` -- reverses the records
  - `annotate` -- ...
  - `distinct` -- ...
  - `values` -- ...
  - `create (returns 1 obj)` -- creates an object dont forget to save it too
  - `count` -- returns you a count
  - `latest, earliest, first, last` -- gives you those records on the set
  - `delete` -- delete record
  - ... etc.

### Admin Page

- 1 - `python manage.py createsuperuser` --  Create a super user 
- 2 - `admin.site.register(ModelName)` -- Add the model to admin page

### Templates

- 1 - First you need to add your template folder into your __settings.py__ in the "config" folder. Othervise you will need to create templates/ folder in every app you create becasue by default django chceks tempalte in apps folders.
- 2 - Create a `base` template so that other templates can use its boilerplate code.
- 3 - You can write bsaic templates such as this:
  ```html
  {% extends 'base.html'% }
  {% load static %}

  {% block content %}

    Hello, World!

    {{ some_key_passed_into_the_context_dictionary }} 

  {% endblock %}
  ```
  
- Here are some tags that can be used in templates:
  - `{% autoescape %} {% autoescape %}` -- ...
  - `{% block %} {% endblock %}` -- block out and make your code more modular and maintainable.
  - `{% comment %} {% endcomment %}` -- add comments to your template
  - `{% csrf_token %}` -- secures your forms
  - `{% cycle %}` -- ...
  - `{% debug %}` -- ...
  - `{% extends " " %}` -- you can use this to have a parent code like "decorators" in python
  - `{% filter %} {% endfilter %}` -- ...
  - `{% for in %} {% endfor %}` -- creates a for loop
  - `{% if %} {% elif %} {% else %} {% endif %}` -- creates a if condition
  - `{% include %}` -- ...
  - `{% load %}` -- load static files caching files .. etc.
  - `{% url %}` -- include a view url in here
  - `{% static %}` -- use this to add static files, images to include it in the template
  - `{% spaceless %} {% endspaceless %}` -- ...
  - `{% templatetag %}` -- ...
  
> You can also do filtering in templates with `| linebreaks` ... etc.

### Page Redirection

- `return redirect(view_1)` -- redirects you to a view
- `return HttpResponseRedirect("/auth/login/")` -- you also use this, it is easier to add variables to the url path

### File Uploading

- Add a media root in your settings.py
- `picture = models.ImageField(upload_to = 'pictures')` -- add a image fielt and a __upload_to__ parameter to it

### Cookies

- `response.set_cookie('username')` -- add a cookie to the response 

### Sessions

- 1 - `'django.contrib.sessions.middleware.SessionMiddleware'` -- add this to middleware classes in settings.py
- 2 - `'django.contrib.sessions'` -- add this to installed apps
- 3 - Then you can use the following session functions:
  - `request.session['username'] = username` -- add a value to the session var
  - `username = request.session['username']` -- use the session variables value
  - `del request.session['username']` -- delete the session variable

### Froms

- ...

### Generic Views

- ...

### Sending Emails

- ...

### Caching

- ...

### RSS

- ...

### AJAX

- ...
