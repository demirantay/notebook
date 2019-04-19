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
