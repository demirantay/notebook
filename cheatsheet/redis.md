# Redis Chetsheet

All the commands you must know: (There may be new commands added to the tech. View [updated version here](https://redis.io/commands#))

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
- `BITCOUNT key [start end]` -- Count set bits in a string 
- `BITFIELD key [`GET type offset]...` -- Perform arbitrary bitfield integer operations on strings

### Keys

### Lists
> A list is a series of ordered values.

### Sets
> A set is similar to a list, except it does not have a specific order and each element may only appear once.

### Sorted Sets
> A sorted set is similar to a regular set, but now each value has an associated score. This score is used to sort the elements in the set.

### Hashes
> Hashes are maps between string fields and string values, so they are the perfect data type to represent objects.

### HyperLogLog
> HyperLogLog uses randomization in order to provide an approximation of the number of unique elements in a set using just a constant, and small, amount of memory

### Publication & Subscription

### Transactions

### Streams

### Server

### Scripting

### Geo  

### Cluster
