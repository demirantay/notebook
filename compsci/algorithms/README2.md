[Part 1](./README.md)

---

<br>

# Search Algorithms

- Not even a single day pass, when we do not have to search for something in our day to day life, car keys, books, pen, mobile charger and what not. Same is the life of a computer, there is so much data stored in it, that whenever a user asks for some data, computer has to search it's memory to look for the data and make it available to the user. 

  What if you have to write a program to search a given number in an array? How will you do it? Well, to search an element in a given array, there are two popular algorithms available (ofcourse there are more searching algortihms but lets take these two for starting):
  - Linear Search
  - Binary Search
  
### Linear Search

- Linear search is a very basic and simple search algorithm. In Linear search, we search an element or value in a given array by traversing the array from the starting, till the desired element or value is found.

- Features of linear search:
  - It is used for unsorted and unordered small list of elements.
  - It has a time complexity of O(n), which means the time is linearly dependent on the number of elements, which is not bad, but not that good too.
  - It has a very simple implementation.

### Binary Search

- Binary Search is used with sorted array or list. In binary search, we follow the following steps:
  - We start by comparing the element to be searched with the element in the middle of the list/array.
  - If we get a match, we return the index of the middle element.
  - If we do not get a match, we check whether the element to be searched is less or greater than in value than the middle element.
  - If the element/number to be searched is greater in value than the middle number, then we pick the elements on the right side of the middle element(as the list/array is sorted, hence on the right, we will have all the numbers greater than the middle number), and start again from the step 1.
  - If the element/number to be searched is lesser in value than the middle number, then we pick the elements on the left side of the middle element, and start again from the step 1.
  
- Binary Search is useful when there are large number of elements in an array and they are sorted. So a necessary condition for Binary search to work is that the list/array should be sorted.

- Features of Binary Search:
  - It is great to search through large sorted arrays.
  - It has a time complexity of O(log n) which is a very good time complexity. We will discuss this in details
  - It has a simple implementation.


<br>
<br>

---

<br>
<br>

# Linear Search Algorithm 

- Linear search is a very basic and simple search algorithm. In Linear search, we search an element or value in a given array by traversing the array from the starting, till the desired element or value is found.
  
  As we learned in the previous section that the time complexity of Linear search algorithm is `O(n)`, we will analyse the same and see why it is `O(n)` after implementing it.




