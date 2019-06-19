# Django

- Django is a web development framework that assists in building and maintaining quality web applications. Django helps eliminate repetitive tasks making the development process an easy and time saving experience.

- The core Django framework can be seen as an MVC architecture. Before writing detailed explanation about each feature of the framework I would like to give an overview of the features of Django:<br>
  - object-relational mapper (ORM) that mediates between data models (defined as Python classes)  and a relational database ("Model")
  - system for processing HTTP requests with a web templating system ("View")
  - regular-expression-based URL dispatcher ("Controller").
  - a lightweight and standalone web server for development and testing
  - a form serialization and validation system that can translate between HTML forms and values suitable for storage in the database
  - a template system that utilizes the concept of inheritance borrowed from object-oriented programming
  - a caching framework that can use any of several cache methods
  - support for middleware classes that can intervene at various stages of request processing and carry out custom functions
  - an internal dispatcher system that allows components of an application to communicate events to each other via pre-defined signals
  - an internationalization system, including translations of Django's own components into a variety of languages
  - a serialization system that can produce and read XML and/or JSON representations of Django model instances
  - a system for extending the capabilities of the template engine  
  - an interface to Python's built-in unit test framework
  
- The main Django distribution also bundles a number of applications in its "contrib" package, including:
  - an extensible authentication system
  - the dynamic administrative interface
  - tools for generating RSS and Atom syndication feeds
  - a "Sites" framework that allows one Django installation to run multiple websites, each with their own content and applications
  - tools for generating Google Sitemaps
  - built-in mitigation for cross-site request forgery, cross-site scripting, SQL injection, password cracking and other typical web attacks, most of them turned on by defaul
  - a framework for creating GIS applications (graphical interface systems)
  
<br>
<br>
<br>

# Basics

- As you already know, Django is a Python web framework. And like most modern framework, Django supports the MVC pattern. First let's see what is the Model-View-Controller (MVC) pattern, and then we will look at Django’s specificity for the Model-View-Template (MVT) pattern.

- When talking about applications that provides UI (web or desktop), we usually talk about MVC architecture. And as the name suggests, MVC pattern is based on three components: Model, View, and Controller
 
### Django MVC - MVT Pattern

- The Model-View-Template (MVT) is slightly different from MVC. In fact the main difference between the two patterns is that Django itself takes care of the Controller part (Software Code that controls the interactions between the Model and View), leaving us with the template.

- The following image shows you the MVT schemantic that django ses
  <img src="./assets/basic-django.png" height="400px" alt="django-request-structure">
 
<br>
<br>
<br>

# Setup

- You can easily install Django using pip:
  ```
  $ pip install django
  ```
  After installing it lets try to set it up on our computer
  
- Now that we have installed Django, let's start using it. In Django, every web app you want to create is called a project; and a project is a sum of applications. An application is a set of code files relying on the MVT pattern. As example let's say we want to build a website, the website is our project and, the forum, news, contact engine are applications. This structure makes it easier to move an application between projects since every application is independent.
 
 
- Lets create a project:
  ```
  $ django-admin startproject <project_name> .
  ```
  This creates the necessary files to start building your project. Most poeple either name their <project_name> the actual name of the project or just `config` since this folder will be our entry point, it has the settings, urls, wsgi and etc. The folder structure weill be the following:
  ```
   project_name/
       manage.py
       config/
          __init__.py
          settings.py
          urls.py
          wsgi.py
  ```
  The “project_name” folder is just your project container, it actually contains two elements −
    - `manage.py` - This file is kind of your project local django-admin for interacting with your project via command line (start the development server, sync db...). To get a full list of command accessible via manage.py you can use the code −
      ```
      $ python manage.py help
      ```
    - `The “project_name” subfolder` - This folder is the actual python package of your project. It contains four files:
      - __init__.py − Just for python, treat this folder as package.
      - settings.py − As the name indicates, your project settings.
      - urls.py − All links of your project and the function to call. A kind of ToC of your project.
      - wsgi.py − If you need to deploy your project over WSGI.
      
### Setting Up Your Project

- Your project is set up in the subfolder myproject/settings.py. Following are some important options you might need to set −
  ```python
  DEBUG = True
  ```
  This option lets you set if your project is in debug mode or not. Debug mode lets you get more information about your project's error. Never set it to ‘True’ for a live project.
  
- Database settings:
  ```python
   DATABASES = {
     'default': {
        'ENGINE': 'django.db.backends.sqlite3',
        'NAME': 'database.sql',
        'USER': '',
        'PASSWORD': '',
        'HOST': '',
        'PORT': '',
     }
  }
  ```
  Database is set in the ‘Database’ dictionary. The example above is for SQLite engine. As stated earlier, Django also supports:
  - MySQL (django.db.backends.mysql)
  - PostGreSQL (django.db.backends.postgresql_psycopg2)
  - Oracle (django.db.backends.oracle) and NoSQL DB
  - MongoDB (django_mongodb_engine)
      
- ** There are tons of things to do and configure in your settings however the focus of this note file is not to give a specific feature of django. If you want to learn more on settings configuration see the parent directory of this file.

- Now that your project is created and configured make sure it's working:
  ```
  $ python manage.py runserver
  ```
  
<br>
<br>
<br>

# Apps

- A project is a sum of many applications. Every application has an objective and can be reused into another project, like the contact form on a website can be an application, and can be reused for others. See it as a module of your project. Try to be specific with your django applicaitons such as: contact, blog, forums, shop, profile, home ... etc.

- In order to create an django app go to your parent folder and do:
  ```
  $ python manage.py startapp <app_name>
  ```
  You just created myapp application and like project, Django create a “<app_name>” folder with the application structure −
  ```
  myapp/
     __init__.py
     admin.py
     models.py
     tests.py
     views.py
  ```
  - `__init__.py` − Just to make sure python handles this folder as a package.
  - `admin.py` − This file helps you make the app modifiable in the admin interface.
  - `models.py` − This is where all the application models are stored.
  - `tests.py` − This is where your unit tests are.
  - `views.py` − This is where your application views are.

- At this stage we have our new application, now we need to register it with our Django project "`config`". To do so, update INSTALLED_APPS tuple in the settings.py file of your project (add your app name) −
  ```python
  INSTALLED_APPS = (
   'django.contrib.admin',
   'django.contrib.auth',
   'django.contrib.contenttypes',
   'django.contrib.sessions',
   'django.contrib.messages',
   'django.contrib.staticfiles',
   
   '<app_name>',   # <-- you new app registered here
  )
  ```
  
<br>
<br>
<br>

# Admin Interface

- Django provides a ready-to-use user interface for administrative activities. We all know how an admin interface is important for a web project. Django automatically generates admin UI based on your project models.

- Before launching your server, to access your Admin Interface, you need to initiate the database −
  ```
  $ python manage.py migrate
  ```
  syncdb will create necessary tables or collections depending on your db type, necessary for the admin interface to run. Even if you don't have a superuser, you will be prompted to create one.
  
- If you already have a superuser or have forgotten it, you can always create one using the following code −
  ```
  $ python manage.py createsuperuser
  ```
  
  
  
  
  

 
 
 
 
 
 
 
 
