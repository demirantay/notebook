# Modern Compiler Implementation in Java (2nd)

- This textbook describes all phases of a compiler: lexical analysis, parsing, abstract syntax, semantic
actions, intermediate representations, instruction selection via tree matching, dataflow analysis, graphcoloring register allocation, and runtime systems

  The first part of the book, Fundamentals of Compilation, is suitable for a one-semester first course in
compiler design. The second part, Advanced Topics, which includes the compilation of object-oriented
and functional languages, garbage collection, loop optimization, SSA form, instruction scheduling, and
optimization for cache-memory hierarchies, can be used for a second-semester or graduate course.

<br>

> __`Part I Fundamentals of Compilation`__

<br>

# 1 Introduction

- This book describes techniques, data structures, and algorithms for translating
programming languages into executable code. A modern compiler is often organized into many phases, each operating on a different abstract “language.”

- To illustrate the issues in compiling real programming languages, we show
how to compile MiniJava, a simple but nontrivial subset of Java. Programming exercises in each chapter call for the implementation of the corresponding phase; a student who implements all the phases described in Part I of the
book will have a working compiler. Part II cover advanced techniques in program
optimization. 

- The interfaces between modules of the compiler are almost as important
as the algorithms inside the modules. What are interfaces for example the tokens that Scanner outputs and pushes to the parser are a interface. In that example the outputted tokens would be the interface between scanner and parser.

### Modules and interfaces

- Any large software system is much easier to understand and implement if
the designer takes care with the fundamental abstractions and interfaces. Each phase is implemented as
one or more software modules. Breaking the compiler into this many pieces allows for reuse of the components

  Some of the interfaces, such as Abstract Syntax, IR Trees, and Assem, take
the form of data structures: For example, the Parsing Actions phase builds an
Abstract Syntax data structure and passes it to the Semantic Analysis phase.
Other interfaces are abstract data types; the Translate interface is a set of
functions that the Semantic Analysis phase can call, and the Tokens interface
takes the form of a function that the Parser calls to get the next token of the
input program.

  Basic idea is somethign like this:
  ```
  open file as f
  
  compiler = generate(opimize(IR(parser(scanner(f)))))
  ```
  
- Description of compiler phases:
  - `Lex` -- Break the source file into individual words, or tokens.
  
  - `Parse` --  Analyze the phrase structure of the program.
  
  - `Semantic Actions` -- Build a piece of abstract syntax tree corresponding to each phrase.
  
  - `Semantic Analysis` -- Determine what each phrase means, relate uses of variables to
their definitions, check types of expressions, request translation
of each phrase.

  - `Frame Layout` -- Place variables, function-parameters, etc. into activation records
(stack frames) in a machine-dependent way.

  - `Translate` --  Produce intermediate representation trees (IR trees), a notation that is not tied to any particular source language or targetmachine architecture.
  
  - `Canonicalize` --  Hoist side effects out of expressions, and clean up conditional
branches, for the convenience of the next phases

  - `Instruction Selection` -- Group the IR-tree nodes into clumps that correspond to the actions of target-machine instructions.
  
  - `Control Flow Analysis` -- Analyze the sequence of instructions into a control flow graph
that shows all the possible flows of control the program might
follow when it executes.

  - `Dataflow Analysis` -- Gather information about the flow of information through variables of the program; for example, liveness analysis calculates
the places where each program variable holds a still-needed value
(is live).

  - `Register Allocation` -- Choose a register to hold each of the variables and temporary
values used by the program; variables not live at the same time
can share the same register

  - `Code Emission` -- Replace the temporary names in each machine instruction with
machine registers.

### Tools and software

- Two of the most useful abstractions used in modern compilers are contextfree grammars, for parsing, and regular expressions, for lexical analysis. To
make the best use of these abstractions it is helpful to have special tools,

- such as `Yacc` (which converts a grammar into a parsing program) and Lex
(which converts a declarative specification into a lexical-analysis program).
Fortunately, such tools are available for Java, and the project described in this
book makes use of them.

  compiler. The parser generators JavaCC and SableCC are freely available on
the Internet; for information see the World Wide Web page

### Data structures for tree languages 

- m

<br>
<br>

---

<br>
<br>

# 2 Lexical Analysis

### Lexical tokens

### Regular expressions

### Finite automata

### Nondeterministic finite automata

### Lexical-analyzer generators

<br>
<br>

---

<br>
<br>

# 3 Parsing

### Context-free grammars

### Predictive parsing

### LR parsing

### Using parser generators

### Error recovery

<br>
<br>

---

<br>
<br>

# 4 Abstract Syntax

### Semantic actions

### Abstract parse trees

### Visitors

<br>
<br>

---

<br>
<br>

# 5 Semantic Analysis

### Symbol tables

### Type-checking MiniJava

<br>
<br>

---

<br>
<br>

# 6 Activation Records

### Stack frames

### Frames in the MiniJava compiler

<br>
<br>

---

<br>
<br>

# 7 Translation to Intermediate Code

### Intermediate representation trees

### Translation into trees

### Declarations

<br>
<br>

---

<br>
<br>

# 8 Basic Blocks and Traces 

### Canonical trees

### Taming conditional branches

<br>
<br>

---

<br>
<br>

# 9 Instruction Selection

### Algorithms for instruction selection

### CISC machines

### Instruction selection for the MiniJava compiler

<br>
<br>

---

<br>
<br>

# 10 Liveness Analysis

### Solution of dataflow equations

### Liveness in the MiniJava compiler

<br>
<br>

---

<br>
<br>

# 11 Register Allocation

### Coloring by simplification

### Coalescing

### Precolored nodes

### Graph-coloring implementation

### Register allocation for trees 

<br>
<br>

---

<br>
<br>

# 12 Putting It All Together 


<br>
<Br>

---

> __`Part II Advanced Topics`__


<br>
<br>

---

<br>
<br>

# 13 Garbage Collection
 
### Mark-and-sweep collection

### Reference counts

### Copying collection

### Generational collection

### Incremental collection

### Baker’s algorithm

### Interface to the compiler

<br>
<br>

---

<br>
<br>

# 14 Object-Oriented Languages

### Class extension

### Single inheritance of data fields

### Multiple inheritance

### Testing class membership

### Private fields and methods

### Classless languages

### Optimizing object-oriented programs

<br>
<br>

---

<br>
<br>

# 15 Functional Programming Languages

### A simple functional language

### Closures

### Immutable variables

### Inline expansion

### Closure conversion

### Efficient tail recursion

### Lazy evaluation

<br>
<br>

---

<br>
<br>

# 16 Polymorphic Types

### Parametric polymorphism

### Polymorphic type-checking

### Translation of polymorphic programs

### Resolution of static overloading

<br>
<br>

---

<br>
<br>

# 17 Dataflow Analysis

### Intermediate representation for flow analysis

### Various dataflow analyses

### Transformations using dataflow analysis

### Speeding up dataflow analysis

### Alias analysis

<br>
<br>

---

<br>
<br>

# 18 Loop Optimizations

### Dominators

### Loop-invariant computations

### Induction variables

### Array-bounds checks

### Loop unrolling

<br>
<br>

---

<br>
<br>

# 19 Static Single-Assignment Form

### Converting to SSA form

### Efficient computation of the dominator tree

### Optimization algorithms using SSA

### Arrays, pointers, and memory

### The control-dependence graph

### Converting back from SSA form

### A functional intermediate form

<br>
<br>

---

<br>
<br>

# 20 Pipelining and Scheduling 

### Loop scheduling without resource bounds

### Resource-bounded loop pipelining

### Branch prediction

<br>
<br>

---

<br>
<br>

# 21 The Memory Hierarchy

### Cache organization

### Cache-block alignment

### Prefetching

### Loop interchange

### Blocking

### Garbage collection and the memory hierarchy

<br>
<br>

---

<br>
<br>

# Appendix: MiniJava Language Reference Manual

### Lexical Issues

### Grammar

### Sample Program

<br>
<br>



