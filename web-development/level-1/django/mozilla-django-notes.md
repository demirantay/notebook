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

...











