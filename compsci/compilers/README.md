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

<br>
<br>

---

<br>
<br>

# Finite Automata

- Finite automata is a state machine that takes a string of symbols as input and changes its state accordingly. Finite automata is a recognizer for regular expressions. When a regular expression string is fed into finite automata, it changes its state for each literal. If the input string is successfully processed and the automata reaches its final state,

  The mathematical model of finite automata consists of:
  - Finite set of states (Q)
  - Finite set of input symbols (Σ)
  - One Start state (q0)
  - Set of final states (qf)
  - Transition function (δ)

<br>
<br>

---

<br>
<br>

# Syntax Anaylsis

- Syntax analysis or parsing is the second phase of a compiler. In this chapter, we shall learn the basic concepts used in the construction of a parser.

  We have seen that a lexical analyzer can identify tokens with the help of regular expressions and pattern rules. But a lexical analyzer cannot check the syntax of a given sentence due to the limitations of the regular expressions. Regular expressions cannot check balancing tokens, such as parenthesis. Therefore, this phase uses context-free grammar (CFG), which is recognized by push-down automata.
  
### Context-Free Grammar

- A context-free grammar has four components:
  - `non-terminals (V)` -- Non-terminals are syntactic variables that denote sets of strings. The non-terminals define sets of strings that help define the language generated by the grammar.
  - `terminal symbols (Σ)` -- Terminals are the basic symbols from which strings are formed
  - `productions (P)` -- The productions of a grammar specify the manner in which the terminals and non-terminals can be combined to form strings. Each production consists of a non-terminal called the left side of the production, an arrow, and a sequence of tokens and/or on- terminals, called the right side of the production.

### Syntax Analyzers

- A syntax analyzer or parser takes the input from a lexical analyzer in the form of token streams. The parser analyzes the source code (token stream) against the production rules to detect any errors in the code. The output of this phase is a `parse tree`.

  This way, the parser accomplishes two tasks, i.e., parsing the code, looking for errors and generating a parse tree as the output of the phase. Parsers are expected to parse the whole code even if some errors exist in the program. Parsers use error recovering strategies, which we will learn later in this chapter.

### Derivation

- A derivation is basically a sequence of production rules, in order to get the input string. During parsing, we take two decisions for some sentential form of input:
  - Deciding the non-terminal which is to be replaced.
  - Deciding the production rule, by which, the non-terminal will be replaced.

### Parse Tree

- A parse tree is a graphical depiction of a derivation. It is convenient to see how strings are derived from the start symbol. The start symbol of the derivation becomes the root of the parse tree.

  In a parse tree:
   - All leaf nodes are terminals.
   - All interior nodes are non-terminals.
   - In-order traversal gives original input string.
   
   A parse tree depicts associativity and precedence of operators. The deepest sub-tree is traversed first, therefore the operator in that sub-tree gets precedence over the operator which is in the parent nodes.

### Ambiguity

- A grammar G is said to be ambiguous if it has more than one parse tree (left or right derivation) for at least one string.
  
  For example: For the string `id + id – id`, the above grammar generates two parse trees
  
  Ambiguity in grammar is not good for a compiler construction. No method can detect and remove ambiguity automatically, but it can be removed by either re-writing the whole grammar without ambiguity, or by setting and following associativity and precedence constraints.

### Precedence

- If two different operators share a common operand, the precedence of operators decides which will take the operand. That is, `2+3*4` can have two different parse trees, one corresponding to `(2+3)*4` and another corresponding to `2+(3*4)`. By setting precedence among operators, this problem can be easily removed. As in the previous example, mathematically * (multiplication) has precedence over + (addition).

### Left Recursion

- A grammar becomes left-recursive if it has any non-terminal ‘A’ whose derivation contains ‘A’ itself as the left-most symbol. Left-recursive grammar is considered to be a problematic situation for top-down parsers. Top-down parsers start parsing from the Start symbol, which in itself is non-terminal. So, when the parser encounters the same non-terminal in its derivation, it becomes hard for it to judge when to stop parsing the left non-terminal and it goes into an infinite loop.

### Left Factoring

- If more than one grammar production rules has a common prefix string, then the top-down parser cannot make a choice as to which of the production it should take to parse the string in hand. Then it cannot determine which production to follow to parse the string as both productions are starting from the same terminal (or non-terminal). To remove this confusion, we use a technique called left factoring.

### First and Follow Sets

- An important part of parser table construction is to create first and follow sets. These sets can provide the actual position of any terminal in the derivation.

### Limitations of Syntax Analyzers

- Syntax analyzers receive their inputs, in the form of tokens, from lexical analyzers. Lexical analyzers are responsible for the validity of a token supplied by the syntax analyzer. Syntax analyzers have the following drawbacks -
  - it cannot determine if a token is valid,
  - it cannot determine if a token is declared before it is being used,
  - it cannot determine if a token is initialized before it is being used,
  - it cannot determine if an operation performed on a token type is valid or not.
  
  These tasks are accomplished by the semantic analyzer, which we shall study in Semantic Analysis.
  
<Br>
<br>
  
---

<br>
<br>

[part 2](./README2.md)
