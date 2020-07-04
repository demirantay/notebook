# 6 - Mechanism: Limited Direct Execution

- In order to virtualize the CPU, the operating system needs to somehow
share the physical CPU among many jobs running seemingly at the same
time. The basic idea is simple: run one process for a little while, then
run another one, and so forth. By time sharing the CPU in this manner,
virtualization is achieved. Obtaining high performance while maintaining control is thus
one of the central challenges in building an operating system.

- __`Basic Technique: Limited Direct Execution`__ -- To make a program run as fast as one might expect, not surprisingly
OS developers came up with a technique, which we call limited direct
execution. The “direct execution” part of the idea is simple: just run the
program directly on the CPU. Thus, when the OS wishes to start a program running, it creates a process entry for it in a process list, allocates
some memory for it, loads the program code into memory (from disk), locates its entry point (i.e., the main() routine or something similar), jumps to it, and starts running the user’s code.

  In developing this technique, we’ll also see where the “limited” part of the name arises from; without
limits on running programs, the OS wouldn’t be in control of anything
and thus would be “just a library” — a very sad state of affairs for an
aspiring operating system!

- __`Problem #1: Restricted Operations`__ -- Direct execution has the obvious advantage of being fast; the program
runs natively on the hardware CPU and thus executes as quickly as one
would expect. But running on the CPU introduces a problem: what if
the process wishes to perform some kind of restricted operation, such
as issuing an I/O request to a disk, or gaining access to more system
resources such as CPU or memory ? Which is a big NO NO because if you harm any of your phsicial chips they are harmed permenantly.

  Thus, the approach we take is to introduce a new processor mode,
known as `user mode`; code that runs in user mode is restricted in what it
can do.

  In contrast to user mode is kernel mode, which the operating system
(or kernel) runs in. In this mode, code that runs can do what it likes, including privileged operations such as issuing I/O requests and executing
all types of restricted instructions

  We are still left with a challenge, however: what should a user process do when it wishes to perform some kind of privileged operation,
such as reading from disk? To enable this, virtually all modern hardware provides the ability for user programs to perform a `system call`. system calls
allow the kernel to carefully expose certain key pieces of functionality to
user programs, such as accessing the file system, creating and destroying processes, communicating with other processes, and allocating more.  Most operating systems provide a few hundred calls (see the
POSIX standard for details

  To execute a system call, a program must execute a special trap instruction. This instruction simultaneously jumps into the kernel and raises the
privilege level to kernel mode; once in the kernel, the system can now perform whatever privileged operations are needed (if allowed), and thus do
the required work for the calling process. When finished, the OS calls a
special return-from-trap instruction, which, as you might expect, returns
into the calling user program while simultaneously reducing the privilege level back to user mode

  There are two phases in the limited direct execution (LDE) protocol.
In the first (at boot time), the kernel initializes the trap table, and the
CPU remembers its location for subsequent use. The kernel does so via a
privileged instruction In the second (when running a process), the kernel sets up a few things
(e.g., allocating a node on the process list, allocating memory) before using a return-from-trap instruction to start the execution of the process;
this switches the CPU to user mode and begins running the process.

- __`Problem #2: Switching Between Processes`__ -- How can the operating system regain control of the CPU so that it can
switch between processes?

  A Cooperative Approach: Wait For System Calls -- One approach that some systems have taken in the past (for example,
early versions of the Macintosh operating system [M11], or the old Xerox
Alto system [A79]) is known as the cooperative approach. In this style,
the OS trusts the processes of the system to behave reasonably. Processes
that run for too long are assumed to periodically give up the CPU so that
the OS can decide to run some other task.

  A Non-Cooperative Approach: The OS Takes Control -- How can the OS gain control of the CPU even if processes are not being
cooperative? What can the OS do to ensure a rogue process does not take
over the machine? The answer turns out to be simple and was discovered by a number
of people building computer systems many years ago: a timer interrupt
[M+63]. A timer device can be programmed to raise an interrupt every
so many milliseconds; when the interrupt is raised, the currently running
process is halted, and a pre-configured interrupt handler in the OS runs. operation. Once the timer has begun, the OS can thus feel safe in that
control will eventually be returned to it, and thus the OS is free to run
user programs

  Now that the OS has regained control, whether cooperatively via a system call, or more forcefully via a timer interrupt, a decision has to be
made: whether to continue running the currently-running process, or
switch to a different one. This decision is made by a part of the operating
system known as the `scheduler`. If the decision is made to switch, the OS then executes a low-level
piece of code which we refer to as a `context switch`.

- Operating systems often have to deal with misbehaving processes, those
that either through design (maliciousness) or accident (bugs) attempt to
do something that they shouldn’t. In modern systems, the way the OS
tries to handle such malfeasance is to simply terminate the offender. One
strike and you’re out! Perhaps brutal, but what else should the OS do
when you try to access memory illegally or execute an illegal instruction?

- __`Worried About Concurrency?`__ -- The answer is yes, the OS does indeed need to be concerned as to what
happens if, during interrupt or trap handling, another interrupt occurs.
This, in fact, is the exact topic of the entire second piece of this book, on
concurrency; we’ll defer a detailed discussion until then

- __`Summary`__ -- We have described some key low-level mechanisms to implement CPU
virtualization, a set of techniques which we collectively refer to as limited
direct execution. The basic idea is straightforward: just run the program
you want to run on the CPU, but first make sure to set up the hardware
so as to limit what the process can do without OS assistance.

<br>
<br>

---

<br>
<br>

# 7 - Scheduling: Introduction

- __`Workload Assumptions`__ --

- __`Scheduling Metrics`__ --

- __`First In, First Out (FIFO)`__ --

- __`Shortest Job First (SJF)`__ --

- __`Shortest Time-to-Completion First (STCF)`__ --

- __`A New Metric: Response Time`__ --

- __`Round Robin`__ --

- __`Incorporating I/O`__ --

- __`No More Oracle`__ --

- __`Summary`__ -- 

<br>
<br>

---

<br>
<br>

# 8 -  Scheduling: The Multi-Level Feedback Queue

- `MLFQ: Basic Rules` --

- `Attempt #1: How To Change Priority` --

- `Attempt #2: The Priority Boost` --

- `Attempt #3: Better Accounting` --

- `Tuning MLFQ And Other Issues` --

- `MLFQ: Summary` -- 

<br>
<br>

---

<br>
<br>

# 9 - Scheduling: Proportional Share

- `Basic Concept: Tickets Represent Your Share` --

- `Ticket Mechanisms` --

- `Implementation` --

- `An Example` --

- `How To Assign Tickets?` --

- `Why Not Deterministic?` --

- `The Linux Completely Fair Scheduler (CFS)` --

- `Summary` --

<br>
<br>

---

<br>
<br>


