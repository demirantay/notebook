# Django’s Secret Sauce: Third-Party Packages 

- The real power of Django is more than just the framework and documentation available at
djangoproject.com. It’s the vast, growing selection of third-party Django and Python packages
provided by the open source community. There are many, many third-party packages available for
your Django projects which can do an incredible amount of work for you

  Much of professional Django and Python development is about the incorporation of third-party
packages into Django projects. If you try to write every single tool that you need from scratch, you’ll
have a hard time getting things done.

### Know About DjangoPackages.org

- Django Packages (djangopackages.org) is a directory of reusable apps, sites, tools and more for
your Django projects. Unlike PyPI, it doesn’t store the packages themselves, instead providing a mix
of hard metrics gathered from the Python Package Index, GitHub, ReadTheDocs, and “soft” data
entered by users.

### Releasing Your Own Django Packages

- Whenever you write a particularly useful Django app, consider packaging it up for reuse in other
projects.

  The best way to get started is to follow Django’s Advanced Tutorial: How to Write Reusable Apps, for
the basics: docs.djangoproject.com/en/1.11/intro/reusable-apps/

- In addition to what is described in that tutorial, we recommend that you also:
  - Create a public repo containing the code. Most Django packages are hosted on GitHub these
days, so it’s easiest to attract contributors there, but various alternatives exist (Gitlab, Bitbucket,
Assembla, etc.).
  - Release the package on the Python Package Index (pypi.python.org). Follow the submission instructions at packaging.python.org/distributing/
#uploading-your-project-to-pypi.
  - Add the package to Django Packages (djangopackages.org).
  - Use Read the Docs (readthedocs.io) to host your Sphinx documentation.

### What Makes a Good Django Package?

- Here’s a checklist for you to use when creating a new open source Django package. Much of this
applies to Python packages that are not Django-specific. This checklist is also helpful for when you’re
evaluating a Django package to use in any of your projects.
  - `Purpose` -- Your package should do something useful and do it well. The package
repo’s root folder should be prefixed with ‘django-’ or ‘dj-’ to help make it easier to find

  - `Scope` -- Your package’s scope should be tightly focused on one small task. Never try to do everything. That is against the Unix Philiosphy (do one thing really well)
  
  - `Documentation` -- A package without documentation is a pre-alpha package. Docstrings don’t suffice as documentation If your package has dependencies, they should be documented. Your package’s installation instructions should also be documented. The installation steps should be bulletproof.
  
  - `Tests` -- Your package should have tests. Tests improve reliability, make it easier to advance Python/Django
versions, and make it easier for others to contribute effectively.
  
  - `Templates` -- However, nowadays it’s pretty standard for Django packages to come with a set
of barebones templates that demonstrate basic functionality. Typically these templates contain only
minimalist HTML, any needed JavaScript, and no CSS
  
  - `Activity` -- Your package should receive regular updates from you or contributors if/when needed. Make it known to your users that there is an update/maintainance ... etc.
  
  - `Community` -- Be an active community leader if you have contributors or forks of your package. If your package is
forked by other developers, pay attention to their work. Merge it update the authors on AUTHORS.txt .. etc.
  
  - `Modularity` -- Your package should be as easily pluggable into any Django project that doesn’t replace core components (templates, ORM, etc) with alternatives. Installation should be minimally invasive
  
  - `Availability on PyPI` -- All major and minor releases of your package should be available for download from the Python
Package Index. Use proper semantic versioning.
  
  - `Uses the Broadest Requirements Specifiers Possible` -- Your third-party package should specify what other libraries your package requires in the broadest
terms possible:
    ```
    # requirements for django-blarg
    Django>=1.10,<1.12
    requests>=2.6.0,<=2.13.0
    ```
  
  - `Proper Version Numbers` -- a. In
fact we follow the ‘A.B.C’ pattern. Let’s go through each element:
    - A’ represents the major version number. Increments should only happen with large changes that
break backwards compatibility from the previous major version.
    - ‘B’ is the minor version number. Increments include less breaking changes, or deprecation notices
about forthcoming changes.
    - C’ represents bug fix releases, and purists call this the ‘micro’ release. It’s not uncommon for developers to wait until a project has its first release at this level before trying the latest major or
minor release of an existing project.

    For alpha, beta, or release-candidates for a project, the convention is to place this information as a
suffix to the upcoming version number. So you might have:
    - Django 1.11-alpha
    - django-crispy-forms 1.6.1-beta
  
  - `Name` -- The name of the project is absolutely critical. A well-named project makes it easy to discover and
remember, a poor name hides it from potential users, can scare off its use from some developer shops,
and even block it from being listed on PyPI, Django Packages, and other resources. (dont put 'gorlx;a_tw29_a')
  
  - `License` -- Your package needs a license. Preferably, for individuals it should be licensed under the MIT licenses,
which are generally accepted for being permissive enough for most commercial or noncommercial
uses
  > In this era of casual litigation and patent trolls adding a software license isn’t just a matter of
protecting your ownership of the code. It’s much, much more. If you don’t license your code, or use an unapproved license not vetted by real lawyers, you run the risk of your work being
used as a weapon by a patent troll, or in the case of financial or medical disaster, you could
be held liable.
  
  - `Clarity of Code` -- The code in your Django package should be as clear and simple as possible, of course. Don’t use weird,
unusual Python/Django hacks without explaining what you are doing.

### Maintaining Your Open Source Package

- While uplodaing to Pypi instead of basic settings.py use `twine` why? Twine is the preferred library for uploading packages to PyPI. The problem with python setup.py is that it sends files over a non-SSH connection, exposing your library to a manin-the-middle attack. In contrast, twine uses only verified TLS to upload your package.

  That’s not all! Twine works better at uploading Wheels (see the next subsection), doesn’t
require executing the setup.py, and even pre-signs your releases. If you are seriously security
minded, it’s the tool of choice 

<Br>
<Br>
<Br>
  
# Testing Stinks and Is a Waste of Money!

- `Useful Library for Testing Django Projects` -- We like to use __coverage.py__. This tool provides clear insight into what parts of your code base are covered by tests, and
what lines haven’t been touched by tests. You also get a handy percentage of how much of your
code is covered by tests. Even 100% test coverage doesn’t guarantee a bug-free application,
but it helps. 

  We want to thank Ned Batchelder for his incredible work in maintaining coverage.py. It’s a
superb project and is useful for any Python related project

### How to Structure Tests

- Let’s say we’ve just created a new Django app. The first thing we do is delete the default but useless
tests.py module that python manage.py startapp creates. In it’s place we create a directory called
tests and place an empty `__init__.py` within. Then we create respective modular test cases for the apps with this structures:
  ```
  Django-Project/
  - manage.py
  - tests/
    - __init__.py
    - app_name1/
      - __init__.py
      - test_views.py
      - test_models.py
      - test_templates.py
      - test_forms.py
    - app_name2/
      - ...
  ```

### How to Write Unit Tests

- Follow these good unit testing practices: A test method must be extremely narrow in what it tests. A single unit test should never assert the
behavior of multiple views, models, forms, or even multiple methods within a class. Instead, a single
test should assert the behavior of a single view, model, form, method or function. And The trick is to be absolutely minimalistic when constructing the environment (the env in `setUp()`) for a particular test

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

  
