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

- Project layout is one of those areas where core Django developers have differing opinions about
what they consider best practice. In this chapter, we present our approach, which is one of the most
commonly-used ones

- There are a number of problems with Django’s default project layout. While useful for the tutorial,
it’s not quite as useful once you are trying to put together a real project. The rest of this chapter will
explain why.

- We rely on a modified two-tier approach that builds on what is generated by the
`django-admin.py startproject` management command. Our layouts at the highest level are:
  ```
  <repository_root>/
  |--- <configuration_root>/
  |--- <django_project_root>/
  ```
  Let’s go over each level in detail:

### Top Level: repositroy_root

- The `<repository_root>` directory is the absolute root directory of the project. In addition to the
`<django_project_root>` and `<configuration_root>`, we also include other critical components like the
`README` , `docs/` directory, `manage.py`, `.gitignore`, `requirements.txt` files, and other high-level files
that are required for deployment and running the project

  **TIP**: Some developers like to combine the <django_project_root> into the <repository_root> of the
project

### Second Level: django_project_root

- The `<django_project_root>/` directory is the root of the actual Django project. Non-configuration
Python code files are inside this directory, its subdirectories, or below.

  If using `django-admin.py startproject`, you would run the command from within the repos-
itory root. The Django project that it generates would then be the project root

### Second Level: configuration_root

- The `<configuration_root>` directory is where the settings module and base URLConf (urls.py) are
placed. This must be a valid Python package (containing an __init__.py module)

  If using `django-admin.py startproject`, the configuration root is initially inside of the Django
project root. It should be moved to the repository root.

---

- The final layout of this reccomendation is this:
	```
	project-name/
	├── config/
	│ ├── settings/
	│ ├── __init__.py
	│ ├── urls.py
	│
	└── wsgi.py
	├── docs/
	├── icecreamratings/
	│ ├── media/ # Development only!
	│ ├── app1/
	│ ├── app2/
	│ ├── app3/
	│ ├── static/
	│ └── templates/
	├── .gitignore
	├── Makefile
	├── README.rst
	├── manage.py
	└── requirements.txt
	```

<br>
<br>
<br>

# Fundementals of Django App Design

- First lets go over some of the terminology again:
	- `Django apps` - are small libraries designed to represent a single aspect of a project. A Django project
is made up of many Django apps. Some of those apps are internal to the project and will never
be reused; others are third-party Django packages.
	- `INSTALLED_APPS` - is the list of Django apps used by a given project available in its IN-
STALLED_APPS setting.
	- `Third-party Django packages` - are simply pluggable, reusable Django apps that have been packaged
with the Python packaging tools


### The Golden Rule of Django App Design

- James Bennett is a Django core developer. He taught us everything that we know about good Django
app design. We quote him:

	> "The art of creating and maintaining a good Django app is that it should follow the
	truncated Unix philosophy according to Douglas McIlroy: ‘Write programs that do one
	thing and do it well."

- In essence, each app should be tightly focused on its task. If an app can’t be explained in a single
sentence of moderate length, or you need to say ‘and’ more than once, it probably means the app is
too big and should be broken up.

### Common and Uncommon App Modules

- Here are the common app modules that you use daily:
	```
	# Common modules
	appname/
	├── __init__.py
	├── admin.py
	├── forms.py
	├── management/
	├── migrations/
	├── models.py
	├── templatetags/
	├── tests/
	├── urls.py
	├── views.py
	```

- However there are very uncommon module names that you may never have heard. Lets see them an explain a summary for each one of them:
	```
	# uncommon modules
	appname/
	├── api/
	├── behaviors.py
	├── constants.py
	├── context_processors.py
	├── decorators.py
	├── db/
	├── exceptions.py
	├── fields.py
	├── factories.py
	├── helpers.py
	├── managers.py
	├── middleware.py
	├── signals.py
	├── utils.py
	├── viewmixins.py
	```
	- `api/` - This is the package we create for isolating the various modules needed when creating an api
	- `behaviors.py` - An option for locating model mixins
	- `constants.py` - A good name for placement of app-level settings. If there are enough of them involved in an app, breaking them out into their own module can add clarity to a project
	- `decorators.py` - Where we like to locate our decorators.
	- `db/` - A package used in many projects for any custom model fields or components
	- `fields.py` - is commonly used for form fields, but is sometimes used for model fields when there isn’t
enough field code to justify creating a db/ package.
	- `factories.oy` - Where we like to place our test data factories.
	- `helpers.py` - What we call helper functions
	- `managers.py` - When models.py grows too large, a common remedy is to move any custom model
managers to this module
	- `signals.py` - Whiel we argue against providing custom signals this can be a useful place to put them
	- `utils.py` - Synoymous with helpers.py
	- `viewmixins.py` - View modules nad packages can be thinned by moving any view mixins to this module

- We will visit each of them in other chapters so, do not stress about it. This is just an overview

<br>
<br>
<br>

# Settings and Requirements Files

- Settings are loaded when your server starts up, and experienced Django developers stay away from trying to change settings in production since they require a server restart. As your project grows, your Django settings can get pretty complex.

- Some best practices the books suggests:
	- **All settings files need to be version-controlled**  is is especially true in production environ- ments, where dates, times, and explanations for settings changes absolutely must be tracked.
	- **Dont Repeat Yourself** You should inherit from a base settings  le rather than cutting-and- pasting from one  le to another.
	- **Keep secret keys safe**  They should be kept out of version control.

- As developers, we have our own necessary settings for development, such as settings for debug tools which should be disabled (and often not installed to) staging or production servers.

	Furthermore, there are often good reasons to keep speci c settings out of public or private code repositories.  e SECRET_KEY setting is the  rst thing that comes to mind, but API key settings to services like Amazon, Stripe, and other password-type variables need to be protected.

- **Warning**: The SECRET_KEY setting is used in Django’s cryptographic signing functionality, and needs to be set to a unique, unpredictable setting best kept out of version control. Running Django with a known SECRET_KEY defeats many of Django’s security protections, which can lead to serious security vulnerabilities.

- A common solution is to create local_settings.py modules that are created locally per server or develop- ment machine, and are purposefully kept out of version control. But, solving the problem with a single local_settings file isnt going to cut it because in the future this solution can cause you literally days of fixing a bug. A better solution is to reak up development, staging, test, and production settings into separate components that inherit from a common base object in a settings  le tracked by version control. Plus, we’ll make sure we do it in such a way that server secrets will remain secret.

### Using Multiple Settings Files

- Instead of having one settings.py  le, with this setup you have a settings/ directory containing your settings  les.  is directory will typically contain something like the following:
	```
	settings/
   ├── __init__.py
   ├── base.py
   ├── local.py
   ├── staging.py
   ├── test.py
   ├── production.py
	```
	- `base.py` - Settings common to all instances of the project.
	- `local.py` -  is is the settings  le that you use when you’re working on the project locally. Local development-speci c settings include DEBUG mode, log level, and activation of developer tools like django-debug-toolbar.
	- `staging.py` - Staging version for running a semi-private version of the site on a production server.  is is where managers and clients should be looking before your work is moved to production.
	- `test.py` - Settings for running tests including test runners, in-memory database de nitions, and log settings.
	- `production.py` -  This is the settings file used by your live production servers. That is the server that host the real website. This file contains production level settings only it is sometimes called prod.py

- **Tip:** You’ll also want to have a ci.py module containing that server’s settings. Similarly, if it’s a large project and you have other special-purpose servers, you might have custom settings files for each of them.

- To run the local development server with your settings/local.py settings file:
	```
	python manage.py runserver --settings=config.settings.local
	```
	Just change the module name for which settings file you would like to use

- As mentioned earlier, we need settings configured for development, such as selecting the console
	email backend, setting the project to run in DEBUG mode, and setting other configuration options
	that are used solely for development purposes. We place development settings like the following into
	`settings/local.py`:
	```
	from .base import *

	DEBUG = True

	EMAIL_BACKEND = 'django.core.mail.backends.console.EmailBackend'

	DATABASES = {
		'default': {
			'ENGINE': 'django.db.backends.postgresql_psycopg2',
			'NAME': 'twoscoops',
			'HOST': 'localhost',
		}
	}

	INSTALLED_APPS += ['debug_toolbar', ]
	```

- Sometimes we’re working on a large project where different developers need different settings, and
	sharing the same local.py settings module with teammates won’t do.

	Well, it’s still better tracking these settings in version control than relying on everyone customizing
	the same `local.py` module to their own tastes. A nice way to do this is with multiple dev settings files,
	e.g. `local_audrey.py` and `local_pydanny.py`:

- Now lets talk about our secret keys inside our settings files. The most basic idea that comes to mind to protect our secrets is to leave them out of the version control system. But that is a dangerous game you play since there is a very big chance of single point faliure and losing all your important settings. To resolve this, our answer is to use environment variables in a pattern we like to call, well, `The Environment Variables Pattern`.

	Here are the benefits of using environment variables for secret keys:
		- Keeping secrets out of settings allows you to store every settings file in version control without hesitation. All of your Python code really should be stored in version control, including your settings
		- Instead of each developer maintaining an easily-outdated, copy-and-pasted version of the local_settings.py.example file for their own development purposes, everyone shares the same version-controlled settings/local.py
		- ➤ Most platforms-as-a-service recommend the use of environment variables for configuration and have built-in features for setting and managing them.

### Environment Variables

- Before you begin setting environment variables, you should have the following:
	- A way to manage the secret information you are going to store
	- A good understanding of how bash works with environment variables on servers, or a willingness to have your project hosted by a platform-as-a-service.

- **Warning**: Enviornment variables do not work with apache

---

- *I am skipping this part of the books since I am not really good with bash scripting at this point ...*

	I will return to this chapter of the book

<br>
<br>
<br>
<br>

# Model Best Practices

- Models are the foundation of most Django projects. Racing to write Django models without thinking things through can lead to problems down the road.

	All too frequently we developers rush into adding or modifying models without considering the
	ramifications of what we are doing. The quick fix or sloppy “temporary” design decision that we toss
	into our code base now can hurt us in the months or years to come, forcing crazy workarounds or
	corrupting existing data

	So keep this in mind when adding new models in Django or modifying existing ones. Take your time to think things through, and design your foundation to be as strong and sound as possible.

### Basics

- If there are 20+ models in a single app, think about ways to break it down into smaller apps, as it
	probably means your app is doing too much. In practice, we like to lower this number to no more
	than five models per app.

- I skipped the part where it explains about model inheritance

### Database Migrations

- Django comes with a powerful database change propagation library aptly called “migrations”,
or as we prefer to refer in the book, django.db.migrations.

- Tips for Creating Migrations
	- As soon as a new app or model is created, take that extra minute to create the initial
django.db.migrations for that new model. All we do is type `python manage.py
makemigrations`.
	- Examine the generated migration code before you run it, especially when complex changes are
involved. Also review the SQL that will be used with the `sqlmigrate` command.
	- Use the MIGRATION_MODULES setting to manage writing migrations for third-party apps that
don’t have their own django.db.migrations-style migrations.
	- Don’t worry about how many migrations are created. If the number of migrations becomes
unwieldy, use `squashmigrations` to bring them to heel.
	- Always back up your data before running a migration.

### Deployment and Management of Migrations

- It goes without saying, but we’ll say it anyway: Always back up your data before running a
migration.

- Before deployment, check that you can rollback migrations!We can’t always have perfect roundtrips, but not being able to roll back to an earlier state really hurts bug tracking and sometimes
deployment in larger projects.

- If a project has tables with millions of rows in them, do extensive tests against data of that size
on staging servers before running a migration on a production server. Migrations on real data
can take much, much, much more time than anticipated.If not careful, schema changes on heavily populated tables can take a long time. Not seconds or minutes, but hours.

- **Tip:** Including migration code in VCS is an absolute necessity. Not including migration code in
version control is just like not including settings files in VCS: You might be able to develop,
but should you switch machines or bring someone else into the project, then everything will
break.

## Django Model Design

- One of the most difficult topics that receives the least amount of attention is how to design good Django models. How do you design for performance without optimizing prematurely? Let’s explore some strategies
here.

- **Start Normalized**:
	- We suggest that readers of this book need to be familiar with `database normalization.` If you are
unfamiliar with database normalization, make it your responsibility to gain an understanding, as
working with models in Django effectively requires a working knowledge of this

		When you’re designing your Django models, always start off normalized. Take the time to make sure
that no model should contain data already stored in another model.

- **Cache Before Denormalizing**:
	-  Often, setting up caching in the right places can save you the trouble of denormalizing your models

- **Denormalize Only if Absolutely Needed**:
	- It can be tempting, especially for those new to the concepts of data normalization, to denormalize prematurely. Don’t do it! Denormalization may seem like a panacea for what causes problems in a project. However it’s a tricky process that risks adding complexity to your project and dramatically raises the risk of losing data. Please, please, please explore caching before denormalization.

### Try to Avoid Using Generic Relations

- In general we advocate against generic relations and use of models.field.GenericForeignKey.
They are usually more trouble than they are worth. Using them is often a sign that troublesome
shortcuts are being taken, that the wrong solution is being explored.

### Fat Models

... skipped it for now -- return to it later on


- **Tip:**
