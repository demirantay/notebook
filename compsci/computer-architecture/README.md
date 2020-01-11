# Computer Architecture

- ENIAC was amongst the first computing system designed in the 1940s. In size, it was equal to the size of 3-4 double decker buses. With over 18,000 buzzing electronic switches called vaccum tubes it was no where close in computing abilities as compared to a Laptop in the modern times. You must be wondering, how we were able to squeeze down all the electonic circuits into smaller and smaller packages to the modern design where laptops are mere fraction of inches thick and very lightweight. The invention of `Integrated Circuits` in 1958 made it all possible.

### A Brief History of Computers 

-  Open up a Television or a Radio, and you will see a green colored board occupying most of the space inside, it is the Printed Circuit Board. It looks like a street map, with small electronic components(such as resistors and capacitors) in place of the buildings and printed copper connections linking them together like miniature metal streets.
  
  Such circuit boards are fine in small appliances like this, but for a complex computing devices like a computer, it is impossible without the board being a couple of hundered square feets in size.

  Simplest of computer requires about eight electronic switches to store a single byte(character) of information. So if you plan to build a simple computer with enough memeory to store this paragraph, which has about 450 characters, so it would require 450 x 8, about 3600 electronic switches. Considering the vaccum tubes used in the early 1940s, which were of the size of a human thumb, you will end up building a large, power hungry monster.

  In 1947, with the invention of transistors, which were a fraction the size of the vaccum tubes and comsumed less power, using transistors for computations became easier, but still the complex circuits were not easy to handle.

  The invention of Integrated Circuits in 1958, changed the game. The concept was to take the whole circuit, with all its components and the connections between them, and recreate the whole thing in microscopically tiny form on the surface of a piece of silicon.

  Jack Kilby and Robert Noyce invented the Integrated Circuit at the same time. How incredible this is, two men, invent the same technology, at the same time, while not knowing each other. In 1968, Robert Noyce co-founded Intel Electronics company which is still the global market leader in IC manufacturing, research and development.

  An integrated circuit (also called an IC or just a chip) is a complete electronic circuit consisting of more than one individual components such as transistors, diodes, resistors, capacitors, and the conductive pathways that connect all the components, all made from a single piece of silicon crystal.
  
<bR>
<br>
  
---

<br>
<br>

# What are Digital Computers

- The digital computer is a digital system that performs various computational tasks. The word digital implies that the information in the computer is represented by variables that take a limited number of discrete values. These values are processed internally by components that can maintain a limited number of discrete states.

  The decimal digits 0, 1, 2, ..., 9, for example, provide 10 discrete values. The first electronic digital computer, developed in the late 1940s, was used primarily for numerical computations and the discrete elements were the digits. From this application the term digital computer emerged.

  In practice, digital computers function more reliably if only two states are used. Because of the physical restriction of components, and because human logic tends to be binary (i.e. true or false, yes or no statements), digital components that are constrained to take discrete values are further constrained to take only two values and are said to be binary.

- `Digital Computers: Computer Organisation` -- Computer Organization is concerned with the way the hardware components operate and the way they are connected together to form the computer system

- `Digital Computers: Computer Design` -- Computer Design is concerned with the hardware design of the computer. Once the computer specifications are formulated, it is the task of the designer to develop hardware for the system.

### Digital Computers: Computer Architecture

- Computer Architecture is concerned with the structure and behaviour of the computer as seen by the user.

  It includes the information, formats, the instruction set, and techniques for addressing memory. The architectural design of a computer system is concerned with the specifications of the various functional modules, such as processors and memories, and structuring them together into a computer system.

  Two basic types of computer architecture are:
  - von Neumann architecture (this is the industry standart)
  - Harvard architecture

### vonn Neumann Architecture

- The von Neumann architecture describes a general framework, or structure, that a computer's hardware, programming, and data should follow. Although other structures for computing have been devised and implemented, the vast majority of computers in use today operate according to the von Neumann architecture.

  von Neumann envisioned the structure of a computer system as being composed of the following components:
  - 1 - `ALU`: The Arithmetic-Logic unit that performs the computer's computational and logical functions.
  - 2 - `RAM`: Memory; more specifically, the computer's main, or fast, memory, also known as Random Access Memory(RAM).
  - 3 - `Control Unit`: This is a component that directs other components of the computer to perform certain actions, such as directing the fetching of data or instructions from memory to be processed by the ALU; and
  - 4 - `Man-machine interfaces`; i.e. input and output devices, such as keyboard for input and display monitor for output.
  ```
  _______________      __________________      _______
  |             |      |      CPU       |      |Input|
  |    Memory   |      |     ----       |<---- |_____| 
  |             |<---> |  1- ALU        |     
  | (data +     |      |  2 - Rrgisters |      ________ 
  |instructions)|      |  3 - Control   |----> |Output|
  |_____________|      |________________|      |______|
  ```

<br>
<bR>
  
---

<br>
<br>

# Boolean Algebra

- Here are some key terms of the Boolean Algebra with a brief description about them: (Boolean algebra is a big topic invented by geoge boole please read more if you want to be good at computers)

### Boolean Function

- logic operations. The variables are designated by letters such as A, B, x, and y. The three basic logic operations are AND, OR and NOT. A Boolean function can be expressed algebraically with binary variables, the logic operation symbols, parentheses and equal sign. For a given combination of values of the variables, the Boolean function can be either 1 or 0. Consider for example, the Boolean Function:
  ```
  F = x + y'z
  ```
  The Function F is equal to 1 if x is 1 or if both y' and z are equal to 1; F is equal to 0 otherwise.


### Truth Table

- The relationship between a function and its binary variables can be represented in a truth table To represent a function in a truth table we need a list of the 2n combinations of the n binary variables.

### Logic Diagram

- A Boolean function can be transformed from an algebraic expression into a logic diagram composed of AND, OR and NOT gates.

  The purpose of Boolean algebra is to facilitate the analysis and design of digital circuits. It provides a convenient tool to:
  - Express in algebraic form a truth table relationship between binary variables.
  - Express in algebraic for the input-output relationship of logic diagrams.
  - Find simpler circuits for the same function.
  
  A Boolean function specified by a truth table can be expressed algebraically in many different ways. Two ways of forming Boolean expressions are Canonical and Non-Canonical forms.


<br>
<Br>
  
---

<br>
<bR>
  
# Basics of Digital Components

- In this tutorial we will learn about the basics of Digital computers. We will cover Integrated Circuits, Digital Logic family, Encoder and Decoder etc.

### Integrated Circuit (IC)

- Complex digital circuits are constructed with integrated circuits. IC is a small silicon semiconductor crystal, called a chip, containing the electronic components for the digital gates. The various gates are interconnected inside the chip to form the required circuit. The chip is mounted in a ceramic or plastic container and the connections are welded to the external pins to form an IC. The number of pins of IC vary from 14 to several thousand. Each pin is identified by a unique number printed on its body.

- Categories of Integrated Circuits:
  - `SSI(Small Scale Integration Device)` -- The number of gates is usually less than 10.
  - `MSI(Medium Scale Integration Device)` -- It contains 10 to 200 gates in a single package.
  - `LSI(Large Scale Integration Device)` -- It contains gates between 200 to few thousand in a single package.
  - `VLSI(Very Large Scale Integration Device)` -- It contains thousands of gates within a single package
  - `ULSI(Ultra Large Scale Integration Device)` -- It contains hundred of thousands of gates within a single package 

### Digital Logic Family

- IC's are also classified by the specific circuit technology to which they belong. The basic circuit in each technology is `NAND`, `NOR`, `NOT` gates.

  The earliest logic family was __Resistor-transistor__ logic which used a resistor as input and a transistor as switching device.
  
  __Diode-transistor__ logic is a direct ancestor of the Transistor-transistor logic, and used a diode for logic functions while a transistor for amplifying functions.
  
### Decoder

- A decoder is a combinational circuit that converts binary information from n coded inputs to 2^n outputs. Commercial decoders include one or more enable (E) inputs to control the operation of circuit. The decoder is enabled when E is equal to 1 and disabled when E is equal to 0.
  - Used in code converters.
  - Used to implement Boolean functions.

### Encoder

- An encoder is a digital circuit that performs the inverse operation of a decoder. An encoder has 2^n input lines and n output lines. It converts octal input to binary digits.

  Types:
  - Priority encoders.
  - Decimal to BCD encoder.
  - Octal to binary encoder.
  - Hexadecimal to binary encoder.
  
### Multiplexer

- A multiplexer is a combinational circuit that receives binary information from one of the 2^n input lines and directs it to a single output line.
 

<br>
<br>

---

<br>
<br>

# Memory Unit

