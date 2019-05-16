# C#

- C# is a simple, modern, general-purpose, object-oriented programming language developed by Microsoft within its .NET initiative led by Anders Hejlsberg.

- Although C# constructs closely follow traditional high-level languages, C and C++ and being an object-oriented programming language. It has strong resemblance with Java, it has numerous strong programming features that make it endearing to a number of programmers worldwide.

<br>
<br>

## Environment 

- In this chapter, we will discuss the tools required for creating C# programming. We have already mentioned that C# is part of .Net framework and is used for writing .Net applications. Therefore, before discussing the available tools for running a C# program, let us understand how C# relates to the .Net framework.

### The .Net Framework

- The .Net framework is a revolutionary platform that helps you to write the following types of applications − `Windows applications`, `Web Applications`, `Web services`

- The .Net framework applications are multi-platform applications. The framework has been designed in such a way that it can be used from any of the following languages: C#, C++, Visual Basic, Jscript, COBOL, etc. All these languages can access the framework as well as communicate with each other.

- Although the.NET Framework runs on the Windows operating system, there are some alternative versions that work on other operating systems. Mono is an open-source version of the .NET Framework which includes a C# compiler and runs on several operating systems, including various flavors of Linux and Mac OS. OR you can just compile your source code by hand in the terminal if you are not lazy

<br>
<br>

## Program Structure

- To compile your c# codes first you need to give `foo.cs` extension to your files and then simply compile with:
  ```
  $ csc foo.cs
  ```
  It will generate a .exe with the name of the file in order to run it simply write the name of the exe:
  ```
  $ foo
  ```
  
- Lets see an example of a hello world program and then we will break it down to its pieces:
  ```cs
  using System;
  
  namespace HelloWorldApplication {
    class HelloWorld {
      static void Main(string[] args) {
        Console.WriteLine("Hello World");
        Console.ReadKey();
      }
    }
  }
  ```
  - The first line of the program using System; - the using keyword is used to include the System namespace in the program. A program generally has multiple using statements. (it is like the `import` in python where you use other libraries
  - The next line has the namespace declaration. A namespace is a collection of classes. The HelloWorldApplication namespace contains the class HelloWorld.
  - The next line has a class declaration, the class HelloWorld contains the data and method definitions that your program uses. Classes generally contain multiple methods. Methods define the behavior of the class. However, the HelloWorld class has only one method Main.
  - The next line defines the Main method, which is the entry point for all C# programs. The Main method states what the class does when executed.
  - WriteLine is a method of the Console class defined in the System namespace. This statement causes the message "Hello, World!" to be displayed on the screen.
  - The last line Console.ReadKey(); is for the VS.NET Users. This makes the program wait for a key press and it prevents the screen from running and closing quickly when the program is launched from Visual Studio .NET
  - Unlike Java, program file name could be different from the class name.

<br>
<br>
<br>


