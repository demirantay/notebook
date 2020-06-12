# Dijktra's Algorithm

- We continue the discussion of graphs, and you
learn about weighted graphs: a way to assign
more or less weight to some edges. You learn Dijkstra’s algorithm, which lets you
answer “What’s the shortest path to X?” for
weighted graphs.

- In the last chapter, you figured out a way to get from point A to point B It’s not necessarily the fastest path. It’s the shortest path, because it has
the least number of segments (three segments). But suppose you add
travel times to those segments. Now you see that there’s a faster path.

  You used breadth-first search in the last chapter. Breadth-first search
will find you the path with the fewest segments (the first graph shown
here). What if you want the fastest path instead (the second graph)? You
can do that fastest with a different algorithm called Dijkstra’s algorithm. 

- There are four steps to Dijkstra’s algorithm:
  - 1 - Find the “cheapest” node. This is the node you can get to in the least
amount of time
  - 2 - Update the costs of the neighbors of this node. I’ll explain what I
mean by this shortly
  - 3 - Repeat until you’ve done this for every node in the graph
  - 4 - Calculate the final path.

### Terminology

- When you work with Dijkstra’s algorithm, each edge in the graph has a
number associated with it. These are called `weights`. A graph with weights is called a weighted graph. A graph without
weights is called an unweighted graph.

  To calculate the shortest path in an unweighted graph, use breadth-first
search. To calculate the shortest path in a weighted graph, use Dijkstra’s
algorithm. Graphs can also have `cycles`. the cycle adds more weight. You
could even follow the cycle twice if you wanted. An undirected graph means that both nodes point to each other. That’s
a cycle!

  With an undirected graph, each edge adds another cycle.
Dijkstra’s algorithm only works with directed acyclic graphs,
called DAGs for short. So try to avoid cycles because of loops.

### Negative-weight edges

-  You can’t use
Dijkstra’s algorithm if you have negative-weight edges. Negative-weight
edges break the algorithm.

  If you want to find the shortest path in a graph
that has negative-weight edges, there’s an algorithm for that! It’s called
the Bellman-Ford algorithm. Bellman-Ford is out of the scope of this
book, but you can find some great explanations online

- `Recap` --
  - Breadth-first search is used to calculate the shortest path for
an unweighted graph.
  - Dijkstra’s algorithm is used to calculate the shortest path for
a weighted graph.
  - Dijkstra’s algorithm works when all the weights are positive
  - If you have negative weights, use the Bellman-Ford algorithm
  
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
