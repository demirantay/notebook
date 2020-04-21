# Compiler Basics

Paper by: © James Alan Farrell, August 1995 [link](http://www.cs.man.ac.uk/~pjj/farrell/compmain.html)

Table of contents:
- [About this paper](#about-this-paper)
- [Basic Language Theory]()
- [Syntax]()
- [Semantics]()
- [Chomsky Normal Form]()
- [Extended Backus Naur Form (EBNF)]()
- [Computer Languages]()
- [Anatomy of a Compiler]()
- [The Tokenizer]()
- [Expression Parsing]()
- [Parsing Data Structures]()
- [Parsing Code Structures]()
- [Parsing Procedures and Scoping]()
- [Parsing Objects]()
- [Error Handling]()
- [Code Interpretation]()
- [Code Generation]()

<br>
<br>

---

<br>
<br>

# About this paper

- This paper is intended to give an overview of basic compiler theory. It is not intended to be complete by any means. It certainly will not replace a college level compiler course, however, it will provide a good solid foundation on which such a course can build.

- This paper does not develop a full compiler, but small examples are given in many places. Where possible, examples are given in Pascal; that is the code being parsed is Pascal and the code performing the parsing is also Pascal. This language is simple and elegant. Where C is more powerful, Pascal is more readable

- Object Oriented Programming is not covered in detail, however there is a section given on parsing objects. It seems that C++ has become the standard object oriented language, but because of its heritage it is a convoluted language that is difficult to understand. So instead of using C++ for the examples the language Language for Object Oriented Programming (LOOP) will be used. This is a language I am working on, that is intended to be a beginners' object oriented language.

<br>
<br>

---

<br>
<br>

# Basic Language Theory
