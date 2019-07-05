# WSGI

- The Web Server Gateway Interface (WSGI) is developed for calling convention for web servers to forward requests to web applications or frameworks written in the Python programming language. This note file, will talk about a simple and universal interface between web servers and web applications or frameworks: the Python Web Server Gateway Interface (WSGI).
  
 - WSGI presents an absolutely "only important tech" interface to the framework author, because bells and whistles like response objects and cookie handling would just get in the way of existing frameworks' handling of these issues. Again, the goal of WSGI is to facilitate easy interconnection of existing servers and applications or frameworks, not to create a new web framework.

<br>
<br>
<br>

# Specification Overview

- The WSGI interface has two sides: the "server" or "gateway" side, and the "application" or "framework" side. The server side invokes a callable object that is provided by the application side. The specifics of how that object is provided are up to the server or gateway. It is assumed that some servers or gateways will require an application's deployer to write a short script to create an instance of the server or gateway, and supply it with the application object. Other servers and gateways may use configuration files or other mechanisms to specify where an application object should be imported from, or otherwise obtained

- In addition to "pure" servers/gateways and applications/frameworks, it is also possible to create "middleware" components that implement both sides of this specification. Such components act as an application to their containing server, and as a server to a contained application, and can be used to provide extended APIs, content transformation, navigation, and other useful functions.

### A Note On String Types

- In general, HTTP deals with bytes, which means that this specification is mostly about handling bytes. However, the content 
of those bytes often has some kind of textual interpretation, and in Python, strings are the most convenient way to handle text. WSGI therefore defines two kinds of "string":
  - "Native" strings (which are always implemented using the type named str) that are used for request/response headers and metadata
  - "Bytestrings" (which are implemented using the bytes type in Python 3, and str elsewhere), that are used for the bodies of requests and responses (e.g. POST/PUT input data and HTML page outputs).
  
### The Application/Framework Side

- The application object is simply a callable object that accepts two arguments. The term "object" should not be misconstrued as requiring an actual object instance: a function, method, class, or instance with a __call__ method are all acceptable for use as an application object. Application objects must be able to be invoked more than once, as virtually all servers/gateways (other than CGI) will make such repeated requests

---

- I stopped for now. The link I was at:
  - https://www.python.org/dev/peps/pep-3333/#specification-overview
  - https://www.sitepoint.com/python-web-applications-the-basics-of-wsgi/
  - 

