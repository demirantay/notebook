# Create and Drop Database in MongoDB

### Creating a Database

- In mongodb you try to connect to an existing database if it does not exist teh mongo server creates it for your:
  ```
  use <database_name>
  ```
  As I said above this will create a new database with the name database_name if there is no database already present with the same name. If a database already exists with the mentioned name, then it just connects to that database.
  
- To check the current connected database, type in:
  ```
  db
  ```

- To see the list of all the databases in MongoDB, use command:
  ```
  show dbs
  ```
  Please note that the newly created dstabase mynewdatabase has not been listed after running the above command. This is because, no records have been inserted into that database yet. In order for databases to be listed they need at least one record. 

### Deleting a Database

- In order to delete(drop) a database do the following:
  ```
  db.DATABASE_NAME.dropDatabase()
  ```
  Or if you are inside the database ith `use <dbname>` you can simply use:
  ```
  db.dropDatabase()
  ```
  without having to designate a databasename to drop.

<br>
<br>

---

<br>
<br>

# Collection Create and Drop

### MongoDB: Creating a Collection

### MongoDB: Creating a Capped Collection

### MongoDB: Drop a Collection
