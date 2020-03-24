# Process Scheduling

- `Definition` -- The process scheduling is the activity of the process manager that handles the removal of the running process from the CPU and the selection of another process on the basis of a particular strategy. Process scheduling is an essential part of a Multiprogramming operating systems.

- `Process Scheduling Queues` -- The OS maintains all PCBs in Process Scheduling Queues. The OS maintains a separate queue for each of the process states and PCBs of all processes in the same execution state are placed in the same queue.

  The Operating System maintains the following important process scheduling queues: `job queue`, `ready queue`, `device queue`
  
  The OS can use different policies to manage each queue (FIFO, Round Robin, Priority, etc.)

- `Long Term Scheduler` -- It is also called a job scheduler. A long-term scheduler determines which programs are admitted to the system for processing. It selects processes from the queue and loads them into memory for execution. Process loads into the memory for CPU scheduling.

- `Short Term Scheduler` -- It is also called as CPU scheduler. Its main objective is to increase system performance in accordance with the chosen set of criteria. It is the change of ready state to running state of the process. CPU scheduler selects a process among the processes that are ready to execute and allocates CPU to one of them.

- `Medium Term Scheduler` -- Medium-term scheduling is a part of swapping. It removes the processes from the memory. It reduces the degree of multiprogramming. The medium-term scheduler is in-charge of handling the swapped out-processes.

- `Context Switch` -- A context switch is the mechanism to store and restore the state or context of a CPU in Process Control block so that a process execution can be resumed from the same point at a later time. Using this technique, a context switcher enables multiple processes to share a single CPU. Context switching is an essential part of a multitasking operating system features.

<br>
<br>

---

<br>
<br>

# Scheduling Algorithms 

- A Process Scheduler schedules different processes to be assigned to the CPU based on particular scheduling algorithms. There are six popular process scheduling algorithms which we are going to discuss in this chapter −

  These algorithms are either `non-preemptive` or `preemptive`. Non-preemptive algorithms are designed so that once a process enters the running state, it cannot be preempted until it completes its allotted time, whereas the preemptive scheduling is based on priority where a scheduler may preempt a low priority running process anytime when a high priority process enters into a ready state.

### 1. First Come First Serve (FCFS)

- Algorithm Overview:
  - Jobs are executed on first come, first serve basis.
  - It is a non-preemptive, pre-emptive scheduling algorithm.
  - Easy to understand and implement.
  - Its implementation is based on FIFO queue.
  - Poor in performance as average wait time is high.

### 2. Shortest Job Next (SJN)

- Algorithm Overview:
  - This is also known as shortest job first, or SJF
  - This is a non-preemptive, pre-emptive scheduling algorithm.
  - Best approach to minimize waiting time.
  - Easy to implement in Batch systems where required CPU time is known in advance.
  - Impossible to implement in interactive systems where required CPU time is not known
  - The processer should know in advance how much time process will take.

### 3. Priority Based Scheduling

- Algorithm Overview:
  - Priority scheduling is a non-preemptive algorithm and one of the most common scheduling algorithms in batch systems.
  - Each process is assigned a priority. Process with highest priority is to be executed first and so on.
  - Processes with same priority are executed on first come first served basis.
  - Priority can be decided based on memory requirements, time requirements or any other resource requirement.

### 4. Shortest Remaining Time

- Algorithm Overview:
  - Shortest remaining time (SRT) is the preemptive version of the SJN algorithm.
  - The processor is allocated to the job closest to completion but it can be preempted by a newer ready job with shorter time to completion.
  - Impossible to implement in interactive systems where required CPU time is not known.
  - It is often used in batch environments where short jobs need to give preference.

### 5. Round Robin Scheduling

- Algorithm Overview:
  - Round Robin is the preemptive process scheduling algorithm.
  - Each process is provided a fix time to execute, it is called a quantum.
  - Once a process is executed for a given time period, it is preempted and other process executes for a given time period.
  - Context switching is used to save states of preempted processes

### 6. Multiple-Level Queues Scheduling

- Algorithm Overview:
  - Multiple queues are maintained for processes with common characteristics.
  - Each queue can have its own scheduling algorithms.
  - Priorities are assigned to each queue.
  
<br>
<br>

---

<br>
<bR>
  
# Multi-threading

- A thread is a flow of execution through the process code, with its own program counter that keeps track of which instruction to execute next, system registers which hold its current working variables, and a stack which contains the execution history

  Each thread belongs to exactly one process and no thread can exist outside a process. Each thread represents a separate flow of control. Threads have been successfully used in implementing network servers and web server. They also provide a suitable foundation for parallel execution of applications on shared memory multiprocessors.

### Advantages of Thread

- Advantages:
  - Threads minimize the context switching time.
  - Use of threads provides concurrency within a process.
  - Efficient communication.
  - It is more economical to create and context switch threads.
  - Threads allow utilization of multiprocessor architectures to a greater scale and efficiency.

- `Types of Thread` -- Threads are implemented in following two ways −
  - User Level Threads − User managed threads.
  - Kernel Level Threads − Operating System managed threads acting on kernel, an operating system core.

- `User Level Threads` -- In this case, the thread management kernel is not aware of the existence of threads. The thread library contains code for creating and destroying threads, for passing message and data between threads, for scheduling thread execution and for saving and restoring thread contexts. The application starts with a single thread.

- `Kernel Level Threads` -- In this case, thread management is done by the Kernel. There is no thread management code in the application area. Kernel threads are supported directly by the operating system. Any application can be programmed to be multithreaded. All of the threads within an application are supported within a single process.

### Multithreading Models

- Some operating system provide a combined user level thread and Kernel level thread facility. Solaris is a good example of this combined approach. In a combined system, multiple threads within the same application can run in parallel on multiple processors and a blocking system call need not block the entire process. Multithreading models are three types:

- `1. Many to Many Model` -- The many-to-many model multiplexes any number of user threads onto an equal or smaller number of kernel threads.

- `2. Many to One Model` -- Many-to-one model maps many user level threads to one Kernel-level thread. Thread management is done in user space by the thread library. When thread makes a blocking system call, the entire process will be blocked. Only one thread can access the Kernel at a time, so multiple threads are unable to run in parallel on multiprocessors.

- `3. One to One Model` -- There is one-to-one relationship of user-level thread to the kernel-level thread. This model provides more concurrency than the many-to-one model.

<bR>
<br>
 
---

<bR>
<br>
  
# Memory Management 

- Memory management is the functionality of an operating system which handles or manages primary memory and moves processes back and forth between main memory and disk during execution. Memory management keeps track of each and every memory location, regardless of either it is allocated to some process or it is free. It checks how much memory is to be allocated to processes. It decides which process will get memory at what time. It tracks whenever some memory gets freed or unallocated and correspondingly it updates the status.

### Process Address Space

- The process address space is the set of logical addresses that a process references in its code. Virtual and physical addresses are the same in compile-time and load-time address-binding schemes. Virtual and physical addresses differ in execution-time address-binding scheme.

  The set of all logical addresses generated by a program is referred to as a `logical address space`. The set of all physical addresses corresponding to these logical addresses is referred to as a `physical address space`.
  
  The runtime mapping from virtual to physical address is done by the memory management unit (MMU) which is a hardware device.

### Static vs Dynamic Loading

### Static vs Dynamic Linking

### Swapping

### Memory Allocation

### Fragmentation

### Paging

### Segmentation
