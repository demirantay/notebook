# Computer Architecture

- First lets see what wikipedia has to say about the topic of Computer Architecture: " Computer architecture is a set of rules and methods that describe the functionality, organization and impelmentation of a computer system"

- The dicipline of computer architecture has three main subcategories:
  - 1 - `Instruction Set Architecture`: (or ISA for short). The ISA defines the machine code that a processor reads and acts upon as well as the memory adresses, modes, registers and data types.
  - 2 - `Microarchitecture`: (or Computer organization) describes how a particular processor will implement a ISA
  - 3 - `System Design`: includes all of the other hardware compnonents within a computing system these include such as : virtulization, multiprocessing , software features and etc.
  
- The purpose of computer architecture is to design a computer that maximazes performance while keeping power consumption in check, and also very reliable. For this many complexity there are many sub topic of the field of computer architecure for each topic. Main topics are: Instructiom set design, functional organization, logic design, implementation and optimzitation.

### Instruction Set Architecture

 - An instruction set architecture (ISA) is the interface betwen the computers software and hardware and also can e viewed as the programmers view of the machine. Comuters do not understand high level programming languages such as Java, C++ or most programming languages used. A processor only understand instructions encoded in some numerical fashion, usually as binary numbers. Software tools, such as compilers, translate those high level langauges into instructions that the processor can understand.

### Computer Organization

- Computer organization (microarchitecture) helps optimize performance-based products. For example, in a SD card, the designers might need to arrange the card so that the most data can be proecessed in the fastets possible way. 

### Implementation

- Once an instruction set and micro-architecture are organized and resigned, a practical machine must be developed. This design process is called the implementation. Implementation is usually not considered architectural design, but rather hardware design engineering. Implementation can be broken down into several steps:
  - **Logic Implementation**: design the circuits required at a logic gate level 
  - **Circuit Implementation**: does transistor-level desings of basic elements(gates, multiplexers, latches etc.
  - **Physical Implementation**: draws physical circuits. and placed in a chip floorplan and wires connecting them are created.
  - **Design Validation**: Basically testing either shit blows up or works.

- Note: For CPUs, the entire implementation process is organized differently and is often reffered to as a CPU design which is kinda a different realm on its own.
