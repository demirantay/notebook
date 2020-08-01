# 5 Graph Traversal

- Graphs are one of the unifying themes of computer science—an abstract representation that describes the organization of transportation systems, human interactions, and telecommunication networks. That so many different structures can
be modeled using a single formalism is a source of great power to the educated
programmer.

  More precisely, a graph G = (V,E) consists of a set of vertices V together with
a set E of vertex pairs or edges. Graphs are important because they can be used to
represent essentially any relationship. For example, graphs can model a network of
roads, with cities as vertices and roads between cities as edges or Electronic circuits can also be modeled as graphs, with junctions as vertices
and components as edges

  The key to solving many algorithmic problems is to think of them in terms
of graphs. Graph theory provides a language for talking about the properties of
relationships, and it is amazing how often messy applied problems have a simple
description and solution in terms of classical graph properties

- A graph G = (V,E) is defined on a set of vertices V , and contains a set of edges E
of ordered or unordered pairs of vertices from V . In modeling a road network, the
vertices may represent the cities or junctions, certain pairs of which are connected
by roads/edges

  In analyzing human interactions, the vertices typically
represent people, with edges connecting pairs of related souls

### Flavors of Graphs

- Several fundamental properties of graphs impact the choice of the data structures used to represent them and algorithms available to analyze them. The first
step in any graph problem is determining the flavors of graphs you are dealing
with:

  - `Undirected vs. Directed` -- Road
networks between cities are typically undirected, since any large road has
lanes going in both directions. Street networks within cities are almost always
directed, because there are at least a few one-way streets lurking somewhere.
Program-flow graphs are typically directed, because the execution flows from
one line into the next and changes direction only at branches

  - `Weighted vs. Unweighted` -- – Each edge (or vertex) in a weighted graph G is assigned a numerical value, or weight. The edges of a road network graph might  be weighted with their length, drive-time, or speed limit, depending upon the application. The difference between weighted and unweighted graphs becomes particularly
apparent in finding the shortest path between two vertices. For unweighted
graphs, the shortest path must have the fewest number of edges, and can
be found using a breadth-first search as discussed in this chapter. Shortest
paths in weighted graphs requires more sophisticated algorithm

  - `Simple vs. Non-simple` – Certain types of edges complicate the task of working
with graphs. A self-loop is an edge (x, x) involving only one vertex. An edge
(x, y) is a multiedge if it occurs more than once in the graph.

  - `Sparse vs. Dense` -- Graphs are sparse when only a small fraction of the possible
vertex pairs actually have
edges defined between them. Graphs where a large fraction of the vertex pairs
define edges are called dense. There is no official boundary between what is
called sparse and what is called dense
  
  - `Cyclic vs. Acyclic` --  An acyclic graph does not contain any cycles. Trees
are connected, acyclic undirected graphs. Cyclic graphs contains cycle.
  
  - `Embedded vs. Topological` -- A graph is embedded if the vertices and edges are
assigned geometric positions Occasionally, the structure of a graph is completely defined by the geometry
of its embedding. For example, if we are given a collection of points in the
plane, and seek the minimum cost tour visiting all of them (i.e., the traveling
salesman problem), the underlying topology is the complete graph connecting
each pair of vertices.
  
  - `Implicit vs. Explicit` -- – Certain graphs are not explicitly constructed and then
traversed, but built as we use them Because you do not have to store the entire graph, it is often easier to work
with an implicit graph than explicitly construct it prior to analysis.
  
  - `Labeled vs. Unlabeled` -- Each vertex is assigned a unique name or identifier in
a labeled graph to distinguish it from all other vertices. In unlabeled graphs,
no such distinctions have been made.

- Take-Home Lesson: Graphs can be used to model a wide variety of structures
and relationships. Graph-theoretic terminology gives us a language to talk
about them

### Data Structures for Graphs

- Selecting the right graph data structure can have an enormous impact on performance. Your two basic choices are "adjacency matrices" and "adjacency lists"

- `Adjacency Matrix` -- We can represent G using an n × n matrix M, where
element M[i, j] = 1 if (i, j) is an edge of G, and 0 if it isn’t. This allows fast
answers to the question “is (i, j) in G?”, and rapid updates for edge insertion
and deletion.

  Consider a graph that represents the street map of Manhattan in New York
City. Every junction of two streets will be a vertex of the graph. Neighboring junctions are connected by edges. How big is this graph? Manhattan is
basically a grid of 15 avenues each crossing roughly 200 streets. This gives us
about 3,000 vertices and 6,000 edges, since each vertex neighbors four other
vertices and each edge is shared between two vertices. This modest amount
of data should easily and efficiently be stored, yet an adjacency matrix would
have 3,000 × 3,000 = 9,000,000 cells, almost all of them empty! So using this data structures requires space bare in mind.

  There is some potential to save space by packing multiple bits per word
or simulating a triangular matrix on undirected graphs.
  
  - `Adjacency Lists` -- Adjacency Lists: We can more efficiently represent sparse graphs by using
linked lists to store the neighbors adjacent to each vertex. Adjacency lists
require pointers but are not frightening once you have experience with linked
structures.

  Adjacency lists make it harder to verify whether a given edge (i, j) is in G,
since we must search through the appropriate list to find the edge. However,
it is surprisingly easy to design graph algorithms that avoid any need for
such queries.

- `Take-Home Lesson`: Adjacency lists are the right data structure for most
applications of graphs.

### Traversing a Graph

- Perhaps the most fundamental graph problem is to visit every edge and vertex in a
graph in a systematic way. Indeed, all the basic bookkeeping operations on graphs are applications of graph traversal. The key idea behind graph traversal is to mark each vertex when we first visit
it and keep track of what we have not yet completely explored. Although bread
crumbs or unraveled threads have been used to mark visited places in fairy-tale
mazes, we will rely on Boolean flags or enumerated types.

  Each vertex will exist in one of three states:
  - undiscovered – the vertex is in its initial, virgin state
  - discovered – the vertex has been found, but we have not yet checked out all
its incident edges.
  - processed – the vertex after we have visited all its incident edges
  
  We must also maintain a structure containing the vertices that we have discovered but not yet completely processed so that we can check them weather if we discovered or processed them before.

### Breadth-First Search

- The basic breadth-first search algorithm is given below. At some point during the
course of a traversal, every node in the graph changes state from undiscovered to
discovered. In a breadth-first search of an undirected graph, we assign a direction
to each edge, from the discoverer u to the discovered v. We thus denote u to be the
parent of v. Since each node has exactly one parent, except for the root, this defines
a tree on the vertices of the graph

- Most elementary graph algorithms make one or two traversals of the graph while
we update our knowledge of the graph. Properly implemented using adjacency lists,
any such algorithm is destined to be linear, since BFS runs in O(n + m) time on
both directed and undirected graphs

- `Take-Home Lesson`: Breadth-first and depth-first searches provide mechanisms
to visit each edge and vertex of the graph. They prove the basis of most simple,
efficient graph algorithms.

### Depth-First Search

- There are two primary graph traversal algorithms: breadth-first search (BFS) and
depth-first search (DFS). For certain problems, it makes absolutely no difference
which you use, but in others the distinction is crucial.

  There are two primary graph traversal algorithms: breadth-first search (BFS) and
depth-first search (DFS). For certain problems, it makes absolutely no difference
which you use, but in others the distinction is crucial.

  - Queue – By storing the vertices in a first-in, first-out (FIFO) queue, we
explore the oldest unexplored vertices first. Thus our explorations radiate
out slowly from the starting vertex, defining a breadth-first search.

  - Stack – By storing the vertices in a last-in, first-out (LIFO) stack, we explore
the vertices by lurching along a path, visiting a new neighbor if one is available, and backing up only when we are surrounded by previously discovered
vertices. Thus, our explorations quickly wander away from our starting point,
defining a depth-first search.

  A depth-first search can be thought of as a breadth-first search with a stack instead
of a queue.

- Take-Home Lesson: DFS organizes vertices by entry/exit times, and edges
into tree and back edges. This organization is what gives DFS its real power

<br>
<br>

---

<bR>
<Br>

# 6 Weighted Graph Algorithms

> I left the book at here 203 on pdf on the local disk

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


