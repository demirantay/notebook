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
 
 
 
 
 
 
 
 
 
 
 
 
 
 
