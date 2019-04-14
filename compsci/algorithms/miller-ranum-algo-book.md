# Problem Solving with Algorithms and Data Structures using Python

My notes on the digital book written by Brad Miller and David Rantum, Luther College

<br/>

# Introduction

- This chapter emphasizes two important areas for the rest of the text. First, it reviews the framework within which computer science and the study of algorithms and data structures must fit, in particular, the reasons why we need to study these topics and how understanding these topics helps us to become better problem solvers

### What is Computer Science

- Computer science is often difficult to define. This is probably due to the unfortunate use of the word “computer” in the name. As you are perhaps aware, computer science is not simply the study of computer. Computer science is the study of problems, problem-solving, and the solutions that come out of the problem-solving process. Given a problem, a computer scientist’s goal is to develop an algorithm, a step-by-step list of instructions for solving any instance of the problem that might arise. Algorithms are finite processes that if followed will solve the problem. Algorithms are solutions.

### What is Programming

- Programming is the process of taking an algorithm and encoding it into a notation, a programming language, so that it can be executed by a computer. Although many programming languages and many different types of computers exist, the important first step is the need to have the solution. Without an algorithm there can be no program.

- Computer science is not the study of programming. Programming, however, is an important part of what a computer scientist does. Programming is often the way that we create a representation for our solutions. 

- All data items in the computer are represented as strings of binary digits. In order to give these strings meaning, we need to have data types. Data types provide an interpretation for this binary data so that we can think about the data in terms that make sense with respect to the problem being solved. These low-level, built-in data types (sometimes called the primitive data types) provide the building blocks for algorithm development.

### Why Study Data Structures and Abstract Data Types

- To manage the complexity of problems and the problem-solving process, computer scientists use abstractions to allow them to focus on the “big picture” without getting lost in the details. By creating models of the problem domain, we are able to utilize a better and more efficient problem-solving process. 

- An abstract data type, sometimes abbreviated ADT, is a logical description of how we view the data and the operations that are allowed without regard to how they will be implemented. This means that we are concerned only with what the data is representing and not with how it will eventually be constructed.

- The implementation of an abstract data type, often referred to as a `data structure`, will require that we provide a physical view of the data using some collection of programming constructs and primitive data types. As we discussed earlier, the separation of these two perspectives will allow us to define the complex data models for our problems without giving any indication as to the details of how the model will actually be built. This provides an `implementation-independent` view of the data. Since there will usually be many different ways to implement an abstract data type, this implementation independence allows the programmer to switch the details of the implementation without changing the way the user of the data interacts with it. The user can remain focused on the problem-solving process.

### Why Study Algorithms

- Computer scientists learn by experience. We learn by seeing others solve problems and by solving problems by ourselves. Being exposed to different problem-solving techniques and seeing how different algorithms are designed helps us to take on the next challenging problem that we are given. By considering a number of different algorithms, we can begin to develop pattern recognition so that the next time a similar problem arises, we are better able to solve it.

- As computer scientists, in addition to our ability to solve problems, we will also need to know and understand solution evaluation techniques. In the end, there are often many ways to solve a problem. Finding a solution and then deciding whether it is a good one are tasks that we will do over and over again.

### Getting Starte With Data

- We stated above that Python supports the object-oriented programming paradigm. This means that Python considers data to be the focal point of the problem-solving process. In Python, as well as in any other object-oriented programming language, we define a `class` to be a description of what the data look like (the state) and what the data can do (the behavior). Data items are called `objects` in the object-oriented paradigm. An object is an instance of a class. You can read more about python on the "programming" folder of this repository.

### Summary

- This is the summary of the first chapter: Introduction:
  - Computer science is the study of problem solving.
  - Computer science uses abstraction as a tool for representing both processes and data.
  - Abstract data types allow programmers to manage the complexity of a problem domain by hiding the details of the data.
  - Lists, tuples, and strings are built in Python sequential collections.
  - Dictionaries and sets are nonsequential collections of data.
  - Classes allow programmers to implement abstract data types.

<br/>
<br/>
<br/>
<br/>
<br/>

# Analysis

- In this chapter, we will understand: algorithm analysis's importance, big-O notation, importance of implementations impact on analysis ... etc. 

### What is Algorithm Analysis


