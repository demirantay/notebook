# Digital Ocean: How to Deploy Python WSGI Apps Using Gunicorn HTTP Server Behind Nginx

<br>

> Reference: https://www.digitalocean.com/community/tutorials/how-to-deploy-python-wsgi-apps-using-gunicorn-http-server-behind-nginx

<bR>
  
# About Gunicorn and Nginx

### Gunicorn

- Gunicorn is a stand-alone WSGI web application server which offers a lot of functionality. It natively supports various frameworks with its adapters, making it an extremely easy to use drop-in replacement for many development servers that are used during development.

- `Gunicorn Server Highlights` -- 
  - Runs any WSGI Python web application (and framework)
  - Can be used as a drop-in replacement for Paster (Pyramid), Django’s Development Server, web2py etc.
  - Comes with various worker types and configurations
  - Manages worker processes automatically
  - HTTP/1.0 and HTTP/1.1 (Keep-Alive) support through synchronous and asynchronous workers
  - Supports SSL
  - Extensible with hooks

### Web Application Deployment Using Nginx

- Nginx is a very high performant web server / (reverse)-proxy. It has reached its current popularity due to being light weight, relatively easy to work with, and easy to extend (with add-ons / plug-ins). Thanks to its architecture, it is capable of handling a lot of requests (virtually unlimited), which - depending on your application or website load - could be really hard to tackle using some other, older alternatives.

- `Why use Nginx as a reverse-proxy in front of an application server?` :

  Many frameworks and application servers (including Gunicorn) can serve static files (e.g. javascript, css, images etc.) together with responses. However, the better thing to do is to let a (reverse-proxy) server such as Nginx handle the task of serving these files and managing connections (requests). This relieves a lot of the load from the application servers, granting you a much better overall performance.

- Example of a Basic Server Architecture:
  ```
  Client Request ----> Nginx (Reverse-Proxy)
                        |
                       /|\                           
                      | | `-> App. Server I.   127.0.0.1:8081
                      |  `--> App. Server II.  127.0.0.1:8082
                       `----> App. Server III. 127.0.0.1:8083
  ```

<br>
<br>

---

<br>
<br>

# Serving Python Web Applications with Gunicorn

- In this section, we will see how a WSGI application works with Gunicorn. This process consists of providing the server with a WSGI application callable (e.g. `application = (..)`) as the point of entry.

### WSGI

- WSGI in a nutshell is an interface between a web server and the application itself. It exists to ensure a standardized way between various servers and applications (frameworks) to work with each other, allowing interchangeability when necessary (e.g. switching from development to production environment), which is a must-have need nowadays.

### WSGI Application Object (Callable): wsgi.py

### Running the server

### Configuring and Optimising Gunicorn

### Configuring Nginx

### Miscellaneous Tips and Suggestions
