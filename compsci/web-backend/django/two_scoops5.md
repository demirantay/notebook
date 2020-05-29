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

  

