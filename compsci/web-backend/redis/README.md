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













