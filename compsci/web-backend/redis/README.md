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

- Redis key commands are used for managing keys in Redis. Following is the syntax for using redis keys commands. The sytax is like this:
  ```
  redis 127.0.0.1:6379> COMMAND KEY_NAME
  ```
  Lets see a real world example:
  ```
  redis 127.0.0.1:6379> SET tutorialspoint redis 
  OK 
  redis 127.0.0.1:6379> DEL tutorialspoint 
  (integer) 1
  ```
  In the above example, `DEL` is the command, while `tutorialspoint` is the key. If the key is deleted, then the output of the command will be (integer) 1, otherwise it will be (integer) 0.
  
- Following points list some basic commands related to keys. You can visit it each to get a real world usage and a tutorial:
  - [DEL key](https://www.tutorialspoint.com/redis/keys_del.htm): This command deletes the key, if it exists.
  - [DUMP key](https://www.tutorialspoint.com/redis/keys_dump.htm) : This command returns a serialized version of the value stored at the specified key.
  - [EXISTS key](https://www.tutorialspoint.com/redis/keys_exists.htm) : This command checks whether the key exists or not.
  - [EXPIRE key second](https://www.tutorialspoint.com/redis/keys_expire.htm) : Sets the expiry of the key after the specified time.
  - [EXPIREAT key timestamp](https://www.tutorialspoint.com/redis/keys_expireat.htm) : Sets the expiry of the key after the specified time. Here time is in Unix timestamp format. 
  - [PEXPIREAT key milliseconds-timestamp](https://www.tutorialspoint.com/redis/keys_pexpire.htm) : Sets the expiry of the key in Unix timestamp specified as milliseconds.
  - [KEYS pattern](https://www.tutorialspoint.com/redis/keys_keys.htm) : Finds all keys matching the specified pattern.
  - [MOVE key db](https://www.tutorialspoint.com/redis/keys_move.htm) : Moves a key to another database
  - [PERSIST key](https://www.tutorialspoint.com/redis/keys_persist.htm) : Removes the expiration from the key. 
  - [PTTL key](https://www.tutorialspoint.com/redis/keys_pttl.htm) : Gets the remaining time in keys expiry in milliseconds.
  - [TTL key](https://www.tutorialspoint.com/redis/keys_ttl.htm) : Gets the remaining time in keys expiry.
  - [RANDOMKEY](https://www.tutorialspoint.com/redis/keys_randomkey.htm) : Returns a random key from Redis.
  - [RENAME key newkey](https://www.tutorialspoint.com/redis/keys_rename.htm) : Changes the key name.
  - [RENAMENX key newkey](https://www.tutorialspoint.com/redis/keys_renamenx.htm) : Renames the key, if a new key doesn't exist.
  - [TYPE key](https://www.tutorialspoint.com/redis/keys_type.htm) : Returns the data type of the value stored in the key.

<br>
<br>
<br>

# Strings 

- As we discussed erlier Redis strings commands are used for managing string values in Redis. Following is the syntax for using Redis string commands. Lets see en example again:
  ```
  redis 127.0.0.1:6379> SET tutorialspoint redis 
  OK 
  redis 127.0.0.1:6379> GET tutorialspoint 
  "redis" 
  ```
  In the above example, `SET` and `GET` are the commands, while `tutorialspoint` is the key.
  
- Just like I listed the key commands that you can use int he above section there are commands that you can use with strings, however it would take a lot of space to list them here. Instead visit the link below and at the bottom you will see a list table with tutorial to each command:
  - https://www.tutorialspoint.com/redis/redis_strings.htm
  
<br>
<br>
<br>

# Hashes

- As we discuessed erlier Redis Hashes are maps between the string fields and the string values. Hence, they are the perfect data type to represent objects.

  In Redis, every hash can store up to more than 4 billion field-value pairs. Let see an example:
  ```
  redis 127.0.0.1:6379> HMSET tutorialspoint name "redis tutorial" 
  description "redis basic commands for caching" likes 20 visitors 23000 
  OK 
  redis 127.0.0.1:6379> HGETALL tutorialspoint  
  1) "name" 
  2) "redis tutorial" 
  3) "description" 
  4) "redis basic commands for caching" 
  5) "likes" 
  6) "20" 
  7) "visitors" 
  8) "23000"
  ```
  In the above example, we have set Redis tutorials detail (name, description, likes, visitors) in hash named ‘tutorialspoint’.

- Just like I listed the key commands that you can use in the `key`s section there are commands that you can use with `hashes`, however it would take a lot of space to list them here. Instead visit the link below and at the bottom you will see a list table with tutorial to each command:
  - https://www.tutorialspoint.com/redis/redis_hashes.htm
  
<br>
<br>
<br>
  
# Lists

- Redis Lists are simply lists of strings, sorted by insertion order. You can add elements in Redis lists in the head or the tail of the list.

  Maximum length of a list is 232 - 1 elements (4294967295, more than 4 billion of elements per list). Lets see an example:
  ```
  redis 127.0.0.1:6379> LPUSH tutorials redis 
  (integer) 1 
  redis 127.0.0.1:6379> LPUSH tutorials mongodb 
  (integer) 2 
  redis 127.0.0.1:6379> LPUSH tutorials mysql 
  (integer) 3 
  redis 127.0.0.1:6379> LRANGE tutorials 0 10  
  1) "mysql" 
  2) "mongodb" 
  3) "redis"
  ```
  In the above example, three values are inserted in Redis list named ‘tutorials’ by the command `LPUSH`.
  
- Just like I listed the key commands that you can use in the `key`s section there are commands that you can use with `lists`, however it would take a lot of space to list them here. Instead visit the link below and at the bottom you will see a list table with tutorial to each command:
  - https://www.tutorialspoint.com/redis/redis_lists.htm
  
<br>
<br>
<br>

# Sets

- Redis Sets are an unordered collection of unique strings. Unique means sets does not allow repetition of data in a key.

  In Redis set add, remove, and test for the existence of members in O(1) (constant time regardless of the number of elements contained inside the Set). The maximum length of a list is 232 - 1 elements (4294967295, more than 4 billion of elements per set). Lets see an exapmle:
  ```
  redis 127.0.0.1:6379> SADD tutorials redis 
  (integer) 1 
  redis 127.0.0.1:6379> SADD tutorials mongodb 
  (integer) 1 
  redis 127.0.0.1:6379> SADD tutorials mysql 
  (integer) 1 
  redis 127.0.0.1:6379> SADD tutorials mysql 
  (integer) 0 
  redis 127.0.0.1:6379> SMEMBERS tutorials  
  1) "mysql" 
  2) "mongodb" 
  3) "redis"
  ```
  In the above example, three values are inserted in Redis set named ‘tutorials’ by the command `SADD`.
  
- Just like I listed the key commands that you can use in the `key`s section there are commands that you can use with `sets`, however it would take a lot of space to list them here. Instead visit the link below and at the bottom you will see a list table with tutorial to each command:
  - https://www.tutorialspoint.com/redis/redis_sets.htm 
  
<br>
<br>
<br>

# Sorted Sets

- Redis Sorted Sets are similar to Redis Sets with the unique feature of values stored in a set. The difference is, every member of a Sorted Set is associated with a score, that is used in order to take the sorted set ordered, from the smallest to the greatest score. Lets see a real world example:
  ```
  redis 127.0.0.1:6379> ZADD tutorials 1 redis 
  (integer) 1 
  redis 127.0.0.1:6379> ZADD tutorials 2 mongodb 
  (integer) 1 
  redis 127.0.0.1:6379> ZADD tutorials 3 mysql 
  (integer) 1 
  redis 127.0.0.1:6379> ZADD tutorials 3 mysql 
  (integer) 0 
  redis 127.0.0.1:6379> ZADD tutorials 4 mysql 
  (integer) 0 
  redis 127.0.0.1:6379> ZRANGE tutorials 0 10 WITHSCORES  
  1) "redis" 
  2) "1" 
  3) "mongodb" 
  4) "2" 
  5) "mysql" 
  6) "4" 
  ```
  In the above example, three values are inserted with its score in Redis sorted set named ‘tutorials’ by the command `ZADD`.

- Just like I listed the key commands that you can use in the `key`s section there are commands that you can use with `sorted sets`, however it would take a lot of space to list them here. Instead visit the link below and at the bottom you will see a list table with tutorial to each command:
  - https://www.tutorialspoint.com/redis/redis_sorted_sets.htm
  
<br>
<br>
<br>

# HyperLogLog
  
- Redis HyperLogLog is an algorithm that uses randomization in order to provide an approximation of the number of unique elements in a set using just a constant, and small amount of memory.

- Following example explains how Redis HyperLogLog works.
  ```
  redis 127.0.0.1:6379> PFADD tutorials "redis"  
  1) (integer) 1  
  redis 127.0.0.1:6379> PFADD tutorials "mongodb"  
  1) (integer) 1  
  redis 127.0.0.1:6379> PFADD tutorials "mysql"  
  1) (integer) 1  
  redis 127.0.0.1:6379> PFCOUNT tutorials  
  (integer) 3 
  ```
  
- Note: I didnt understand hyperloglog a lot. You can use this tutorial as a starter point:
  - https://www.tutorialspoint.com/redis/redis_hyperloglog.htm
  
<br>
<br>
<br>

# Publish Subscribe

- Redis Pub/Sub implements the messaging system where the senders (in redis terminology called publishers) sends the messages while the receivers (subscribers) receive them. The link by which the messages are transferred is called `channel`. In Redis, a client can subscribe any number of channels

- Following example explains how publish subscriber concept works. In the following example, one client subscribes a channel named ‘redisChat’.
  ```
  redis 127.0.0.1:6379> SUBSCRIBE redisChat  
  Reading messages... (press Ctrl-C to quit) 
  1) "subscribe" 
  2) "redisChat" 
  3) (integer) 1 
  ```
  Now, two clients are publishing the messages on the same channel named ‘redisChat’ and the above subscribed client is receiving messages.
  ```
  redis 127.0.0.1:6379> PUBLISH redisChat "Redis is a great caching technique"  
  (integer) 1  
  redis 127.0.0.1:6379> PUBLISH redisChat "Learn redis by tutorials point"  
  (integer) 1   
  1) "message" 
  2) "redisChat" 
  3) "Redis is a great caching technique" 
  1) "message" 
  2) "redisChat" 
  3) "Learn redis by tutorials point" 
  ```
  
- Just like I listed the key commands that you can use in the `key`s section there are commands that you can use with `publish/subscribe`, however it would take a lot of space to list them here. Instead visit the link below and at the bottom you will see a list table with tutorial to each command:
  - https://www.tutorialspoint.com/redis/redis_pub_sub.htm
  
<br>
<br>
<br>

# Transactions

- Redis transactions allow the execution of a group of commands in a single step. Following are the two properties of Transactions:
  - All commands in a transaction are sequentially executed as a single isolated operation. It is not possible that a request issued by another client is served in the middle of the execution of a Redis transaction.
  - Redis transaction is also atomic. Atomic means either all of the commands or none are processed.
  
- Redis transaction is initiated by command `MULTI` and then you need to pass a list of commands that should be executed in the transaction, after which the entire transaction is executed by `EXEC` command.
  ```
  redis 127.0.0.1:6379> MULTI 
  OK 
  List of commands here 
  redis 127.0.0.1:6379> EXEC
  ```
  
  Following example explains how Redis transaction can be initiated and executed.
  ```
  redis 127.0.0.1:6379> MULTI 
  OK 
  redis 127.0.0.1:6379> SET tutorial redis 
  QUEUED 
  redis 127.0.0.1:6379> GET tutorial 
  QUEUED 
  redis 127.0.0.1:6379> INCR visitors 
  QUEUED 
  redis 127.0.0.1:6379> EXEC  
  1) OK 
  2) "redis" 
  3) (integer) 1 
  ```
  
- Just like I listed the key commands that you can use in the `key`s section there are commands that you can use with `transactions`, however it would take a lot of space to list them here. Instead visit the link below and at the bottom you will see a list table with tutorial to each command:
  - https://www.tutorialspoint.com/redis/redis_transactions.htm
  
<br>
<br>
<br>

# Scripting 

- You can write scripts with redis. However, I am not going to note it down here if you want to you can read it here:
  - https://www.tutorialspoint.com/redis/redis_scripting.htm
  
<br>
<br>
<br>



<br>
<br>
<br>

---

[Part 2](./README2.md)




