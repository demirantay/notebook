# Recursion

- In this chapter You learn about recursion. Recursion is a coding technique used in many algorithms. It’s a building block for understanding later chapters in this book.
  
  You learn how to break a problem down into a base case and a recursive case. The divide-and- conquer strategy (chapter 4) uses this simple concept to solve hard problems.
  
### Recursion

- Suppose you’re digging through your grandma’s attic and come across a mysterious locked suitcase. Grandma tells you that the key for the suitcase is probably in this other box.

  This box contains more boxes, with more boxes inside those boxes. he key is in a box somewhere. What’s your algorithm to search for the key? hink of an algorithm before you read on. Here’s one approach.
  
  - 1 - Make a pile of boxes to look through.
  - 2 - Grab a box and look through 
  - 3 - If you find a box,add it to the pile to look through later.
  - 4 - If you ind a key, you’re done!
  - 5 - Repeat.
  
  Here’s an alternate approach.
  
  - 1 - Look through the box.
  - 2 - If you find a box,go to step 1.
  - 3 - If you ind a key, you’re done!
  
  Which approach seems easier to you? he irst approach uses a `while`
loop. While the pile isn’t empty, grab a box and look through it:

  The second way uses recursion. Recursion is where a function calls itself.
  
  Both approaches accomplish the same thing, but the second approach is clearer to me. Recursion is used when it makes the solution clearer. here’s no performance beneit to using recursion; in fact, loops are sometimes better for performance. “Loops may achieve a performance gain for your program. Recursion may achieve a performance gain for your programmer. Choose which is more important in your situation!”
  
### Base Case and Recursive Case

- When you write a recursive function, you have to tell it when to stop recursing. hat’s why every recursive function has two parts: the base case, and the recursive case. he recursive case is when the function calls itself. he base case is when the function doesn’t call itself again ... so it doesn’t go into an ininite loop.

  Let’s add a base case to the countdown function:
  ```python
  def countdown(i): print i
    if i <= 0: # Base case 
      return
    else:      # Recursive case 
      countdown(i-1)
  ```
  
### The Stack

- call stack. It’s an important concept in programming. he call stack is an important concept in general programming, and it’s also important to understand when using recursion.

  This is the big idea behind this section: when you call a function from another function, the calling function is paused in a partially completed state. All the values of the variables for that function are still stored in memory. Now that you’re done with the greet2 function, you’re back to the greet function, and you pick up where you let of.

- `Recap`:
  - Recursion is when a function calls itself.
  - Every recursive function has two cases: the base case and the recursive case.
  - A stack has two operations: push and pop.
  - All function calls go onto the call stack.
  - The call stack can get very large, which takes up a lot of memory.
  
  <br>
  <br>
  
  ---
  
  <br>
  <br>
  
  # Quicksort
  
  - You learned all about recursion in the last chapter. his chapter focuses on using your new skill to solve problems. We’ll explore divide and conquer (D&C), a well-known recursive technique for solving problems. D&C gives you a new way to think about solving problems. D&C is another tool in your toolbox. When you get a new problem, you don’t have to be stumped. Instead, you can ask, “Can I solve this if I use divide and conquer?”

  At the end of the chapter, you’ll learn your irst major D&C algorithm: quicksort. Quicksort is a sorting algorithm, and a much faster one than selection sort 
  
  D&C algorithms are recursive algorithms. To solve a problem using D&C, there are two steps:
    - 1 - Figure out the base case. his should be the simplest possible case.
    - 2 - Divide or decrease your problem until it becomes the base case.
    
 
  To recap, here’s how D&C works:
    - 1 - Figure out a simple case as the base case.
    - 2 - Figure out how to reduce your problem and get to the base case.
    
  ### Quicksort
  
  - Quicksort is a sorting algorithm. It’s much faster than selection sort and is frequently used in real life. For example, the C standard library has a function called qsort, which is its implementation of quicksort. Quicksort also uses D&C.
  
    Remember, you’re using D&C. So you want to break down this array until you’re at the base case. Here’s how quicksort works. First, pick an element from the array. his element is called the pivot.
    
    We’ll talk about how to pick a good pivot later. For now, let’s say the irst item in the array is the pivot. Now ind the elements smaller than the pivot and the elements larger than the pivot. his is called partitioning. Now you have
    - A sub-array of all the numbers less than the pivot
    - The pivot
    - A sub-array of all the numbers greater than the pivot
    
   The two sub-arrays aren’t sorted. hey’re just partitioned. But if they
were sorted, then sorting the whole array would be pretty easy.

  If the sub-arrays are sorted, then you can combine the whole thing like this—left array + pivot + right array—and you get a sorted array.
  
### Big O Notation revisited

- Quicksort is unique because its speed depends on the pivot you choose. Check out selection sort, which you learned in chapter 2. It’s O(n2). hat’s a pretty slow algorithm.
  
  There’s another sorting algorithm called merge sort, which is
O(n log n). Much faster! Quicksort is a tricky case. In the worst case, quicksort takes O(n2) time. It’s as slow as selection sort! But that’s the worst case. In the average case, quicksort takes O(n log n) time. 
  - What do worst case and average case mean here?
  - If quicksort is O(n log n) on average, but merge sort is O(n log n) always, why not use merge sort? Isn’t it faster?

- `merge sort vs quick sort` -- You usually ignore that constant, because if two algorithms have diferent Big O times, the constant doesn’t matter. Take binary search and simple search, for example. Suppose both algorithms had these constants.

  You might say, “Wow! Simple search has a constant of 10 milliseconds, but binary search has a constant of 1 second. Simple search is way faster!” Now suppose you’re searching a list of 4 billion elements. Here are the times.
  
  As you can see, binary search is still way faster. hat constant didn’t make a diference at all. But sometimes the constant can make a diference. Quicksort versus merge sort is one example. Quicksort has a smaller constant than merge sort. So if they’re both O(n log n) time, quicksort is faster. And quicksort is faster in practice because it hits the average case way more oten than the worst case.
  
- `average case vs. worst case` -- The performance of quicksort heavily depends on the pivot you choose.
Suppose you always choose the first element as the pivot.  In the worst case, the stack size is
O(n). In the best case, the stack size is O(log n).  Quicksort
is one of the fastest sorting algorithms out there, and it’s a very good
example of D&C.

- `recap` --
  - • D&C works by breaking a problem down into smaller and smaller
pieces. If you’re using D&C on a list, the base case is probably an
empty array or an array with one element.
  - If you’re implementing quicksort, choose a random element as the
pivot. The average runtime of quicksort is O(n log n)!
  - The constant in Big O notation can matter sometimes. That’s why
quicksort is faster than merge sort.
  - The constant almost never matters for simple search versus binary
search, because O(log n) is so much faster than O(n) when your list
gets big

<Br>
<br>
  
---

<br>
<br>

# Hash Tables

- You learn about hash tables, one of the most
useful basic data structures. Hash tables have many
uses; this chapter covers the common use cases.

- Suppose you work at a grocery store. When a customer
buys produce, you have to look up the price in a book. If
the book is unalphabetized, it can take you a long time to
look through every single line for apple. You’d be doing
simple search from chapter 1, where you have to look at
every line. Do you remember how long that would take?
O(n) time. If the book is alphabetized, you could run
binary search to find the price of an apple. That would
only take O(log n) time. As a reminder, there’s a big difference between O(n) and O(log n) time!

  You already know that binary search is darn fast. But as a cashier,
looking things up in a book is a pain, even if the book is sorted. You can
feel the customer steaming up as you search for items in the book. What
you really need is a buddy who has all the names and prices memorized.
Then you don’t need to look up anything: you ask her, and she tells you
the answer instantly

  Your buddy Maggie can give you the price in O(1) time for any item, no
matter how big the book is. She’s even faster than binary search.

  What a wonderful person! How do you get a “Maggie”? You could implement this book as
an array.
  ```
  [("eggs", 12), ("milk", 54), ("bread", 2)]
  ```
  Each item in the array is really two items: one is the name of a kind of
produce, and the other is the price. If you sort this array by name, you
can run binary search on it to find the price of an item. So you can find
items in O(log n) time. But you want to find items in O(1) time. That is,
you want to make a “Maggie.” That’s where hash functions come in.

### Hash Functions

- A hash function is a function where you put in a string1
 and you get
back a number. (mostly you enter the key as string and get the index of the key in the array as an int). Your hash function:
  -  It needs to be consistent. For example, suppose you put in “apple” and
get back “4”. Every time you put in “apple”, you should get “4” back.
Without this, your hash table won’t work.
  - • It should map different words to different numbers. For example, a
hash function is no good if it always returns “1” for any word you put
in. In the best case, every different word should map to a different
number.

- The hash function tells you exactly where the price is stored, so you
don’t have to search at all! This works because
  - • The hash function consistently maps a name to the same index. Every
time you put in “avocado”, you’ll get the same number back. So you
can use it the first time to find where to store the price of an avocado,
and then you can use it to find where you stored that price
  - The hash function maps different strings to different indexes.
“Avocado” maps to index 4. “Milk” maps to index 0. Everything maps
to a different slot in the array where you can store its price.

- You just built a “Maggie”! Put a hash function and an array together,
and you get a data structure called a hash table. A hash table is the first
data structure you’ll learn that has some extra logic behind it. Arrays
and lists map straight to memory, but hash tables are smarter. They use
a hash function to intelligently figure out where to store elements.
  
  Hash tables are probably the most useful complex data structure
you’ll learn. They’re also known as hash maps, maps, dictionaries, and
associative arrays. And hash tables are fast!

  A hash table has keys and values. In the book hash, the names of
produce are the keys, and their prices are the values. A hash table maps
keys to values
  
### Use Cases

- Hash tables are used everywhere. This section will show you a few
use cases.

- `Using Hash tables for lookups` -- Your phone has a handy phonebook built in.
Each name has a phone number associated with it. Suppose you want to build a phone book like this. You’re mapping
people’s names to phone numbers.

  Hash tables are used for lookups on a much larger scale. For example,
suppose you go to a website like http://adit.io. Your computer has to
translate adit.io to an IP address. For any website you go to, the address has to be translated to an IP
address Wow, mapping a web address to an IP address? Sounds like a perfect
use case for hash tables! This process is called DNS resolution.

- `Preventing duplicate entries` -- Suppose you’re running a voting booth. Naturally, every person can
vote just once. How do you make sure they haven’t voted before? When
someone comes in to vote, you ask for their full name. Then you check
it against the list of people who have voted.

- `Using hash tables as a cache` -- One final use case: caching. If you work on a website, you
may have heard of caching before as a good thing to do.
Here’s the idea

  Suppose you have a niece who keeps asking you about planets. “How far
is Mars from Earth?” “How far is the Moon?” “How far is Jupiter?” Each
time, you have to do a Google search and give her an answer. It takes 

  a couple of minutes. Now, suppose she always asked, “How far is the
Moon?” Pretty soon, you’d memorize that the Moon is 238,900 miles
away. You wouldn’t have to look it up on Google … you’d just remember
and answer. This is how caching works: websites remember the data
instead of recalculating it.

  If you’re logged in to Facebook, all the content you see is tailored just
for you. Each time you go to facebook.com, its servers have to think
about what content you’re interested in. But if you’re not logged in to
Facebook, you see the login page. Everyone sees the same login page.
Facebook is asked the same thing over and over: “Give me the home
page when I’m logged out.” So it stops making the server do work to
figure out what the home page looks like. Instead, it memorizes what
the home page looks like and sends it to you. This is called caching

  Caching is a common way to make things faster. All big websites use
caching. And that data is cached in a hash! Facebook isn’t just caching the home page. It’s also caching the About
page, the Contact page, the Terms and Conditions page, and a lot more.  When you visit a page on Facebook, it first checks whether the page is
stored in the hash.

### Collisons

- Like I said earlier, most languages have hash tables. You don’t need to
know how to write your own. So, I won’t talk about the internals of hash
tables too much. But you still care about performance! To understand
the performance of hash tables, you first need to understand what
collisions are. 

  First, I’ve been telling you a white lie. I told you that a hash function
always maps different keys to different slots in the array.

  In reality, it’s almost impossible to write a hash function that does this. Let’s take a simple example. Suppose your array contains 26 slots. And your hash function is really simple: it assigns a spot in the array
alphabetically. Then you want to put the price of bananas in the hash. You get assigned
the second slot Everything is going so well! But now you want to put the price of
avocados in your hash. You get assigned the first slot again.

  Oh no! Apples have that slot already! What to do? This is called a
collision: two keys have been assigned the same slot. This is a problem.
If you store the price of avocados at that slot, you’ll overwrite the price
of apples. Then the next time someone asks for the price of apples,
they will get the price of avocados instead! Collisions are bad, and you
need to work around them. There are many different ways to deal with
collisions. The simplest one is this: if multiple keys map to the same
slot, start a linked list at that slot

  In this example, both “apple” and “avocado” map to the same slot.
So you start a linked list at that slot. If you need to know the price of
bananas, it’s still quick. If you need to know the price of apples, it’s a
little slower. You have to search through this linked list to find “apple”. If
the linked list is small, no big deal—you have to search through three or
four elements. But doing that ina  big linked list is a extremly bad idea, so you need a good hash function Hash functions are important. A good hash function will give you very
few collisions. So how do you pick a good hash function? That’s coming
up in the next 

- > Before you start this next section, know that this isn’t required reading. I’m
going to talk about how to implement a hash table, but you’ll never have
to do that yourself. Whatever programming language you use will have an
implementation of hash tables built in. You can use the built-in hash table
and assume it will have good performance. The next section gives you a
peek under the hood.

### Performance

- `a good hash function` -- A good hash function distributes values in the array evenly. A bad hash function groups values together and produces a lot of
collisions. What is a good hash function? That’s something you’ll never have to
worry about—old men (and women) with big beards sit in dark rooms
and worry about that. If you’re really curious, look up the SHA function
(there’s a short description of it in the last chapter). You could use that
as your hash function.  (__this was a very bad explanation of a good hash function but it is a hard problem and out of this books scope so it is understandable__)

- `Recap` --
  - You can make a hash table by combining a hash function
with an array
  - Collisions are bad. You need a hash function that
minimizes collisions.
  - Hash tables have really fast search, insert, and delete.
  - Hash tables are good for modeling relationships from one
item to another item.
  - Once your load factor is greater than .07, it’s time to resize
your hash table
  - Hash tables are used for caching data (for example, with
a web server).
  - Hash tables are great for catching duplicates

<br>
<Br>
  
---

<br>
<Br>
  
