# Templates: Best Practices

- One of Django’s early design decisions was to limit the functionality of the template language. This
heavily constrains what can be done with Django templates, which we often think is a very good
thing since it forces us to keep business logic in the Python side of things.

### Keep Templates Mostly in templates/ 

- In our projects, we keep the majority of our templates in the main ‘templates/’ directory. We put
subdirectories in ‘templates/’ to correspond to each of our apps, as shown here:
  ```
  templates/
  ├── base.html
  ├── ... (other sitewide templates in here)
  ├── freezers/
  │   ├── ("freezers" app templates in here)
  ```

### Template Architecture Patterns

- `3-Tier Template Architecture Example` -- With a 3-tier template architecture:
  ```
  templates/
      base.html
      dashboard.html # extends base.html
      profiles/
          base_profiles.html # extends base.html
          profile_detail.html # extends base_profiles.html
          profile_form.html # extends base_profiles.html
  ```
  The 3-tier architecture is best for websites where each section requires a distinctive layout.
  
  Complex template hierarchies make it exceedingly difficult to debug, modify, and extend HTML
pages and tie in CSS styles. When template block layouts become unnecessarily nested, you end up
digging through file after file just to change, say, the width of a box

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
