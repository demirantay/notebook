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

<br>
<br>

---

<br>
<br>

# A Map of the Territory

- First, let me establish a shorthand. Much of this book is about a language’s implementation, which is distinct from the language itself in some sort of Platonic ideal form. 

### The Parts of a Language

-  Not every language takes the exact same path—some take a shortcut or two—but otherwise they are reassuringly similar from Rear Admiral Grace Hopper’s first COBOL compiler all the way to some hot new transpile-to-JavaScript language whose “documentation” consists entirely of a single poorly-edited README in a Git repository somewhere.

- `Scanning` -- The first step is scanning, also known as lexing, or (if you’re trying to impress someone) lexical analysis. They all mean pretty much the same thing. A scanner (or “lexer”) takes in the linear stream of characters and chunks them together into a series of something more akin to “words”. In programming languages, each of these words is called a token.

  Some characters in a source file don’t actually mean anything. Whitespace is often insignificant and comments, by definition, are ignored by the language. The scanner usually discards these, leaving a clean sequence of meaningful tokens. 

- `Parsing` -- The next step is parsing. This is where our syntax gets a grammar—the ability to compose larger expressions and statements out of smaller parts.

  A parser takes the flat sequence of tokens and builds a tree structure that mirrors the nested nature of the grammar. These trees have a couple of different names—“parse tree” or “abstract syntax tree”

- `Static Analysis` -- The first two stages are pretty similar across all implementations. Now, the individual characteristics of each language start coming into play. At this point, we know the syntactic structure of the code—things like operator precedence and expression nesting—but we don’t know much more than that.

  The first bit of analysis that most languages do is called binding or resolution. For each identifier we find out where that name is defined and wire the two together. This is where scope comes into play
  
  Everything up to this point is considered the front end of the implementation. You might guess everything after this is the back end, but no. Back in the days of yore when “front end” and “back end” were coined, compilers were much simpler. Later researchers invented new phases to stuff between the two halves. Rather than discard the old terms, William Wulf and company lumped them into the charming but spatially paradoxical name “middle end”.

- `Intermediate Representation` -- You can think of the compiler as a pipeline where each stage’s job is to organize the code in a way that makes the next stage simpler to implement. The front end of the pipeline is specific to the source language the user is programming in. The back end is concerned with the final architecture that the code will run on.

  In the middle, the code may be stored in some intermediate representation (or “IR”) the IR acts as an interface between these two languages. This lets you support multiple source languages and target platforms with less effort

- `Optimization` -- Once we understand what the user’s program means, we are free to swap it out with a different program that has the same semantics but implements them more efficiently—we can optimize it. Optimization is a huge part of the programming language business. Many language hackers spend their entire careers here, squeezing every drop of performance they can out of their compilers to get their benchmarks a fraction of a percent faster. 

- `Code Generation` -- We have applied all of the optimizations we can think of to the user’s program. The last step is converting it to a form the machine can actually run. In other words generating code, where “code” refers to the kind of primitive assembly-like instructions a CPU runs and not the kind of “source code” a human might want to read.

  We have a decision to make. Do we generate instructions for a real CPU or a virtual one? If we generate real machine code, we get an executable that the OS can load directly onto the chip. Native code is lightning fast, but generating it is a lot of work. Today’s architectures have piles of instructions, complex pipelines Speaking the chip’s language also means your compiler is tied to a specific architecture. If your compiler targets x86 machine code, it’s not going to run on an ARM device
  
  To get around that, hackers like Martin Richards and Niklaus Wirth, of BCPL and Pascal fame, respectively, made their compilers produce virtual machine code. Instead of instructions for some real chip, they produced code for a hypothetical, idealized machine. Wirth called this “p-code” for “portable”, but today, we generally call it __bytecode__

- `Virtual Machine` -- If your compiler produces bytecode, your work isn’t over once that’s done. Since there is no chip that speaks that bytecode, it’s your job to translate. Again, you have two options. You can write a little mini-compiler for each target architecture that converts the bytecode to native code for that machine. You still have to do work for each chip you support, but this last stage is pretty simple and you get to reuse the rest of the compiler pipeline across all of the machines you support. You’re basically using your bytecode as an intermediate representation.

  Or you can write a virtual machine (VM), a program that emulates a hypothetical chip supporting your virtual architecture at runtime. Running bytecode in a VM is slower than translating it to native code ahead of time because every instruction must be simulated at runtime each time it executes. In return, you get simplicity and portability. Implement your VM in, say, C, and you can run your language on any platform that has a C compiler.

- `Runtime` -- We have finally hammered the user’s program into a form that we can execute. The last step is running it. If we compiled it to machine code, we simply tell the operating system to load the executable and off it goes. If we compiled it to bytecode, we need to start up the VM and load the program into that.

### Shortcuts and Alternate Routes

- That’s the long path covering every possible phase you might implement. Many languages do walk the entire route, but there are a few shortcuts and alternate paths.

- `Single-pass compilers` -- Some simple compilers interleave parsing, analysis, and code generation so that they produce output code directly in the parser, without ever allocating any syntax trees or other IRs.  You have no intermediate data structures to store global information about the program, and you don’t revisit any previously parsed part of the code

  Pascal and C were designed around this limitation. At the time, memory was so precious that a compiler might not even be able to hold an entire source file in memory, much less the whole program.

- `Tree-walk interpreters` -- Some programming languages begin executing code right after parsing it to an AST (with maybe a bit of static analysis applied).  This style of interpretation is common for student projects and little languages, but is not widely used for general-purpose languages since it tends to be slow. Some people use “interpreter” to mean only these kinds of implementations, but others define that word more generally, so I’ll use the inarguably explicit “tree-walk interpreter”

- `Transpilers` -- We write a front end for our language. Then, in the back end, instead of doing all the work to lower the semantics to some primitive target language, we produce a string of valid source code for some other language that’s about as high level as ours.

  They used to call this a “source-to-source compiler” or a “transcompiler”. After the rise of languages that compile to JavaScript in order to run in the browser, they’ve affected the hipster sobriquet “transpiler”. While the first transcompiler translated one assembly language to another, today, almost all transpilers work on higher-level languages.
  
   C compilers were available everywhere UNIX was and produced efficient code, so targeting C was a good way to get your language running on a lot of architectures.
   
   Web browsers are the “machines” of today, and their “machine code” is JavaScript, so these days it seems almost every language out there has a compiler that targets JS

- `Just-in-time compilation` -- This last one is less of a shortcut and more a challenging scramble best reserved for experts. The fastest way to execute code is by compiling it to machine code, but you might not know what architecture your end user’s machine supports. What to do?

  You can do the same thing the HotSpot JVM, Microsoft’s CLR and most JavaScript interpreters do. On the end user’s machine, when the program is loaded—either from source in the case of JS, or platform-independent bytecode for the JVM and CLR—you compile it to native for the architecture their computer supports. Naturally enough, this is called just-in-time compilation. Most hackers just say “JIT”

### Compilers and Interpreters

- “What’s the difference between a compiler and an interpreter?”

  __Compiling__ -- is an implementation technique that involves translating a source language to some other—usually lower-level—form. When you generate bytecode or machine code, you are compiling. When you transpile to another high-level language you are compiling too. When we say a language implementation “is a compiler”, we mean it translates source code to some other form but doesn’t execute it. The user has to take the resulting output and run it themselves.
  
  __Interpereter__ -- Conversely, when we say an implementation “is an interpreter”, we mean it takes in source code and executes it immediately. It runs programs “from source”. The user does not have to run it themselves.
  
<br>
<br>

---

<br>
<br>

# The Lox Language

- It seems cruel to have you immediately start grinding out code for the interpreter without at least a glimpse of what we’re going to end up with.

### Hello, Lox

- Here’s your very first taste of Lox:
  ```lox
  // Your first Lox program!
  print "Hello, world!";
  ```
  As that // line comment and the trailing semicolon imply, Lox’s syntax is a member of the C family. (There are no parentheses around the string because print is a built-in statement, and not a library function.)

### A High-Level Language

- When I think of languages that are small but useful, what comes to mind are high-level “scripting” languages like JavaScript, Scheme, and Lua. Of those three, Lox looks most like JavaScript, mainly because most C-syntax languages do. As we’ll learn later, Lox’s approach to scoping hews closely to Scheme. The C flavor of Lox we’ll build in Part III is heavily indebted to Lua’s clean, efficient implementation.

- `Dynamic typing` -- Lox is dynamically typed. Variables can store values of any type, and a single variable can even store values of different types at different times.

  There are plenty of reasons to like static types, but they don’t outweigh the pragmatic reasons to pick dynamic types for Lox. A static type system is a ton of work to learn and implement. Skipping it gives you a simpler language and a shorter book.

- `Automatic memory management` -- There are two main techniques for managing memory: reference counting and tracing garbage collection (usually just called “garbage collection” or “GC”). Ref counters are much simpler to implement—I think that’s why Perl, PHP, and Python all started out using them. But, over time, the limitations of ref counting become too troublesome. All of those languages eventually ended up adding a full tracing GC or at least enough of one to clean up object cycles.

### Data Types

- There are only a few primitive data types in Lox:
  - Booleans 
    ```
    true;
    false;
    ```
    
  - Numbers -- Full-featured languages have lots of syntax for numbers—hexadecimal, scientific notation, octal, all sorts of fun stuff. We’ll settle for basic integer and decimal literals:
    ```
    1234;  // An integer.
    12.34; // A decimal number.
    ```
    
  - Strings –
    ```
    "I am a string";
    "";    // The empty string.
    ```
    
  - Nil – There’s one last built-in value who’s never invited to the party but always seems to show up. It represents “no value”. It’s called “null” in many other languages

### Expressions

- `Arithmetic` -- These are how arithmetic expressions happen in lox:
  ```
  add + me;
  subtract - me;
  multiply * me;
  divide / me;
  ```
  One arithmetic operator is actually both an infix and a prefix one. The - operator can also be used to negate a number:
  ```
  -negateMe;
  ```

- `Comparison and equality` -- these will be the comparison operators in lox:
  ```
  less < than;
  lessThan <= orEqual;
  greater > than;
  greaterThan >= orEqual;
  ```
  or:
  ```
  1 == 2;          // false.
  "cat" != "dog";  // true.
  123 == "123";    // false.
  ```

- `Logical operators` -- These wil be the logical operators of the language:
  ```
  !true;  // false.
  !false; // true.
  
  true and false; // false.
  true and true;  // true.
  
  false or false; // false.
  true or false;  // true.
  ```

- `Precedence and grouping` -- All of these operators have the same precedence and associativity that you’d expect coming from C. (When we get to parsing, we’ll get way more precise about that.) In cases where the precedence isn’t what you want, you can use () to group stuff:
  ```
  var average = (min + max) / 2;
  ```

### Variables

- You declare variables using var statements. If you omit the initializer, the variable’s value defaults to nil:
  ```
  var imAVariable = "here is my value";
  var iAmNil;
  ```

### Control Flow

- The control flow will look like this:
  ```
  if (condition) {
    print "yes";
  } else {
    print "no";
  }
  ```

- The `while` loop will look like this:
  ```
  var a = 1;
  while (a < 10) {
    print a;
    a = a + 1;
  }
  ```
  
- Finally, we have for loops:
  ```
  for (var a = 1; a < 10; a = a + 1) {
    print a;
  }
  ```

### Functions

- A function call expression looks the same as it does in C, but the definition of the function looks a bit different:
  ```
  fun printSum(a, b) {
    print a + b;
    return a;
  }
  
  sum(1, 3);
  ```

### Classes

- `Why might any language want to be object oriented?` -- It is true that the “all inheritance all the time” binge of the 90s produced some monstrous class hierarchies, but object-oriented programming is still pretty rad. Billions of lines of successful code have been written in OOP languages, shipping millions of apps to happy users. Likely a majority of working programmers today are using an object-oriented language. They can’t all be that wrong.

- `Why is Lox object oriented?` -- I could claim objects are groovy but still out of scope for the book. Most programming language books, especially ones that try to implement a whole language, leave objects out. To me, that means the topic isn’t well covered. With such a widespread paradigm, that omission makes me sad.

- `Classes or prototypes?` -- When it comes to objects, there are actually two approaches to them, classes and prototypes. Classes came first, and are more common thanks to C++, Java, C#, and friends. Prototypes were a virtually forgotten offshoot until JavaScript accidentally took over the world.

  In a class-based language, there are two core concepts: instances and classes. Instances store the state for each object and have a reference to the instance’s class. Classes contain the methods and inheritance chain.
  
  Prototype-based languages merge these two concepts. There are only objects—no classes—and each individual object may contain state and methods. Objects can directly inherit from each other This means prototypal languages are more fundamental in some way than classes. They are really neat to implement because they’re so simple.
  
   So, for Lox, we’ll save our users the trouble and bake classes right in. Because even the though prototypes are simpler the users use them to implement classes in the long run:) because classes are very natural to human comprehension.

- `Classes in Lox` -- This is how we will define classes:
  ```lox
  class Breakfast {
    init(meat, bread) {
      this.meat = meat;
      this.bread = bread;
    }
  
    cook() {
      print "Eggs a-fryin'!";
    }

    serve(who) {
      print "Enjoy your breakfast, " + this.meat;
    }
  }
  ```
  Next, we need a way to create instances. We could add some sort of new keyword, but to keep things simple, in Lox the class itself is a factory function for instances
  ```
  var breakfast = Breakfast();
  print breakfast; // "Breakfast instance".
  ```

- `Inheritance` --  Lox supports single inheritance. When you declare a class, you can specify a class that it inherits from using `<`:
  ```
  class Brunch < Breakfast {
    drink() {
      print "How about a Bloody Mary?";
    }
  }
  ```
  and as usual you cans use the parent objects methods too:
  ```
  var benedict = Brunch("ham", "English muffin");
  benedict.serve("Noble Reader");
  ```
  Because we don’t implement classes until well after we start working with the built-in types, that would have been hard. So values of primitive types aren’t real objects in the sense of being instances of classes. They don’t have methods or properties. If I were trying to make Lox a real language for real users, I would fix that.

### The Standard Library

- We’re almost done. That’s the whole language, so all that’s left is the “core” or “standard” library—the set of functionality that is implemented directly in the interpreter and that all user-defined behavior is built on top of.

  This is the saddest part of Lox. Its standard library goes beyond minimalism and veers close to outright nihilism. For the sample code in the book, we only need to demonstrate that code is running and doing what it’s supposed to do. For that, we already have the built-in `print` statement. 
  
   we need to track time, so we’ll define one built-in function `clock()` that returns the number of seconds since the application started.
   
   If you wanted to turn Lox into an actual useful language, the very first thing you should do is flesh this out. String manipulation, trigonometric functions, file I/O, networking, heck, even reading input from the user would help


<br>
<br>

---

<br>
<br>


