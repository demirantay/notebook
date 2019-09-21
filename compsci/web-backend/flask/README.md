---

- Things to read:
  - [ ] https://www.fullstackpython.com/flask.html
  - [ ] https://www.deploypython.com/

---


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
  ```python
  def index():
   return ‘hello world’
  
  app.add_url_rule(‘/’, ‘hello’, index)
  ```

<Br>
<br>
<br>
  
 # Variable Rules
  
- It is possible to build a URL dynamically, by adding variable parts to the rule parameter. This variable part is marked as `<variable-name>`. It is passed as a keyword argument to the function with which the rule is associated

- In the following example, the rule parameter of `route()` decorator contains `<name>` variable part attached to URL `‘/hello’`. Hence, if the `http://localhost:5000/hello/TutorialsPoint` is entered as a URL in the browser, `‘TutorialPoint’` will be supplied to `hello()` function as argument.
  ```python
  @app.route('/hello/<name>')
  def hello_name(name):
     return 'Hello %s!' % name
  ```
  
  In addition to the default string variable part, rules can be constructed usining `int`, `flaot`, `path` ... etc. such as this:
  ```python
  @app.route('/foo/<int:bar>')
  @app.route('/foo/<float:baz>')
  ```

- The URL rules of Flask are based on Werkzeug’s routing module. This ensures that the URLs formed are unique and based on precedents laid down by Apache. So Instead of using:
  ```python
  '/foo/baz/'
  ```
  use this:
  ```
  '/foo/baz`
  ```
  Do not put th slash to close the URL path
  
<br>
<br>
<br>

# HTTP Methods

- By default, the Flask route responds to the GET requests. However, this preference can be altered by providing methods argument to route() decorator:
  ```python
  @app.route('/login',methods = ['POST', 'GET'])
  def login():
    if request.method == 'POST':
      user = request.form['nm']
      return redirect(url_for('success',name = user))
  ```
  As show above in order to get the value of the input value from the post u just use this:
  ```python
  foo = request.form['input_name']
  ```
  If you want to get the value of a `GET` requested input than use this instead:
  ```python
  foo = request.args.get(‘input_name’)
  ```
  Here, args is dictionary object containing a list of pairs of form parameter and its corresponding value. 

<br>
<br>
<br>

# Templates

- Instead of writing full html code into a python string you can render it into `templates`. This is where one can take advantage of Jinja2 template engine, on which Flask is based. Instead of returning hardcode HTML from the function, a HTML file can be rendered by the `render_template()` function.
  ```python
  @app.route('/')
  def index():
     return render_template(‘hello.html’)
  ```
  Flask will try to find the HTML file in the templates folder, in the same folder in which this script is present. You can add the path to your template folders from the app config like this:
  ```python
  app = Flask(
      __name__,
      static_folder='./static',
      template_folder='./templates'
  )
  ```
  
- You will view more on how to use jinja templates on the jinja template tutorial notes however these are the basics that will get you started:

  First you pass your data from the views with the `data` parameter of the render template, view the code snippet for more info:
  ```python
  @app.route('/')
  def index():
     foo = 42
     
     data = {
      'foo': foo,
     }
     return render_template(‘index.html’ data=data)
  ```
  Now that you have your dynamic data ready to be used in your templates you can accsess the variables in templates like this:
  ```html
  <h1>{{ data.foo }}</h1>
  ```
  
- You can also add logic to your templates with `if` and `for` blocks:
  ```html
  {% if data.foo > 40 %}
    <h1>Horray correct</h1>
  {% else %}
    <h1>You failed</h1>
  {% endif %}
  ```
  Or as said above you can use for loops inside your templates. Lets assume we passed an array to the data dict
  ```html
  {% for element in data.array %}
    <h1>{{ element.name }}</h1>
  {% endfor %}
  ```
  
- You can also `block` out pieces of your code in order re-use them like functions. Nearly all projects have a base block so lets see it:
  ```html
  <html>
    <head>
      <title>foo</title>
      ...
    </head>  
    
    <body>
      {% block content %}
        <!-- Your actual content will go here -->
      {% endblock %}
    </body>
   
  </html> 
  ```
  Now that we have our 'base.html' template lets write our actual code. In order to the base in our code we first need to import it with `extends`:
  ```html
  {% extends 'base.html' %}

  {% block content %}
    <h1>Hello</h1>
  {% endblock %}
  ```
 
<br>
<br>
<br>

# Static Files

- A web application often requires a static file such as a `javascript` file or a `CSS` file supporting the display of a web page. Usually, the web server is configured to serve them for you, but during the development, these files are served from static folder in your package or next to your module and it will be available at `/static` on the application.

- As defined above we first need to show the path to the Flask app so that it will know where our static files are located:
  ```python
  app = Flask(
      __name__,
      static_folder='./static',
      template_folder='./templates'
  )
  ```
  
- And you need a specific url patthing for your static files while trying to accsess them from your templates. It looks like this:
  ```html
  <link rel="stylesheet" type="text/css" href="{{ url_for('static', filename='css/index.css') }}" />
  ```

<br>
<br>
<br>

# Cookies

- A cookie is stored on a client’s computer in the form of a text file. Its purpose is to remember and track data pertaining to a client’s usage for better visitor experience and site statistics.

- In Flask, cookies are set on response object. Use `make_response()` function to get response object from return value of a view function. After that, use the `set_cookie()` function of response object to store a cookie.

  Reading back a cookie is easy. The `get()` method of `request.cookies` attribute is used to read a cookie. 
  
  Now Lets see all of them in action first we need to have our data. Lets put a form in our `readcookie.html` file:
  ```html
  <form action = "/setcookie" method = "POST">
    <p><h3>Enter userID</h3></p>
    <p><input type = 'text' name = 'number'/></p>
    <p><input type = 'submit' value = 'submit'/></p>
  </form>
  ```
  The Form is posted to `‘/setcookie’` URL. The associated view function sets a Cookie name `userID` and renders another page.
  ```python
  @app.route('/setcookie', methods = ['POST', 'GET'])
  def setcookie():
     if request.method == 'POST':
     user = request.form['number']

     response = make_response(render_template('readcookie.html'))
     response.set_cookie('userID', user)

     return response
  ```
  `‘readcookie.html’` contains a hyperlink to another view function `getcookie()`, which reads back and displays the cookie value in browser.
  ```python
  @app.route('/getcookie')
  def getcookie():
     user_id = request.cookies.get('userID')
     
     return '<h1>' + user_id + '</h1>'
  ```

<br>
<br>
<br>

# Sessions

- Unlike a Cookie, Session data is stored on server. Session is the time interval when a client logs into a server and logs out of it. The data, which is needed to be held across this session, is stored in a temporary directory on the server.

- A session with each client is assigned a `Session ID`. The Session data is stored on top of cookies and the server signs them cryptographically. For this encryption, a Flask application needs a defined `SECRET_KEY`.
 
  Session object is also a dictionary object containing key-value pairs of session variables and associated values. For example let's set a key named 'username' to our session dictionary:
  ```python
  Session['username'] = 'admin'
  ```
  To release(delete) a session variable use pop() method.
  ```python
  session.pop('username', None)
  ```
  
- Lets see a real world very basic example of how sessions are used with Flask:
  ```python
  @app.route('/login', methods = ['GET', 'POST'])
  def login():
     if request.method == 'POST':
        session['username'] = request.form['username']
        return redirect(url_for('index'))
  ```
  And we can also use the `pop()` function with the logout view:
  ```python
  @app.route('/logout')
  def logout():
     # remove the username from the session if it is there
     session.pop('username', None)
     return redirect(url_for('index'))
  ````
  
- Run the application and visit the homepage. (Ensure to set secret_key in the application's configuration)
  ```python
  from flask import Flask, session, redirect, url_for, escape, request
  app = Flask(__name__)
  app.secret_key = 'any random string’
  ```
  
<br>
<br>
<br>

# Redirect & Errors

- Flask class has a redirect() function. When called, it returns a response object and redirects the user to another target location with specified status code.

  Prototype of redirect() function is as below −
  ```python
  Flask.redirect(location, statuscode, response)
  ```
  In the above function −
    - `location` parameter is the URL where response should be redirected.
    - `statuscode` sent to browser’s header, defaults to 302 which is for ‘found’..
    - `response` parameter is used to instantiate response.
    
- Let's see a real world example: 
  ```python
  from flask import Flask, redirect, url_for, render_template, request
  ...
  
  @app.route('/login',methods = ['POST', 'GET'])
  def login():
     if request.method == 'POST' and request.form['username'] == 'admin' :
         return redirect(url_for('success'))
  ```
    
- You can also `abort()` the redirect in case if the request method has an error. Lets modify our login gate above to haev an abort function init:
  ```python
  @app.route('/login',methods = ['POST', 'GET'])
  def login():
     if request.method == 'POST':
        if request.form['username'] == 'admin' :
           return redirect(url_for('success'))
        else:
           abort(401)
  ```
    
<br>
<br>
<br>

# File Uploading

- Handling file upload in Flask is very easy. It needs an HTML form with its enctype attribute set to ‘multipart/form-data’, posting the file to a URL. The URL handler fetches file from `request.files[]` object and saves it to the desired location.

  Each uploaded file is first saved in a temporary location on the server, before it is actually saved to its ultimate location. Name of destination file can be hard-coded or can be obtained from filename property of `request.files[file]` object. However, it is recommended to obtain a secure version of it using the `secure_filename()` function.
 
 It is possible to define the path of default upload folder and maximum size of uploaded file in configuration settings of Flask object.
 ```python
 app.config[‘UPLOAD_FOLDER’]  # Defines path for upload folder

  app.config[‘MAX_CONTENT_PATH’]	# Specifies maximum size of file yo be uploaded – in bytes 
 ```
 
- Let's see a real world example. First do not forget to add enctype attrbiute to your form in the template:
  ```html
  <form method = "POST" action="..." enctype = "multipart/form-data" > 
  ```
  and you can process the form in your flask view like this:
  ```python
  @app.route('/uploader', methods = ['GET', 'POST'])
  def upload_file():
     if request.method == 'POST':
        f = request.files['file']
        f.save(secure_filename(f.filename))
        return 'file uploaded successfully'
  ```

<br>
<br>


---

[Part 2](./README2.md)






