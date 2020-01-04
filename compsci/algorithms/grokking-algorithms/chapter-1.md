# Grokking Algortihms:

An illustrated guide for programmers and other curious people

<br>

# Introduction to Algorithms

- An algorithm is a set of instructions for accomplishing a task. Every piece of code could be called an algorithm,

### Binary Search

- Suppose you’re searching for a person in the phone book (what an old- fashioned sentence!). heir name starts with K. You could start at the beginning and keep lipping pages until you get to the Ks. But you’re more likely to start at a page in the middle, because you know the Ks are going to be near the middle of the phone book.

  Or suppose you’re searching for a word in a dictionary, and it starts with O. Again, you’ll start near the middle.
  
  Now suppose you log on to Facebook. When you do, Facebook
has to verify that you have an account on the site. So, it needs to search for your username in its database. Suppose your username is karlmageddon. Facebook could start from the As and search for your name—but it makes more sense for it to begin somewhere in the middle.

  This is a search problem. And all these cases use the same algorithm to solve the problem: binary search.
  
  Binary search is an algorithm; its input is a sorted list of elements (I’ll explain later why it needs to be sorted). If an element you’re looking for is in that list, binary search returns the position where it’s located. Otherwise, binary search returns `null`.
  
  Here’s an example of how binary search works. I’m thinking of a number between 1 and 100.
  
  You have to try to guess my number in the fewest tries possible. With every guess, I’ll tell you if your guess is too low, too high, or correct. Suppose you start guessing like this: 1, 2, 3, 4 .... Here’s how it would go.
  
  This is simple search (maybe stupid search would be a better term). With each guess, you’re eliminating only one number. If my number was 99, it could take you 99 guesses to get there!
  
### A better way to search

- Heres a better technique start with 50.

  Too low, but you just eliminated half the numbers! Now you know that 1–50 are all too low. Next guess: 75.

  Too high, but again you cut down half the remaining numbers! With binary search, you guess the middle number and eliminate half the remaining numbers every time. Next is 63 (halfway between 50 and 75). This is binary search. You just learned your first algorithm.
  
  Suppose you’re looking for a word in the dictionary. he dictionary has 240,000 words. In the worst case, how many steps do you think each search will take?
  
  Simple search could take 240,000 steps if the word you’re looking for is the very last one in the book. With each step of binary search, you cut the number of words in half until you’re let with only one word. So binary search will take 18 steps—a big diference
  
- `Logarithms` -- You may not remember what logarithms are, but you probably know what exponentials are. log10 100 is like asking, “How many 10s do we multiply together to get 100?” he answer is 2: 10 × 10. So log10 100 = 2. Logs are the lip of exponentials.

  In this book, when I talk about running time in Big O notation (explained a little later), log always means log2. When you search for an element using simple search, in the worst case you might have to look at every single element. So for a list of 8 numbers, you’d have to check 8 numbers at most. For binary search, you have to check log n elements in the worst case. For a list of 8 elements, log 8 == 3, because 23 == 8. So for a list of 8 numbers, you would have to check 3 numbers at most. For a list of 1,024 elements, log 1,024 = 10, because 210 == 1,024. So for a list of 1,024 numbers, you’d have to check 10 numbers at most
  
- `Running Time` -- Any time I talk about an algorithm, I’ll discuss its running time. Generally you want to choose the most eicient algorithm— whether you’re trying to optimize for time or space.

  Back to binary search. How much time do you save by using it? Well, the irst approach was to check each number, one by one. If this is a list of 100 numbers, it takes up to 100 guesses. If it’s a list of 4 billion numbers, it takes up to 4 billion guesses. So the maximum number of guesses is the same as the size of the list. his is called linear time.

  Binary search is diferent. If the list is 100 items long, it takes at most 7 guesses. If the list is 4 billion items, it takes at most 32 guesses. Powerful, eh? Binary search runs in logarithmic time (or log time, as the natives call it

### Big O Notation

- Big O notation is special notation that tells you how fast an algorithm is. Who cares? Well, it turns out that you’ll use other people’s algorithms oten—and when you do, it’s nice to understand how fast or slow they are

- `Algorithm running times grow at diferent rates` -- it’s not enough to know how long an algorithm takes to run—you need to know how the running time increases as the list size increases. hat’s where Big O notation comes in.

  Big O notation tells you how fast an algorithm is. For example, suppose you have a list of size n. Simple search needs to check each element, so it will take n operations. he run time in Big O notation is O(n). Where are the seconds? here are none—Big O doesn’t tell you the speed in seconds. Big O notation lets you compare the number of operations. It tells you how fast the algorithm grows.
  
  This tells you the number of operations an algorithm will make. It’s called Big O notation because you put a “big O” in front of the number of operations (it sounds like a joke, but it’s true!).

- `Big O establishes a worst-case run time` -- Suppose you’re using simple search to look for a person in the phone book. You know that simple search takes O(n) time to run, which means in the worst case, you’ll have to look through every single entry in your phone book. In this case, you’re looking for Adit. his guy is the irst entry in your phone book. So you didn’t have to look at every entry—you found it on the irst try. Did this algorithm take O(n) time? Or did it take O(1) time because you found the person on the irst try?
  
  Simple search still takes O(n) time. In this case, you found what you were looking for instantly. hat’s the best-case scenario. But Big O notation is about the worst-case scenario. So you can say that, in the worst case, you’ll have to look at every entry in the phone book once. hat’s O(n) time. It’s a reassurance—you know that simple search will never be slower than O(n) time.
  
- `Some common Big O run times` -- Here are ive Big O run times that you’ll encounter a lot, sorted from fastest to slowest:
  - `O(log n)`, also known as log time. Example: Binary search.
  - `O(n)`, also known as linear time. Example: Simple search.
  - `O(n * log n)`. Example: A fast sorting algorithm, like quicksort (coming up in chapter 4).
  - `O(n2)`. Example: A slow sorting algorithm, like selection sort (coming up in chapter 2).
  - `O(n!)`. Example: A really slow algorithm, like the traveling salesperson (coming up next!).
  
- There are other run times, too, but these are the ive most common.

  For now, the main takeaways are as follows:
  - Algorithm speed isn’t measured in seconds, but in growth of the number of operations.
  - Instead, we talk about how quickly the run time of an algorithm increases as the size of the input increases.
  - Run time of algorithms is expressed in Big O notation.
  - O(log n) is faster than O(n), but it gets a lot faster as the list of items you’re searching grows.
  
- `The traveling salesperson` -- You might have read that last section and thought, “here’s no way I’ll ever run into an algorithm that takes O(n!) time.” Well, let me try to prove you wrong! Here’s an example of an algorithm with a really bad running time. his is a famous problem in computer science, because its growth is appalling and some very smart people think it can’t be improved. It’s called the traveling salesperson problem. You have a salesperson.

  The salesperson has to go to ive cities.T his salesperson, whom I’ll call Opus, wants to hit all ive cities while traveling the minimum distance. Here’s one way to do that: look at every possible order in which he could travel to the cities.
  
  He adds up the total distance and then picks the path with the lowest distance. here are 120 permutations with 5 cities, so it will take 120 operations to solve the problem for 5 cities. For 6 cities, it will take 720 operations (there are 720 permutations). For 7 cities, it will take 5,040 operations!
  
  In general, for n items, it will take n! (n factorial) operations to compute the result. So this is O(n!) time, or factorial time. It takes a lot of operations for everything except the smallest numbers. Once you’re dealing with 100+ cities, it’s impossible to calculate the answer in time—the Sun will collapse first.
  
  This is a terrible algorithm! Opus should use a diferent one, right? But he can’t. his is one of the unsolved problems in computer science. The best we can do is come up with an approximate solution;
  
- `Recap` -- 
  - Binary search is a lot faster than simple search.
  - O(log n) is faster than O(n), but it gets a lot faster once the list of items you’re searching through grows.
  - Algorithm speed isn’t measured in seconds.
  - Algorithm times are measured in terms of growth of an algorithm.
  - Algorithm times are written in Big O notation.
  
<Br>
 
---

<Br>
  
# Selection Sort
  
- In this chapter you learn about arrays and linked lists—two of the most basic data structures. They’re used absolutely everywhere. You already used arrays in chapter 1, and you’ll use them in almost every chapter in this book. Arrays are a crucial topic, so pay attention! But sometimes it’s better to use a linked list instead of an array. This chapter explains the pros and cons of both so you can decide which one is right for your algorithm.

  You learn your irst sorting algorithm. A lot of algo- rithms only work if your data is sorted. Remember binary search? You can run binary search only on a sorted list of elements
  
### How memory works

- Imagine you go to a show and need to check your things. A chest of drawers is available. Each drawer can hold one element. You want to store two things, so you ask for two drawers. You store your two things here. And you’re ready for the show! his is basically how your computer’s memory works. Your computer looks like a giant set of drawers, and each drawer has an address. 

  fe0/feeb is the address of a slot in memory. Each time you want to store an item in memory, you ask the computer for some space, and it gives you an address where you can store your item. If you want to store multiple items, there are two basic ways to do so: arrays and lists
  
  There isn’t one right way to store items for every use case, so it’s important to know the diferences.
  
### Arrays and Linked Lists

- adding new items to an array can be a big pain. If you’re out of space and need to move to a new spot in memory every time, adding a new item will be really slow. One easy ix is to “hold seats”: even if you have only 3 items in your task list, you can ask the computer for 10 slots, just in case. hen you can add 10 items to your task list without having to move. his is a good workaround, but you should be aware of a couple of downsides:

  - You may not need the extra slots that you asked for, and then that memory will be wasted. You aren’t using it, but no one else can use it either.
  - You may add more than 10 items to your task list and have to move anyway.
  
  So it’s a good workaround, but it’s not a perfect solution. Linked lists solve this problem of adding items.

- `Linked Lists` -- With linked lists, your items can be anywhere in memory. Each item stores the address of the next item in the list. A bunch of random memory addresses are linked together. If linked lists are so much better at inserts, what are arrays good for?

- `Arrays` -- Websites with top-10 lists use a scummy tactic to get more page views. Instead of showing you the list on one page, they put one item on each page and make you click Next to get to the next item in the list. For example, Top 10 Best TV Villains won’t show you the entire list on one page. Instead, you start at #10 (Newman), and you have to click Next on each page to reach #1 (Gustavo Fring). his technique gives the websites 10 whole pages on which to show you ads, but it’s boring to click Next 9 times to get to #1. It would be much better if the whole list was on one page and you could click each person’s name for more info.

  Linked lists have a similar problem. Suppose you want to read the last item in a linked list. You can’t just read it, because you don’t know what address it’s at. Instead, you have to go to item #1 to get the address for item #2. hen you have to go to item #2 to get the address for item #3. And so on, until you get to the last item. Linked lists are great if you’re going to read all the items one at a time: you can read one item, follow the address to the next item, and so on. But if you’re going to keep jumping around, linked lists are terrible.
  
  Arrays are diferent. You know the address for every item in your array.
  
  Arrays are great if you want to read random elements, because you can look up any element in your array instantly. With a linked list, the elements aren’t next to each other,
so you can’t instantly calculate the position of the ith element in memory

- `Deletions` -- What if you want to delete an element? Again, lists are better, because you just need to change what the previous element points to. With arrays, everything needs to be moved up when you delete an element.

  Which are used more: arrays or lists? Obviously, it depends on the use case. But arrays see a lot of use because they allow random access. here are two diferent types of access: random access and sequential access. Sequential access means reading the elements one by one, starting
at the irst element. Linked lists can only do sequential access. If you want to read the 10th element of a linked list, you have to read the irst 9 elements and follow the links to the 10th element. Random access means you can jump directly to the 10th element. You’ll frequently hear me say that arrays are faster at reads. his is because they provide random access. A lot of use cases require random access, so arrays are used a lot. Arrays and lists are used to implement other data structures, too 

### Selection Sort

- Let’s put it all together to learn your second algorithm: selection sort. Suppose you have a bunch of music on your computer. For each artist, you have a play count. You want to sort this list from most to least played, so that you can rank your favorite artists. How can you do it?

  One way is to go through the list and ind the most-played artist. Add that artist to a new list. Do it again to ind the next-most-played artist. Keep doing this, and you’ll end up with a sorted list.
  
  Let’s put on our computer science hats and see how long this will take to run. Remember that O(n) time means you touch every element in a list once. For example, running simple search over the list of artists means looking at each artist once.
  
  To ind the artist with the highest play count, you have to check each item in the list. his takes O(n) time, as you just saw
  
  Sorting algorithms are very useful. Now you can sort
  - Names in a phone book
  - Travel dates
  - Emails (newest to oldest)
  
  Selection sort is a neat algorithm, but it’s not very fast. Quicksort is a faster sorting algorithm that only takes O(n log n) time.
  
- `Recap` -- 
  - Your computer’s memory is like a giant set of drawers.
  - When you want to store multiple elements, use an array or a list.
  - With an array, all your elements are stored right next to each other.
  - With a list, elements are strewn all over, and one element stores the address of the next one.
  - Arrays allow fast reads.
  - Linked lists allow fast inserts and deletes.
  - All elements in the array should be the same type (all ints, all doubles, and so on).
