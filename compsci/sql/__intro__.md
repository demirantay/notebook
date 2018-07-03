## SQL

- SQL, or Structured Query Language is the standart language for accessing and manuplating relational databases.

- Before learning sql sytax we should have a mental model of what a realational database actually is A relational database represents a collection of related (two-dimensional) tables. Each of the tables are similar to an Excel spreadsheet, with a fixed number of named columns (the attributes or properties of the table) and any number of rows of data.

  For example lets build a realtional database model for the Department of Motor Vehicles (Table: Vehicles) :
  
  | Id | Make/Model | Wheels | Doors | Type|
  |----|------------|--------|-------|-----| 
  |1| Ford Focus | 4 | 4 | Sedan |
  |2| Kawasaki Ninja | 2 | 0 | Motorcycle |
  |3| McLaren Formula 1| 4 | 0 | Race |
  
  By learning SQL, the goal is to learn how to answer specific questions about this data, like "What types of vehicles are on the road have less than four wheels?", or "How many models of cars does Ford produce?", to help us make better decisions down the road.
  
- To run sql in your web site you need a RDBMS (Relational database management system i.e. MySQL PostgreSQL), a server scripting language like PHP, Python .etc. And html to style your SQL queries. 

- There arent many MAJOR commands in the SQL language but these are the very important ones : `SELECT`, `UPDATE`, `DELETE`, `INSERT`.

### SELECT

- To retrieve data from a SQL database we need to write `Select` statements which are often referred to as `queries`. If we had a very basic table of data the most basic query would be like the following:
  ```sql
  SELECT column, another_column, ...
  FROM my_table;
  ```
  or you can simply use the asterisk symbol like in python to select all columns and rows:
  ```sql 
  SELECT *
  FROM my_table
  ```
  
- Now we know how to select for specific columns of data from a table, but if you had a table with a hundred million rows of data, reading through all the rows would be inefficient and perhaps even impossible. In order to filter certain results from being returned, we need to use a WHERE clause in the query. The clause is applied to each row of data by checking specific column values to determine whether it should be included in the results or not. 
  ```sql
  SELECT column, another_column ...
  FROM my_table 
  WHERE condition
    AND/OR another_condition;
  ```
  You can nest as many `and` and `or`s in your where clause it is up to you to make the condition as complex as possible. (ie. num_wheels >= 4 AND doors <= 2 for the table we built above). The following table consists the most used conditions in sql language:
  
  |Operator|Condition|SQL Example|
  |--------|---------|-----------|
  |=, !=, <, <=, >, >=| Standart numerical operations| col_name =! 4|
  |BETWEEN ..AND..| Number is within range of two values | col_name BETWEEN 4 AND 8 |
  | NOT BETWEEN .. AND ..| Number is *NOT* within range of two vlaues | col_name NOT BETWEEN 1 AND 3 |
  |IN(...)| Number exists in a list| col_name IN (1,3,5) |
  | NOT IN(...)| Number does NOT exitst in a list| col_name NOT IN (2,5,9)|
  
  If we do a example for the DMV table we defined at the top of the page it would look something like this:
  ```sql 
  SELECT * FROM dmv_table
  WHERE wheels > 2; 
  ```
  
- In the real-world unlike it is in these notes the data in the databases are added with no particular order or rules. So in order to select the data and view it efficently SQL provides us these are the following:
  - `DISTINCT`: You can have copies of the same data added twice or more. In order to discard the duplicates you can do the following:
    ```sql
    SELECT DISTINCT column, another_column, …
    FROM mytable
    WHERE condition(s);
    ```
  The discard keyword removes any duplicates of the data, we will come back to these filtering keywords later on it is  just a getting acquinated at the moment.
  - `ORDER BY`: In order to order our rows we can use this keyword with an aceding order or decending.
    ```sql
    SELECT column, another_columnt, ...
    FROM mytable
    WHERE condition(s)
    ORDER BY column ASC/DESC;
    ```
  - `LIMIT` & `OFFSET` : These are the key for optimizing database results to return faster. Reddit, Pinterest .. etc. Front pages use these to get popular posts quickly. I will add this keywords notes later on...
   
  Lets give a example while using the filtering we have met above :
  
  ```sql
  SELECT city, population FROM north_american_cities
  WHERE country="Mexico"
  ORDER BY population DESC
  LIMIT 2;  
  ```
- Up to now we have been using single tables but in the real world most of the data is broken down into many tables and this process is called normalization. Database normalization is useful because it minimizes duplicate data in any single table, and allows for data in the database to grow independently of each other.

  In order to answer questions about an entity that has data spanning multiple tables in a normalized database, we need to learn how to write a query that can combine all that data and pull out exactly the information we need.
  
  Tables that share information about a single entity need to have a primary key that identifies that entity uniquely across the database. One common primary key type is an auto-incrementing integer (because they are space efficient), but it can also be a string, hashed value, so long as it is unique.

  Using the JOIN clause in a query, we can combine row data across two separate tables using this unique key. The first of the joins that we will introduce is the INNER JOIN. See the following:
   ```sql
   SELECT column1, column2
   FROM mytable
   INNER JOIN another_table ON mytable.id=another_table.id
   ...
   ```
   In order to demonstrate it better lets give a example with tha first table being the `Movies` and the second `boxoffice`|
   
   |id|title|year|
   |--|-----|----|
   |1| Intouchables| 2010|
   |2| Burnt| 2014|
   
   |movie_id|rating|sale|
   |--|---|---|
   |1|9.5|500 million|
   |2|6.9|1 million|
   
   If write the following code we can create a new table like the following :
   ```sql 
   SELECT *
   FROM movies
   INNER JOIN boxoffice ON movies.id = boxoffice.movie_id
   ORDER BY id ASC;
   ```
   Creates this new table
   
   |id|title|year|ratings|sale|
   |--|--|--|--|--|
   |1|Intouchabels|2010|9.5|500million|
   |2|Burnt|2014|6.9|1 million|
   
   There are many more join keywords open up the W3 docs for more SQL commands
   
 - Having NULL typed values for your data is bad practice and requires special attention try to avoid it as much as possible. A common way to get around nulls is using defaults values for each column. But NULL values can be appropriate if the default values will skew later analysis (for example, when taking averages of numerical data). You can use null values like the following in querying:
   ```sql
    SELECT column, another_column, …
    FROM mytable
    WHERE column IS/IS NOT NULL
    AND/OR another_condition
    AND/OR …;
   ```
   
- There are many more functions for select as aggreagates and expressions refer to the w3 docs for more info

### INSERT

- We've spent quite a few lessons on how to query for data in a database, so it's time to start learning a bit about SQL schemas and how to add new data.

- When inserting data into a database, we need to use an INSERT statement, which declares which table to write into, the columns of data that we are filling, and one or more rows of data to insert. In general, each row of data you insert should contain values for every corresponding column in the table. You can insert multiple rows at a time by just listing them sequentially.

  ```sql
  INSERT INTO mytable VALUES (value_or_expr, another_value_or_expr, …),
                             (value_or_expr_2, another_value_or_expr_2, …),
                              …;
  ```
  
- In some cases, if you have incomplete data and the table contains columns that support default values, you can insert rows with only the columns of data you have by specifying them explicitly.
  ```sql
  INSERT INTO mytable (column, another_column, …)
  VALUES (value_or_expr, another_value_or_expr, …),
  ```
  In these cases, the number of values need to match the number of columns specified. Despite this being a more verbose statement to write, inserting values this way has the benefit of being forward compatible. For example, if you add a new column to the table with a default value, no hardcoded  INSERT statements will have to change as a result to accommodate that change.
  
### UPDATE

- In addition to adding new data, a common task is to update existing data, which can be done using an UPDATE statement. Similar to the INSERT statement, you have to specify exactly which table, columns, and rows to update. In addition, the data you are updating has to match the data type of the columns in the table schema.
  ```sql 
  UPDATE table_name
  SET column1 = value1, column2 = value2, ...
  WHERE condition;
  ```
  Lets give a real world example, assume that you have a table with customer names cities they live in and you want to change the first customer in the database :
  ```sql
  UPDATE Customers
  SET ContactName = 'Alfred Schmidt', City= 'Frankfurt'
  WHERE CustomerID = 1;
  ```
 
- Most people working with SQL will make mistakes updating data at one point or another. Whether it's updating the wrong set of rows in a production database, or accidentally leaving out the WHERE clause (which causes the update to apply to all rows), you need to be extra careful when constructing UPDATE statements.

### DELETE

- When you need to delete data from a table in the database, you can use a DELETE statement, which describes the table to act on, and the rows of the table to delete through the WHERE clause.
  ```sql
  DELETE FROM mytable
  WHERE condition;
  ```
  If you decide to leave out the WHERE constraint, then all rows are removed, which is a quick and easy way to clear out a table completely (if intentional).
  A real life example :
  ```sql
  DELETE FROM Customers
  WHERE CustomerName='Alfreds Futterkiste' AND CustomerId=1;
  ```
  
- Like the UPDATE statement from last lesson, it's recommended that you run the constraint in a  SELECT query first to ensure that you are removing the right rows. Without a proper backup or test database, it is downright easy to irrevocably remove data, so always read your DELETE statements twice and execute once.

### CREATE TABLE

- When you have new entities and relationships to store in your database, you can create a new database table using the CREATE TABLE statement.
  ```sql
  CREATE TABLE IF NOT EXISTS mytable (
    columnName dataType columnConstraint DEFAULT defaultValue,
    columnName dataType columnConstraint DEFAULT defaultValue,
  );
  ```

- These are the data types for the columns:

  |Data Type | Description|
  |--|--|
  |INTEGER, BOOLEAN| The integer datatypes can store whole integer values like the count of a number or an age. In some implementations, the boolean value is just represented as an integer value of just 0 or 1.|
  | FLOAT, DOUBLE, REAL | The floating point datatypes can store more precise numerical data like measurements or fractional values. Different types can be used depending on the floating point precision required for that value.|
  | CHARACTER(num_chars),  VARCHAR(num_chars), TEXT | The text based datatypes can store strings and text in all sorts of locales. The distinction between the various types generally amount to underlaying efficiency of the database when working with these columns. Both the CHARACTER and VARCHAR (variable character) types are specified with the max number of characters that they can store (longer values may be truncated), so can be more efficient to store and query with big tables.| 
  | DATE, DATETIME | SQL can also store date and time stamps to keep track of time series and event data. They can be tricky to work with especially when manipulating data across timezones. | 
  | BLOB | Finally, SQL can store binary data in blobs right in the database. These values are often opaque to the database, so you usually have to store them with the right metadata to requery them.|
  
  See more data types at the official documentation.
  
- These are the column constraints :

  | Constraint | Description |
  | -- | --|
  | PRIMARY KEY | This means that the values in this column are unique, and each value can be used to identify a single row in this table.|
  |AUTOINCREMENT| For integer values, this means that the value is automatically filled in and incremented with each row insertion. Not supported in all databases.|
  |UNIQUE| This means that the values in this column have to be unique, so you can't insert another row with the same value in this column as another row in the table. Differs from the `PRIMARY KEY` in that it doesn't have to be a key for a row in the table.|
  |NOT NULL|This means that the inserted value can not be `NULL`.|
  | FOREIGN KEY | This is a consistency check which ensures that each value in this column corresponds to another value in a column in another table. For example, if there are two tables, one listing all Employees by ID, and another listing their payroll information, the `FOREIGN KEY` can ensure that every row in the payroll table corresponds to a valid employee in the master Employee list.|
  
  This is not a complete list refer to the official documentation for more constraints

- Here is an example of a real world example:
  ```sql
  CREATE TABLE movies (
    id INTEGER PRIMARY KEY,
    title TEXT,
    director TEXT,
    year INTEGER, 
    length_minutes INTEGER
  );
  ```
  
### ALTER TABLE

- The syntax for adding a new column is similar to the syntax when creating new rows in the  CREATE TABLE statement. You need to specify the data type of the column along with any potential table constraints and default values to be applied to both existing and new rows
  ```sql
  ALTER TABLE mytable
  ADD column DataType OptionalTableConstraint DEFAULT default_value;
  ```
  
- If you need to rename the table itself, you can also do that using the RENAME TO clause of the statement.
  ```sql
  ALTER TABLE mytable
  RENAME TO new_table_name;
  ```
  
- Each RDBMS has their own way of `ALTER`ing existing tables so there is no standart it is best to check out their official docs.

### DROP TABLE

- In some rare cases, you may want to remove an entire table including all of its data and metadata, and to do so, you can use the DROP TABLE statement, which differs from the DELETE statement in that it also removes the table schema from the database entirely.
  ```sql
  DROP TABLE IF EXISTS mytable;
  ```
  Before you drop make sure you have a valid reason since there is no going back
  
  In addition, if you have another table that is dependent on columns in table you are removing (for example, with a FOREIGN KEY dependency) then you will have to either update all dependent tables first to remove the dependent rows or to remove those tables entirely.

...





