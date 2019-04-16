# Basic Data Structures

- In this chapter of this book we will try to: To understand the abstract data types stack, queue, deque, and list, understand the performance of the implementations of basic linear data structures, understand prefix, infix, and postfix expression formats, able to recognize problem properties where stacks, queues, and deques are appropriate data structures, able to implement the abstract data type list as a linked list using the node and reference pattern.

### What are Linear Structures

- We will begin our study of data structures by considering four simple but very powerful concepts. Stacks, queues, deques, and lists are examples of data collections whose items are ordered depending on how they are added or removed. Once an item is added, it stays in that position relative to the other elements that came before and came after it. Collections such as these are often referred to as linear data structures.

- What distinguishes one linear structure from another is the way in which items are added and removed, in particular the location where these additions and removals occur. For example, a structure might allow new items to be added at only one end. Some structures might allow items to be removed from either end. These variations give rise to some of the most useful data structures in computer science. They appear in many algorithms and can be used to solve a variety of important problems.

### What is a Stack

- A stack (sometimes called a “push-down stack”) is an ordered collection of items where the addition of new items and the removal of existing items always takes place at the same end. This end is commonly referred to as the “top.” The end opposite the top is known as the “base.”

- The base of the stack is significant since items stored in the stack that are closer to the base represent those that have been in the stack the longest. The most recently added item is the one that is in position to be removed first. This ordering principle is sometimes called LIFO, last-in first-out. It provides an ordering based on length of time in the collection. Newer items are near the top, while older items are near the base.

- One of the most useful ideas related to stacks comes from the simple observation of items as they are added and then removed. Assume you start out with a clean desktop. Now place books one at a time on top of each other. You are constructing a stack. Consider what happens when you begin removing books. The order that they are removed is exactly the reverse of the order that they were placed. Stacks are fundamentally important, as they can be used to reverse the order of items. The order of insertion is the reverse of the order of removal.

### The Stack Abstract Data Type

- The stack abstract data type is defined by the following structure and operations. A stack is structured, as described above, as an ordered collection of items where items are added to and removed from the end called the “top.” Stacks are ordered LIFO. The stack operations are given below.:
  - `Stack()` -- creates a new stack that is empty. It needs no parameters and returns an empty stack.
  - `push(item)` -- adds a new item to the top of the stack. It needs the item and returns nothing.
  - `pop()` -- removes the top item from the stack. It needs no parameters and returns the item. The stack is modified.
  - `peek()` -- returns the top item from the stack but does not remove it. It needs no parameters. The stack is not modified.
  - `isEmpty()` -- tests to see whether the stack is empty. It needs no parameters and returns a boolean value.
  - `size()` -- returns the number of items on the stack. It needs no parameters and returns an integer.

### Implementing a Stack in Python

- Now that we have clearly defined the stack as an abstract data type we will turn our attention to using Python to implement the stack. Recall that when we give an abstract data type a physical implementation we refer to the implementation as a data structure.










<hr>

[Chapter 4](./chapter-4.md)
