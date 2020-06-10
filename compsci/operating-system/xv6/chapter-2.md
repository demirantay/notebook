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
