# Types of Parsing

- Syntax analyzers follow production rules defined by means of context-free grammar. The way the production rules are implemented (derivation) divides parsing into two types : top-down parsing and bottom-up parsing.

- `Top-down Parsing` -- When the parser starts constructing the parse tree from the start symbol and then tries to transform the start symbol to the input, it is called top-down parsing.

- `Bottom-up Parsing` -- As the name suggests, bottom-up parsing starts with the input symbols and tries to construct the parse tree up to the start symbol.

<br>
<Br>

---

<br>
<br>

# Top-Down Parser

- We have learnt in the last chapter that the top-down parsing technique parses the input, and starts constructing a parse tree from the root node gradually moving down to the leaf nodes

- `Recursive Descent Parsing` -- Recursive descent is a top-down parsing technique that constructs the parse tree from the top and the input is read from left to right. It uses procedures for every terminal and non-terminal entity. This parsing technique recursively parses the input to make a parse tree, which may or may not require back-tracking A form of recursive-descent parsing that does not require any back-tracking is known as `predictive parsing`.

- `Predictive Parser` -- Predictive parser is a recursive descent parser, which has the capability to predict which production is to be used to replace the input string. The predictive parser does not suffer from backtracking.

  To accomplish its tasks, the predictive parser uses a look-ahead pointer, which points to the next input symbols. To make the parser back-tracking free, the predictive parser puts some constraints on the grammar and accepts only a class of grammar known as LL(k) grammar.
  
- `LL Parser` -- An LL Parser accepts LL grammar. LL grammar is a subset of context-free grammar but with some restrictions to get the simplified version, in order to achieve easy implementation. LL grammar can be implemented by means of both algorithms namely, recursive-descent or table-driven.

  LL parser is denoted as LL(k). The first L in LL(k) is parsing the input from left to right, the second L in LL(k) stands for left-most derivation and k itself represents the number of look aheads. Generally k = 1, so LL(k) may also be written as LL(1). (you can check out LL(1) algorithm implementation in different files this is just a introductiory note file)

<br>
<br>

---

<br>
<Br>

# Bottom-Up-Parser

- Bottom-up parsing starts from the leaf nodes of a tree and works in upward direction till it reaches the root node. Here, we start from a sentence and then apply production rules in reverse manner in order to reach the start symbol.

- `Shift-Reduce Parsing` -- Shift-reduce parsing uses two unique steps for bottom-up parsing. These steps are known as shift-step and reduce-step.
  - `Shift step`: The shift step refers to the advancement of the input pointer to the next input symbol, which is called the shifted symbol. This symbol is pushed onto the stack. The shifted symbol is treated as a single node of the parse tree.
  - `Reduce step`: When the parser finds a complete grammar rule (RHS) and replaces it to (LHS), it is known as reduce-step. 

- `LR Parser` -- The LR parser is a non-recursive, shift-reduce, bottom-up parser. It uses a wide class of context-free grammar which makes it the most efficient syntax analysis technique. LR parsers are also known as LR(k) parsers, where L stands for left-to-right scanning of the input stream; R stands for the construction of right-most derivation in reverse, and k denotes the number of lookahead symbols to make decisions.

<br>
<Br>

---

<br>
<Br>

# Error Recovery

- A parser should be able to detect and report any error in the program. It is expected that when an error is encountered, the parser should be able to handle it and carry on parsing the rest of the input. Mostly it is expected from the parser to check for errors but errors may be encountered at various stages of the compilation process. A program may have the following kinds of errors at various stages:
  - `Lexical` : name of some identifier typed incorrectly
  - `Syntactical` : missing semicolon or unbalanced parenthesis
  - `Semantical` : incompatible value assignment
  - `Logical` : code not reachable, infinite loop
  
  There are four common error-recovery strategies that can be implemented in the parser to deal with errors in the code:
  
- `Panic mode` -- When a parser encounters an error anywhere in the statement, it ignores the rest of the statement by not processing input from erroneous input to delimiter, such as semi-colon. This is the easiest way of error-recovery and also, it prevents the parser from developing infinite loops.

- `Statement mode` -- When a parser encounters an error, it tries to take corrective measures so that the rest of inputs of statement allow the parser to parse ahead. For example, inserting a missing semicolon, replacing comma with a semicolon etc. Parser designers have to be careful here because one wrong correction may lead to an infinite loop.

- `Error productions` --  In addition, the designers can create augmented grammar to be used, as productions that generate erroneous constructs when these errors are encountered.

- `Global correction` -- The parser considers the program in hand as a whole and tries to figure out what the program is intended to do and tries to find out a closest match for it, which is error-free. When an erroneous input (statement) X is fed, it creates a parse tree for some closest error-free statement Y.

<br>
<Br>

---

<br>
<br>

# Semantic Analysis

- We have learnt how a parser constructs parse trees in the syntax analysis phase. The plain parse-tree constructed in that phase is generally of no use for a compiler, as it does not carry any information of how to evaluate the tree. The productions of context-free grammar, which makes the rules of the language, do not accommodate how to interpret them.

### Semantics

- Semantics of a language provide meaning to its constructs, like tokens and syntax structure. Semantics help interpret symbols, their types, and their relations with each other. Semantic analysis judges whether the syntax structure constructed in the source program derives any meaning or not.

  For example in a C compiler:
  ```c
  int a = “value”;
  ```
  should not issue an error in lexical and syntax analysis phase, as it is lexically and structurally correct, but it should generate a semantic error as the type of the assignment differs. These rules are set by the grammar of the language and evaluated in semantic analysis. The following tasks should be performed in semantic analysis:
  - Scope resolution
  - Type checking
  - Array-bound checking

- `Semantic Errors` -- We have mentioned some of the semantics errors that the semantic analyzer is expected to recognize:
  - Type mismatch
  - Undeclared variable
  - Reserved identifier misuse.
  - Multiple declaration of variable in a scope.
  - Accessing an out of scope variable.
  - Actual and formal parameter mismatch. 
  
### Attribute Grammar

- Attribute grammar is a special form of context-free grammar where some additional information (attributes) are appended to one or more of its non-terminals in order to provide context-sensitive information. Each attribute has well-defined domain of values, such as integer, float, character, string, and expressions.

  Attribute grammar is a medium to provide semantics to the context-free grammar and it can help specify the syntax and semantics of a programming language

<br>
<br>

---

<br>
<Br>

# Run-Time Environment

- A program as a source code is merely a collection of text (code, statements etc.) and to make it alive, it requires actions to be performed on the target machine. A program needs memory resources to execute instructions. A program contains names for procedures, identifiers etc., that require mapping with the actual memory location at runtime.

  By runtime, we mean a program in execution. Runtime environment is a state of the target machine, which may include software libraries, environment variables, etc., to provide services to the processes running in the system.
  
  Runtime support system is a package, mostly generated with the executable program itself and facilitates the process communication between the process and the runtime environment. It takes care of memory allocation and de-allocation while the program is being executed.
  
### Activation Trees

- A program is a sequence of instructions combined into a number of procedures. Instructions in a procedure are executed sequentially. A procedure has a start and an end delimiter and everything inside it is called the body of the procedure. The procedure identifier and the sequence of finite instructions inside it make up the body of the procedure.

  The execution of a procedure is called its activation. An activation record contains all the necessary information required to call a procedure.
  - `Temporaries` --	Stores temporary and intermediate values of an expression.
  - `Local Data` --	Stores local data of the called procedure.
  - `Machine Status` --	Stores machine status such as Registers, Program Counter etc., before the procedure is called.
  - `Control Link` --	Stores the address of activation record of the caller procedure.
  - `Access Link` --	Stores the information of data which is outside the local scope.
  - `Actual Parameters` --	Stores actual parameters, i.e., parameters which are used to send input to the called procedure.
  - `Return Value` --	Stores return values.

  Whenever a procedure is executed, its activation record is stored on the stack, also known as control stack.
  
### Storage Allocation

- There are many ways that a runtime enviorement allocates the storage:

- `Static Allocation` -- In this allocation scheme, the compilation data is bound to a fixed location in the memory and it does not change when the program executes

- `Stack Allocation` -- Procedure calls and their activations are managed by means of stack memory allocation. It works in last-in-first-out (LIFO) method and this allocation strategy is very useful for recursive procedure calls.

- `Heap Allocation` --  Variables local to a procedure are allocated and de-allocated only at runtime. Heap allocation is used to dynamically allocate memory to the variables and claim it back when the variables are no more required.

<br>
<br>

---

<br>
<Br>
  
# Symbol Table

- Symbol table is an important data structure created and maintained by compilers in order to store information about the occurrence of various entities such as variable names, function names, objects, classes, interfaces, etc. Symbol table is used by both the analysis and the synthesis parts of a compiler. A symbol table may serve the following purposes depending upon the language in hand:
  - To store the names of all entities in a structured form at one place.
  - To verify if a variable has been declared.
  - To implement type checking, by verifying assignments and expressions in the source code are semantically correct.
  - To determine the scope of a name (scope resolution).
  
  A symbol table is simply a table which can be either linear or a hash table. It maintains an entry for each name in the following format:
  ```
  <symbol name,  type,  attribute>
  ```
  Lets see an example 
  ```c++
  static int interest;
  ```
  the table record would be something like this:
  ```
  <interest, int, static>
  ```
  
- `Implementation` -- A symbol table can be implemented in one of the following ways:
  -
  -
  -

### Operations

### Scope Management

<Br>
<br>
  
---

<br>
<br>
