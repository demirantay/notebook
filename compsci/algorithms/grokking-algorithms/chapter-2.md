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
