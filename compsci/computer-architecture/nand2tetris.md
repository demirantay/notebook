# Nand 2 Tetris 

My notes on the book of Nand2Tetris's course by Noam N. and Shimon S.

To run any of the Nand2Tetris Course emulator tools you need to run this command:
```
~/Desktop/nand2tetris/tools/HardwareSimulator.sh
```
[FAQ about the tools](https://www.nand2tetris.org/copy-of-nestedcall-1)

<br>
<br>

# Boolean Logic

- Every digital device—be it a personal computer, a cellular telephone, or a network router—is based on a set of chips designed to store and process information. Although these chips come in different shapes and forms, they are all made from the same building blocks: Elementary logic gates

### Boolean Algebra

- Since computer hardware is based on the representation and manipulation of binary values, Boolean functions play a central role in the specification, construction, and optimization of hardware architectures. 

- Every Boolean function, no matter how complex, can be expressed using three Boolean operators only: And, Or, and Not.

### Gate Logic 

- A gate is a physical device that implements a Boolean function. If a Boolean function f operates on n variables and returns m binary results, the gate that implements f will have n input pins and m output pins

- And just like complex Boolean functions can be expressed in terms of simpler functions, complex gates are composed from more elementary gates. The simplest gates of all are made from tiny switching devices, called transistors, wired in a certain topology designed to effect the overall gate functionality.

- Indeed, during the last fifty years, researchers have built many hardware implementations of Boolean functions, including magnetic, optical, biological, hydraulic, and pneumatic mechanisms. Today, most gates are implemented as transistors etched in silicon, packaged as chips.

- Primitive and Composite Gates Since all logic gates have the same input and output semantics (0’s and 1’s), they can be chained together, creating composite gates of arbitrary complexity.

- Simply put, logic design is the art of interconnecting gates in order to implement more complex functionality, leading to the notion of composite gates. For example, the Xor function can be implemented using four, rather than five, And, Or, and Not gates.

### Hardware Description Language (HDL)

- Today, hardware designers no longer build anything with their bare hands. Instead, they plan and optimize the chip architecture on a computer workstation, using structured modeling formalisms like Hardware Description Language, or HDL (also known as VHDL, where V stands for Virtual). The designer specifies the chip structure by writing an HDL program, which is then subjected to a rigorous battery of tests. These tests are carried out virtually, using computer simulation: A special software tool, called a hardware simulator, takes the HDL program as input and builds an image of the modeled chip in memory. Next, the designer can instruct the simulator to test the virtual chip on various sets of inputs, generating simulated chip outputs. The outputs can then be compared to the desired results, as mandated by the client who ordered the chip built

- An HDL definition of a chip consists of a header section and a parts section. The header section specifies the chip interface, namely the chip name and the names of its input and output pins. The parts section describes the names and topology of all the lower-level parts (other chips) from which this chip is constructed.

- Rigorous quality assurance mandates that chips be tested in a specific, replicable, and well- documented fashion. With that in mind, hardware simulators are usually designed to run test scripts, written in some scripting language.

- HDL Language [Reference]() will need to find a link

### Harware Simulation

- Since HDL is a hardware construction language, the process of writing and debugging HDL programs is quite similar to software development. The main difference is that instead of writing code in a language like Java, we write it in HDL, and instead of using a compiler to translate and test the code, we use a hardware simulator. The hardware simulator is a computer program that knows how to parse and interpret HDL code, turn it into an executable representation, and test it according to the specifications of a given test script.

### Basic Logic Gates

- The starting point of our computer architecture is the Nand gate, from which all other gates and chips are built. The Nand gate is designed to compute the following Boolean function:
  ```hdl
  Chip name: Nand 
  Inputs:    a, b
  Outputs:   out
  Functions: If a=b=1 then out=0 else out=1
  Comment:   This gate is considered primitive and thus there is
             no need to implement it
  ```

- `Not Gate`: The single-input Not gate, also known as “converter,” converts its input from 0 to 1 and vice versa. The gate API is as follows:
  ```hdl
  Chip name: Not 
  Inputs:    in
  Outputs:   out
  Functions: If in=0 then out=1 else out=0
  ```

- `And Gate`: The And function returns 1 when both its inputs are 1, and 0 otherwise.
  ```hdl
  Chip name: And 
  Inputs:    a, b
  Outputs:   out
  Functions: If a=b=1 then out=1 else out=0
  ```
  
- `Or Gate`: The Or function returns 1 when at least one of its inputs is 1, and 0 otherwise.
  ```hdl
  Chip name: Or 
  Inputs:    a, b
  Outputs:   out
  Functions: If a=b=0 then out=0 else out=1
  ```
  
- `Xor Gate`: The Xor function, also known as “exclusive or,” returns 1 when its two inputs have opposing values, and 0 otherwise.
  ```hdl
  Chip name: Xor 
  Inputs:    a, b
  Outputs:   out
  Functions: If a!=b then out=1 else out=0
  ```
  
- `Multiplexor Gate` A multiplexor is a three-input gate that uses one of the inputs, called “selection bit,” to select and output one of the other two inputs, called “data bits.” Thus, a better name for this device might have been selector. The name multiplexor was adopted from communications systems, where similar devices are used to serialize (multiplex) several input signals over a single output wire.
  ```hdl
  Chip name: Mux 
  Inputs:    a, b, sel
  Outputs:   out
  Functions: If sel=0 then out=a else out=b
  ```
  
- `Demultiplexor Gate` :
  ```hdl
  Chip name: DMux 
  Inputs:    in, sel
  Outputs:   out
  Functions: If sel=0 then (a=in, b=0) else (a=0, b=in)
  ```
  
<br>
<br>
<br>

# Boolean Arithmetic

- Remarkably, most of the operations performed by digital computers can be reduced to elementary additions of binary numbers. Therefore, constructive understanding of binary addition holds the key to the implementation of numerous computer operations that depend on it, one way or another.

- I REALLY DID NOT UNDERSTAND THIS PART RETURN TO IT LATER ON ...

<br>
<br>

# Sequential Logic

- Combinational chips compute functions that depend solely on combinations of their input values. These relatively simple chips provide many important processing functions (like the ALU), but they cannot maintain state. Since computers must be able to not only compute values but also store and recall values, they must be equipped with memory elements that can preserve data over time. These memory elements are built from sequential chips.

- The implementation of memory elements is an intricate art involving synchronization, clocking, and feedback loops. Conveniently, most of this complexity can be embedded in the operating logic of very low-level sequential gates called flip-flops.

<br>
<br>

# Machine Language

...

<br>
<br>

# Computer Architecture

...

<br>
<br>

# Assembler

...

<br>
<br>

# Virtual Machine I: Stack Arithmetic

...

<br>
<br>

# Virtual Machine II: Program Control

...

<br>
<br>

# High Level Language

...

<br>
<br>

# Compiler I: Syntax Analysis

...

<br>
<br>

# Compiler II: Code Generation

...

<br>
<br>

# Operating System

...

<br>
<br>

# PostScript: More Fun to Go

...