# Basic Data Structures

- In this chapter of this book we will try to: To understand the abstract data types stack, queue, deque, and list, understand the performance of the implementations of basic linear data structures, understand prefix, infix, and postfix expression formats, able to recognize problem properties where stacks, queues, and deques are appropriate data structures, able to implement the abstract data type list as a linked list using the node and reference pattern.

### What are Linear Structures

- We will begin our study of data structures by considering four simple but very powerful concepts. Stacks, queues, deques, and lists are examples of data collections whose items are ordered depending on how they are added or removed. Once an item is added, it stays in that position relative to the other elements that came before and came after it. Collections such as these are often referred to as linear data structures.

- What distinguishes one linear structure from another is the way in which items are added and removed, in particular the location where these additions and removals occur. For example, a structure might allow new items to be added at only one end. Some structures might allow items to be removed from either end. These variations give rise to some of the most useful data structures in computer science. They appear in many algorithms and can be used to solve a variety of important problems.

## What is a Stack

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

- As we described in Chapter 1, in Python, as in any object-oriented programming language, the implementation of choice for an abstract data type such as a stack is the creation of a new class. The stack operations are implemented as methods. Further, to implement a stack, which is a collection of elements, it makes sense to utilize the power and simplicity of the primitive collections provided by Python. We will use a list.

- Lets try to create a stack data structure see the code below:
  ```python
  class Stack:
      
      def __init__(self):
          self.items = []
          
      def isEmpty(self):
          if self.items == []
              return True
          else:
              return False
      
      def push(self, item):
          self.items.append(item)
          
      def pop(self):
          return self.items.pop()
          
      def peek(self):
          return(self.items[len(self.items) - 1])
          
      def size(self):
          return len(self.items)
  ```

### Infix, Prefix and Posfix Expressions

- I skipped this part on the book because I really did not understand a bit of it

## What is a Queue

- A queue is an ordered collection of items where the addition of new items happens at one end, called the “rear,” and the removal of existing items occurs at the other end, commonly called the “front.” As an element enters the queue it starts at the rear and makes its way toward the front, waiting until that time when it is the next element to be removed.

- The most recently added item in the queue must wait at the end of the collection. The item that has been in the collection the longest is at the front. This ordering principle is sometimes called FIFO, first-in first-out. It is also known as “first-come first-served.”

- The simplest example of a queue is the typical line that we all participate in from time to time. We wait in a line for a movie, we wait in the check-out line at a grocery store, and we wait in the cafeteria line (so that we can pop the tray stack). Well-behaved lines, or queues, are very restrictive in that they have only one way in and only one way out. There is no jumping in the middle and no leaving before you have waited the necessary amount of time to get to the front

- Operating systems use a number of different queues to control processes within a computer. The scheduling of what gets done next is typically based on a queuing algorithm that tries to execute programs as quickly as possible and serve as many users as it can

### The Queue Abstract Data Type

- The queue abstract data type is defined by the following structure and operations. A queue is structured, as described above, as an ordered collection of items which are added at one end, called the “rear,” and removed from the other end, called the “front.” Queues maintain a FIFO ordering property. The queue operations are given below:  
  - `Queue()` -- creates a new queue that is empty. It needs no parameters and returns an empty queue.
  - `enqueue(item)` -- adds a new item to the rear of the queue. It needs the item and returns nothing.
  - `dequeue()` -- removes the front item from the queue. It needs no parameters and returns the item. The queue is modified.
  - `isEmpty()` -- tests to see whether the queue is empty. It needs no parameters and returns a boolean value.
  - `size()` -- returns the number of items in the queue. It needs no parameters and returns an integer.

### Implementing Queue in Python

- It is again appropriate to create a new class for the implementation of the abstract data type queue. As before, we will use the power and simplicity of the list collection to build the internal representation of the queue.

- We need to decide which end of the list to use as the rear and which to use as the front. The implementation shown in below assumes that the rear is at the end of the list. and front is at the front
  ```python
  class Queue:
      
      def __init__(self):
          self.items = []
          
      def isEmpty(self):
          if self.items == []:
              return True
          else:
              return False
              
      def enqueue(self, item):
          self.items.append(item)
          
      def dequeue(self):
          self.items.pop(0)
          
      def size(self):
          return len(self.items)
  ````

## What is a Deque

- A deque, also known as a double-ended queue, is an ordered collection of items similar to the queue. It has two ends, a front and a rear, and the items remain positioned in the collection. What makes a deque different is the unrestrictive nature of adding and removing items. New items can be added at either the front or the rear. Likewise, existing items can be removed from either end. In a sense, this hybrid linear structure provides all the capabilities of stacks and queues in a single data structure.

- It is important to note that even though the deque can assume many of the characteristics of stacks and queues, it does not require the LIFO and FIFO orderings that are enforced by those data structures. It is up to you to make consistent use of the addition and removal operations.

### The Deque Abstract Data Type

- The deque abstract data type is defined by the following structure and operations. A deque is structured, as described above, as an ordered collection of items where items are added and removed from either end, either front or rear. The deque operations are given below:
  - `Deque()` creates a new deque that is empty. It needs no parameters and returns an empty deque.
  - `addFront(item)` adds a new item to the front of the deque. It needs the item and returns nothing.
  - `addRear(item)` adds a new item to the rear of the deque. It needs the item and returns nothing.
  - `removeFront()` removes the front item from the deque. It needs no parameters and returns the item. The deque is modified.
  - `removeRear()` removes the rear item from the deque. It needs no parameters and returns the item. The deque is modified.
  - `isEmpty()` tests to see whether the deque is empty. It needs no parameters and returns a boolean value.
  - `size()` returns the number of items in the deque. It needs no parameters and returns an integer.

  

<hr>

[Chapter 4](./chapter-4.md)
