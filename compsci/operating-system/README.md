# Operating System

- An operating system (OS) is a collection of software that manages computer hardware resources and provides common services for computer programs. The operating system is a vital component of the system software in a computer system

  An Operating System (OS) is an interface between a computer user and computer hardware. An operating system is a software which performs all the basic tasks like file management, memory management, process management, handling input and output, and controlling peripheral devices such as disk drives and printers.
  
  Some popular Operating Systems include Linux Operating System, Windows Operating System, VMS, OS/400, AIX, z/OS, etc.
  
<br>
<br>

---

<br>
<br>

# Overview

- Following are some of important functions of an operating System:
  - Memory Management
  - Processor Management
  - Device Management
  - File Management
  - Security
  - Control over system performance
  - Job accounting
  - Error detecting aids
  - Coordination between other software and users

### Memory Management

- Memory management refers to management of Primary Memory or Main Memory. Main memory is a large array of words or bytes where each word or byte has its own address.

  Main memory provides a fast storage that can be accessed directly by the CPU. For a program to be executed, it must in the main memory. An Operating System does the following activities for memory management −
  - Keeps tracks of primary memory, i.e., what part of it are in use by whom, what part are not in use.
  - In multiprogramming, the OS decides which process will get memory when and how much.
  - Allocates the memory when a process requests it to do so.
  - De-allocates the memory when a process no longer needs it or has been terminated.

### Processor Management

- In multiprogramming environment, the OS decides which process gets the processor when and for how much time. This function is called `process scheduling`. An Operating System does the following activities for processor management −
  - Keeps tracks of processor and status of process. The program responsible for this task is known as `traffic controller`.
  - Allocates the processor (CPU) to a process.
  - De-allocates processor when a process is no longer required.

### Device Management

- An Operating System manages device communication via their respective drivers. It does the following activities for device management −
  - Keeps tracks of all devices. Program responsible for this task is known as the `I/O controller`.
  - Decides which process gets the device when and for how much time.
  - Allocates the device in the efficient way.
  - De-allocates devices.

### File Management

- A file system is normally organized into directories for easy navigation and usage. These directories may contain files and other directions.
  - Keeps track of information, location, uses, status etc. The collective facilities are often known as `file system`.
  - Decides who gets the resources.
  - Allocates the resources.
  - De-allocates the resources.

### Other Important Activities

- Following are some of the important activities that an Operating System performs −
  - `Security` − By means of password and similar other techniques, it prevents unauthorized access to programs and data.
  - `Control over system performance` − Recording delays between request for a service and response from the system.
  - `Job accounting` − Keeping track of time and resources used by various jobs and users.
  - `Error detecting aids` − Production of dumps, traces, error messages, and other debugging and error detecting aids
  - `Coordination between other softwares and users` − Coordination and assignment of compilers, interpreters, assemblers and other software to the various users of the computer systems.
  
<br>
<br>

---

<br>
<br>

# Types of Operating System

- Operating systems are there from the very first computer generation and they keep evolving with time

### Batch operating system

- The users of a batch operating system do not interact with the computer directly. Each user prepares his job on an off-line device like punch cards and submits it to the computer operator. To speed up processing, jobs with similar needs are batched together and run as a group. The programmers leave their programs with the operator and the operator then sorts the programs with similar requirements into batches

  The problems with Batch Systems are as follows −
  - Lack of interaction between the user and the job
  - Difficult to provide the desired priority.

### Time-sharing operating systems

- Time-sharing is a technique which enables many people, located at various terminals, to use a particular computer system at the same time. Time-sharing or multitasking is a logical extension of multiprogramming. The main difference between Multiprogrammed Batch Systems and Time-Sharing Systems is that in case of Multiprogrammed batch systems, the objective is to maximize processor use, whereas in Time-Sharing Systems, the objective is to minimize response time.

  The operating system uses CPU scheduling and multiprogramming to provide each user with a small portion of a time. Computer systems that were designed primarily as batch systems have been modified to time-sharing systems.
  
  Disadvantages of Time-sharing operating systems are as follows −
  - Question of security and integrity of user programs and data.
  - Problem of reliability.

### Distributed operating System

- Distributed systems use multiple central processors to serve multiple real-time applications and multiple users. Data processing jobs are distributed among the processors accordingly. The processors communicate with one another through various communication lines (such as high-speed buses or telephone lines). These are referred as loosely coupled systems or distributed systems. 

  The advantages of distributed systems are as follows −
  - With resource sharing facility, a user at one site may be able to use the resources available at another.
  - Speedup the exchange of data with one another via electronic mail.
  - If one site fails in a distributed system, the remaining sites can potentially continue operating.
  - Better service to the customers. ... etc.
 
### Network operating System

- A Network Operating System runs on a server and provides the server the capability to manage data, users, groups, security, applications, and other networking functions. The primary purpose of the network operating system is to allow shared file and printer access among multiple computers in a network, typically a local area network (LAN), a private network or to other networks.

  Examples of network operating systems include Microsoft Windows Server 2003, Microsoft Windows Server 2008, UNIX, Linux, Mac OS X, Novell NetWare, and BSD.
  
  The advantages of network operating systems are as follows −
  - Centralized servers are highly stable.
  - Security is server managed.
  
  The disadvantages of network operating systems are as follows −
  - High cost of buying and running a server.
  - Regular maintenance and updates are required.

### Real Time operating System

- A real-time system is defined as a data processing system in which the time interval required to process and respond to inputs is so small that it controls the environment

  Real-time systems are used when there are rigid time requirements on the operation of a processor or the flow of data and real-time systems can be used as a control device in a dedicated application. A real-time operating system must have well-defined, fixed time constraints, otherwise the system will fail. For example, Scientific experiments, medical imaging systems, industrial control systems, weapon systems, robots, air traffic control systems, etc.
  
  There are two types of real-time operating systems.
  - `Hard real-time systems` -- Hard real-time systems guarantee that critical tasks complete on time. In hard real-time systems, secondary storage is limited or missing and the data is stored in ROM. In these systems, virtual memory is almost never found.
  - `Soft real-time systems` -- Soft real-time systems are less restrictive. A critical real-time task gets priority over other tasks and retains the priority until it completes. Soft real-time systems have limited utility than hard real-time systems. For example, multimedia, virtual reality

<br>
<br>

---

<br>
<br>

# Services

- Following are a few common services provided by an operating system −
  - Program execution
  - I/O operations
  - File System manipulation
  - Communication
  - Error Detection
  - Resource Allocation
  - Protection
  
### Program execution

- Operating systems handle many kinds of activities from user programs to system programs like printer spooler, name servers, file server, etc. Each of these activities is encapsulated as a process. A process includes the complete execution context (code to execute, data to manipulate, registers, OS resources in use).

### I/O Operation

- An I/O subsystem comprises of I/O devices and their corresponding driver software. Drivers hide the peculiarities of specific hardware devices from the users.

### File system manipulation

- A file represents a collection of related information. Computers can store files on the disk (secondary storage), for long-term storage purpose. Examples of storage media include magnetic tape, magnetic disk and optical disk drives like CD, DVD. Each of these media has its own properties like speed, capacity, data transfer rate and data access methods.

### Communication

- In case of distributed systems which are a collection of processors that do not share memory, peripheral devices, or a clock, the operating system manages communications between all the processes. Multiple processes communicate with one another through communication lines in the network.

### Error handling

- Errors can occur anytime and anywhere. An error may occur in CPU, in I/O devices or in the memory hardware.

### Resource Management

- In case of multi-user or multi-tasking environment, resources such as main memory, CPU cycles and files storage are to be allocated to each user or job.

### Protection

- Considering a computer system having multiple users and concurrent execution of multiple processes, the various processes must be protected from each other's activities.

<br>
<Br>
  
---

<br>
<br>

# Properties

- `Batch Processing` -- Batch processing is a technique in which an Operating System collects the programs and data together in a batch before processing starts. An operating system does the following activities related to batch processing −

- `Multitasking` -- Multitasking is when multiple jobs are executed by the CPU simultaneously by switching between them. Switches occur so frequently that the users may interact with each program while it is running

- `Multiprogramming` -- Sharing the processor, when two or more programs reside in memory at the same time, is referred as multiprogramming. Multiprogramming assumes a single shared processor. Multiprogramming increases CPU utilization by organizing jobs so that the CPU always has one to execute.

- `Interactivity` -- Interactivity refers to the ability of users to interact with a computer system.

- `Real Time System` -- Real-time systems are usually dedicated, embedded systems in such systems, Operating Systems typically read from and react to sensor data.

- `Distributed Environment` -- A distributed environment refers to multiple independent CPUs or processors in a computer system.

- `Spooling` -- Spooling is an acronym for simultaneous peripheral operations on line. Spooling refers to putting data of various I/O jobs in a buffer. This buffer is a special area in memory or hard disk which is accessible to I/O devices.

<br>
<br>

---

<br>
<br>

# Processes

- A process is basically a program in execution. The execution of a process must progress in a sequential fashion. To put it in simple terms, we write our computer programs in a text file and when we execute this program, it becomes a process which performs all the tasks mentioned in the program.

  When a program is loaded into the memory and it becomes a process, it can be divided into four sections ─ stack, heap, text and data
  - `Stack` -- The process Stack contains the temporary data such as method/function parameters, return address and local variables.
  - `Heap` -- This is dynamically allocated memory to a process during its run time.
  - `Text` -- This includes the current activity represented by the value of Program Counter and the contents of the processor's registers.
  - `Data` -- This section contains the global and static variables.

### Process Life Cycle

- When a process executes, it passes through different states. These stages may differ in different operating systems
  - `Start` -- This is the initial state when a process is first started/created.
  - `Ready` -- The process is waiting to be assigned to a processor. Ready processes are waiting to have the processor allocated to them by the operating system so that they can run
  - `Running` -- Once the process has been assigned to a processor by the OS scheduler, the process state is set to running and the processor executes its instructions.
  - `Waiting` -- Process moves into the waiting state if it needs to wait for a resource, such as waiting for user input
  - `Terminated or Exit` -- Once the process finishes its execution, or it is terminated by the operating system

### Process Control Block (PCB)

- A Process Control Block is a data structure maintained by the Operating System for every process. The PCB is identified by an integer process ID (PID). A PCB keeps all the information needed to keep track of a process:
  - `Process State` -- The current state of the process i.e., whether it is ready, running, waiting, or whatever.
  - `Process privileges` -- This is required to allow/disallow access to system resources.
  - `Process ID` -- Unique identification for each of the process in the operating system.
  - `Pointer` -- A pointer to parent process.
  - `Program Counter` -- Program Counter is a pointer to the address of the next instruction to be executed for this process.
  - `CPU registers` -- Various CPU registers where process need to be stored for execution for running state.
  - `CPU Scheduling Information` -- Process priority and other scheduling information which is required to schedule the process.
  - `Memory management information` -- This includes the information of page table, memory limits
  - `Accounting information` -- This includes the amount of CPU used for process execution, time limits, execution ID etc
  - `IO status information` -- This includes a list of I/O devices allocated to the process.
  - ...etc

<br>
<br>

---

<br>
<br>



  
