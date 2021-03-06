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

- we have yet to understand the high-level policies that an OS scheduler employs. We will
now do just that, presenting a series of scheduling policies (sometimes
called disciplines) that various smart and hard-working people have developed over the years.

  The origins of scheduling, in fact, predate computer systems; early
approaches were taken from the field of operations management and applied to computers. This reality should be no surprise: assembly lines
and many other human endeavors also require scheduling, and many of
the same concerns exist therein, including a laser-like desire for efficiency

- __`Workload Assumptions`__ -- Before getting into the range of possible policies, let us first make a
number of simplifying assumptions about the processes running in the
system, sometimes collectively called the workload.

  We will make the following assumptions about the processes, sometimes called jobs, that are running in the system:
  - 1 - Each job runs for the same amount of time
  - 2 - All jobs arrive at the same time
  - 3 - Once started, each job runs to completion.
  - 4 - All jobs only use the CPU (i.e., they perform no I/O)
  - 5 - The run-time of each job is known
  
  We said many of these assumptions were unrealistic, but just as some
animals are more equal than others in Orwell’s Animal Farm [O45], some
assumptions are more unrealistic than others in this chapter.
  
- __`Scheduling Metrics`__ -- Beyond making workload assumptions, we also need one more thing
to enable us to compare different scheduling policies: a scheduling metric. For now, however, let us also simplify our life by simply having a single metric: `turnaround time`. The turnaround time of a job is defined
as the time at which the job completes minus the time at which the job
arrived in the system

- __`First In, First Out (FIFO)`__ -- The most basic algorithm we can implement is known as First In, First
Out (FIFO) scheduling or sometimes First Come, First Served (FCFS). FIFO has a number of positive properties: it is clearly simple and thus
easy to implement. And, given our assumptions, it works pretty well. But once the times differ in the processes, so lets say one of them takes a second and another one takes 2 minutes, there is no reason the 2 minute one should be the first on just because it was inputted first. That is why we have the shortest job first.

- __`Shortest Job First (SJF)`__ -- This new scheduling discipline
is known as Shortest Job First (SJF), and the name should be easy to
remember because it describes the policy quite completely: it runs the
shortest job first, then the next shortest, and so on

  But again this algorithm lacks another issue we assume that all the inputs are given in the same time for example if the 2min job was inputtued 1min59 seconds ago we wouldnt have to make it wait for the 1 second process which wil come in 1min59 seconds later, it would be unlogical.

- __`Shortest Time-to-Completion First (STCF)`__ -- To address this concern, we need to relax assumption 3 (that jobs must
run to completion) As you might have guessed, given our previous discussion about timer interrupts and context switching, the scheduler can certainly do something else when B and C arrive: it can preempt job A
and decide to run another job, perhaps continuing A later  Any time a new
job enters the system, the STCF scheduler determines which of the remaining jobs (including the new job) has the least time left, and schedules
that one.

- __`A New Metric: Response Time`__ -- Thus, if we knew job lengths, and that jobs only used the CPU, and our
only metric was turnaround time, STCF would be a great policy. In fact,
for a number of early batch computing systems, these types of scheduling
algorithms made some sense  . However, the introduction of time-shared
machines changed all that. Now users would sit at a terminal and demand interactive performance from the system as well. And thus, a new
metric was born: response time. The formula is:
  ```
  T response = T firstrun - T arrival
  ```
  As you might be thinking, STCF and related disciplines are not particularly good for response time. If three jobs arrive at the same time,
for example, the third job has to wait for the previous two jobs to run in
their entirety before being scheduled just once. While great for turnaround
time, this approach is quite bad for response time and interactivity. Indeed, imagine sitting at a terminal, typing, and having to wait 10 seconds
to see a response from the system just bec

- __`Round Robin`__ -- To solve this problem, we will introduce a new scheduling algorithm,
classically referred to as Round-Robin (RR) scheduling [K64]. The basic
idea is simple: instead of running jobs to completion, RR runs a job for a
time slice (sometimes called a scheduling quantum) and then switches
to the next job in the run queue. It repeatedly does so until the jobs are
finished. 

  As you can see, the length of the time slice is critical for RR. The shorter
it is, the better the performance of RR under the response-time metric.
However, making the time slice too short is problematic: suddenly the
cost of context switching will dominate overall performance. Thus, deciding on the length of the time slice presents a trade-off to a system designer, making it long enough to amortize the cost of switching without
making it so long that the system is no longer responsive

  It is not surprising, then, that RR is indeed one of the worst policies if
turnaround time is our metric. Intuitively, this should make sense: what
RR is doing is stretching out each job as long as it can, by only running
each job for a short bit before moving to the next. Because turnaround
time only cares about when jobs finish, RR is nearly pessimal, even worse
than simple FIFO in many cases

- __`Incorporating I/O`__ -- First we will relax assumption 4 — of course all programs perform
I/O. Imagine a program that didn’t take any input: it would produce the
same output each time. Imagine one without output: it is the proverbial
tree falling in the forest, with no one to see it; it doesn’t matter that it ran.

  A scheduler clearly has a decision to make when a job initiates an I/O
request, because the currently-running job won’t be using the CPU during the I/O; it is blocked waiting for I/O completion. If the I/O is sent to
a hard disk drive, the process might be blocked for a few milliseconds or
longer, depending on the current I/O load of the drive. Thus, the scheduler should probably schedule another job on the CPU at that time.

- __`Summary`__ -- We have introduced the basic ideas behind scheduling and developed
two families of approaches. The first runs the shortest job remaining and
thus optimizes turnaround time; the second alternates between all jobs
and thus optimizes response time. Both are bad where the other is good,
alas, an inherent trade-off common in systems. We have also seen how we
might incorporate I/O into the picture, but have still not solved the problem of the fundamental inability of the OS to see into the future. Shortly,
we will see how to overcome this problem, by building a scheduler that
uses the recent past to predict the future. This scheduler is known as the
multi-level feedback queue

<br>
<br>

---

<br>
<br>

# 8 -  Scheduling: The Multi-Level Feedback Queue

- In this chapter, we’ll tackle the problem of developing one of the most
well-known approaches to scheduling, known as the Multi-level Feedback Queue (MLFQ).

  The fundamental problem MLFQ tries to address is two-fold. First, it
would like to optimize turnaround time, which, as we saw in the previous
note, is done by running shorter jobs first; unfortunately, the OS doesn’t
generally know how long a job will run for, exactly the knowledge that
algorithms like SJF (or STCF) require. Second, MLFQ would like to make
a system feel responsive to interactive users (i.e., users sitting and staring
at the screen, waiting for a process to finish), and thus minimize response
time; unfortunately, algorithms like Round Robin reduce response time
but are terrible for turnaround time

- __`MLFQ: Basic Rules`__ -- To build such a scheduler, in this chapter we will describe the basic
algorithms behind a multi-level feedback queue; although the specifics of
many implemented MLFQs differ

  MLFQ uses priorities to decide which job
should run at a given time: a job with higher priority (i.e., a job on a
higher queue) is chosen to run. Of course, more than one job may be on a given queue, and thus have
the same priority. In this case, we will just use round-robin scheduling
among those jobs.

- __`Attempt #1: How To Change Priority`__ -- We now must decide how MLFQ is going to change the priority level
of a job (and thus which queue it is on) over the lifetime of a job:
  - Rule 3: When a job enters the system, it is placed at the highest
priority (the topmost queue).
  - Rule 4a: If a job uses up an entire time slice while running, its priority is reduced (i.e., it moves down one queue).
  - Rule 4b: If a job gives up the CPU before the time slice is up, it stays
at the same priority level.

- __`Attempt #2: The Priority Boost`__ -- Let’s try to change the rules and see if we can avoid the problem of
starvation. What could we do in order to guarantee that CPU-bound jobs
will make some progress (even if it is not much?).
The simple idea here is to periodically boost the priority of all the jobs
in system. There are many ways to achieve this, but let’s just do something simple: throw them all in the topmost queue; hence, a new rule: Rule 5: After some time period S, move all the jobs in the system
to the topmost queue.

- __`Attempt #3: Better Accounting`__ -- s to perform better accounting of CPU time at each
level of the MLFQ. Instead of forgetting how much of a time slice a process used at a given level, the scheduler should keep track; once a process
has used its allotment, it is demoted to the next priority queue. Whether
it uses the time slice in one long burst or many small ones does not matter.
We thus rewrite Rules 4a and 4b to the following single rule:
  - Rule 4: Once a job uses up its time allotment at a given level (regardless of how many times it has given up the CPU), its priority is
reduced (i.e., it moves down one queue).

- __`Tuning MLFQ And Other Issues`__ -- A few other issues arise with MLFQ scheduling. One big question is
how to parameterize such a scheduler. For example, how many queues
should there be? How big should the time slice be per queue? How often
should priority be boosted in order to avoid starvation and account for
changes in behavior? There are no easy answers to these questions, and
thus only some experience with workloads and subsequent tuning of the
scheduler will lead to a satisfactory balance.

- __`MLFQ: Summary`__ -- We have described a scheduling approach known as the Multi-Level
Feedback Queue (MLFQ). Hopefully you can now see why it is called
that: it has multiple levels of queues, and uses feedback to determine the
priority of a given job. History is its guide: pay attention to how jobs
behave over time and treat them accordingly

<br>
<br>

---

<br>
<br>

# 9 - Scheduling: Proportional Share

- In this chapter, we’ll examine a different type of scheduler known as a
proportional-share scheduler, also sometimes referred to as a fair-share
scheduler. Proportional-share is based around a simple concept: instead
of optimizing for turnaround or response time, a scheduler might instead
try to guarantee that each job obtain a certain percentage of CPU time

  The basic idea
is quite simple: every so often, hold a lottery to determine which process
should get to run next; processes that should run more often should be
given more chances to win the lottery. 

- __`Basic Concept: Tickets Represent Your Share`__ -- Underlying lottery scheduling is one very basic concept: tickets, which
are used to represent the share of a resource that a process (or user or
whatever) should receive. The percent of tickets that a process has represents its share of the system resource in question.

  Let’s look at an example. Imagine two processes, A and B, and further
that A has 75 tickets while B has only 25. Thus, what we would like is for
A to receive 75% of the CPU and B the remaining 25%.

- __`Ticket Mechanisms`__ -- One of the most powerful (and basic) mechanisms in the design of lottery
(and stride) scheduling is that of the ticket. The ticket is used to represent
a process’s share of the CPU in these examples, but can be applied much
more broadly

  Lottery scheduling also provides a number of mechanisms to manipulate tickets in different and sometimes useful ways. One way is with
the concept of ticket currency. Currency allows a user with a set of tickets to allocate tickets among their own jobs in whatever currency they
would like; the system then automatically converts said currency into the
correct global value

  For example, assume users A and B have each been given 100 tickets.
User A is running two jobs, A1 and A2, and gives them each 500 tickets
(out of 1000 total) in A’s currency. User B is running only 1 job and gives
it 10 tickets (out of 10 total). The system converts A1’s and A2’s allocation
from 500 each in A’s currency to 50 each in the global currency; similarly,
B1’s 10 tickets is converted to 100 tickets

  Another useful mechanism is ticket transfer. With transfers, a process
can temporarily hand off its tickets to another process. This ability is
especially useful in a client/server setting, where a client process sends
a message to a server asking it to do some work on the client’s behalf.

- __`Implementation`__ -- Probably the most amazing thing about lottery scheduling is the simplicity of its implementation. All you need is a good random number
generator to pick the winning ticket, a data structure to track the processes of the system (e.g., a list), and the total number of tickets.

- __`How To Assign Tickets?`__ -- One problem we have not addressed with lottery scheduling is: how
to assign tickets to jobs? This problem is a tough one, because of course
how the system behaves is strongly dependent on how tickets are allocated.

- __`Why Not Deterministic?`__ -- You might also be wondering: why use randomness at all? As we saw
above, while randomness gets us a simple (and approximately correct)
scheduler, it occasionally will not deliver the exact right proportions, especially over short time scales. For this reason, Waldspurger invented
stride scheduling, a deterministic fair-share scheduler

- __`The Linux Completely Fair Scheduler (CFS)`__ -- Despite these earlier works in fair-share scheduling, the current Linux
approach achieves similar goals in an alternate manner. The scheduler,
entitled the Completely Fair Scheduler (or CFS) [J09], implements fairshare scheduling, but does so in a highly efficient and scalable manner.

  To achieve its efficiency goals, CFS aims to spend very little time making scheduling decisions, through both its inherent design and its clever
use of data structures well-suited to the task

- __`Summary`__ -- We have introduced the concept of proportional-share scheduling and
briefly discussed three approaches: lottery scheduling, stride scheduling,
and the Completely Fair Scheduler (CFS) of Linux. Lottery uses randomness in a clever way to achieve proportional share; stride does so deterministically. CFS, the only “real” scheduler discussed in this chapter, is a
bit like weighted round-robin with dynamic time slices, but built to scale
and perform well under load; to our knowledge, it is the most widely
used fair-share scheduler in existence today.

<br>
<br>

---

<br>
<br>


