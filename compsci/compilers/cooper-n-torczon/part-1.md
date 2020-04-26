# Engineering a Compiler

My textbook notes of Cooper and Torzon's book.

Table of Contents:
- [CHAPTER 1 Overview of Compilation](#CHAPTER-2-Scanners)
- [CHAPTER 2 Scanners]()
- [CHAPTER 3 Parsers]()
- [CHAPTER 4 Context-Sensitive Analysis]()
- [CHAPTER 5 Intermediate Representations]()
- [CHAPTER 6 The Procedure Abstraction ]()
- [CHAPTER 7 Code Shape.]()
- [CHAPTER 8 Introduction to Optimization ]()
- [CHAPTER 9 Data-Flow Analysis]()
- [CHAPTER 10 Scalar Optimizations]()
- [CHAPTER 11 Instruction Selection]()
- [CHAPTER 12 Instruction Scheduling]()
- [CHAPTER 13 Register Allocation]()

<br>
<br>

# Chapter 1: Overview of Compilation

- Compilers are computer programs that translate a program written in one language into a program written in another language. At the same time, a compiler is a large software system, with many internal components and algorithms and complex interactions between them.

  Keywords: Compiler, Interpreter, Automatic Translation

### Introduction

- computer applications rely on software computer programs
that build virtual tools on top of the low-level abstractions provided by the
underlying hardware. Almost all of that software is translated by a tool
called a compiler. A compiler is simply a computer program that trans- 
lates other computer programs to prepare them for execution. Even operating systems, kernels ... etc. which are very low level are built on top of compilers. so you can think compilers as the lowest abstraction of the hardware after assembly on bare metal .. etc.

- `conceptual roadmap` -- A compiler is a tool that translates software written in one language into
another language. To translate text from one language to another, the tool
must understand both the form, or syntax, and content, or meaning, of the
input language. It needs to understand the rules that govern syntax and meaning in the output language. Finally, it needs a scheme for mapping content from the source language to the target language.

  The structure of a typical compiler derives from these simple observations.
The compiler has a front end to deal with the source language. It has a back
end to deal with the target language. Connecting the front end and the back
end, it has a formal structure for representing the program in an intermediate form whose meaning is largely independent of either language

  Typical “source” languages might be c, c++, fortran, Java, or ml. The
“target” language is usually the instruction set of some processor (assembly lang of different ISAs (mips, x86 assembly ... etc.)

-  Compilers that target programming languages rather than the instruction set of a computer are
often called `source-to-source` translators.

- `A virtual machine` -- is a simulator for some
processor. It is an interpreter for that machine’s
instruction set.

- `Interpreters` -- Interpreters and compilers have much in common. They perform many of the
same tasks. Both analyze the input program and determine whether or not it
is a valid program. Both build an internal model of the structure and meaning of the program. Both determine where to store values during execution.
However, interpreting the code to produce a result is quite different from
emitting a translated program that can be executed to produce the result. This
book focuses on the problems that arise in building compilers. However, an
implementor of interpreters may find much of the material relevant.

- `Why Study Compiler Construction?` -- A good compiler contains a microcosm of computer science. It makes practical use of greedy algorithms (register allocation), heuristic search techniques
(list scheduling), graph algorithms (dead-code elimination), dynamic programming (instruction selection), finite automata and push-down automata
(scanning and parsing), and fixed-point algorithms (data-flow analysis). It
deals with problems such as dynamic allocation, synchronization, naming, locality, memory hierarchy management, and pipeline scheduling. Few
software systems bring together as many complex and diverse components. Working inside a compiler provides practical experience in software
engineering that is hard to obtain with smaller, less intricate systems.

- `The Fundamental Principles of Compilation` -- there are two fundamental principles that a compiler writer must
keep in mind at all times. The first principle is inviolable: _The compiler must preserve the meaning of the program being compiled._  The second principle that a compiler must observe is practical: _The compiler must improve the input program in some discernible way_ Lets give a n example to the second rule: A source-to-source translator for c must produce code that is, in some measure, better than the input program; if it is not, why would anyone invoke it? (it basically means optimize the shit out of your input language without damaging the logic of it so that people will use your fast compiler.

### Compiler Structure

- As we said erlier the structure looks like this:
  ```
  source program --> front-end --> IR --> Backend --> Target Program
  ```
  The front end focuses on understanding the source-language program. The
back end focuses on mapping programs to the target machine. An IR is some set of data structures to
represent the code that the coompiler uses it to processes. This intermediate representation (ir) becomes the compiler’s definitive representation for the code it is translating

  In a two-phase compiler, the front end must ensure that the source program
is well formed, and it must map that code into the ir. The back end must map the ir program into the instruction set and the finite resources of the target
machine. Because the back end only processes ir created by the front end, it
can assume that the ir contains no syntactic or semantic errors

- `Retargeting` --
The task of changing the compiler to generate
code for a new processor is often called
retargetingthe compiler. Finally, the two-phase structure may simplify the process of retargeting the compiler. We can easily envision constructing multiple back ends for a
single front end to produce compilers that accept the same language but tar get different machines. Similarly, we can envision front ends for different languages producing the same ir and using a common back end.

- `Optimizer` -- Introducing an ir makes it possible to add more phases to compilation. The
compiler writer can insert a third phase between the front end and the back end. This middle section, or optimizer, takes an ir program as its input and produces a semantically equivalent ir program as its output. By using the ir
as an interface, the compiler writer can insert this third phase with minimal
disruption to the front end and back end. This leads to the following compiler
structure, termed a three-phase compiler
  ```
  frontend --> IR --> Optimizer --> IR --> Backend
  ```
  The optimizer is an ir-to-ir transformer that tries to improve the ir program
in some way

### Overview of Translation

- To translate code written in a programming language into code suitable for
execution on some target machine, a compiler runs through many steps.

- `The Frontend` -- Before the compiler can translate an expression into executable targetmachine code, it must understand both its form, or syntax, and its meaning or semantics. The front end determines if the input code is well formed, in
terms of both syntax and semantics. If it finds that the code is valid, it creates
a representation of the code in the compiler’s intermediate representation; if
not, it reports back to the user with diagnostic error messages to identify the
problems with the code.

### Summary and Perspective

<br>
<Br>

---

<br>
<br>

# CHAPTER 2: Scanners

### Introduction

### Recognizing Words

###  Regular Expressions

### From Regular Expression to Scanner

### Implementing Scanners

### Advanced Topics

### Chapter Summary and Perspective

<br>
<Br>

---

<br>
<br>

# CHAPTER 3: Parsers

### Introduction

### Expressing Syntax

### Top-Down Parsing

### Bottom-Up Parsing

### Practical Issues

### Advanced Topics

### Summary and Perspective

<br>
<br>

---

<br>
<br>

# CHAPTER 4: Context-Sensitive Analysis

### Introduction

### An Introduction to Type Systems

### The Attribute-Grammar Framework

### Ad Hoc Syntax-Directed Translation

### Advanced Topics

### Summary and Perspective

<br>
<br>

---

<br>
<br>

# CHAPTER 5: Intermediate Representations

### Introduction

### Graphical IRs 

### Linear IRs

### Mapping Values to Names

### Symbol Tables

### Summary and Perspective

<Br>
<br>

---

<br>
<br>

# CHAPTER 6: The Procedure Abstraction

### Introduction

### Procedure Calls

### Name Spaces

### Communicating Values Between Procedures

### Standardized Linkages

### Advanced Topics 

### Summary and Perspective

<br>
<br>

---

<br>
<Br>

# CHAPTER 7: Code Shape

### Introduction

### Assigning Storage Locations

### Arithmetic Operators

### Boolean and Relational Operators

### Storing and Accessing Arrays

### Character Strings 

### Structure References

### Control-Flow Constructs

### Procedure Calls

### Summary and Perspective

<br>
<br>

---

<Br>
<br>

# CHAPTER 8: Introduction to Optimization

### Introduction

### Background

### Scope of Optimization

### Local Optimization

### Regional Optimization

### Global Optimization

### Interprocedural Optimization

### Summary and Perspective

<br>
<br>

---

<br>
<br>

# CHAPTER 9: Data-Flow Analysis

### Introduction

### Iterative Data-Flow Analysis

### Static Single-Assignment Form

### Interprocedural Analysis 

### Advanced Topics 

### Summary and Perspective

<Br>
<br>

---

<br>
<br>

# CHAPTER 10: Scalar Optimizations

### Introduction

### Eliminating Useless and Unreachable Code

### Code Motion

### Specialization 

### Redundancy Elimination

### Enabling Other Transformations .

### Advanced Topics

### Summary and Perspective 

<br>
<Br>

---

<br>
<br>

# CHAPTER 11: Instruction Selection 

### Introduction

### Code Generation

### Extending the Simple Treewalk Scheme

### Instruction Selection via Tree-Pattern Matching 

### Instruction Selection via Peephole Optimization 

### Advanced Topics

### Summary and Perspective

<br>
<br>

---

<br>
<br>

# CHAPTER 12: Instruction Scheduling

### Introduction

### The Instruction-Scheduling Problem

### Local List Scheduling

### Regional Scheduling 

### Advanced Topics

### Summary and Perspective

<br>
<Br>

---

<br>
<br>

# CHAPTER 13: Register Allocation.

### Introduction

### Background Issues

### Local Register Allocation and Assignment

### Global Register Allocation and Assignment 

### Advanced Topics 

### Summary and Perspective

<br>
<br>
