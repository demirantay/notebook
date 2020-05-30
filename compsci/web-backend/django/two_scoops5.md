# Logging: What’s It For, Anyway?

- Anyone who’s ever worked on a large production project with intense demands understands the importance of using the different log levels appropriately, creating module-specific loggers, meticulously
logging information about important events, and including extra detail about the application’s state
when those events are logged.

  While logging might not seem glamorous, remember that it is one of the secrets to building extremely
stable, robust web applications that scale and handle unusual loads gracefully. Logging can be used
not only to debug application errors, but also to track interesting performance metrics. Logging unusual activity and checking logs regularly is also important for ensuring the security of
your server

### Application Logs vs. Other Logs

- This chapter focuses on application logs. Any log file containing data logged from your Python web
application is considered an application log.

  In addition to your application logs, you should be aware that there are other types of logs, and that
using and checking all of your server logs is necessary. Your server logs, database logs, network logs,
etc. all provide vital insight into your production system, so consider them all equally important.

### When to Use Each Log Level

- In your production environment, we recommend using every log level except for DEBUG.

- Use the CRITICAL log level only when something catastrophic occurs that requires urgent attention For example, if your code relies on an internal web service being available, and if that web service is
part of your site’s core functionality, then you might log at the CRITICAL level anytime that the web
service is inaccessible.

- Similarly, we recommend that you use the ERROR log level whenever you need to log an error that is
worthy of being emailed to you or your site admins. When your code catches the exception, log as
much information as you can to be able to resolve the problem.

- Log Lower-Priority Problems With WARNING. This level is good for logging events that are unusual and potentially bad, but not as bad as ERRORlevel events.

- Log Useful State Information With INFO We recommend using this level to log any details that may be particularly important when analysis
is needed, state changes, change in permissions ... etc.

- Log Debug-Related Messages to DEBUG In development, we recommend using DEBUG and occasionally INFO level logging wherever you’d
consider throwing a print statement into your code for debugging purposes

<br>
<br>
<Br>
  
# Signals: Use Cases and Avoidance Techniques

- The Short Answer: Use signals as a last resort.

- I do not know what the fuck signals are so I am skipping this part.

<br>
<br>
<Br>
  
# What About Those Random Utilities? 

### Create a Core App for Your Utilities

- Sometimes we end up writing shared classes or little general-purpose utilities that are useful everywhere. These bits and pieces don’t belong in any particular app. We don’t just stick them into a
sort-of-related random app, because we have a hard time finding them when we need them. We also
don’t like placing them as “random” modules in the root of the project.

  Our way of handling our utilities is to place them into a Django app called core that contains modules
which contains functions and objects for use across a project. (Other developers follow a similar
pattern and call this sort of app common, generic, util, or utils.)

- We always make the core directory a Django app. At some point we inevitably end up doing
at least one of the following:
  - ➤ Have non-abstract models in core.
  - ➤ Have admin auto-discovery working in core.
  - ➤ Have template tags and filters in core

### Optimize Apps With Utility Modules

- Synonymous with helpers, these are commonly called utils.py and sometimes helpers.py. They are
places where we place functions and classes which make common patterns shorter and easier. 

### Exceptions

- Django comes with a lot of exceptions. Most of them are used internally, but a few of them stand
out because the way they interact with Django can be leveraged in fun and creative ways. These, and
other built-in Django exceptions, are documented at docs.djangoproject.com/en/dev/ref/
exceptions.
  - django.core.exceptions.ImproperlyConfigured
  - django.core.exceptions.ObjectDoesNotExist
  - MultipleObjectsReturned
  - PermissionDenied
  - ... etc.

### Serializers and Deserializers

- Whether it’s for creating data files or generating one-off simple REST APIs, Django has some great
tools for working with serialization and deserialization of data of JSON, Python, YAML and XML
data. They include the capability to turn model instances into serialized data and then return it back
to model instances. You can check for them int he official docs. its is documented well.

<br>
<br>
<Br>
   
# Deployment: Platforms as a Service

- If you’re working on a small side project or are a founder of a small startup, you’ll definitely save time
by using a Platform as a Service (PaaS) instead of setting up your own servers. Even large projects
can benefit from the advantages of using them.

- `TIP: Never Get Locked Into a Platform as a Service` -- There are amazing services which will host your code, databases, media assets, and also provide a lot of wonderful accessories services. These services, however, can go through changes
that can destroy your project. These changes include crippling price increases, performance
degradation, unacceptable terms of service changes, untenable service license agreements,
sudden decreases in availability, or can simply go out of business. 

  This means that it’s in your best interest to do your best to avoid being forced into architectural
decisions based on the needs of your hosting provider. Be ready to be able to move from one
provider to another without major restructuring of your project.

- As a WSGI-compliant framework, Django is supported on many PaaS providers. The most
commonly-used Django-friendly PaaS companies as of this writing are:
  - Elastic Beanstalk (aws.amazon.com/elasticbeanstalk/) is an up-and-coming PaaS in
the Python world
  - Heroku (heroku.com) is a popular option in the Python community well known for its documentation and add-ons system.
  - PythonAnywhere (pythonanywhere.com) is a Python-powered PaaS that is incredibly
beginner-friendly

### Evaluating a PaaS

- Therefore, when a PaaS is chosen for a project, or while we are using a PaaS, we constantly consider
the following:

- `Compliance` -- Before you begin evaluating any other aspect, it’s critical to check to see if the PaaS meets local or
federal mandates. Many medical-based projects in the United States require meeting HIPAA standards Most e-commerce projects require at least SSL, and anything dealing with credit cards
needs to adhere to PCI... etc.

- `Pricing` -- Most PaaS options provide a free tier for beginner and toy projects, and Heroku and PythonAnywhere are good examples of this trend. This is a cool way to get to customers. Orospuyu guzel yapan makyajadir. Dont get fooled by free tiers. Look at the real pricingns and estimate a traffic / price ratio. For example, Heroku maxed out on dynos and enterprise PostgreSQL
will cost over $40,000 a month.

- `Uptime` -- For PaaS this is a very tricky issue. They would really like to provide 99.999999% uptime (sometimes
referred to as the ‘nines’), but even with the best engineering, it’s not entirely under their control: Most of them, including Heroku and PythonAnywhere, rent space from vendors such as AWS
and Rackspace. If those services go down, then they go down.

  It’s worth mentioning that for projects that are life-critical, i.e. people could die if they lack
immediate access, then a PaaS is not the right solution. Instead, please use an infrastructure
service that provides a formal Service License Agreement.

- `Staffing` -- Yes, it’s important to know about the staffing level of a PaaS Do they have the staff to answer emails and problem tickets? If their engineering staff is managing all of these requests, when do they have time to maintain the system? Look at how big the company is, PaaS is a unforgiving business for startups.

- `Scaling` -- How easy is it to scale up? If an e-commerce site is mentioned on CNN or on national television,
can the site be dialed up quickly?

- `HTTP Server` -- Most Python-friendly PaaS use Nginx or their own similar systems to serve data, and all of them can
handle WSGI. What you have to look out for is that some PaaS only support WSGI, which makes
it impossible to use Django Channels.

- `Documentation` -- we want the services that we use to have good,
maintained documentation. It’s important to have this as readily-found reference material, and it
demonstrates that the PaaS in question is serious about what they do.

- `Geography` -- Consider the location of primary usage compared to the location of the PaaS. For example, if the
majority of users are in China, then a PaaS that only serves from US-based data centers isn’t a good option. Latency issues can cause clients and users to become quickly unhappy with a project.

- `Company Stability` -- A PaaS is an enormous undertaking. When done well, it requires a lot of overhead. Engineers, servers,
customer support, account, and marketing are all expensive business. Since the advent of PaaS solutions, we’ve seen a number of them fail because of lack of sales, over expenditure of funds, and
sheer exhaustion by overworked staf. You can find youor platform (backbone of your app) go bacnkrupt so choose well.

### Best Practices for Deploying to PaaS

- `Aim for Identical Environments` -- The holy grail of deployment is identical environments between development and production. However, as soon as you decide to use a PaaS, this is no longer possible as the production system configuration is beyond your control. Nevertheless, the closer your can keep things identical between
development and production the more maintainable your project will be.

- `Maintain a test enviorenment` --  With automation often comes the ability to run staging instances of projects at a lower cost tier. This
is a great place to test production deployments, not to mention a place to demo feature changes.

- `Automate All the Things!` -- When it comes time to push an update to a production instance, it’s never a good idea to do all the
steps manually. It’s simply too easy to make a mistake. Our solution is to use simple automation
  - Makefiles are useful for simple projects. Their limited capability means we won’t be tempted
to make things too fancy
  - If you want something powerful learn about operating systems and how to use shell scripting very well. You can automate almost anything inside a operating system.
  
- `Multiple Requirements Files in Multiple Environments` -- Most PaaS limit themselves to only reading the root requirements.txt file. While it can be good to be
constrained to identical environments everywhere, under some circumstances we just need different
versions of software in different places. For example, production might run Django 1.11.3, and we
want staging to run Django 1.11.5.

- `Prepare for Disaster With Backups and Rollbacks` -- Even with all the precautions we take, sometimes deployments just blow up. Therefore, before any
change is pushed a live site, we make certain for a particular PaaS we know how to:
  - Restore databases and user-uploaded files from backups.
  - Roll back to a previous code push.

- `Keep External Backups` -- The great virtue of PaaS is that they abstract away many deployment and operational issues, allowing
us to focus on writing our project. With that comes the risk that the PaaS might encounter their own
problems. While most PaaS provide the capability to generate backups to their own systems, it’s a
good idea to periodically run backups to external services. This includes the databases and uploaded
user files. Suggestions for storing the data include Dropbox, Crashplan, Amazon S3, and Rackspace Cloud
Files, but there are many more.

<br>
<br>
<Br>
  
# Deploying Django Projects

- Deployment of Django projects is an in-depth topic that could fill an entire book on its own. Here,
we touch upon deployment at a high level.

### Single-Server for Small Projects

- Single-server is the quickest way to get a small Django project up onto a server. It’s also the cheapest
Django deployment option. The obvious drawback is that your server will go down if your website URL gets featured on Hacker
News or any popular blog.

- However, we highly recommend that you try setting up a single-server Django deployment in these
situations: 
  - If you’ve never done it before. It’s an extremely important learning experience. Doing it will
give you a deeper understanding of how Python web applications work
  - If your Django project is more of a toy project or experiment. Websites with paying customers
can’t afford to risk downtime

- Here’s an example of how we could deploy a single-server Django project easily with the following
components:
  - An old computer or cheap cloud server
  - Ubuntu Server OS
  - PostgreSQL
  - Virtualenv
  - Gunicorn
  
  Typicaly, we start out by installing the latest LTS version of Ubuntu Server onto a cloud server. Cloud
server providers often have readymade disk images that are installable with a click, making this trivial Then we do all the server setup basics like updating packages and creating a user account for the
project.

  At this point, it’s Django time. We clone the Django project repo into our user’s home directory and
create a virtualenv with the project’s Python package dependencies, including Gunicorn. We create
a PostgreSQL database for the Django project and run python manage.py migrate. Then we run the Django project in Gunicorn. 

  At this point, we see the Django site running when we go to the server’s IP address in a web browser.
Then we can configure the server hostname and point a domain name at that IP address.

  You’ll also outgrow the single-server setup pretty quickly. At that point, you may get fancier with
your setup, e.g. adding nginx, Redis, and/or memcached, or setting up Gunicorn behind an nginx
proxy. Eventually, you’ll want to either sign up for a PaaS or move to a multi-server setup.
  
### Multi-Server for Medium to Large Projects 

- Companies and growing startups who opt not to use a PaaS typically use a multi-server setup. This is what you need at the most basic level:
  - Database server. Typically PostgreSQL in our projects when we have the choice, though
Eventbrite uses MySQL
  - WSGI application server. Typically uWSGI or Gunicorn with Nginx, or Apache with
mod_wsgi.

  Additionally, we may also want one or more of the following:
  - Static file server. If we want to do it ourselves, Nginx or Apache are fast at serving static files.
However, CDNs such as Amazon CloudFront are relatively inexpensive at the basic level.
  - Caching and/or asynchronous message queue server. This server might run Redis, Memcached or Varnish.
  - Miscellaneous server. If our site performs any CPU-intensive tasks, or if tasks involve waiting
for an external service (e.g. the Twitter API) it can be convenient to offload them onto a server
separate from your WSGI app server.

  Finally, we also need to be able to manage processes on each server.
  - Supervisord `or` init scripts
  
- `TIP: Horizontal vs. Vertical Scaling` -- The above is an example of horizontal scaling, where more servers are added to handle load.
Before scaling horizontally, it’s good to scale vertically by upgrading your servers’ hardware
and maxing out the RAM on each server. Vertical scaling is relatively easy, since it’s just a
matter of throwing money at the problem
  
### WSGI Application Servers

- Always deploy your Django projects with WSGI. The most commonly-used WSGI deployment setups are:
  - uWSGI with Nginx.
  - Gunicorn behind a Nginx proxy
  - Apache with mod_wsgi.
  
  There’s a lot of debate over which option is faster. Don’t trust benchmarks blindly, as many of them
are based on serving out tiny “Hello World” pages, which of course will have different performance
from real web applications.

  if a site is busy enough it’s worth investing time in learning one of these options very well. The disadvantage of setting up our own web servers is the added overhead of extra sysadmin work.

### Common Apache Gotchas

- `WARNING: Do Not Use mod_python` -- The official Django documentation explicitly warns against using mod_python. Django’s
mod_python support was deprecated in Django 1.3. In Django 1.5, the mod_python request
handler was removed from Django.

  Unfortunately, there are still many online resources that talk about configuring Django with
mod_python, causing many people confusion. Do not use mod_python. If using Apache, use
mod_wsgi instead.

- `Apache and Environment Variables` -- Outside of Elastic Beanstalk, Apache doesn’t work with environment. You’ll need to do something like load a local configuration
file for secret values into your settings module written in .ini, .cfg, .json, or .xml formats.

### Automated, Repeatable Deployments

- When we configure our servers, we really shouldn’t be SSHing into our servers and typing in configuration commands from memory. It’s too easy to forget what we’ve done. If servers configured
this way go down and need to be recreated in an emergency, it’s almost impossible to set them up
identically to what we had before Relying on you or your system administrator’s memory of how he or
she set up everything a year ago is dangerous.

  Instead, our server setup should be automated and documented in a way that makes it trivial to
recreate everything from scratch. In the reader’s case, you or your sysadmin should be able to set up
everything without having to log into a single server manually.

### Which Automation Tool Should Be Used?

- Because Python web application deployment is such a huge problem and pain point, the space has
been flooded with tools attempting to solve it. We’re hearing lots of big promises from every tool,
but at this point no particular tool has gone mainstream as The Easiest Way to Deploy, Self-Hosted.

- In the past few years we’ve seen an vibrant ecosystem of companies dedicated to the issue of automating deployments. There is a lot of money to be made The result is that there are many good tools being built, but there is also a lot of corporate fluff to
sift through.

### Current Infrastructure Automation Tools

- Among Django users, Docker, Kubernetes, Ansible, and SaltStack are the most popular tools for
automating deployments. as of 2020. All of these automation tools tend to be complex to set up and use, with a steep learning curve. That’s
because they’re designed to manage not just one server, but thousands or more.

- Here is what these tools can perform at large scale:
  - `Remote execution`:
    - Installing packages via apt-get or other system package management tools on remote servers
    - Running commands on remote servers
    - Starting services, and restarting them under certain conditions
    - When a command is executed remotely, logging and returning the response from the server
  - `Configuration management`:
    - Creating or updating conf files for services.
    - Populating configuration values differently for different servers, based on variables like each server’s particular IP address
  - `Orchestration and targeting:` 
    - Controlling which servers a job is sent to, and when it should be sent
    - Managing various components at a high level, creating pipelines to handle different workflows
    - Pushing jobs to servers from a master server, in push mode.
    - Asking the master server what needs to occur, in pull mode

<br>
<br>
<Br>
  


