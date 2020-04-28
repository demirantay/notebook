# Engineering a Compiler

My textbook notes of Cooper and Torzon's book.

Table of Contents:
- [CHAPTER 1 Overview of Compilation](#chapter-1-overview-of-compilation)
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

## Introduction

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

## Compiler Structure

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

## Overview of Translation

- To translate code written in a programming language into code suitable for
execution on some target machine, a compiler runs through many steps.

- `The Frontend` -- Before the compiler can translate an expression into executable targetmachine code, it must understand both its form, or syntax, and its meaning or semantics. The front end determines if the input code is well formed, in
terms of both syntax and semantics. If it finds that the code is valid, it creates
a representation of the code in the compiler’s intermediate representation; if
not, it reports back to the user with diagnostic error messages to identify the
problems with the code.

- `Checking Syntax` -- Mathematically, the source language is a set, usually infinite, of strings
defined by some finite set of rules, called a grammar. Two separate passes
in the front end, called the scanner and the parser, determine whether or not
the input code is, in fact, a member of the set of valid programs defined by
the grammar.

  A grammatically correct sentence can be meaningless. For example, the
sentence “Rocks are green vegetables” has the same parts of speech in
the same order as “Compilers are engineered objects,” but has no rational
meaning. To understand the difference between these two sentences requires
contextual knowledge about software systems, rocks, and vegetables.
The semantic models that compilers use to reason about programming languages are simpler than the models needed to understand natural language. A compiler builds mathematical models that detect specific kinds of inconsistency in a program.

- `Intermediate Representations` -- The final issue handled in the front end of a compiler is the generation of
an ir form of the code. Compilers use a variety of different kinds of ir,
depending on the source language, the target language, and the specific trans formations that the compiler applies

- `The Optimizer` --  the initial `ir`
program contains general implementation strategies that will work in any
surrounding context that the compiler might generate. At runtime, the code
will execute in a more constrained and predictable context. The optimizer
analyzes the ir form of the code to discover facts about that context and uses
that contextual knowledge to rewrite the code so that it computes the same
answer in a more efficient way.

  Efficiency can have many meanings. The classic notion of optimization is
to reduce the application’s running time. In other contexts, the optimizer
might try to reduce the size of the compiled code

- `Analysis` -- Most optimizations consist of an analysis and a transformation. The analysis
determines where the compiler can safely and profitably apply the technique.

- `Transformation` -- To improve the code, the compiler must go beyond analyzing it. The compiler must use the results of analysis to rewrite the code into a more
efficient form. Myriad transformations have been invented to improve the
time or space requirements of executable code

   Transformations vary in their effect, the scope over which
they operate, and the analysis required to support them. The literature on
transformations is rich; the subject is large enough and deep enough to
merit one or more separate books.

- `The Back End` -- The compiler’s back end traverses the ir form of the code and emits code
for the target machine. It selects target-machine operations to implement
each ir operation. It chooses an order in which the operations will execute
efficiently

- `Instruction Selection` -- The first stage of code generation rewrites the ir operations into target machine operations, a process called instruction selection. Instruction selection maps each ir operation, in its context, into one or more target machine operations

- `Register Allocation` -- During instruction selection, the compiler deliberately ignored the fact
that the target machine has a limited set of registers. Instead, it used virtual registers and assumed that “enough” registers existed. In practice, the
earlier stages of compilation may create more demand for registers than the
hardware can support. The register allocator must map those virtual registers onto actual target-machine registers. Thus, the register allocator decides, at
each point in the code, which values should reside in the target-machine registers

- `Instruction Scheduling` -- Instruction SchedulingTo produce code that executes quickly, the code generator may need to
reorder operations to reflect the target machine’s specific performance constraints. The execution time of the different operations can vary. The impact of
these longer latency operations on the performance of compiled code can be
dramatic.

- `Interactions Among Code-Generation Components` -- Most of the truly hard problems that occur in compilation arise during code
generation. It even fucking becomes a lot harder if the compiler inputs or outputs a humanly sopen language from or to a computer language such as in NLP good luck coding that shit.

> Throughout the book, low-level examples are written in a notation that
we call ILOC—an acronym derived from "intermediate language for an
optimizing compiler." Over the years, this notation has undergone many
changes. The version used in this book is described in detail in Appendix A.
Think of ILOC as the assembly language for a simple RISC machine

## Summary and Perspective

- Compiler construction is a complex task. A good compiler combines ideas
from formal language theory, from the study of algorithms, from artificial
intelligence, from systems design, from computer architecture, and from the
theory of programming languages and applies them to the problem of translating a program. A compiler brings together greedy algorithms, heuristic
techniques, graph algorithms, dynamic programming, dfas and nfas, fixedpoint algorithms, synchronization and locality, allocation and naming, and
pipeline management. Many of the problems that confront the compiler are
too hard for it to solve optimally; thus, compilers use approximations, heuristics, and rules of thumb.  

  This book explores each of these phases. Chapters 2 through 4 deal with
the algorithms used in a compiler’s front end. Chapters 5 through 7 describe
background material for the discussion of optimization and code generation.
Chapter 8 provides an introduction to code optimization. Chapters 9 and 10 provide more detailed treatment of analysis and optimization for the interested reader. Finally, Chapters 11 through 13 cover the techniques used by
back ends for instruction selection, scheduling, and register allocation.

<br>
<Br>

---

<br>
<br>


