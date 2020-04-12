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

- `Interpreter` --

- `Assembler` --

- `Linker` -- 

- `Loader` --

- `Cross-compiler` --

- `Source-to-source Compiler` --

<br>
<bR>

---

<br>
<br>

# Architecture
