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

### Real world

<br>
<Br>

---

<Br>
<br>

# 1 Operating System Organisation

### Abstracting physical resources

### User mode, kernel mode, and system calls

### Kernel organization

### Process overview

### Code: the first address space

### Code: creating the first process

### Code: Running the first process

### The first system call: exec

### Real world

### Exercises

<br>
<Br>

---

<Br>
<br>

# 2 Page Tables

### Paging hardware

### Process address space

### Code: creating an address space

### Physical memory allocation

### Code: Physical memory allocator

### User part of an address space

### Code: sbrk

### Code: exec

### Real world

<br>
<Br>

---

<Br>
<br>

# 3 Traps, Interrupts, Drivers

### Systems calls, exceptions, and interrupts

### X86 protection

### Code: The first system call

### Code: Assembly trap handlers

### Code: C trap handler

### Code: System calls

### Code: Interrupts

### Drivers

### Code: Disk driver

### Real world

<br>
<Br>

---

<Br>
<br>

# 4 Locking

### Race conditions

### Code: Locks

### Code: Using locks

### Deadlock and lock ordering

### Interrupt handlers

### Instruction and memory ordering

### Sleep locks

### Limitations of locks

### Real world

<br>
<Br>

---

<Br>
<br>

# 5 Scheduling

### Multiplexing

### Code: Context switching

### Code: Scheduling

### Code: mycpu and myproc

### Sleep and wakeup

### Code: Sleep and wakeup

### Code: Pipes

### Code: Wait, exit, and kill

### Real world

<br>
<Br>

---

<Br>
<br>

# 6 File System

### Overview

### Buffer cache layer 

### Code: Buffer cache

### Logging layer

### Log design

### Code: logging

### Code: Block allocator

### Inode layer

### Code: Inodes

### Code: Inode content

### Code: directory layer

### Code: Path names

### File descriptor layer

### Code: System calls

### Real world

<br>
<Br>

---

<Br>
<br>

# 7 Summary

<br>
<Br>

---

<Br>
<br>

# A PC Hardware

### Processor and memory

### I/O

### 

<br>
<Br>

---

<Br>
<br>

# A The Boot Loader

### Code: Assembly bootstrap

### Code: C bootstrap

### Real world

<br>
