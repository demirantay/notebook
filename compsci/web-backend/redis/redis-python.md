# Using Redis with Python

- I am not going to write too much about what `redis` is or how to use it on it's own command line interface becuase I have already done that in other files on this directory. Instead this file is more dedicated towards the use of `redis` with python.

<br>
<br>

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
  
- First, like always lets start with a hello world :) 
  ```python
  import redis
  
  r = redis.Redis()
  
  r.mset({"foo": "Hello world", "bar", 5})
  
  r.get("foo")  # gets b("hello world")
  ```
  Redis, used in Line 2, is the central class of the package and the workhorse by which you execute (almost) any Redis command. The TCP socket connection and reuse is done for you behind the scenes, and you call Redis commands using methods on the class instance r.
  
  Also note that when you `get` a value from the set it returns a `bytestring` rather than a plain old string. If you want to do operations on your returned value don't forget to change the type.
  
  We built the Redis instance `r` above with no arguments, but it comes bundled with a number of parameters if you need them:
  ```python
  # From redis/client.py
  class Redis(object):
      def __init__(self, host='localhost', port=6379,
                   db=0, password=None, socket_timeout=None,
                   # ..
  ```
  
<br>
<br>
<br>

# Allowed Key Types

- One thing that’s worth knowing is that redis-py requires that you pass it keys that are bytes, str, int, or float. (It will convert the last 3 of these types to bytes before sending them off to the server.)
  
  So remember that if you want to add a different value to your keys:"value" do not forget to convert into the variable types above. But you can only use `strings` for your keys
  
<br>
<br>
<br>

# Important Note

So as you have figured out rigth now there is not much to learn for the redis-py package because most of the stuff you actually learn is realted to the REDIS and I have already written it's functions and their definitions in my redis specific note files. In order to use redis with python you just need to figure out how to write the "redis functions" in the python syntax.

TLDR just checkout the translations of redis commands to --> python-sytanxly written redis commands. The logic is same so it is enough to learn for the redis-py package.

<br>
<br>
<br>

---

<br>

At the moment I do not know where to use Redis other than trivial to-do apps. Once I need to use it for real I will learn it fully and add more notes on it.

For example serilazation, crypotgrahy, pipelining are very important topics that I want to touch in the future to reach the full potential of redis.
