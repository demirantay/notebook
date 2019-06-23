# Two Scoops of Django

- These are my notes from the book: Two Scoops of Django written by Daniel and Audrey Roy Greenfeld

<br>
<br>

# Introduction

- Unlike the Django documentation, this book recommends particular coding styles, patterns, and
library choices. While core Django developers may agree with some or many of these choices, keep
in mind that many of our recommendations are just that: personal recommendations formed after
years of working with Django.

- When deciding where to put a piece of code, we like to follow the “Fat Models, Utility Modules,
Thin Views, Stupid Templates” approach.

- We recommend that you err on the side of putting more logic into anything but views and templates.
The results are pleasing. e code becomes clearer, more self-documenting, less duplicated, and a lot
more reusable. As for template tags and lters, they should contain the least amount of logic possible
to function.

- A comprehensive approach to web-based application design, the Twelve-Factor App approach is
growing in popularity amongst many senior and core Django developers. It is a methodology for
building deployable, scalable applications worth reading and understanding. See this later: https://12factor.net/

<br>
<br>
<br>

# Coding Style

- Code is read more than it is written. An individual block of code takes moments to write, minutes
or hours to debug, and can last forever without being touched again. It’s when you or someone else
visits code written yesterday or ten years ago that having code written in a clear, consistent style
becomes extremely useful. What this means is that you should go the extra mile to make your code as readable as possible:
  - Avoid short-cutted variable names.
  - Write out your function argument names.
  - Document your classes and methods.
  - Comment your code.
  - Refactor repeated lines of code into reusable functions or methods.
  - Keep functions and methods short. A good rule of thumb is that scrolling should not be nec-
  - essary to read an entire function or method.
  - Use the 79-Character limit
  
- PEP 8 suggest that imports should be grouped in the following order:
  - 1 - Standart library imports
  - 2 - Imports from core Django.
  - 3 - Related third-party imports
  - 4 - Local application or library specific imports
  
  Do not hesitate to put comments on your imports liek this (remember readabiltiy is more important than beauty or personal preference:
  ```python
  #stdlib improts
  from math import sqrt
  from os.path import abspath
  
  # Core Django imports
  from django.db import models
  from django.utils.translation import foo
  
  # Thirds-party app imports
  from django_extension..db.models import foo
  
  # Imports from your apps
  from app.models import ModelName
  ```

- Remember! that in 99% of all of our work we explicitly import each module, and try to avoid using the `import *`. You may think that this is easy and fast way to develop and get the functions froma  module however these often result in cathastrophic bugs when a huge module like `django.db.models` imprted with `*` (all). But of course there can be few expections but always avoid it if you can.

<br>
<br>
<br>

# The Optimal Django Environment Setup

- Use the same database for everywhere. A common developer pitfall is using SQLite3 for local development and PostgreSQL (or MySQL) in production.  is section applies not only to the SQLite3/PostgreSQL scenario, but to any scenario where you’re using two di erent databases and expecting them to behave identically.
  
  Keep in mind that di erent databases handle typing of  eld data di erently. Django’s ORM attempts to accommodate those di erences, but there’s only so much that it can do. Most problems usually can’t be discovered until the project is run on a strongly typed database (e.g. PostgreSQL or MySQL). When these types of bugs hit, you end up kicking yourself and scrambling to set up your local development machine with the right database.
  
- TIP: Django+PostgreSQL Rocks. Most Django developers that we know prefer to use PostgreSQL for all environments: de- velopment, staging, QA, and production systems.

- WARNING: Don’t Use SQLite3 with Django in Production. For any web project with more than one user, or requiring anything but light concurrency, SQLite3 is a nightmare in the making. In the simplest terms possible, SQLite3 works great in production until it doesn’t. We’ve experienced it ourselves, and heard horror stories from others.

-  The official Django documentation describes several ways of installing Django. Our recommended installation method is with pip and requirements  les.

- What works on a programmer’s laptop might not work in production. But what if your local devel- opment environment was identical to your project’s staging, test, and production environments?
  
  Of course, if the production infrastructure consists of 10,000 servers, it’s completely unrealistic to have another 10,000 local servers for development purposes. So when we say identical, we mean “as identical as realistically possible.”
  
  In order to achieve that we use `containers` (e.g. docker .etc.) however at this time of writing i do not know how to write docker, so I will need to revisit this part in the future. But, the potential downsides of `containers` are:
   - Extra complexity that is not needed in many situations. For simpler projects where we’re not too worried about OS-level differences, it’s easier to skip this.
   
<br>
<br>
<br>

# How to Layout Django Projects 




# 21
  
  








