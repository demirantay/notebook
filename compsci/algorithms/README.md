# Algorithms and Data Structures

- *IRC explanation in nutshell: Each Data Structure is like a different styled array or a node and you use algorithms to get the data from the strcutres in a number of different ways *

- Data Structures are the programmatic way of storing data so that data can be used efficiently. Almost every enterprise application uses various types of data structures in one or the other way

- Data Structure is a systematic way to organize data in order to use it efficiently. Following terms are the foundation terms of a data structure.
  - `Interface` : Each data structure has an interface. Interface represents the set of operations that a data structure supports. An interface only provides the list of supported operations, type of parameters they can accept and return type of these operations
  - `Implementation` : Implementation provides the internal representation of a data structure. Implementation also provides the definition of the algorithms used in the operations of the data structure.
  
- Characteristics of a datastructure:
   - *Correctness* − Data structure implementation should implement its interface correctly.
   - *Time Complexity* − Running time or the execution time of operations of data structure must be as small as possible.
   - *Space Complexity* − Memory usage of a data structure operation should be as little as possible.
   
### Need for Algortihms and Data Structures

- As applications are getting complex and data rich, there are three common problems that applications face now-a-days.
  - `Data Search` − Consider an inventory of 1 million(106) items of a store. If the application is to search an item, it has to search an item in 1 million(106) items every time slowing down the search. As data grows, search will become slower.
  - `Processor speed` − Processor speed although being very high, falls limited if the data grows to billion records.
  - `Multiple requests` − As thousands of users can search data simultaneously on a web server, even the fast server fails while searching the data.

  To solve the above-mentioned problems, data structures come to rescue. Data can be organized in a data structure in such a way that all items may not be required to be searched, and the required data can be searched almost instantly.

### Execution Time Cases

- There are three cases which are usually used to compare various data structure's execution time in a relative manner.
  - `Worst Case` − This is the scenario where a particular data structure operation takes maximum time it can take.
  - `Average Case` − This is the scenario depicting the average execution time of an operation of a data structure.  
  - `Best Case` − This is the scenario depicting the least possible execution time of an operation of a data structure. 

<br/>
<br/>
<br/>
<br/>

# Algorithm Basics 

- Algorithm is a step-by-step procedure, which defines a set of instructions to be executed in a certain order to get the desired output. Algorithms are generally created independent of underlying languages, i.e. an algorithm can be implemented in more than one programming language.

- From the data structure point of view, following are some important categories of algorithms −
  - `Search` − Algorithm to search an item in a data structure.
  - `Sort` − Algorithm to sort items in a certain order.
  - `Insert` − Algorithm to insert item in a data structure.
  - `Update` − Algorithm to update an existing item in a data structure.
  - `Delete` − Algorithm to delete an existing item from a data structure.
  
- Characteristics of an Algorithm: Not all procedures can be called an algorithm. An algorithm should have the following characteristics −
  - `Unambiguous` − Algorithm should be clear and unambiguous. Each of its steps (or phases), and their inputs/outputs should be clear and must lead to only one meaning.
  - `Input` − An algorithm should have 0 or more well-defined inputs.
  - `Output` − An algorithm should have 1 or more well-defined outputs, and should match the desired output.
  - `Finiteness` − Algorithms must terminate after a finite number of steps.
  - `Feasibility` − Should be feasible with the available resources.
  - `Independent` − An algorithm should have step-by-step directions, which should be independent of any programming code.
  
### How to Write an Algorithm

- There are no well-defined standards for writing algorithms. Rather, it is problem and resource dependent. As we know that all programming languages share basic code constructs like loops (do, for, while), flow-control (if-else), etc. These common constructs can be used to write an algorithm.

  We write algorithms in a step-by-step manner, but it is not always the case. Algorithm writing is a process and is executed after the problem domain is well-defined. That is, we should know the problem domain, for which we are designing a solution.

- We design an algorithm to get a solution of a given problem. A problem can be solved in more than one ways. Hence, many solution algorithms can be derived for a given problem. The next step is to analyze those proposed solution algorithms and implement the best suitable solution.

- Lets view an example of an algorithm where the main focus is to return a sum of two numbers which is greater than 10
  ```
  Step 1: Start
  Step 2: Declare 3 variables a, b, c
  Step 3: Define values of a, b
  Step 4: store output of -step 3- into c
  Step 5: if c < 10 go backto -Step 2-, if c > 10 go to step 6
  Step 6: print c
  Step 7: Stop
  ```

### Algorithm Analysis

- Efficiency of an algorithm can be analyzed at two different stages, before implementation and after implementation. They are the following −
  - `Priori Analysis`: This is a theoretical analysis of an algorithm. Efficiency of an algorithm is measured by assuming that all other factors, for example, processor speed, are constant and have no effect on the implementation.
  - `Posterior Analysis`: This is an empirical analysis of an algorithm. The selected algorithm is implemented using programming language. This is then executed on target computer machine. In this analysis, actual statistics like running time and space required, are collected.
  
### Algorithm Complexity

- Suppose X is an algorithm and n is the size of input data, the time and space used by the algorithm X are the two main factors, which decide the efficiency of X.
  - `Time Factor` − Time is measured by counting the number of key operations 
  - `Space Factor` − Space is measured by counting the maximum memory space required by the algorithm.

### Space Complexity

- Space complexity of an algorithm represents the amount of memory space required by the algorithm in its life cycle. The space required by an algorithm is equal to the sum of the following two components −
  - A fixed part that is a space required to store certain data and variables, that are independent of the size of the problem. For example, simple variables and constants used, program size, etc.
  - A variable part is a space required by variables, whose size depends on the size of the problem. For example, dynamic memory allocation, recursion stack space, etc.
  
  Space complexity S(P) of any algorithm P is S(P) = C + SP(I), where C is the fixed part and S(I) is the variable part of the algorithm, which depends on instance characteristic I.
  
### Time Complexity

- Time complexity of an algorithm represents the amount of time required by the algorithm to run to completion. Time requirements can be defined as a numerical function T(n), where T(n) can be measured as the number of steps, provided each step consumes constant time.

<br/>
<br/>
<br/>
<br/>

# Asymptotic Analysis

- Asymptotic analysis of an algorithm refers to defining the mathematical boundation/framing of its run-time performance. Using asymptotic analysis, we can very well conclude the best case, average case, and worst case scenario of an algorithm.

- Asymptotic analysis is input bound i.e., if there's no input to the algorithm, it is concluded to work in a constant time. Other than the "input" all other factors are considered constant.

- Asymptotic analysis refers to computing the running time of any operation in mathematical units of computation. For example, the running time of one operation is computed as f(n) and may be for another operation it is computed as g(n2). This means the first operation running time will increase linearly with the increase in n and the running time of the second operation will increase exponentially when n increases. Similarly, the running time of both operations will be nearly the same if n is significantly small.
  
  Usually, the time required by an algorithm falls under three types −
    - Best Case − Minimum time required for program execution.
    - Average Case − Average time required for program execution.
    - Worst Case − Maximum time required for program execution.
    
### Asymptotoic Notations

  - Following are the commonly used asymptotic notations to calculate the running time complexity of an algorithm.
    - `Ο Notation` - Big O notation. The notation Ο(n) is the formal way to express the upper bound of an algorithm's running time. It measures the worst case time complexity or the longest amount of time an algorithm can possibly take to complete.
    - `Ω Notation` - Omega notation. The notation Ω(n) is the formal way to express the lower bound of an algorithm's running time. It measures the best case time complexity or the best amount of time an algorithm can possibly take to complete.
    - `θ Notation` - Theta notation. The notation θ(n) is the formal way to express both the lower bound and the upper bound of an algorithm's running time. It is represented as follows −

<br/>
<br/>
<br/>
<br/>

# Greedy Algorithms

- An algorithm is designed to achieve optimum solution for a given problem. In greedy algorithm approach, decisions are made from the given solution domain. As being greedy, the closest solution that seems to provide an optimum solution is chosen.

- Greedy algorithms try to find a localized optimum solution, which may eventually lead to globally optimized solutions. However, generally greedy algorithms do not provide globally optimized solutions.

- Lets see an example of a problem where we use greedy algorithm. This problem is to count to a desired value by choosing the least possible coins and the greedy approach forces the algorithm to pick the largest possible coin. Remember Optimisation and efficency is the key factor in greedy algorithms

<br/>
<br/>
<br/>
<br/>

# Divide and Conquer 

- In divide and conquer approach, the problem in hand, is divided into smaller sub-problems and then each problem is solved independently. When we keep on dividing the subproblems into even smaller sub-problems, we may eventually reach a stage where no more division is possible. Those "atomic" smallest possible sub-problem (fractions) are solved. The solution of all sub-problems is finally merged in order to obtain the solution of an original problem.

- Broadly, we can understand divide-and-conquer approach in a three-step process.

### Divide/Break

- This step involves breaking the problem into smaller sub-problems. Sub-problems should represent a part of the original problem. This step generally takes a recursive approach to divide the problem until no sub-problem is further divisible. At this stage, sub-problems become atomic in nature but still represent some part of the actual problem.

### Conquer/Solve

- This step receives a lot of smaller sub-problems to be solved. Generally, at this level, the problems are considered 'solved' on their own.

### Merge/Combine

- When the smaller sub-problems are solved, this stage recursively combines them until they formulate a solution of the original problem. This algorithmic approach works recursively and conquer & merge steps works so close that they appear as one.

<br/>
<br/>
<br/>
<br/>

# Dynamic Programming

- Dynamic programming approach is similar to divide and conquer in breaking down the problem into smaller and yet smaller possible sub-problems. But unlike, divide and conquer, these sub-problems are not solved independently. Rather, results of these smaller sub-problems are remembered and used for similar or overlapping sub-problems.

- Dynamic programming is used where we have problems, which can be divided into similar sub-problems, so that their results can be re-used. Mostly, these algorithms are used for optimization. Before solving the in-hand sub-problem, dynamic algorithm will try to examine the results of the previously solved sub-problems. The solutions of sub-problems are combined in order to achieve the best solution.

- So we can say that −
  - The problem should be able to be divided into smaller overlapping sub-problem.
  - An optimum solution can be achieved by using an optimum solution of smaller sub-problems.
  - Dynamic algorithms use Memoization.
  
- In contrast to greedy algorithms, where local optimization is addressed, dynamic algorithms are motivated for an overall optimization of the problem.

- In contrast to divide and conquer algorithms, where solutions are combined to achieve an overall solution, dynamic algorithms use the output of a smaller sub-problem and then try to optimize a bigger sub-problem. Dynamic algorithms use Memoization to remember the output of already solved sub-problems.

<br/>
<br/>
<br/>
<br/>

# Data Structures

- First, lets learn about the generic jargon of the terminalogy used with data stuctures:
  - `Atomic`: Definition should define a single concept.
  - `Tracable`: Definition should be able to be mapped to some data element.
  - `Accurate`:  Definition should be unambiguous.
  - `Clear and Concise`:  Definition should be understandable.
  - `Data Object`: Data Object represents an object having a data.
  - `Data Type`:Data type is a way to classify various types of data such as integer, string, etc. which determines the values that can be used with the corresponding type of data, the type of operations that can be performed on the corresponding type of data. There are two data types −
    - Built-In Data Type
    - Derived Data Type
    
### Built-in Data Type

- Those data types for which a language has built-in support are known as Built-in Data types. For example, most of the languages provide the following built-in data types. `Integers`, `Boolean`, `Floating`, `Characters` and `Strings`

### Derived Data Type

- Those data types which are implementation independent as they can be implemented in one or the other way are known as derived data types. These data types are normally built by the combination of primary or built-in data types and associated operations on them. For example − `List`, `Array`, `Dictionary`, `Stack`, `Queue`

### Basic Operations

- The data in the data structures are processed by certain operations. The particular data structure chosen largely depends on the frequency of the operation that needs to be performed on the data structure. Some common operations are - `Traversing`, `Searching`, `Insertion`, `Deletion`, `Sorting`, `Merging`

<br/>
<br/>
<br/>
<br/>

# Arrays

- Array is a container which can hold a fix number of items and these items should be of the same type. Most of the data structures make use of arrays to implement their algorithms. Following are the important terms to understand the concept of Array.
  - `Element` − Each item stored in an array is called an element.
  - `Index` − Each location of an element in an array has a numerical index, which is used to identify the element.

<br/>
<br/>
<br/>
<br/>


The following are the different common data strcutres and algotihms used daily by millions of programmers:

### Linked Lists 

[Click here to view the page](./linked-lists.md)

### Stack & Queue

[Click here to view the page](./stacks-queues.md)

### Searching Techniques

[Click here to view the page](./searching-techniques.md)

### Sorting Techniques

[Click here to view the page](./sorting-techniques.md)

### Graph Data Structure

[Click here to view the page](./graph-data-structure.md)

### Tree Data Structure

[Click here to view the page](./tree-data-structure.md)

### Recrusion

[Click here to view the page](./recrusion.md)

