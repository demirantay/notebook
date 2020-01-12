# Memory Organization in Computer Architecture

- A memory unit is the collection of storage units or devices together. The memory unit stores the binary information in the form of bits. Generally, memory/storage is classified into 2 categories:
  - `Volatile Memory`: This loses its data, when power is switched off.
  - `Non-Volatile Memory`: This is a permanent storage and does not lose any data when power is switched off.

### Memory Hierarchy

- The total memory capacity of a computer can be visualized by hierarchy of components. The memory hierarchy system consists of all storage devices contained in a computer system from the slow Auxiliary Memory to fast Main Memory and to smaller Cache memory.

  Lets view the memories ranked by the access time ratio from the fastest to slowest:
  ```
  1 - Register Memory
  2 - Cache Memory
  3 - Main Memory           # Primary Memory
  4 - Magnetic Disks        # Auxilary Memory
  5 - Magnetic Tapes        # Auxilary Memory
  ```

### Memory Access Methods

- Each memory type, is a collection of numerous memory locations. To access data from any memory, first it must be located and then the data is read from the memory location. Following are the methods to access information from memory locations:
  - `Random Access`: Main memories are random access memories, in which each memory location has a unique address. Using this unique address any memory location can be reached in the same amount of time in any order.
  - `Sequential Access`: This methods allows memory access in a sequence or in order.
  - `Direct Access`: In this mode, information is stored in tracks, with each track having a separate read/write head.

### Main Memory

- The memory unit that communicates directly within the CPU, Auxillary memory and Cache memory, is called main memory. It is the central storage unit of the computer system. It is a large and fast memory used to store data during computer operations. Main memory is made up of `RAM` and `ROM`, with RAM integrated circuit chips holing the major share.

### Auxilary Memory

- Devices that provide backup storage are called auxiliary memory. For example: Magnetic disks and tapes are commonly used auxiliary devices. Other devices used as auxiliary memory are magnetic drums, magnetic bubble memory and optical disks.

  It is not directly accessible to the CPU, and is accessed using the Input/Output channels. Such as USB ... etc.
  
### Cache Memory

- The data or contents of the main memory that are used again and again by CPU, are stored in the cache memory so that we can easily access that data in shorter time. Whenever the CPU needs to access memory, it first checks the cache memory. If the data is not found in cache memory then the CPU moves onto the main memory

- The performance of cache memory is measured in terms of a quantity called `hit ratio`

### Associative Memory

<br>
<br>

---

<br>
<br>

# Mapping and Virtual Memory

- The transformation of data from main memory to cache memory is called mapping. There are 3 main types of mapping:
  - Associative Mapping
  - Direct Mapping
  - Set Associative Mapping

- `Associative Mapping` -- The associative memory stores both address and data. The address value of 15 bits is 5 digit octal numbers and data is of 12 bits word in 4 digit octal number. A CPU address of 15 bits is placed in argument register and the associative memory is searched for matching address.

- `Direct Mapping` -- The CPU address of 15 bits is divided into 2 fields. In this the 9 least significant bits constitute the index field and the remaining 6 bits constitute the tag field. The number of bits in index field is equal to the number of address bits required to access cache memory.

- `Set Associative Mapping` -- The disadvantage of direct mapping is that two words with same index address can't reside in cache memory at the same time. This problem can be overcome by set associative mapping.

  In this we can store two or more words of memory under the same index address. Each data word is stored together with its tag and this forms a set.

### Virtual Memory

- Virtual memory is the separation of logical memory from physical memory. This separation provides large virtual memory for programmers when only small physical memory is available.

  Virtual memory is used to give programmers the illusion that they have a very large memory even though the computer has a small main memory. It makes the task of programming easier because the programmer no longer needs to worry about the amount of physical memory available.

<br>
<br>

---

<br>
<br>

# Parallel Processing

### Data Transfer Modes of a Computer System

- `SISD` -- 

...

<br>
<Br>

---

<br>
<br>

# Pipelining 
