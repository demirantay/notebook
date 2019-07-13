# SQL

- SQL is a database computer language designed for the retrieval and management of data in a relational database. SQL stands for Structured Query Language. This readme file will give you a quick start to SQL. It covers most of the topics required for a basic understanding of SQL. In the future I will add more advanced notes about SQL

- SQL is a language to operate databases; it includes database creation, deletion, fetching rows, modifying rows, etc. SQL is an ANSI (American National Standards Institute) standard language, but there are many different versions of the SQL language.

- SQL is the standard language for Relational Database System. All the Relational Database Management Systems (RDMS) like MySQL, MS Access, Oracle, Sybase, Informix, Postgres and SQL Server use SQL as their standard database language.

- The most used sql commands are : CREATE, SELECT, INSERT, UPDATE, DELETE and DROP. Buf of course in this note we will go deeper than them, however on a day to day trivial projects you do not need to use anything more.

<br>
<br>
<br>

# RDBMS Concepts

- RDBMS stands for Relational Database Management System. RDBMS is the basis for SQL, and for all modern database systems like MS SQL Server, IBM DB2, Oracle, MySQL, and Microsoft Access.

   A Relational database management system (RDBMS) is a database management system (DBMS) that is based on the relational model as introduced by E. F. Codd. Rlational means mostly links through tables e.g. foreign keys one to one keys ... etc.
   
- The data in an RDBMS is stored in database objects which are called as tables. This table is basically a collection of related data entries and it consists of numerous columns and rows.

  Remember, a table is the most common and simplest form of data storage in a relational database. The following program is an example of a CUSTOMERS table −
  ```sql
  +----+----------+-----+-----------+----------+
  | ID | NAME     | AGE | ADDRESS   | SALARY   |
  +----+----------+-----+-----------+----------+
  |  1 | Ramesh   |  32 | Ahmedabad |  2000.00 |
  |  2 | Khilan   |  25 | Delhi     |  1500.00 |
  |  3 | kaushik  |  23 | Kota      |  2000.00 |
  |  4 | Chaitali |  25 | Mumbai    |  6500.00 |
  +----+----------+-----+-----------+----------+
  ```
  Every table is broken up into smaller entities called fields. The fields in the CUSTOMERS table consist of ID, NAME, AGE, ADDRESS and SALARY. A field is a column in a table that is designed to maintain specific information about every record in the table.
  
  A record is also called as a row of data is each individual entry that exists in a table. For example, there are 4 records in the above CUSTOMERS table. Following is a single row of data or record in the CUSTOMERS table 
  ```sql
  +----+----------+-----+-----------+----------+
  |  1 | Ramesh   |  32 | Ahmedabad |  2000.00 |
  +----+----------+-----+-----------+----------+
  ```
  
  A column is a vertical entity in a table that contains all information associated with a specific field in a table. For example, a column in the CUSTOMERS table is ADDRESS, which represents location description and would be as shown below −
  ```sql
  +-----------+
  | ADDRESS   |
  +-----------+
  | Ahmedabad |
  | Delhi     |
  | Kota      |
  | Mumbai    |
  +----+------+
  ```
  
- A NULL value in a table is a value in a field that appears to be blank, which means a field with a NULL value is a field with no value. It is very important to understand that a NULL value is different than a zero value or a field that contains spaces. A field with a NULL value is the one that has been left blank during a record creation.

### SQL Constraints

- Constraints are the rules enforced on data columns on a table. These are used to limit the type of data that can go into a table. This ensures the accuracy and reliability of the data in the database. Constraints can either be column level or table level

### Database Normalization

- Database normalization is the process of efficiently organizing data in a database. There are two reasons of this normalization process −
   - Eliminating redundant data, for example, storing the same data in more than one table.
   - Ensuring data dependencies make sense.
  
  Both these reasons are worthy goals as they reduce the amount of space a database consumes and ensures that data is logically stored. Normalization consists of a series of guidelines that help guide you in creating a good database structure. Normalization guidelines are divided into normal forms, check out google for more info
  
- *Note: There are many databases e.g. postgres, mysql, oracle, sqlite ... etc. Just choose one that is used by your language or framework ecosystem*
  
<br>
<br>
<br>

# Data Types

- Apart from the most used common data types of SQL such as :`int` `decimal` `float` `char` `text` there are many more. You can see all of them listed in this article in a neatly matter:
   Reosurce: https://www.tutorialspoint.com/sql/sql-data-types.htm
   
<br>
<br>
<br>

# Operators

- An operator is a reserved word or a character used primarily in an SQL statement's WHERE clause to perform operation(s), such as comparisons and arithmetic operations. These Operators are used to specify conditions in an SQL statement and to serve as conjunctions for multiple conditions in a statement. (same with any other language just written in a WHERE instead of an IF

- There are 3 types of operators:
   - Arithmetic Operators:  +, -, /, * ...etc
   - Comparison Operators:  >, >=, <, ==, != ...etc
   - Logical Operators :  AND, OR, BETWEEN ...etc

- See the full list in this document:
   - https://www.tutorialspoint.com/sql/sql-operators.htm
   
<br>
<br>
<br>

# Expressions

-  These SQL EXPRESSIONs are like formulae and they are written in query language. You can also use them to query the database for a specific set of data. Consider the basic syntax of the SELECT statement as follows −
   ```
   SELECT column1, column2, columnN 
   FROM table_name 
   WHERE [CONDITION|EXPRESSION];
   ```
   
<br>
<br>
<br>

# CREATE Database

- The SQL CREATE DATABASE statement is used to create a new SQL database. The basic syntax of this CREATE DATABASE statement is as follows −
   ```sql
   CREATE DATABASE DatabaseName;
   ```
   Always the database name should be unique within the RDBMS. 
   
- Make sure you have the admin privilege before creating any database. Once a database is created, you can check it in the list of databases as follows −
   ```sql
   SHOW DATABASES;
   ```
 
<br>
<br>
<br>

# DROP or DELETE Database

- The SQL DROP DATABASE statement is used to drop an existing database in SQL schema. The basic syntax of DROP DATABASE statement is as follows −
   ```sql
   DROP DATABASE DatabaseName;
   ```

- NOTE − Be careful before using this operation because by deleting an existing database would result in loss of complete information stored in the database. Always know how to backup your databases

<br>
<br>
<br>

# INSERT Query
- The SQL INSERT INTO Statement is used to add new rows of data to a table in the database. There are two basic syntaxes of the INSERT INTO statement which are shown below.
   ```sql
   INSERT INTO TABLE_NAME (column1, column2, column3,...columnN)  
   VALUES (value1, value2, value3,...valueN);
   ```
   or you can use this too:
   ```sql
   INSERT INTO TABLE_NAME VALUES (value1,value2,value3,...valueN);
   ```
   But it is always better to use the first one for security
   
   
- Lets see a real world example:
   ```sql
   INSERT INTO CUSTOMERS (ID,NAME,AGE,ADDRESS,SALARY)
   VALUES (1, 'Ramesh', 32, 'Istanbul', 2000.00 );
   ```
   
- Remember you can populate the table with filtered data with `WHERE` clause you can check google for more info on filtered insertion

<br>
<br>
<br>

# SELECT Query

- The SQL SELECT statement is used to fetch the data from a database table which returns this data in the form of a result table. These result tables are called result-sets. The basic syntax of the SELECT statement is as follows −
   ```sql
   SELECT column1, column2, columnN FROM table_name;
   ```
   Here, column1, column2... are the fields of a table whose values you want to fetch. If you want to fetch all the fields available in the field, then you can use the following syntax.
   ```sql
   SELECT * FROM table_name;
   ```
   
- Lets see an real world example. Consider the CUSTOMERS table having the following records −:
   ```sql
   +----+----------+-----+-----------+----------+
   | ID | NAME     | AGE | ADDRESS   | SALARY   |
   +----+----------+-----+-----------+----------+
   |  1 | Ramesh   |  32 | Ahmedabad |  2000.00 |
   |  2 | Khilan   |  25 | Delhi     |  1500.00 |
   |  3 | kaushik  |  23 | Kota      |  2000.00 |
   +----+----------+-----+-----------+----------+
   ```
   Lets select the following columns:
   ```sql
   SELECT ID, NAME, SALARY FROM CUSTOMERS;
   ```
   This would produce the following result −
   ```
   +----+----------+----------+
   | ID | NAME     | SALARY   |
   +----+----------+----------+
   |  1 | Ramesh   |  2000.00 |
   |  2 | Khilan   |  1500.00 |
   |  3 | kaushik  |  2000.00 |
   +----+----------+----------+
   ```
   
<br>
<br>
<br>

# WHERE Clause

- The SQL WHERE clause is used to specify a condition while fetching the data from a single table or by joining with multiple tables. If the given condition is satisfied, then only it returns a specific value from the table. You should use the WHERE clause to filter the records and fetching only the necessary records.

   The WHERE clause is not only used in the SELECT statement, but it is also used in the UPDATE, DELETE statement, etc., which we would examine in the subsequent chapters. The basic syntax of the SELECT statement with the WHERE clause is as shown below.
   ```sql
   SELECT column1, column2, columnN 
   FROM table_name
   WHERE [condition]
   ```
   
- Consider the CUSTOMERS table having the following records −
   ```sql
   +----+----------+-----+-----------+----------+
   | ID | NAME     | AGE | ADDRESS   | SALARY   |
   +----+----------+-----+-----------+----------+
   |  1 | Ramesh   |  32 | Ahmedabad |  2000.00 |
   |  2 | Khilan   |  25 | Delhi     |  1500.00 |
   |  3 | kaushik  |  23 | Kota      |  2000.00 |
   +----+----------+-----+-----------+----------+
   ```
   The following code is an example which would fetch the ID, Name and Salary fields from the CUSTOMERS table, where the salary is greater than 1800 −
   ```sql
   SELECT ID, NAME, SALARY 
   FROM CUSTOMERS
   WHERE SALARY > 1800;
   ```
   This would produce the following result −
   ```
   +----+----------+----------+
   | ID | NAME     | SALARY   |
   +----+----------+----------+
   |  1 | Ramesh   |  2000.00 |
   |  3 | kaushik  |  2000.00 |
   +----+----------+----------+
   ```

<br>
<br>
<br>

# UPDATE Query
 
- The SQL UPDATE Query is used to modify the existing records in a table. You can use the WHERE clause with the UPDATE query to update the selected rows, otherwise all the rows would be affected. The basic syntax of the UPDATE query with a WHERE clause is as follows −
   ```sql
   UPDATE table_name
   SET column1 = value1, column2 = value2...., columnN = valueN
   WHERE [condition];
   ```

- Consider the CUSTOMERS table having the following records −
   ```sql
   +----+----------+-----+-----------+----------+
   | ID | NAME     | AGE | ADDRESS   | SALARY   |
   +----+----------+-----+-----------+----------+
   |  1 | Ramesh   |  32 | Ahmedabad |  2000.00 |
   |  2 | Khilan   |  25 | Delhi     |  1500.00 |
   |  3 | kaushik  |  23 | Kota      |  2000.00 |
   +----+----------+-----+-----------+----------+
   ```
   The following query will update the ADDRESS for a customer whose ID number is 1 in the table.
   ```sql
   UPDATE CUSTOMERS
   SET ADDRESS = 'Pune'
   WHERE ID = 1;
   ```
   
 - If you want to modify all the ADDRESS and the SALARY column values in the CUSTOMERS table, you do not need to use the WHERE clause as the UPDATE query would be enough as shown in the following code block.
   ```sql
   UPDATE CUSTOMERS
   SET ADDRESS = 'Pune', SALARY = 1000.00;
   ```
   This would change all rows int the column 
   
<br>
<br>
<br>

# DELETE Query

- The SQL DELETE Query is used to delete the existing records from a table. You can use the WHERE clause with a DELETE query to delete the selected rows, otherwise all the records would be deleted. The basic syntax of the DELETE query with the WHERE clause is as follows -
   ```sql
   DELETE FROM table_name
   WHERE [condition];
   ```
   
- Consider the CUSTOMERS table having the following records −
   ```sql
   +----+----------+-----+-----------+----------+
   | ID | NAME     | AGE | ADDRESS   | SALARY   |
   +----+----------+-----+-----------+----------+
   |  1 | Ramesh   |  32 | Ahmedabad |  2000.00 |
   |  2 | Khilan   |  25 | Delhi     |  1500.00 |
   |  3 | kaushik  |  23 | Kota      |  2000.00 |
   +----+----------+-----+-----------+----------+
   ```
   The following code has a query, which will DELETE a customer, whose ID is 1:
   ```sql
   DELETE FROM CUSTOMERS
   WHERE ID = 1;
   ```
   
- If you want to DELETE all the records from the CUSTOMERS table, you do not need to use the WHERE clause and the DELETE query would be as follows −
   ```sql
   DELETE FROM CUSTOMERS;
   ```
   This deletes all rows but not the table
   
   
<br>
<br>
<br>

# LIKE Clause
 
 







  
  
  
  
  
