# Indexing in MongoDB

- Indexes in SQL programming are nothing but a special data structure used to easily and quickly locate the record in a given table of the database without being required to traverse through each and every record of the table. Indexes are easily generated using one or more columns of a given table. As a note, the data structure used by an index is a Binary Tree (B-Tree).

  In MongoDB, indexes plays a vital role in efficiently execution of the queries. Basically, if no index is defined in MongoDB, then it has to scan every document of a given collection. Hence, MongoDB uses index to reduce the number of documents to be scanned in a given collection. In fact, MongoDB's index is more or less similar to the indexes used in other relational databases.
  
- `Default Index of MangoDB` -- Mongodb provides a default index named `_id` which acts as a primary key to access any document in a collection. This _id index basically avoids the insertion of 2 documents with the same value for the _id field.

- To create an index in MongoDB, run the following command :
  ```js
  db.collection_name.createIndex({field : value })
  ```
  Lets see a real world exmample and give a register number to a collection:
  ```js
  db.student.createIndex({registerNo : 1})
  ```
  
- Types of indexes in MongoDB:
  
  | Index Type | Description |
  | -- | --| 
  | Single Field Types | Used to create an index on a single field and it can be a user defined as well apart from the default _id one |
  | Compound Index | MongoDB supports the user-defined indexes on multiple fields. |
  | Multi key index | MongoDB uses multi key indexes basically to store the arrays. MongoDB creates a separate index for each element in an array. MongoDB intelligently identifies to create a multi key index if the index contains elements from an array. |
  | Geospatial index | Used to support the queries required for the geospatial coordinate data. |
  | Text index | This index is used to search for a string content in a collection | 
  | Hashed index | Used for hash based Sharding | 
  
<br>
<br>

---

<br>
<br>

# Sorting Records

- Sorting the data in any database is one of the vital operations in any database management system. MongoDB provides sort() function in order to sort the data in a collection.  Sort function in MongoDB accepts a list of values and an integer value 1 or -1 which states whether the collection to be sorted in ascending (1) or descending (-1) order:
  ```js
  db.collection_name.find().sort({KEY : 1}) 
  ```
  > NOTE: If you do not specify the sorting preference(i.e 1 or -1), then by default documents in a collection are sorted in ascending order.
  
<br>
<br>

# Aggregation Functions

- Aggregation in MongoDB is nothing but an operation used to process the data that returns the computed results. Aggregation basically groups the data from multiple documents and operates in many ways on those grouped data in order to return one combined result. In sql `count(*`) and with `group by` is an equivalent of MongoDB aggregation.

  Aggregate function groups the records in a collection, and can be used to provide total number(sum), average, minimum, maximum etc out of the group selected.
  
  Following is the syntax for aggregation :
  ```js
  db.collection_name.aggregate(aggregate_operation)
  ```
  You can read more herE: https://www.studytonight.com/mongodb/aggregation-in-mongodb about aggregation in mongoDB
  
<br>
<Br>

---

<br>
<br>

# Data Backup and Restoration in MongoDB

- Data backup is one of the vital and highly required process for any database management system. The primary reason being is that it is difficult to anticipate how and when the data can be lost. So it is an ideal and best practice that whenever a database is setup, we need to ensure that it has a provision for the data backup in case of any loss events happens.

  A backup is nothing but the copy of data from the database which helps in reusing the database in case of any catastrophic event happens to the data.
  
  In order to perform a data backup process in mongodb, the command mongodump should be used. In order to properly perform the data backup, follow the below mentioned instructions:
  - 1 - Start the mongodb server with the command `mongod`
  - 2 - Start the mongodb client with the command `mongo` in a new command prompt.
  - 3 - Switch to the required collection and run the command `mongodump`. 
  - 4 - From the above screenshot observer that all the data from the collection <dbname> has been dumped.
  
  Mongodump basically reads the data from the database and creates a BSON file in which the data is dumped. Mongodump writes only documents from the database. The resultant backup of the data will be of the space efficient. The backup of the data will be stored under the mongodb's bin\dump folder
  
- Now let us learn how to restore the backup data in mongodb. Data backup is basically used to reconstruct the data in case of a loss event. MongoDB helps to restore the backup data through its one of the utility tools called `mongorestore` which in turn is a command as well.

<br>
<br>

---

<br>
<br>

# Sharding

- Sharding is the mechanism of storing data across multiple machines. The basic principle of this feature of MongoDB is to support the data growth which is expected any application. Because, at one point of time the accessibility of any application will definitely result in increase of the data growth and it would be difficult to accommodate such a growth of data

  Considering the data growth which is really difficult to manage in a single system, it is an ideal way to have a cluster containing the replica set of the data. Hence, a horizontal scaling of the data is required and sharding does this in MongoDB. Sharding in simple just adds more machines to handle the sudden or rapid growth of data in an application.
    
