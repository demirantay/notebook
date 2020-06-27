# Introduction to Operating System

- A computer system has many resources (hardware and software), which may be require to complete a task. The commonly required resources are input/output devices, memory, file storage space, CPU etc. The operating system acts as a manager of the above resources and allocates them to specific programs and users, whenever necessary to perform a particular task

   Therefore operating system is the resource manager i.e. it can manage the resource of a computer system internally. The resources are processor, memory, files, and I/O devices. In simple terms, an operating system is the interface between the user and the machine.

- `Two Views of Operating System` -- `User's View` and `System View` 

  __Operating System: User View__ -- The user view of the computer refers to the interface being used. In these cases, the operating system is designed mostly for ease of use, with some attention paid to performance, and none paid to resource utilization.
  
  __Operating System: System View__ --  The operating system acts as the manager of the resources, decides between conflicting requests, controls execution of programs etc.

- `Operating System Management Tasks` --
  - 1 - Processor management which involves putting the tasks into order and pairing them into manageable size before they go to the CPU.
  - 2 - Memory management which coordinates data to and from RAM (random-access memory) and determines the necessity for virtual memory.
  - 3 - Device management which provides interface between connected devices
  - 4 - Storage management which directs permanent data storage.
  - 5 - Application which allows standard communication between software and your computer.
  - 6 - User interface which allows you to communicate with your computer.

- `Functions of Operating System` --
  - It boots the computer
  - It performs basic computer tasks e.g. managing the various peripheral devices e.g. mouse, keyboard
  - It provides a user interface, e.g. command line, graphical user interface (GUI)
  - It handles system resources such as computer's memory and sharing of the central processing unit(CPU) time by various applications or peripheral devices.
  - It provides file management which refers to the way that the operating system manipulates, stores, retrieves and saves data.
  - Error Handling is done by the operating system. It takes preventive measures whenever required to avoid errors.

<br>
<br>

---

<br>
<br>

# Types of Operating System

- Following are some of the most widely used types of Operating system:
  - Simple Batch System
  - Multiprogramming Batch System
  - Multiprocessor System
  - Desktop System
  - Distributed Operating System
  - Clustered System
  - Realtime Operating System
  - Handheld System
  
- `Simple Batch Systems` -- In this type of system, there is no direct interaction between user and the computer. The user has to submit a job (written on cards or tape) to a computer operator. Then a special program, the monitor, manages the execution of each program in the batch. The monitor is always in the main memory and available for execution.

- `Multiprogramming Batch System` -- In this the operating system picks up and begins to execute one of the jobs from memory If several jobs are ready to run at the same time, then the system chooses which one to run through the process of CPU Scheduling. In Multiprogramming system, CPU will never be idle and keeps on processing.

- `Multiprocessor System` -- A Multiprocessor system consists of several processors that share a common physical memory. Multiprocessor system provides higher computing power and speed. In multiprocessor system all processors operate under single operating system

- `Desktop System` -- Earlier, CPUs and PCs lacked the features needed to protect an operating system from user programs. PC operating systems therefore were neither multiuser nor multitasking. However, the goals of these operating systems have changed with time; instead of maximizing CPU and peripheral utilization, the systems opt for maximizing user convenience and responsiveness. These systems are called Desktop Systems and include PCs running Microsoft Windows and the Apple Macintosh

- `Distributed Operating System` -- The motivation behind developing distributed operating systems is the availability of powerful and inexpensive microprocessors and advances in communication technology These advancements in technology have made it possible to design and develop distributed systems comprising of many computers that are inter connected by communication networks. The main benefit of distributed systems is its low price/performance ratio.

   Following are the two types of distributed operating systems used:
   - Client-Server Systems
   - Peer-to-Peer Systems

- `Clustered System` -- Like parallel systems, clustered systems gather together multiple CPUs to accomplish computational work. Clustered systems differ from parallel systems, however, in that they are composed of two or more individual systems coupled together. A layer of cluster software runs on the cluster nodes. Each node can monitor one or more of the others. If the monitored machine fails, the monitoring machine can take ownership of its storage, and restart the application(s) that were running on the failed machine. The failed machine can remain down, but the users and clients of the application would only see a brief interruption of service.

- `Realtime Operating System` -- A layer of cluster software runs on the cluster nodes. Each node can monitor one or more of the others. If the monitored machine fails, the monitoring machine can take ownership of its storage, and restart the application(s) that were running on the failed machine. The failed machine can remain down, but the users and clients of the application would only see a brief interruption of service.

- `Handheld System` -- Handheld systems include Personal Digital Assistants(PDAs), such as Palm-Pilots or Cellular Telephones with connectivity to a network such as the Internet. They are usually of limited size due to which most handheld devices have a small amount of memory, include slow processors, and feature small display screens.

<br>
<br>

---

<br>
<br>

# Operating System Processes

- A process is a program in execution. Process is not as same as program code but a lot more than it. A process is an 'active' entity as opposed to program which is considered to be a 'passive' entity. Attributes held by process include hardware state, memory, CPU etc.

   Process memory is divided into four sections for efficient working :
   - 1 - The Text section is made up of the compiled program code, read in from non-volatile storage when the program is launched.
   - 2 - The Data section is made up the global and static variables, allocated and initialized prior to executing the main
   - 3 - The Heap is used for the dynamic memory allocation, and is managed via calls to new, delete, malloc, free, etc
   - 4 - The Stack is used for local variables. Space on the stack is reserved for local variables when they are declared.
   
 - `Different Process States` -- Processes in the operating system can be in any of the following states:
   - NEW- The process is being created.
   - READY- The process is waiting to be assigned to a processor.
   - RUNNING- Instructions are being executed.
   - WAITING- The process is waiting for some event to occur(such as an I/O completion or reception of a signal).
   - TERMINATED- The process has finished execution.
   
 - `Process Control Block` -- There is a Process Control Block for each process, enclosing all the information about the process. It is a data structure, which contains the following:
   - Process State: It can be running, waiting etc.
   - Process ID and the parent process ID.
   - CPU registers and Program Counter. Program Counter holds the address of the next instruction to be executed for that process.
   - CPU Scheduling information: Such as priority information and pointers to scheduling queues.
   - Memory Management information: For example, page tables or segment tables.
   - Accounting information: The User and kernel CPU time consumed, account numbers, limits, etc.
   - I/O Status information: Devices allocated, open file tables, etc.
   
<br>
<br>

---

<br>
<br>

# Process Scheduling

- The act of determining which process is in the ready state, and should be moved to the running state is known as Process Scheduling. The prime aim of the process scheduling system is to keep the CPU busy all the time and to deliver minimum response time for all programs

- `What are Scheduling Queues?` -- 
  - All processes, upon entering into the system, are stored in the Job Queue.
  - Processes in the Ready state are placed in the Ready Queue.
  
- `Types of Schedulers` -- There are three types of schedulers available:
  - 1 - Long Term Scheduler
  - 2 - Short Term Scheduler
  - 3 - Medium Term Schedule
  
- `What is Context Switch?` -- Switching the CPU to another process requires saving the state of the old process and loading the saved state for the new process. This task is known as a Context Switch.

- `Process Creation` -- Through appropriate system calls, such as fork or spawn, processes may create other processes. The process which creates other process, is termed the parent of the other process, while the created sub-process is termed its child. Each process is given an integer identifier, termed as process identifier, or PID. The parent PID (PPID) is also stored for each process.

<br>
<br>

---

<br>
<br>

# CPU Scheduling

- `What is CPU Scheduling?` -- CPU scheduling is a process which allows one process to use the CPU while the execution of another process is on hold(in waiting state) due to unavailability of any resource like I/O etc, thereby making full use of CPU. The aim of CPU scheduling is to make the system efficient, fast and fair.

- `Types of CPU Scheduling` -- CPU scheduling decisions may take place under the following four circumstances:
  - When a process switches from the running state to the waiting state(for I/O request or invocation of wait for the termination of one of the child processes).
  - When a process switches from the running state to the ready state (for example, when an interrupt occurs).
  - When a process switches from the waiting state to the ready state(for example, completion of I/O).
  - When a process terminates.
  
- There are many different criterias to check when considering the "best" scheduling algorithm, they are:
  - `CPU Utilization` -- To make out the best use of CPU and not to waste any CPU cycle, CPU would be working most of the time(Ideally 100% of the time). 
  - `Throughput` -- It is the total number of processes completed per unit time or rather say total amount of work done in a unit of time
  - `Turnaround Time` -- It is the amount of time taken to execute a particular process
  - `Waiting Time` -- The sum of the periods spent waiting in the ready queue amount of time a process has been waiting in the ready queue to acquire get control on the CPU.
  - `Load Average` -- It is the average number of processes residing in the ready queue waiting for their turn to get into the CPU
  - `Response Time` -- Amount of time it takes from when a request was submitted until the first response is produced.
  
 - `Scheduling Algorithms`: To decide which process to execute first and which process to execute last to achieve maximum CPU utilisation, computer scientists have defined some algorithms, they are:
  - 1 - First Come First Serve(FCFS) Scheduling 
  - 2 - Shortest-Job-First(SJF) Scheduling
  - 3 - Priority Scheduling
  - 4 - Round Robin(RR) Scheduling
  - 5 - Multilevel Queue Scheduling
  - 6 - Multilevel Feedback Queue Scheduling

<br>
<br>

---

<br>
<br>

# Introduction to Threads

- `What are threads` -- Thread is an execution unit which consists of its own program counter, a stack, and a set of registers. Threads are also known as Lightweight processes. Threads are popular way to improve application through parallelism. The CPU switches rapidly back and forth among the threads giving illusion that the threads are running in parallel

- `Types of Threads` -- There are two types of threads:
  - User Threads
  - Kernel Threads
  
  User threads, are above the kernel and without kernel support. These are the threads that application programmers use in their programs.
  
  Kernel threads are supported within the kernel of the OS itself. All modern OSs support kernel level threads, allowing the kernel to perform multiple simultaneous tasks and/or to service multiple kernel system calls simultaneously.
  
- `Multithreading Models` -- The user threads must be mapped to kernel threads, by one of the following strategies:
  - Many to One Model -- In the many to one model, many user-level threads are all mapped onto a single kernel thread.
  - One to One Model -- The one to one model creates a separate kernel thread to handle each and every user thread.
  - Many to Many Model -- The many to many model multiplexes any number of user threads onto an equal or smaller number of kernel threads
  
- `What are Thread Libraries?` -- Thread libraries provide programmers with API for creation and management of threads. Thread libraries may be implemented either in user space or in kernel space. The user space involves API functions implemented solely within the user space, with no kernel support. The kernel space involves system calls, and requires a kernel with thread library support.
  

<br>
<br>

---

<br>
<br>

# Process Synchronization

- Process Synchronization means sharing system resources by processes in a such a way that, Concurrent access to shared data is handled thereby minimizing the chance of inconsistent data. Maintaining data consistency demands mechanisms to ensure synchronized execution of cooperating processes.

- `Critical Selection Problem` -- A Critical Section is a code segment that accesses shared variables and has to be executed as an atomic action. It means that in a group of cooperating processes, at a given point of time, only one process must be executing its critical section. If any other process also wants to execute its critical section, it must wait until the first one finishes.

<br>
<br>

---

<br>
<br>

# Classical Synchronization Problems

- Below are some of the classical problem depicting flaws of process synchronaization in systems where cooperating processes are present. We will discuss the following three problems:
   - 1 - Bounded Buffer (Producer-Consumer) Problem
   - 2 - Dining Philosophers Problem
   - 3 - The Readers Writers Problem

- `Bounded Buffer (Producer-Consumer) Problem` -- This problem is generalised in terms of the Producer Consumer problem, where a finite buffer pool is used to exchange messages between producer and consumer processes.
Because the buffer pool has a maximum size, this problem is often called the Bounded buffer problem.

   Solution to this problem is, creating two counting semaphores "full" and "empty" to keep track of the current number of full and empty buffers respectively.

- `Dining Philosophers Problem` -- The dining philosopher's problem involves the allocation of limited resources to a group of processes in a deadlock-free and starvation-free manner.

   There are five philosophers sitting around a table, in which there are five chopsticks/forks kept beside them and a bowl of rice in the centre, When a philosopher wants to eat, he uses two chopsticks - one from their left and one from their right. When a philosopher wants to think, he keeps down both chopsticks at their original place.

- `The Readers Writers Problem` -- In this problem there are some processes(called readers) that only read the shared data, and never change it, and there are other processes(called writers) who may change the data in addition to reading, or instead of reading it.

- `deadlocks` -- Deadlocks are a set of blocked processes each holding a resource and waiting to acquire a resource held by another process.

<br>
<br>

---

<br>
<br>
