# Programming

- First lets see what wikipedia has to say about programming : 
  > Computer programming is the process of desinging and building and building an executable computer program for accomplishing a specific computer task. Programming involves tasks such as analysis, generating alogirthms, profiling algorithms, accuarcy and resource consumption, and the implementation of algorithms in a chosen programming languages (commonly reffered to as coding). The source code of the program is written in one or more programming languages. The purpose of programming is to find a sequence of instructions that will automate the performance of a task for solving a problem.
  
  
- This is a fairly good summarazation of programming and to clear out from the begining software engineering is not the same as programming. In software engineering you have a lot of responsibilities such as testing, debugging, maintaining the source code. But in programming as stated above it is just a better and sequenced way of doing things it doesnt have to be realted to coding or computers you can program your daily schedule and so on ... However I am trying to become a software engineer so my notes will be related to "computer programs"

- Whatever the approach to development may be, the final computer program must satisfy some fundemental properties. The following properties are the **most** important ones.
  - `Reliability`: how often the results of a program are correct. This can depend on the correctness of the algorithms or the minimalisation of the sourse code and so on ...
  -  `Robustness`: How well the program aniticipates problems due to error (not bugs!), such as power outages, incorrect data and so on ...
  - `Usability`: the ergonomics of a program what I mean by that is the ease with which which a person can use the program for its intended purpose.
  - `Portability`: the range of computer hardware and operating system platforms on which the source code can run without any problems.
  - `Maintainability`: the ease with which a program can be modified by its present or future developers.
  - `Efficiency`: performance of the program the "more things you can do with less" is always the best 
  - `Readability`: even though this might be open to discussion I feel that it is *very* important that the code (program) you write should be easily readable not for other people neccessarily, but for you. It is a shame if you cannot read the code you have written the night before.
  
- There are many more things to talk about but I think this is enough for the start since I will note a lot of things from the notorious "Structure and Interpretation of Computer Programs" book. I will try to add as much different notes as I can but most of this note page will consists a summary of SICP for me.

## Introduction

- In the "Structure and Interpretation of Computer Programs" book the author uses Scheme a dialect of Lisp familia. So thats why the code snippets will be in Scheme.

- Table of Contents:
  - [Building Abstractions with Procedures]()
  - [Building Abstractions with Data]()
  - [Modularity, Objects and State]()
  - [Metalinguistic Abstraction]()
  - [Computing with Register Machines]()
  
- Educators, Generals, Dieticians, pyschologists, and parents program. Armies, students, and some socities are programmed. Most of the day to day or even year to year problems are programmed so smoothly that we dont even pay any notice anymore. The programmer must seek both perfection of part and sufficency for its computer program. Every computer program is  model, hatched in the mind, of a real mental process. These processes, arising from human experience and thought, are huge in number, intricate in detail and at any time only partially understood. They are modeled to our permenant  satisfaction rarely by our computer programs. Thus even though our programs are carefully handcrafted discerete collections of beauty they will have to continually evolve them until the new model ultimately fullfills our satisfactory need, which never happens beacuse humans always want more. Unfortunately, as programs get large and complicated, as they almost always do, the correctness of the program come open to doubt. Since large programs grow from small ones it is curicial that we develop an arsenal of standard program structures of whose correctness we have become sure.

- The computers are never large enough or fast enough. Each brakethrough in hardware technology leads to more massive programming enterprieses, new orgranizatonal principles, and an enrichemnt of abstract models. Every programmer should ask himself periodically "Toward what end, toward what end?" -- but donot ask it too often lest you pass up the fun of programming for the constipation of bittersweet philosophy. Among the programs we write, some perform precise mathematical function such as sorting or finding the maximum of a sequence of numbers, determining primality, or finding the square root. We call such programs algorithms. A programmer should acquire good algorithms and an arsenal of standart program stcutrues that he trusts.

- *"A computer is like a violin. You can imagine a novice trying a phonography and then a violin. The latter, he says sounds terrible. That is the argument we have heard from our humanists and most of our computer scientists. Computer programs are good, they say, for particular purposes, but they arent flexible. Neither is a violin, or a typewriter until you learn how to use it."* - Marvin Minsky

---

## Building Abstractions with Procedures

- ...
