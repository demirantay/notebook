[PART 1](./README.md)

---

<br>

# GROUP BY

- The SQL GROUP BY clause is used in collaboration with the SELECT statement to arrange identical data into groups. This GROUP BY clause follows the WHERE clause in a SELECT statement and precedes the ORDER BY clause.
  
  The basic syntax of a GROUP BY clause is shown in the following code block. The GROUP BY clause must follow the conditions in the WHERE clause and must precede the ORDER BY clause if one is used.
  ```sql
  SELECT column1, column2
  FROM table_name
  WHERE [ conditions ]
  GROUP BY column1, column2
  ORDER BY column1, column2
  ```
  
- Consider the CUSTOMERS table is having the following records −
  ```sql
  +----+----------+-----+-----------+----------+
  | ID | NAME     | AGE | ADDRESS   | SALARY   |
  +----+----------+-----+-----------+----------+
  |  1 | Ramesh   |  32 | Ahmedabad |  2000.00 |
  |  2 | Khilan   |  25 | Delhi     |  1500.00 |
  |  3 | kaushik  |  23 | Kota      |  2000.00 |
  +----+----------+-----+-----------+----------+
  ```
  If you want to know the total amount of the salary on each customer, then the GROUP BY query would be as follows.
  ```sql
  SELECT NAME, SUM(SALARY) FROM CUSTOMERS
   GROUP BY NAME;
  ```
 
- I am not going to too much detail about this Clause. You can see a very good detailed tutorial on here:
  - https://www.tutorialspoint.com/sql/sql-group-by.htm
  
<br>
<br>
<br>

# DISTINCT

- The SQL DISTINCT keyword is used in conjunction with the SELECT statement to eliminate all the duplicate records and fetching only unique records.

  There may be a situation when you have multiple duplicate records in a table. While fetching such records, it makes more sense to fetch only those unique records instead of fetching duplicate records.  
  
- The basic syntax of DISTINCT keyword to eliminate the duplicate records is as follows −
  ```sql
  SELECT DISTINCT column1, column2,.....columnN 
  FROM table_name
  WHERE [condition]
  ```

- See this tutorial document to have a better understanding i am lazy to write more notes on how to use it:
  - https://www.tutorialspoint.com/sql/sql-distinct-keyword.htm
  
<br>
<br>
<br>

# Constraints

- Constraints are the rules enforced on the data columns of a table. These are used to limit the type of data that can go into a table. This ensures the accuracy and reliability of the data in the database. Constraints could be either on a column level or a table level. The column level constraints are applied only to one column, whereas the table level constraints are applied to the whole table.

- Following are some of the most commonly used constraints available in SQL. (There are much more you can check the docs):
  - `NOT NULL` - Ensures that a column cannot have NULL value.
  - `DEFAULT` -  Provides a default value for a column when none is specified.
  - `UNIQUE` - Ensures that all values in a column are different.
  - `PRIMARY Key` - Uniquely identifies each row/record in a database table.
  - `FOREIGN Key` - Uniquely identifies a row/record in any of the given database table.
  - `CHECK` - The CHECK constraint ensures that all the values in a column satisfies certain conditions
  - `INDEX` - Used to create and retrieve data from the database very quickly.
  
  You can use this link https://www.tutorialspoint.com/sql/sql-constraints.htm to see more info on each most used constraints however you can always use other resoruces
  
- You can drop constraints! Do not forgot that, you can find how to do it in the link provided above.

<br>
<br>
<br>

# Using Joins

- The SQL Joins clause is used to combine records from two or more tables in a database. A JOIN is a means for combining fields from two tables by using values common to each:

  Table 1 − CUSTOMERS Table:
  ```sql
  +----+----------+-----+-----------+----------+
  | ID | NAME     | AGE | ADDRESS   | SALARY   |
  +----+----------+-----+-----------+----------+
  |  1 | Ramesh   |  32 | Ahmedabad |  2000.00 |
  |  2 | Khilan   |  25 | Delhi     |  1500.00 |
  |  3 | kaushik  |  23 | Kota      |  2000.00 |
  +----+----------+-----+-----------+----------+
  ```
  ORDERS Table
  ```sql
  +-----+---------------------+-------------+--------+
  |OID  | DATE                | CUSTOMER_ID | AMOUNT |
  +-----+---------------------+-------------+--------+
  | 102 | 2009-10-08 00:00:00 |           3 |   3000 |
  | 100 | 2009-10-08 00:00:00 |           3 |   1500 |
  +-----+---------------------+-------------+--------+
  ```
  Now, let us join these two tables in our SELECT statement as shown below.
  ```sql
  SELECT ID, NAME, AGE, AMOUNT
  FROM CUSTOMERS, ORDERS
  WHERE  CUSTOMERS.ID = ORDERS.CUSTOMER_ID;
  ```
  Here, it is noticeable that the join is performed in the WHERE clause. Several operators can be used to join tables, such as =, <, >, <>, <=, >=, !=, BETWEEN, LIKE, and NOT; they can all be used to join tables. However, the most common operator is the equal to symbol.
  
- There are different type of `joins` available in SQL such as `right join`, `inner join`, `self join` ... etc. Im not going to note all of them here you can see all of them neatly documented in this tutorial:
  - https://www.tutorialspoint.com/sql/sql-using-joins.htm
  
<br>
<br>
<br>

# Unions Clause

I am too lazy at the moment to write notes about this -- just read this document again :
  - https://www.tutorialspoint.com/sql/sql-unions-clause.htm
  
<br>
<br>
<br>

# NULL Values

- The SQL NULL is the term used to represent a missing value. A NULL value in a table is a value in a field that appears to be blank. A field with a NULL value is a field with no value. It is very important to understand that a NULL value is different than a zero value or a field that contains spaces.

  The basic syntax of NULL while creating a table:
  ```sql
  REATE TABLE CUSTOMERS(
     ID   INT              NOT NULL,
     NAME VARCHAR (20)     NOT NULL,
     AGE  INT              NOT NULL,
     ADDRESS  CHAR (25) ,
     SALARY   DECIMAL (18, 2),       
     PRIMARY KEY (ID)
  );
  ```
  Here, NOT NULL signifies that column should always accept an explicit value of the given data type. There are two columns where we did not use NOT NULL, which means these columns could be NULL.
  
- While comparing data NULL calues can cause troubles with control statements that is why you must use the IS NULL or IS NOT NULL operators to check for a NULL value.

<br>
<br>
<br>

# Alias 

- You can rename a table or a column temporarily by giving another name known as Alias. The use of table aliases is to rename a table in a specific SQL statement. The renaming is a temporary change and the actual table name does not change in the database. The column aliases are used to rename a table's columns for the purpose of a particular SQL query.

  The basic syntax of a table alias is as follows.
  ```sql
  SELECT column1, column2....
  FROM table_name AS alias_name
  WHERE [condition];
  ```
  The basic syntax of a column alias is as follows.
  ```sql
  SELECT column_name AS alias_name
  FROM table_name
  WHERE [condition];
  ```
  
- See this link it has a real world example of how Aliases are used:
  - https://www.tutorialspoint.com/sql/sql-alias-syntax.htm
  
<br>
<br>
<br>

# Indexes 

- Indexes are special lookup tables that the database search engine can use to speed up data retrieval. Simply put, an index is a pointer to data in a table. An index in a database is very similar to an index in the back of a book.

  An index helps to speed up SELECT queries and WHERE clauses, but it slows down data input, with the UPDATE and the INSERT statements. Indexes can be created or dropped with no effect on the data.
  
  Creating an index involves the CREATE INDEX statement, which allows you to name the index, to specify the table and which column or columns to index, and to indicate whether the index is in an ascending or descending order.
  
  The basic syntax of a CREATE INDEX is as follows.
  ```sql
  CREATE INDEX index_name ON table_name;
  ```
  
- A `single-column index` is created based on only one table column. The basic syntax is as follows.
  ```sq
  CREATE INDEX index_name
  ON table_name (column_name);
  ```
  
- `Unique indexes` are used not only for performance, but also for data integrity. A unique index does not allow any duplicate values to be inserted into the table. The basic syntax is as follows.
  ```sql
  CREATE UNIQUE INDEX index_name
  on table_name (column_name);
  ```
  
- A `composite index` is an index on two or more columns of a table. Its basic syntax is as follows.
  ```sql
  CREATE INDEX index_name
  on table_name (column1, column2);
  ```
  
- You can drop indexes with this command:
  ```sql
  DROP INDEX index_name;
  ```
  
### When should indexes be avoided ?

- You should avoid using them when:
  - Indexes should not be used on small tables.
  - Tables that have frequent, large batch updates or insert operations.
  - Indexes should not be used on columns that contain a high number of NULL values.
  - Columns that are frequently manipulated should not be indexed.
  
- You can see official docs for more info on this chapter

<br>
<br>
<br>

# ALTER TABLE Command

- The SQL ALTER TABLE command is used to add, delete or modify columns in an existing table. You should also use the ALTER TABLE command to add and drop various constraints on an existing table. The basic syntax of an ALTER TABLE command to add a New Column in an existing table is as follows:
  ```sql
  ALTER TABLE table_name ADD column_name datatype;
  ```
  The basic syntax of an ALTER TABLE command to DROP COLUMN in an existing table is as follows.
  ```sql
  ALTER TABLE table_name DROP COLUMN column_name;
  ```
  The basic syntax of an ALTER TABLE command to change the DATA TYPE of a column in a table is as follows.
  ```sql
  ALTER TABLE table_name MODIFY COLUMN column_name datatype;
  ```
  The basic syntax of an ALTER TABLE command to add a NOT NULL constraint to a column in a table is as follows.
  ```sql
  ALTER TABLE table_name MODIFY column_name datatype NOT NULL;
  ```
  The basic syntax of ALTER TABLE to ADD UNIQUE CONSTRAINT to a table is as follows.
  ```sql
  ALTER TABLE table_name 
  ADD CONSTRAINT MyUniqueConstraint UNIQUE(column1, column2...);
  ```
  ...
  
- You can view all of the altering list, and a real world example in this link:
  - https://www.tutorialspoint.com/sql/sql-alter-command.htm
  
<br>
<br>
<br>

# TRUNCATE TABLE Command

- The SQL TRUNCATE TABLE command is used to delete complete data from an existing table. You can also use DROP TABLE command to delete complete table but it would remove complete table structure form the database and you would need to re-create this table once again if you wish you store some data.

  The basic syntax of a TRUNCATE TABLE command is as follows.
  ```sql
  TRUNCATE TABLE  table_name;
  ```
  
<br>
<br>
<br>

# Using Views

- A view is nothing more than a SQL statement that is stored in the database with an associated name. A view is actually a composition of a table in the form of a predefined SQL query. 

  A view can contain all rows of a table or select rows from a table. A view can be created from one or many tables which depends on the written SQL query to create a view.
  
  Views, which are a type of virtual tables allow users to do the following −
    - Structure data in a way that users or classes of users find natural or intuitive.
    - Restrict access to the data in such a way that a user can see and (sometimes) modify exactly what they need and no more.
    - Summarize data from various tables which can be used to generate reports.
    
- This document is too long to summarize in here, so if you want to have more info you can start reading from here:
  - https://www.tutorialspoint.com/sql/sql-using-views.htm
  
<br>
<br>
<br>

# Transactions

- A transaction is a unit of work that is performed against a database. Transactions are units or sequences of work accomplished in a logical order, whether in a manual fashion by a user or automatically by some sort of a database program

  A transaction is the propagation of one or more changes to the database. For example, if you are creating a record or updating a record or deleting a record from the table, then you are performing a transaction on that table. It is important to control these transactions to ensure the data integrity and to handle database errors.
  
  Practically, you will club many SQL queries into a group and you will execute all of them together as a part of a transaction.

- Transactions have the following four standard properties, usually referred to by the acronym ACID:
  - `Atomicity` - nsures that all operations within the work unit are completed successfully. Otherwise, the transaction is aborted at the point of failure and all the previous operations are rolled back to their former state.
  - `Consistency` - ensures that the database properly changes states upon a successfully committed transaction.
  - `Isolation` - enables transactions to operate independently of and transparent to each other
  - `Durability` - ensures that the result or effect of a committed transaction persists in case of a system failure.
  
- Transaction Controls:
  - COMMIT − to save the changes.
  - ROLLBACK − to roll back the changes.
  - SAVEPOINT − creates points within the groups of transactions in which to ROLLBACK.
  - SET TRANSACTION − Places a name on a transaction
  
- I am tired right now I will just leave a link for how they are implemented in the sql code. You can start reading from here:
  - https://www.tutorialspoint.com/sql/sql-transactions.htm
  
<br>
<br>
<br>

# Wildcards











  
  

  








