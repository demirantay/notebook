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
  
  
