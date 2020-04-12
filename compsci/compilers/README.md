# Compilers 

- A compiler translates the code written in one language to some other language without changing the meaning of the program. It is also expected that a compiler should make the target code efficient and optimized in terms of time and space.

  Compiler design principles provide an in-depth view of translation and optimization process. Compiler design covers basic translation mechanism and error detection & recovery. It includes lexical, syntax, and semantic analysis as front end, and code generation and optimization as back-end.
  
<br>
<br>

---

<br>
<br>

# Overview

- Computers are a balanced mix of software and hardware. Hardware is just a piece of mechanical device and its functions are being controlled by a compatible software. Hardware understands instructions in the form of electronic charge, which is the counterpart of binary language in software programming. Binary language has only two alphabets, 0 and 1. To instruct, the hardware codes must be written in binary format, which is simply a series of 1s and 0s. It would be a difficult and cumbersome task for computer programmers to write such codes, which is why we have compilers to write such codes.

### Language Processing System

- So we write programs in high-level language, which is easier for us to understand and remember. These programs are then fed into a series of tools and OS components to get the desired code that can be used by the machine. This is known as Language Processing System:
  ```
  Source Code -> Pre-processor -> pre-processed code -> Compiler -> Target Assembly Code -> Assembler -> Relocatable Machine Code -> Linker -> Executable Machine Code -> Loader -> Memory 
  ```
  A compiler is a program that converts high-level language to assembly language. Similarly, an assembler is a program that converts the assembly language to machine-level language.
  
  Before diving straight into the concepts of compilers, we should understand a few other tools that work closely with compilers.
  
- `Preprocessor` -- A preprocessor, generally considered as a part of compiler, is a tool that produces input for compilers. It deals with macro-processing, augmentation, file inclusion, language extension, etc.

- `Interpreter` -- An interpreter, like a compiler, translates high-level language into low-level machine language. The difference lies in the way they read the source code or input. A compiler reads the whole source code at once, creates tokens, checks semantics, generates intermediate code, executes the whole program and may involve many passes. In contrast, an interpreter reads a statement from the input, converts it to an intermediate code, executes it, then takes the next statement in sequence. If an error occurs, an interpreter stops execution and reports it. whereas a compiler reads the whole program even if it encounters several errors.

- `Assembler` -- An assembler translates assembly language programs into machine code.The output of an assembler is called an object file, which contains a combination of machine instructions as well as the data required to place these instructions in memory.

- `Linker` -- Linker is a computer program that links and merges various object files together in order to make an executable file. All these files might have been compiled by separate assemblers. The major task of a linker is to search and locate referenced module/routines in a program and to determine the memory location where these codes will be loaded, making the program instruction to have absolute references.

- `Loader` -- Loader is a part of operating system and is responsible for loading executable files into memory and execute them It initializes various registers to initiate execution.

- `Cross-compiler` -- A compiler that runs on platform (A) and is capable of generating executable code for platform (B) is called a cross-compiler.

- `Source-to-source Compiler` -- A compiler that takes the source code of one programming language and translates it into the source code of another programming language is called a source-to-source compiler.

<br>
<bR>

---

<br>
<br>

# Architecture

- A compiler can broadly be divided into two phases based on the way they compile.

### Analysis Phase

- Known as the front-end of the compiler, the analysis phase of the compiler reads the source program, divides it into core parts and then checks for lexical, grammar and syntax errors.

  The analysis phase generates an intermediate representation of the source program and symbol table, which should be fed to the Synthesis phase as input.

### Synthesis Phase

- Known as the back-end of the compiler, the synthesis phase generates the target program with the help of intermediate source code representation and symbol table.

<br>
<br>

---

<Br>
<br>

# Phases of Compiler 

- The compilation process is a sequence of various phases. Each phase takes input from its previous stage: 

  `1) Lexical Analysis` -- The first phase of scanner works as a text scanner. This phase scans the source code as a stream of characters and converts it into meaningful lexemes. Lexical analyzer represents these lexemes in the form of tokens as
  ```
  <token-name, attribute-value>
  ```
  
  `2) Syntax Analysis` -- The next phase is called the syntax analysis or parsing. It takes the token produced by lexical analysis as input and generates a parse tree (or syntax tree)
  
  `3) Semantic Analysis` -- Semantic analysis checks whether the parse tree constructed follows the rules of language. For example, assignment of values is between compatible data types, and adding string to an integer. Also, the semantic analyzer keeps track of identifiers, their types and expressions The semantic analyzer produces an annotated syntax tree as an output.
  
  `4) Intermediate Code Generation` -- After semantic analysis the compiler generates an intermediate code of the source code for the target machine. It represents a program for some abstract machine. It is in between the high-level language and the machine language. This intermediate code should be generated in such a way that it makes it easier to be translated into the target machine code.
  
  `5) Code Optimization` -- The next phase does code optimization of the intermediate code. Optimization can be assumed as something that removes unnecessary code lines, and arranges the sequence of statements in order to speed up the program 
  
  `6) Code Generation` -- In this phase, the code generator takes the optimized representation of the intermediate code and maps it to the target machine language. Sequence of instructions of machine code performs the task as the intermediate code would do.
  
  `7) Symbol Table` -- It is a data-structure maintained throughout all the phases of a compiler. All the identifier's names along with their types are stored here. The symbol table makes it easier for the compiler to quickly search the identifier record and retrieve it.
  
<br>
<br>

---

<br>
<Br>
  
# Lexical Analysis 

- Lexical analysis is the first phase of a compiler. It takes the modified source code from language preprocessors that are written in the form of sentences. The lexical analyzer breaks these syntaxes into a series of tokens, by removing any whitespace or comments in the source code.

### Tokens

- Lexemes are said to be a sequence of characters (alphanumeric) in a token. There are some predefined rules for every lexeme to be identified as a valid token. These rules are defined by grammar rules, by means of a pattern. A pattern explains what can be a token, and these patterns are defined by means of regular expressions.

  In programming language, keywords, constants, identifiers, strings, numbers, operators and punctuations symbols can be considered as tokens.
  
  For example, in C language, the variable declaration line
  ```c
  int value = 100;
  ```
  contains the tokens:
  ```
  int (keyword), value (identifier), = (operator), 100 (constant) and ; (symbol).
  ```

### Specifications of Tokens

- Let us understand how the language theory undertakes the following terms:
  
- `Alphabets` -- Any finite set of symbols {0,1} is a set of binary alphabets, {0,1,2,3,4,5,6,7,8,9,A,B,C,D,E,F} is a set of Hexadecimal alphabets, {a-z, A-Z} is a set of English language alphabets.

- `Strings` -- Any finite sequence of alphabets is called a string.

- _Special Symbol_ -- A typical high-level language contains the following symbols:-
  - `Arithmetic Symbols` -- 	Addition(+), Subtraction(-), Modulo(%), Multiplication(*), Division(/)
  - `Punctuation` -- Comma(,), Semicolon(;), Dot(.), Arrow(->)
  - `Assignment` -- =
  - `Special Assignment` -- +=, /=, *=, -=
  - `Comparison` -- ==, !=, <, <=, >, >=
  - `Preprocessor` -- #
  - `Location Specifier` -- &
  - `Logical` -- &, &&, |, ||, !
  - `Shift Operator` -- >>, >>>, <<, <<<
  
### Longest Match Rule

- When the lexical analyzer read the source-code, it scans the code letter by letter; and when it encounters a whitespace, operator symbol, or special symbols, it decides that a word is completed.
  ```
  int intvalue;
  ```
  While scanning both lexemes till ‘int’, the lexical analyzer cannot determine whether it is a keyword int or the initials of identifier int value.
  
  The lexical analyzer also follows `rule priority` where a reserved word, e.g., a keyword, of a language is given priority over user input. That is, if the lexical analyzer finds a lexeme that matches with any existing reserved word, it should generate an error.
  
<br>
<br>

---

<br>
<br>

# Regular Expressions 

- The lexical analyzer needs to scan and identify only a finite set of valid string/token/lexeme that belong to the language in hand. It searches for the pattern defined by the language rules.

  Regular expressions have the capability to express finite languages by defining a pattern for finite strings of symbols. The grammar defined by regular expressions is known as `regular grammar`. The language defined by regular grammar is known as `regular language`. Regular expression is an important notation for specifying patterns

### Operations

- The various operations on languages are:
  - Union of two languages L and M is written as:
    ```
    L U M = {s | s is in L or s is in M}
    ```
  - Concatenation of two languages L and M is written as
    ```
    LM = {st | s is in L and t is in M}
    ```
  - The Kleene Closure of a language L is written as
    ```
    L* = Zero or more occurrence of language L.
    ```

### Notations

- If r and s are regular expressions denoting the languages L(r) and L(s), then
  - `Union` : (r)|(s) is a regular expression denoting L(r) U L(s)
  - `Concatenation` : (r)(s) is a regular expression denoting L(r)L(s)
  - `Kleene closure` : (r)* is a regular expression denoting (L(r))*

### Representing valid tokens of a language in regular expression

- If x is a regular expression, then:
  - `x*` -- means zero or more occurrence of x. i.e., it can generate { e, x, xx, xxx, xxxx, … }
  - `x+` -- means one or more occurrence of x. i.e., it can generate { x, xx, xxx, xxxx … } or x.x*
  - `x?` -- means at most one occurrence of x i.e., it can generate either {x} or {e}.
  - `[a-z]` -- is all lower-case alphabets of English language.
  - `[A-Z]` -- is all upper-case alphabets of English language.
  - `[0-9]` -- is all natural digits used in mathematics.

The only problem left with the lexical analyzer is how to verify the validity of a regular expression used in specifying the patterns of keywords of a language. A well-accepted solution is to use finite automata for verification.

