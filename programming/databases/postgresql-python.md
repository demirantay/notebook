## PostgreSQL with Python

- Several libraries exist for connecting to the PostgreSQL database from the Python language. But the best one in 2018 right now is `psycopg2`

- First lets start running our PostgreSQL server and run `$ createdb testdb` in the shell. And after all we can write the following code I will explain below what the code does:
  ```python
  import psycopg2
  
  # Connection variable
  conn = psycopg2.connect()
  ```
