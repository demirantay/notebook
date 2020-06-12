# Recursion

- In this chapter You learn about recursion. Recursion is a coding technique used in many algorithms. It’s a building block for understanding later chapters in this book.
  
  You learn how to break a problem down into a base case and a recursive case. The divide-and- conquer strategy (chapter 4) uses this simple concept to solve hard problems.
  
### Recursion

- Suppose you’re digging through your grandma’s attic and come across a mysterious locked suitcase. Grandma tells you that the key for the suitcase is probably in this other box.

  This box contains more boxes, with more boxes inside those boxes. he key is in a box somewhere. What’s your algorithm to search for the key? hink of an algorithm before you read on. Here’s one approach.
  
  - 1 - Make a pile of boxes to look through.
  - 2 - Grab a box and look through 
  - 3 - If you find a box,add it to the pile to look through later.
  - 4 - If you ind a key, you’re done!
  - 5 - Repeat.
  
  Here’s an alternate approach.
  
  - 1 - Look through the box.
  - 2 - If you find a box,go to step 1.
  - 3 - If you ind a key, you’re done!
  
  Which approach seems easier to you? he irst approach uses a `while`
loop. While the pile isn’t empty, grab a box and look through it:

  The second way uses recursion. Recursion is where a function calls itself.
  
  Both approaches accomplish the same thing, but the second approach is clearer to me. Recursion is used when it makes the solution clearer. here’s no performance beneit to using recursion; in fact, loops are sometimes better for performance. “Loops may achieve a performance gain for your program. Recursion may achieve a performance gain for your programmer. Choose which is more important in your situation!”
  
### Base Case and Recursive Case

- When you write a recursive function, you have to tell it when to stop recursing. hat’s why every recursive function has two parts: the base case, and the recursive case. he recursive case is when the function calls itself. he base case is when the function doesn’t call itself again ... so it doesn’t go into an ininite loop.

  Let’s add a base case to the countdown function:
  ```python
  def countdown(i): print i
    if i <= 0: # Base case 
      return
    else:      # Recursive case 
      countdown(i-1)
  ```
  
### The Stack

- call stack. It’s an important concept in programming. he call stack is an important concept in general programming, and it’s also important to understand when using recursion.

  This is the big idea behind this section: when you call a function from another function, the calling function is paused in a partially completed state. All the values of the variables for that function are still stored in memory. Now that you’re done with the greet2 function, you’re back to the greet function, and you pick up where you let of.

- `Recap`:
  - Recursion is when a function calls itself.
  - Every recursive function has two cases: the base case and the recursive case.
  - A stack has two operations: push and pop.
  - All function calls go onto the call stack.
  - The call stack can get very large, which takes up a lot of memory.
  
  <br>
  <br>
  
  ---
  
  <br>
  <br>
  
  # Quicksort
  
  - You learned all about recursion in the last chapter. his chapter focuses on using your new skill to solve problems. We’ll explore divide and conquer (D&C), a well-known recursive technique for solving problems. D&C gives you a new way to think about solving problems. D&C is another tool in your toolbox. When you get a new problem, you don’t have to be stumped. Instead, you can ask, “Can I solve this if I use divide and conquer?”

  At the end of the chapter, you’ll learn your irst major D&C algorithm: quicksort. Quicksort is a sorting algorithm, and a much faster one than selection sort 
  
  D&C algorithms are recursive algorithms. To solve a problem using D&C, there are two steps:
    - 1 - Figure out the base case. his should be the simplest possible case.
    - 2 - Divide or decrease your problem until it becomes the base case.
    
 
  To recap, here’s how D&C works:
    - 1 - Figure out a simple case as the base case.
    - 2 - Figure out how to reduce your problem and get to the base case.
    
  ### Quicksort
  
  - Quicksort is a sorting algorithm. It’s much faster than selection sort and is frequently used in real life. For example, the C standard library has a function called qsort, which is its implementation of quicksort. Quicksort also uses D&C.
  
    Remember, you’re using D&C. So you want to break down this array until you’re at the base case. Here’s how quicksort works. First, pick an element from the array. his element is called the pivot.
    
    We’ll talk about how to pick a good pivot later. For now, let’s say the irst item in the array is the pivot. Now ind the elements smaller than the pivot and the elements larger than the pivot. his is called partitioning. Now you have
    - A sub-array of all the numbers less than the pivot
    - The pivot
    - A sub-array of all the numbers greater than the pivot
    
   The two sub-arrays aren’t sorted. hey’re just partitioned. But if they
were sorted, then sorting the whole array would be pretty easy.

  If the sub-arrays are sorted, then you can combine the whole thing like this—left array + pivot + right array—and you get a sorted array.
  
### Big O Notation revisited

- Quicksort is unique because its speed depends on the pivot you choose. Check out selection sort, which you learned in chapter 2. It’s O(n2). hat’s a pretty slow algorithm.
  
  There’s another sorting algorithm called merge sort, which is
O(n log n). Much faster! Quicksort is a tricky case. In the worst case, quicksort takes O(n2) time. It’s as slow as selection sort! But that’s the worst case. In the average case, quicksort takes O(n log n) time. 
  - What do worst case and average case mean here?
  - If quicksort is O(n log n) on average, but merge sort is O(n log n) always, why not use merge sort? Isn’t it faster?

- `merge sort vs quick sort` -- You usually ignore that constant, because if two algorithms have diferent Big O times, the constant doesn’t matter. Take binary search and simple search, for example. Suppose both algorithms had these constants.

  You might say, “Wow! Simple search has a constant of 10 milliseconds, but binary search has a constant of 1 second. Simple search is way faster!” Now suppose you’re searching a list of 4 billion elements. Here are the times.
  
  As you can see, binary search is still way faster. hat constant didn’t make a diference at all. But sometimes the constant can make a diference. Quicksort versus merge sort is one example. Quicksort has a smaller constant than merge sort. So if they’re both O(n log n) time, quicksort is faster. And quicksort is faster in practice because it hits the average case way more oten than the worst case.
  
- `average case vs. worst case` -- The performance of quicksort heavily depends on the pivot you choose.
Suppose you always choose the first element as the pivot.  In the worst case, the stack size is
O(n). In the best case, the stack size is O(log n).  Quicksort
is one of the fastest sorting algorithms out there, and it’s a very good
example of D&C.

- `recap` --
  - • D&C works by breaking a problem down into smaller and smaller
pieces. If you’re using D&C on a list, the base case is probably an
empty array or an array with one element.
  - If you’re implementing quicksort, choose a random element as the
pivot. The average runtime of quicksort is O(n log n)!
  - The constant in Big O notation can matter sometimes. That’s why
quicksort is faster than merge sort.
  - The constant almost never matters for simple search versus binary
search, because O(log n) is so much faster than O(n) when your list
gets big

<Br>
<br>
  
---

<br>
<br>

# Hash Tables

### Hash Functions

### Use Cases

- `Using Hash tables for lookups` --

- `Preventing duplicate entries` --

- `Using hash tables as a cache` --

### Collisons

### Performance

- `Recap` --

<br>
<Br>
  
---

<br>
<Br>
  
# Breadth-first Search

### Introuction to graphs

### What is a graph?

### Breadth first search

- `finding the shortest path` --

- `queues` --

### Implementing the graph

### Implementing the algorithm

- `running time` --

- `Recap` 

<Br>
<br>
  
---

<br>
<Br>
  
# Dijktra's Algorithm

### Working with Dijkstra's algorithm

### Terminology

### Trading for a piano

### Negative-weight edges

### Implementation

### Recap

<br>
<br>

---

<Br>
<br>
  
# Greedy Algorithms

### The classroom scheduling problem

### The knapsack problem

### The set-covering problem

- `approximation algorithms` --

### NP-complete problems

### Travelling salesperson, step by step

- `how do you tell if a problem is NP-complete` 

- `recap` --

<br>
<br>

---

<Br>
<Br>
  
# Dynamic Programming

### THe knapscak problem

- `the simple solution` --

- `dynamic programming` --

### Knapsack problem FAQ

- `what happens if you add an item` --

- `what happens if you change the order of the rows` --

- `can you fill in the frid colum wise instead of row-wise` --

- `what happens if you add a smaller item` -- 

- `can you steal fractions of an item?` --

- `optimizing your travel itinerary` --

- `Handling items that depend on each other` --

- `is it possible that the solution will require more than two sub-knapsacks` --

- `Is it possible that the best solution doesnt fill the knapscak completly` --

### Longest common substring

<br>
<br>

---

<br>
<Br>
  
# K-nearest neighbors

### Classifying orange vs grapefruit

### Building a recommendations system

- `feature extraction` --

- `regression` --

- `picking good features` --

### Introduction to machine learning

- `ocr` --

- `building a spam filter` --

- `predicting the stock market` --

- `Recap` --

<br>
<br>

---

<Br>
<br>
  
# Where to go next

### Trees

### Inverted indexes

### The fourier transforms

### Parallel algorithms

### MapReduce

### Bloom filters and HyperLogLog

### The SHA Algorithms

### Locality-sensetive hashing

### Diffie-Hellman key exchange

### Linear Programming 

### Epilogue
