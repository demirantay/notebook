# Using MongoDB with Python

- Now that we’ve described what MongoDB is exactly, let’s find out how you’d actually use it with Python. The official driver published by the Mongo developers is called PyMongo. For more information please check out the official documentation of PyMongo. First let's install it:
  ```
  $ pip install pymongo
  ```
  > you have to have mongodb installed on your local machine
  
### Establishing a Connection

- To establish a connection we’ll use the MongoClient object.

  The first thing that we need to do in order to establish a connection is import the MongoClient class. We’ll use this to communicate with the running database instance
  ```python
  from pymongo import MongoClient
  client = MongoClient()
  ```
  the connection will be established to the default host (localhost) and port (27017). You can also specify the host and/or port using:
  ```python
  client = MongoClient('localhost', 27017)
  ```
  Or just use the Mongo URI format:
  ```python
  client = MongoClient('mongodb://localhost:27017')
  ```

### Accessing Databases

- Once you have a connected instance of MongoClient, you can access any of the databases within that Mongo server. To specify which database you actually want to use, you can access it as an attribute:
  ```python
  db = client.<dbname>
  ```
  Or you can also use the dictionary-style access:
  ```python
  db = client['dbname']
  ```
  if you dont have a database dont worry mongo creates a database automatically if does not exist

### (CREATE) Inserting Documents

- YOu fist create the dcument you want to insertinto your collection and then insert it:
  ```python
  test_db = db.test
  
  data = {
    title: "title",
    date: "12 jan 2019"
  }
  
  insertion = test_db.insert_one(data)
  ```
  We can even insert many documents at a time, which is much faster than using insert_one() if you have many documents to add to the database. The method to use here is insert_many(). This method takes an array of document data:
  ```python
  post_1 = {
      'title': 'Python and MongoDB',
      'content': 'PyMongo is fun, you guys',
      'author': 'Scott'
  }
  post_2 = {
      'title': 'Virtual Environments',
      'content': 'Use virtual environments, you guys',
      'author': 'Scott'
  }
  post_3 = {
      'title': 'Learning Python',
      'content': 'Learn Python, it is easy',
      'author': 'Bill'
  }
  new_result = posts.insert_many([post_1, post_2, post_3])
  ```

### (READE) Retrieving Documents

- To retrieve a document, we’ll use the find_one() method. The lone argument that we’ll use here (although it supports many more) is a dictionary that contains fields to match. Lets use the second example given above:
  ```python
  bills_post = posts.find_one({'author': 'Bill'})
  ```
  
  If we want to find more than one document, we can use the find() method. This time, let’s find all of the posts written by Scott:
  ```python
  scotts_posts = posts.find({'author': 'Scott'})    # this gets 2 
  
  # Read below for why 
  # we are doing this
  for post in scotts_posts:
    print(post)
  ```
  The main difference here is that the document data isn’t returned directly to us as an array. Instead we get an instance of the Cursor object. This Cursor is an iterable object that contains quite a few helper methods to help you work with the data. To get each document, just iterate over the result:

### (UPDATE) Updating Documents

- ...

### (DELETE) Deleting Documents

- foo

  ```
  db.collection.remove()
  ```

<br>
<br>

---

<br>
<br>

# MongoEngine

- While PyMongo is very easy to use and overall a great library, it’s probably a bit too low-level for many projects out there. Put another way, you’ll have to write a lot of your own code to consistently save, retrieve, and delete objects.

  One library that provides a higher abstraction on top of PyMongo is MongoEngine. MongoEngine is an object document mapper (ODM), which is roughly equivalent to a SQL-based object relational mapper (ORM)
  
  > I am skipping this for now since I like dealing with low-level code. If I want an mapper or a higher abstraction I can always re read it. Start with this tutoirial: 
    - https://realpython.com/introduction-to-mongodb-and-python/#mongoengine
