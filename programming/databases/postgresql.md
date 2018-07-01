## PostgreSQL

- [Official Documentation](https://www.postgresql.org/docs/9.4/static/index.html)

- PostgreSQL (pronounced as post-gress-Q-L) is an open source relational database management system (DBMS) developed by a worldwide team of volunteers. PostgreSQL is not controlled by any corporation or other private entity and the source code is available free of charge.

- After installing PostgreSQL we can `start` the RDBMS with their GUI application. After starting the application creating a database is as simple as this:
  ```bash
  $ createdb dbname
  ```
  You can also delete databases like this
  ```bash
  $ dropdb dbname
  ```
  
- After you setup everything in order to directly speak with postgreSQL we will use its terminal interface which is called `psql`. You can easily accsess psql with this
  ```bash
  $ psql
  psql (10.1)
  Type "help" for help.

  dbname=# 
  ```
  You can write SQL statements inside while you are inside a database in the postgresql terminal interface.
  ```
  $ psql testdb
  psql (10.1)
  
  testdb=# CREATE TABLE movies (Title TEXT, Year INTEGER);  
  ```
  
- To view all of your tables you can use `\d` and you view a specific table with the `\d table_name`. You can list all tables with additional info with `\d+` and as the same you can use `\d+ table_name`. You can also list all of your databases with `\l`. And quit from psql sheel with `\q` there are many more character encodings refer to the official docs.
  
- Never ever never forget to backup your production database since if there is no backup and the data is deleted there is no coming back. , a backup is simply a full copy of your database schema and data, with restore being the ability to use that backed up data and load it into your database or another database.
  
  You can backup your site with 
  ```bash
  $ pg_dump database_name_here > database.sql
  ```
  The above will create the plaintext dump of your database. To create a form more suitable you a persistent backup and storage you can use either of the below:
  ```bash
  pg_dump -Fc database_name_here > database.bak # compressed binary format
  pg_dump -Ft database_name_here > database.tar # tarball
  ```
  
  When restoring, there are a few more options that you'll want to consider: If the database already exists and The format of your backup
  If your database already exists :
  ```bash
  pg_restore -Fc database.bak # restore compressed binary format
  pg_restore -Ft database.tar # restore tarball
  ```
  However, if you're creating your database new from the restore you'll want to run a command similar to the following:
  ```bash
  pg_restore -Fc -C database.bak # restore compressed binary format
  pg_restore -Ft -C database.tar # restore tarball
  ```
