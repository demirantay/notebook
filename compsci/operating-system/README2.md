- [Part 1](./README)

---

<br>

# Operating System Processes

- `What is a Process`: A process is a program in execution. Process is not as same as program code but a lot more than it. A process is an 'active' entity as opposed to program which is considered to be a 'passive' entity. Attributes held by process include hardware state, memory, CPU etc.

  __Process memory__ is divided into four sections for efficient working :
    - 1 - `Text section`: is made up of the compiled program code, read in from non-volatile storage when the program is launched. 
    - 2 - `Data Section`: is made up the global and static variables, allocated and initialized prior to executing the main.
    - 3 - `Heap Section`: is used for the dynamic memory allocation, and is managed via calls to new, delete, malloc, free, etc.
    - 4 - `Stack Section`: is used for local variables. Space on the stack is reserved for local variables when they are declared.

### Different Process States

- Processes in the operating system can be in any of the following states:
  - `NEW` - The process is being created.
  - `READY` - The process is waiting to be assigned to a processor.
  - `RUNNING` - Instructions are being executed.
  - `WAITING` - The process is waiting for some event to occur(such as an I/O completion or reception of a signal).
  - `TERMINATED` - The process has finished execution.

### Process Control Block

- There is a Process Control Block for each process, enclosing all the information about the process. It is a data structure, which contains the following:
  - __Process State__: It can be running, waiting etc.
  - __Process ID__: and the __parent process ID__.
  - __Program Counter__:  holds the address of the next instruction to be executed for that process.
  - __CPU Scheduling__ information: Such as priority information and pointers to scheduling queues.
  - __Memory Management information__: For example, page tables or segment tables.
  - __Accounting information__: The User and kernel CPU time consumed, account numbers, limits, etc. 
  - __I/O Status information__: Devices allocated, open file tables, etc.

<br>
<br>

---

<br>
<br>

# Process Scheduling 

- The act of determining which process is in the `ready` state, and should be moved to the `running` state is known as `Process Scheduling`.
  
  The prime aim of the process scheduling system is to keep the CPU busy all the time and to deliver minimum response time for all programs. For achieving this, the scheduler must apply appropriate rules for swapping processes `IN` and `OUT` of CPU.

### What are Scheduling Queues

- All processes, upon entering into the system, are stored in the __Job Queue__.
- Processes in the `Ready` state are placed in the __Ready Queue__.
- Processes waiting for a device to become available are placed in `Device Queues`. There are unique device queues available for each I/O device
- The process could issue an I/O request, and then be placed in the __I/O queue__.
- ... etc.

### Types of Schedulers

- There are three types of schedulers available:
  - Long Term Scheduler
  - Short Term Scheduler
  - Medium Term Scheduler

- `Long Term Scheduler`: Long term scheduler runs less frequently. Long Term Schedulers decide which program must get into the job queue. From the job queue, the Job Processor, selects processes and loads them into the memory for execution. Primary aim of the Job Scheduler is to maintain a good degree of Multiprogramming. An optimal degree of Multiprogramming means the average rate of process creation is equal to the average departure rate of processes from the execution memory.

- `Short Term Scheduler`: This is also known as CPU Scheduler and runs very frequently. The primary aim of this scheduler is to enhance CPU performance and increase process execution rate.

- `Medium Term Scheduler`: This scheduler removes the processes from memory (and from active contention for the CPU), and thus reduces the degree of multiprogramming. At some later time, the process can be reintroduced into memory and its execution van be continued where it left off. This scheme is called swapping. The process is swapped out, and is later swapped in, by the medium term scheduler.

### What is Context Switch 

- Left here: https://www.studytonight.com/operating-system/process-scheduling

### Operations on Process

### Process Creation

### Process Termination

<br>
<br>

---

<br>
<br>

# CPU Scheduling 


