# Flask

- Flask is a "micro framework" for web development built for python ecosysytem. It is not like django where it dictates and limits most of what you do flask is more permissive however that can mean it is less secure. Lets build a minimal application for a intruction.

## A Minimal Application

- A minimal flask application might look something like this:
  ```python
  from flask import Flask
  app = Flask(__name__)
  
  @app.route('/')
  def index():
    return 'index page'
  ```
  First we imported the `Flask` class, an instance of this class will be our wsgi application. The parameter while creating the class insance is the name of the application module. If you are writing a single module you should leave it as `__name__` if it is not just put the name you will specify in setup. This is needed because flask will know where to look for templates and static files. You tell the flask to set the url patterns with the `@app.route()` decorator. The function under the decorator is just the view that returns the value we want the user to see
  
- Before you run your flask application you need to export the flask app enviorement variable in your terminal. After that you can simply run your flask app with the python `-m` command:
  ```
  $ export FLASK_APP=filename.py  # export env var
  $ python -m flask run           # runs the server
    * Running on http://127.0.0.1:5000/
  ```
  This runs the developemnt built in server for production and deployment you need to check the official docs.
  
- 
