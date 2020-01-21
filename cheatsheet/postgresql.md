## PostgreSQL Cheatsheet

### Psql: Posgres Command Line Interface

- `psql` -- opens up the postgresql command line interface
- `psql -U [username]` -- Access the PostgreSQL server from psql with a specific user
- `\c [database_name]` -- Connect to a specific database
- `\q` -- To quit the psql
- `\l` -- List all databases in the PostgreSQL database server
- `\dt` -- Lists all tables in a current database
- `\dt+` -- Or to get more information on tables in the current database
- `\dt+ [tablename]` -- Get detailed information on a specific table
- `\dn` --  List all schemas
- `\di` -- list indexes
- `\df` -- List all stored procedures and functions
- `\dv` -- List all views
- `\df+ [func_name]` -- Show a stored procedure or function code
- `\x` -- Show query output in the pretty-format:
- `\du` -- List all users

### Querying Data From a Table

- `SELECT c1, c2 FROM t;` -- Query data in columns c1, c2 from a table
- `SELECT * FROM t;` -- Query all rows and columns from a table
- `SELECT c1, c2 FROM t WHERE condition;` -- Query data and filter rows with a condition
- `SELECT DISTINCT c1 FROM t WHERE condition;` -- Query distinct rows from a table
- `SELECT c1, c2 FROM t ORDER BY c1 ASC [DESC];` -- Sort the result set in ascending or descending order
- `SELECT c1, c2 FROM t ORDER BY c1 LIMIT n OFFSET offset;` -- Skip offset of rows and return the next n rows 
- `SELECT c1, aggregate(c2) FROM t GROUP BY c1;` -- Group rows using an aggregate function
- `SELECT c1, aggregate(c2) FROM t GROUP BY c1 HAVING condition;` -- Filter groups using HAVING clause

### Querying From Multiple Tables

- `SELECT c1, c2 FROM t1 INNER JOIN t2 ON condition;` -- Inner join t1 and t2
- `SELECT c1, c2 FROM t1 LEFT JOIN t2 ON condition;` -- Left join t1 and t1
- `SELECT c1, c2 FROM t1 RIGHT JOIN t2 ON condition;` -- Right join t1 and t2
- `SELECT c1, c2 FROM t1 FULL OUTER JOIN t2 ON condition;` -- Perform full outer join
- `SELECT c1, c2 FROM t1 CROSS JOIN t2;` -- Produce a Cartesian product of rows in tables
- `SELECT c1, c2 FROM t1, t2;` -- Another way to perform cross join
- `SELECT c1, c2 FROM t1 A INNER JOIN t2 B ON condition;` -- Join t1 to itself using INNER JOIN clause

### Using SQL Operators

- `SELECT c1, c2 FROM t1 UNION [ALL] SELECT c1, c2 FROM t2;` -- Combine rows from two queries
- `SELECT c1, c2 FROM t1 INTERSECT SELECT c1, c2 FROM t2;` -- Return the intersection of two queries
- `SELECT c1, c2 FROM t1 EXCEPT SELECT c1, c2 FROM t2;` -- Subtract a result set from another result set
- `SELECT c1, c2 FROM t1 WHERE c1 [NOT] LIKE pattern;` -- Query rows using pattern matching %, _
- `SELECT c1, c2 FROM t WHERE c1 [NOT] IN value_list;` -- Query rows in a list
- `SELECT c1, c2 FROM t WHERE c1 BETWEEN low AND high;` -- Query rows between two values
- `SELECT c1, c2 FROM t WHERE c1 IS [NOT] NULL;` -- Check if values in a table is NULL or not

### Managing Tables

### Using SQL Constraints

### Modifying Data

### Managing Views

### Managing Indexes

### Managing Triggers

