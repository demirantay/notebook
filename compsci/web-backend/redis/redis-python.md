# Using Redis with Python

- I am not going to write too much about what `redis` is or how to use it on it's own command line interface becuase I have already done that in other files on this directory. Instead this file is more dedicated towards the use of `redis` with python.

# Redis in Python

- Now that you’ve mastered some basics of Redis, it’s time to jump into `redis-py`, the Python client that lets you talk to Redis from a user-friendly Python API.
  
  redis-py is a well-established Python client library that lets you talk to a Redis server directly through Python calls. Install it with:
  ```
  pip install redis
  ```
  Next, make sure that your Redis server is still up and running in the background. 
  ```
  $ redis-server
  ```
