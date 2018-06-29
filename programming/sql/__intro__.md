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
  
  
