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

  Stacks and queues can be effectively implemented using either arrays or linked
lists. 

### Dictionaries

- The dictionary data type permits access to data items by content. You stick an
item into a dictionary so you can find it when you need it. The primary operations of dictionary support are:
  - Search(D,k) – Given a search key k, return a pointer to the element in dictionary D whose key value is k, if one exists.
  - Insert(D,x) – Given a data item x, add it to the set in the dictionary D.
  - Delete(D,x) – Given a pointer to a given data item x in the dictionary D,
remove it from D.

  A basic dictioanry example in python:
  ```python
  dictname = {
    "key": value,
    "key2": value2,
  }
  ```

### Binary Search Trees

- We have seen data structures that allow fast search or flexible update, but not fast
search and flexible update. Unsorted, doubly-linked lists supported insertion and
deletion in O(1) time but search took linear time in the worse case. Sorted arrays
support binary search and logarithmic query times, but at the cost of linear-time
update.

  Binary search requires that we have fast access to two elements—specifically
the median elements above and below the given node. To combine these ideas, we
need a “linked list” with two pointers per node. This is the basic idea behind binary
search trees

- `Implementing Binary Search Trees` -- Binary tree nodes have left and right pointer fields, an (optional) parent pointer,
and a data field. so a parent node and a left and right child nodes. This gives the data structure a tree like look. 
  ```
       o
      / \
     o   o
  ```

- `How Good Are Binary Search Trees?` -- When implemented using binary search trees, all three dictionary operations take
O(h) time, where h is the height of the tree. The smallest height we can hope for
occurs when the tree is perfectly balanced, where h = ⌈log n⌉. This is very good,
but the tree must be perfectly balanced.

- `Balanced Search Trees` -- Random search trees are usually good. But if we get unlucky with our order of
insertion, we can end up with a linear-height tree in the worst case. This worst
case is outside of our direct control, since we must build the tree in response to the
requests given by our potentially nasty user

  What would be better is an insertion/deletion procedure which adjusts the tree a
little after each insertion, keeping it close enough to be balanced so the maximum
height is logarithmic.

  Take-Home Lesson: Picking the wrong data structure for the job can be
disastrous in terms of performance. Identifying the very best data structure
is usually not as critical, because there can be several choices that perform
similarly

### Priority Queues 

- Many algorithms process items in a specific order. For example, suppose you must
schedule jobs according to their importance relative to other jobs. Scheduling the jobs requires sorting them by importance, and then evaluating them in this sorted
order.

  Priority queues are data structures that provide more flexibility than simple
sorting, because they allow new elements to enter a system at arbitrary intervals.
It is much more cost-effective to insert a new job into a priority queue than to
re-sort everything on each such arrival.


  Take-Home Lesson: Building algorithms around data structures such as dictionaries and priority queues leads to both clean structure and good performance.

### Hashing and Strings

- Hash tables are a very practical way to maintain a dictionary. They exploit the fact
that looking an item up in an array takes constant time once you have its index. A
hash function is a mathematical function that maps keys to integers. We will use
the value of our hash function as an index into an array, and store our item at that
position.

- `Collision Resolution` -- No matter how good our hash function is, we had better be prepared for collisions,
because two distinct keys will occasionally hash to the same value. Chaining is the
easiest approach to collision resolution

  Pragmatically, a hash table is often the best data structure to maintain a dictionary. The applications of hashing go far beyond dictionaries

- `Duplicate Detection Via Hashing` -- The key idea of hashing is to represent a large object (be it a key, a string, or a
substring) using a single number. The goal is a representation of the large object
by an entity that can be manipulated in constant time, such that it is relatively
unlikely that two different large objects map to the same value.

  Hashing has a variety of clever applications beyond just speeding up search. I
once heard Udi Manber—then Chief Scientist at Yahoo—talk about the algorithms
employed at his company. The three most important algorithms at Yahoo, he said,
were hashing, hashing, and hashing.

- Optimizing hash table performance is surprisingly complicated for such a conceptually simple data structure. The importance of short runs in open addressing
has to more sophisticated schemes than sequential probing for optimal hash table
performance. 

### Specialized Data Structures

- The basic data structures described thus far all represent an unstructured set of
items so as to facilitate retrieval operations. These data structures are well known
to most programmers. Not as well known are data structures for representing more structured or specialized kinds of objects, such as points in space, strings, and
graphs

  The design principles of these data structures are the same as for basic objects.
There exists a set of basic operations we need to perform repeatedly. We seek a data
structure that supports these operations very efficiently Here are some examples:
  - String data structures
  - Geometric data structures
  - Graph data structures
  - Set data structures

<br>
<br>

---

<bR>
<Br>
  
# 4 Sorting and Searching

- Typical computer science students study the basic sorting algorithms at least three
times before they graduate: first in introductory programming, then in data structures, and finally in their algorithms course. Why is sorting worth so much attention? There are several reasons:
  - Sorting is the basic building block that many other algorithms are built
around. By understanding sorting, we obtain an amazing amount of power
to solve other problems.
  
  - Most of the interesting ideas used in the design of algorithms appear in the
context of sorting, such as divide-and-conquer, data structures, and randomized algorithms.
  
  - Computers have historically spent more time sorting than doing anything
else. A quarter of all mainframe cycles were spent sorting data [Knu98]. Sorting remains the most ubiquitous combinatorial algorithm problem in practice
  
  - Sorting is the most thoroughly studied problem in computer science. Literally dozens of different algorithms are known, most of which possess some
particular advantage over all other algorithms in certain situations.

- Many important problems can be reduced to sorting, so we can use our clever
O(n log n) algorithms to do work that might otherwise seem to require a quadratic
algorithm. An important algorithm design technique is to use sorting as a basic
building block, because many other problems become easy once a set of items is
sorted.

- It is a rare application where the running time of sorting proves to be the bottleneck, especially a bottleneck that could have
otherwise been removed using more clever algorithmics. Never be afraid to spend
time sorting, provided you use an efficient sorting routine

  Take-Home Lesson: Sorting lies at the heart of many algorithms. Sorting the
data is one of the first things any algorithm designer should try in the quest
for efficiency.

### Pragmatics of Sorting

- We have seen many algorithmic applications of sorting, and we will see several
efficient sorting algorithms. One issue stands between them: in what order do we
want our items sorted?
The answers to this basic question are application-specific. Consider the following considerations:
  - Increasing or decreasing order?
  - Sorting just the key or an entire record?
  - What should we do with equal keys?
  - What about non-numerical data? (sorting strings etc) - Alphabetizing is the sorting of text strings

### Sorting Algorithms 

- `Heap Sort: Fast Sorting via Data Structures ` -- Heapsort is a great sorting algorithm. It is simple to program; indeed, the
complete implementation has been presented above. It runs in worst-case O(n log n)
time, which is the best that can be expected from any sorting algorithm. It is an inplace sort, meaning it uses no extra memory over the array containing the elements
to be sorted. Although other algorithms prove slightly faster in practice, you won’t
go wrong using heapsort for sorting data that sits in the computer’s main memory. Priority queues are very useful data structures for this algorithm

- `Mergesort: Sorting by Divide-and-Conquer` -- Recursive algorithms reduce large problems into smaller ones. A recursive approach
to sorting involves partitioning the elements into two groups, sorting each of the
smaller problems recursively, and then interleaving the two sorted lists to totally
order the elements. This algorithm is called mergesort,  Mergesort is a great algorithm for sorting linked lists, because it does not rely on
random access to elements as does heapsort or quicksort. Its primary disadvantage
is the need for an auxilliary buffer when sorting arrays. It is easy to merge two
sorted linked lists without using any extra space, by just rearranging the pointers. Mergesort is a classic divide-and-conquer algorithm.

- `Quicksort: Sorting by Randomization` -- If you can implement quicksort extremly perfect What we can say is that experiments show that where a properly implemented
quicksort is implemented well, it is typically 2-3 times faster than mergesort or
heapsort. The primary reason is that the operations in the innermost loop are
simpler

- `Take-Home Lesson`: Sorting can be used to illustrate most algorithm design
paradigms. Data structure techniques, divide-and-conquer, randomization, and
incremental construction all lead to efficient sorting algorithms

### Binary Search and Related Algorithms

- Binary search is a fast algorithm for searching in a sorted array of keys S. To search
for key q, we compare q to the middle key S[n/2]. If q appears before S[n/2], it
must reside in the top half of S; if not, it must reside in the bottom half of S. By
repeating this process recursively on the correct half, we locate the key in a total
of ⌈lg n⌉ comparisons—a big win over the n/2 comparisons expect using sequential
search

- `Take-Home Lesson`: Binary search and its variants are the quintessential
divide-and-conquer algorithms.

### Divide-and-Conquer

- One of the most powerful techniques for solving problems is to break them down
into smaller, more easily solved pieces. Smaller problems are less overwhelming, and
they permit us to focus on details that are lost when we are studying the entire
problem. A recursive algorithm starts to become apparent when we can break
the problem into smaller instances of the same type of problem.

  Two important algorithm design paradigms are based on breaking problems
down into smaller problems. In Chapter 8, we will see dynamic programming,
which typically removes one element from the problem, solves the smaller problem,
and then uses the solution to this smaller problem to add back the element in the
proper way. Divide-and-conquer instead splits the problem in (say) halves, solves
each half, then stitches the pieces back together to form a full solution.

  Divide-and-conquer is a design technique with many important algorithms to
its credit, including mergesort, the fast Fourier transform, and Strassen’s matrix
multiplication algorithm. Beyond binary search and its many variants, however, I
find it to be a difficult design technique to apply in practice.

- `Chapter Notes` -- The most interesting sorting algorithms that have not been discussed in this section
include shellsort, which is a substantially more efficient version of insertion sort,
and radix sort, an efficient algorithm for sorting strings. You can learn more about
these and every other sorting algorithm by browsing through Knuth [Knu98], with
hundreds of pages of interesting material on sorting. This includes external sorting,
the subject of this chapter’s legal war story

  Several other algorithms texts provide more substantive coverage of divideand-conquer algorithms, including [CLRS01, KT06, Man89]. See [CLRS01] for an
excellent overview of the master theorem.

<br>
<br>

---

<bR>
<Br>
  
