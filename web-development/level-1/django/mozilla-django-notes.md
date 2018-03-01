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

1) If you dont have the main project folder structre start with : (if you have it skip to the next step )
```
$ django-admin startproject `project-name` .
```
2) Use `manage.py` to create the desired app. (* Of course do not create apps for every bit of feature that you have, catogrize them such as, eg. main site, blog, wiki, download are, messageing ..etc.
```
$ python manage.py startapp `app-name`
```
3) Register the new applications to include them in the project (via settings).
4) Hook up the url/path mapper for each application.

---

## Using Models
