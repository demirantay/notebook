# MongoDB

- MongoDB is an open-source document database and leading NoSQL database. MongoDB is written in C++. This tutorial will give you great understanding on MongoDB concepts needed to create and deploy a highly scalable and performance-oriented database.
  
  MongoDB is a cross-platform, document oriented database that provides, high performance, high availability, and easy scalability. MongoDB works on concept of collection and document.
  
- `Database`: Database is a physical container for collections. Each database gets its own set of files on the file system. A single MongoDB server typically has multiple databases.

- `Collection`: Collection is a group of MongoDB documents. It is the equivalent of an RDBMS table. A collection exists within a single database. Collections do not enforce a schema. Documents within a collection can have different fields. Typically, all documents in a collection are of similar or related purpose.

- `Document`: A document is a set of key-value pairs. Documents have dynamic schema. Dynamic schema means that documents in the same collection do not need to have the same set of fields or structure, and common fields in a collection's documents may hold different types of data.

- The following table shows the relationship of RDBMS terminology with MongoDB.

  |RDBMS | MongodDB|
  |---|---|
  |Database|Database|
  |Table|Collection|
  |Row|Document|
  |Column|Field|
  |Table Join| Embedded Documents|
  | Primary Key| Primary Key|
  
  
- After downloading you can use mongoDb with this command:
  ```
  $ mongod --config /usr/local/etc/mongod.conf
  ```
  
  <br>
  <br>
  <br>
  
  # Advantages
  
 - Any relational database has a typical schema design that shows number of tables and the relationship between these tables. While in MongoDB, there is no concept of relationship.
 
- Advantages of MongoDB over RDBMS:
  - Schema less − MongoDB is a document database in which one collection holds different documents. Number of fields, content and size of the document can differ from one document to another.
  - Structure of a single object is clear.
  - No complex joins.
  - Deep query-ability. MongoDB supports dynamic queries on documents using a document-based query language that's nearly as powerful as SQL
  - Ease of scale-out − MongoDB is easy to scale
  - Uses internal memory for storing the (windowed) working set, enabling faster access of data
  
- Where to use MongoDB:
  - Big Data
  - Content Management and Delivery
  - Mobile and Social Infrastructure
  - User Data Management
  - Data Hub
  
 <br>
 <br>
 <br>
 
 # Data Modeling 
 
 - Data in MongoDB has a flexible schema.documents in the same collection. They do not need to have the same set of fields or structure, and common fields in a collection’s documents may hold different types of data.
 
 - Considerations while designing schema in mongoDB:
    - Design your schema according to user requirements.
    - Otherwise separate them (but make sure there should not be need of joins).
    - Duplicate the data (but limited) because disk space is cheap as compare to compute time.
    - Do joins while write, not on read.
    - Optimize your schema for most frequent use cases.
    - Do complex aggregation in the schema.

  
  
  <br>
  <br>
  <br>
  
  # Create Database 
  
  - MongoDB `use DATABASE_NAME` is used to create database. The command will create a new database if it doesn't exist, otherwise it will return the existing database.
  
    Basic syntax of use DATABASE statement is as follows −
    ```json
    use DATABASE_NAME
    ```
    To check your currently selected database, use the command `db`
    ```json
    >db
    ```
    If you want to check your databases list, use the command `show dbs`
    ```json
    show dbs
    ```
    
<br>
<br>
<br>
  
# Drop Database

- MongoDB db.dropDatabase() command is used to drop a existing database
  ```
  db.dropDatabase()
  ```
  This will delete the selected database. If you have not selected any database, then it will delete default 'test' database.
  
<br>
<br>
<br>
 
 # Create Collection
 
- MongoDB db.createCollection(name, options) is used to create collection.
  ```
  db.createCollection(name, options)
  ```
  In the command, `name` is name of collection to be created. `Options` is a document and is used to specify configuration of collection. `name` is a string and the `options` parameter is optional so actually you just need to define a name to your collection.
  
- Here is the list of `options` you can use:
  - `capped` - (boolean) - (Optional) If true, enables a capped collection. Capped collection is a fixed size collection that automatically overwrites its oldest entries when it reaches its maximum size. If you specify true, you need to specify size parameter also.
  - `autoIndexId` - (boolean) - (Optional) If true, automatically create index on _id field.s Default value is false.
  - `size` - (number) - (Optional) Specifies a maximum size in bytes for a capped collection. If capped is true, then you need to specify this field also.
  - `max` - (number) - (Optional) Specifies the maximum number of documents allowed in the capped collection.
 
- Basic syntax of createCollection() method without options is as follows −
  ```
  >use test
  switched to db test
  >db.createCollection("mycollection")
  { "ok" : 1 }
  >
  ```
  You can check the created collection by using the command `show collections`.
  ```
  >show collections
  ```
  
- The following example shows the syntax of createCollection() method with few important options −
  ```
  >db.createCollection("mycol", { capped : true, autoIndexId : true, size : 
     6142800, max : 10000 } )
  { "ok" : 1 }
  ```

<br>
<br>
<br>

# Drop Collection

- MongoDB's db.collection.drop() is used to drop a collection from the database.
  ```
  db.COLLECTION_NAME.drop()
  ```
  Lets see a real world example:
  ```
  >use mydb
  switched to db mydb
  db.collectionName.drop()
  true
  ```
  
<br>
<br>
<br>

# Data Types
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
