# The Algorithm Design Manual - Skienna 2nd

Designing correct, efficient, and implementable algorithms for real-world problems requires
access to two distinct bodies of knowledge:
  - `Techniques` – Good algorithm designers understand several fundamental algorithm design techniques, including data structures, dynamic programming,
depth-first search, backtracking, and heuristics. Perhaps the single most important design technique is modeling, the art of abstracting a messy real-world
application into a clean problem suitable for algorithmic attack.
  - `Resources` – Good algorithm designers stand on the shoulders of giants.
Rather than laboring from scratch to produce a new algorithm for every task,
they can figure out what is known about a particular problem. Rather than
re-implementing popular algorithms from scratch, they seek existing implementations to serve as a starting point. They are familiar with many classic
algorithmic problems, which provide sufficient source material to model most
any application.

Table of Contents:
- [1 Introduction to Algorithm Design]()
- [2 Algorithm Analysis]()
- [3 Data Structures]()
- [4 Sorting and Searching]()
- [5 Graph Traversal]()
- [6 Weighted Graph Algorithms]()
- [7 Combinatorial Search and Heuristic Methods]()
- [8 Dynamic Programming]()
- [9 Intractable Problems and Approximation Algorithms]()
- [10 How to Design Algorithms]()
- [11 A Catalog of Algorithmic Problems]()
- [12 Data Structures]()
- [13 Numerical Problems]()
- [14 Combinatorial Problems]()
- [15 Graph Problems: Polynomial-Time]()
- [16 Graph Problems: Hard Problems]()
- [17 Computational Geometry]()
- [18 Set and String Problems]()
- [19 Algorithmic Resources]()

<br>
<br>

---

<br>
<br>

# 1 Introduction to Algorithm Design

- What is an algorithm? An algorithm is a procedure to accomplish a specific task.
An algorithm is the idea behind any reasonable computer program.
To be interesting, an algorithm must solve a general, well-specified problem

- There are three desirable properties for a good algorithm. We seek algorithms
that are correct and efficient, while being easy to implement. These goals may not
be simultaneously achievable. In industrial settings, any program that seems to
give good enough answers without slowing the application down is often acceptable,
regardless of whether a better algorithm exists. The issue of finding the best possible
answer or achieving maximum efficiency usually arises in industry only after serious
performance or legal troubles. So a good enough algorithm is enough if it gets the job done.

### Selecting the Right Jobs

- Reasonable-looking algorithms can easily be incorrect. Algorithm correctness is a property that must be carefully demonstrated. For example you may be thinking that you are using the right algorithm for the job however the `n` input of the alforithm may quickly turn into a 20! permutation problem which is compulationaly impossible to solve. The take home lesson is be careful while playing with heuristic, travelling salesman typed algorithms. 

### Reasoning about Correctness

- We need tools to distinguish correct algorithms from incorrect
ones, the primary one of which is called a proof.

  A proper mathematical proof consists of several parts. First, there is a clear,
precise statement of what you are trying to prove. Second, there is a set of assumptions of things which are taken to be true and hence used as part of the proof.
Third, there is a chain of reasoning which takes you from these assumptions to the
statement you are trying to prove. Finally, there is a little square ( ) or QED at the
bottom to denote that you have finished, representing the Latin phrase for “thus
it is demonstrated.”

- `Expressing Algorithms` -- Reasoning about an algorithm is impossible without a careful description of the
sequence of steps to be performed. The three most common forms of algorithmic
notation are (1) English, (2) pseudocode, or (3) a real programming language. Programmers generally go for psudeo-code which is the most useful between all three.

  The heart of any algorithm is an idea. If your idea is
not clearly revealed when you express an algorithm, then you are using too
low-level a notation to describe it. Try to avoid hard to read languages like C, C++ ... etc.

- `Problems and Properties` --

- `Demonstrating Incorrectness` --

- ` Induction and Recursion` --

- `Summations` --

### Modeling the Problem

### About the War Stories

### War Story: Psychic Modeling

### Exercises

<br>
<br>

---

<bR>
<Br>
  
# 2 Algorithm Analysis

### The RAM Model of Computation

### The Big Oh Notation

### Growth Rates and Dominance Relations

### Working with the Big Oh

### Reasoning About Efficiency

### Logarithms and Their Applications

### Properties of Logarithms

### War Story: Mystery of the Pyramids

### Advanced Analysis (*)

### Exercises

<br>
<br>

---

<bR>
<Br>
  
# 3 Data Structures

### Contiguous vs. Linked Data Structures

### Stacks and Queues

### Dictionaries

### Binary Search Trees

### Priority Queues .

### War Story: Stripping Triangulations

### Hashing and Strings

### Specialized Data Structures

### War Story: String ’em Up

### Exercises

<br>
<br>

---

<bR>
<Br>
  
# 4 Sorting and Searching

### Applications of Sorting

### Pragmatics of Sorting

### Heapsort: Fast Sorting via Data Structures 

### War Story: Give me a Ticket on an Airplane

### Mergesort: Sorting by Divide-and-Conquer

### Quicksort: Sorting by Randomization

### Distribution Sort: Sorting via Bucketing

### War Story: Skiena for the Defense

### Binary Search and Related Algorithms 

### Divide-and-Conquer

### Exercises

<br>
<br>

---

<bR>
<Br>
  
# 5 Graph Traversal

### Flavors of Graphs

### Data Structures for Graphs

### War Story: I was a Victim of Moore’s Law 

### War Story: Getting the Graph

### Traversing a Graph

### Breadth-First Search

### Applications of Breadth-First Search

### Depth-First Search

### Applications of Depth-First Search

### Depth-First Search on Directed Graphs

### Exercises

<br>
<br>

---

<bR>
<Br>
  
# 6 Weighted Graph Algorithms

### Minimum Spanning Trees

### War Story: Nothing but Nets

### Shortest Paths 

### War Story: Dialing for Documents

### Network Flows and Bipartite Matching

### Design Graphs, Not Algorithms

### Exercises

<br>
<br>

---

<bR>
<Br>
  
# 7 Combinatorial Search and Heuristic Methods

### Backtracking

### Search Pruning

### Sudoku

### War Story: Covering Chessboards

### Heuristic Search Methods

### War Story: Only it is Not a Radio

### War Story: Annealing Arrays

### Other Heuristic Search Methods

### Parallel Algorithms

### War Story: Going Nowhere Fast

### Exercises

<br>
<br>

---

<bR>
<Br>
  
# 8 Dynamic Programming

### Caching vs. Computation

### Approximate String Matching

### Longest Increasing Sequence

### War Story: Evolution of the Lobster

### The Partition Problem

### Parsing Context-Free Grammars

### Limitations of Dynamic Programming: TSP

### War Story: What’s Past is Prolog

### War Story: Text Compression for Bar Codes

### Exercises

<br>
<br>

---

<bR>
<Br>
  
# 9 Intractable Problems and Approximation Algorithms
 
### Problems and Reductions

### Reductions for Algorithms

### Elementary Hardness Reductions

### Satisfiability .

### Creative Reductions

### The Art of Proving Hardness

### War Story: Hard Against the Clock 

### War Story: And Then I Failed

### P vs. NP

### Dealing with NP-complete Problems

### Exersices

<br>
<br>

---

<bR>
<Br>
  
# 10 How to Design Algorithms

<br>
<br>

---

<bR>
<Br>
  
# 11 A Catalog of Algorithmic Problems

<br>
<br>

---

<bR>
<Br>
  
# 12 Data Structures

### Dictionaries

### Priority Queues

### Suffix Trees and Arrays 

### Graph Data Structures

### Set Data Structures

### Kd-Trees

<br>
<br>

---

<bR>
<Br>
  
# 13 Numerical Problems

### Solving Linear Equations

### Bandwidth Reduction

### Matrix Multiplication 

### Determinants and Permanents

### Constrained and Unconstrained Optimization

### Linear Programming

### Random Number Generation

### Factoring and Primality Testing .

### Arbitrary-Precision Arithmetic

### Knapsack Problem

### Discrete Fourier Transform

<br>
<br>

---

<bR>
<Br>
  
# 14 Combinatorial Problems

### Sorting 

### Searching

### Median and Selection

### Generating Permutations .

### Generating Subsets

### Generating Partitions

### Generating Graphs

### Calendrical Calculations

### Job Scheduling

### Satisfiability

<br>
<br>

---

<bR>
<Br>
  
# 15 Graph Problems: Polynomial-Time

### Connected Components

### Topological Sorting

### Minimum Spanning Tree

### Shortest Path

### Transitive Closure and Reduction

### Matching

### Eulerian Cycle/Chinese Postman

### Edge and Vertex Connectivity

### Network Flow

### Drawing Graphs Nicely

### Drawing Trees

### Planarity Detection and Embedding

<br>
<br>

---

<bR>
<Br>
  
# 16 Graph Problems: Hard Problems

### Clique

### Independent Set

### Vertex Cover

### Traveling Salesman Problem

### Hamiltonian Cycle

### Graph Partition

### Vertex Coloring

### Edge Coloring

### Graph Isomorphism

### Steiner Tree

### Feedback Edge/Vertex Set

<br>
<br>

---

<bR>
<Br>
  
# 17 Computational Geometry

### Robust Geometric Primitives

### Convex Hull

### Triangulation

### Voronoi Diagrams

### Nearest Neighbor Search

### Range Search

### Point Location

### Intersection Detection

### Bin Packing

### Medial-Axis Transform

### Polygon Partitioning

### Simplifying Polygons

### Shape Similarity 

### Motion Planning

### Maintaining Line Arrangements

### Minkowski Sum

<br>
<br>

---

<bR>
<Br>
  
# 18 Set and String Problems

### Set Cover

### Set Packing

### String Matching

### Approximate String Matching

### Text Compression

### Cryptography

### Finite State Machine Minimization

### Longest Common Substring/Subsequence

### Shortest Common Superstring

<br>
<br>

---

<bR>
<Br>
  
# 19 Algorithmic Resources

### Software Systems

### Data Sources

### Online Bibliographic Resources

### Professional Consulting Services


<Br>




