# Flask - SQLAlchemy

- Using raw SQL in Flask web applications to perform CRUD operations on database can be tedious. Instead, SQLAlchemy, a Python toolkit is a powerful OR Mapper that gives application developers the full power and flexibility of SQL. Flask-SQLAlchemy is the Flask extension that adds support for SQLAlchemy to your Flask application.

  Because SQLAlchemy is a common database abstraction layer and object relational mapper that requires a little bit of configuration effort, there is a Flask extension that handles that for you. This is recommended if you want to get started quickly.

  You can download Flask-SQLAlchemy from PyPI.
  ```
  pip install flask-sqlalchemy
  ```
  You need to import SQLAlchemy class from this module.
  ```python
  from flask_sqlalchemy import SQLAlchemy
  ```
  Now create a Flask application object and set URI for the database to be used.
  ```python
  app = Flask(__name__)
  :app.config['SQLALCHEMY_DATABASE_URI'] = 'sqlite:///students.sqlite3'
  ```
   Then create an object of SQLAlchemy class with application object as the parameter. This object contains helper functions for ORM operations. It also provides a parent Model class using which user defined models are declared. In the snippet below, a students model is created.
   ```python
   
   db = SQLAlchemy(app)
  class students(db.Model):
     id = db.Column('student_id', db.Integer, primary_key = True)
     name = db.Column(db.String(100))
     city = db.Column(db.String(50))  
     addr = db.Column(db.String(200))
     pin = db.Column(db.String(10))

    def __init__(self, name, city, addr,pin):
       self.name = name
       self.city = city
       self.addr = addr
       self.pin = pin
   ```
   To create / use database mentioned in URI, run the create_all() method.
   ```python
   db.create_all()
   ```
   
