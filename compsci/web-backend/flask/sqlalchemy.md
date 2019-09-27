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

### Simple Example

### One-to-Many Relationship

### Many-to-Many Relationship

<br>
<br>

---

<br>
<br>

# Select, Insert, Delete 

### Inserting Records

### Deleting Records

### Querying Records

### Queries in Views

<br>
<br>

---

<br>
<br>

# Multiple Databases with Binds 

### Example Configuration 

### Creating and Dropping Tables

### Reffering to Binds 


<br>
<br>

----

<br>
<Br>
  
# Signalling Support & Customizing 

### Model Class

### Model Mixins

### Query Class 

### Model Metaclass 
