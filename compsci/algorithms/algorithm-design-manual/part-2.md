# 3 Data Structures

- Changing a data structure in a slow program can work the same way an organ
transplant does in a sick patient. Important classes of abstract data types such as
containers, dictionaries, and priority queues, have many different but functionally
equivalent data structures that implement them. Changing the data structure does
not change the correctness of the program, since we presumably replace a correct
implementation with a different correct implementation. However, the new implementation of the data type realizes different tradeoffs in the time to execute various
operations, so the total performance can improve dramatically

  But it is better to be born with a good heart than have to wait for a replacement. The maximum benefit from good data structures results from designing your
program around them in the first place

  In data structures, as with most subjects, it is more important to really understand the basic material than have exposure to more advanced concepts We
will focus on each of the three fundamental abstract data types (containers, dictionaries, and priority queues) and see how they can be implemented with arrays
and lists.

### Contiguous vs. Linked Data Structures

- Data structures can be neatly classified as either contiguous or linked, depending
upon whether they are based on arrays or pointers:
  - Contiguously-allocated structures are composed of single slabs of memory, and
include arrays, matrices, heaps, and hash tables.
  - Linked data structures are composed of distinct chunks of memory bound
together by pointers, and include lists, trees, and graph adjacency lists

- `Arrays` -- The array is the fundamental contiguously-allocated data structure. Arrays are
structures of fixed-size data records such that each element can be efficiently located
by its index or (equivalently) address. Advantages of contiguously-allocated arrays include:
  - Constant-time access given the index – Because the index of each element
maps directly to a particular memory address
  - Space efficiency – Arrays consist purely of data, so no space is wasted with
links or other formatting information.
  - Memory locality – A common programming idiom involves iterating through
all the elements of a data structure. Arrays are good for this because they
exhibit excellent memory locality

  Actually, we can efficiently enlarge arrays as we need them, through the miracle
of dynamic arrays. Suppose we start with an array of size 1, and double its size from
m to 2m each time we run out of space. This doubling process involves allocating a
new contiguous array of size 2m, copying the contents of the old array to the lower
half of the new one, and returning the space used by the old array to the storage
allocation system.

  The primary thing lost using dynamic arrays is the guarantee that each array
access takes constant time in the worst case. Now all the queries will be fast, except
for those relatively few queries triggering array doubling. What we get instead is a
promise that the nth array access will be completed quickly enough that the total
effort expended so far will still be O(n). 

- `Pointers and Linked Structures` -- Pointers are the connections that hold the pieces of linked structures together.
Pointers represent the address of a location in memory. A variable storing a pointer
to a given data item can provide more freedom than storing a copy of the item
itself

  We use pointers for linked data structures especially __Lists__. They have the same mentalty as arrays but instead of having a fixed size and a doubling algorithm inside it. They have unlimited space from the beginining. How this is done ? it is easy there are two variables inside the value of a list node, one has the value such as 19, "foo", ... etc. and the next variabble holds the __next__ memory location (pointer) to next list node.

- `Comparison` -- The relative advantages of linked lists over static arrays include:
  - Overflow on linked structures can never occur unless the memory is actually
full.
  - Insertions and deletions are simpler than for contiguous (array) lists
  - With large records, moving pointers is easier and faster than moving the
items themselves.
  
  while the relative advantages of arrays include:
  - Linked structures require extra space for storing pointer fields
  - Linked lists do not allow efficient random access to items.
  - Arrays allow better memory locality and cache performance than random
pointer jumping.

### Stacks and Queues

- We use the term container to denote a data structure that permits storage and
retrieval of data items independent of content. By contrast, dictionaries are abstract
data types that retrieve based on key values or content, Containers are distinguished by the particular retrieval order they support:
  - Stacks – Support retrieval by last-in, first-out (LIFO) order. Stacks are simple
to implement and very efficient. For this reason, stacks are probably the
right container to use when retrieval order doesn’t matter at all
  - Queues – Support retrieval in first in, first out (FIFO) order. This is surely
the fairest way to control waiting times for services. You want the container
holding jobs to be processed in FIFO order to minimize the maximum time
spent waiting Queues are somewhat trickier to implement than stacks and thus are most
appropriate for applications (like certain simulations) where the order is important.

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
