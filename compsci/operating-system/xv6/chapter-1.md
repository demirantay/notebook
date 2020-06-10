# xv6 -- a simple, Unix-like teaching operating system

This is a draft text intended for a class on operating systems. It explains the main concepts of operating systems by studying an example kernel, named xv6. xv6 is a re-implementation of Dennis Ritchie’s and Ken Thompson’s Unix Version 6 (v6). xv6 loosely follows the structure and style of v6, but is implemented in ANSI C for an x86-
based multiprocessor.

Table of Contents:
- [0 Operating System Interfaces]()
- [1 Operating System Organisation]()
- [2 Page Tables]()
- [3 Traps, Interrupts, Drivers]()
- [4 Locking]()
- [5 Scheduling]()
- [6 File System]()
- [7 Summary]()
- [A PC Hardware]()
- [A The Boot Loader]()

<br>
<br>

# 0 Operating System Interfaces

- The job of an operating system is to share a computer among multiple programs
and to provide a more useful set of services than the hardware alone supports. The
operating system manages and abstracts the low-level hardware, so that, for example, a
word processor need not concern itself with which type of disk hardware is being
used. It also shares the hardware among multiple programs so that they run (or appear to run) at the same time. 

  An operating system provides services to user programs through an interface.
Designing a good interface turns out to be difficult. 

  Unix provides a narrow interface whose mechanisms
combine well, offering a surprising degree of generality. This interface has been so
successful that modern operating systems—BSD, Linux, Mac OS X, Solaris, and even,
to a lesser extent, Microsoft Windows—have Unix-like interfaces. 

  The rest of this chapter outlines xv6’s services—processes, memory, file descriptors, pipes, and file system—and illustrates them with code snippets and discussions of
how the shell, which is the primary user interface to traditional Unix-like systems,
uses them.

  The shell is an ordinary program that reads commands from the user and executes them. The fact that the shell is a user program, not part of the kernel, illustrates
the power of the system call interface: there is nothing special about the shell. It also
means that the shell is easy to replace; as a result, modern Unix systems have a variety
of shells to choose from

- Here are some systam calls with their descriptions (these are not all system calls they are just the tip of the iceberg):
  - `fork()` -- Create a process
  - `exit()` -- Terminate the current process
  - `wait()` -- Wait for a child process to exit
  - `kill(pid)` -- Terminate process pid
  - `getpid()` -- Return the current process’s pid
  - `sleep(n)` -- Sleep for n clock ticks
  - `exec(filename, *argv)` --  Load a file and execute it
  - `sbrk(n)` -- Grow process’s memory by n bytes
  - `open(filename, flags)` -- Open a file; the flags indicate read/write
  - `read(fd, buf, n) ` -- Read n bytes from an open file into buf
  - `write(fd, buf, n)` -- Write n bytes to an open file
  - `close(fd)` -- Release open file fd
  - `dup(fd)` -- Duplicate fd
  - `pipe(p)` -- Create a pipe and return fd’s in p
  - `chdir(dirname)` -- Change the current directory
  - `mkdir(dirname)` -- Create a new directory
  - `mknod(name, major, minor)` -- Create a device file
  - `fstat(fd)` -- Return info about an open file
  - `link(f1, f2)` -- Create another name (f2) for the file f1
  - `unlink(filename)` -- Remove a file

### Processes and memory

- An xv6 process consists of user-space memory (instructions, data, and stack) and
per-process state private to the kernel. Xv6 can time-share processes: it transparently
switches the available CPUs among the set of processes waiting to execute. When a
process is not executing, xv6 saves its CPU registers, restoring them when it next runs
the process. The kernel associates a process identifier, or pid, with each process.

- The xv6 shell uses the above calls to run programs on behalf of users. The main
structure of the shell is simple; see main (8701). The main loop reads a line of input
from the user with getcmd. Then it calls fork, which creates a copy of the shell process. The parent calls wait, while the child runs the command. For example, if the
user had typed ‘‘echo hello’’ to the shell, runcmd would have been called with ‘‘echo
hello’’ as the argument. runcmd (8606) runs the actual command. For ‘‘echo hello’’, it
would call exec (8626). If exec succeeds then the child will execute instructions from
echo instead of runcmd. At some point echo will call exit, which will cause the parent to return from wait in main (8701). You might wonder why fork and exec are not
combined in a single call; we will see later that separate calls for creating a process
and loading a program is a clever design

### I/O and File descriptors

- A file descriptor is a small integer representing a kernel-managed object that
a process may read from or write to. A process may obtain a file descriptor by opening a file, directory, or device, or by creating a pipe, or by duplicating an existing descriptor. For simplicity we’ll often refer to the object a file descriptor refers to as a "file"

### Pipes

- A pipe is a small kernel buffer exposed to processes as a pair of file descriptors,
one for reading and one for writing. Writing data to one end of the pipe makes that
data available for reading from the other end of the pipe. Pipes provide a way for
processes to communicate

  The xv6 shell implements pipelines such as `grep fork sh.c | wc -l` in a manner where each process feeds the input to the next process ... etc.
  
  Pipes may seem no more powerful than temporary files: the pipeline
  ```
  echo hello world | wc
  ```
  could be implemented without pipes as
  ```
  echo hello world >/tmp/xyz; wc </tmp/xyz
  ```

### File system

- The xv6 file system provides data files, which are uninterpreted byte arrays, and
directories, which contain named references to data files and other directories. The directories form a tree, starting at a special directory called the root.

  Paths that don’t begin with / are evaluated
relative to the calling process’s current directory, which can be changed with the
chdir system call.

  Shell commands for file system operations are implemented as user-level programs such as mkdir, ln, rm, etc. This design allows anyone to extend the shell with new user commands by just adding a new user-level program

### Real world

- Unix’s combination of the ‘‘standard’’ file descriptors, pipes, and convenient shell
syntax for operations on them was a major advance in writing general-purpose
reusable programs. The idea sparked a whole culture of ‘‘software tools’’ that was responsible for much of Unix’s power and popularity, and the shell was the first so-called
‘‘scripting language.’’ The Unix system call interface persists today in systems like BSD,
Linux, and Mac OS X.

  The Unix system call interface has been standardized through the Portable Operating System Interface (POSIX) standard. Xv6 is not POSIX compliant. It misses system calls (including basic ones such as lseek), it implements systems calls only partially, etc. 
  
  Modern kernels, however, provide many more system calls, and many more kinds of
kernel services, than xv6. For example, they support networking, Window systems, user-level threads, drivers for many devices, and so on

  The file system abstraction has been a powerful idea, most recently applied to
network resources in the form of the World Wide Web. Even so, there are other models for operating system interfaces. Multics, a predecessor of Unix, abstracted file storage in a way that made it look like memory, producing a very different flavor of interface. 

  This book examines how xv6 implements its Unix-like interface, but the ideas and
concepts apply to more than just Unix. Any operating system must multiplex processes onto the underlying hardware, isolate processes from each other, and provide mechanisms for controlled inter-process communication.

<br>
<Br>

---

<Br>
<br>

# 1 Operating System Organisation

- A key requirement for an operating system is to support several activities at once.
For example, using the system call interface described in chapter 0 a process can start
new processes with fork. The operating system must time-share the resources of the
computer among these processes. Thus an
operating system must fulfil three requirements: multiplexing, isolation, and
interaction.

  This chapter provides an overview of how operating systems are organized to
achieve these 3 requirements. It turns out there are many ways to do so, but this text
focuses on mainstream designs centered around a monolithic kernel, which is used
by many Unix operating systems

  Xv6 runs on Intel 80386 or later (‘‘x86’’) processors on a PC platform, and much
of its low-level functionality (for example, its process implementation) is x86-specific.

### Abstracting physical resources

- The first question one might ask when encountering an operating system is why
have it at all? That is, one could implement the system calls in Figure 0-2 as a library,
with which applications link

  The downside of this library approach is that, if there is more than one applica tion running, the applications must be well-behaved. For example, each application
must periodically give up the processor so that other applications can run. Such a cooperative time-sharing scheme may be OK if all applications trust each other and have
no bugs. 

  As you can see, the system call interface in Figure 0-2 is carefully designed to
provide both programmer convenience and the possibility of strong isolation. The
Unix interface is not the only way to abstract resources, but it has proven to be a very
good one.

### User mode, kernel mode, and system calls

- Strong isolation requires a hard boundary between applications and the operating
system. If the application makes a mistake, we don’t want the operating system to fail.
Instead, the operating system should be able to clean up the failed application and
continue running other applications Applications shouldn’t be able to modify (or even
read) the operating system’s data structures or instructions, should be able to access
other process’s memory, etc.

  Processors provide hardware support for strong isolation. For example, the x86
processor, like many other processors, has two modes in which the processor can execute instructions: kernel mode and user mode. In kernel mode the processor is allowed to execute privileged instructions. For example, reading and writing the
disk (or any other I/O device) involves privileged instructions. 

  If an application in
user mode attempts to execute a privileged instruction, then the processor doesn’t exe cute the instruction, but switches to kernel mode so that the software in kernel mode
can clean up the application, because it did something it shouldn’t be doing. The software running in kernel space (or in kernel
mode) is called the kernel.

  An application that wants to read or write a file on disk must transition to the
kernel to do so, because the application itself can not execute I/O instructions.  Processors provide a special instruction that switches the processor from user mode to kernel
mode and enters the kernel at an entry point specified by the kernel.

### Kernel organization

- A key design question is what part of the operating system should run in kernel
mode. One possibility is that the entire operating system resides in the kernel, so that
the implementations of all system calls run in kernel mode. This organization is called
a monolithic kernel.

  In this organization the entire operating system runs with full hardware privilege.
This organization is convenient because the OS designer doesn’t have to decide which
part of the operating system doesn’t need full hardware privilege A downside of the monolithic organization is that the interfaces between different
parts of the operating system are often complex

  If the kernel fails, the computer stops working, and thus all applications fail too. The computer must reboot to start again
  
- To reduce the risk of mistakes in the kernel, OS designers can minimize the
amount of operating system code that runs in kernel mode, and execute the bulk of
the operating system in user mode. This kernel organization is called a microkernel.

  In a microkernel, the kernel interface consists of a few low-level functions for
starting applications, sending messages, accessing device hardware, etc. This organization allows the kernel to be relatively simple, as most of the operating system resides
in user-level servers

### Process overview

- The unit of isolation in xv6 (as in other Unix operating systems) is a process.
The process abstraction prevents one process from wrecking or spying on another process’ memory, CPU, file descriptors, etc. It also prevents a process from wrecking the
kernel itself, so that a process can’t subvert the kernel’s isolation mechanisms.

  The kernel must implement the process abstraction with care because a buggy or malicious
application may trick the kernel or hardware in doing something bad

  A process provides a program with what appears to be a private memory system, or address space, which other processes cannot read or write. A process also provides the program with what appears to be its
own CPU to execute the program’s instructions

  When the process enters the kernel (for a system call or interrupt), the kernel code executes on the
process’s kernel stack; while a process is in the kernel, its user stack still contains saved
data, but isn’t actively used. A process’s thread alternates between actively using its
user stack and its kernel stack. The kernel stack is separate (and protected from user
code) so that the kernel can execute even if a process has wrecked its user stack

  When a process makes a system call, the processor switches to the kernel stack,
raises the hardware privilege level, and starts executing the kernel instructions that implement the system call. When the system call completes, the kernel returns to user
space: the hardware lowers its privilege level, switches back to the user stack, and re sumes executing user instructions just after the system call instruction.

### The first system call: exec

- Now that we have seen how the kernel provides strong isolation for processes, let’s
look at how a user-level process re-enters the kernel to ask for services that it cannot
perform itself.

  The first action of initcode.S is to invoke the exec system call. As we saw in
Chapter 0, exec replaces the memory and registers of the current process with a new
program, but it leaves the file descriptors, process id, and parent process unchanged.

### Real world

- Most operating systems have adopted the process concept, and most processes
look similar to xv6’s. A real operating system would find free proc structures with an
explicit free list in constant time instead of the linear-time search in allocproc; xv6
uses the linear scan (the first of many) for simplicity

<br>
<Br>

---

<Br>
<br>

# 2 Page Tables

- Page tables are the mechanism through which the operating system controls what
memory addresses mean. They allow xv6 to multiplex the address spaces of different
processes onto a single physical memory, and to protect the memories of different processes xv6
uses page tables primarily to multiplex address spaces and to protect memor

### Paging hardware

- As a reminder, x86 instructions (both user and kernel) manipulate virtual addresses.
The machine’s RAM, or physical memory, is indexed with physical addresses. The x86
page table hardware connects these two kinds of addresses, by mapping each virtual
address to a physical address.

  An x86 page table is logically an array of 2^20 (1,048,576) page table entries
(PTEs). Each PTE contains a 20-bit physical page number (PPN) and some flags

  A few notes about terms. Physical memory refers to storage cells in DRAM. A
byte of physical memory has an address, called a physical address. Instructions use
only virtual addresses, which the paging hardware translates to physical addresses, and
then sends to the DRAM hardware to read or write storage. At this level of discussion
there is no such thing as virtual memory, only virtual addresses

### Process address space

- Each process has a separate page table, and xv6 tells the page table hardware to
switch page tables when xv6 switches between processe Having every process’s page table contain mappings for both user memory and
the entire kernel is convenient when switching from user code to kernel code during
system calls and interrupts: such switches do not require page table switches. For the
most part the kernel does not have its own page table; it is almost always borrowing
some process’s page table

### Physical memory allocation

- The kernel must allocate and free physical memory at run-time for page tables,
process user memory, kernel stacks, and pipe buffers

  xv6 uses the physical memory between the end of the kernel and PHYSTOP for
run-time allocation. It allocates and frees whole 4096-byte pages at a time. It keeps
track of which pages are free by threading a linked list through the pages themselves.
Allocation consists of removing a page from the linked list; freeing consists of adding the freed page to the list

### Real world

- Like most operating systems, xv6 uses the paging hardware for memory protection and mapping. Most operating systems use x86’s 64-bit paging hardware Memory allocation was a hot topic a long time ago, the basic problems being efficient use of limited memory and preparing for unknown future requests; see Knuth.
Today people care more about speed than space-efficiency. We need fast computers, networks, sites, ... speed is the name of the game.

<br>
<Br>

---

<Br>
<br>

