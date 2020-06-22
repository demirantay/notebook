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

- You learn how to tackle the impossible:
problems that have no fast algorithmic solution
(NP-complete problems). You learn how to identify such problems when you
see them, so you don’t waste time trying to find a
fast algorithm for them.

  You learn about approximation algorithms, which
you can use to find an approximate solution to an
NP-complete problem quickly. You learn about the greedy strategy, a very simple
problem-solving strategy.

### The classroom scheduling problem

- Suppose you have a classroom and want to hold as many classes
here as possible. You get a list of classes You can’t hold all of these classes in there, because some of them
overlap. You want to hold as many classes as possible in this classroom. How
do you pick what set of classes to hold, so that you get the biggest set of
classes possible

  Sounds like a hard problem, right? Actually, the algorithm is so easy, it
might surprise you. Here’s how it works:
  - 1. Pick the class that ends the soonest. This is the first class you’ll hold
in this classroom.
  - 2. Now, you have to pick a class that starts after the first class.
Again, pick the class that ends the soonest. This is the second
class you’ll hold.
  
  A lot of people tell me that this algorithm seems easy. It’s too obvious,
so it must be wrong. But that’s the beauty of greedy algorithms: they’re
easy! A greedy algorithm is simple: at each step, pick the optimal move.
In this case, each time you pick a class, you pick the class that ends the
soonest t. In technical terms: at each step you pick the locally optimal
solution, and in the end you’re left with the globally optimal solution

### The knapsack problem

- Suppose you’re a greedy thief. You’re in a store with a
knapsack, and there are all these items you can steal.
But you can only take what you can fit in your knapsack.
The knapsack can hold 35 pounds. You’re trying to maximize the value of the items you put
in your knapsack. What algorithm do you use? Again, the greedy strategy is pretty simple:
  - 1 - Pick the most expensive thing that will fit in your
knapsack
  - 2 - Pick the next most expensive thing that will fit in
your knapsack. And so on.

  Clearly, the greedy strategy doesn’t give you the optimal solution here.
But it gets you pretty close. In the next chapter, I’ll explain how to
calculate the correct solution. But if you’re a thief in a shopping center,
you don’t care about perfect. “Pretty good” is good enough. 

  Here’s the takeaway from this second example: sometimes, perfect is the
enemy of good. Sometimes all you need is an algorithm that solves the
problem pretty well.

### NP-complete problems

- `Travelling salesperson, step by step` -- You may be wondering, “In the traveling salesperson problem, is there
a specific city you need to start from?” For example, let’s say I’m the
traveling salesperson. I live in San Francisco, and I need to go to four
other cities. San Francisco would be my start city

  But sometimes the start city isn’t set. Suppose you’re FedEx, trying
to deliver a package to the Bay Area. The package is being flown in
from Chicago to one of 50 FedEx locations in the Bay Area. Then
that package will go on a truck that will travel to different locations
delivering packages. Which location should it get flown to? Here the
start location is unknown. It’s up to you to compute the optimal path
and start location for the traveling salesperson

  The traveling-salesperson problem and the set-covering problem both
have something in common: you calculate every possible solution and
pick the smallest/shortest one. Both of these problems are NP-complete

  Here’s the short explanation of NP-completeness: some problems are
famously hard to solve. The traveling salesperson and the set-covering
problem are two examples. A lot of smart people think that it’s not
possible to write an algorithm that will solve these problems quickly so they use greedy algorithms to make approximations.

- `how do you tell if a problem is NP-complete` -- it’s hard to tell if a problem you’re working on is
NP-complete. Usually there’s a very small difference between a problem
that’s easy to solve and an NP-complete problem. For example, in the
previous chapters, I talked a lot about shortest paths. You know how to
calculate the shortest way to get from point A to point B.

  But if you want to find the shortest path that connects several points,
that’s the traveling-salesperson problem, which is NP-complete. The
short answer: there’s no easy way to tell if the problem you’re working
on is NP-complete. Here are some giveaways:
  - Your algorithm runs quickly with a handful of items but really slows
down with more items
  - All combinations of X” usually point to an NP-complete problem
  - Do you have to calculate “every possible version” of X because you
can’t break it down into smaller sub-problems? Might be
NP-complete.
  - If your problem involves a sequence (such as a sequence of cities, like
traveling salesperson), and it’s hard to solve, it might be NP-complete
  - If your problem involves a set (like a set of radio stations) and it’s hard
to solve, it might be NP-complete
  - Can you restate your problem as the set-covering problem or the
traveling-salesperson problem? Then your problem is definitely
NP-complete

- `recap` --
  - Greedy algorithms optimize locally, hoping to end up with a global
optimum. 
  - NP-complete problems have no known fast solution. 
  - If you have an NP-complete problem, your best bet is to use an
approximation algorithm. 
  - Greedy algorithms are easy to write and fast to run, so they make
good approximation algorithms

<br>
<br>

---

<Br>
<Br>
  
# Dynamic Programming

- You learn dynamic programming, a
technique to solve a hard problem by
breaking it up into subproblems and
solving those subproblems first.

### THe knapscak problem

- Let’s revisit the knapsack problem from chapter 8.
You’re a thief with a knapsack that can carry 4 lb
of goods. You have three items that you can put into the knapsack. What items should you steal so that you steal the maximum money’s
worth of goods? 

- `the simple solution` --  In chapter 8,
you saw how to calculate an approximate solution. That solution will be
close to the optimal solution, but it may not be the optimal solution.(greedy) So how do you calculate the optimal solution?

- `dynamic programming` --  Dynamic programming starts by
solving subproblems and builds up to solving the big problem. For the knapsack problem, you’ll start by solving the problem for
smaller knapsacks (or “sub-knapsacks”) and then work up to solving
the original problem Dynamic programming is a hard concept, so don’t worry if you don’t get it
right away

### Longest common substring

- You’ve seen one dynamic programming problem so far. What are
the takeaways?
  
  Dynamic programming is useful when you’re trying to optimize
something given a constraint. In the knapsack problem, you had to
maximize the value of the goods you stole, constrained by the size of
the knapsack. 
  
  You can use dynamic programming when the problem can be broken
into discrete subproblems, and they don’t depend on each other. It can be hard to come up with a dynamic-programming solution. That’s
what we’ll focus on in this section. Some general tips follow: 
  - Every dynamic-programming solution involves a grid.
  - The values in the cells are usually what you’re trying to optimize.
For the knapsack problem, the values were the value of the goods
  - Each cell is a subproblem, so think about how you can divide
your problem into subproblems. That will help you figure out what
the axes are.

- `Recap` --
  - Dynamic programming is useful when you’re trying to optimize
something given a constraint. 
  - You can use dynamic programming when the problem can be
broken into discrete subproblems.
  - Every dynamic-programming solution involves a grid
  - The values in the cells are usually what you’re trying to optimize
  - Each cell is a subproblem, so think about how you can divide your
problem into subproblems.
  - There’s no single formula for calculating a dynamic-programming
solution.

<br>
<br>

---

<br>
<Br>
  
# K-nearest neighbors

- You learn to build a classification system using
the k-nearest neighbors algorithm You learn about feature extraction. You learn about regression: predicting a number,
like the value of a stock tomorrow, or how much
a user will enjoy a movie.

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
