# Memory Management

- Main Memory refers to a physical memory that is the internal memory to the computer. The word main is used to distinguish it from external mass storage devices such as disk drives. Main memory is also known as RAM. The computer is able to change only data that is in main memory. Therefore, every program we execute and every file we access must be copied from a storage device into main memory.

  All the programs are loaded in the main memeory for execution. Sometimes complete program is loaded into the memory, but some times a certain part or routine of the program is loaded into the main memory only when it is called by the program, this mechanism is called Dynamic Loading, this enhance the performance.
  
- `Swapping` -- A process needs to be in memory for execution. But sometimes there is not enough main memory to hold all the currently active processes in a timesharing system. So, excess process are kept on disk and brought in to run dynamically. Swapping is the process of bringing in each process in main memory, running it for a while and then putting it back to the disk.

- `Contiguous Memory Allocation` -- In contiguous memory allocation each process is contained in a single contiguous block of memory. Memory is divided into several fixed size partitions. Each partition contains exactly one process. When a partition is free, a process is selected from the input queue and loaded into it.

- `Memory Protection` -- Memory protection is a phenomenon by which we control memory access rights on a computer. The main aim of it is to prevent a process from accessing memory that has not been allocated to it. Hence prevents a bug within a process from affecting other processes, or the operating system itsel

- `Memory Allocation` -- Memory allocation is a process by which computer programs are assigned memory or space. It is of three types :
  - First Fit (The first hole that is big enough is allocated to program)
  - Best Fit  (The smallest hole that is big enough is allocated to program.)
  - Worst Fit (The largest hole that is big enough is allocated to program.)

- `Fragmentation` -- Fragmentation occurs in a dynamic memory allocation system when most of the free blocks are too small to satisfy any request. It is generally termed as inability to use the available memory.

- `Paging` -- A solution to fragmentation problem is Paging. Paging is a memory management mechanism that allows the physical address space of a process to be non-contagious. Here physical memory is divided into blocks of equal size called Pages. The pages belonging to a certain process are loaded into available memory frames.

  `page table` -- A Page Table is the data structure used by a virtual memory system in a computer operating system to store the mapping between virtual address and physical addresses.

- `Segmentation` -- Segmentation is another memory management scheme that supports the user-view of memory. Segmentation allows breaking of the virtual address space of a single process into segments that may be placed in non-contiguous areas of physical memory.

<br>
<br>

---

<br>
<br>

# Virtual Memory

- Virtual Memory is a space where large programs can store themselves in form of pages while their execution and only the required pages or portions of processes are loaded into the main memory. This technique is useful as large virtual memory is provided for user programs when a very small physical memory is there.

  In real scenarios, most processes never need all their pages at once, for following reasons :
  - Error handling code is not needed unless that specific error occurs, some of which are quite rare.
  - Arrays are often over-sized for worst-case scenarios, and only a small fraction of the arrays are actually used in practice.
  - Certain features of certain programs are rarely used.
  
- `Benefits of having Virtual Memory` -- Large programs can be written, as virtual space available is huge compared to physical memory. More physical memory available, as programs are stored on virtual memory, so they occupy very less space on actual physical memory.

<br>
<br>

---

<br>
<br>

# File System

- A file can be "free formed", indexed or structured collection of related bytes having meaning only to the one who created it. Or in other words an entry in a directory is the file. The file may have attributes like name, creator, date, type, permissions etc.

- `Attributes of a File` -- Following are some of the attributes of a file :
  - Name . It is the only information which is in human-readable form.
  - Identifier. The file is identified by a unique tag(number) within file system.
  - Type. It is needed for systems that support different types of files.
  - Location. Pointer to file location on device.
  - Size. The current size of the file.
  - Protection. This controls and assigns the power of reading, writing, executing.
  - Time, date, and user identification. This is the data for protection, security, and usage monitoring.

- `File Access Methods` -- The way that files are accessed and read into memory is determined by Access methods:
  - 1. Sequential Access
  - 2. Direct Access
  - 3. Indexed Sequential Access

- `What is a Directory?` -- Information about files is maintained by Directories. A directory can contain multiple files. It can even have directories inside of them. In Windows we also call these directories as folders Following is the information maintained in a directory :
  - Name : The name visible to user.
  - Type : Type of the directory.
  - Location : Device and location on the device where the file header is located.
  - Size : Number of bytes/words/blocks in the file.
  - Position : Current next-read/next-write pointers.
  - Protection : Access control on read/write/execute/delete.
  - Usage : Time of creation, access, modification etc.
  - Mounting : When the root of one file system is "grafted" into the existing tree of another file system its called Mounting.

<br>
<br>

---

<br>
<br>

# Secondary Storage

- Secondary storage devices are those devices whose memory is non volatile, meaning, the stored data will be intact even if the system is turned off. Here are a few things worth noting about secondary storage
  - Secondary storage is also called auxiliary storage.
  - Secondary storage is less expensive when compared to primary memory like RAMs.
  - The speed of the secondary storage is also lesser than that of primary storage.
  - Hence, the data which is less frequently accessed is kept in the secondary storage.
  - A few examples are magnetic disks, magnetic tapes, removable thumb drives etc.

<br>
<br>

---

<br>
<br>

# System Calls

- To understand system calls, first one needs to understand the difference between kernel mode and user mode of a CPU. Every modern operating system supports these two modes.

- `Kernel Mode` -- 
  - When CPU is in kernel mode, the code being executed can access any memory address and any hardware resource.
  - Hence kernel mode is a very privileged and powerful mode.
  - If a program crashes in kernel mode, the entire system will be halted.

- `User Mode` --
  - When CPU is in user mode, the programs don't have direct access to memory and hardware resources.
  - In user mode, if any program crashes, only that particular program is halted.
  - Hence, most programs in an OS run in user mode

- `System Call` -- When a program in user mode requires access to RAM or a hardware resource, it must ask the kernel to provide access to that resource. This is done via something called a system call. When a program makes a system call, the mode is switched from user mode to kernel mode. This is called a context switch.

  Then the kernel provides the resource which the program requested. After that, another context switch happens which results in change of mode from kernel mode back to user mode.
  
  Generally, system calls are made by the user level programs in the following situations:
   - Creating, opening, closing and deleting files in the file system.
   - Creating and managing new processes.
   - Creating a connection in the network, sending and receiving packets.
   - Requesting access to a hardware device, like a mouse or a printer.
   
   In a typical UNIX system, there are around 300 system calls.

- `Fork()` -- The fork() system call is used to create processes. When a process (a program in execution) makes a fork() call, an exact copy of the process is created. Now there are two processes, one being the parent process and the other being the child process.
