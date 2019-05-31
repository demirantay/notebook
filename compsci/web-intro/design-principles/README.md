# Design Principles

*THE NOTES ON THIS FILE ARE PRETTY USELESS. I NEEED TO CHANGE AND FIND A BETTER RESOURCE FOR LEARNING DESIGN PRINCPILES FOR OOP*


- The Object-Oriented Design Principles are the core of OOP programming, It’s important to learn the basics of Object-oriented programming like Abstraction, Encapsulation, Polymorphism, and Inheritance. But, at the same time, it’s equally important to know object-oriented design principles.

- They will help you to create a clean and modular design, which would be easy to test, debug, and maintain in the future.

- If you are not able to understand a design principle, you should try to do more than one example because sometimes we connect to another example or author better but you must understand these design principles and learn how to use it in your code.

- Though the best way of learning any design principle or pattern is a real-world example and understanding the consequences of violating that design principle

- Lets list few of the design principles below, however self note for the future: I will need to understand and research more about programming design principles. This file is just for skeeeming

<br>
<br>

## 1) DRY (Don't Repeat Yourself)

- Our first object-oriented design principle is DRY, as the name suggests DRY (don’t repeat yourself) means don’t write duplicate code, instead use Abstraction to abstract common things in one place.

- If you have a block of code in more than two places consider making it a separate method, or if you use a hard-coded value more than one time make them public final constant. The benefit of this Object oriented design principle is in maintenance.

- It’s important not to abuse it, duplication is not for code, but for functionality. So beware of such coupling and just don’t combine anything which uses the similar code but are not related. 

<br>
<br>

## 2) Encapsulate What Changes

- There is only one thing which is constant in the software field and that is “Change”, So, encapsulate the code you expect or suspect to be changed in future. The benefit of this OOP Design principle is that It’s easy to test and maintain proper encapsulated code.
 
- the Factory design pattern is one example of Encapsulation which encapsulates object creation code and provides flexibility to introduce a new product later with no impact on existing code.

<br>
<br>

## 3) Open Closed Design Principle

- According to tho this OOP design principle, “Classes, methods or functions should be Open for extension (new functionality) and Closed for modification”.

- This is another beautiful SOLID design principle, coined by Uncle Bob on his classic Clean Code book, which prevents someone from changing already tried and tested code.

- The key benefit of this design principle is that already tried and tested code is not touched which means they won’t break. By the way, the Open-Closed principle is “O” from the SOLID acronym.

<br>
<br>

## 4) Single Responsibility Principle (SRP)

- Single Responsibility Principle is another SOLID design principle, and represent “S” on the SOLID acronym. As per SRP, there should not be more than one reason for a class to change, or a class should always handle single functionality.

- The key benefit of this principle is that it reduces coupling between the individual component of the software and Code.

<br>
<br>

....
