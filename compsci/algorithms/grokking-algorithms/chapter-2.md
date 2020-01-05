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

