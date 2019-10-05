# Flask-Migrate

- Flask-Migrate is an extension that handles SQLAlchemy database migrations for Flask applications using Alembic. The database operations are made available through the Flask command-line interface or through the Flask-Script extension.

## Why Use Flask-Migrate vs. Alembic Directly?

- Flask-Migrate is an extension that configures Alembic in the proper way to work with your Flask and Flask-SQLAlchemy application. In terms of the actual database migrations, everything is handled by Alembic so you get exactly the same functionality.

## Usage

- Install Flask-Migrate with pip:
  ```
  pip install Flask-Migrate
  ```
  
- Lets see an example usage of the extension:
  ```python
  from flask import Flask
  from flask_sqlalchemy import SQLAlchemy
  from flask_migrate import Migrate

  app = Flask(__name__)
  app.config['SQLALCHEMY_DATABASE_URI'] = 'sqlite:///app.db'

  db = SQLAlchemy(app)
  migrate = Migrate(app, db)

  class User(db.Model):
      id = db.Column(db.Integer, primary_key=True)
      name = db.Column(db.String(128))
  ```
  With the above application you can create a migration repository with the following command:
  ```
  $ flask db init
  ```
  This will add a migrations folder to your application. The contents of this folder need to be added to version control along with your other source files.
  
  You can then generate an initial migration:
  ```
  $ flask db migrate
  ```
  Then you can apply the migration to the database:
  ```
  $ flask db upgrade
  ```
  
  
 - Left reading at here:
  - https://flask-migrate.readthedocs.io/en/latest/#using-flask-script
