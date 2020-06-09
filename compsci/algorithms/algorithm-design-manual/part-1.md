# The Algorithm Design Manual - Skienna 2nd

Designing correct, efficient, and implementable algorithms for real-world problems requires
access to two distinct bodies of knowledge:
  - `Techniques` – Good algorithm designers understand several fundamental algorithm design techniques, including data structures, dynamic programming,
depth-first search, backtracking, and heuristics. Perhaps the single most important design technique is modeling, the art of abstracting a messy real-world
application into a clean problem suitable for algorithmic attack.
  - `Resources` – Good algorithm designers stand on the shoulders of giants.
Rather than laboring from scratch to produce a new algorithm for every task,
they can figure out what is known about a particular problem. Rather than
re-implementing popular algorithms from scratch, they seek existing implementations to serve as a starting point. They are familiar with many classic
algorithmic problems, which provide sufficient source material to model most
any application.

Table of Contents:
- [1 Introduction to Algorithm Design]()
- [2 Algorithm Analysis]()
- [3 Data Structures]()
- [4 Sorting and Searching]()
- [5 Graph Traversal]()
- [6 Weighted Graph Algorithms]()
- [7 Combinatorial Search and Heuristic Methods]()
- [8 Dynamic Programming]()
- [9 Intractable Problems and Approximation Algorithms]()
- [10 How to Design Algorithms]()
- [11 A Catalog of Algorithmic Problems]()
- [12 Data Structures]()
- [13 Numerical Problems]()
- [14 Combinatorial Problems]()
- [15 Graph Problems: Polynomial-Time]()
- [16 Graph Problems: Hard Problems]()
- [17 Computational Geometry]()
- [18 Set and String Problems]()
- [19 Algorithmic Resources]()

<br>
<br>

---

<br>
<br>

# 1 Introduction to Algorithm Design

- What is an algorithm? An algorithm is a procedure to accomplish a specific task.
An algorithm is the idea behind any reasonable computer program.
To be interesting, an algorithm must solve a general, well-specified problem

- There are three desirable properties for a good algorithm. We seek algorithms
that are correct and efficient, while being easy to implement. These goals may not
be simultaneously achievable. In industrial settings, any program that seems to
give good enough answers without slowing the application down is often acceptable,
regardless of whether a better algorithm exists. The issue of finding the best possible
answer or achieving maximum efficiency usually arises in industry only after serious
performance or legal troubles. So a good enough algorithm is enough if it gets the job done.

### Selecting the Right Jobs

- Reasonable-looking algorithms can easily be incorrect. Algorithm correctness is a property that must be carefully demonstrated. For example you may be thinking that you are using the right algorithm for the job however the `n` input of the alforithm may quickly turn into a 20! permutation problem which is compulationaly impossible to solve. The take home lesson is be careful while playing with heuristic, travelling salesman typed algorithms. 

### Reasoning about Correctness

- We need tools to distinguish correct algorithms from incorrect
ones, the primary one of which is called a proof.

  A proper mathematical proof consists of several parts. First, there is a clear,
precise statement of what you are trying to prove. Second, there is a set of assumptions of things which are taken to be true and hence used as part of the proof.
Third, there is a chain of reasoning which takes you from these assumptions to the
statement you are trying to prove. Finally, there is a little square ( ) or QED at the
bottom to denote that you have finished, representing the Latin phrase for “thus
it is demonstrated.”

- `Expressing Algorithms` -- Reasoning about an algorithm is impossible without a careful description of the
sequence of steps to be performed. The three most common forms of algorithmic
notation are (1) English, (2) pseudocode, or (3) a real programming language. Programmers generally go for psudeo-code which is the most useful between all three.

  The heart of any algorithm is an idea. If your idea is
not clearly revealed when you express an algorithm, then you are using too
low-level a notation to describe it. Try to avoid hard to read languages like C, C++ ... etc.

- `Problems and Properties` -- We need more than just an algorithm description in order to demonstrate correctness. We also need a careful description of the problem that it is intended to
solve. Problem specifications have two parts: (1) the set of allowed input instances,
and (2) the required properties of the algorithm’s output. It is impossible to prove
the correctness of an algorithm for a fuzzily-stated problem Put another way, ask
the wrong problem and you will get the wrong answer.

  : An important and honorable technique in algorithm design is to narrow the set of allowable instances until there is a correct and
efficient algorithm. For example, we can restrict a graph problem from general
graphs down to trees, or a geometric problem from two dimensions down to
one.

- `Demonstrating Incorrectness` -- The best way to prove that an algorithm is incorrect is to produce an instance in
which it yields an incorrect answer. Such instances are called counter-examples.
No rational person will ever leap to the defense of an algorithm after a counterexample has been identified

  Hunting for counter-examples is a skill worth developing. It bears some similarity to the task of developing test sets for computer programs, but relies more on
inspiration than exhaustion. Always have a test case if you are developing an algorithm that is more complex than fucking fibonacci series ... etc.

- ` Induction and Recursion` -- Failure to find a counterexample to a given algorithm does not mean “it is obvious”
that the algorithm is correct. A proof or demonstration of correctness is needed.
Often mathematical induction is the method of choice.

  When I first learned about mathematical induction it seemed like complete
magic. You proved a formula like "n
i=1 i = n(n + 1)/2 for some basis case like 1
or 2, then assumed it was true all the way to n − 1 before proving it was true for
general n using the assumption. That was a proof? Ridiculous

- `Summations` -- Mathematical summation formulae arise often in algorithm analysis, which we will
study in Chapter 2. Further, proving the correctness of summation formulae is a
classic application of induction

### Modeling the Problem

- Modeling is the art of formulating your application in terms of precisely described,
well-understood problems. Proper modeling is the key to applying algorithmic design techniques to real-world problems. Indeed, proper modeling can eliminate the
need to design or even implement algorithms, by relating your application to what
has been done before. Proper modeling is the key to effectively using the “Hitchhiker’s Guide”

- `Combinatorial Objects` -- In real world you dont just go on and say "Oh I need a sorting algorithm in my site" no!, thats not how any of this works!. Real world means real objects, so first you define your problem lets say that you want to write a program with the shortest linkage in a ancestry tree of a family. There you go now you can use the three data structure with graph algorithms .. etc. 

  Examples of successful application modeling will be presented in the war stories
spaced throughout this book.. Modeling is only the first step in designing an algorithm for a problem. Be alert
for how the details of your applications differ from a candidate model, but don’t
be too quick to say that your problem is unique and special

  Take-Home Lesson: Modeling your application in terms of well-defined structures and algorithms is the most important single step towards a solution.

- `Recursive Objects` -- Learning to think recursively is learning to look for big things that are made from
smaller things of exactly the same type as the big thing. If you think of houses as
sets of rooms, then adding or deleting a room still leaves a house behind.
Recursive structures occur everywhere in the algorithmic world. Indeed, each
of the abstract structures described above can be thought about recursively. You
just have to see how you can break them down

<br>
<br>

---

<bR>
<Br>
  
# 2 Algorithm Analysis

- Algorithms are the most important and durable part of computer science because
they can be studied in a language- and machine-independent way. This means that
we need techniques that enable us to compare the efficiency of algorithms without
implementing them. Our two most important tools are (1) the RAM model of
computation and (2) the asymptotic analysis of worst-case complexity

  Assessing algorithmic performance makes use of the “big Oh” notation that,
proves essential to compare algorithms and design more efficient ones. The most math intensive part of algorithms are the big Oh notation but to be fair once you understand it it becomes really easy and the basics of it is that watch out for the `n` in the parameters and not too much on the constant parameters.

### The RAM Model of Computation

- Machine-independent algorithm design depends upon a hypothetical computer
called the Random Access Machine or RAM.  Under this model of computation,
we are confronted with a computer where:
  - Each simple operation (+, *, –, =, if, call) takes exactly one time st
  - Loops and subroutines are not considered simple operations. Instead, they
are the composition of many single-step operations.
  - Each memory access takes exactly one time step
  
  Under the RAM model, we measure run time by counting up the number of
steps an algorithm takes on a given problem instance. If we assume that our RAM
executes a given number of steps per second, this operation count converts naturally
to the actual running time. Even though computers vary greatly in terms of real horse power of processing. It does not fucking matter. We only care about algorithms in a vacumed imaginary computer. We just compare the algorithms on a same abstract computer model called RAM.

  Take-Home Lesson: Algorithms can be understood and studied in a languageand machine-independent manner.
  
- `Best, Worst, and Average-Case Complexity` -- To understand the notions of the best, worst, and average-case complexity,
think about running an algorithm over all possible instances of data that can be fed to it. The best case will need the least amount of steps for the algorithm to run and the worst case will need the most amount of steps. Average is just average in the middle. The most important one is worst because getting a best case senarios is very unlikely and preparing for the worst is always more rewarding in any case in life not just in programming.

### The Big Oh Notation

- The best, worst, and average-case time complexities for any given algorithm are
numerical functions over the size of possible problem instances

  Take-Home Lesson: The Big Oh notation and worst-case analysis are tools
that greatly simplify our ability to compare the efficiency of algorithms.

### Growth Rates and Dominance Relations

- With the Big Oh notation, we cavalierly discard the multiplicative constants. Thus,
the functions f(n)=0.001n2 and g(n) = 1000n2 are treated identically, even
though g(n) is a million times larger than f(n) for all values of n. If the input gets large enough constants doesnt mean shit.

- The following conclusions can be drawn from different big Oh notations:
  - All such algorithms take roughly the same time for n = 10.
  - Any algorithm with n! running time becomes useless for n ≥ 20
  - Algorithms whose running time is 2n have a greater operating range, but
become impractical for n > 40.
  - Quadratic-time algorithms whose running time is n2 remain usable up to
about n = 10, 000, but quickly deteriorate with larger inputs. They are likely
to be hopeless for n > 1,000,000.
  - Linear-time and n lg n algorithms remain practical on inputs of one billion
items.
  - An O(lg n) algorithm hardly breaks a sweat for any imaginable value of n.
  
  The bottom line is that even ignoring constant factors, we get an excellent idea
of whether a given algorithm is appropriate for a problem of a given size. An algorithm whose running time is f(n) = n3 seconds will beat one whose running time is
g(n) = 1,000,000 · n2 seconds only when n < 1,000,000. Such enormous differences
in constant factors between algorithms occur far less frequently in practice than
large problems do

- `Dominance Relations` --  We say that a faster-growing function dominates a slower-growing one, just as
a faster-growing country eventually comes to dominate the laggard. The good news is that only a few function classes tend to occur in the course
of basic algorithm analysis. These suffice to cover almost all the algorithms we will
discuss in this text, and are listed in order of increasing dominance:
  - Constant functions, f(n) = 1
  - Logarithmic functions, f(n) = log n
  - Linear functions, f(n) = n
  - Superlinear functions, f(n) = n lg n
  - Quadratic functions, f(n) = n2
  - Cubic functions, f(n) = n3
  - Exponential functions, f(n) = cn
  - Factorial functions, f(n) = n!
  
  Dominance doesnt mean a good thing in this case it mostly means the bad apple will make the good apple not show up.
  ```
  n! ≫ 2n ≫ n3 ≫ n2 ≫ n log n ≫ n ≫ log n ≫ 1
  ```

### Working with the Big Oh

- You learned how to do simplifications of algebraic expressions back in high school.
Working with the Big Oh requires dusting off these tools.

- `Adding Functions` -- The sum of two functions is governed by the dominant one, namely:
  
  n3 + n2 + n +1= O(n3)
  
  Everything is small potatoes besides the dominant term.
  
- `Multiplying Functions` -- Multiplication is like repeated addition. Consider multiplication by any constant
c > 0, be it 1.02 or 1,000,000. Multiplying a function by a constant can not affect
its asymptotic behavior, because we can multiply the bounding constants in the
Big Oh analysis:
  - O(c · f(n)) → O(f(n))
  - Ω(c · f(n)) → Ω(f(n))
  
  But if you are not using any constants that as said above it is like repeteated addition:
  - O(f(n)) ∗ O(g(n)) → O(f(n) ∗ g(n))
  - Ω(f(n)) ∗ Ω(g(n)) → Ω(f(n) ∗ g(n))

### Logarithms and Their Applications

- `Logarithms and Binary Search` -- Binary search is a good example of an O(log n) algorithm. To locate a particular
person p in a telephone book containing n names, you start by comparing p against
the middle, or (n/2)nd name, say Monroe, Marilyn. Regardless of whether p belongs
before this middle name (Dean, James) or after it (Presley, Elvis), after only one
comparison you can discard one half of all the names in the book. The number of
steps the algorithm takes equals the number of times we can halve n until only one
name is left. By definition, this is exactly log2 n. Thus, twenty comparisons suffice
to find any name in the million-name Manhattan phone book! Binary search is one of the most powerful ideas in algorithm design.

- `Logarithms and Trees` -- A binary tree of height 1 can have up to 2 leaf nodes, while a tree of height two
can have up to four leaves. What is the height h of a rooted binary tree with n leaf
nodes? Note that the number of leaves doubles every time we increase the height
by one. To account for n leaves, n = 2h which implies that h = log2 n.
What if we generalize to trees that have d children, where d = 2 for the case
of binary trees? A tree of height 1 can have up to d leaf nodes, while one of height
two can have up to d2 leaves. The number of possible leaves multiplies by d every
time we increase the height by one, so to account for n leaves, n = dh which implies
that h = logd n

  The punch line is that very short trees can have very many leaves, which is
the main reason why binary trees prove fundamental to the design of fast data
structures.

- `Logarithms and Multiplication` -- Logarithms were particularly important in the days before pocket calculators. They
provided the easiest way to multiply big numbers by hand Logarithms are still useful for multiplication, particularly for exponentiation.
Recall that loga(xy) = loga(x) + loga(y); i.e. , the log of a product is the sum of
the logs.

<br>
<br>

---

<bR>
<Br>
  




