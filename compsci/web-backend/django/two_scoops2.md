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

- Decorators are very useful in django projects and lets see an example usage of it:
  ```python
  # sprinkles/decorators.py
  from functools import wraps
  from . import utils
  
  # based off the decorator template from the previous chapter
  def check_sprinkles(view_func):
      """Check if a user can add sprinkles"""
      @wraps(view_func)
      def new_view_func(request, *args, **kwargs):
          # Act on the request object with utils.can_sprinkle()
          request = utils.can_sprinkle(request)
          # Call the view function
          response = view_func(request, *args, **kwargs)
          # Return the HttpResponse object
          return response
      return new_view_func
  ```
  Than we can use our own decorators on the views.py such as this:
  ```python
  # sprinkles/views.py
  from django.shortcuts import get_object_or_404, render
  from .decorators import check_sprinkles
  from .models import Sprinkle
  
  # Attach the decorator to the view
  @check_sprinkles
  def sprinkle_detail(request, pk):
      """Standard detail view"""
      sprinkle = get_object_or_404(Sprinkle, pk=pk)
      return render(request, "sprinkles/sprinkle_detail.html", {"sprinkle": sprinkle})
  ```
  
- `Be Conservative with Decorators` -- As with any powerful tool, decorators can be used the wrong way. Too many decorators can
create their own form of obfuscation, making even complex class-based view hierarchies seem
simple in comparison. When using decorators, establish a limit of how many decorators can
be set on a view and stick with it.

<Br>
<Br>
<Br>
 
# Best Practices for Class-Based Views

- Django provides a standard way to write class-based views (CBVs). In fact, as we mentioned in
previous chapters, a Django view is just a callable that accepts a request object and returns a response

### Guidelines When Working With CBVs

- Less view code is better
- Never repeat code in views.
- Views should handle presentation logic. Try to keep business logic in models when possible,
or in forms if you must
- Keep your views simple
- Keep your mixins simpler

### Using Mixins With CBVs

- In programming, a mixin is a class that provides functionality to be inherited, but isn’t meant for
instantiation on its own. In programming languages with multiple inheritance, mixins can be used
to add enhanced functionality and behavior to classes. We can use the power of mixins to compose our own view classes for our Django apps.

 When using mixins to compose our own view classes, we recommend these rules of inheritance
provided by Kenneth Love
 - 1 - The base view classes provided by Django always go to the right.
 - 2 - Mixins go to the left of the base view.
 - 3 - Mixins should inherit from Python’s built-in object type. Keep your inheritance chain simple!
 
 Example of the rules in action:
 ```python
 from django.views.generic import TemplateView

 class FreshFruitMixin:
    def get_context_data(self, **kwargs):
       context = super(FreshFruitMixin, self).get_context_data(**kwargs)
       context["has_fresh_fruit"] = True
       return context
       
 class FruityFlavorView(FreshFruitMixin, TemplateView):
    template_name = "fruity_flavor.html"
 ```

### General Tips for Django CBVs

- > Note from Djangos Creation Jacob Kaplan: The School of “Avoid them unless you’re actually subclassing views”
Jacob Kaplan-Moss says, “My general advice is to start with function views since they’re
easier to read and understand, and only use CBVs where you need them. Where do you
need them? Any place where you need a fair chunk of code to be reused among multiple
views.”

> I skipped most part of this section because I prefer to use Function Based Views

<Br>
<Br>
<Br>
  
# Common Patterns for Forms

> I skipped most part of this chapter since I haven't quite figured out how to use django's form. and this chapter mostly talks about forms best practices rather than how to use them.

- Django forms are powerful, flexible, extensible, and robust. For this reason, the Django admin and
CBVs use them extensively. In fact, all the major Django API frameworks use ModelForms or a
similar implementation as part of their validation.

  This chapter goes explicitly into one of the best parts of Django: forms, models, and CBVs working
in concert. This chapter covers five common form patterns that should be in every Django developer’s
toolbox.

### Pattern 1: Simple ModelForm With Default Validators

- If you recall, using ModelForms with CBVs to implement add/edit forms can be done in just a few
lines of code:
  ```python
  from django.contrib.auth.mixins import LoginRequiredMixin
  from django.views.generic import CreateView, UpdateView
  
  from .models import Flavor
  
  class FlavorCreateView(LoginRequiredMixin, CreateView):
      model = Flavor
      fields = ['title', 'slug', 'scoops_remaining']
  
  class FlavorUpdateView(LoginRequiredMixin, UpdateView):
      model = Flavor
      fields = ['title', 'slug', 'scoops_remaining']
  ```
  Yes, Django gives us a lot of great defaults for data validation, but in practice, the defaults are never
enough So it is not used very much

<Br>
<Br>
<Br>
  
# Form Fundamentals

- Django’s forms are really powerful, and knowing how to use them anytime data is coming from
outside your application is part of keeping your data clean. The most important thing to remember about Django forms is they should be used to validate all
incoming data.

- `Validate All Incoming Data With Django Forms` -- What’s really nice about this practice is that rather than cooking up our own validation system for incoming data, we’re using the well-proven data testing framework built into Django

### Use the POST Method in HTML Forms

- Every HTML form that alters data must submit its data via the POST method (not any other http method like GET, PUT):
  ```html
  <form action="{% url 'flavor_add' %}" method="POST">
  ```
  The only exception you’ll ever see to using POST in forms is with search forms, which typically
submit queries that don’t result in any alteration of data. Search forms that are idempotent should
use the GET method.

### Always Use CSRF Protection With HTTP Forms That Modify Data

- Django comes with cross-site request forgery protection (CSRF) built in, and usage of it is introduced
in Part 4 of the Django introductory tutorial. It’s easy to use, and Django even throws a friendly warning during development when you forget to use it. This is a critical security issue

  If you are writing an API from scratch that accepts data changes, it’s a good idea to become familiar
with Django’s CSRF documentation

- You should use Django’s CSRF protection even when posting data via AJAX. Do not make your
AJAX views CSRF-exempt.

### Know How Form Validation Works

- Form validation is one of those areas of Django where knowing the inner workings will drastically
improve your code. Let’s take a moment to dig into form validation and cover some of the key points

  When you call `form.is_valid()`, a lot of things happen behind the scenes. The following things
occur according to this workflow:
  - 1 - If the form has bound data, form.is_valid() calls the form.full_clean() method.
  - 2 - form.full_clean() iterates through the form fields and each field validates itself:
  - 3 - form.full_clean() executes the form.clean() method.
  - 4 - If it’s a ModelForm instance, form._post_clean().

### Fields Without Pre-Made Widgets

- Two of the new django.contrib.postgres fields, ArrayField and HStoreField, don’t work
well with existing Django HTML fields. They don’t come with corresponding widgets at all. Nevertheless, you should still be using forms with these fields.

### Customizing Widgets

- One of our favorite features about Django 1.11 is trivial it is to override the HTML of Django
widgets or even create custom widgets. This is a monumental change, a far cry from the days when
most of us would do everything in our power to avoid these kinds of customizations. Here’s our
general advice:
  - As always, keep it simple! Stay focused on presentation, nothing more
  - No widgets should ever change data. They are meant purely for display.
  - Follow the Django pattern and put all custom widgets into modules called widgets.py



<Br>
<Br>
<Br>
  
  


