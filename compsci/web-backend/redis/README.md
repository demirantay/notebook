# Redis

- Redis is an open source, BSD licensed, advanced key-value store. It is often referred to as a data structure server, since the keys can contain strings, hashes, lists, sets and sorted sets. Redis is written in C. This tutorial provides good understanding on Redis concepts, needed to create and deploy a highly scalable and performance-oriented system.

- Redis is an open source, advanced key-value store and an apt solution for building highperformance, scalable web applications. Redis has three main peculiarities that sets it apart:
  - Redis holds its database entirely in the memory, using the disk only for persistence.
  - Redis has a relatively rich set of data types when compared to many key-value data stores.
  - Redis can replicate data to any number of slaves.
  
- Following are certain advantages of Redis.
  - Exceptionally fast − Redis is very fast and can perform about 110000 SETs per second, about 81000 GETs per second.
  - Supports rich data types − Redis natively supports most of the datatypes that developers already know such as list, set, sorted set, and hashes. This makes it easy to solve a variety of problems as we know which problem can be handled better by which data type.
  - Operations are atomic − All Redis operations are atomic, which ensures that if two clients concurrently access, Redis server will receive the updated value.
  - Multi-utility tool − Redis is a multi-utility tool and can be used in a number of use cases such as caching, messaging-queues (Redis natively supports Publish/Subscribe), any short-lived data in your application, such as web application sessions, web page hit counts, etc.
  
<br>
<br>
<br>

# Environment

- You can start your redis server by:
  ```
  $ redis-server
  ```
  You cana also use the command line interface with:
  ```
  $ redis-cli
  ```
  This will open the command line prompt. Type `ping` and if the app returns `PONG` than redis is working.

### Configuration

- In Redis, there is a configuration file (redis.conf) available at the root directory of Redis. Although you can get and set all Redis configurations by Redis CONFIG command.
  
  Following is the basic sytax of redis CONFIG command:
  ```
  redis 127.0.0.1:6379> CONFIG GET CONFIG_SETTING_NAME
  ```
  Lets see a real world example:
  ```
  redis 127.0.0.1:6379> CONFIG GET loglevel  
  1) "loglevel" 
  2) "notice"
  ```
  
- You can get all of the configurations with:
  ```
  CONFIG GET *  
  ```
  
### Editing Configuration

To update configuration, you can edit `redis.conf` file directly or you can update configurations via `CONFIG set` command. Following is the basic syntax of CONFIG SET command:
  ```
  redis 127.0.0.1:6379> CONFIG SET CONFIG_SETTING_NAME NEW_CONFIG_VALUE
  ```
  Lets see a real world example:
  ```
  redis 127.0.0.1:6379> CONFIG SET loglevel "hello" 
  OK 
  redis 127.0.0.1:6379> CONFIG GET loglevel  
  1) "loglevel" 
  2) "hello" 
  ```
  
<br>
<br>
<br>

# Data Types

- Redis supports 5 types of data types:
 
- 1 - `Strings` : Redis string is a sequence of bytes. Strings in Redis are binary safe, meaning they have a known length not determined by any special terminating characters. Thus, you can store anything up to 512 megabytes in one string.
  ```
  redis 127.0.0.1:6379> SET name "tutorialspoint" 
  ```

- 2 - `Hashes` : A Redis hash is a collection of key value pairs. Redis Hashes are maps between string fields and string values. Hence, they are used to represent objects.
  ```
  redis 127.0.0.1:6379> HMSET user:1 username tutorialspoint password 
  tutorialspoint points 200 
  OK 
  redis 127.0.0.1:6379> HGETALL user:1  
  1) "username" 
  2) "tutorialspoint" 
  3) "password" 
  4) "tutorialspoint" 
  5) "points" 
  6) "200"
  ```
  In the above example, hash data type is used to store the user's object which contains basic information of the user. Here `HMSET`, `HGETALL` are commands for Redis, while `user` − `1` is the key.

- 3 - `Lists` : Redis Lists are simply lists of strings, sorted by insertion order. You can add elements to a Redis List on the head or on the tail.
  ```
  redis 127.0.0.1:6379> lpush tutoriallist redis 
  (integer) 1 
  redis 127.0.0.1:6379> lpush tutoriallist mongodb 
  (integer) 2 
  redis 127.0.0.1:6379> lpush tutoriallist rabitmq 
  (integer) 3 
  redis 127.0.0.1:6379> lrange tutoriallist 0 10  

  1) "rabitmq" 
  2) "mongodb" 
  3) "redis"
  ```

- 4 - `Sets` : Redis Sets are an unordered collection of strings. In Redis, you can add, remove, and test for the existence of members in O(1) time complexity.
  ```
  redis 127.0.0.1:6379> sadd tutoriallist redis 
  (integer) 1 
  redis 127.0.0.1:6379> sadd tutoriallist mongodb 
  (integer) 1 
  redis 127.0.0.1:6379> sadd tutoriallist rabitmq 
  (integer) 1 
  redis 127.0.0.1:6379> sadd tutoriallist rabitmq 
  (integer) 0 
  redis 127.0.0.1:6379> smembers tutoriallist  

  1) "rabitmq" 
  2) "mongodb" 
  3) "redis" 
  ```
   Note − In the above example, rabitmq is added twice, however due to unique property of the set, it is added only once.

  The max number of members in a set is 232 - 1 (4294967295, more than 4 billion of members per set).
  
- 5 - `Sorted Sets` : Redis Sorted Sets are similar to Redis Sets, non-repeating collections of Strings. The difference is, every member of a Sorted Set is associated with a score, that is used in order to take the sorted set ordered, from the smallest to the greatest score. While members are unique, the scores may be repeated.
  ```
  redis 127.0.0.1:6379> zadd tutoriallist 0 redis 
  (integer) 1 
  redis 127.0.0.1:6379> zadd tutoriallist 0 mongodb 
  (integer) 1 
  redis 127.0.0.1:6379> zadd tutoriallist 0 rabitmq 
  (integer) 1 
  redis 127.0.0.1:6379> zadd tutoriallist 0 rabitmq 
  (integer) 0 
  redis 127.0.0.1:6379> ZRANGEBYSCORE tutoriallist 0 1000  

  1) "redis" 
  2) "mongodb" 
  3) "rabitmq" 
  ```
  
<br>
<br>
<br>

# Keys

- Redis key commands are used for managing keys in Redis. Following is the syntax for using redis keys commands.










