# Algorithms and Data Structures

- *IRC explanation in nutshell: Each Data Structure is like a different styled array or a node and you use algorithms to get the data from the strcutres in a number of different ways *

- Data Structure is a way of collecting and organising data in such a way that we can perform operations on these data in an effective way. Data Structures is about rendering data elements in terms of some relationship, for better organization and storage.
  
  If you are aware of Object Oriented programming concepts, then a `class` also does the same thing, it collects different type of data under one single entity. The only difference being, data structures provides for techniques to access and manipulate data efficiently.
  
  In simple language, Data Structures are structures programmed to store ordered data, so that various operations can be performed on it easily. It represents the knowledge of data to be organized in memory. It should be designed and implemented in such a way that it reduces the complexity and increases the efficiency.
  
### Basic Types of Data Structures

- As we have discussed above, anything that can store data can be called as a data structure, hence Integer, Float, Boolean, Char etc, all are data structures. They are known as `Primitive Data Structures`.

  Then we also have some complex Data Structures, which are used to store large and connected data. Some example of `Abstract Data Structure` are :
  - Linked List
  - Tree
  - Graph
  - Stack, Queue ... etc.
  
  All these data structures allow us to perform different operations on data. We select these data structures based on which type of operation is required. We will look into these data structures in more details in our later chapters.
  
- The data structures can also be classified on the basis of the following characteristics:
  - `Linear` - 	In Linear data structures,the data items are arranged in a linear sequence. Example: "Array"
  - `Non-Linear` - In Non-Linear data structures,the data items are not in sequence. Example: "Tree", "Graph
  - `Homogeneous` - In homogeneous data structures,all the elements are of same type. Example: "Array"
  - `Non-Homogeneous` - In Non-Homogeneous data structure, the elements may or may not be of the same type. Example: "Structures"
  - `Static` - Static data structures are those whose sizes and structures associated memory locations are fixed, at compile time. Example: "Array"
  - `Dynamic` - Dynamic structures are those which expands or shrinks depending upon the program need and its execution. Also, their associated memory locations changes. Example: "Linked List created using pointers"


### What is an Algorithm

- An algorithm is a finite set of instructions or logic, written in order, to accomplish a certain predefined task. Algorithm is not the complete code or program, it is just the core logic(solution) of a problem, which can be expressed either as an informal high level description as pseudocode or using a flowchart.

- Every Algorithm must satisfy the following properties:
  - `Input` - There should be 0 or more inputs supplied externally to the algorithm.
  - `Output` - There should be atleast 1 output obtained.
  - `Definiteness` - Every step of the algorithm should be clear and well defined.
  - `Finiteness` - The algorithm should have finite number of steps.
  - `Correctness` - Every step of the algorithm must generate a correct output.
  
  An algorithm is said to be efficient and fast, if it takes less time to execute and consumes less memory space. The performance of an algorithm is measured on the basis of following properties :
  - Space Complexity
  - Time Compleixty

### Space Complexity

- Its the amount of memory space required by the algorithm, during the course of its execution. Space complexity must be taken seriously for multi-user systems and in situations where limited memory is available. An algorithm generally requires space for following components :
  - `Instruction Space:` Its the space required to store the executable version of the program. This space is fixed, but varies depending upon the number of lines of code in the program.
  - `Data Space:` Its the space required to store all the constants and variables(including temporary variables) value.
  - `Environment Space:` Its the space required to store the environment information needed to resume the suspended function.
  
### Time Complexity

- Time Complexity is a way to represent the amount of time required by the program to run till its completion. It's generally a good practice to try to keep the time required minimum, so that our algorithm completes it's execution in the minimum time possible. We will study about Time Complexity in details in later sections.


<br>
<br>

---

<br>
<br>

# Asymptotic Notations 

- When it comes to analysing the complexity of any algorithm in terms of time and space, we can never provide an exact number to define the time required and the space required by the algorithm, instead we express it using some standard notations, also known as `Asymptotic Notations`.

### What is Asymptotic Behaviour 

- If we have two algorithms with the following expressions representing the time required by them for execution, then:
  - `Expression 1` - (20n2 + 3n - 4)
  - `Expression 2` - (n3 + 100n - 2)

  Now, as per asymptotic notations, we should just worry about how the function will grow as the value of `n`(input) will grow, and that will entirely depend on `n2` for the Expression 1, and on `n3` for Expression 2. Hence, we can clearly say that the algorithm for which running time is represented by the Expression 2, will grow faster than the other one, simply by analysing the highest power coeeficient and ignoring the other constants(20 in 20n2) and insignificant parts of the expression(`3n - 4` and `100n - 2`).
  
  The main idea behind casting aside the less important part is to make things **manageable**.
  
  So while analysing algorithm complexities you do not need to calculate all of the expressions inside a formula. Just take the biggest exponened one(s) and base your complexity around that single n3, n2 ... etc. You get the idea.
  
### Types of Asymptotic Notations

- We use three types of asymptotic notations to represent the growth of any algorithm, as input increases:
  - Big Theta (Θ)
  - Big Oh(O)
  - Big Omega (Ω)
  
### Tight Bounds: Theta

- For example, if for some algorithm the time complexity is represented by the expression 3n2 + 5n, and we use the Big-Θ notation to represent this, then the time complexity would be Θ(n2), ignoring the constant coefficient and removing the insignificant part, which is 5n.

### Upper Bounds: Big-O

- This notation is known as the upper bound of the algorithm, or a Worst Case of an algorithm. It tells us that a certain function will never exceed a specified time for any value of input n. I didn't understand the explanation here. Find a different resource:
  - https://www.studytonight.com/data-structures/aysmptotic-notations
  
### Lower Bounds: Omega

- Big Omega notation is used to define the lower bound of any algorithm or we can say the best case of any algorithm. This always indicates the minimum time required for any algorithm for all input values, therefore the best case of any algorithm.

  This always indicates the minimum time required for any algorithm for all input values, therefore the best case of any algorithm.

<br>
<br>

---

<br>
<br>

# Space Complexity of Algorithms 

- Whenever a solution to a problem is written some memory is required to complete. For any algorithm memory may be used for the following:
  - Variables (This include the constant values, temporary values)
  - Program Instruction
  - Execution
  
  > Space complexity is the amount of memory used by the algorithm (including the input values to the algorithm) to execute and produce the result.

- Sometime Auxiliary Space is confused with Space Complexity. But Auxiliary Space is the extra space or the temporary space used by the algorithm during it's execution.

  *Space Complexity = Auxiliary Space + Input space*
  
### Memory Usage while Execution

- While executing, algorithm uses memory space for three reasons:
  - `Instruction Space` - It's the amount of memory used to save the compiled version of instructions.
  - `Environmental Stack` - Sometimes an algorithm(function) may be called inside another algorithm(function). In such a situation, the current variables are pushed onto the system stack, forcing the original algorithm to have the other algotihms stack on its space.
  - `Data Space` - Amount of space used by the variables and constants.
  
  Important: But while calculating the `Space Complexity` of any algorithm, we usually consider only `Data Space` and we neglect the `Instruction Space` and `Environmental Stack`.

### Calculating Space Complexity 

- For calculating the space complexity, we need to know the value of memory used by different type of datatype variables, which generally varies for different operating systems, but the method for calculating the space complexity remains the same.

- Sizes of var types:
  - `bool`, `char`, `unsigned char`, `signed char` -- 1 Byte
  - `__int16`, `short`, `unsigned short`, `wchar_t`, `__wchar_t` -- 2 Bytes
  - `float`, `__int32`, `int`, `unsigned int`, `long`, `unsigned long` -- 4 Bytes
  - `double`, `__int64`, `long double`, `long long` -- 8 Bytes

  Now let's learn how to compute space complexity by taking a few example:
  ```cpp
  {
      int z = a + b + c;
      return(z);
  }
  ```
  In the above expression, variables a, b, c and z are all integer types, hence they will take up 4 bytes each, so total memory requirement will be `(4(4) + 4) = 20` bytes, this additional 4 bytes is for `return` value. And because this space requirement is fixed for the above example, hence it is called `Constant Space Complexity`. If we had a variable that needed input such as `n2` and we did not know how much space it woudl take we would call it `Linear Space Complexity.`
  
  Remember: We should always focus on writing algorithm code in such a way that we keep the space complexity minimum.
  
<br>
<br>

---

<br>
<br>

# Time Complexity of Algorithms

- For any defined problem, there can be N number of solution. This is true in general. Similarly for any problem which must be solved using a program, there can be infinite number of solutions. For exmaple we want to get the number `2` from two numbers. We can add them, subtact them ... etc. the number of solution is infinite:
  ```
  0 + 2 = 2
  1 + 1 = 2
  1.2 + 0.8 = 2
  98 - 96 = 2
  ...
  ```
  Remember that programs have many solutions
  
### What is Time Complexity

- Time complexity of an algorithm signifies the total time required by the program to run till its completion. The time complexity of algorithms is most commonly expressed using the big O notation. It's an asymptotic notation to represent the time complexity.

  Time Complexity is most commonly estimated by counting the number of elementary steps performed by any algorithm to finish execution. And since the algorithm's performance may vary with different types of input data, hence for an algorithm we usually use the `worst-case Time complexity` of an algorithm because that is the maximum time taken for any input size.

### Calculating Time Compleixty

- Now lets tap onto the next big topic related to Time complexity, which is How to Calculate Time Complexity. It becomes very confusing some times, but we will try to explain it in the simplest way.

  Now the most common metric for calculating time complexity is Big O notation. This removes all constant factors so that the running time can be estimated in relation to `N`, as `N` approaches infinity. In general you can think of it like this :
  ```cpp
  statement;
  ```
  Above we have a single statement. Its Time Complexity will be Constant. The running time of the statement will not change in relation to `N`.
  ```cpp
  for(i=0; i < N; i++)
  {
      statement;
  }
  ```
  The time complexity for the above algorithm will be `Linear`. The running time of the loop is directly proportional to `N`. When N doubles, so does the running time.
  ```cpp
  for(i=0; i < N; i++) 
  {
      for(j=0; j < N;j++)
      { 
      statement;
      }
  }
  ```
  This time, the time complexity for the above code will be `Quadratic`. The running time of the two loops is proportional to the square of N. When N doubles, the running time increases by N * N.
  ```cpp
    while(low <= high) 
  {
      mid = (low + high) / 2;
      if (target < list[mid])
          high = mid - 1;
      else if (target > list[mid])
          low = mid + 1;
      else break;
  }
  ```
  This is an algorithm to break a set of numbers into halves, to search a particular field(we will study this in detail later). Now, this algorithm will have a `Logarithmic` Time Complexity. The running time of the algorithm is proportional to the number of times N can be divided by 2(N is high-low here). This is because the algorithm divides the working area in half with each iteration.

### Types of Notations for Time Complexity 

- Now we will discuss and understand the various notations used for Time Complexity.
  - 1 - `Big Oh` denotes "fewer than or the same as" <expression> iterations.
  - 2 - `Big Omega` denotes "more than or the same as" <expression> iterations.
  - 3 - `Big Theta` denotes "the same as" <expression> iterations.
  - 4 - `Little Oh` denotes "fewer than" <expression> iterations.
  - 5 - `Little Omega` denotes "more than" <expression> iterations
  
- `O(expression)` is the set of functions that grow slower than or at the same rate as expression. It indicates the maximum required by an algorithm for all input values. It represents the worst case of an algorithm's time complexity.

- `Omega(expression)` is the set of functions that grow faster than or at the same rate as expression. It indicates the minimum time required by an algorithm for all input values. It represents the best case of an algorithm's time complexity.


- `Theta(expression)` consist of all the functions that lie in both O(expression) and Omega(expression). It indicates the average bound of an algorithm. It represents the average case of an algorithm's time complexity.

<br>
<br>

---

<br>
<br>

[Part 2](./README2.md)
