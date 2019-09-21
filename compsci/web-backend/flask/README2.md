[Part 1](./README.md)

---

<br>

# Message Flashing

- A good GUI based application provides feedback to a user about the interaction. For example, the desktop applications use dialog or message box and JavaScript uses alerts for similar purpose.

  Generating such informative messages is easy in Flask web application. Flashing system of Flask framework makes it possible to create a message in one view and render it in a view function called `next`.

  A Flask module contains `flash()` method. It passes a message to the next request, which generally is a template.
  ```python
  flash(message, category)
  ```
  - `message` - parameter is the actual message to be flashed.
  - `category` - parameter is optional. It can be either ‘error’, ‘info’ or ‘warning’.
  
- In order to remove message from session, template calls `get_flashed_messages()`:
  ```python
  get_flashed_messages(with_categories, category_filter)
  ```
  
- You can read more on flashing somewhere else I am not going to note down it at the moment:
  - starting point: https://www.tutorialspoint.com/flask/flask_message_flashing.htm
  
<br>
<br>

---

<br>
<Br>

# File Uploading

- Handling file upload in Flask is very easy. It needs an HTML form with its enctype attribute set to ‘multipart/form-data’, posting the file to a URL. The URL handler fetches file from `request.files[]` object and saves it to the desired location.

  
- It is possible to define the path of default upload folder and maximum size of uploaded file in configuration settings of Flask object.
  - `app.config[‘UPLOAD_FOLDER’]` -> Defines path for upload folder
  - `app.config[‘MAX_CONTENT_PATH’]` -> Specifies maximum size of file yo be uploaded – in bytes
  
  Lets see an example:
  ```html
  <form action = "http://localhost:5000/uploader" method = "POST" enctype = "multipart/form-data"> ... </form>
  ```
  And you can get the image in your view with this:
  ```python
  if request.method == 'POST':
      f = request.files['file']
  ```
  
<br>
<br>

---

<br>
<br>

# Extensions

- Flask is often referred to as a micro framework, because a core functionality includes WSGI and routing based on Werkzeug and template engine based on Jinja2. In addition, Flask framework has support for cookie and sessions as well as web helpers like JSON, static files etc. Obviously, this is not enough for the development of a full-fledged web application. This is where the Flask extensions come in picture. Flask extensions give extensibility to Flask framework.

  There are a large number of Flask extensions available. A Flask extension is a Python module, which adds specific type of support to the Flask application. Flask Extension Registry is a directory of extensions available. The required extension can be downloaded by pip utility
    
   Few common used ones are:
   - `Flask Mail` − provides SMTP interface to Flask application
   - `Flask WTF` − adds rendering and validation of WTForms
   - `Flask SQLAlchemy` − adds SQLAlchemy support to Flask application
   - `Flask Sijax` − Interface for Sijax - Python/jQuery library that makes AJAX easy to use in web applications

<br>
<br>

---

<br>
<br>

# Flask-Mail 

- A web based application is often required to have a feature of sending mail to the users/clients. Flask-Mail extension makes it very easy to set up a simple interface with any email server. First install it with pip:
  ```
  pip instal Flask-Mail
  ```
  A web based application is often required to have a feature of sending mail to the users/clients. Flask-Mail extension makes it very easy to set up a simple interface with any email server.
  - `MAIL_SERVER` - Name/IP address of email server
  - `MAIL_PORT` - Port number of server used
  - `MAIL_USE_TLS` - Enable/disable Transport Security Layer encryption
  - `MAIL_USE_SSL` - Enable/disable Secure Sockets Layer encryption
  - `MAIL_DEBUG` - Debug support. Default is Flask application’s debug status
  - `MAIL_USERNAME` - User name of sender
  - `MAIL_PASSWORD` - password of sender
  - `MAIL_DEFAULT_SENDER` - sets default sender
  - `MAIL_MAX_EMAILS` - Sets maximum mails to be sent
  - `MAIL_SUPPRESS_SEND` - Sending suppressed if app.testing set to true
  - `MAIL_ASCII_ATTACHMENTS` - If set to true, attached filenames converted to ASCII
  
  
  
  
  
  
  
  

