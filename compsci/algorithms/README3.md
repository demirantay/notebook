[Part 2](./README2.md)

---

<br>

# Sorting Algorithms

- Sorting is nothing but arranging the data in ascending or descending order. The term `sorting` came into picture, as humans realised the importance of searching quickly. 

  There are so many things in our real life that we need to search for, like a particular record in database, roll numbers in merit list, a particular telephone number in telephone directory, a particular page in a book etc. All this would have been a mess if the data was kept unordered and unsorted, but fortunately the concept of sorting came into existence, making it easier for everyone to arrange data in an order, hence making it easier to search.
  
  `Sorting` arranges data in a sequence which makes searching easier.

### Sorting Efficency

- If you ask me, how will I arrange a deck of shuffled cards in order, I would say, I will start by checking every card, and making the deck as I move on. It can take me hours to arrange the deck in order, but that's how I will do it.
  
  Well, thank god, computers don't work like this. Since the beginning of the programming age, computer scientists have been working on solving the problem of sorting by coming up with various different algorithms to sort data.
  
  The two main criterias to judge which algorithm is better than the other have been:
    - Time taken to sort the given data.
    - Memory Space required to do so.


### Different Sorting Alogrithms

- There are many different techniques available for sorting, differentiated by their efficiency and space requirements. Following are some sorting techniques which we will be covering in next few sections. Ofcourse there are lots of other sorting techniques but the following are the most common ones:
  - Bubble Sort
  - Insertion Sort
  - Selection Sort
  - Quick Sort
  - Merge Sort
  - Heap Sort

<br>
<br>

---

<br>
<br>

# Bubble Sort Algorithm

- Bubble Sort is a simple algorithm which is used to sort a given set of `n` elements provided in form of an array with `n` number of elements. Bubble Sort compares all the element one by one and sort them based on their values.

  If the given array has to be sorted in ascending order, then bubble sort will start by comparing the first element of the array with the second element, if the first element is greater than the second element, it will `swap` both the elements, and then move on to compare the second and the third element, and so on
  
  If we have total `n` elements, then we need to repeat this process for `n-1` times.
  
  Sorting takes place by stepping through all the elements one-by-one and comparing it with the adjacent element and swapping them if required.
  
### Implementing Bubble Sort Algorithm 

- Following are the steps involved in bubble sort(for sorting a given array in ascending order):
  - Starting with the first element(index = 0), compare the current element with the next element of the array.
  - If the current element is greater than the next element of the array, swap them.
  - If the current element is less than the next element, move to the next element. Repeat Step 1.
  
- Lets write it in `python`:
  ```python
  def bubble_sort(array):
    
    for i in range(0, len(array), 1):
      
      for j in range(0, len(array), 1):
      
        if (array[j] > array[j+1]):
          # swap the elements
          temp = array[j];
          array[j] = arr[j+1]
          array[j+1] = temp;
          
    return array;
  
  ```
  Although the above logic will sort an unsorted array, still the above algorithm is not efficient because as per the above logic, the outer for loop will keep on executing for `len(array)` for example(6) iterations even if the array gets sorted after the second iteration. So, we can clearly optimize our algorithm.
  
### Optimized Bubble Sort Algorithm 

- To optimize our bubble sort algorithm, we can introduce a `flag` to monitor whether elements are getting swapped inside the inner `for` loop. Hence, in the inner `for` loop, we check whether swapping of elements is taking place or not, everytime.

  If for a particular iteration, no swapping took place, it means the array has been sorted and we can jump out of the `for` loop, instead of executing all the iterations.

- Lets edit the code snippet we used above with `flag`:
  ```python
  def bubble_sort(array):
    
    for i in range(0, len(array), 1):
      
      for j in range(0, len(array), 1):
      
        flag = 0  # new
      
        if (array[j] > array[j+1]):
          # swap the elements
          temp = array[j];
          array[j] = arr[j+1]
          array[j+1] = temp;
          # if swapping happens update flag to 1
          flag = 1
      
      if (flag == 0):
        # if flag comes out 0 which means
        # nothing swapped place end the loop
        break
      
      
    return array;
  ```

<bR>
<br>

--- 

<br>
<br>

# Insertion Sort Algorithm

- Consider you have 10 cards out of a deck of cards in your hand. And they are sorted, or arranged in the ascending order of their numbers. If I give you another card, and ask you to `insert` the card in just the right position, so that the cards in your hand are still sorted. What will you do?

  Well, you will have to go through each card from the starting or the back and find the right position for the new card, comparing it's value with each card. Once you find the right position, you will `insert` the card there.
  
  Similarly, if more new cards are provided to you, you can easily repeat the same process and insert the new cards and keep the cards sorted too. This is exactly how `insertion sort` works too. 
  
- Following are some of the important characteristics of Insertion Sort:
  - It is efficient for smaller data sets, but very inefficient for larger lists.
  - Insertion Sort is adaptive, that means it reduces its total number of steps if a partially sorted array is provided as input, making it efficient.
  - It is better than Selection Sort and Bubble Sort algorithms.
  - It is better than Selection Sort and Bubble Sort algorithms.
  
### Implementing Insertion Sort Algorithm 
  
- Following are the steps involved in insertion sort:
  - 1 - We start by making the second element of the given array, i.e. element at index `1`, the `key`. The `key` element here is the new card that we need to add to our existing sorted set of card
  - 2 - We compare the `key` element with the element(s) before it, in this case, element at index `0`:
    - If the `key` element is less than the first element, we insert the key element before the first element.
    - If the `key` element is greater than the first element, then we insert it after the first element.
  - 3 - Then, we make the third element of the array as key and will compare it with elements to it's left and insert it at the right position.
  - 4 - And we go on repeating this, until the array is sorted.
  
- Lets implement it with `python`:
  ```python
  def insertion_sort(array):
  
  for i in range(1, len(array), 1):
    key = None
    j = i
    
    while (j > 0 and array[j - 1] > array[j]):
      key = array[j]
      array[j] = array[j-1]
      array[j-1] = key
      j--
  ```
  
- `Note:` I didn't neccesairly understand this part but I think that when I implement it on my onw project and study it more than fucking 5 minutes it will make sense.

<br>
<br>

---

<br>
<br>

# Selection Sort Algorithm 

- Selection sort is conceptually the most simplest sorting algorithm. This algorithm will first find the `smallest` element in the array and swap it with the element in the `first` position, then it will find the `second smallest` element and swap it with the element in the `second` position, and it will keep on doing this until the entire array is sorted. It is called selection sort because it repeatedly selects the next-smallest element and swaps it into the right place.

### How Selection Sort Works

- Following are the steps involved in selection sort(for sorting a given array in ascending order):
  - 1 -Starting from the first element, we search the smallest element in the array, and replace it with the element in the first position.
  - 2 - We then move on to the second position, and look for smallest element present in the subarray, starting from index 1, till the last index.
  - 3 - We replace the element at the second position in the original array, or we can say at the first position in the subarray, with the second smallest element.
  - 4 - This is repeated, until the array is completely sorted.

- Note: I am skipping the implementation part because I will be implementing the algorithms in my algorithm implementation repository

<br>
<br>

---

<br>
<br>

# Summary

I am not going to note down rest of the algorithms because you get the idea. Algoritmhs are steps for solving a particular problem with an ending to it. It can be efficent or it can be terrible it is up to you which one you will use. 







