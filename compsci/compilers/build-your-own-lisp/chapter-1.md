# Build Your Own Lisp

Notes from http://www.buildyourownlisp.com

Table of Contents:
- [Chapter 1 • Introduction]()
- [Chapter 2 • Installation]()
- [Chapter 3 • Basics]()
- [Chapter 4 • An Interactive Prompt]()
- [Chapter 5 • Languages]()
- [Chapter 6 • Parsing]()
- [Chapter 7 • Evaluation]()
- [Chapter 8 • Error Handling]()
- [Chapter 9 • S-Expressions]()
- [Chapter 10 • Q-Expressions]()
- [Chapter 11 • Variables]()
- [Chapter 12 • Functions]()
- [Chapter 13 • Conditionals]()
- [Chapter 14 • Strings]()
- [Chapter 15 • Standard Library]()
- [Chapter 16 • Bonus Projects]()
- [Appendix A • Hand Rolled Parser]()


<Br>
<br>

---

<Br>
<Br>

# Chapter 1 • Introduction

> I skipped some parts that just teach the C language because I already have that in my notes. And to be fair the site does not explain C in a good way.

### About

- In this book you'll learn the C programming language and at the same time learn how to build your very own programming language, a minimal Lisp, in under 1000 lines of code! We'll be using a library to do some of the initial work, so I'm cheating a bit on the line count, but the rest of the code will be completely original, and you really will create a powerful little Lisp by the end.

### Why learn C

- C is one of the most popular and influential programming languages in the world. It is the language of choice for development on Linux, and has been used extensively in the creation of OS X and to some extent Microsoft Windows. It is used on micro-computers too. Your fridge and car probably run on it. In modern software development, the use of C may be escapable, but its legacy is not. Anyone wanting to make a career out of software development would be smart to learn C.

  The ideology of freedom is reflected in the nature of C itself. There is little C hides from you, including its warts and flaws. There is little C stops you from doing, including breaking your programs in horrible ways. When programming in C you do not stand on a path, but a plane of decision, and C dares you to decide what to do.

### How to learn C

- There is no way around the fact that C is a difficult language. It has many concepts that are unfamiliar, and it makes no attempts to help a new user. In this book I am not going to cover in detail things like the syntax of the language, or how to write loops and conditional statements.

  I will, on the other hand, show you how to build a real world program in C. This approach is always more difficult for the reader, but hopefully will teach you many implicit things a traditional approach cannot. I can't guarantee that this book will make you a confident user of C. What I can promise, is that those 1000 lines of code are going to be packed with content - and you will learn something worthwhile.

### Why build a Lisp

- The type of Lisp we'll be building is one I've invented for the purposes of this book. I've designed it for minimalism, simplicity and clarity, and I've become quite fond of it along the way. I hope you come to like it too. Conceptually, syntactically, and in implementation, this Lisp has a number of differences to other major brands of Lisp. If you are looking to learn about the semantics and behaviours of conventional Lisps, and how to program them, this book may not be for you. This book is more about building a language with C rather than showing you lisp.

<Br>
<br>

---

<Br>
<Br>

# Chapter 4 • An Interactive Prompt

### Read, Evaluate, Print

- As we build our programming language we'll need some way to interact with it. C uses a compiler, where you can change the program, recompile and run it. It'd be good if we could do something better, and interact with the language dynamically. Then we test its behaviour under a number of conditions very quickly. For this we can build something called an interactive prompt.

  This system is also called a REPL, which stands for read-evaluate-print loop. It is a common way of interacting with a programming language which you may have used before in languages such as Python.

### An Interactive Prompt

### Compilation

### Editing input

### The C Preprocessor

<br>
<br>

---

<Br>
<br>

# Chapter 5 • Languages

### What is a Programming Language?

### Parser Combinators

### Coding Grammars

### Natural Grammars

<br>
<Br>

---

<br>
<Br>

# Chapter 6 • Parsing

### Polish Notation

### Regular Expressions

### Installing mpc

### Polish Notation Grammar

### Parsing User Input

<Br>
<Br>

---

<br>
<br>

# Chapter 7 • Evaluation

### Trees

### Recursion

### Evaluation

### Printing

<Br>
<br>

---

<br>
<br>

# Chapter 8 • Error Handling

### Crashes

### Lisp Value

### Enumerations

### Lisp Value Functions

### Evaluating Errors

### Plumbing

<br>
<Br>

---

<Br>
<Br>

# Chapter 9 • S-Expressions

### Lists and Lisps

### Pointers

### The Stack & The Heap

### Parsing Expressions

### Expression Structure

### Constructors & Destructors

### Reading Expressions

### Printing Expressions

### Evaluating Expressions

<br>
<Br>

---

<Br>
<Br>

# Chapter 10 • Q-Expressions

### Adding Features

### Quoted Expressions

### Reading Q-Expressions

### Builtin Functions

### First Attempt

### Macros

### Builtins Lookup

<br>
<br>

---

<br>
<br>

# Chapter 11 • Variables

### Immutability

### Symbol Syntax

### Function Pointers

### Cyclic Types

### Function Type

### Environment

### Variable Evaluation

### Builtins

### Define Function

### Error Reporting

<br>
<br>

---

<br>
<br>

# Chapter 12 • Functions

### What is a Function?

### Function Type

### Lambda Function

### Parent Environment

### Function Calling

### Variable Arguments

### Interesting Functions

<br>
<br>

---

<br>
<br>

# Chapter 13 • Conditionals

### Doing it yourself

### Ordering

### Equality

### If Function

### Recursive Functions

<br>
<br>

---

<Br>
<Br>

# Chapter 14 • Strings

### Libraries

### String Type

### Reading Strings

### Comments

### Load Function

### Command Line Arguments

### Print Function

### Error Function

### Finishing Up

<br>
<br>

---

<Br>
<br>

# Chapter 15 • Standard Library

### Minimalism

### Atoms

### Building Blocks

### Logical Operators

### Miscellaneous Functions

### List Functions

### Conditional Functions

### Fibonacci

<br>
<br>

---

<Br>
<Br>

# Chapter 16 • Bonus Projects

### Only the Beginning

### Native Types

### User Defined Types

### List Literal

### Operating System Interaction

### Macros

### Variable Hashtable

### Pool Allocation

### Garbage Collection

### Tail Call Optimisation

### Lexical Scoping

### Static Typing

### Conclusion

<Br>
<Br>

---

<br>
<br>

# Appendix A • Hand Rolled Parser

### Hand Rolling

### Replacing mpc

### A Character at a Time

### Reading Symbols

### Reading Strings

### Printing Strings

### Cleaning Up
