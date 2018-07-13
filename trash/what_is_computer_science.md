Originally scientists built computers to solve arithmetic,  but they turned out to be incredibly useful for many other things as well:  running the entire internet, lifelike graphics, artificial brains or simulating the Universe, but amazingly all of it boils down to flipping 0's and 1's.

Computer science is the subject that studies what computers can do. It is a diverse and overlapping field but the notes that I am taking from the video split them into three parts.

1 - The fundamental theory of computer science
2 - Computer Engineering
3 - Applications
<br>
<h3>Theoretical Comp Sci</h3>
We'll start with the father of theoretical computer science: Alan Turing, who formalized the concept of a Turing machine which is a simple description of general purpose computer. People came up with other designs for computing machines but they're all equivalent to a Turing machine which makes it the foundation of Computer Science. 

The Turing machine contains several parts as an infinitely long tape that's split into cells containing symbols there's also a head that can read and write symbols to the tape, a state register that stores the state of the head and a list of possible instructions. In today's computers, the tape is like the working memory or RAM, the head is the central processing unit (CPU) and the list of instructions is held in the computer's memory.  Even though a Turing machine is a simple set of rules, it is incredibly powerful and this is essentially what all computers do nowadays.

Every problem that is computable by a Turing machine is computable using Lambda calculus which is the basis of research in programming languages 

An algorithm is a set of instructions independent of the hardware or programming language designed to solve a particular problem. It is kind of like a recipe of how to build a program and a lot of work is put into developing algorithms to get the best out of computers. Different algorithms can get to the same final result, like sorting a random set of numbers into order, but some algorithms are much more efficient than others, this is studied in O(n) complexity. 

Information theory studies the properties of information and how it can be measured, stored and communicated. One application of this is how well you can compress data, making it take up less memory while preserving all or most of the information but there are lots but there are lots of other applications. And of course, cryptography is a huge branch of the information theory where sensitive information needs to be secured.

These are the main branches of theoretical computer science although there are many, more than the narrator of the video had time to go into such as Logic, Graph Theory, Computational Geometry, Automata Theory, Quantum Computation, Parallel Programming, Formal Methods and Data structures and etc..
<br>
<h3>Computer Engineering</h3>
Designing computers is difficult because they have to do so many different things. Designers need to try and make sure they are capable of solving many different kinds of problem as optimally as possible.

Every single task that is run on the computer goes through the core of the computer: the CPU(central processing unit). When you are doing lots of things at the same time the CPU needs to switch back and forth between these jobs to make sure everything gets done in a reasonable time. This is controlled by a scheduler which chooses what to do when and tries to get through the tasks in the most efficient way. which can be a very difficult problem. Multiprocessing helps speed things up because the CPU has several cores that can execute multiple jobs in parallel. But this makes the job of the scheduler even more complex.

Computer architecture is how a processor is designed to perform tasks and different architectures are good at different things. For example, CPUs are general purpose, GPUs (graphical processing units) are optimized for graphics.

On top of the raw hardware, there are many layers of software written by programmers using many different programming languages.  A programming language is how humans tell a computer what to do and they vary greatly depending on the job at hand from low-level languages like assembly through to high-level languages like python or javascript for coding websites and apps. In general, the closer a language is to the hardware, the more difficult it is for humans to use. At all stages of this hierarchy the code that programmers write needs to be turned into raw CPU instructions (machine code) and this is done by one or several programs called compilers. Designing programming languages and compilers is a big deal because they are the tool that software engineers use to make everything and so they need to be as easy to use as possible but also be versatile enough to allow the programmers to build their crazy ideas.

The operating system is the most important piece of software on the computer as it is what we interact with and it controls how all of the other programs are run on the hardware and engineering a good operating system is a huge challenge.

This brings us to software engineering: writing bundles of instructions telling the computer what to do. Building good software is an art form because you have to translate your creative ideas into logical instructions in a specific language, make it as efficient as possible to run and as free of errors as you can. So there are many best practices and design philosophies that people follow, eg. OOP, functional, unit testing, version control .. etc.

Some other important areas are getting many computers to communicate and work together to solve problems(networking). Storing and retrieving large amounts of data(Data management). DEtermining how well computer systems are performing at specific tasks(performance) & creating highly detailed and realistic graphics(computer graphics, games)
<br>
<h3>Applications</h3>
Now we get to a really cool part of computer science, getting computers to solve real-world problems. These technologies underlie a lot of the programs apps and websites we use.

When you are going on vacation and you want to get the best trip for the money you are solving an optimization problem. Optimisation problems appear everywhere and finding the best path or most efficient combination of parts can save businesses millions of dollars.

Computers extend our brains multiple cognitive abilities. The forefront of computer science research is developing computer systems that can think for themselves: Artifical Intelligence. There are many avenues that AI research takes the most prominent of which is machine learning which aims to develop algorithms and techniques to enable computers to learn from large amounts of data and then use what they've learned to do something useful like make decisions or classify things. and there are many diferent types of machine learning( neural networking, supervised, unsupervised).

Closely related fields like computer vision, trying to make computers able to see objects in images like we do, which uses image processing techniques.

Natural language processing aims to get computers to understand and communicate using human language or to process large amounts of data in form of words for analysis.

There are many others such as computational science, hacking, big data, super computing, virtual reality, augmented reality , telepresence and so on ...

Credit : <a href="https://www.youtube.com/watch?v=SzJ46YA_RaA&t=562s">Video</a>
