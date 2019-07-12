## Databases

- A database is an abstraction over operating system's file system that makes it easier for developers to build applications that create, read, update and delete data.

- Why are databases necessary? At a high level web applications store data and present it to users in a useful way. For example, Google stores data about roads and provides directions to get from one location to another by driving through the Maps application. Driving directions are possible because the data is stored in a structured format.

  Databases make structured storage reliable and fast. They also give you a mental framework for how the data should be saved and retrieved instead of having to figure out what to do with the data every time you build a new application.
  
- Most of the databases gets categorized in to two. One is relation databases such as MySQL, PostgreSQL ... etc. and others are no-SQL databases such as MangoDB, Redis ... etc.

### Relational Databases

- The database storage abstraction mostly commonly used in python web development is sets of relational tables. Relational databases store data in a series of tables. Interconnections between the tables are specified as `foreign keys`. A foreign key is a unique reference from one row in a relational table to another row in a table, which can be the same table but is most commonly a different table.

- Typically web applications start with a single database instance such as PostgreSQL with a straightforward schema. Over time the database schema evolves to a more complex structure using schema migrations and advanced features such as replication, sharding and monitoring become more useful as database utilization increases based on the application users' needs.

- `PostgreSQ`L and `MySQL` are two of the most common open source databases for storing Python web applications' data.
  
  SQLite is a database that is stored in a single file on disk. SQLite is built into Python but is only built for access by a single connection at a time. Therefore is highly recommended to not run a production web application with SQLite.
  
- Object-relational mappers (ORMs) allow developers to access data from a backend by writing Python code instead of SQL queries. Each web application framework handles integrating ORMs differently. There's an [entire page on object-relational mapping (ORMs)](https://www.fullstackpython.com/object-relational-mappers-orms.html) that you should read to get a handle on this subject.

### NoSQL Databases

- NoSQL databases are not supposed to be better than relational databaseses they were esentially created to handle unstructured data sets. They are used to store the vast majority of web applications persistent data. However there are many several classifications for storage representations such as: 
  - Key-Value Pair      (redis ..etc)
  - Document-oriented   (mongoDB ..etc.)
  - Column-family table (Cassandra .etc.)
  - Graph               (Neo4j etc.)
  
### More Resources

- [FullStack-Python: Databases] section has great resources at the end of the page.
