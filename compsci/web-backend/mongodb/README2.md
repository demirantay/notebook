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

- In MongoDB a collection is automatically created when it is referenced in any command. For example, if you run an insert command :
  ```javascript
  db.student.insert({
    name: "Viraj"
  })
  ```
  Above command will create a collection named student if it doesn't exist already in the database. But we can explicitly create a collection using the `createCollection()` command:
  ```javascript
  db.createCollection(name, options)
  ```
  In the above command, name will be the name of the collection and options is a document which can be used to specify configurations for the collection.
  
  Options parameter is optional Following are the available configuration options for creating a collection in MongoDB:
    - `capped` (boolean) -- (Optional) To create a capped collection, where in we specify the the maximum size or document counts to prevent it from growing beyond a set maximum value.
    - `size` (number) -- (Optional) To specify the maximum size in bytes for a capped collection. If a collection is capped and reaches its maximum size limit, MongoDB then removes older documents from it to make space for new.
    - `max` (number) -- (Optional) This can be used to specify the maximum number of documents allowed in a capped collection.
    - `validator` (document) -- (Optional) Validates any document inserted or updated against provided validation rules.
    - `validationLevel` (string) -- (Optional) This is used to define how strictly validation rules must be applied to existing documents during an update. Available values are: __off__ , __strict__ , __moderate__
    - `validationAction` (string) -- (Optional) This can be used to set the action to be taken upon validatio 
  

- We can create a capped collection using the following command:
  ```js
  db.createCollection("student", { capped : true, size : 5242880, max : 5000 } )
  ```

### MongoDB: Drop a Collection

- Any collection in a database in MongoDB can be dropped easily using the following command:
  ```js
  db.collection_name.drop()
  ```
  
<Br>
<br>
  
---

<br>
<br>

# CRUD Operations

- CRUD operations refer to the basic Insert, Read, Update and Delete operations (I know we haev seen some of it above like create and delete but lets see it in a orderly fashion here.

### (CREATE) Inserting a document into a collection

- The `command db.collection.insert()` will perform an insert operation into a collection of a document. You must be connected to a database for doing any insert. Let's see a real world example:
  ```js
  db.student.insert({
    regNo: "3014",
    name: "Test Student",
    course: {
      courseName: "MCA",
      duration: "3 Years"
    },
    address: {
      city: "Bangalore",
      state: "KA",
      country: "India"
    }
  })
  ```

### (READ) Querying a document from a collection

- To retrieve (Select) the inserted document, run the below command. The find() command will retrieve all the documents of the given collection.
  ```js
  db.collection_name.find()
  ```
  If a record is to be retrieved based on some criteria, the find() method should be called passing parameters, then the record will be retrieved based on the attributes specified:
  ```js
  db.collection_name.find({"fieldname":"value"})
  ```
  Lets see a real world example based on the created collection above:
  ```js
  db.students.find({"regNo":"3014"})
  ```

### (UPDATE) Updating a document in a collection

- In order to update specific field values of a collection in MongoDB, run the below query:
  ```js
  db.collection_name.update()
  ```
  
  Let us update the attribute name of the collection student for the document with regNo 3014.
  ```js
  db.student.update({
    "regNo": "3014"	
  },
  $set:
  {
    "name":"Viraj"
  })
  ```

### (DELETE) Removing an entry from the collection

- Let us now look into the deleting an entry from a collection. In order to delete an entry from a collection, run the command as shown below:
  ```js
  db.collection_name.remove({"fieldname":"value"})
  ```

<br>
<br>

---

<br>
<br>

# Data Relationships

- Relationships in MongoDB are used to specify how one or more documents are related to each other. In MongoDB, the relationships can be modelled either by Embedded way or by using the Reference approach. These relationships can be of the following forms:
  - One to One
   -One to Many
  - Many to Many
  
- `Embeded Relationships` -- In this approach, one document will be embedded in another document (like a subset).

- `Reference Relationships` -- In this approach, the documents are maintained separately (student and address). But, the student document will have a reference to the address `document id` field. This is basically used for designing normalized relationships. The basic idea behind any NoSQL database is to eliminate the complex relationships between document

### One to One

- Consider a student database of a college, where the college restricts only one course can be availed by the student at a time. So, this is nothing but One to One relationship i.e. a student can be enrolled only to one course at a time. Let us see how this can be modelled.
  ```js
  {
    _id: "3014",
    name: "john doe"
  }
  
  {
    studentId: "3014",
    courseId: "MCA",
    duration: "2 years"
  }
  ```
  The above figure shows that there is student data which has a relationship with the course data. In MongoDB, these 2 collections can be embedded into one as shown below:
  ```js
  {
     _id: "3014",
     name: "john doe",
     course: {
        studentId: "3014",
        courseId: "MCA",
        duration: "2 years"
     }
  }
  ```

### One to Many

- Continuing with the same student database example, consider a student can have more than one address (permanent and current). Let us see how to model such a usecase which is a one to many relationship:
  ```
  {
    _id: "3014",
    name: "john doe",
    addresses: [
        {
          adressId: "addr1",
          street: "123 fake st",
          crity: "dummyton",
          zip: "123123",
        },
        {
          adressId: "addr2",
          street: "321 fake st",
          crity: "dumistan",
          zip: "55555",
        }
    ]
  }
  ```
  With this embedded approach, both the addresses of the student can be retrieved by a single query! (YOu can also use the reference case for it too!)

### Many to Many

- Consider the same student database example, where a student can have different roles like leader, cricket captain, football captain etc. i.e. many roles can be accomplished by students or students can be associated to multiple roles. Let us see how to model this approach which is a many to many relationship.

- Embeded Approach:
  ```js
  {
    id: "3101",
    name: "john doe",
    roles: ["leader", "cricket", "captain", "football"]
  }
  ```
  
- Reference Approach:
  ```js
  {
    id: "3101",
    name: "john doe",
    roles: [<refernece_object_id>, <reference_object_id>]
  }
  ```


