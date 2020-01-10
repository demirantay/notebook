# Sorting and Searching

- The objectives in this chapter are: To be able to explain and implement sequential search and binary search, To be able to explain and implement selection sort, bubble sort, merge sort, quick sort, insertion sort, and shell sort. To understand the idea of hashing as a search technique. To introduce the map abstract data type. To implement the map abstract data type using hashing.

<br>
<br>
<br>

## Searching

- We will now turn our attention to some of the most common problems that arise in computing, those of searching and sorting. In this section we will study searching. We will return to sorting later in the chapter. Searching is the algorithmic process of finding a particular item in a collection of items. A search typically answers either True or False as to whether the item is present. On occasion it may be modified to return where the item is found. For our purposes here, we will simply concern ourselves with the question of membership.

- In Python, there is a very easy way to ask whether an item is in a list of items. We use the `in` operator.
  ```python
  >>> 15 in [1, 3, 4, 5]
  False
  >>>  3 in [3, 5, 6, 1]
  True
  ```
  Even though this is easy to write, an underlying process must be carried out to answer the question. It turns out that there are many different ways to search for the item. What we are interested in here is how these algorithms work and how they compare to one another.
  
### The Sequental Search

- When data items are stored in a collection such as a list, we say that they have a linear or sequential relationship. Each data item is stored in a position relative to the others. In Python lists, these relative positions are the index values of the individual items. Since these index values are ordered, it is possible for us to visit them in sequence. This process gives rise to our first searching technique, the sequential search.

- Starting at the first item in the list, we simply move from item to item, following the underlying sequential ordering until we either find what we are looking for or run out of items. If we run out of items, we have discovered that the item we were searching for was not present.

- Lets look at a code logic for sequential logic with arrays(lists):
  ```python
  def sequential_search(array, item):
      found = False
      
      for i in range(0, len(array), 1):
          if array[i] == item:
              found = True
              break;
          else:
              found = False
              
      return found
  ```
  
### The Binary Search

- It is possible to take greater advantage of the ordered list if we are clever with our comparisons. In the sequential search, when we compare against the first item, there are at most n−1 more items to look through if the first item is not what we are looking for. Instead of searching the list in sequence, a binary search will start by examining the middle item. If that item is the one we are searching for, we are done. If it is not the correct item, we can use the ordered nature of the list to eliminate half of the remaining items. If the item we are searching for is greater than the middle item, we know that the entire lower half of the list as well as the middle item can be eliminated from further consideration. The item, if it is in the list, must be in the upper half. We can then repeat the process with the upper half. Start at the middle item and compare it against what we are looking for. Again, we either find it or split the list in half, therefore eliminating another large part of our possible search space.

- Lets look at a code logic for binary search with python:
  ```python
  # I kinda could not understand the recursion 
  # nature of the binary search. I'll come back.
  ```
  
<br>
<br>
<br>
  
  
## Hashing

- In previous sections we were able to make improvements in our search algorithms by taking advantage of information about where items are stored in the collection with respect to one another. For example, by knowing that a list was ordered, we could search in logarithmic time using a binary search. In this section we will attempt to go one step further by building a data structure that can be searched in 𝑂(1) time. This concept is referred to as hashing.

  A hash table is a collection of items which are stored in such a way as to make it easy to find them later. Each position of the hash table, often called a slot, can hold an item and is named by an integer value starting at 0. For example, we will have a slot named 0, a slot named 1, a slot named 2, and so on. Initially, the hash table contains no items so every slot is empty. We can implement a hash table by using a list with each element initialized to the special Python value `None`
  ```python
  [None, None, None, None, None, None, None, None, None, None]
  ```
  The mapping between an item and the slot where that item belongs in the hash table is called the `hash function`. The hash function will take any item in the collection and return an integer in the range of slot names, between 0 and m-1. Every `hash function` has their own benfits and performance standarts some are better than the others.
  
  A good hash function is what makes a good hash table. Sometimes the hash function can assign, two or more items would need to be in the same slot. This is referred to as a collision (it may also be called a “clash”). Clearly, collisions create a problem for the hashing technique. We will discuss them in detail later.
  
### Hash Functions 

- Given a collection of items, a hash function that maps each item into a unique slot is referred to as a perfect hash function. If we know the items and the collection will never change, then it is possible to construct a perfect hash function. Unfortunately, given an arbitrary collection of items, there is no systematic way to construct a perfect hash function. Luckily, we do not need the hash function to be perfect to still gain performance efficiency

  One way to always have a perfect hash function is to increase the size of the hash table so that each possible value in the item range can be accommodated. This guarantees that each item will have a unique slot. Although this is practical for small numbers of items, it is not feasible when the number of possible items is large. For example, if the items were nine-digit Social Security numbers, this method would require almost one billion slots.
  
- Our goal is to create a hash function that minimizes the number of collisions, is easy to compute, and evenly distributes the items in the hash table.

> I skipped hashing and hash functions in this book. I cannot follow the epxlanations of this book.

---

<br>
<Br>
<br>
  
# Sorting 

