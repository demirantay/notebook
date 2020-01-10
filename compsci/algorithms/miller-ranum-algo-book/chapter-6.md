## Trees and Tree Algorithms

- Now that we have studied linear data structures like stacks and queues and have some experience with recursion, we will look at a common data structure called the tree. Trees are used in many areas of computer science, including operating systems, graphics, database systems, and computer networking.

  Tree data structures have many things in common with their botanical cousins. A tree data structure has a root, branches, and leaves. The difference between a tree in nature and a tree in computer science is that a tree data structure has its root at the top and its leaves on the bottom.
  
  Another example of a tree structure that you probably use every day is a file system. In a file system, directories, or folders, are structured as a tree. The file system tree has much in common with the biological classification tree. You can follow a path from the root to any directory. That path will uniquely identify that subdirectory (and all the files in it). Another important property of trees, derived from their hierarchical nature, is that you can move entire sections of a tree (called a subtree) to a different position in the tree without affecting the lower levels of the hierarchy.
  
### Vocabulary and definitions

- `Node` -- A node is a fundamental part of a tree. It can have a name, which we call the “key.” A node may also have additional information. We call this additional information the “payload.” While the payload information is not central to many tree algorithms, it is often critical in applications that make use of trees.
- `Edge` -- An edge is another fundamental part of a tree. An edge connects two nodes to show that there is a relationship between them. Every node (except the root) is connected by exactly one incoming edge from another node. Each node may have several outgoing edges.
- `Root` -- The root of the tree is the only node in the tree that has no incoming edges.
- `Path` -- A path is an ordered list of nodes that are connected by edges. For example, Mammal → Carnivora → Felidae → Felis → Domestica is a path.
- `Children` -- The set of nodes 𝑐 that have incoming edges from the same node to are said to be the children of that node.
- `Parent` -- A node is the parent of all the nodes it connects to with outgoing edges.
- `Sibling` -- Nodes in the tree that are children of the same parent are said to be siblings.
- `Subtree` -- A subtree is a set of nodes and edges comprised of a parent and all the descendants of that parent.
- `Leaf Node` -- A leaf node is a node that has no children
- `Level` -- The level of a node 𝑛 is the number of edges on the path from the root node to 𝑛.
- `Height` -- The height of a tree is equal to the maximum level of any node in the tree.

- `Tree Definition` -- A tree consists of a set of nodes and a set of edges that connect pairs of nodes. A tree has the following properties:
  - One node of the tree is designated as the root node.
  - Every node 𝑛, except the root node, is connected by an edge from exactly one other node 𝑝, where 𝑝 is the parent of 𝑛.
  - A unique path traverses from the root to each node.
  - If each node in the tree has a maximum of two children, we say that the tree is a binary tree.
  
###
