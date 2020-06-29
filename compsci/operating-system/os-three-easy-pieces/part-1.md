# 2 - Introduction to Operating Systems

- So what happens when a program runs? Well, a running program does one very simple thing: it executes instructions. Many millions (and these days, even billions) of times every second, the processor fetches an instruction from memory, decodes
it (i.e., figures out which instruction this is), and executes it (i.e., it does
the thing that it is supposed to do, like add two numbers together, access
memory, check a condition, jump to a function, and so forth)

  Thus, we have just described the basics of the Von Neumann model of
computing2
. Sounds simple, right? But in this class, we will be learning
that while a program runs, a lot of other wild things are going on with
the primary goal of making the system easy to use.

  There is also a software that is placed in a computer that makes it easy for programs to run on actual physical hardware. The software is called Operating System. The primary way the OS does this is through a general technique that
we call virtualization. That is, the OS takes a physical resource (such as
the processor, or memory, or a disk) and transforms it into a more general, powerful, and easy-to-use virtual form of itself Thus, we sometimes
refer to the operating system as a virtual machine.

  Of course, in order to allow users to tell the OS what to do and thus
make use of the features of the virtual machine (such as running a program, or allocating memory, or accessing a file), the OS also provides
some interfaces (APIs) that you can call. A typical OS, in fact, exports
a few hundred system calls that are available to applications

  Finally, because virtualization allows many programs to run (thus sharing the CPU), and many programs to concurrently access their own instructions and data (thus sharing memory), and many programs to access
devices (thus sharing disks and so forth), the OS is sometimes known as
a resource manager.

- `Virtualizing The CPU` --  let’s run many different instances of this same program Well, now things are getting a little more interesting. Even though we
have only one processor, somehow all four of these programs seem to be
running at the same time! How does this magic happen?

  It turns out that the operating system, with some help from the hardware, is in charge of this illusion, i.e., the illusion that the system has
a very large number of virtual CPUs. Turning a single CPU (or a small
set of them) into a seemingly infinite number of CPUs and thus allowing
many programs to seemingly run at once is what we call virtualizing the
CPU,

- `Virtualizing Memory` -- Now let’s consider memory. The model of physical memory presented by modern machines is very simple. Memory is just an array of
bytes; to read memory, one must specify an address to be able to access
the data stored there; to write (or update) memory, one must also specify
the data to be written to the given address.

  Memory is accessed all the time when a program is running.  A program keeps all of its data structures in memory, and accesses them through
various instructions, like loads and stores or other explicit instructions
that access memory in doing their work. Don’t forget that each instruction of the program is in memory too; thus memory is accessed on each
instruction fetch.

  Now, we again run multiple instances of this same program to see
what happens y! It is as
if each running program has its own private memory, instead of sharing
the same physical memory with other running programs5
. Indeed, that is exactly what is happening here as the OS is virtualizing memory. Each process accesses its own private virtual address space

- `Concurrency` -- Another main theme of this book is concurrency. We use this conceptual term to refer to a host of problems that arise, and must be addressed,
when working on many things at once (i.e., concurrently) in the same
program. The problems of concurrency arose first within the operating
system itself; as you can see in the examples above on virtualization, the
OS is juggling many things at once, first running one process, then another, and so forth. As it turns out, doing so leads to some deep and
interesting problems

- `Persistence` -- The third major theme of the course is persistence. In system memory,
data can be easily lost, as devices such as DRAM store values in a volatile
manner; when power goes away or the system crashes, any data in memory is lost. Thus, we need hardware and software to be able to store data
persistently; such storage is thus critical to any system as users care a
great deal about their data.

  The hardware comes in the form of some kind of input/output or I/O
device; in modern systems, a hard drive is a common repository for longlived information, although solid-state drives (SSDs) are making headway in this arena as well. The software in the operating system that usually manages the disk is
called the file system; it is thus responsible for storing any files the user
creates in a reliable and efficient manner on the disks of the system.

  You might be wondering what the OS does in order to actually write
to disk. We would show you but you’d have to promise to close your
eyes first; it is that unpleasant. The file system has to do a fair bit of work:
first figuring out where on disk this new data will reside, and then keeping track of it in various structures the file system maintains. Doing so
requires issuing I/O requests to the underlying storage device, to either
read existing structures or update (write) them. As anyone who has written a device driver8
knows, getting a device to do something on your
behalf is an intricate and detailed process. It requires a deep knowledge
of the low-level device interface and its exact semantics. Fortunately, the
OS provides a standard and simple way to access devices through its system calls. Thus, the OS is sometimes seen as a standard library.

- `Design Goals` -- So now you have some idea of what an OS actually does: it takes physical resources, such as a CPU, memory, or disk, and virtualizes them. It
handles tough and tricky issues related to concurrency. And it stores files
persistently, thus making them safe over the long-term. Given that we
want to build such a system, we want to have some goals in mind to help
focus our design and implementation and make trade-offs as necessary;
finding the right set of trade-offs is a key to building systems succesful products

  Abstractions are fundamental to everything we do in computer science. Abstraction makes
it possible to write a large program by dividing it into small and understandable pieces, to write such a program in a high-level language like
C
9 without thinking about assembly, to write code in assembly without
thinking about logic gates, and to build a processor out of gates without
thinking too much about transistors. Abstraction is so fundamental that
sometimes we forget its importance, but we won’t here; thus, in each section, we’ll discuss some of the major abstractions that have developed
over time, giving you a way to think about pieces of the OS.

- `Some History` -- In the beginning, the operating system didn’t do too much. Basically,
it was just a set of libraries of commonly-used functions; for example,
instead of having each programmer of the system write low-level I/O
handling code, the “OS” would provide such APIs, and thus make life
easier for the developer Usually, on these old mainframe systems, one program ran at a time,
as controlled by a human operator. Much of what you think a modern
OS would do (e.g., deciding what order to run jobs in) was performed by
this operator. This mode of computing was known as batch processing, as a number
of jobs were set up and then run in a “batch” by the operator.

  In moving beyond being a simple library of commonly-used services, operating systems took on a more central role in managing machines implementing a file system (to manage your files) as a library makes little
sense. Instead, something else was needed Thus, the idea of a system call was invented, pioneered by the Atlas
computing system [K+61,L78]. Instead of providing OS routines as a library (where you just make a procedure call to access them), the idea here
was to add a special pair of hardware instructions and hardware state to
make the transition into the OS a more formal, controlled process.

  Where operating systems really took off was in the era of computing beyond the mainframe, that of the minicomputer. In particular, multiprogramming became commonplace due to the desire to make better use of machine resources. Instead of just running one
job at a time, the OS would load a number of jobs into memory and switch
rapidly between them, thus improving CPU utilization One of the major practical advances of the time was the introduction
of the UNIX operating system, primarily thanks to Ken Thompson (and
Dennis Ritchie) at Bell Labs

  Beyond the minicomputer came a new type of machine, cheaper, faster,
and for the masses: the personal computer, or PC as we call it today. Led
by Apple’s early machines (e.g., the Apple II)

  Fortunately for UNIX, a young Finnish hacker named Linus Torvalds decided to write his own version of UNIX which borrowed heavily on the
principles and ideas behind the original system, but not from the code
base, thus avoiding issues of legality. He enlisted help from many others
around the world, took advantage of the sophisticated GNU tools that
already existed [G85], and soon Linux was born (as well as the modern
open-source software movement). As the internet era came into place, most companies (such as Google,
Amazon, Facebook, and others) chose to run Linux

- `Summary` -- Unfortunately, due to time constraints, there are a number of parts of
the OS we won’t cover in the book. For example, there is a lot of networking code in the operating system; we leave it to you to take the networking class to learn more about that. Similarly, graphics devices are
particularly important; take the graphics course to expand your knowledge in that direction. Finally, some operating system books talk a great
deal about security; we will do so in the sense that the OS must provide
protection between running programs and give users the ability to protect their files, but we won’t delve into deeper security issues that one
might find in a security course. However, there are many important topics that we will cover, including the basics of virtualization of the CPU and memory, concurrency, and
persistence via devices and file systems

<br>
<br>

---

<br>
<br>

# 3 - A Dialogue on Virtualization


<br>
<br>

---

<br>
<br>

# 4 -  The Abstraction: The Process

- `The Abstraction: A Process` --

- `Process API` --

- `Process Creation: A Little More Detail` --

- `Process States` --

- `Data Structures` -- 

- `Summary` --

<br>
<br>

---

<br>
<br>

# 5 - Interlude: Process API

- `The fork() System Call` --

- `The wait() System Call` --

- `Finally, The exec() System Call` --

- `Why? Motivating The API` --

- `Process Control And Users` --

- `Useful Tools` --

- `Summary` --

<br>
<br>

---

<br>
<br>

# 6 - Mechanism: Limited Direct Execution

- `Basic Technique: Limited Direct Execution` --

- `Problem #1: Restricted Operations` --

- `Problem #2: Switching Between Processes` --

- `Worried About Concurrency?` --

- `Summary` --

<br>
<br>

---

<br>
<br>

# 7 - Scheduling: Introduction

- `Workload Assumptions` --

- `Scheduling Metrics` --

- `First In, First Out (FIFO)` --

- `Shortest Job First (SJF)` --

- `Shortest Time-to-Completion First (STCF)` --

- `A New Metric: Response Time` --

- `Round Robin` --

- `Incorporating I/O` --

- `No More Oracle` --

- `Summary` -- 

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

# 10 - Multiprocessor Scheduling (Advanced)

- `Background: Multiprocessor Architecture` --

- `Don’t Forget Synchronization` --

- `One Final Issue: Cache Affinity` --

- `Single-Queue Scheduling` --

- `Multi-Queue Scheduling` --

- `Linux Multiprocessor Schedulers` --

- `Summary` --

<br>
<br>

---

<br>
<br>

# 11 - Summary Dialogue on CPU Virtualization

<br>
<br>

---

<br>
<br>

# 12 - A Dialogue on Memory Virtualization

<br>
<br>

---

<br>
<br>

# 13 - The Abstraction: Address Spaces

- `Early Systems` --

- `Multiprogramming and Time Sharing` --

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

# 16 - Segmentation

- `Segmentation: Generalized Base/Bounds` --

- `Which Segment Are We Referring To?` --

- `What About The Stack?` --

- `Support for Sharing` --

- `Fine-grained vs. Coarse-grained Segmentation` --

- `OS Support` --

- `Summary` --

<br>
<br>

---

<br>
<br>

# 17 - Free Space Management

- `Assumptions` --

- `Low-level Mechanisms` --

- `Basic Strategies` --

- `Other Approaches` --

- `Summary` --

<br>
<br>

---

<br>
<br>

# 18 - Introduction to Paging

- `A Simple Example And Overview` --

- `Where Are Page Tables Stored?` -- 

- `What’s Actually In The Page Table?` --

- `Paging: Also Too Slow` --

- `A Memory Trace` --

- `Summary` --

<br>
<br>

---

<br>
<br>

# 19 - Paging: Faster Translations (TLBs)

- `TLB Basic Algorithm` --

- `Example: Accessing An Array` --

- `Who Handles The TLB Miss?` --

- `TLB Contents: What’s In There?` --

- `TLB Issue: Context Switches` --

- `Issue: Replacement Policy` --

- `A Real TLB Entry` --

- `Summary` --

<br>
<br>

---

<br>
<br>

# 20 -  Paging: Smaller Tables

- `Simple Solution: Bigger Pages` --

- `Hybrid Approach: Paging and Segments` --

- `Multi-level Page Tables` --

- `Inverted Page Tables` --

- `Swapping the Page Tables to Disk` --

- `Summary` --

<br>
<br>

---

<br>
<br>

# 21 - Beyond Physical Memory: Mechanisms

- `Swap Space` --

- `The Present Bit` --

- `The Page Fault` --

- `What If Memory Is Full?` --

- `Page Fault Control Flow` --

- `When Replacements Really Occur` --

- `Summary` --

<br>
<br>

---

<br>
<br>

# 22 - Beyond Physical Memory: Policies

- `Cache Management` --

- `The Optimal Replacement Policy` --

- `A Simple Policy: FIFO` --

- `Another Simple Policy: Random` --

- `Using History: LRU` --

- `Workload Examples` --

- `Implementing Historical Algorithms` --

- `Approximating LRU` --

- `Considering Dirty Pages` --

- `Other VM Policies` --

- `Thrashing` --

- `Summary` --

<br>
<br>

---

<br>
<br>

# 23 - Complete Virtual Memory Systems

- `VAX/VMS Virtual Memory` --

- `The Linux Virtual Memory System` --

- `Summary` --

<br>
<br>

---

<br>
<br>

# 24 - Summary Dialogue on Memory Virtualization

<br>
<br>

---

<br>
<br>

# 25 - A Dialogue on Concurrency

<br>
<br>

---

<br>
<br>

# 26 - Concurrency: An Introduction

- `Concurrency: An Introduction` --

- `An Example: Thread Creation` --

- `Why It Gets Worse: Shared Data` --

- `The Heart Of The Problem: Uncontrolled Scheduling` --

- `The Wish For Atomicity` --

- `One More Problem: Waiting For Another` --

- `Summary: Why in OS Class?` --

<br>
<br>

---

<br>
<br>

# 27 - Interlude: Thread API

- `Thread Creation` --

- `Thread Completion` --

- `Locks` --

- `Condition Variables` --

- `Compiling and Running` --

- `Summary` --

<br>
<br>

---

<br>
<br>

# 28 - Locks

- `Locks: The Basic Idea` --

- `Pthread Locks` --

- `Building A Lock` --

- `Evaluating Locks` --

- `Controlling Interrupts` --

- `A Failed Attempt: Just Using Loads/Stores` --

- `Building Working Spin Locks with Test-And-Set` --

- `Evaluating Spin Locks` --

- `Compare-And-Swap` --

- `Load-Linked and Store-Conditional` --

- `Fetch-And-Add` --

- `Too Much Spinning: What Now?` --

- `A Simple Approach: Just Yield, Baby` --

- `Using Queues: Sleeping Instead Of Spinning` --

- `Different OS, Different Support` --

- `Two-Phase Locks` --

- `Summary` --

<br>
<br>

---

<br>
<br>

# 29 - Lock-based Concurrent Data Structures

- `Concurrent Counters` --

- `Concurrent Linked Lists` --

- `Concurrent Queues` --

- `Concurrent Hash Table` --

- `Summary` --

<br>
<br>

---

<br>
<br>

# 30 - Condition Variables 

- `Definition and Routines` --

- `The Producer/Consumer (Bounded Buffer) Problem` --

- ` Covering Conditions` --

- `Summary` --

<br>
<br>

---

<br>
<br>

# 31 - Semaphores 

- `Semaphores: A Definition` --

- `Binary Semaphores (Locks)` --

- `Semaphores For Ordering` --

- `The Producer/Consumer (Bounded Buffer) Problem` --

- `Reader-Writer Locks` --

- `The Dining Philosophers` --

- `How To Implement Semaphores` --

- `Summary` --

<br>
<br>

---

<br>
<br>

# 32 - Common Concurrency Problems

- `What Types Of Bugs Exist?` --

- `Non-Deadlock Bugs` --

- `Deadlock Bugs` --

- `Summary` --

<br>
<br>

---

<br>
<br>

# 33 - Event-based Concurrency (Advanced)

- `The Basic Idea: An Event Loop` --

- `An Important API: select() (or poll())` --

- `Using select()` --

- `Why Simpler? No Locks Needed` -- 

- `A Problem: Blocking System Calls` --

- `A Solution: Asynchronous I/O` --

- `Another Problem: State Management` -- 

- `What Is Still Difficult With Events` -- 

- `Summary` --

<br>
<br>

---

<br>
<br>

# 34 - Summary Dialogue on Concurrency

<br>
<br>

---

<br>
<br>

# 35 - A Dialogue on Persistence

<br>
<br>

---

<br>
<br>

# 36 - I/O Devices

- `System Architecture` -- 

- `A Canonical Device` --

- `The Canonical Protocol` --

- `Lowering CPU Overhead With Interrupts` --

- `More Efficient Data Movement With DMA` --

- `Methods Of Device Interaction` --

- `Fitting Into The OS: The Device Driver` --

- `Case Study: A Simple IDE Disk Driver` --

- `Historical Notes` --

- `Summary` --

<br>
<br>

---

<br>
<br>

# 37 - Hard Disk Drives

- `The Interface` --

- `Basic Geometry` --

- `A Simple Disk Drive` --

- `I/O Time: Doing The Math` --

- `Disk Scheduling` --

- `Summary` --

<br>
<br>

---

<br>
<br>

# 38 - Redundant Arrays of Inexpensive Disks (RAIDs)

- `Interface And RAID Internals .` --

- `Fault Mode` --

- `How To Evaluate A RAID` --

- `RAID Level 0: Striping` --

- `RAID Level 1: Mirroring` --

- `RAID Level 4: Saving Space With Parity ` --

- `RAID Level 5: Rotating Parity` --

- `RAID Level 5: Rotating Parity` -- 

- `Other Interesting RAID Issues` --

- `Summary` --

<br>
<br>

---

<br>
<br>

# 39 -  Interlude: Files and Directories

- `Files And Directories` --

- `The File System Interface` --

- `Creating Files` --

- `Reading And Writing Files` --

- `Reading And Writing, But Not Sequentially` --

- `Shared File Table Entries: fork() And dup()` --

- `Writing Immediately With fsync()` --

- `Renaming Files` --

- `Getting Information About Files` --

- `Removing Files` --

- `Making Directories` --

- `Reading Directories` --

- `Deleting Directories` --

- `Hard Links` --

- `Symbolic Links` --

- `Permission Bits And Access Control Lists` --

- `Making And Mounting A File System` --

- ` Summary` --

<br>
<br>

---

<br>
<br>

# 40 - File System Implementation

- `The Way To Think` --

- `Overall Organization` --

- `File Organization: The Inode` --

- `Directory Organization` --

- `Free Space Management` --

- `Access Paths: Reading and Writing` -- 

- `Caching and Buffering .` --

- `Summary` -- 

<br>
<br>

---

<br>
<br>

# 41 - Locality and The Fast File System

- ` The Problem: Poor Performance` --

- `FFS: Disk Awareness Is The Solution` --

- `Organizing Structure: The Cylinder Group` --

- `Policies: How To Allocate Files and Directories` --

- `Measuring File Locality` --

- `The Large-File Exception` --

- `A Few Other Things About FFS` --

- `Summary` -- 

<br>
<br>

---

<br>
<br>

# 42 - Crash Consistency: FSCK and Journaling

- `A Detailed Example` --

- `Solution #1: The File System Checker` --

- `Solution #2: Journaling (or Write-Ahead Logging)` --

- `Solution #3: Other Approaches` --

- `Summary` --

<br>
<br>

---

<br>
<br>

# 43 - Log-structured File System (LFS)	

- `Writing To Disk Sequentially` --

- `Writing Sequentially And Effectively` 

- ` How Much To Buffer?` --

- `Problem: Finding Inodes` --

- ` Solution Through Indirection: The Inode Map` --

- `Completing The Solution: The Checkpoint Region` --

- `Reading A File From Disk: A Recap` --

- `What About Directories?` --

- `A New Problem: Garbage Collection` --

- `Determining Block Liveness` --

- `A Policy Question: Which Blocks To Clean, And When?` --

- `Crash Recovery And The Log` --

- `Summary` --

<br>
<br>

---

<br>
<br>

# 44 - Flash-based SSDs

- `Storing a Single Bit` --

- `From Bits to Banks/Planes` --

- `Basic Flash Operations` --

- `Flash Performance And Reliability` -- 

- `From Raw Flash to Flash-Based SSDs` --

- `FTL Organization: A Bad Approach` --

- `A Log-Structured FTL` --

- `Garbage Collection` --

- `Mapping Table Size` --

- `Wear Leveling` --

- `SSD Performance And Cost` -- 

- `Summary` -- 

<br>
<br>

---

<br>
<br>

# 45 - Data Integrity and Protection

- `Disk Failure Modes` --

- `Handling Latent Sector Errors` --

- `Detecting Corruption: The Checksum` --

- `Using Checksums` --

- `A New Problem: Misdirected Writes` --

- `One Last Problem: Lost Writes` --

- `Scrubbing` --

- `Overheads Of Checksumming` --

- `Summary` --

<br>
<br>

---

<br>
<br>

# 46 - Summary Dialogue on Persistence

<br>
<br>

---

<br>
<br>

# 47 -  A Dialogue on Distribution

<br>
<br>

---

<br>
<br>

# 48 - Distributed Systems

- `Communication Basics` --

- `Unreliable Communication Layers` --

- ` Reliable Communication Layers` --

- `Communication Abstractions` --

- `Remote Procedure Call (RPC) ` --

- `Summary` -- 

<br>
<br>

---

<br>
<br>

# 49 - Sun’s Network File System (NFS)

- `A Basic Distributed File System` --

- `On To NFS` --

- `Focus: Simple And Fast Server Crash Recovery` --

- `Key To Fast Crash Recovery: Statelessness` --

- `The NFSv2 Protocol` -- 

- `From Protocol To Distributed File System` -- 

- `Handling Server Failure With Idempotent Operations` -- 

- `Improving Performance: Client-side Caching` -- 

- ` The Cache Consistency Problem` -- 

- `Assessing NFS Cache Consistency` -- 

- `Implications On Server-Side Write Buffering` -- 

- `Summary` -- 

<br>
<br>

---

<br>
<br>

# 50 - Andrew File System (AFS)

- `AFS Version 1` --

- `Problems with Version 1` -- 

- `Improving the Protocol` --

- `AFS Version 2` --

- `Cache Consistency` --

- `Crash Recovery` --

- `Scale And Performance Of AFSv2` -- 

- `AFS: Other Improvements ` --

- `Summary` --

<br>
<br>

---

<br>
<br>

# Summary Dialogue on Distribution



