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

- Instead of processing each instruction sequentially, a parallel processing system provides concurrent data processing to increase the execution time. In this the system may have two or more ALU's and should be able to execute two or more instructions at the same time. The purpose of parallel processing is to speed up the computer processing capability and increase its throughput.

- Parallel processing can be viewed from various levels of complexity. At the lowest level, we distinguish between parallel and serial operations by the type of registers used. At the higher level of complexity, parallel processing can be achieved by using multiple functional units that perform many operations simultaneously.

### Data Transfer Modes of a Computer System

- According to the data transfer mode, computer can be divided into 4 major groups:
  - 1 - SISD
  - 2 - SIMD
  - 3 - MISD 
  - 4 - MIMD

- `SISD -- (Single Instruction Stream, Single Data Stream))` -- It represents the organization of a single computer containing a control unit, processor unit and a memory unit. Instructions are executed sequentially. It can be achieved by pipelining or multiple functional units.

- `SIMD (Single Instruction Stream, Multiple Data Stream)` -- It represents an organization that includes multiple processing units under the control of a common control unit. All processors receive the same instruction from control unit but operate on different parts of the data.

- `MISD (Multiple Instruction Stream, Single Data Stream)` -- It consists of a single computer containing multiple processors connected with multiple control units and a common memory unit. It is capable of processing several instructions over single data stream simultaneously

- `MIMD (Multiple Instruction Stream, Multiple Data Stream` -- It represents the organization which is capable of processing several programs at same time. It is the organization of a single computer containing multiple processors connected with multiple control units and a shared memory unit. 

<br>
<Br>

---

<br>
<br>

# Pipelining 

- Pipelining is the process of accumulating instruction from the processor through a pipeline. It allows storing and executing instructions in an orderly process. It is also known as pipeline processing.

  Pipelining is a technique where multiple instructions are overlapped during execution. Pipeline is divided into stages and these stages are connected with one another to form a pipe like structure. Instructions enter from one end and exit from another end.

### Types of Pipeline

- It is divided into 2 categories:
  - 1 - Arithmetic Pipeline 
  - 2 - Instruction Pipeline
  
- `Arithmetic Pipeline` -- Arithmetic pipelines are usually found in most of the computers. They are used for floating point operations, multiplication of fixed point numbers etc

- `Instruction Pipieline` -- In this a stream of instructions can be executed by overlapping fetch, decode and execute phases of an instruction cycle. This type of technique is used to increase the throughput of the computer system.

### Pipeline Conflicts

- There are some factors that cause the pipeline to deviate its normal performance. Some of these factors are given below:
  - 1 - Timing Variations
  - 2 - Data Hazards
  - 3 - Branching
  - 4 - Interrupts
  - 5 - Data Dependency
  
<br>
<br>

---

<br>
<br>

# Vector(Array) Processing and Superscalar Processors

> This is where I left off of this tutorial : 

https://www.studytonight.com/computer-architecture/vector-and-superscalar
