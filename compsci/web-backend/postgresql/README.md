---

Note: I will not note most of the PostgreSQL since it jsut basically teaches you SQL. You can view my [SQL notes here](https://github.com/demirantay/notebook/tree/master/compsci/web-backend/sql) . I will mostly note the little tweaks I need to learn for using PostgreSQL

---

<br>

# PostgreSQL

- PostgreSQL is a powerful, open source object-relational database system. It has more than 15 years of active development and a proven architecture that has earned it a strong reputation for reliability, data integrity, and correctness

- PostgreSQL (pronounced as post-gress-Q-L) is an open source relational database management system (DBMS) developed by a worldwide team of volunteers. PostgreSQL is not controlled by any corporation or other private entity and the source code is available free of charge.

- PostgreSQL supports a large part of the SQL standard and offers many modern features including the following −
  - Complex SQL queries
  - SQL Sub-selects
  - Foreign keys
  - Trigger
  - Views
  - Transactions
  - Multiversion concurrency control (MVCC)
  - Streaming Replication (as of 9.0)
  - Hot Standby (as of 9.0)
  
- PostgreSQL can be extended by the user in many ways. For example by adding new −
  - Data types
  - Functions
  - Operators
  - Aggregate functions
  - Index methods
  
- After you have downloaded PostgreSQL you can open the CLI with this command:
  ```
  $ psql
  ```
  
<br>
<br>
<br>

# PSQL Commands

- You can check avialbae databases listing using `\l`:
  ```
  postgres-# \l
  ```
  You can use this command to connect/select a desired database
  ```
  postgres-# \c dbname;
  ```
  To exit from a database you can use `\q`:
  ```
  postgres-# \q
  ```
  
- You can verify if your table has been created successfully using \d command, which will be used to list down all the tables in an attached database.
  ```
  postgres-# \d
  ```
  Use \d tablename to describe each table with its layout −
  ```
  testdb-# \d tablename
  ```
  
<br>
<br>
<br>

# Creating/Dropping Database

- Ofcourse you can always use SQL's `CREATE DATABASe dbname` but postgres provides us their own command too:
  ```
  $ createdb name 
  ```
  You can give parameters add pasword make it limited to local ... etc. Go check out the docs. But before you do that you can start by reading this:
    - https://www.tutorialspoint.com/postgresql/postgresql_create_database.htm
    
- Again you can use SQLS `DROP DATABASE dbname` but postgres provides us their own command for this too:
  ```
  $ dropdb name
  ```
  You can give parameters to this command too before you visit official docs you start reading from here:
    - https://www.tutorialspoint.com/postgresql/postgresql_drop_database.htm
    
    
<br>
<br>
<br>

# Schemas

- I am tired now just start reading from here schemas are important dont skip it:
  - https://www.tutorialspoint.com/postgresql/postgresql_schema.htm
  
<br>
<br>
<br>



  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
