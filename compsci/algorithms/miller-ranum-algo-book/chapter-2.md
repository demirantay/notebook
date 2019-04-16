# Analysis

- In this chapter, we will understand: algorithm analysis's importance, big-O notation, importance of implementations impact on analysis ... etc. 

### What is Algorithm Analysis

- Algorithm analysis is concerned with comparing algorithms based upon the amount of computing resources that each algorithm uses. We want to be able to consider two algorithms and say that one is better than the other because it is more efficient in its use of those resources or perhaps because it simply uses fewer.

- At this point, it is important to think more about what we really mean by computing resources. There are two different ways to look at this. One way is to consider the amount of space or memory an algorithm requires to solve the problem. The amount of space required by a problem solution is typically dictated by the problem instance itself. 

- As an alternative to space requirements, we can analyze and compare algorithms based on the amount of time they require to execute. This measure is sometimes referred to as the “execution time” or “running time” of the algorithm. One way we can measure the execution time for the function `foo` is to do a benchmark analysis. This means that we will track the actual time required for the program to compute its result. In Python, we can benchmark a function by noting the starting time and ending time with respect to the system we are using. In the `time` module there is a function called `time` that will return the current system clock time in seconds since some arbitrary starting point. By calling this function twice, at the beginning and at the end, and then computing the difference, we can get an exact number of seconds (fractions in most cases) for execution. View to code below:
  ```python
  import time   # definetly check the docs for this module
  
  def foo(num1, num2):
      start = time.time()  # <-- Starts the timer
      
      sum = num1 + num2
      
      end = time.time()
      
      return sum, end-start
  ```
  We need a better way to characterize these algorithms with respect to execution time. The benchmark technique computes the actual time to execute. It does not really provide us with a useful measurement, because it is dependent on a particular machine, program, time of day, compiler, and programming language. Instead, we would like to have a characterization that is independent of the program or computer being used. This measure would then be useful for judging the algorithm alone and could be used to compare algorithms across implementations.
  
### Big-O Notation

- When trying to characterize an algorithm’s efficiency in terms of execution time, independent of any particular program or computer, it is important to quantify the number of operations or steps that the algorithm will require. If each of these steps is considered to be a basic unit of computation, then the execution time for an algorithm can be expressed as the number of steps required to solve the problem. Deciding on an appropriate basic unit of computation can be a complicated problem and will depend on how the algorithm is implemented.

- In the summation functions given above, it makes sense to use the number of terms in the summation to denote the size of the problem. We can then say that the sum of the first 100,000 integers is a bigger instance of the summation problem than the sum of the first 1,000. Because of this, it might seem reasonable that the time required to solve the larger case would be greater than for the smaller case. Our goal then is to show how the algorithm’s execution time changes with respect to the size of the problem.

- Computer scientists prefer to take this analysis technique one step further. It turns out that the exact number of operations is not as important as determining the most dominant part of the T(n) function. In other words, as the problem gets larger, some portion of the T(n) function tends to overpower the rest. This dominant term is what, in the end, is used for comparison. The `order of magnitude` function describes the part of T(n) that increases the fastest as the value of n increases. Order of magnitude is often called `Big-O notation` (for “order”) and written as O(f(n))
  
- In the above example, T(n)=1+n. As n gets large, the constant 1 will become less and less significant to the final result. If we are looking for an approximation for T(n), then we can drop the 1 and simply say that the running time is O(n). It is important to note that the 1 is certainly significant for T(n). However, as n gets large, our approximation will be just as accurate without it.

- sometimes the performance of an algorithm depends on the exact values of the data rather than simply the size of the problem. For these kinds of algorithms we need to characterize their performance in terms of best case, worst case, or average case performance. The worst case performance refers to a particular data set where the algorithm performs especially poorly. Whereas a different data set for the exact same algorithm might have extraordinarily good performance. However, in most cases the algorithm performs somewhere in between these two extremes (average case). It is important for a computer scientist to understand these distinctions so they are not misled by one particular case.

### Performance of Python Data Structures

- Now that you have a general idea of Big-O notation and the differences between the different functions, our goal in this section is to tell you about the Big-O performance for the operations on Python lists and dictionaries. We will then show you some timing experiments that illustrate the costs and benefits of using certain operations on each data structure. It is important for you to understand the efficiency of these Python data structures because they are the building blocks we will use as we implement other data structures in the remainder of the book.

### Lists (Arrays)

- The designers of Python had many choices to make when they implemented the list data structure. Each of these choices could have an impact on how fast list operations perform. To help them make the right choices they looked at the ways that people would most commonly use the list data structure and they optimized their implementation of a list so that the most common operations were very fast.

- Two common operations are indexing and assigning to an index position. Both of these operations take the same amount of time no matter how large the list becomes. When an operation like this is independent of the size of the list they are O(1). Another very common programming task is to grow a list. There are two ways to create a longer list. You can use the append method or the concatenation operator. The append method is O(1).

### Dictionaries 

- The second major Python data structure is the dictionary. As you probably recall, dictionaries differ from lists in that you can access items in a dictionary by a key rather than a position. he thing that is most important to notice right now is that the get item and set item operations on a dictionary are O(1). Another important dictionary operation is the contains operation. Checking to see whether a key is in the dictionary or not is also O(1). Dictonaries are very time efficent compared to the lists.

### Summary

- This is the summary of this chapter:
  - Algorithm analysis is an implementation-independent way of measuring an algorithm.
  - Big-O notation allows algorithms to be classified by their dominant process with respect to the size of the problem.


<hr>

[Chapter 3](./chapter-3.md)
