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

- __`Virtualizing The CPU`__ --  let’s run many different instances of this same program Well, now things are getting a little more interesting. Even though we
have only one processor, somehow all four of these programs seem to be
running at the same time! How does this magic happen?

  It turns out that the operating system, with some help from the hardware, is in charge of this illusion, i.e., the illusion that the system has
a very large number of virtual CPUs. Turning a single CPU (or a small
set of them) into a seemingly infinite number of CPUs and thus allowing
many programs to seemingly run at once is what we call virtualizing the
CPU,

- __`Virtualizing Memory`__ -- Now let’s consider memory. The model of physical memory presented by modern machines is very simple. Memory is just an array of
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

- __`Concurrency`__ -- Another main theme of this book is concurrency. We use this conceptual term to refer to a host of problems that arise, and must be addressed,
when working on many things at once (i.e., concurrently) in the same
program. The problems of concurrency arose first within the operating
system itself; as you can see in the examples above on virtualization, the
OS is juggling many things at once, first running one process, then another, and so forth. As it turns out, doing so leads to some deep and
interesting problems

- __`Persistence`__ -- The third major theme of the course is persistence. In system memory,
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

- __`Design Goals`__ -- So now you have some idea of what an OS actually does: it takes physical resources, such as a CPU, memory, or disk, and virtualizes them. It
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

- __`Some History`__ -- In the beginning, the operating system didn’t do too much. Basically,
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

- __`Summary`__ -- Unfortunately, due to time constraints, there are a number of parts of
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

# 4 -  The Abstraction: The Process

- In this chapter, we discuss one of the most fundamental abstractions that
the OS provides to users: the process. The definition of a process, informally, is quite simple: it is a running program.  The program
itself is a lifeless thing: it just sits there on the disk, a bunch of instructions
(and maybe some static data), waiting to spring into action. It is the operating system that takes these bytes and gets them running, transforming
the program into something useful.

  The OS creates this illusion by virtualizing the CPU. By running one
process, then stopping it and running another, and so forth, the OS can
promote the illusion that many virtual CPUs exist when in fact there is
only one physical CPU (or a few). This basic technique, known as time
sharing of the CPU, allows users to run as many concurrent processes as
they would like; the potential cost is performance, as each will run more
slowly if the CPU(s) must be shared.

  To implement virtualization of the CPU, and to implement it well, the
OS will need both some low-level machinery and some high-level intelligence. We call the low-level machinery __mechanisms__. On top of these mechanisms resides some of the intelligence in the
OS, in the form of __policies__. Policies are algorithms for making some
kind of decision within the OS. For example, given a number of possible programs to run on a CPU, which program should the OS run? A
scheduling policy in the OS will make this decision

- __`The Abstraction: A Process`__ -- The abstraction provided by the OS of a running program is something
we will call a process. As we said above, a process is simply a running
program To understand what constitutes a process, we thus have to understand
its __machine state__: what a program can read or update when it is running

  One obvious component of machine state that comprises a process is
its memory. Instructions lie in memory; the data that the running program reads and writes sits in memory as well. Thus the memory that the
process can address (called its address space)

- __`Process API`__ -- here we first give some idea of what must be included in any
interface of an operating system:
  - __Create__ -- : An operating system must include some method to create new processes. When you type a command into the shell, or
double-click on an application icon, the OS is invoked to create a
new process to run the program you have indicated.
  
  - __Destroy__: As there is an interface for process creation, systems also
provide an interface to destroy processes forcefully
  
  - __Wait__: Sometimes it is useful to wait for a process to stop running;
  
  - __Miscellaneous Control__: Other than killing or waiting for a process,
there are sometimes other controls that are possible.
  
  - __Status__: There are usually interfaces to get some status information
about a process

- __`Process Creation: A Little More Detail`__ -- The first thing that the OS must do to run a program is to load its code
and any static data (e.g., initialized variables) into memory, into the address space of the process. In early (or simple) operating systems, the loading process is done eagerly, i.e., all at once before running the program; modern OSes perform
the process lazily, i.e., by loading pieces of code or data only as they are
needed during program execution.

  Once the code and static data are loaded into memory, there are a few
other things the OS needs to do before running the process. Some memory must be allocated for the program’s run-time stack (or just stack).  The OS will also likely initialize the stack with arguments; specifically, it will fill in the parameters to
the main() function, i.e., argc and the argv array

  By loading the code and static data into memory, by creating and initializing a stack, and by doing other work as related to I/O setup, the OS
has now (finally) set the stage for program execution

- __`Process States`__ -- In a simplified view, a process can be in one of three states:
  - 1 - Running: In the running state, a process is running on a processor.
This means it is executing instructions.
  - 2 - Ready: In the ready state, a process is ready to run but for some
reason the OS has chosen not to run it at this given moment.
  - 3 - Blocked: In the blocked state, a process has performed some kind
of operation that makes it not ready to run until some other event
takes place. A common example: when a process initiates an I/O
request to a disk, it becomes blocked and thus some other process
can use the processor.

- __`Data Structures`__ -- The OS is a program, and like any program, it has some key data structures that track various relevant pieces of information. To track the state
of each process, for example, the OS likely will keep some kind of process list for all processes that are ready and some additional information to track which process is currently running.

- __`Summary`__ -- We have introduced the most basic abstraction of the OS: the process.
It is quite simply viewed as a running program. With this conceptual
view in mind, we will now move on to the nitty-gritty: the low-level
mechanisms needed to implement processes, and the higher-level policies required to schedule them in an intelligent way. By combining mechanisms and policies, we will build up our understanding of how an operating system virtualizes the CPU.

<br>
<br>

---

<br>
<br>

# 5 - Interlude: Process API

- __`The fork() System Call`__ --

- __`The wait() System Call`__ --

- __`Finally, The exec() System Call`__ --

- __`Why? Motivating The API`__ --

- __`Process Control And Users`__ --

- __`Useful Tools`__ --

- __`Summary`__ --

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


