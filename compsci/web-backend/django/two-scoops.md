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



# PAGE 8 







