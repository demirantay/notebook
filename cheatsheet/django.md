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

### Templates

### Admin Page

### Page Redirection

### File Uploading

### Cookies

### Sessions

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
