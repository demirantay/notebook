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

  

