# Computer Organization And Design

Notes on the 5th edition book - Hannesy & Patterson

## Computer Abstraction and Thecnology

- There are 8 main great ideas in Computer Archiecture, view them below in a nutshell:
    - `Moore's Law`: computer architecs must anticipate where the techonolgy will be when the design finishes
    - `Abstraction`: harware doesnt always mean physical, use abstraction like software for efficency
    - `Common Case Fast`: make the common case fast
    - `Parallelism`: get more performance by performing operations in parallel
    - `Pipelining`: a pattern of parallelism that is so important that it needs its own name
    - `Prediction`: in some cases it can be faster to guess and start working rather than wait until you are sure
    - `Hierarcy`: use the "hierarcy of memory" triangle for cutting memory costs
    - `Dependability`: make systems dependable by building strong components that can take over when failure happens
    
    
- The underlying harware in every computer performs the same basic functions: input data , output data , processing data , storing data.

- The five classic components of a computer are: input, output, memory, datapath and control (with last two sometimes combined and said 'processor') 

- Lets view the components in more depth:
    - `Input Device`: A mechanism thorugh which the computer is fed information such as a keyboard
    - `Output Device`: A mechanism that shows the result of a computation to the user such as display, screen anoother computer
    - `Integrated Circuit`: Also called a "chip". A device combining dozens to millions of transistors
    - `Central Processing Unit (CPU)`: Also called processor. The active part of the computer, which contains the datapath and controls the computer.
    - `Datapath`: The component of the processor that performs arithmetic operations
    - `Control`: The component of the processor that commands the datapath, memory and I/O devices accordign to the instructions of the program.
    - `Memory`: The storage area in which programs are kept when they are running and that contains the data needed by running programs
    - `DRAM`: "Dynamic Random Acsess Memory" built as an integrated circuit. It provides random acsess to any location.
    - `Cache Memory`: A small, fast memory that acts as a buffer for a slower, larger memory. Safer place to hide data.
    - `SRAM`: Static Random Accsess Memory built as an integrated circuit, but faster and less dense that DRAM
    
- Both harware and software consists of hierarihcal layers using abstraction, with each lower level hiding details from the level above. One key interface beetween the levels of abstraction is the `Instruction Set Architecture` -- the interface between the harware and low-level software. This abstract interface enables many implementations of varying cost and performance to run identical software.

- These are the main parts of the memory:
    - `Volatile Memory`: Storage such as the DRAM that retains data only if it is recieving power
    - `Nonvolatile Memory`: A form of memory that retains the data even in the absence of a powersource 
    - `Main Memory`: Used to hold programs while they are running, typically consists of DRAM in todays computers.
    - `Secondary Memory`: Nonvolatile memory used to store programs and data between typically consists of flash memories.
    - `Magentic Disk`: Also called the "Hard Disk". A form of nonvolatile secondary memory 
    - `Flash Memory`: A nonvolatile semi conductor memory it is slower and cheaper from DRAM
    
- Types of networks in computer architecture:
    - `LAN`: A network designed to carry data within a georagraphically confined area typcially a single building
    - `WAN`: A network extended over hundreds of kilometers   
   
- Performance of Computers: 
    - `Response Time`: Also called the "Execution Time". The total time required  for the computer to complete a task
    - `Throughput`: Also called the bandwith. Another measure of performance, it is the number of tasks completed per unit
    - `CPU Time`: The actual time the CPU spends computing for a single task
    - `User CPU Time`: The CPU time spent in a program itself.
    - `System CPU Time`: The CPU time spent in the operating system performing tasks on behalf of the prpogram.
    - `Clock Cycle`: CPI of CPUs and stuff ... I did not understand this part on the book at the moment
    
  
