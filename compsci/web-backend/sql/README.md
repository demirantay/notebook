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
  
  
  
  
  
  
