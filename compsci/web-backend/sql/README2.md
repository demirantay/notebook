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
  - NOT NULL
  - DEFAULT
  - UNIQUE
  - PRIMARY Key
  - FOREIGN Key
  - CHECK
  - INDEX
  
  Lets view all of them more specifically, (You can always drop constraints remember! (check docs for more info)
  
  ### NOT NULL
  








