# Redis Chetsheet

All the commands you must know: (There are a lot more commands to redis to [view them all click here](https://redis.io/commands#))

### Config

- `redis-server` -- starts redis server with default config
- `redis-server /path/redis.conf` -- start redis with the related configuration file
- `redis-cli` -- opens a redis prompt

### Connection

- `AUTH password` -- Authenticate to the server
- `ECHO message` -- Echo the given string 
- `PING [message]` -- Ping the server
- `QUIT` -- Close the connection
- `SELECT index` -- Change the selected database for the current connection
- `SWAPDB index1 index2` -- Swaps two redis databases 

### Strings

- `APPEND key value` -- Append a value to a key
- `BITCOUNT key [start end]` -- count set bits in a string
- `SET key value` -- set value in key
- `SETNX key value` -- set if not exist value in key
- `SETRANGE key offset value ` -- overwrite part of a string at key starting at the specified offset
- `STRLEN key` -- get the length of the value stored in a key
- `MSET key value [key value ...]` -- set multiple keys to multiple values
- `MSETNX key value [key value ...]` -- set multiple keys to multiple values, only if none of the keys exist
- `GET key` -- get value in key
- `GETRANGE key value` -- get a substring value of a key and return its old value
- `MGET key [key ...]` -- get the values of all the given keys
- `INCR key` -- increment value in key
- `INCRBY key increment` -- increment the integer value of a key by the given amount
- `INCRBYFLOAT key increment` -- increment the float value of a key by the given amount
- `DECRBY key decrement` -- decrement the integer value of a key by the given number
- `DEL key` -- delete key
- `EXPIRE key 120` -- key will be deleted in 120 seconds
- `TTL key` -- returns the number of seconds until a key is deleted

### Lists
> A list is a series of ordered values.

- `RPUSH key value [value ...]` -- put the new value at the end of the list
- `RPUSHX key value` -- append a value to a list, only if the exists
- `LPUSH key value [value ...]` -- put the new value at the start of the list
- `LRANGE key start stop` -- give a subset of the list
- `LINDEX key index` -- get an element from a list by its index
- `LINSERT key BEFORE|AFTER pivot value` -- insert an element before or after another element in a list
- `LLEN key` -- return the current length of the list
- `LPOP key` -- remove the first element from the list and returns it
- `LSET key index value` -- set the value of an element in a list by its index
- `LTRIM key start stop` -- trim a list to the specified range
- `RPOP key` -- remove the last element from the list and returns it
- `RPOPLPUSH source destination` -- remove the last element in a list, prepend it to another list and return it
- `BLPOP key [key ...] timeout` -- remove and get the first element in a list, or block until one is available
- `BRPOP key [key ...] timeout` -- remove and get the last element in a list, or block until one is available

### Sets
> A set is similar to a list, except it does not have a specific order and each element may only appear once.

- `SADD key member [member ...]` -- add the given value to the set
- `SCARD key` -- get the number of members in a set
- `SREM key member [member ...]` -- remove the given value from the set
- `SISMEMBER myset value` -- test if the given value is in the set.
- `SMEMBERS myset` -- return a list of all the members of this set
- `SUNION key [key ...]` -- combine two or more sets and returns the list of all elements
- `SINTER key [key ...]` -- intersect multiple sets
- `SMOVE source destination member` -- move a member from one set to another
- `SPOP key [count]` -- remove and return one or multiple random members from a set

### Sorted Sets
> A sorted set is similar to a regular set, but now each value has an associated score. This score is used to sort the elements in the set.

- `ZADD key [NX|XX] [CH] [INCR] score member [score member ...]` -- add one or more members to a sorted set, or update its score if it already exists
- `ZCARD key` -- get the number of members in a sorted set

### Hashes
> Hashes are maps between string fields and string values, so they are the perfect data type to represent objects.

### HyperLogLog
> HyperLogLog uses randomization in order to provide an approximation of the number of unique elements in a set using just a constant, and small, amount of memory

