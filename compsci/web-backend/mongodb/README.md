# MongoDB

- My notes taken from the studytonight.com 

<br>
<br>

# Introduction to NoSQL

- NoSQL, as many of you may already know, is basically a database used to manage huge sets of unstructured data, where in the data is not stored in tabular relations like relational databases. Most of the currently existing Relational Databases have failed in solving some of the complex modern problems like :
  - Continuosly changing nature of data - structured, semi-structured, unstructured and polymorphic data.
  - Applications now serve millions of users in different geo-locations, in different timezones and have to be up and running all the time, with data integrity maintained
  - Applications are becoming more distributed with many moving towards cloud computing
  
  NoSQL plays a vital role in an enterprise application which needs to access and analyze a massive set of data that is being made available on multiple virtual servers (remote based) in the cloud infrastructure and mainly when the data set is not structured. Hence, the NoSQL database is designed to overcome the Performance, Scalability, Data Modelling and Distribution limitations that are seen in the Relational Databases.
  
- `What is Structured Data?` -- Structured data is usually text files, with defined column titles and data in rows. Such data can easily be visulaized in form of charts and can be processed using data mining tools.

- `What is Unstructured Data?` -- Unstructured data can be anything like video file, image file, PDF, Emails etc. What does these files have in common, nothing. Structured Information can be extracted from unstructured data, but the process is time consuming

### NoSQL Database Types

- Following are the NoSQL database types :
  - `Document Databases` : In this type, key is paired with a complex data structure called as Document. Example : MongoDB
  - `Graph stores` : This type of database is ususally used to store networked data. Where in we can relate data based on some existing data.
  - `Key-Value stores` : These are the simplest NoSQL databases. In this each is stored with a key to identify it. In some Key-value databases, we can even save the typr of the data saved along, like in Redis.
  - `Wide-column stores` : Used to store large data sets(store columns of data together). Example : Cassandra(Used in Facebook), HBase etc.

### Some Advantages of NoSQL Databases

- `Dynamic Schemas` -- You must be wondering what does dynamic schema means? In Relational Databases like Oracle, MySQL we define table structures, right? For example, if we want to save records of Student Data, then we will have to create a table named Student, add columns to it, like student_id, student_name etc, this is called defined schema, where in we define the structure before saving any data.

  If in future we plan to add some more related data in our Student table, then we will have to add a new column to our table. Which is easy, if we have less data in our tables, but what if we have millions of records. Migration to the updated schema would be a hectic job. NoSQL databases solve this problem, as in a NoSQL database, schema definition is not required.

- `Sharding` -- In Sharding, large databases are partitioned into small, faster and easily manageable databases.

  The (classic) Relational Databases follow a vertical architecture where in a single server holds the data, as all the data is related. Relational Databases does not provide Sharding feature by default, to achieve this a lot of efforts has to be put in
  NoSQL Databases have the Sharding feature as default. No additional efforts required. They automatically spread the data across servers, fetch the data in the fastest time from the server which is free

- `Replication` -- Auto data replication is also supported in NoSQL databases by default. Hence, if one DB server goes down, data is restored using its copy created on another server in network

- `Integrated Caching` -- Many NoSQL databases have support for Integrated Caching, where in the frequently demanded data is stored in cache to make the queries fater.

### MongoDB - NoSQL Database

- MongoDB is a NoSQL database written in C++ language. Some of its drivers use the C programming language as the base. MongoDB is a document oriented database where it stores data in collections instead of tables. The best part of MongoDB is that the drivers are available for almost all the popular programming languages.

<br>
<Br>

---

<br>
<Br>

# Introduction to MongoDB

- MongoDB is a NoSQL database which stores the data in form of key-value pairs. It is an Open Source, Document Database which provides high performance and scalability along with data modelling and data management of huge sets of data in an enterprise application.

### What is Document based storage?

- A Document is nothing but a data structure with name-value pairs like in JSON. It is very easy to map any custom Object of any programming language with a MongoDB Document. For example :
  ```python
  {
    name : "Stduytonight",
    rollno : 1,
    subjects : ["C Language", "C++", "Core Java"]
  }
  ```

### Key Features of MongoDB

- Apart from most of the NoSQL default features, MongoDB does bring in some more, very important and useful features :
  - 1 - MongoDB provides high performance. Input/Output operations are lesser than relational databases due to support of embedded documents(data models) and Select queries are also faster as Indexes in MongoDB supports faster queries.
  - 2 - MongoDB has a rich Query Language, supporting all the major CRUD operations. The Query Language also provides good Text Search and Aggregation features.
  - 3 - Auto Replication feature of MongoDB leads to High Availability. It provides an automatic failover mechanism, as data is restored through backup(replica) copy if server fails.
  - 4 - Sharding is a major feature of MongoDB. Horizontal Scalability is possible due to sharding.

<br>
<br>

---

<Br>
<br>

# Overview of MongoDB

- MongoDB consists of a set of databases. Each database again consists of Collections. Data in MongoDB is stored in collections. Database in MongoDB is nothing but a container for collections.

- `Collections` -- Collection is nothing but a set of MongoDB documents. These documents are equivalent to the row of data in tables in RDBMS. But, collections in MongoDB do not relate to any set schema as compared to RDBMS. But for reference you ca think collections as tables.
  
  You must be wondering why create multiple collections with different namespace, when we can keep any form or data in a single collection itself. It's because, MongoDB does not index attributes for totally unrelated documents. So it is advised to keep related data in collections.

- `Documents` -- Document in MongoDB is nothing but the set of key-value pairs. These documents will have dynamic schema which means that the documents in the same collection do not need to possess the same set of fields.

  Since MongoDB is considered as a schema-less database, each collection can hold different type of objects. Every object in a collection is known as Document, which is represented in a JSON like (JavaScript Object Notation) structure(nothing but a list of key-value pair). Data is stored and queried in BSON, its binary representation of JSON-like data.
  
  Example:
  ```javascript
  { _id : 112233,
    name : "Viraj",
    education : [
             {
                year : 2029,
                course : "BTECH",
                college : "IIT, Delhi"
              },
             {
                year : 2031,
                course : "MS",
                college : "Harvard College"
             }
    ]
  }
  ```
  
<br>
<br>

---

<br>
<br>

# MongoDB vs SQL Databases

- It is a well known fact that SQL databases have ruled the world of data technologies and have been the primary source of data storage for over 4 decades. Generally the SQL databases are used, mainly for accessing relational databases.
  
  Soon enough data started growing exponentially and scalability became a major issue, at that time NoSQL rolled in to save the day. One of the cool facts about NoSQL databases is that they existed since 1960, but in the recent times they have gained more popularity especially for the scaling feature provided by the same.
  
  Let us see some of the key differences between MongoDB and other SQL databases :
  
  | SQL Databases | NoSQL Database (MongoDB) |
  | -- | --|
  | Relational database | Non-relational database |
  | Supports SQL query language | Supports JSON query language |
  | Table based | Collection based and key-value pair |
  | Row based | Document based |
  | Column based | 	Field based |
  | Support foreign key | No support for foreign key |
  | Support for triggers | No Support for triggers |
  | Contains schema which is predefined | Contains dynamic schema |
  | Not fit for hierarchical data storage | Best fit for hierarchical data storage |
  | Vertically scalable - increasing RAM | Horizontally scalable - add more servers | 
  | Emphasizes on ACID properties (Atomicity, Consistency, Isolation and Durability) | Emphasizes on CAP theorem (Consistency, Availability and Partition tolerance) |

> First and foremost, MongoDB is not a replacement for any traditional RDMS databases. They both have their pros and cons, choose repsectively based on the requirements of your project.

<br>
<br>

---

<br>
<Br>

# Data Modelling in MongoDB

- As explained in the earlier lessons, data in MongoDB is schema-less, which means there is no need of defining a structure for the data before insertion. Since, MongoDB is a document based database, any document within the same collection is not mandatory to have same set of fields or structure]

  In general, the documents in a collection of MongoDB will always share the same data structure(recommended for best performance, not mandatory)
  
  The vital factor or challenge in modelling the data in a given database is load balancing and hence ensuring the performance aspect effectively. It is a mandate while modelling the data to consider the complete usage of data (CRUD operations) along with how the data will be inherited as well.
  
  There are 2 ways in which the relationships between the data can be established in MongoDB:
    - `Reference Documents` 
    - `Embeded Documents` 
    
### Reference Documents

- This is one of the ways to implement the relationship between data stored in different collections. In this, a reference to the data in one collection will be used in connecting the data between the collections:
  ```javascript
  {
    title: "Java in action",
    author: "author1",
    language: "English",
    publisher: {
               name: "My publications",
               founded:1990,
               location: "SF"
              }
  }

  {
    title: "Hibernate in action",
    author: "author2",
    language: "English",
    publisher: {
               name: "My publications",
               founded:1990,
               location: "SF"
              }
  }
  ```
  In the above example, the publisher data is repeated. In order to avoid this repetition, we can add references of the book to the publisher data instead of using entire data of publisher in every book entry, as shown below:
  ```javascript
  {
    name: "My Publciations",
    founded:1980,
    location: "CA",
    books: [111222333,444555666, ..]
  }

  {
     _id:111222333,
     title: "Java in action",
     author: "author1",
     language: "English"
  }

  {
    _id:444555666,
    title: "Hibernate in action",
    author: "author2",
    language: "English"
  }
  ```
  This can be done the other way round as well, where in one can reference the `publisher id` in the books data, your choice.

### Embeded Documents

- In this, one collection will be embedded into another collection. Consider 2 collections student and address. Let us see how the `address` can be embedded into `student` collection. Below is an example embedding single address to student data.
  ```javascript
  {
  _id:123,
  name: "Student1"
  }

  {
    _studentId:123,
    street: "123 Street",
    city: "Bangalore",
    state: "KA"
  }

  {
    _studentId:123,
    street: "456 Street",
    city: "Punjab",
    state: "HR"
  }
  ```

<br>
<br>

---

<br>
<br>

# Data Types in MongoDB

- MongoDB supports the below list of datatypes. Each datatype in MongoDB possess a unique number:
  
  | Datatype | Number | Description |
  | -- | -- | -- |
  | Double |	1	 | Used to stored floating point values |
  | String |	2	 | Commonly used datatype and it is UTF-8 valid |
  | Object |	3 |	Used for storing embedded objects |
  | Array	| 4	| Used for storing embedded objects |
  | Binary Data | 5 |	Used to store binary data |
  | Undefined |	6	| Used to store undefined value |
  | Object Id |	7 |	Used to store document's ID |
  | Boolean |	9	| Used to store Boolean value |
  | Date | 10 |	Used to store current date time in UNIX format. |
  | Null | 11 |	Used to store null value |
  | Regular Expression | 12 |	Used to store regex |
  | Javascript | 13 |	Used to store JavaScript data without scope |
  | Symbol | 14 |	Basically used to store string, but reserved for languages that use specific symbol |
  | Javascript with scope |	15 | Used to store JavaScript data with scope |
  | Integer	| 16 & 18 |	Used to store numerical value |
  | Timestamp |	10 | Used to track when a document is modified. |
  | Min/Max Key |	255/127 |	Used to compare value against lowest and highest BSON elements |
  
<br>
<br>

---

<br>
<br>


  
  
  
  
