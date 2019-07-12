## PostgreSQL with Python

- Several libraries exist for connecting to the PostgreSQL database from the Python language. But the best one in 2018 right now is `psycopg2`

- First lets start running our PostgreSQL server and run `$ createdb testdb` in the shell. And after all we can write the following code I will explain below what the code does:
  ```python
  import psycopg2
  
  # Connection variable
  connection = None
  try:
    connection = psycopg2.connect(dbname='testdb', user='testuser', ...)
    cur = connection.cursor()

    # DB sql commands
    cur.execute("CREATE TABLE Cars(Id INTEGER PRIMARY KEY, Name VARCHAR(20), Price INTEGER)")
    cur.execute("INSERT INTO Cars VALUES(1, 'Audi', 54321)")
    cur.execute("INSERT INTO Cars VALUES(2, 'Mercedes', 54321)")
    cur.execute("INSERT INTO Cars VALUES(3,'Skoda',9000)")
    cur.execute("INSERT INTO Cars VALUES(4,'Volvo',29000)")

    # Commit sql code
    connection.commit()
    
  except psycopg2.DatabaseError:
    print("something went wrong")
  ```
  In the above code we first imported the `psycopg2` package and than connected to the database using the package. Than we need to define a cursor and use the `execute()` function of the cursor to execute our SQL. And finally if there is a database error we print a message this can be more advanced I will go into depth later.

- You can do a lot of execute methods and SQL statements with the cursor variable these are the most common ones but there is no point of writing all of them in this notes. Refer to tuorials or offical documentation for more functions.
  ```python
  ...
  cursor.execute("SELECT * FROM Cars")  # first you need to select the table you want
  
  rows = cursor.fetchall()              # gets all the rows and forms a array
  
  for (row in rows):
      if row == None:
            break
      print("id: " + str(row['id']) + "name: " + str(row['name'])
  ```
  
There are lots of more stuff on pyscopg2 library however there is a **Excellent** tutorial by zetcode you can view that also it is highly recommended.

- [ZetCode Tutorial](http://zetcode.com/db/postgresqlpythontutorial/)
- [Psycopg2 Official Docs](http://initd.org/psycopg/)
- [Another Good Tutorial](http://initd.org/psycopg/docs/usage.html)
