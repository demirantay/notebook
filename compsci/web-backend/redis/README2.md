[Part 1](./README.md)

---

<br>

# Connections

- Redis connection commands are basically used to manage client connections with Redis server. Following example explains how a client authenticates itself to Redis server and checks whether the server is running or not:
  ```
  redis 127.0.0.1:6379> AUTH "password" 
  OK 
  redis 127.0.0.1:6379> PING 
  PONG 
  ```
  
- You can use this command to use with Redis Connections:
  - [AUTH password](https://www.tutorialspoint.com/redis/connection_auth.htm): Authenticates to the server with the given password
  - [ECHO message](https://www.tutorialspoint.com/redis/connection_echo.htm) : Prints the given string
  - [PING](https://www.tutorialspoint.com/redis/connection_ping.htm) : Checks whether the server is running or not
  - [QUIT](https://www.tutorialspoint.com/redis/connection_quit.htm): Closes the current connection
  - [SELECT index](https://www.tutorialspoint.com/redis/connection_select.htm): Changes the selected database for the current connection

<br>
<br>
<br>

# Server

- Redis server commands are basically used to manage Redis server. Following example explains how we can get all statistics and information about the server.
  ```
  redis 127.0.0.1:6379> INFO  

  # Server 
  redis_version:2.8.13 
  redis_git_sha1:00000000 
  redis_git_dirty:0 
  redis_build_id:c2238b38b1edb0e2 
  redis_mode:standalone 
  os:Linux 3.5.0-48-generic x86_64 
  arch_bits:64 
  multiplexing_api:epoll 
  gcc_version:4.7.2 
  process_id:3856 
  run_id:0e61abd297771de3fe812a3c21027732ac9f41fe 
  tcp_port:6379 
  uptime_in_seconds:11554 
  uptime_in_days:0 hz:10 
  lru_clock:16651447 
  config_file:  

  ...
  ```
  
- There are many ways to confid the servers settings or there are commands to use the server however it is a huge topic so it is best that you read it from a different resource. This is an exxcellent resource to start with:
  - https://www.tutorialspoint.com/redis/redis_server.htm
  
<br>
<br>
<br>

# Backup 

- Redis SAVE command is used to create a backup of the current Redis database. Following is the basic syntax of redis `SAVE` command.
  ```
  127.0.0.1:6379> SAVE 
  ```
  This command will create a `dump.rdb` file in your Redis directory.
  
- To restore Redis data, move Redis backup file (dump.rdb) into your Redis directory and start the server. To get your Redis directory, use `CONFIG` command of Redis as shown below.
  ```
  127.0.0.1:6379> CONFIG get dir  
  1) "dir" 
  2) "/user/tutorialspoint/redis-2.8.13/src" 
  ```
  In the output of the above command /user/tutorialspoint/redis-2.8.13/src is the directory, where Redis server backupwill be installed.
  
- For more info on the topic please start by reading this:
  - https://www.tutorialspoint.com/redis/redis_backup.htm
  
<br>
<br>
<br>

# Security

- Redis database can be secured, such that any client making a connection needs to authenticate before executing a command. To secure Redis, you need to set the password in the config file.

- Following example shows the steps to secure your Redis instance:
  ```
  127.0.0.1:6379> CONFIG get requirepass 
  1) "requirepass" 
  2) "" 
  ```
  By default, this property is blank, which means no password is set for this instance. You can change this property by executing the following command.
  ```
  127.0.0.1:6379> CONFIG set requirepass "tutorialspoint" 
  OK 
  127.0.0.1:6379> CONFIG get requirepass 
  1) "requirepass" 
  2) "tutorialspoint" 
  ```
  After setting the password, if any client runs the command without authentication, then (error) NOAUTH Authentication required. error will return. Hence, the client needs to use AUTH command to authenticate himself.
  
  Following is the basic syntax of AUTH command.
  ```
  127.0.0.1:6379> AUTH password 
  ```
  Let's see a real world example:
  ```
  127.0.0.1:6379> AUTH "tutorialspoint" 
  OK 
  127.0.0.1:6379> SET mykey "Test value" 
  OK 
  127.0.0.1:6379> GET mykey 
  "Test value"
  ```
  
<br>
<br>
<br>

# Benchmarks

- Redis benchmark is the utility to check the performance of Redis by running n commands simultaneously. Following is the basic syntax of Redis benchmark
  ```
  redis-benchmark [option] [option value] 
  ```
  Following real world example checks Redis by calling 100000 commands in order to test performance.
  ```
  redis-benchmark -n 100000  

  PING_INLINE: 141043.72 requests per second 
  PING_BULK: 142857.14 requests per second 
  ...
  ```
  
- There are lots of available options in Redis benchmark. See the bottom of this link to see the tabled list of the options:
  - https://www.tutorialspoint.com/redis/redis_benchmarks.htm
  
<br>
<br>
<br>

# Client Connection

- This content is a little bit hard for me to understand re-read it in the future:
  - https://www.tutorialspoint.com/redis/redis_client_connection.htm
  
<br>
<br>
<br>

# Pipelining

- This content is a little bit hard for me to understand re-read it in the future:
  - https://www.tutorialspoint.com/redis/redis_pipelining.htm
  
<br>
<br>
<br>

# Partitioning

- This content is a little bit hard for me to understand re-read it in the future:
  - https://www.tutorialspoint.com/redis/redis_partitioning.htm
  
  
