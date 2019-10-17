# Introcution to Operating Systems

- A computer system has many resources (hardware and software), which may be require to complete a task. The commonly required resources are input/output devices, memory, file storage space, CPU etc. The operating system acts as a manager of the above resources and allocates them to specific programs and users, whenever necessary to perform a particular task. Therefore operating system is the resource manager i.e. it can manage the resource of a computer system internally. The resources are processor, memory, files, and I/O devices. __In simple terms, an operating system is the interface between the user and the machine.__
  
### Operating System Management Tasks

- The management tasks are:
  - 1 - `Processor management` - which involves putting the tasks into order and pairing them into manageable size before they go to the CPU.
  - 2 - `Memory management` - which coordinates data to and from RAM (random-access memory) and determines the necessity for virtual memory
  - 3 - `Device management` - which provides interface between connected devices.
  - 4 - `Storage management` - which directs permanent data storage.
  - 5 - `Application` - which allows standard communication between software and your computer.
  - 6 - `User interface` - which allows you to communicate with your computer

### Functions of Operating System

- Summary/Overview of the main functions:
  - 1 - It boots the computer
  - 2 - It performs basic computer tasks e.g. managing the various peripheral devices e.g. mouse, keyboard
  - 3 - It provides a user interface, e.g. command line, graphical user interface (GUI)
  - 4 - It handles system resources such as computer's memory and sharing of the central processing unit(CPU) time by various applications or peripheral devices.
  - 5 - It provides file management which refers to the way that the operating system manipulates, stores, retrieves and saves data.
  - 6 - Error Handling is done by the operating system. It takes preventive measures whenever required to avoid errors.

<br>
<br>

---

<br>
<br>

# Types of Operating Systems

- Following are some of the most widely used types of Operating system:
  - 1 - Simple Batch System
  - 2 - Multiprogramming Batch System
  - 3 - Multiprocessor System
  - 4 - Desktop System
  - 5 - Distributed Operating System
  - 6 - Clustered System
  - 7 - Realtime Operating System
  - 8 - Handheld System

### Simple Batch Systems

- In this type of system, there is __no direct interaction between user and the computer.__ The user has to submit a job (written on cards or tape) to a computer operator.

  Then computer operator places a batch of several jobs on an input device. Jobs are batched together by type of languages and requirement. Then a special program, the monitor, manages the execution of each program in the batch. The monitor is always in the main memory and available for execution.

- `Advantages of Simple Batch Systems` - 
  - No interaction between user and computer.
  - No mechanism to prioritise the processes.

### Multiprogramming Batch Systems 

- In this the operating system picks up and begins to execute one of the jobs from memory. Once this job needs an I/O operation operating system switches to another job (CPU and OS always busy).Jobs in the memory are always less than the number of jobs on disk(Job Pool).
  
  If several jobs are ready to run at the same time, then the system chooses which one to run through the process of CPU Scheduling. In Non-multiprogrammed system, there are moments when CPU sits idle and does not do any work. In Multiprogramming system, CPU will never be idle and keeps on processing.

### Multiprocessor Systems

- A Multiprocessor system consists of several processors that share a common physical memory. Multiprocessor system provides higher computing power and speed. In multiprocessor system all processors operate under single operating system. Multiplicity of the processors and how they do act together are transparent to the others.

- `Advantages of Multiprocessor Systems`:
  - Enhanced performance
  - Execution of several tasks by different processors concurrently, increases the system's throughput without speeding up the execution of a single task.
  - If possible, system divides task into many subtasks and then these subtasks can be executed in parallel in different processors. Thereby speeding up the execution of single tasks.

### Desktop Systems

- Earlier, CPUs and PCs lacked the features needed to protect an operating system from user programs. PC operating systems therefore were neither multiuser nor multitasking. However, the goals of these operating systems have changed with time; instead of maximizing CPU and peripheral utilization, the systems opt for maximizing user convenience and responsiveness. These systems are called Desktop Systems and include PCs running `Microsoft Windows` and the `Apple Macintosh`

### Distrubuted Operating Systems 

- The motivation behind developing distributed operating systems is the availability of powerful and inexpensive microprocessors and advances in communication technology.
  
  These advancements in technology have made it possible to design and develop distributed systems comprising of many computers that are inter connected by communication networks. The main benefit of distributed systems is its low price/performance ratio.
  
- `Advantages Distributed Operating System` - 
  - Fast processing.
  - Less load on the Host Machine.

- Types of Distributed Operating Systems - 
  - Client-Server Systems
  - Peer-to-Peer Systems
  
  `Client-Server Systems`: Server Systems can be broadly categorized as: Compute Servers and File Servers.
    - __Computer Server Systems__: provide an interface to which clients can send requests to perform an action, in response to which they execute the action and send back results to the client.
    - __File Server Systems__: provide a file-system interface where clients can create, update, read, and delete files.
  
  `Peer-to-Peer Systems`: The growth of computer networks - especially the Internet and World Wide Web (WWW) – has had a profound influence on the recent development of operating systems. In contrast to the Tightly Coupled systems, the computer networks used in these applications consist of a collection of processors that do not share memory or a clock. Instead, each processor has its own local memory. The processors communicate with one another through various communication lines, such as high-speed buses or telephone lines. These systems are usually referred to as loosely coupled systems ( or distributed systems). 
  
### Clustered Systems

- Like parallel systems, clustered systems gather together multiple CPUs to accomplish computational work. Clustered systems differ from parallel systems, however, in that they are composed of two or more individual systems coupled together. 

  The definition of the term clustered is not concrete; the general accepted definition is that clustered computers share storage and are closely linked via LAN networking.

### Real Time Operating System

- It is defined as an operating system known to give maximum time for each of the critical operations that it performs, like OS calls and interrupt handling.

### Handheld Systems

- Handheld systems include Personal Digital Assistants(PDAs), such as `Palm-Pilots` or `Cellular Telephones` with connectivity to a network such as the Internet. They are usually of limited size due to which most handheld devices have a small amount of memory, include slow processors, and feature small display screens.
  
  Some handheld devices may use wireless technology such as BlueTooth, allowing remote access to e-mail and web browsing. Cellular telephones with connectivity to the Internet fall into this category. Their use continues to expand as network connections become more available and other options such as `cameras` and `MP3` players, expand their utility.

<br>
<br>

---

<br>

[Part 2](./README2.md)
  
