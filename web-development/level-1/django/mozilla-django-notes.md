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

**Common Field Arguments**
- [help_text](https://docs.djangoproject.com/en/2.0/ref/models/fields/#help-text) : Provides a text label for html forms(eg. in admin site)
- [verbose_name](https://docs.djangoproject.com/en/2.0/ref/models/fields/#verbose-name) : A human readable name for the field used in field labels
- [default](https://docs.djangoproject.com/en/2.0/ref/models/fields/#default) : The default value for the field. 
- [null](https://docs.djangoproject.com/en/2.0/ref/models/fields/#null) : If `True` Django will store blank values of `NULL` in the database for fields where this is apropirate(a CharField will be an empty string). The default is `False`.
- [blank](https://docs.djangoproject.com/en/2.0/ref/models/fields/#blank) : If `True` the field is allowed to be blank in your forms. The default is `False` which means Django's form validation will forece you to enter a value. This is often used with `null=True`, because if you are going to allow blank values you also want the database to be able to represent them appropriately.
- [choices](https://docs.djangoproject.com/en/2.0/ref/models/fields/#choices) : a group of choices for this field. If this is provided the default corresponding form widget will be a select box with these choices instead of the standart text field.
- [primary_key](https://docs.djangoproject.com/en/2.0/ref/models/fields/#primary-key) : If `True`, sets the current field as the primary key for the model (a primary key is a special database column designated to uniqely identfiy all the different table records). If no field is specified as the primary key then Django will automatically add a field for this purpose.

there are more options view them all [here](https://docs.djangoproject.com/en/2.0/ref/models/fields/#field-options)

**Common Field Types**
- [CharField](https://docs.djangoproject.com/en/2.0/ref/models/fields/#django.db.models.CharField) : Is used to define short to mid sized strings. You must specify the `max_length`of the data to be stored.
- [TextField](https://docs.djangoproject.com/en/2.0/ref/models/fields/#django.db.models.TextField) : Text field is used for large abritary-length strings. You may specify a max_length for the field but it is only used in when the field is displayed in forms.
- [IntegerField](https://docs.djangoproject.com/en/2.0/ref/models/fields/#django.db.models.IntegerField) : Is a field for storing integer(whole numbers) values, and for validating entered values as integers in forms
- [DateField](https://docs.djangoproject.com/en/2.0/ref/models/fields/#datefield) and [DateTimeField](https://docs.djangoproject.com/en/2.0/ref/models/fields/#datetimefield) : are used for storing date and times information.
- [EmailField](https://docs.djangoproject.com/en/2.0/ref/models/fields/#emailfield) : is used to store and validate emails.
- [FileField](https://docs.djangoproject.com/en/2.0/ref/models/fields/#filefield) and [ImageField](https://docs.djangoproject.com/en/2.0/ref/models/fields/#imagefield) : are used to upload files and images respectievly(the `ImageField` simply add additional validation that the uploaded file is an image). These have their own parameters check the docs.
- [AutoField](https://docs.djangoproject.com/en/2.0/ref/models/fields/#autofield) : Is a special type of `IntegerFiel` that automatically increments. A primary key of this type is added autamtiaclly if you do not specify one.
- [ForeignKey](https://docs.djangoproject.com/en/2.0/ref/models/fields/#foreignkey) : is used to specify one-to-many relationship to another database model (e.g. a car has one manufacturer, but a manufacturer can make many cars). The "one" side of the relationship is the model that contains the key.
- [ManyToManyField](https://docs.djangoproject.com/en/2.0/ref/models/fields/#manytomanyfield) : is used to specify a many-to-many relationship (e.g. a book can have several genres, and each genre can contain several books) 

There are many other types of fields, including fields for different types of numbers (big integers, small integers, floats), booleans, URLs, slugs, unique ids, and other "time-related" information (duration, time, etc.). You can view the [full list here](https://docs.djangoproject.com/en/2.0/ref/models/fields/#field-types)

### Metadata

You can declare model-level metadata for your Model by declaring `class Meta`, as shown:
```python
class Meta:
	ordering = ['-example_field_name']
	...
```

Definetely return to this later, it is late at night and im not abosrbing any of this info from the tutorial.

### Methods

A model can also have methods.

Minimally in every model you should define the standart python class `__str__()` to return a human readable string for the object. It is like the `toString` function in java. Often this will return a title or a name associated with that model.

example:
```python
def __str__(self):
	return self.example_field_named_title
```

Another common method to include in Django models is `get_absolute_url()` which returns a url for displaying the individual model records on the website(If you define this method than Django will automatically 'View on site' button to the models record editing screen in the Admin site. 

exapmle:
```python
def get_absolute_url(self):
	#returns the url to accsess a particual instance of a model
	return reverse('model-detail-view', args=[str(self.id)])
```

In addition you can add any methods you like to your model to use them in your templates or code. (Provided they dont take any arguments)

You will use queries to manage your databases but we can learn this later on in views section but for information about queries [click here](https://docs.djangoproject.com/en/2.0/topics/db/queries/) to see the docs

After you are finished editing your models run:
```
$ python manage.py makemigrations
$ python manage.py migrate
```

---
---
---

## Admin Site

The django admin application can use your models to automatically build a site area that you can use to create, read, update or delete records. This can save you a lot of time during development, making it very easy to test your models. All configuration that is needed to create an admin site was done when you created the skelton project by django.

As a result of this all you have to do is **register your models** to the admin site and create a super user to manage them. And you can configure the admin panel if you want to be more advanced.

### Registering Models

Firstly open your `admin.py` in your targeted app_directory. Than after importing your models simply register them with `admin.site.register(model_name)` :

app_directory/admin.py :
```python
from django.contrib import admin
from .models import *

admin.site.register(Model_1)
admin.site.register(Model_2)
```

This is the simplest way of registering your models to the admin panel but dont worry the panel itself is highly customazible.

### Creating a Superuser

In order to create a user where it keeps full control over everything and usuaylly controlled by the *staff* you need to create a superuser. The process is very simple after running this command :
```
$ python manage.py createsuperuser
```
You select an username and a password. After that you are good to go! do not forget to re run your server.

### Advanced configuration

Django does a pretty good job for creating a basic administiration site for CRUD applications. However, the admin panel is **highly** customizible you can add additional fields, how the forms are layed out, allow inline displayment and **many more things...** since it is too long I am not going to list all of them here. 

However if you want to check [visit official docs for admin panel](https://docs.djangoproject.com/en/2.0/ref/contrib/admin/)
or check out [MDN django admin docs](https://developer.mozilla.org/en-US/docs/Learn/Server-side/Django/Admin_site) which has great hands on experience

---
---
---

## URL mapping & Views & Templates

Now that we have defined our skeleton, models and an admin panel we need to show our data to the users. In order to present the information to users we have to select which appropirate data in your models you want to show. After selcting your data you need to define URLs for returning those selections. After creating the basis we need to fancy it with url mapper, views and templates

Views are at the heart of every django website because it is the first UI that our users interfere with. Yet, in order to show our views we need to guide users in our URL maps to get the desired views.

### **URL mapping**

When we created the `skeleton website` we updated the entry_folder's `urls.py` file to include our apps urls. Remember : 
```python
from django.contrib import admin
from django.urls import path, include

urlpatterns = [
  #including all of the paths of the targeted app
  path('', include('app-name.urls')),
]
```
and we also created a path inside our `targeted_apps/urls.py` to connect it to our views. Remember:
```python
from django.urls import path, include
from . import views

urlpatterns = [
  #example
  path('', views.index, name='index'),
]
```

Lets talk about these maps for a second before moving to views. This `path()` function defines a URL pattern such as `'/example/page/1'` which in this case is just `''` for making this page the index, and a view function is defined if there is a url pattern `views.index` is our view pattern. This connects our paths url map to the function named index() in our apps/views.py file.

This `path()` function also specifies a `name`parameter which uniqeley identifies this particular URL mapping. You can use the `name` to do lots of different things but mostly it is used for our templates such as you can add links pointing that URL mapping

example_app/example_template.html : 
```html
<a href="{% url 'index' %}">HOME</a>
```

### **Views**

A view is a function processes a HTTP request, fetches data from the database as needed, generates an html page by rendering this data using an HTML template and returns the HTML in an HTTP response to be shown to the user. 

Open `targeted_app/views.py` file and note that the file already imports the `render()` shortcut function which generates html files using templates and data.

targeted_app/views.py currently looks like this:
```python
from django.shortcuts import render 

# create your views here
```

Now lets create our first index view. For the sake of the example lets assume that we have written two models `User` and `Post`. We will talk about the code after.

targeted_app/views.py :
```python
from django.shortcuts import render 
from .models import User, Post

# View function for home page of the site
def index(request):
	
	# Generate(GET) some variables(DATA) for 
	# context(from the database) to use in templates
	all_users = User.objects.all()
	all_posts = Post.objects.all()
	num_of_users = User.objects.all().count()
	num_of_posts = Post.objects.all().count()
	
	# Render the HTML template index.html with the data in the context variable
	return render(request, 'index.html', context={'all_users':all_users, 'all_posts':all_posts, \
	'num_of_users':num_of_users, 'num_of_posts':num_of_posts})
```

As you can see above the code is pretty self explainatory. If you want to `GET` `data` from the database you need accsess the objects properties through various ways. The relation ship of the databse above is one of the most basic relationships on django. You can spice things up such as `posts = Post.objects.order_by('-created_date')[:6]` which gets the firts six post which are ordered from the latest if you add `created_time` field in your Post model. You can make the context data as complicated as you want. For more adnvanced info check the offical Docs.

At the end of the function we call `render()` to create and return an HTML page as a response (thank god this shortcut function wraps a lot of other functions and simplifies this very common-use case). This takes parameters, the original `request` object(HttpRequest), an HTML template with placeholders for data and a `context`variable (a python dictionary that holds the data that will be inserted to those placeholders).

### **Templates**

A template is a text file defining the structure or layout of a file (such as HTML page)with placeholders used to represent actual content. Django will automatically look for templates in a folder named **'templates'**  in your targeted_application and will raise a error if the file cannot be found. 

#### Extending Templates

Most of your templates will need standart boiler plate code in your templates. In order to not repeat your self and write hundreds of lines of code we can simply estanbish a `base_template` which contains all the boiler plate static code such as the navigation, meta-data in head, font, bootstrap CDNs and all of that crap. 

To give an example lets create a base_template.html file that will be our extending template

templates/base_template.html
```html
<!DOCTYPE html>
<html lang="en">
<head>
  {% block title %}<title>Local Library</title>{% endblock %}
</head>

<body>
  {% block content %}<!-- default content text (typically empty) -->{% endblock %}
</body>
</html>
```
After coding our base template if we want to define a template for a particular view, we first specify the base template (with `{% extends 'base_template.html' %}` template tag ). If we want to change any particular content we simply add them between `{% block %}`/`{% endblok%}`.

For example the code snippet below shows how to use the `extends` tag and override the `content` block

templates/index.html:
```html
{% extends 'base_template.html' %}

{% block content %}
<h1>Home</h1>
<p>I overwrote the content and index file has this content instead of emptiness</p>
{% endblock %}
```

#### Adding css and javascript

If you would like to add css or javascript to your templates it is always better to write them on a seperate file. Like we created 'templates' in your root folder, we have to create another folder named `static` in your root folder for all of your css and js files. After defining them you can include them in your templates with `load static` tag.

templates/template_example.html :
```html
...
<head>
	<!-- add additional css from the file named static  -->
	{% load static %}
	<link rel='stylesheet' href='{% static 'style.css' %}' />
	
	<!-- for images if you desire -->
	<img src="{% static 'assets/face.jpg' alt='face image' %}" />
</head>	
...

```

For more info about serving static files visit [official docs](https://docs.djangoproject.com/en/2.0/howto/static-files/)

#### Using placeholders

Remember that we added context variables in when we were defining our views ? This line `context={'all_users':all_users, 'all_posts':all_posts, 'num_of_users':num_of_users, 'num_of_posts':num_of_posts}`. Since we defined context variables we can use them in the targeted template which is the `return render(request, 'index.html', context=...)` index.html in this case.

In order to use our variables in our templates we can simply use `{{ var_name }}` tags

templates/index.html :
```html
{% extends 'base_template.html %}

{% block content %}
<body>
	<h1>All of the notes</h1>
	<p>{{ all_posts }}</p>
	
</body>
{% endblock %}
...
```

*Note: You can easily understand if you are dealing with template variables or tags. Variables do not have (`{{ var }}`) the percentage sign before and after the curly brackts and have double curly brackets. While tags (`{% extends 'example.html %}`) have single curly brackets and one percentage sign on both sides.

#### Linking URLs in templates 

If you defined a `name='index'` in in your `path()` s in your apps urls.py you can easily link stuff with their name.

```html
<a href='{% url 'index' %}'>HOME</a>
```

#### Advanced views
Definetly check the [MDN docs since I am not going to take any notes regarding class based views](https://developer.mozilla.org/en-US/docs/Learn/Server-side/Django/Generic_views)

...

---
---
---

## Detail Pages

Most of the time we will need to generate specific views for users input without touching our code. Such as, creating profile pages after registering to the site, single page posts, blog writinhg ..etc . And usually the url pattern is somthing like this `application_name/user/<id>/` where `<id>` is the primary key to the model which in this case `user`.

### URL mapping for detail pages

applicatio_name/urls.py
```python
urlpatterns = [
	path('users/', views.userlist, name='userlist'),
	path('users/<int:pk>', views.user_detail, name='user_detail')
]
```
For the user-detail path the URL pattern uses a special syntax to capture the specific id of the user we want to see. The syntax is very simple angle brackets `< >` defines the part of the URl to be captured. Enclosing the name of the variable that the view can use to accsess the captured data. For example `<int:pk>`, will caputre the part of the url pattern and pass the value to the view as a variable named `pk` (short for primary key)in this case.

Now lets write our user-detail view:

application_name/views.py:
```python
def user_detail(request, pk):
	user_id = User.objects.get(pk=pk)
	
	# if you want to raise a 404 error if user doesnt exist write,
	# book_id=get_object_or_404(Book, pk=pk)
	 
	return render(request, 'user_detail.html', context={'user':user_id,})
```

### Advanced path mapping

I wont go into detail but using regular expressions in mapping is a very powerful tool make sure to check our official docs and [MDN docs](https://developer.mozilla.org/en-US/docs/Learn/Server-side/Django/Generic_views)

```python
#example advnaced regex mapping
urlpatterns = [
	re_path(r'^book/(?P<pk>\d+)$', views.user_detail, name='user_detail')
]
```

There are more to learn on creating detail pages. Definetly check out official docs

---
---
---

## Sessions

Until now in our website the content is dynamically created from the database and served same to all of its users. However, usually sites does not do this. In a real site it is common to create a individual user with a customized experience based on their perivious visit, likes etc. 

The session framework implemented in django allows you to collect arbitary data based on per-site visitor basis.

### What are sessions ?

All communucation of the web browser and the servier is via HTTP protocol, which is *stateless*. The fact that the protocol is *stateless* means that the messages between the client and the server are completely independent of each other-- there is no notion of 'sequence' or behavior based on perivious messages. As a result if you want to have a site that keeps track of the ongoing relationships with a client, you need to implement it yourself.

Sessions are the mechanism used by django (and most of the internet) for keeping track of the *state* between the server(Site) and the particular browser(user). Sessions allow you to store arbitary data per browser and have this data aviable to the server whenever the browser connects. Individual data items associated with the session are then referenced by a "key", which is both used to store and retrieve data.

Django uses a cookie containing special *session id* to identify each particular browser and its accosiated session with the site. The actual session data is stored in the site database by defualt (this is more secure than storing the data in a cookie where they are more valunarable to mallicious users). You can configure django to store sessions into other places like cache files, secure cookies but the defualt location is good and relatively in a secure position.

### Enabling sessions

Sessions were automatically enabled when we created the skeleton site.

The configuration is set up in `INSTALLED_APPS` and `MIDDLEWARE` sections of the entry_folder/settings.py as shown below.

entry_folder/settings.py :
```python
INSTALLED_APPS = [
	...
	'django.contrib.sessions',
	...
]

MIDDLEWARE = [
	...
	'django.contrbi.sessions.middleware.SessionMiddleware',
	...
]
```

### Using sessions

I will not go into detail about how to use sessions in django at the moment but you should definetly check out django docs and [MDN has a killer docs on sessions](https://developer.mozilla.org/en-US/docs/Learn/Server-side/Django/Sessions)

---
---
---

## User authentication & permissions

The django authentication system handles both authentication and authorazition. Berifely, authentication verifies a user is who they claim to be, and authorazition determines what an authenticated user is allowed to do. 

The auth system consists of:
- Users
- Permissions: Binary(yes/no) flags designated weather a user may perform a certian task. 
- Groups: A generic way of appliying labels and permissions to more than one user.
- A configurable password hashing system.
- Forms and view tools for logging in users,or restricting content.
- A pluggable backend system.

The auth system in django is very generic. Even though django is a very batteries included framework the auth system is very generic and needs 3rd party apps for common solutions. such as:

- Password strength checking
- Throttling of login attempts
- Authentication against third parties(OAuth, for example)

### Installation

You do not need to do anything the auth system is already installed like sessions in `INSTALLED_APPS` and `MIDDLEWARE` under:
INSTALLED_APPS :
- `django.contrib.auth` -- contains the core of the authentication framework and its default models.
- `django.contrib.contenttypes` -- is the django content type system which allows permissions to be accosiated with models you create

MIDDLEWARE :
- `SessionMiddleware` -- manages sessions across requests
- `AuthenticationMiddleware` -- accosiates users with requests using sessions.

### Using auth system

Django provides almost everything you need to create authentication pages to handle login, logout and password maangement 'out of the box'. This includes url mapper, views and forms but it does not include the templates -- we have to create our own.

#### URL mapping for auth system

Add the following to the bottom of your entry-folder/urls.py

entry-folder/urls.py:
```python
urlpatterns = [
	...
	#Add Django site authentication urls (for login, logout, password management)
	path('accounts/', include('django.contrib.auth.urls')),
]
```

Navigate to http://127.0.0.1:8000/accounts/ URl and django will throw you an error saying that it could not find any urls. This is becuase when you `include('django.contrib.auth.urls')` it doesnt get included in one single url instead it maps out itself to many other maps, I know it is confusing, just look at the example of their mapping system below. :

```
accounts/ login/ [name='login']
accounts/ logout/ [name='logout']
accounts/ password_change/ [name='password_change']
accounts/ password_change/done/ [name='password_change_done']
accounts/ password_reset/ [name='password_reset']
accounts/ password_reset/done/ [name='password_reset_done']
accounts/ reset/<uidb64>/<token>/ [name='password_reset_confirm']
accounts/ reset/done/ [name='password_reset_complete']
```

*Note: You dont have to map anything else -- the 'django.contrib.auth.urls' maps nearly everything a site needs as you can see above. Try http://127.0.0.1:8000/accounts/login this time and it will work since we passed 'login/' to the url it is included above.

#### Templates for user auth

Django authentication system expects templates associated with its views to be found in a folder named **registration/** in your templates folder. So the folder stcutrue will be like this :

```
|_directory-name/
	|_entry-folder/
	|_app-name/
	|_templates/
		|_example_template.html
		|_registration/
			|_login.html
```

To make these directories visible to the template loader (i.e. to put this directory in template search path) open the project settings and update the `TEMPLATE` sections `'DIRS'` line as shown.

```python
TEMPLATES = [ 
	{
		...
		'DIRS': ['./templates',],
		'APP_DIRS' : True,
		...
```

#### Login Template

create the following file in ./templates/registration/login.html:

```html
{% extends 'base_template.html' %}

{% block content %}

<form method='post' action="{% url 'login' %}">
{% csrf_token %}
	<div>
	  <td>{{ form.username.label_tag }}</td>
	  <td>{{ form.username }}</td>
	</div>
	<div>
	  <td>{{ form.password.label_tag }}</td>
	  <td>{{ form.password }}</td>
	</div>
	
	<div>
  		<input type="submit" value="login" />
  		<input type="hidden" name="next" value="{{ next }}" />
	</div>
</form>

{% endblock %}

```

The code is fairly simple form handling code for your username and password. The `{% csrf_token %}` is added to prevent XSS attacks.

If your login succseeds you will be redirected to another page (by default this will be https://127.0.0.1:8000/accounts/profile). The problem here is that by default django expects that after login you will want to be taken to a profile page which may not be the case always. and as you havent defined profile page you will get an error. 

We can fix this very easily. Open your entry_folders settings.py and add the text below at the bottom of your file.
```python
# redirects to home page after login (defuajlt redirects to .../accounts/profile/ )
LOGIN_REDIRECT_URL = '/'
```

#### Logout template


If you navigate to logout url (https://127.0.0.1:8000/accounts/logout) then you will see some odd behavior -- your user will be logged out sure but you will be taken to the Admin logout page. Thats not what you want because the login link on that admin screen takes you to the admin panel login page(and that is only avilable to the users who are `staff_only`).

To change this we have to include a {% url 'logout' %} somewhere in our profile page after we get redirected when we login. And of course we need to redirect the users when they logout.

First add the logout url, 

templates/profile.html
```html
{% extends 'base_template.html' %}
{% block content %}
	
	<!-- navbar and all that profile crap ... -->
	...
	<a href="{% url 'logout.html' %}">Logout</a>

{% endblock %}
```

After clicking logout button  we have to redirect the user to the log out page which is generally same as the login page since logging in is the gate to the web site.

enry-folder/settings.py :
```python
LOGIN_REDIRECT_URL = '/'
LOGOUT_REDIRECT_URL = '/'
```

### Testing against authenticated users

This section looks at what we can do to selectively control content the user sees based on weather they are logged in or not. 

#### Testing in templates

You can get information about the currently logged in user in templates with the `{{ user }}` template variable. 

Typically you will first test against the `{{ user.is_authenticated }}` template variable to determine weather the user is eligible to see specific content. 

To demonstrate this lets assumme that we have a public navbar but it will display few more elements if the user is logged in:
```html
...

{% if user.is_authenticated %}
	<li>User: {{user.get_username}}</li>
	<li><a href="{% url 'logout' %}">Log out</a></li>
{% else %}
	<li><a href="{% url 'login' %}">Log in</a></li>
{% endif %}

...
```

#### Testing in views

If you are using function based views the easiest way to restrict accsess to your function is to apply the `login_required` decorator(`@`) to your function, as shown below. If the user is logged in then your view code will exucute as normal. If the user is not logged in this will redirect to the login url defined in the project settings(`settings.LOGIN_URL`).

application-name/views.py:
```python
from django.contrib.auth.decorators import login_required

@login_required
def my_view(request):
	...
```
*Note: you can do the same shit manually by testing on `request.user.is_authenticated` but the decorator is much more elegant and convenient.*

For [additional detail check out docs](https://docs.djangoproject.com/en/2.0/topics/auth/default/#limiting-access-to-logged-in-users)

#### Conneting auth User model to our models

To connect the auth systems User model to any of our models defined in the model.py file we need to use ForeignKeys.

application-name/model.py:
```python
from django.contrib.auth.models import User

class example_fiel(models.Model):
	example-field = models.ForeignKey(User, on_delete=models.SET_NULL, null=True, blank=True)
```

after this ofcourse dont forget to migrate!

### Permissions

Check this out else where MDN docs are bad at explaining permissions ...

---
---
---

## Using Forms

An html form is a group of fields/widgets on a web page which can be used to get information (data) from the user. Forms are one of the heart beat at every wev application and as you would expect they are one of the most complex concepts in the web. You first need to write the HTML form, validate and properly santise the the entered data, repost the form messages to inform users in case of invalid fields, handle data and when it is succsessful, indicate and show that there is a succsess.

As you would expect it even tires me out to list all of these. Yet, this is where django comes in and provides us a framework to do most of the heavylifting all we have to do is play along its protocols and customize it to our needs.

### HTML forms

First lets give a brief overview of html forms. Form elements in html pages contains at least one input element which type is 'submit'.

an example:
```html
<form action='/team_name_url/' method='POST'>
	<label for='team_name'>Enter name:</label>
	<input id='team_name' type='text' name='name_field' value="default name for team">
	<input type='submit' value="OK">
</form>
```

the `submit` typed input will  be displayed as a button an when it is pressed it uploads the data elements to the server. The `method` defines the HTTP method that is going to be used on the data, either `get` , `post` or etc. 

Forms use a lot of time while validating their cells. After the user presses the submit button if the form contains any invalid data server should display the form again this time with the valid fields filled with the users perivious fillment and manage to describe the problem for the invalid field and notify the user.

As you can imagine all of this creates a unwanted repeated code. Django, as always makes it easy and removes the unnecessary repeated code.

### Django form handling procsess

The techniques is quite the same, the view gets a request, performs any action required including reading data from th models then generates and returns a html page. What makes this process in form handling complex is that server needs to be able to proccsess data provided by the user and redisplay the page if there are any errors.

<img src="/web-development/level-1/django/assets/form-handling.png" height="500px" alt="django-request-structure">

Based on the diagram above the main things django form handling does are:
	
1. Display the default form the first time it is requested by the user
	* The form may contain blank fields (eg. if you are creating a new record) or it may be prepopulated with intial values (eg. if you are changing a record or have useful initial values)
	* The form is referred to as unbound at this point because it isnt associated with any user-entered data(though it may have intial values)
2. Recieve data from a submit request and bind it to the form
	- Binding data to the form means that the user the user-entered data and any errors are available when we need to redisplay the form
3. Clean and validate the data
	- Cleaning the data performs santisation of the input (eg. removing invalid characters that might be used for mallicious attacks. )
	- Calidation checks that the values are appropirate for the field (eg. are in the right date range, arent too short or too long)
4. If any data is invalid redisplay the form, this time with user populated values and error messages for the invalid fields.
5. If data is valid perform required actions (save the data, send and email, return the result of a search, pload a file etc.)
6. Once all actions are complete redirect the user to another page.

Django provides us a lot of tools to approach form handling as easy as possible. The fundemental is the `Form` class, which simplifies both generation of form HTML and data cleanig/validation.

### Using form handling

The `Form` class is the heart of djangos form handling system. It specifies the fields in the form, their layout, display widgets, labels, intiial values, valid values, and error messages associated with invalid fields. The class also provides methods for rendering itself in templates using predefined formats(tables, lists)

#### Declaring a Form

The declaration syntax of a `form` is very similar to a `model` and shares the same field types and some similar parameters. This makes sense because in each case we need to ensure that each field handles the right type of data, is contrained to valid data and has description or documentation.

To create a form we import `forms` library. A very basic pattern is shown below:
```python
from django import forms

class Settings_Form(forms.Form):
	name = forms.CharField(help_text="Enter your name to appear on your profile")
	lastname = forms.CharField(help_text="Enter your lastname to appear on you profile")
```

#### Form fields

The code above will only render a form with two blank cells with no labels or placeholders. In order to eliminate that and make a lovely form that is appealing to the eye we need to add fields with parameters. The following are the field types of forms in django : 

[BooleanField](https://docs.djangoproject.com/en/2.0/ref/forms/fields/#booleanfield), [CharField](https://docs.djangoproject.com/en/2.0/ref/forms/fields/#charfield), [ChoiceField](https://docs.djangoproject.com/en/2.0/ref/forms/fields/#choicefield), [TypedChoiceField](https://docs.djangoproject.com/en/2.0/ref/forms/fields/#typedchoicefield), [DateField](https://docs.djangoproject.com/en/2.0/ref/forms/fields/#datefield), [DateTimeField](https://docs.djangoproject.com/en/2.0/ref/forms/fields/#datetimefield), [DecimalField](https://docs.djangoproject.com/en/2.0/ref/forms/fields/#decimalfield), [DurationField](https://docs.djangoproject.com/en/2.0/ref/forms/fields/#durationfield), [EmailField](https://docs.djangoproject.com/en/2.0/ref/forms/fields/#emailfield), [FileField](https://docs.djangoproject.com/en/2.0/ref/forms/fields/#filefield), [FilePathField](https://docs.djangoproject.com/en/2.0/ref/forms/fields/#filepathfield), [FloatField](https://docs.djangoproject.com/en/2.0/ref/forms/fields/#floatfield), [ImageField](https://docs.djangoproject.com/en/2.0/ref/forms/fields/#imagefield), [IntegerField](https://docs.djangoproject.com/en/2.0/ref/forms/fields/#integerfield), [GenericIPAddress](https://docs.djangoproject.com/en/2.0/ref/forms/fields/#genericipaddressfield), [MultipleChoiceField](https://docs.djangoproject.com/en/2.0/ref/forms/fields/#multiplechoicefield), [TypedMultipleChoiceField](https://docs.djangoproject.com/en/2.0/ref/forms/fields/#typedmultiplechoicefield), [NullBooleanField](https://docs.djangoproject.com/en/2.0/ref/forms/fields/#nullbooleanfield), [RegexField](https://docs.djangoproject.com/en/2.0/ref/forms/fields/#regexfield), [SlugField](https://docs.djangoproject.com/en/2.0/ref/forms/fields/#slugfield), [TimeField](https://docs.djangoproject.com/en/2.0/ref/forms/fields/#timefield),[URLField](https://docs.djangoproject.com/en/2.0/ref/forms/fields/#urlfield), [UUIDField](https://docs.djangoproject.com/en/2.0/ref/forms/fields/#uuidfield), [ComboField](https://docs.djangoproject.com/en/2.0/ref/forms/fields/#combofield), [MultiValueField](https://docs.djangoproject.com/en/2.0/ref/forms/fields/#multivaluefield), [SplitDateTimeField](https://docs.djangoproject.com/en/2.0/ref/forms/fields/#splitdatetimefield), [ModelMultipleChoiceField](https://docs.djangoproject.com/en/2.0/ref/forms/fields/#modelmultiplechoicefield), [ModelChoiceField](https://docs.djangoproject.com/en/2.0/ref/forms/fields/#modelchoicefield)

The paramters that are common to most of the fields are listed below:

- [required](https://docs.djangoproject.com/en/2.0/ref/forms/fields/#required):

---
---
---

## Sign up mechanism
The django auth provides us a url mapping and views for login, logout, password reset mechanisms all we needed was to add templates. But to create a signup page we will need to make our own view and url. 

You need to crate a path to the url,

application-name/urls.py:
```python
urlpatterns = [
	...
	path('signup/', views.signup, name='signup')
]
```

After that we need to create the actual view

application-name/views.py:
```python
...

from django.contrib.auth.forms import UserCreationForm


def signup(request):

```

...


---
---
---
---
---

## Mega signup login example

I will code a mega signup login logout with custom users to demonstrate what we have learnt.
	
		  





