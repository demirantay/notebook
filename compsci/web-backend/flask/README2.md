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
  
- I won't note more because it will take too much space if youa re interested pllease raed the documentations but for a starting point tutorial this page is excellent:
  - https://www.tutorialspoint.com/flask/flask_mail.htm
  
<br>
<br>

---

<br>
<br>

# FLask-WTF

- One of the essential aspects of a web application is to present a user interface for the user. HTML provides a <form> tag, which is used to design an interface. A Form’s elements such as text input, radio, select etc. can be used appropriately.

  Data entered by a user is submitted in the form of Http request message to the server side script by either GET or POST method.
  - The Server side script has to recreate the form elements from http request data. So in effect, form elements have to be defined twice – once in HTML and again in the server side script.
  - Another disadvantage of using HTML form is that it is difficult (if not impossible) to render the form elements dynamically. HTML itself provides no way to validate a user’s input.
  
  This is where `WTForms`, a flexible form, rendering and validation library comes handy. Flask-WTF extension provides a simple interface with this WTForms library.
  
- Using Flask-WTF, we can define the form fields in our Python script and render them using an HTML template. It is also possible to apply validation to the WTF field.

  Like above since it would take a huge space to note Flask WTF I am just going to link a tutorial page and if you want to read more do your research:
    - https://www.tutorialspoint.com/flask/flask_wtf.htm
    
<br>
<br>

---

<br>
<br>

# SQLAlchemy

- Using raw SQL in Flask web applications to perform CRUD operations on database can be tedious. Instead, SQLAlchemy, a Python toolkit is a powerful OR Mapper that gives application developers the full power and flexibility of SQL. Flask-SQLAlchemy is the Flask extension that adds support for SQLAlchemy to your Flask application.

- SQL ALchemy is just an ORM for flask and again it would be impractical to note it down here at the moment. so just read this:
  - https://www.tutorialspoint.com/flask/flask_sqlalchemy.htm
  - than research more
  
<br>
<bR>
  
---

<br>
<br>

# Sijax

- Sijax stands for ‘Simple Ajax’ and it is a Python/jQuery library designed to help you easily bring Ajax to your application. It uses jQuery.ajax to make AJAX requests.

- No point of noting it down here, start here:
  - https://www.tutorialspoint.com/flask/flask_sijax.htm
  - research more ...


  
  
  
  
  
  

