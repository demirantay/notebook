# CHAPTER 2: Scanners

- The scanner’s task is to transform a stream of characters into a stream of
words in the input language. Each word must be classified into a syntactic
category, or “part of speech.” The scanner is the only pass in the compiler
to touch every character in the input program

  This chapter introduces regular expressions, a notation used to describe
the valid words in a programming language. It develops the formal mechanisms to generate scanners from regular expressions, either manually or
automatically.

  Keywords: Scanner, Finite Automaton, Regular Expression, Fixed Point

### Introduction

- Scanning is the first stage of a three-part process that the compiler uses
to understand the input program. The scanner, or lexical analyzer, reads a
stream of characters and produces a stream of words. It aggregates characters to form words and applies a set of rules to determine whether or not each
word is legal in the source language.

- `Conceptual Roadmap` -- This chapter describes the mathematical tools and programming techniques
that are commonly used to construct scanners s—both generated scanners
and hand-crafted scanners.

  Both generated and hand-crafted scanners rely on the same underlying techniques. While most textbooks and courses advocate the use of generated
scanners, most commercial compilers and open-source compilers use handcrafted scanners.

- `Overview` -- Western languages, such as English, have simple microsyntax. Adjacent
alphabetic letters are grouped together, left to right, to form a word.
A blank space terminates a word, as do most nonalphabetic symbols. (The
word-building algorithm can treat a hyphen in the midst of a word as
if it were an alphabetic character.) Once a group of characters has been
aggregated together to form a potential word, the word-building algorithm
can determine its validity with a dictionary lookup.

  Most programming languages have equally simple microsyntax. Characters
are aggregated into words. In most languages, blanks and punctuation marks
terminate a word.

  In a typical programming language, some words, called keywords or res- erved words, match the rule for an identifier but have special meanings. Both `while` and `static` are keywords in both C and Java. Keywords (and punctuation marks) form their own syntactic categories . To recognize keywords, the scanner can either use dictionary
lookup or encode the keywords directly into its microsyntax rules.

### Recognizing Words

- The simplest explanation of an algorithm to recognize words is often a
character-by-character formulation. The structure of the code can provide
some insight into the underlying problem. Consider the problem of recognizing the keyword `new`:
  ```
  c ← NextChar();
  if (c = ‘n’)
    then begin;
    c ← NextChar();
    if (c = ‘e’)
      then begin;
      c ← NextChar();
      if (c = ‘w’)
        then report success;
      else try something else;
      end;
    else try something else;
    end;
  else try something else;
  ```
  In the code, cases that do not
match new try something else. In the recognizer, we can think of this action
as a transition to an error state

- `A Formalism for Recognizers` -- Transition diagrams serve as abstractions of the code that would be required
to implement them. They can also be viewed as formal mathematical obj- ects, called finite automata, that specify recognizers. Formally, a finite

- `Recognizing More Complex Words` -- 

### Regular Expressions

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
