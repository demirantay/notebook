# 3 Traps, Interrupts, Drivers

- When running a process, a CPU executes the normal processor loop: read an instruction, advance the program counter, execute the instruction, repeat. But there are
events on which control from a user program must transfer back to the kernel instead
of executing the next instruction. These events include a device signaling that it wants
attention, a user program doing something illegal (e.g., references a virtual address for
which there is no page table entry), or a user program asking the kernel for a service
with a system call. There are three main challenges in handling these events: 1) the
kernel must arrange that a processor switches from user mode to kernel mode (and
back); 2) the kernel and devices must coordinate their parallel activities; and 3) the
kernel must understand the interface of the devices. Addressing these 3 challenges requires detailed understanding of hardware and careful programmin

### Systems calls, exceptions, and interrupts

- There are three cases when control must be transferred from a user program to the
kernel. First, a system call: when a user program asks for an operating system service,
as we saw at the end of the last chapter. Second, an exception: when a program performs an illegal action. Examples of illegal actions include divide by zero, attempt to
access memory for a page-table entry that is not present, and so on. Third, an interrupt: when a device generates a signal to indicate that it needs attention from the operating system. For example, a clock chip may generate an interrupt every 100 msec
to allow the kernel to implement time sharing

  The kernel handles all interrupts, rather than processes handling them, because in
most cases only the kernel has the required privilege and state To achieve this goal the operating system must be aware of the details of how the
hardware handles system calls, exceptions, and interrupts. In most processors these
three events are handled by a single hardware mechanism. 

### X86 protection

- The x86 has 4 protection levels, numbered 0 (most privilege) to 3 (least privilege).
In practice, most operating systems use only 2 levels: 0 and 3, which are then called
kernel mode and user mode, respectively. 

### Drivers

- A driver is the code in an operating system that manages a particular device: it tells
the device hardware to perform operations, configures the device to generate interrupts
when done, and handles the resulting interrupts. Driver code can be tricky to write
because a driver executes concurrently with the device that it manages. In addition,
the driver must understand the device’s interface (e.g., which I/O ports do what), and
that interface can be complex and poorly documented.

### Real world

- Supporting all the devices on a PC motherboard in its full glory is much work, because there are many devices, the devices have many features, and the protocol between device and driver can be complex. In many operating systems, the drivers together account for more code in the operating system than the core kernel.

  Actual device drivers are far more complex than the disk driver in this chapter,
but the basic ideas are the same: typically devices are slower than CPU, so the hardware uses interrupts to notify the operating system of status changes. 

  Some drivers dynamically switch between polling and interrupts, because using
interrupts can be expensive, but using polling can introduce delay until the driver processes an event. For example, for a network driver that receives a burst of packets,
may switch from interrupts to polling since it knows that more packets must be processed and it is less expensive to process them using polling.

<br>
<Br>

---

<Br>
<br>

# 4 Locking

- Xv6 runs on multiprocessors: computers with multiple CPUs executing independently. These multiple CPUs share physical RAM, and xv6 exploits the sharing to
maintain data structures that all CPUs read and write. This sharing raises the possibility of one CPU reading a data structure while another CPU is mid-way through updating it, or even multiple CPUs updating the same data simultaneously; without careful design such parallel access is likely to yield incorrect results or a broken data structure.

  Any code that accesses shared data concurrently must have a strategy for maintaining correctness despite concurrency. The concurrency may arise from accesses by
multiple cores, or by multiple threads, or by interrupt code. xv6 uses a handful of simple concurrency control strategies; much more sophistication is possible. This chapter
focuses on one of the strategies used extensively in xv6 and many other systems: the
lock.
A lock provides mutual exclusion, ensuring that only one CPU at a time can hold
the lock. 

### Deadlock and lock ordering

- If a code path through the kernel must hold several locks at the same time, it is important that all code paths acquire the locks in the same order. If they don’t, there is a
risk of deadlock. Let’s say two code paths in xv6 need locks A and B, but code path 1
acquires locks in the order A then B, and the other path acquires them in the order B
then A. This situation can result in a deadlock if two threads execute the code paths
concurrently

### Interrupt handlers

- Xv6 uses spin-locks in many situations to protect data that is used by both interrupt
handlers and threads. For example, a timer interrupt might (3414) increment ticks at
about the same time that a kernel thread reads ticks in sys_sleep (3823). The lock
tickslock serializes the two accesses

  Interrupts can cause concurrency even on a single processor: if interrupts are enabled, kernel code can be stopped at any moment to run an interrupt handler instead.

### Real world

- Concurrency primitives and parallel programming are active areas of research, because
programming with locks is still challenging. It is best to use locks as the base for
higher-level constructs like synchronized queues, although xv6 does not do this. If you
program with locks, it is wise to use a tool that attempts to identify race conditions,
because it is easy to miss an invariant that requires a lock.

  To avoid the expenses associated with locks, many operating systems use lock-free
data structures and algorithms. For example, it is possible to implement a linked list
like the one in the beginning of the chapter that requires no locks during list searches,
and one atomic instruction to insert an item in a list. Lock-free programming is more
complicated, however, than programming locks; for example, one must worry about instruction and memory reordering. Programming with locks is already hard, so xv6
avoids the additional complexity of lock-free programming.

<br>
<Br>

---

<Br>
<br>

# 5 Scheduling

- Any operating system is likely to run with more processes than the computer has
processors, and so a plan is needed to time-share the processors among the processes.
Ideally the sharing would be transparent to user processes. A common approach is to
provide each process with the illusion that it has its own virtual processor by multiplexing the processes onto the hardware processors. This chapter explains how xv6
achieves this multiplexing.

### Multiplexing

- Xv6 multiplexes by switching each processor from one process to another in two
situations. First, xv6’s sleep and wakeup mechanism switches when a process waits for
device or pipe I/O to complete, or waits for a child to exit, or waits in the sleep system call. Second, xv6 periodically forces a switch when a process is executing user instructions. This multiplexing creates the illusion that each process has its own CPU,
just as xv6 uses the memory allocator and hardware page tables to create the illusion
that each process has its own memory.

### Real world

- The xv6 scheduler implements a simple scheduling policy, which runs each process in turn. This policy is called round robin. Real operating systems implement
more sophisticated policies that, for example, allow processes to have priorities. The
idea is that a runnable high-priority process will be preferred by the scheduler over a
runnable low-priority thread. These policies can become complex quickly because
there are often competing goals: for example, the operating might also want to guarantee fairness and high-throughput. In addition, complex policies may lead to unintended interactions such as priority inversion and convoys. Priority inversion can
happen when a low-priority and high-priority process share a lock, which when acquired by the low-priority process can cause the high-priority process to not run

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
