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

# SELECT Database 

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




 
 
 
 
 
 







  
  
  
  
  
