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
