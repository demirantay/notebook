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

<br>
<br>
<br>

# Boolean Arithmetic

...

<br>
<br>

# Sequential Logic

...

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

