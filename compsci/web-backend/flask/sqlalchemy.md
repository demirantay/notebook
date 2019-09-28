# Flask - SQLAlchemy

- Remember this note file is not noted from sqlalchemy's documentation. It is noted from the flask-sqlalchemy documentation, so the notes are more oriented towards flask.

- For API Reference visit here:
  - https://flask-sqlalchemy.palletsprojects.com/en/2.x/#api-reference
  
<br>

# Configuration

- The following configuration values exist for Flask-SQLAlchemy. Flask-SQLAlchemy loads these values from your main Flask config which can be populated in various ways. Note that some of those cannot be modified after the engine was created so make sure to configure as early as possible and to not modify them at runtime

### Configuration Keys

- A list of configuration keys currently understood by the extension:
  - `SQLALCHEMY_DATABASE_URI` -- The database URI that should be used for the connection. Examples: sqlite:////tmp/test.db
  - `QLALCHEMY_ECHO` -- If set to True SQLAlchemy will log all the statements issued to stderr which can be useful for debugging.
  - There are much more configuration keys, if you want a full view first visit here if not enough you can search from the API too: 
    - https://flask-sqlalchemy.palletsprojects.com/en/2.x/config/#configuration-keys

### Connection URI Format 

- For a complete list of connection URIs head over to the SQLAlchemy documentation under [(Supported Databases)](https://docs.sqlalchemy.org/en/13/core/engines.html). This here shows some common connection strings.
  
  The form of the URI is:
  ```
  dialect+driver://username:password@host:port/database
  ```
  
- Lets see the URI's of some of the most famous database management systems:
  - PostgreSQL :
    ```
    postgresql://scott:tiger@localhost/mydatabase
    ```
  - MySQL:
    ```
    mysql://scott:tiger@localhost/mydatabase
    ```
  - SQLite (note that platform path conventions apply):
    ```
    #Unix/Mac (note the four leading slashes)
    sqlite:////absolute/path/to/foo.db
    ```
    
### Using Custom MetaData and Naming Conventions 

- This is important for using things such as migrations (e.g. with amblemic). I am not sure where to use this at the moment:
  - https://flask-sqlalchemy.palletsprojects.com/en/2.x/config/#using-custom-metadata-and-naming-conventions

### Timeouts

- Certain database backends may impose different inactive connection timeouts, which interferes with Flask-SQLAlchemy’s connection pooling. If you are having issues with timeouts the configuration key is usually : SQLALCHEMY_POOL_RECYCLE

<br>
<br> 

---

<br>
<br>

# Declaring Models

- This notes are not full, read the official sqlaclhemy documentation for the full scope of model declariton. But I will try to note most common use cases.

  Things to keep in mind:
    - The baseclass for all your models is called `db.Model`. It’s stored on the SQLAlchemy instance you have to create.
    - Some parts that are required in SQLAlchemy are optional in Flask-SQLAlchemy. For instance the table name is automatically set for you unless overridden. It’s derived from the class name converted to lowercase and with “CamelCase” converted to “camel_case”. To override the table name, set the `__tablename__` class attribute.
    
### Simple Example

- A very simple example:
  ```python
  class User(db.Model):
    id = db.Column(db.Integer, primary_key=True)
    username = db.Column(db.String(90), unique=True, nullable=False)
    email = db.Column(db.String(120), unique=True, nullable=False)
    
    def __init__(self, username, email):
       self.username = username
       self.email = email
       
  class Post(db.Model):
    id = db.Column(db.Integer, primary_key=True)
    content = db.Column(db.Text)
    user_id = db.Column(db.Integer, db.ForeignKey('user.id')
      
  ```
  Use Column to define a column. The name of the column is the name you assign it to. If you want to use a different name in the table you can provide an optional first argument which is a string with the desired column name, such as:
  ```python
  id = db.Column("random_name_hehe", db.Integer, ...)
  ```
  
- The types of the column are the first argument to Column. You can either provide them directly or call them to further specify them (like providing a length). The following types are not all but the most common:
  - `Integer` -- an integer
  - `String(size)` -- a string with a maximum length (optional in some databases, e.g. PostgreSQL)
  - `Text` -- some longer unicode text
  - `DateTime` -- date and time expressed as Python datetime object.
  - `Float` -- stores floating point values
  - `Boolean` -- stores a boolean value
  - `LargeBinary` -- stores large arbitrary binary data
  - `PickleType` -- stores a pickled Python object

### One-to-Many Relationship

- The most common relationships are one-to-many relationships. Because relationships are declared before they are established you can use strings to refer to classes that are not created yet (for instance if `Person` defines a relationship to `Address` which is declared later in the file).

  Relationships are expressed with the `relationship()` function. However the foreign key has to be separately declared with the `ForeignKey` class:
  ```python
  class User(db.Model):
    __tablename__ = "user"
    id = db.Column(db.Integer, primary_key=True)
    name = db.Column(db.String(80))
    email = db.Column(db.String(120), unique=True)
    posts = db.relationship('Post', backref='user')
   
  ```
  
  So what do `backref` and `lazy` mean? `backref` is a simple way to also declare a new property on the `Address` class. You can then also use `my_address.person` to get to the person at that address. `lazy` defines when SQLAlchemy will load the data from the database:

### Many-to-Many Relationship

- If you want to use many-to-many relationships you will need to define a helper table that is used for the relationship. For this helper table it is strongly recommended to not use a model but an actual table:
  ```python
  tags = db.Table('tags',
      db.Column('tag_id', db.Integer, db.ForeignKey('tag.id'), primary_key=True),
      db.Column('page_id', db.Integer, db.ForeignKey('page.id'), primary_key=True)
  )

  class Page(db.Model):
      id = db.Column(db.Integer, primary_key=True)
      tags = db.relationship('Tag', secondary=tags, lazy='subquery',
          backref=db.backref('pages', lazy=True))

  class Tag(db.Model):
      id = db.Column(db.Integer, primary_key=True)
  ```
  
- I did not necessarlily understand how to fully write m-2-m relationshipped keys, try to research it from stackoverflow or ... etc. to get an example of usage

<br>
<br>

---

<br>
<br>

# Select, Insert, Delete 

- Now that you have declared models it’s time to query the data from the database

### Inserting Records

- Before we can query something we will have to insert some data. All your models should have a constructor, so make sure to add one if you forgot. Constructors are only used by you, not by SQLAlchemy internally so it’s entirely up to you how you define them.
   
  Inserting data into the database is a three step process:
  - 1 - Create the Python object
  - 2 - Add it to the session
  - 3 - Commit the session
  
  The session here is not the Flask session, but the Flask-SQLAlchemy one. It is essentially a beefed up version of a database transaction. This is how it works:
  ```python
  >>> from yourapp import User
  >>> me = User('admin', 'admin@example.com')
  >>> db.session.add(me)
  >>> db.session.commit()
  ```
  The `add()` function call then adds the object. It will issue an __INSERT__ statement for the database but because the transaction is still not committed you won’t get an ID back immediately

### Deleting Records

- Deleting records is very similar, instead of add() use delete():
  ```python
  >>> db.session.delete(me)
  >>> db.session.commit()
  ```
  
### Querying Records

- So how do we get data back out of our database? For this purpose Flask-SQLAlchemy provides a query attribute on your Model class. When you access it you will get back a new query object over all records. You can then use methods like `filter()` to filter the records before you fire the select with `all()` or `first()`. If you want to go by primary key you can also use `get()`.

- In order to examine an example lets have this imaginary table:
  
  | id | username | email |
  |--|--|--|
  | 1 | admin | admin@admin.com |
  | 2 | peter | peter@foo.com |
  | 3 | guest | guest@foo.com |
  
  Retrieve a user by username:
  ```python
  >>> peter = User.query.filter_by(username='peter').first()
  >>> peter.id
  2
  >>> peter.email
  u'peter@example.org'
  ```
  Same as above but for a non existing username gives None:
  ```python
  >>> missing = User.query.filter_by(username='missing').first()
  >>> missing is None
  True
  ```
  Selecting a bunch of users by a more complex expression:
  ```
  >>> User.query.filter(User.email.endswith('@foo.com')).all()
  [<User u'peter'>, <User u'guest'>]
  ```
  Ordering users by something:
  ```python
  >>> User.query.order_by(User.username).all()
  [<User u'admin'>, <User u'guest'>, <User u'peter'>]
  ```
  Limiting users:
  ```python
  >>> User.query.limit(1).all()
  [<User u'admin'>]
  ```
  Getting user by primary key:
  ```python
  >>> User.query.get(1)
  <User u'admin'>
  ```

### Queries in Views

- If you write a Flask view function it’s often very handy to return a 404 error for missing entries. Because this is a very common idiom, Flask-SQLAlchemy provides a helper for this exact purpose. Instead of `get()` one can use `get_or_404()` and instead of `first()`, `first_or_404()`. This will raise 404 errors instead of returning None:
  ```python
  @app.route('/user/<username>')
  def show_user(username):
      user = User.query.filter_by(username=username).first_or_404()
  ```

<br>
<br>

---

<br>
<br>

# Multiple Databases with Binds 

- Flask-SQLAlchemy can easily connect to multiple databases. To achieve that it preconfigures SQLAlchemy to support multiple “binds”. What are binds? In SQLAlchemy speak a bind is something that can execute SQL statements and is usually a connection or engine. In Flask-SQLAlchemy binds are always engines that are created for you automatically behind the scenes. Each of these engines is then associated with a short key (the bind key). This key is then used at model declaration time to assocate a model with a specific engine.

  If no bind key is specified for a model the default connection is used instead (as configured by `SQLALCHEMY_DATABASE_URI`).

### Example Configuration 

- The following configuration declares three database connections. The special default one as well as two others named users (for the users) and appmeta (which connects to a sqlite database for read only access to some data the application provides internally):
  ```python
  SQLALCHEMY_DATABASE_URI = 'postgres://localhost/main'
  SQLALCHEMY_BINDS = {
      'users':        'mysqldb://localhost/users',
      'appmeta':      'sqlite:////path/to/appmeta.db'
  }
  ```

### Creating and Dropping Tables

- The `create_all()` and `drop_all()` methods by default operate on all declared binds, including the default one. This behavior can be customized by providing the bind parameter. It takes either a single bind name, `'__all__'` to refer to all binds or a list of binds. The default bind (SQLALCHEMY_DATABASE_URI) is named `None`:
  ```python
  >>> db.create_all()
  >>> db.create_all(bind=['users'])
  >>> db.create_all(bind='appmeta')
  >>> db.drop_all(bind=None)
  ```

### Reffering to Binds 

- If you declare a model you can specify the bind to use with the `__bind_key__` attribute:
  ```python
  class User(db.Model):
    __bind_key__ = 'users'
    id = db.Column(db.Integer, primary_key=True)
    username = db.Column(db.String(80), unique=True)
  ```
  If you specified the `__bind_key__` on your models you can use them exactly the way you are used to. The model connects to the specified database connection itself.

<br>
<br>

----

<br>
<Br>
  
# Customizing 

- Flask-SQLAlchemy defines sensible defaults. However, sometimes customization is needed. There are various ways to customize how the models are defined and interacted with.

### Model Class

- SQLAlchemy models all inherit from a declarative base class. This is exposed as db.Model in Flask-SQLAlchemy, which all models extend. This can be customized by subclassing the default and passing the custom class to `model_class`.

- There are much more you can do for customizing your sqlaclhemy orm for using it with flask but I am not going to note down everything about it at the moment. Just see this link for a starter tutorial:
  - https://flask-sqlalchemy.palletsprojects.com/en/2.x/customizing/
