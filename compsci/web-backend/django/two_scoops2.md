- [Part 1](./two_scoops.md)

---

<br>

# Queries and the Database Layer

- The Django ORM, like any ORM, converts data from different types into objects that we can use
pretty consistently across supported databases. Then it provides a set of methods for interacting with
those objects. For the most part, Django’s does a pretty good job at what it’s designed to do. However,
it does have quirks, and understanding those quirks is part of learning how to use Django

### Use get_object_or_404() for Single Objects 

- In views such as detail pages where you want to retrieve a single object and do something with it, use
`get_object_or_404()` instead of `get()`

 Only use it in views. Don’t use it in helper functions, forms, model methods or anything that is not a view
or directly view related. Dont use it anywhere else than __views__
 
### Be Careful With Queries That Might Throw Exceptions

- When you’re getting a single Django model instance with the get_object_or_404() shortcut,
you don’t need to wrap it in a try-except block. That’s because get_object_or_404() already does
that for you

 But for most of the part you will need to use try..except... blocks. So use `ObjectDoesNotExist` package from `from django.core.exceptions import ObjectDoesNotExist`
 
- If it’s possible that your query may return more than one object, check for a MultipleObjectsReturned exception.
  ```python
  try:
   ...
  except ObjectDoesNotExist:
   ...
  except MultipleObjectsReturned:
   ...
  ```

### Use Lazy Evaluation to Make Queries Legible 

- By lazy evaluation, we mean that the Django ORM doesn’t make the SQL calls until the data is
actually needed. We can chain ORM methods and functions as much as we want, and until we try
to loop through the result, Django doesn’t touch the database. Instead of being forced to chain many
methods and advanced database features on a single line, we can break them up over as many lines
as needed. This increases readability, which improves the ease of maintenance
  ```python
  # instead of one big query like this
  return Promo.objects.active().filter(Q(name__startswith=name)|Q(description__icontains=name)
  
  # we can break it up:
  results = Promo.objects.active()
  results = results.filter(
              Q(name__startswith=name) |
              Q(description__icontains=name) 
  return results
  ```
  
- This technique borrows from the Pandas and JavaScript communities. Instead of using lazy evaluation, it’s possible to chain queries thus:
  ```python
  qs = (Promo
         .objects
         .active()
         .filter(
         Q(name__startswith=name) |
         Q(description__icontains=name)
         )
         .exclude(status='melted')
         .select_related('flavors')
         )
  return qs
  ```
  The downside to this approach is that debugging isn’t as easy as using the lazy evaluation method of
writing a query.

### Lean on Advanced Query Tools

- Django’s ORM is easy to learn, intuitive, and covers many use cases. Yet there are a number of things
it does not do well. What happens then is after the queryset is returned we begin processing more
and more data in Python

 Instead of managing data with Python, we always try to use Django’s advanced query tools to do the
lifting. In doing so we not only benefit from increased performance

 Use functions such as `filter()` -- `customers = Customer.objects.filter(scoops_ordered__gt=F('store_visits'))` Do not try to edit the returned queryset with your won python code.

### Don’t Drop Down to Raw SQL Until It’s Necessary

- Whenever we write raw SQL we lose elements of security and reusability. This does’t just apply to
internal project code, but also to the rest of the Django world. Specifically, if you ever release one
of your Django apps as a third-party package, using raw SQL will decrease the portability of the
work.

### Transactions

- The default behavior of the ORM is to autocommit every query when it is called. In the case of
data modification, this means that every time a .create() or .update() is called, it immediately
modifies data in the SQL database. The advantage of this is that it makes it easier for beginning
developers to understand the ORM. The disadvantage is that if a view (or some other operation)
requires two or more database modifications to occur, if one modification succeeds and the other
fails, the database is at risk of corruption

 The way to resolve the risk of database corruption is through the use of database transactions. A
database transaction is where two or more database updates are contained in a single unit of work. If
a single update fails, all the updates in the transaction are rolled back. To make this work, a database
transaction, by definition, must be atomic, consistent, isolated and durable. Database practitioners
often refer to these properties of database transactions using the acronym ACID.

- When it comes to transactions, here are some good guidelines to live by:
 - Database operations that do not modify the database should not be wrapped in transactions.
 - Database operations that modify the database should be wrapped in a transaction.
 - Special cases including database modifications that require database reads and performance
considerations can affect the previous two guidelines

<br>
<br>
<br>

# Function- And Class-Based Views

- Both function-based views (FBVs) and class-based views (CBVs) are in Django We recommend that you understand how to use both types of views.

### When to Use FBVs or CBVs

- Whenever you implement a view, think about whether it would make more sense to implement as a
FBV or as a CBV. Some views are best implemented as CBVs, and others are best implemented as
FBVs.

 General rule of thumb is that if your view is processing more than one form or even processing some logic it is best to implement it as a function based view. Class based virews get used by same looking webpages.
 
 > Some developers prefer to err on the side of using FBVs for most views and CBVs only for
views that need to be subclassed. That strategy is fine as well. (this is what i (reader) do

### Keep View Logic Out of URLConfs

- Requests are routed to views via URLConfs, in a module that is normally named urls.py. Per Django’s URL design philosophy  the coupling of views with urls is loose, allows for
infinite flexibility, and encourages best practices.

- But even though you can define url logic in anywehere you should only do it in urls.py for unix philiosophy. The views should not have any url logic.

### Use URL Namespaces

- What URL namespaces do is provide an identifier for app-level and instance level namespaces. URL
namespaces are one of those things where on the surface they seem like they might not help much,
but once a developer begins using them they wonder why they didn’t use them already. We’ll sum up
using URL namespaces as follows:
 ```python
 url(r'^tastings/', include('tastings.urls', namespace='tastings')),
 ```

### Try to Keep Business Logic Out of Views

- In the past, we’ve placed an amazing amount of sophisticated business logic into our views. Unfortunately, when it became time to generate PDFs, add a REST API, or serve out other formats, placing
so much logic in our views made it much harder to deliver new formats.

 This is where our preferred approach of model methods, manager methods, or general utility helper
functions come into play. When business logic is placed into easily reusable components, and called
from within views, it makes extending components of the project to do more things much easier.

### Django Views Are Functions

- When it comes down to it, every Django view is a function. This function takes an HTTP request
object and turns it into a HTTP response object. This concept of change serves as a foundation for all sorts of things you can do with Django views,
be they function- or class-based.

### Don’t Use locals() as Views Context

- dont pass `locals()` which is a function that passes an object to the context paramter of the `render` functionality of the function based views. Always use a dictionary because it is a dictionary ( a hash table that has the O(1) value. so it is very hard to beat it. Plus, locals() is a pain in the ass to maintain.

<br>
<Br>
<Br>
  
# Best Practices for Function-Based Views

###  Advantages of FBVs

- The simplicity of FBVs comes at the expense of code reuse: FBVs don’t have the same ability to
inherit from superclasses the way that CBVs do. T

  We follow these guidelines when writing FBVs:
  - Less view code is better.
  - Never repeat code in views
  - Views should handle presentation logic. Try to keep business logic in models when possible,
or in forms if you must.
  - Keep your views simple
  - Use them to write custom 403, 404, and 500 error handlers
  - Complex nested-if blocks are to be avoided.

### Keeping the Views Simple

- Try to keep a utility.py module next to your views.py and you can import whatever function, class ... etc. you would like from that but the main views in your views.py should look simple DRY and small and easy to read.

### Decorators Are Sweet

###  Passing the HttpResponse Object

<Br>
<Br>
<Br>
  
# Best Practices for Class-Based Views

### Guidelines When Working With CBVs

### Using Mixins With CBVs

### Which Django GCBV Should Be Used for What Task?

### General Tips for Django CBVs

### How GCBVs and Forms Fit Together

### Using Just django.views.generic.View

### Additional Resources

<Br>
<Br>
<Br>
  
# Common Patterns for Forms

### Pattern 1: Simple ModelForm With Default Validators

### Pattern 2: Custom Form Field Validators in ModelForms

### Pattern 3: Overriding the Clean Stage of Validation

### Pattern 4: Hacking Form Fields (2 CBVs, 2 Forms, 1 Model)

### Pattern 5: Reusable Search Mixin View

<Br>
<Br>
<Br>
  
# Form Fundamentals

### Validate All Incoming Data With Django Forms

### Use the POST Method in HTML Forms

### Always Use CSRF Protection With HTTP Forms That Modify Data

### Understand How to Add Django Form Instance Attributes

### Know How Form Validation Works

### Add Errors to Forms With Form.add_error()

### Fields Without Pre-Made Widgets

### Customizing Widgets

### Additional Resources


<Br>
<Br>
<Br>
  
# Templates: Best Practices

### Keep Templates Mostly in templates/ 

### Template Architecture Patterns

### Limit Processing in Templates

### Don’t Bother Making Your Generated HTML Pretty

### Exploring Template Inheritance

### block.super Gives the Power of Control

### Useful Things to Consider

###  Error Page Templates

### Follow a Minimalist Approach


<Br>
<Br>
<Br>
  
# Template Tags and Filters

### Filters Are Functions

### Custom Template Tags

### Naming Your Template Tag Libraries

### Loading Your Template Tag Modules

<Br>
<Br>
<Br>
  
# Django Templates and Jinja2

### What’s the Syntactical Difference?

### Should I Switch?

### Considerations When Using Jinja2 With Django

### Resources

<Br>
<Br>
<Br>
  
# Building REST APIs With Django REST Framework

### Fundamentals of Basic REST API Design

### Illustrating Design Concepts With a Simple API

### REST API Architecture

### When DRF Gets in the Way

### Shutting Down an External API

### Rate-Limiting Your API

### Advertising Your REST API

### Additional Reading

<Br>
<Br>
<Br>
  
# Consuming REST APIs

### Learn How to Debug the Client

### Consider Using JavaScript-Powered Static Asset Preprocessors

### Real-Time Woes a.k.a. Latency

### Avoid the Anti-Patterns

### AJAX and the CSRF Token

### Improving JavaScript Skills

### Follow JavaScript Coding Standards

<Br>
<Br> 
<Br>
  
# Tradeoffs of Replacing Core Components

### The Temptation to Build FrankenDjango

###  Non-Relational Databases vs. Relational Databases

### What About Replacing the Django Template Language?

<Br>
<Br>
<Br>
  
# Working With the Django Admin

### It’s Not for End Users

### Admin Customization vs. New Views

### Viewing String Representations of Objects

### Adding Callables to ModelAdmin Classes

### Be Aware of the Complications of Multiuser Environments

### Django’s Admin Documentation Generator

### Using Custom Skins With the Django Admin

### Secure the Django Admin

### Securing the Admin Docs

<Br>
<Br>
<Br>
  
# Dealing With the User Model

### Use Django’s Tools for Finding the User Model

### Custom User Fields for Django 1.11 Projects

<Br>
<Br>
<Br>
  
# Django’s Secret Sauce: Third-Party Packages 

### Examples of Third-Party Packages

### Know About the Python Package Index

### Know About DjangoPackages.org

### Know Your Resources

### Tools for Installing and Managing Packages

### Package Requirements

### Wiring Up Django Packages: The Basics

### Troubleshooting Third-Party Packages

### Releasing Your Own Django Packages

### What Makes a Good Django Package?

###  Creating Your Own Packages the Easy Way

### Maintaining Your Open Source Package

### Additional Reading

<Br>
<Br>
<Br>
  
# Testing Stinks and Is a Waste of Money!

### Testing Saves Money, Jobs, and Lives

### How to Structure Tests

### How to Write Unit Tests

### What About Integration Tests?

### Continuous Integration 

### Who Cares? We Don’t Have Time for Tests!

### The Game of Test Coverage

### Setting Up the Test Coverage Game

### Playing the Game of Test Coverage

### Alternatives to unittest

<Br>
<Br>
<Br>
  
# Documentation: Be Obsessed 

### Use reStructuredText for Python Docs

### Use Sphinx to Generate Documentation From reStructuredText

### What Docs Should Django Projects Contain?

### Additional Documentation Resources

### The Markdown Alternative

### Wikis and Other Documentation Methods

<br>
<br>
<br>

# Finding and Reducing Bottlenecks 

### Should You Even Care?

### Speed Up Query-Heavy Pages

### Get the Most Out of Your Database 

### Cache Queries With Memcached or Redis

### Identify Specific Places to Cache

### Consider Third-Party Caching Packages

### Compression and Minification of HTML, CSS, and JavaScript

### Use Upstream Caching or a Content Delivery Network

### Other Resources

<br>
<br>
<Br>
  
# Asynchronous Task Queues

### Do We Need a Task Queue?

### Choosing Task Queue Software

### Best Practices for Task Queues

### Resources for Task Queues

<br>
<br>
<Br>
  
# Security Best Practices

### Reference Security Sections in Other Chapters

### Harden Your Servers

### Know Django’s Security Features

### Turn Off DEBUG Mode in Production

### Keep Your Secret Keys Secret

### HTTPS Everywhere

### Use Allowed Hosts Validation

###  Always Use CSRF Protection With HTTP Forms That Modify Data

### Prevent Against Cross-Site Scripting (XSS) Attacks

### Defend Against Python Code Injection Attacks

### Validate All Incoming Data With Django Forms

### Disable the Autocomplete on Payment Fields

### Handle User-Uploaded Files Carefully

### Don’t Use ModelForms.Meta.exclude

### Don’t Use ModelForms.Meta.fields = ”__all__”

### Beware of SQL Injection Attacks

### Never Store Credit Card Data

### Monitor Your Sites

### Keep Your Dependencies Up-to-Date

### Prevent Clickjacking

### Guard Against XML Bombing With defusedxml

### Explore Two-Factor Authentication

### Embrace SecurityMiddleware

### Force the Use of Strong Passwords

### Give Your Site a Security Checkup

### Put Up a Vulnerability Reporting Page

### Never Display Sequential Primary Keys

### Reference Our Security Settings Appendix

### Review the List of Security Packages

### Keep Up-to-Date on General Security Practices

<br>
<br>
<Br>
  
# Logging: What’s It For, Anyway?

### Application Logs vs. Other Logs

### Why Bother With Logging?

### When to Use Each Log Level

### Log Tracebacks When Catching Exceptions

### One Logger Per Module That Uses Logging 

### Log Locally to Rotating Files

### Other Logging Tips

### Necessary Reading Material

### Useful Third-Party Tools

<br>
<br>
<Br>
  
# Signals: Use Cases and Avoidance Techniques

### When to Use and Avoid Signals

### Signal Avoidance Techniques

<br>
<br>
<Br>
  
# What About Those Random Utilities? 

### Create a Core App for Your Utilities

### Optimize Apps With Utility Modules

### Django’s Own Swiss Army Knife

### Exceptions

### Serializers and Deserializers

<br>
<br>
<Br>
   
# Deployment: Platforms as a Service

### Evaluating a PaaS

### Best Practices for Deploying to PaaS

<br>
<br>
<Br>
  
# Deploying Django Projects

### Single-Server for Small Projects

### Multi-Server for Medium to Large Projects 

### WSGI Application Servers

### Performance and Tuning: uWSGI and Gunicorn

### Stability and Ease of Setup: Gunicorn and Apache

### Common Apache Gotchas

### Automated, Repeatable Deployments

### Which Automation Tool Should Be Used?

### Current Infrastructure Automation Tools

### Other Resources

<br>
<br>
<Br>
  
# Continuous Integration

### Principles of Continuous Integration

### Tools for Continuously Integrating Your Project

### Continuous Integration as a Service

### Additional Resources

<br>
<br>
<Br>
  
# The Art of Debugging

### Debugging in Development

### Debugging Production Systems

###  Feature Flags

<br>
<br>
<Br>
  
# Where and How to Ask Django Questions

### What to Do When You’re Stuck

### How to Ask Great Django Questions in IRC

### Feed Your Brain

### Insider Tip: Be Active in the Community

