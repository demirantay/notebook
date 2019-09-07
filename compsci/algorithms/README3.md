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

# Bubble Sort 

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

# Insertion Sort 
