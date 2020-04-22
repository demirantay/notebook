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

- A compiler is a program that translates one language to another. The target language, that is the output of the compiler, is often assembler language or object code, but this is not necessarily the case. Many compilers convert one high level language to another high level language. One notable example of this is cfront, the UNIX C++ compiler, which translates C++ into C. The C language output is then fed into cc, the standard UNIX C compiler, which produces object code.

- In order to write a program that performs a translation on a language, that language must first be precisely and accurately defined. By precisely, we mean ALL aspects of the language must be set out. By accurately we mean that the language must be defined consistently to the smallest detail

  In order to create a language that meets these criteria, we must develop the concept of language in a formal mathematical sense. There are two parts to creating a language in the mathematical sense. The first part is defining rules for the language. This is called syntax. The second part is defining the meaning behind the rules. This is called semantics.
  
<br>
<br>

---

<Br>
<br>
  
# Syntax

- In order to define the syntax for a language we start with an alphabet. An alphabet is a series of tokens, not necessarily letters, that can be used to create strings in the alphabet. A string is a series of tokens pieced together according to the rules of the language. Strings are also sometimes referred to as sentences. So in order to define the syntax for a language, we need an alphabet and a set of rules used to manipulate the alphabet.

  The rules and the alphabet can be expressed together in one of two forms: Chomsky Normal Form (CNF) or Extended Backus Naur Form (EBNF) A description of the syntax of a language in either of these forms is called a grammar.
  
- Namely that what we normally understand as the alphabet is not what we define above as being the alphabet. According to our mathematical definition of a language, the words of the English language are the alphabet of the English language. 

  The alphabet is sometimes referred to as the lexical elements of a language. The following sentence is an example of an English language sentence:
  ```
  The cat sat.
  ```
  In this example there are three tokens, or members of the alphabet: `The`, `cat` and `sat`.
  
<br>
<br>

---

<br>
<br>

# Semantics

- Semantics refers to the meaning behind a sentence in a language. Developing mathematical rules to describe semantics has proven to be an elusive undertaking. It is possible to define a meaning for each token in an alphabet, but when tokens are placed together there are subtle interactions in meaning that make precise semantic definition of a language quite difficult. This is a major reason for continued difficulties in making modern languages completely portable.

  Solutions for describing the semantics of a language tend to be exponential, since interactions between a modifier and the object of the modifier have to be described.  Assignment statements and for loops exist in some form in most languages. But not every compiler just works for computer lang-to-computer lang. There are compilers which just translate human language to computer code (NLP) thats where you meet the harsh wilderness of compiler semantics design.
  
<br>
<br>

---

<Br>
<br>
  
# Chomsky Normal Form
