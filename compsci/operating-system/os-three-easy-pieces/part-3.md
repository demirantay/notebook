# 10 - Multiprocessor Scheduling (Advanced)

- This chapter will introduce the basics of multiprocessor scheduling. As
this topic is relatively advanced, it may be best to cover it after you have
studied the topic of concurrency in some detail (i.e., the second major
“easy piece” of the book).

  After years of existence only in the high-end of the computing spectrum, multiprocessor systems are increasingly commonplace, and have
found their way into desktop machines, laptops, and even mobile devices. The rise of the multicore processor, in which multiple CPU cores
are packed onto a single chip, is the source of this proliferation; these
chips have become popular as computer architects have had a difficult
time making a single CPU much faster without using (way) too much
power.

  Of course, there are many difficulties that arise with the arrival of more
than a single CPU. A primary one is that a typical application (i.e., some C
program you wrote) only uses a single CPU; adding more CPUs does not
make that single application run faster. To remedy this problem, you’ll
have to rewrite your application to run in parallel, perhaps using threads

  How should the OS schedule jobs on multiple CPUs? What new problems arise? Do the same old techniques work, or are new ideas required?

- __`Background: Multiprocessor Architecture`__ --  To understand the new issues surrounding multiprocessor scheduling, we have to understand a new and fundamental difference between
single-CPU hardware and multi-CPU hardware. This difference centers
around the use of hardware caches,  and exactly how
data is shared across multiple processors.

  Now for the tricky part: what happens when you have multiple processors in a single system, with a single shared main memory. As it turns out, caching with multiple CPUs is much more complicated.

- __`Don’t Forget Synchronization`__ -- Given that the caches do all of this work to provide coherence, do programs (or the OS itself) have to worry about anything when they access
shared data? The answer, unfortunately, is yes, and is documented in
great detail in the second piece of this book on the topic of concurrency

  When accessing (and in particular, updating) shared data items or
structures across CPUs, mutual exclusion primitives (such as locks) should
likely be used to guarantee correctness

- __`One Final Issue: Cache Affinity`__ -- One final issue arises in building a multiprocessor cache scheduler,
known as cache affinity [TTG95]. This notion is simple: a process, when
run on a particular CPU, builds up a fair bit of state in the caches (and
TLBs) of the CPU.

- __`Single-Queue Scheduling`__ -- With this background in place, we now discuss how to build a scheduler for a multiprocessor system. The most basic approach is to simply
reuse the basic framework for single processor scheduling, by putting all
jobs that need to be scheduled into a single queue; we call this singlequeue multiprocessor scheduling or SQMS for short.  This approach
has the advantage of simplicity; it does not require much work to take an
existing policy that picks the best job to run next and adapt it to work on
more than one CPU. However, SQMS has obvious shortcomings. The first problem is a lack
of scalability.

- __`Multi-Queue Scheduling`__ -- Because of the problems caused in single-queue schedulers, some systems opt for multiple queues, e.g., one per CPU. We call this approach
multi-queue multiprocessor scheduling (or MQMS). . Each queue will likely follow a particular scheduling discipline, such as round robin, though of course any algorithm can be used. MQMS has a distinct advantage of SQMS in that it should be inherently more scalable. As the number of CPUs grows, so too does the number of queues, and thus lock and cache contention should not become a
central problem. In addition, MQMS intrinsically provides cache affinity;
jobs stay on the same CPU and thus reap the advantage of reusing cached
contents therein.
  
  But, if you’ve been paying attention, you might see that we have a new
problem, which is fundamental in the multi-queue based approach: load
imbalance So what should a poor multi-queue multiprocessor scheduler do? How
can we overcome the insidious problem of load imbalance and defeat the
evil forces of ... the Decepticons? The obvious answer to this query is to move jobs around, a technique
which we (once again) refer to as migration. By migrating a job from one
CPU to another, true load balance can be achieved.

- __`Linux Multiprocessor Schedulers`__ -- Interestingly, in the Linux community, no common solution has approached to building a multiprocessor scheduler. Over time, three different schedulers arose: the O(1) scheduler, the Completely Fair Scheduler (CFS), and the BF Scheduler (BFS)2
. See Meehean’s dissertation for
an excellent overview of the strengths and weaknesses of said schedulers
[M11]; here we just summarize a few of the basics

- __`Summary`__ -- We have seen various approaches to multiprocessor scheduling. The
single-queue approach (SQMS) is rather straightforward to build and balances load well but inherently has difficulty with scaling to many processors and cache affinity. The multiple-queue approach (MQMS) scales
better and handles cache affinity well, but has trouble with load imbalance and is more complicated. Whichever approach you take, there is no
simple answer: building a general purpose scheduler remains a daunting
task, as small code changes can lead to large behavioral differences.

<br>
<br>

---

<br>
<br>

# 13 - The Abstraction: Address Spaces

- `Early Systems` -- From the perspective of memory, early machines didn’t provide much
of an abstraction to users. The OS was a set of routines (a library, really) that sat in memory (starting at physical address 0 in this example), and there would be one running program (a process) that currently sat in physical memory (starting
at physical address 64k in this example) and used the rest of memory

- `Multiprogramming and Time Sharing` -- After a time, because machines were expensive, people began to share
machines more effectively. Thus the era of multiprogramming was born. Soon enough, however, people began demanding more of machines,
and the era of time sharing was born. As time sharing became more popular, you can probably guess that
new demands were placed on the operating system. In particular, allowing multiple programs to reside concurrently in memory makes protection an important issue; you don’t want a process to be able to read, or
worse, write some other process’s memory.

- `The Address Space` --

- `Goals` --

- `Summary` --

<br>
<br>

---

<br>
<br>

# 14 - Interlude: Memory API

- `Types of Memory` --

- `The malloc() Call` --

- `The free() Call` -- 

- `Common Errors` --

- `Underlying OS Support` --

- `Other Calls` --

- `Summary` --

<br>
<br>

---

<br>
<br>

# 15 - Mechanism: Address Translation

- `Assumptions` --

- `An Example` --

- `Dynamic (Hardware-based) Relocation` --

- `Hardware Support: A Summary` --

- `Operating System Issues` --

- `Summary` --

<br>
<br>

---

<br>
<br>


