# Flask

- Flask is a web application framework written in Python. It is developed by Armin Ronacher, who leads an international group of Python enthusiasts named Pocco. Flask is based on the Werkzeug WSGI toolkit and Jinja2 template engine. Both are Pocco projects.

- **WSGI**: Web Server Gateway Interface (WSGI) has been adopted as a standard for Python web application development. WSGI is a specification for a universal interface between the web server and the web applications.

- **Werkezug**: It is a WSGI toolkit, which implements requests, response objects, and other utility functions. This enables building a web framework on top of it. The Flask framework uses Werkzeug as one of its bases.

- **Jinja2**: Jinja2 is a popular templating engine for Python. A web templating system combines a template with a certain data source to render dynamic web pages.

- Flask is often referred to as a micro framework. It aims to keep the core of an application simple yet extensible. Flask does not have built-in abstraction layer for database handling, nor does it have form a validation support. Instead, Flask supports the extensions to add such functionality to the application.

- You can install flask with pip:
  ```
  $ pip install Flask
  ```
  
<br>
<br>
<br>

# Application

- A Flask application is an instance of the Flask class. Everything about the application, such as configuration and URLs, will be registered with this class.
  ```python
  from flask import Flask
  
  app = Flask(__name__)  # <-- Flask App Instance

  @app.route('/')
  def index():
     return 'Hello World’

  if __name__ == '__main__':
     app.run()
  ```
  The app.route() is a rotuting to the view we will discuss this later on.
  
- Flask constructor takes the name of current `module (__name__)` as argument.

  Finally the `run()` method of Flask wsgi app class runs the application on the local development server. You can add optional parameters to it:
  ```python
  app.run(host, port, debug, options)
  ```
  
  Lets see the parameters list:
  - `host` : Hostname to listen on. Defaults to 127.0.0.1 (localhost). Set to ‘0.0.0.0’ to have server available externally
  - `port` : Defaults to 5000
  - `debug` : Defaults to false. If set to true, provides a debug information
  - `options` : To be forwarded to underlying Werkzeug server.
  
<br>
<br>
<br>

# Routing

- Modern web frameworks use the routing technique to help a user remember application URLs. It is useful to access the desired page directly without having to navigate from the home page. The `route()` decorator in Flask is used to bind URL to a function. For example −
  ```python
  @app.route(‘/hello’)
  def index():
     return ‘hello world’
  ```
  
- You can also `add_url_rule()` function of an application object is also available to bind a URL with a function as in the above example, `route()` is used. (like in Django)
  ```
  def index():
   return ‘hello world’
  
  app.add_url_rule(‘/’, ‘hello’, index)
  ```

<Br>
<br>
<br>
  
 # Variable Rules
  
  ...




