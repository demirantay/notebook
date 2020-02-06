# Using Redis with Python

- I am not going to write too much about what `redis` is or how to use it on it's own command line interface becuase I have already done that in other files on this directory. Instead this file is more dedicated towards the use of `redis` with python.

  But lets jump straight in with a small redis-cli and python-redis comparison before getting into the details of the python interface of redis. As you imageine redis stands for remote dictionary service and python already has a built in `dict` data type. Lets use it in this instance:
  ```
  127.0.0.1:6379> SET Bahamas Nassau
  OK
  127.0.0.1:6379> SET Croatia Zagreb
  OK
  127.0.0.1:6379> GET Croatia
  "Zagreb"
  127.0.0.1:6379> GET Japan
  (nil)
  ```
  We created a database that maps the capitals to their countries. This is how you would write it in pure python:
  ```python
  >>> capitals = {}
  >>> capitals["Bahamas"] = "Nassau"
  >>> capitals["Croatia"] = "Zagreb"
  >>> capitals.get("Croatia")
  'Zagreb'
  >>> capitals.get("Japan")  # None
  ```
  
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
  >>> import redis
  >>> r = redis.Redis()
  >>> r.mset({"Croatia": "Zagreb", "Bahamas": "Nassau"})
  True
  >>> r.get("Bahamas")
  b'Nassau'
  ```
  Redis, used in Line 2, is the central class of the package and the workhorse by which you execute (almost) any Redis command. The TCP socket connection and reuse is done for you behind the scenes, and you call Redis commands using methods on the class instance r.
  
  Notice also that the type of the returned object, b'Nassau' in Line 6, is Python’s bytes type, not str. It is bytes rather than str that is the most common return type across redis-py, so you may need to call `r.get("Bahamas").decode("utf-8")` depending on what you want to actually do with the returned bytestring.
  
  Does the code above look familiar? The methods in almost all cases match the name of the Redis command that does the same thing. Here, you called r.mset() and r.get(), which correspond to MSET and GET in the native Redis API.
  
  This also means that HGETALL becomes r.hgetall(), PING becomes r.ping(), and so on. There are a few exceptions, but the rule holds for the large majority of commands.
  
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


