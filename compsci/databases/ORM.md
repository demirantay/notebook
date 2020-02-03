# Database ORM's

- An object-relational mapper (ORM) is a code library that automates the transfer of data stored in relational databases tables into objects that are more commonly used in application code.

### Why are ORMs useful?

- ORMs provide a high-level abstraction upon a relational database that allows a developer to write Python code instead of SQL to create, read, update and delete data and schemas in their database. Developers can use the programming language they are comfortable with to work with a database instead of writing SQL statements or stored procedures.

- For example, without an ORM a developer would write the following SQL statement to retrieve every row in the USERS table where the zip_code column is 94107:
  ```sql
  SELECT * FROM USERS WHERE zip_code=94107;
  ```
  The equivalent of the above code in a ORM such as (Django ORM) would instead look like the following Python code:
  ```python
  users = Users.objects.filter(zip_code=94107)
  ```
  The ability to write Python code instead of SQL can speed up web application development, especially at the beginning of a project. The potential development speed boost comes from not having to switch from Python code into writing declarative paradigm SQL statements
  
  ORMs also make it theoretically possible to switch an application between various relational databases. For example, a developer could use SQLite for local development and MySQL in production. A production application could be switched from MySQL to PostgreSQL with minimal code modifications. In practice however, it's best to use the same database for local development as is used in production
  
### Do I have to use an ORM for my web application?

- Python ORM libraries are not required for accessing relational databases. In fact, the low-level access is typically provided by another library called a database connector, such as psycopg (for PostgreSQL) or MySQL-python (for MySQL). 

<br>
<Br>

## What are the downsides of using an ORM?

- There are numerous downsides of ORMs, including:
  - Impedance mismatch
  - Potential for reduced performance
  - Shifting complexity from the database into the application code
  
### Impedance Mismatch

- The phrase "impedance mismatch" is commonly used in conjunction with ORMs. Impedance mismatch is a catch-all term for the difficulties that occur when moving data between relational tables and application objects. The gist is that the way a developer uses objects is different from how data is stored and joined in relational tables.

### Potential for Reduced Performance

- One of the concerns that's associated with any higher-level abstraction or framework is potential for reduced performance. With ORMs, the performance hit comes from the translation of application code into a corresponding SQL statement which may not be tuned properly.

- ORMs are also often easy to try but difficult to master. For example, a beginner using Django might not know about the `select_related()` function and how it can improve some queries' foreign key relationship performance. There are dozens of performance tips and tricks for every ORM. It's possible that investing time in learning those quirks may be better spent just learning SQL and how to write stored procedures.

### Shifting complexity from the database into the app code

- The code for working with an application's data has to live somewhere. Before ORMs were common, database stored procedures were used to encapsulate the database logic. With an ORM, the data manipulation code instead lives within the application's Python codebase. The addition of data handling logic in the codebase generally isn't an issue with a sound application design, but it does increase the total amount of Python code instead of splitting code between the application and the database stored procedures.

### Python ORM Implementations

- There are numerous ORM implementations written in Python, including the most used ones:
  - SQLAlchemy
  - Peewee
  - Django's ORM
  - PonyORM
  - SQLObject
  - Tortoise ORM
