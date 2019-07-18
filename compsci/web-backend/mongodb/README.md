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
  $ mongo
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
 
- MongoDB supports many datatypes. Some of them are :
  - `String` - This is the most commonly used datatype to store the data. String in MongoDB must be UTF-8 valid.
  - `Integer` - This type is used to store a numerical value. Integer can be 32 bit or 64 bit depending upon your server.
  - `Boolean` -  This type is used to store a boolean (true/ false) value.
  - `Double` - This type is used to store floating point values.
  - `Min/ Max keys` - This type is used to compare a value against the lowest and highest BSON elements.
  - `Arrays` - This type is used to store arrays or list or multiple values into one key.
  - `Timestamp` - ctimestamp. This can be handy for recording when a document has been modified or added
  - `Object` - This datatype is used for embedded documents.
  - `Null` - This type is used to store a Null value.
  - `Symbol` - This datatype is used identically to a string; however, it's generally reserved for languages that use a specific symbol type.
  - `Date` - This datatype is used to store the current date or time in UNIX time format. You can specify your own date time by creating object of Date and passing day, month, year into it.
  - `Object ID` - This datatype is used to store the document’s ID.
  - `Binary data` - This datatype is used to store binary data.
  - `Code` - his datatype is used to store JavaScript code into the document.
  - `Regular expression` - This datatype is used to store regular expression.
  
<br>
<br>
<br>

# Insert Document 

- To insert data into MongoDB collection, you need to use MongoDB's insert() or save() method. The basic syntax of insert() command is as follows −
  ```
  >db.COLLECTION_NAME.insert(document)
  ```
  Lets see a real world example:
  ```
  >db.mycol.insert({
     _id: ObjectId(7df78ad8902c),
     title: 'MongoDB Overview', 
     description: 'MongoDB is no sql database',
     by: 'tutorials point',
     url: 'http://www.tutorialspoint.com',
     tags: ['mongodb', 'database', 'NoSQL'],
     likes: 100
  })
  ```
  Here `mycol` is our collection name, as created in the previous chapter. If the collection doesn't exist in the database, then MongoDB will create this collection and then insert a document into it. In the inserted document, if we don't specify the _id parameter, then MongoDB assigns a unique ObjectId for this document. _id is 12 bytes hexadecimal number unique for every document in a collection. 
 
<br>
<br>
<br>

# Query Document

- To query data from MongoDB collection, you need to use MongoDB's find() method. The basic syntax of find() method is as follows −
  ```
  >db.COLLECTION_NAME.find()
  ```
  find() method will display all the documents in a non-structured way.
  
  To display the results in a formatted way, you can use pretty() method.
  ```
  >db.mycol.find().pretty()
  ```
  Apart from find() method, there is findOne() method, that returns only one document.
  
  ### RDBMS Comparisons
  
  To query the document on the basis of some condition, you can use following operations.
  
  |Operation|Syntax|Example|RDBMS|
  |------|-----|------|------|
  |Equality|{key:value}|db.mycol.find({"by":"tutorials point"}).pretty()| WHERE by = 'tutorials point'|
  |Less Than|{key:{$lt:value}}| db.mycol.find({"likes":{$lt:50}}).pretty()| WHERE likes < 50 |
  |Less Than Equals|{key:{$lte:value}}| db.mycol.find({"likes":{$lte:50}}).pretty() | WHERE likes <= 50 |
  |Greater Than|{key:{$gt:value}}|db.mycol.find({"likes":{$gt:50}}).pretty() | WHERE where likes > 50 |
  |...|...|...|...|
  
  There are many more comparisons with `or` and `and` clauses however there is no point of trying to write them here. Just see this document for the list:
    - https://www.tutorialspoint.com/mongodb/mongodb_query_document.htm
    
<br>
<br>
<br>

# Update Document

- MongoDB's update() and save() methods are used to update document into a collection. The update() method updates the values in the existing document while the save() method replaces the existing document with the document passed in save() method. The basic syntax of update() method is as follows −
  ```
  >db.COLLECTION_NAME.update(SELECTION_CRITERIA, UPDATED_DATA)
  ```
  
- Consider the mycol collection has the following data 
  ```
  { "_id" : ObjectId(5983548781331adf45ec5), "title":"MongoDB Overview"}
  { "_id" : ObjectId(5983548781331adf45ec6), "title":"NoSQL Overview"}
  ```
  Following example will set the new title 'New MongoDB Tutorial' of the documents whose title is 'MongoDB Overview'
  ```
  >db.mycol.update({'title':'MongoDB Overview'},{$set:{'title':'I changed the title wubababa'}})
  ```

- The save() method replaces the existing document with the new document passed in the save() method. The basic syntax of MongoDB save() method is shown below −
  ```
  >db.COLLECTION_NAME.save({_id:ObjectId(),NEW_DATA})
  ```
 
<br>
<br>
<br>

# Delete Document

- MongoDB's remove() method is used to remove a document from the collection. remove() method accepts two parameters. One is deletion criteria and second is justOne flag.
  - `deletion criteria` − (Optional) deletion criteria according to documents will be removed.
  - `justOne` − (Optional) if set to true or 1, then remove only one document.

- Basic syntax of remove() method is as follows −
  ```
  >db.COLLECTION_NAME.remove(DELLETION_CRITTERIA)
  ```
  Lets see a real world example:
  ```
  >db.mycol.remove({'title':'MongoDB Overview'})
  ```
  
- If there are multiple records and you want to delete only the first record, then set justOne parameter in remove() method.
  ```
  >db.COLLECTION_NAME.remove(DELETION_CRITERIA,1)
  ```
  
- If you don't specify deletion criteria, then MongoDB will delete whole documents from the collection.
  ```
  >db.mycol.remove({})
  ```
  Removes all documents 
  
<br>
<br>
<br>

# Limit Records 

- To limit the records in MongoDB, you need to use limit() method. The method accepts one number type argument, which is the number of documents that you want to be displayed. The basic syntax of limit() method is as follows −
  ```
  >db.COLLECTION_NAME.find().limit(NUMBER)
  ```
 
- Lets see a real world example. Consider the collection myycol has the following data:
  ```
  { "_id" : ObjectId(5983548781331adf45ec5), "title":"MongoDB Overview"}
  { "_id" : ObjectId(5983548781331adf45ec6), "title":"NoSQL Overview"}
  { "_id" : ObjectId(5983548781331adf45ec7), "title":"Tutorials Point Overview"}
  ```
  Following example will display only two documents while querying the document.
  ```
  >db.mycol.find({},{"title":1,_id:0}).limit(2)
  {"title":"MongoDB Overview"}
  {"title":"NoSQL Overview"}
  ```

- skip() ...

<br>
<br>
<br>

# Sorting Records

...


---

I stopped doing the tutorial at this part :https://www.tutorialspoint.com/mongodb/mongodb_limit_record.htm . After the tutorial the reading list was this:
  - https://realpython.com/introduction-to-mongodb-and-python/ 

---













<br>
<br>
<br>
<br>

---

Since learning MongoDb is not a priority for me at the moment I am not going to write too much notes or at least advacned notes on it. I just wanted to assimilate myself to the techonolgy you can find more info from other soruces. This is a great place to start for advacned mongoDB:
  - https://www.tutorialspoint.com/mongodb/mongodb_relationships.htm
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 