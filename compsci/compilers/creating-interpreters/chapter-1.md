# Creating Interpreters

> My notes of the e-book: https://craftinginterpreters.com

- Before we strap on our hiking boots and venture out, we should familiarize ourselves with the territory. The chapters in this part introduce you to the basic concepts used by programming languages and how they are organized.

  We will also get acquainted with Lox, the language we’ll spend the rest of the book implementing (twice). Let’s go!


<bR>

---

<Br>

# Introduction

- In these pages, we will walk step by step through two complete interpreters for a full-featured language. I assume this is your first foray into languages, so I’ll cover each concept and line of code you need to build a complete, usable, fast language implementation.

  In order to cram two full implementations inside one book without it turning into a doorstop, this text is lighter on theory than others

### Why Learn This Stuff?

- Implementing a language is a real test of programming skill. The code is complex and performance critical. You must master recursion, dynamic arrays, trees, graphs, and hash tables. You probably use hash tables at least in your day-to-day programming, but how well do you really understand them? Well, after we’ve crafted our own from scratch, I guarantee you will.

### How the Book is Organized

- This book is broken into three parts. You’re reading the first one now. It’s a couple of chapters to get you oriented, teach you some of the lingo language hackers use, and introduce you to Lox, the language we’ll be implementing.

  Each of the other two parts builds one complete Lox interpreter. Within those parts, each chapter is structured the same. Every one takes a single language feature, teaches you the concepts behind it, and walks through an implementation of it.

### The First Interpreter

- We’ll write our first interpreter, jlox, in Java. The focus is on concepts. We’ll write the simplest, cleanest code we can to correctly implement the semantics of the language. This will get us comfortable with the basic techniques and also hone our understanding of exactly how the language is supposed to behave.

  Java is a great language for this. It’s high level enough that we don’t get overwhelmed by fiddly implementation details, but it’s still pretty explicit. Unlike scripting languages, there tends to be less magic under the hood, and you’ve got static types to see what data structures you’re working with.
  
  By the end of part II, we’ll have a simple, readable implementation. What we won’t have is a fast one
  
- `NOTE` -- A compiler reads in files in one language and translates them to files in another language. You can implement a compiler in any language, including the same language it compiles, a process called “self-hosting”.
  
  You can’t compile it using itself yet, but if you have another compiler for your language written in some other language, you use that one to compile your compiler once. Now you can use the compiled version of your own compiler to compile future versions of itself and you can discard the original one compiled from the other compiler. This is called “bootstrapping”

### The Second Interpreter

- So in the next part, we’ll start all over again, but this time in C. C is the perfect language for understanding how an implementation really works, all the way down to the bytes in memory and the code flowing through the CPU.

  A big reason that we’re using C is so I can show you things C is particularly good at, but that does mean you’ll need to be pretty handy with it.
  
  In our C interpreter, clox, we are forced to implement for ourselves all the things Java gave us for free. We’ll write our own dynamic array and hash table. We’ll decide how objects are represented in memory, and build a garbage collector to reclaim it.
  
  Our Java implementation was focused on being correct. Now that we have that down, we’ll turn to also being fast.


<bR>

---

<Br>

# A Map of the Territory

### The Parts of a Language

### Shortcuts and Alternate Routes

### Compilers and Interpreters

### Our Journey


<bR>

---

<Br>

# The Lox Language


<bR>

---

<Br>

# A Tree-Walk Interpreter


<bR>

---

<Br>

# Scanning


<bR>

---

<Br>

# Representing Code 


<bR>

---

<Br>

# Parsing Expressions


<bR>

---

<Br>

# Evaluating Expressions


<bR>

---

<Br>

# Statements and State


<bR>

---

<Br>

# Control Flow


<bR>

---

<Br>

# Functions


<bR>

---

<Br>

# Resolving and Binding


<bR>

---

<Br>

# Classes


<bR>

---

<Br>

# Inheritance

<bR>

---

<Br>

# A Bytecode Virtual Machine

<bR>

---

<Br>

# Chunks of Bytecode

<bR>

---

<Br>

# A Virtual Machine

<bR>

---

<Br>

# Scanning on Demand

<bR>

---

<Br>

# Compiling Expressions

<bR>

---

<Br>

# Types of Values

<bR>

---

<Br>

# Strings

<bR>

---

<Br>

# Hash Tables

<bR>

---

<Br>

# Global Variables

<bR>

---

<Br>

# Local Variables

<bR>

---

<Br>

# Jumping Back and Forth

<bR>

---

<Br>

# Calls and Functions

<bR>

---

<Br>

# Closures

<bR>

---

<Br>

# Garbage Collection

<bR>

---

<Br>

# Classes and Instances

<bR>

---

<Br>

# Methods and Initializers

<bR>

---

<Br>

# Superclasses

<bR>

---

<Br>

# Optimization
