# Dijktra's Algorithm

- We continue the discussion of graphs, and you
learn about weighted graphs: a way to assign
more or less weight to some edges. You learn Dijkstra’s algorithm, which lets you
answer “What’s the shortest path to X?” for
weighted graphs.

- In the last chapter, you figured out a way to get from point A to point B It’s not necessarily the fastest path. It’s the shortest path, because it has
the least number of segments (three segments). But suppose you add
travel times to those segments. Now you see that there’s a faster path.

  You used breadth-first search in the last chapter. Breadth-first search
will find you the path with the fewest segments (the first graph shown
here). What if you want the fastest path instead (the second graph)? You
can do that fastest with a different algorithm called Dijkstra’s algorithm. 

- There are four steps to Dijkstra’s algorithm:
  - 1 - Find the “cheapest” node. This is the node you can get to in the least
amount of time
  - 2 - Update the costs of the neighbors of this node. I’ll explain what I
mean by this shortly
  - 3 - Repeat until you’ve done this for every node in the graph
  - 4 - Calculate the final path.

### Terminology

- When you work with Dijkstra’s algorithm, each edge in the graph has a
number associated with it. These are called `weights`. A graph with weights is called a weighted graph. A graph without
weights is called an unweighted graph.

  To calculate the shortest path in an unweighted graph, use breadth-first
search. To calculate the shortest path in a weighted graph, use Dijkstra’s
algorithm. Graphs can also have `cycles`. the cycle adds more weight. You
could even follow the cycle twice if you wanted. An undirected graph means that both nodes point to each other. That’s
a cycle!

  With an undirected graph, each edge adds another cycle.
Dijkstra’s algorithm only works with directed acyclic graphs,
called DAGs for short. So try to avoid cycles because of loops.

### Negative-weight edges

-  You can’t use
Dijkstra’s algorithm if you have negative-weight edges. Negative-weight
edges break the algorithm.

  If you want to find the shortest path in a graph
that has negative-weight edges, there’s an algorithm for that! It’s called
the Bellman-Ford algorithm. Bellman-Ford is out of the scope of this
book, but you can find some great explanations online

- `Recap` --
  - Breadth-first search is used to calculate the shortest path for
an unweighted graph.
  - Dijkstra’s algorithm is used to calculate the shortest path for
a weighted graph.
  - Dijkstra’s algorithm works when all the weights are positive
  - If you have negative weights, use the Bellman-Ford algorithm
  
<br>
<br>

---

<Br>
<br>
  
# Greedy Algorithms

- You learn how to tackle the impossible:
problems that have no fast algorithmic solution
(NP-complete problems). You learn how to identify such problems when you
see them, so you don’t waste time trying to find a
fast algorithm for them.

  You learn about approximation algorithms, which
you can use to find an approximate solution to an
NP-complete problem quickly. You learn about the greedy strategy, a very simple
problem-solving strategy.

### The classroom scheduling problem

- Suppose you have a classroom and want to hold as many classes
here as possible. You get a list of classes You can’t hold all of these classes in there, because some of them
overlap. You want to hold as many classes as possible in this classroom. How
do you pick what set of classes to hold, so that you get the biggest set of
classes possible

  Sounds like a hard problem, right? Actually, the algorithm is so easy, it
might surprise you. Here’s how it works:
  - 1. Pick the class that ends the soonest. This is the first class you’ll hold
in this classroom.
  - 2. Now, you have to pick a class that starts after the first class.
Again, pick the class that ends the soonest. This is the second
class you’ll hold.
  
  A lot of people tell me that this algorithm seems easy. It’s too obvious,
so it must be wrong. But that’s the beauty of greedy algorithms: they’re
easy! A greedy algorithm is simple: at each step, pick the optimal move.
In this case, each time you pick a class, you pick the class that ends the
soonest t. In technical terms: at each step you pick the locally optimal
solution, and in the end you’re left with the globally optimal solution

### The knapsack problem

- Suppose you’re a greedy thief. You’re in a store with a
knapsack, and there are all these items you can steal.
But you can only take what you can fit in your knapsack.
The knapsack can hold 35 pounds. You’re trying to maximize the value of the items you put
in your knapsack. What algorithm do you use? Again, the greedy strategy is pretty simple:
  - 1 - Pick the most expensive thing that will fit in your
knapsack
  - 2 - Pick the next most expensive thing that will fit in
your knapsack. And so on.

  Clearly, the greedy strategy doesn’t give you the optimal solution here.
But it gets you pretty close. In the next chapter, I’ll explain how to
calculate the correct solution. But if you’re a thief in a shopping center,
you don’t care about perfect. “Pretty good” is good enough. 

  Here’s the takeaway from this second example: sometimes, perfect is the
enemy of good. Sometimes all you need is an algorithm that solves the
problem pretty well.

### NP-complete problems

- `Travelling salesperson, step by step` -- You may be wondering, “In the traveling salesperson problem, is there
a specific city you need to start from?” For example, let’s say I’m the
traveling salesperson. I live in San Francisco, and I need to go to four
other cities. San Francisco would be my start city

  But sometimes the start city isn’t set. Suppose you’re FedEx, trying
to deliver a package to the Bay Area. The package is being flown in
from Chicago to one of 50 FedEx locations in the Bay Area. Then
that package will go on a truck that will travel to different locations
delivering packages. Which location should it get flown to? Here the
start location is unknown. It’s up to you to compute the optimal path
and start location for the traveling salesperson

  The traveling-salesperson problem and the set-covering problem both
have something in common: you calculate every possible solution and
pick the smallest/shortest one. Both of these problems are NP-complete

  Here’s the short explanation of NP-completeness: some problems are
famously hard to solve. The traveling salesperson and the set-covering
problem are two examples. A lot of smart people think that it’s not
possible to write an algorithm that will solve these problems quickly so they use greedy algorithms to make approximations.

- `how do you tell if a problem is NP-complete` -- it’s hard to tell if a problem you’re working on is
NP-complete. Usually there’s a very small difference between a problem
that’s easy to solve and an NP-complete problem. For example, in the
previous chapters, I talked a lot about shortest paths. You know how to
calculate the shortest way to get from point A to point B.

  But if you want to find the shortest path that connects several points,
that’s the traveling-salesperson problem, which is NP-complete. The
short answer: there’s no easy way to tell if the problem you’re working
on is NP-complete. Here are some giveaways:
  - Your algorithm runs quickly with a handful of items but really slows
down with more items
  - All combinations of X” usually point to an NP-complete problem
  - Do you have to calculate “every possible version” of X because you
can’t break it down into smaller sub-problems? Might be
NP-complete.
  - If your problem involves a sequence (such as a sequence of cities, like
traveling salesperson), and it’s hard to solve, it might be NP-complete
  - If your problem involves a set (like a set of radio stations) and it’s hard
to solve, it might be NP-complete
  - Can you restate your problem as the set-covering problem or the
traveling-salesperson problem? Then your problem is definitely
NP-complete

- `recap` --
  - Greedy algorithms optimize locally, hoping to end up with a global
optimum. 
  - NP-complete problems have no known fast solution. 
  - If you have an NP-complete problem, your best bet is to use an
approximation algorithm. 
  - Greedy algorithms are easy to write and fast to run, so they make
good approximation algorithms

<br>
<br>

---

<Br>
<Br>
  
# Dynamic Programming

- You learn dynamic programming, a
technique to solve a hard problem by
breaking it up into subproblems and
solving those subproblems first.

### THe knapscak problem

- Let’s revisit the knapsack problem from chapter 8.
You’re a thief with a knapsack that can carry 4 lb
of goods. You have three items that you can put into the knapsack. What items should you steal so that you steal the maximum money’s
worth of goods? 

- `the simple solution` --  In chapter 8,
you saw how to calculate an approximate solution. That solution will be
close to the optimal solution, but it may not be the optimal solution.(greedy) So how do you calculate the optimal solution?

- `dynamic programming` --  Dynamic programming starts by
solving subproblems and builds up to solving the big problem. For the knapsack problem, you’ll start by solving the problem for
smaller knapsacks (or “sub-knapsacks”) and then work up to solving
the original problem Dynamic programming is a hard concept, so don’t worry if you don’t get it
right away

### Longest common substring

- You’ve seen one dynamic programming problem so far. What are
the takeaways?
  
  Dynamic programming is useful when you’re trying to optimize
something given a constraint. In the knapsack problem, you had to
maximize the value of the goods you stole, constrained by the size of
the knapsack. 
  
  You can use dynamic programming when the problem can be broken
into discrete subproblems, and they don’t depend on each other. It can be hard to come up with a dynamic-programming solution. That’s
what we’ll focus on in this section. Some general tips follow: 
  - Every dynamic-programming solution involves a grid.
  - The values in the cells are usually what you’re trying to optimize.
For the knapsack problem, the values were the value of the goods
  - Each cell is a subproblem, so think about how you can divide
your problem into subproblems. That will help you figure out what
the axes are.

- `Recap` --
  - Dynamic programming is useful when you’re trying to optimize
something given a constraint. 
  - You can use dynamic programming when the problem can be
broken into discrete subproblems.
  - Every dynamic-programming solution involves a grid
  - The values in the cells are usually what you’re trying to optimize
  - Each cell is a subproblem, so think about how you can divide your
problem into subproblems.
  - There’s no single formula for calculating a dynamic-programming
solution.

<br>
<br>

---

<br>
<Br>
  
# K-nearest neighbors

- You learn to build a classification system using
the k-nearest neighbors algorithm You learn about feature extraction. You learn about regression: predicting a number,
like the value of a stock tomorrow, or how much
a user will enjoy a movie.

### Building a recommendations system

- Suppose you’re Netflix, and you want to build a movie
recommendations system for your users You can plot every user on a graph (x, y) These users are plotted by similarity, so users with similar taste are
plotted closer together

  Once you have this graph, building a recommendations system is easy.
If Justin likes a movie, recommend it to Priyanka because they are close in their own bubble But there’s still a big piece missing. You graphed the users by similarity.
How do you figure out how similar two users are? 

  Suppose you’re comparing Netflix users, instead. You need some
way to graph the users. So, you need to convert each user to a set of
coordinates Once you can graph users, you can measure the distance between them. 

  Here’s how you can convert users into a set of numbers. When users
sign up for Netflix, have them rate some categories of movies based on
how much they like those categories. For each user, you now have a set
of ratings! and update those cordiantes based on his ratings ont he new movies he/her watches

  The distance formula is flexible: you could have a set of a million
numbers and still use the same old distance formula to find the
distance. Maybe you’re wondering, “What does distance mean when
you have five numbers?” The distance tells you how similar those sets of
numbers are (a graph distance formula is teached in algebra 1 you can search it on google)

- `regression` -- Suppose you’re trying to guess a rating for Pitch Perfect. Well, how did
Justin, JC, Joey, Lance, and Chris rate it? (5, 4, 4, 5, 3)

  You could take the average of their ratings and get 4.2 stars.
That’s called regression. These are the two basic things you’ll do
with KNN—classification and regression:
  - Classification = categorization into a group
  - Regression = predicting a response (like a number)
  
- `cosine similarity` -- So far, you’ve been using the distance formula to compare the distance
between two users. Is this the best formula to use? A common one used
in practice is cosine similarity. Suppose two users are similar, but one of
them is more conservative in their ratings. They both loved Manmohan
Desai’s Amar Akbar Anthony. Paul rated it 5 stars, but Rowan rated it 4
stars. If you keep using the distance formula, these two users might not be
each other’s neighbors, even though they have similar tas

  So far, you’ve been using the distance formula to compare the distance
between two users. Is this the best formula to use? A common one used
in practice is cosine similarity. Suppose two users are similar, but one of
them is more conservative in their ratings. They both loved Manmohan
Desai’s Amar Akbar Anthony. Paul rated it 5 stars, but Rowan rated it 4
stars. If you keep using the distance formula, these two users might not be
each other’s neighbors, even though they have similar tas

### Introduction to machine learning

- KNN is a really useful algorithm, and it’s your introduction to
the magical world of machine learning! Machine learning is all
about making your computer more intelligent. You already saw
one example of machine learning: building a recommendations
system. Let’s look at some other examples

- `ocr` -- OCR stands for optical character recognition. It means you can take a
photo of a page of text, and your computer will automatically read the
text for you. Google uses OCR to digitize books

  It’s the same KNN problem but isntead of classifying nodes wih their genre you use measre lines and curves. Generally speaking,
OCR algorithms measure lines, points, and curves

  Feature extraction is a lot more complicated in OCR than the
fruit example. But it’s important to understand that even complex
technologies build on simple ideas, like KNN. You could use the same
ideas for speech recognition or face recognition

- `building a spam filter` -- Spam filters use another simple algorithm called the Naive Bayes
classifier. First, you train your Naive Bayes classifier on some data. Suppose you get an email with the subject “collect your million dollars
now!” Is it spam? You can break this sentence into words. Then, for
each word, see what the probability is for that word to show up in a
spam email. For example, in this very simple model, the word million
only appears in spam emails. Naive Bayes figures out the probability
that something is likely to be spam. It has applications similar to KNN.

- `predicting the stock market` -- Here’s something that’s hard to do with machine learning: really
predicting whether the stock market will go up or down. How do
you pick good features in a stock market? Suppose you say that if the
stock went up yesterday, it will go up today. Is that a good feature? Or
suppose you say that the stock will always go down in May. this is one of the algorithms that are close on the hard scale.

- `Recap` --
  - KNN is used for classification and regression and involves looking
at the k-nearest neighbors.
  - Classification = categorization into a group
  - Regression = predicting a response (like a number)
  - Feature extraction means converting an item (like a fruit or a user)
into a list of numbers that can be compared.
  - Picking good features is an important part of a successful KNN
algorithm

<br>
<br>

---

<Br>
<br>
  
# Where to go next

- You get a brief overview of 10 algorithms
that weren’t covered in this book, and why
they’re useful. You get pointers on what to read next,
depending on what your interests are.

### Trees

- Let’s go back to the binary search example.
When a user logs in to Facebook, Facebook
has to look through a big array to see if the
username exists. We said the fastest way to
search through this array is to run binary
search. But there’s a problem: every time a new
user signs up, you insert their username into
the array. Then you have to re-sort the array,
because binary search only works with sorted
arrays. Wouldn’t it be nice if you could insert the username into the right slot in the array right away, so you don’t
have to sort the array afterward? That’s the idea behind the binary search
tree data structure

  If you’re interested in databases or more-advanced data structures,
check these out trees, heaps ... etc.

### Inverted indexes

- Here’s a very simplified version of how a search engine works. Suppose
you have three web pages with this simple content. Let’s build a hash table from this content. The keys of the hash table are the words, and the values tell
you what pages each word appears on. Now suppose a user
searches for hi. Let’s see what pages hi shows up on. Aha: It appears on pages A and B. Let’s show the user those pages as
the result. 

   This is a useful data
structure: a hash that maps words to places where they appear. This
data structure is called an inverted index, and it’s commonly used to
build search engines.

### The fourier transforms

- The Fourier transform is one of those rare algorithms: brilliant,
elegant, and with a million use cases. The best analogy for the Fourier
transform comes from Better Explained (a great website that explains
math simply): given a smoothie, the Fourier transform will tell you the
ingredients in the smoothie.1
 Or, to put it another way, given a song, the
transform can separate it into individual frequencies.

   Fourier
transform is great for processing signals. You can also use it to compress
music. First you break an audio file down into its ingredient notes. The
Fourier transform tells you exactly how much each note contributes
to the overall song. So you can just get rid of the notes that aren’t
important. That’s how the MP3 format works!

  Music isn’t the only type of digital signal. The JPG format is another
compressed format, and it works the same way. People use the Fourier
transform to try to predict upcoming earthquakes and analyze DNA.  You can use it to build an app like Shazam, which guesses what song is
playing. 

### Parallel algorithms

- The next three topics are about scalability and working with a lot of
data. Back in the day, computers kept getting faster and faster. If you
wanted to make your algorithm faster, you could wait a few months,
and the computers themselves would become faster. But we’re near the
end of that perio  To make your algorithms faster, you need to change them to run
in parallel across all the cores at once!

  Parallel algorithms are hard to design. And it’s also hard to make sure
they work correctly and to figure out what type of speed boost you’ll
see. One thing is for sure—the time gains aren’t linear. So if you have
two cores in your laptop instead of one, that almost never means your
algorithm will magically run twice as fast.

  There are a couple of reasons
for this:
  - Overhead of managing the parallelism
  - Load balancing
  
  If you’re interested in the theoretical side of performance and scalability,
parallel algorithms might be for you! 

### MapReduce

- There’s a special type of parallel algorithm that is becoming increasingly
popular: the distributed algorithm. It’s fine to run a parallel algorithm
on your laptop if you need two to four cores, but what if you need
hundreds of cores? Then you can write your algorithm to run across
multiple machines. The MapReduce algorithm is a popular distributed
algorithm.

  Suppose you have a table with billions or trillions of rows, and you
want to run a complicated SQL query on it. You can’t run it on MySQL,
because it struggles after a few billion rows. Use MapReduce

  Distributed algorithms are great when you have a lot of work to do
and want to speed up the time required to do it

  MapReduce uses these two simple concepts to run queries about data
across multiple machines. When you have a large dataset (billions
of rows), MapReduce can give you an answer in minutes where a
traditional database might take hours. 

### Bloom filters and HyperLogLog

- Or suppose you’re Google, and you’re crawling web pages. You only
want to crawl a web page if you haven’t crawled it already. So you need
to figure out whether this page has been crawled before. these examples have the same problem. You have a very large set.

  Now you have a new item, and you want to see whether it belongs in
that set. You could do this quickly with a hash. For example, suppose
Google has a big hash in which the keys are all the pages it has crawled. You want to see whether you’ve already crawled adit.io. Look it up in
the hash.

  adit.io is a key in the hash, so you’ve already crawled it. The average
lookup time for hash tables is O(1). adit.io is in the hash, so you’ve
already crawled it. You found that out in constant time. Pretty good!

  Except that this hash needs to be huge. Google indexes trillions of web
pages. If this hash has all the URLs that Google has indexed, it will take
up a lot of space. Reddit and bit.ly have the same space problem. When
you have so much data, you need to get creative!

- `Bloomfilters` -- Bloom filters offer a solution. Bloom filters are probabilistic data
structures. They give you an answer that could be wrong but is probably
correct. Instead of a hash, you can ask your bloom filter if you’ve
crawled this URL before. A hash table would give you an accurate
answer. A bloom filter will give you an answer that’s probably correct

  Bloom filters are great because they take up very little space. A hash
table would have to store every URL crawled by Google, but a bloom
filter doesn’t have to do that. They’re great when you don’t need an exact
answer, as in all of these examples

- `hyperloglog` -- Along the same lines is another algorithm called HyperLogLog.
Suppose Google wants to count the number of unique searches
performed by its users. Or suppose Amazon wants to count the number
of unique items that users looked at today. Answering these questions
takes a lot of space! With Google, you’d have to keep a log of all the
unique searches g. Even
for a single day, this log would be massive! 

  HyperLogLog approximates the number of unique elements in a set.
Just like bloom filters, it won’t give you an exact answer, but it comes
very close and uses only a fraction of the memory a task like this would
otherwise take.

### The SHA Algorithms

- Other than hash table usage hash function is used in secure hash algorithm (SHA) function. The terminology can be a little confusing here. SHA is a hash function.
It generates a hash, which is just a short string. The hash function for
hash tables went from string to array index, whereas SHA goes from
string to string. 

  SHA is also useful when you want to compare strings without revealing
what the original string was. For example, suppose Gmail gets hacked,
and the attacker steals all the passwords! Is your password out in the
open? No, it isn’t. Google doesn’t store the original password, only the
SHA hash of the password! The gold standard for password-hashing functions is currently
bcrypt (though nothing is foolproof). 

### Diffie-Hellman key exchange

- Diffie-Hellman has two keys: a public key and a private key. The public
key is exactly that: public. You can post it on your website, email it
to friends, or do anything you want with it. You don’t have to hide it.
When someone wants to send you a message, they encrypt it using
the public key. An encrypted message can only be decrypted using the
private key. As long as you’re the only person with the private key, only
you will be able to decrypt this message

  The Diffie-Hellman algorithm is still used in practice, along with its
successor, RSA. If you’re interested in cryptography, Diffie-Hellman is a
good place to start: it’s elegant and not too hard to follow

### Linear Programming 

- Linear programming is used to maximize something given some
constraints. For example, suppose your company makes two products,
shirts and totes. Shirts need 1 meter of fabric and 5 buttons. Totes need
2 meters of fabric and 2 buttons. You have 11 meters of fabric and 20
buttons. You make $2 per shirt and $3 per tote. How many shirts and
totes should you make to maximize your profit?  Here you’re trying to maximize profit, and you’re constrained by the
amount of materials you have.

  Another example: you’re a politician, and you want to maximize the
number of votes you get. Your research has shown that it takes an
average of an hour of work (marketing, research, and so on) for each
vote from a San Franciscan or 1.5 hours/vote from a Chicagoan. You
need at least 500 San Franciscans and at least 300 Chicagoans. 

  50 days. It also costs you $2/San Franciscan versus $1/Chicagoan. Your
total budget is $1,500. What’s the maximum number of total votes you
can get (San Francisco + Chicago)? Here you’re trying to maximize votes, and you’re constrained by time
and money. 

<br>
