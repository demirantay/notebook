[Part 3](./README3.md)

---

<br>

# Data Structures 

- As we discussed erlier, Data Structure is a way of collecting and organising data in such a way that we can perform operations on these data in an effective way. Data Structures is about rendering data elements in terms of some relationship, for better organization and storage.

  Since we discuess what data structures are in the perivous section lets study different and most common data structures:
  
<br>
<br>

---

<br>
<br>

# Stack Data Structure 

- `Stack` is an abstract data type with a bounded(predefined) capacity. It is a simple data structure that allows adding and removing elements in a particular order. Every time an element is added, it goes on the top of the stack and the only element that can be removed is the element that is at the top of the stack, just like a pile of objects.

### Basic Features of Stack

- Basic Features:
  - Stack is an **ordered list** of similar data type.
  - Stack is a **LIFO(Last in First out)** structure or we can say **FILO(First in Last out)**.
  - `push()` function is used to insert new elements into the Stack and `pop()` function is used to remove an element from the stack. Both insertion and removal are allowed at only one end of Stack called Top
  - Stack is said to be in "Overflow" state when it is completely full and is said to be in "Underflow" state if it is completely empty.

### Applications of Stack

- The simplest application of a stack is to reverse a word. You push a given word to stack - letter by letter - and then pop letters from the stack.
  
  There are other uses also like:
  - Parsing
  - Expression Conversion(Infix to Postfix, Postfix to Prefix etc)
  - Clicking on back/front buttons on a browser
  - etc ...
  
### Implementation of Stack Data Structure

- Stack can be easily implemented using an Array or a Linked List. Arrays are quick, but are limited in size and Linked List requires overhead to allocate, link, unlink, and deallocate, but is not limited in size. Here we will implement Stack using a list.

### Algorithm for PUSH operation

- algoritmh:
  - Check if the stack is full or not.
  - If the stack is full, then print error of overflow and exit the program.
  - If the stack is not full, then increment the top and add the element.

### Algorithm for POP operation

- algorithm:
  - Check if the stack is empty or not.
  - If the stack is empty, then print error of underflow and exit the program.
  - If the stack is not empty, then print the element at the top and decrement the top.

### Implementation 

- Lets implement Stack using python (since we use lists there is no need to check if stack is full or not):
  ```python
  class Stack:
  
    def __init__(self):
      self.arr = []
      
    def isEmpty(self):
      if (self.arr == []):
        return True
      else:
        return False
      
    def push(self, item):
      self.arr.append(item)
    
    def pop(self):
      self.arr.pop()
  ```

<br>
<br>

---

<br>
<br>

# Queue Data Structure 

- `Queue` is also an abstract data type or a linear data structure, just like stack data structure, in which the first element is inserted from one end called the `REAR`(also called tail), and the removal of existing element takes place from the other end called as `FRONT`(also called head).

- This makes queue as `FIFO`(First in First Out) data structure, which means that element inserted first will be removed first. 
  
  Which is exactly how queue system works in real world. If you go to a ticket counter to buy movie tickets, and are first in the queue, then you will be the first one to get the tickets. Right? Same is the case with Queue data structure. Data inserted first, will leave the queue first.
  
  The process to add an element into queue is called `Enqueue` and the process of removal of an element from queue is called `Dequeue`.

### Basic Features of Queue

- Basic Features:
  - Like stack, queue is also an ordered list of elements of similar data types.
  - Queue is a FIFO( First in First Out ) structure.
  - Once a new element is inserted into the Queue, all the elements inserted before the new element in the queue must be removed, to remove the new element.
  - `peek( )` function is oftenly used to return the value of first element without dequeuing it.

### Applicaitons of Queue

- Queue, as the name suggests is used whenever we need to manage any group of objects in an order in which the first one coming in, also gets out first while the others wait for their turn, like in the following scenarios:
  - Serving requests on a single shared resource, like a printer, CPU task scheduling etc.
  - In real life scenario, Call Center phone systems uses Queues to hold people calling them in an order, until a service representative is free.
  - ... etc.
  
### Algorithm for ENQUEUE

- Algorithm:
  - Check if the queue is full or not. 
  - If the queue is full, then print overflow error and exit the program.
  - If the queue is not full, then increment the tail and add the element.

### Algorithm for DEQUEUE

- Algorithm:
  - Check if the queue is empty or not.
  - If the queue is empty, then print underflow error and exit the program.
  - If the queue is not empty, then print the element at the head and increment the head.

### Implementation of Queue 

- Queue can be implemented using an Array, Stack or Linked List. The easiest way of implementing a queue is by using an Array. But we will use lists since they are so easy to use in python + we will not limit the lists size.
  ```python
  class Queue:
  
    def __init__(self):
      self.arr = []
      
    def enqueue(self, item):
      self.arr.append(item)
      
    def dequeue(self):
      self.arr.pop(0)
    
  ```

<br>
<br>

---

<br>
<br>

# Linked List

- Linked List is a very commonly used linear data structure which consists of group of `nodes` in a sequence. Each node holds its own `data` and the `address of the next node` hence forming a chain like structure. Linked Lists are used to create trees and graphs.

### Advantages of Linked Lists

- Advantages:
  - They are a dynamic in nature which allocates the memory when required.
  - Insertion and deletion operations can be easily implemented.
  - Stacks and queues can be easily executed.
  - Linked List reduces the access time.
  
### Disadvantages of Linked Lists 

- Disadvantages:
  - The memory is wasted as pointers require extra memory for storage.
  - No element can be accessed randomly; it has to access each node sequentially.
  - Reverse Traversing is difficult in linked list.
  
### Applications of Linked Lists

- Applications:
  - Linked lists are used to implement stacks, queues, graphs, etc.
  - Linked lists let you insert elements at the beginning and end of the list.
  - In Linked Lists we don't need to know the size in advance

### Types of Linked Lists 

- There are 3 different implementations of Linked List available, they are:
  - Singly Linked List
  - Doubly Linked List
  - Circular Linked List

- `Singly Linked List` - Singly linked lists contain nodes which have a data part as well as an address part i.e. `next`, which points to the next node in the sequence of nodes. The operations we can perform on singly linked lists are insertion, deletion and traversal

- `Doubly Linked List` - In a doubly linked list, each node contains a data part and two addresses, one for the previous node and one for the next node.

- `Circular Linked List` - In circular linked list the last node of the list holds the address of the first node hence forming a circular chain.

<br>
<br>

---

<br>
<br>

# Linked List vs Array 

- - Both Linked List and Array are used to store linear data of similar type, but an array consumes contiguous memory locations allocated at compile time, i.e. at the time of declaration of array, while for a linked list, memory is assigned as and when data is added to it, which means at runtime.

  This is the basic and the most important difference between a linked list and an array
  
- `Array` is a datatype which is widely implemented as a default type, in almost all the modern programming languages, and is used to store data of similar type.

  But there are many usecases, like the one where we don't know the quantity of data to be stored, for which advanced data structures are required, and one such data structure is `linked list`.
  
- There are too many things to compare on the website, if you want to read it again from here:
  - https://www.studytonight.com/data-structures/linked-list-vs-array

<br>
<br>

---

<br>
<br>

# Linear Linked List 

- Linear Linked list is the default linked list and a linear data structure in which data is not stored in contiguous memory locations but each data node is connected to the next data node via a pointer, hence forming a chain.

- The element in such a linked list can be inserted in 2 ways:
  - Insertion at beginning of the list.
  - Insertion at the end of the list.
  
- We will also be adding some other useful methods like to a linked list class:
  - Checking whether Linked List is empty or not.
  - Searching any data element in the Linked List
  - Deleting a particular Node(data element) from the List
  
  Before learning how we insert data and create a linked list, we must understand the components forming a linked list, and the main component is the `Node`.

### What is a Node 

- A Node in a linked list holds the data value and the pointer which points to the location of the next node in the linked list.

  You must be wondering why we need to store the location of the next node. Well, because the memory locations allocated to these nodes are not contiguous hence each node should know where the next node is stored.
  
- Lets build it using python:
  ```python
  class Node:
  
    def __init__(self, data, next_node):
      self.data = data
      self.next = next_node
      
    def get_data(self):
      return self.data
      
    def get_next(self):
      return self.next
      
    def set_next(self, new_next):
      self.next = new_next
  ```

### Linked List Class Implementation

- Now that we have a `Node` class lets use it in order to create a linked list:
  ```python
  class LinkedList:
    
    def __init__(self, head=None):
      self.head = head
      
    def insert(self, data):
      new_node = Node(data)
      new_node.set_next(self.head)
      self.head = new_node
      
    def search(...)
    
    def size(...)
    
    def delete(...)
  ```

<br>
<br>

---

<br>
<br>

# Circular & Doubly Linked List 

- Since I know the basics of a linked list and node classes noting these too would take too much time, plus I will code them inisde my algorithm implementation repo so no need to re-write it again. 

<br>
<br>

---

<br>
<br>

# Introduction to Binary Tree 









