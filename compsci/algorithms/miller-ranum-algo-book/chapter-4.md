# Recursion

- In this chapter the goals are to: understand that complex problems that may otherwise be difficult to solve may have a simple recursive solution, learn how to formulate programs recursively, understand and apply the three laws of recursion,  understand recursion as a form of iteration, implement the recursive formulation of a problem, understand how recursion is implemented by a computer system.

### What is Recursion

- Recursion is a method of solving problems that involves breaking a problem down into smaller and smaller subproblems until you get to a small enough problem that it can be solved trivially. Usually recursion involves a function calling itself. While it may not seem like much on the surface, recursion allows us to write elegant solutions to problems that may otherwise be very difficult to program.

### The Three Laws of Recursion

- Like the robots of Asimov, all recursive algorithms must obey three important laws:
  - 1 - A recursive algorithm must have a base case.
  - 2 - A recursive algorithm must change its state and move toward the base case.
  - 3 - A recursive algorithm must call itself, recursively.
  
- Lets first see an exapmle of a recursion in python code and we will than discuss where the laws are used within it. The example programs motive is to give the sum of the int elements in an array(list). Yes we could use while or for loops to solve it a lot easier but thats not the point we are trying to understand recursion.
  ```python
  def sum(array):
      if len(array) == 1:
          return sum[0]
      else:
          return array[0] + sum(array[1:])
  ```
  
- Let’s look at each one of these laws in more detail and see how it was used in the `sum` algorithm. First, a base case is the condition that allows the algorithm to stop recursing. A base case is typically a problem that is small enough to solve directly. In the `sum` algorithm the base case is a list of length 1.

- To obey the second law, we must arrange for a change of state that moves the algorithm toward the base case. A change of state means that some data that the algorithm is using is modified. Usually the data that represents our problem gets smaller in some way. In the `sum` algorithm our primary data structure is a list, so we must focus our state-changing efforts on the list. Since the base case is a list of length 1, a natural progression toward the base case is to shorten the list. This is exactly what happens on code above  when we call `sum` with a shorter list in the else statement.

- The final law is that the algorithm must call itself. This is the very definition of recursion. Recursion is a confusing concept to many beginning programmers. As a novice programmer, you have learned that functions are good because you can take a large problem and break it up into smaller problems. The smaller problems can be solved by writing a function to solve each problem. When we talk about recursion it may seem that we are talking ourselves in circles. We have a problem to solve with a function, but that function solves the problem by calling itself! But the logic is not circular at all; the logic of recursion is an elegant expression of solving a problem by breaking it down into a smaller and easier problems.

- In the remainder of this chapter we will look at more examples of recursion. In each case we will focus on designing a solution to a problem by using the three laws of recursion.

### Summary

- All recursive algorithms must have a base case.
- A recursive algorithm must change its state and make progress toward the base case.
- A recursive algorithm must call itself (recursively).
- Recursion can take the place of iteration in some cases.
- Recursive algorithms often map very naturally to a formal expression of the problem you are trying to solve.
- Recursion is not always the answer. Sometimes a recursive solution may be more computationally expensive than an alternative algorithm.


### I really got bored of this chapter through out the book I may need other cooler examples for learning recursion.

<hr>

[Chapter 5](./chapter-5.md)
