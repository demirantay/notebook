# CHAPTER 2: Scanners

- The scanner’s task is to transform a stream of characters into a stream of
words in the input language. Each word must be classified into a syntactic
category, or “part of speech.” The scanner is the only pass in the compiler
to touch every character in the input program

  This chapter introduces regular expressions, a notation used to describe
the valid words in a programming language. It develops the formal mechanisms to generate scanners from regular expressions, either manually or
automatically.

  Keywords: Scanner, Finite Automaton, Regular Expression, Fixed Point

## Introduction

- Scanning is the first stage of a three-part process that the compiler uses
to understand the input program. The scanner, or lexical analyzer, reads a
stream of characters and produces a stream of words. It aggregates characters to form words and applies a set of rules to determine whether or not each
word is legal in the source language.

- `Conceptual Roadmap` -- This chapter describes the mathematical tools and programming techniques
that are commonly used to construct scanners s—both generated scanners
and hand-crafted scanners.

  Both generated and hand-crafted scanners rely on the same underlying techniques. While most textbooks and courses advocate the use of generated
scanners, most commercial compilers and open-source compilers use handcrafted scanners.

- `Overview` -- Western languages, such as English, have simple microsyntax. Adjacent
alphabetic letters are grouped together, left to right, to form a word.
A blank space terminates a word, as do most nonalphabetic symbols. (The
word-building algorithm can treat a hyphen in the midst of a word as
if it were an alphabetic character.) Once a group of characters has been
aggregated together to form a potential word, the word-building algorithm
can determine its validity with a dictionary lookup.

  Most programming languages have equally simple microsyntax. Characters
are aggregated into words. In most languages, blanks and punctuation marks
terminate a word.

  In a typical programming language, some words, called keywords or res- erved words, match the rule for an identifier but have special meanings. Both `while` and `static` are keywords in both C and Java. Keywords (and punctuation marks) form their own syntactic categories . To recognize keywords, the scanner can either use dictionary
lookup or encode the keywords directly into its microsyntax rules.

## Recognizing Words

- The simplest explanation of an algorithm to recognize words is often a
character-by-character formulation. The structure of the code can provide
some insight into the underlying problem. Consider the problem of recognizing the keyword `new`:
  ```
  c ← NextChar();
  if (c = ‘n’)
    then begin;
    c ← NextChar();
    if (c = ‘e’)
      then begin;
      c ← NextChar();
      if (c = ‘w’)
        then report success;
      else try something else;
      end;
    else try something else;
    end;
  else try something else;
  ```
  In the code, cases that do not
match new try something else. In the recognizer, we can think of this action
as a transition to an error state

- `A Formalism for Recognizers` -- Transition diagrams serve as abstractions of the code that would be required
to implement them. They can also be viewed as formal mathematical obj- ects, called finite automata, that specify recognizers. Formally, a finite

- `Section Review` --A character-by-character approach to scanning leads to algorithmic clarity. We can represent character-by-character scanners with a transition
diagram; that diagram, in turn, corresponds to a finite automaton. Small
sets of words are easily encoded in acyclic transition diagrams. Infinite
sets, such as the set of integers or the set of identifiers in an Algol-like
language, require cyclic transition diagrams.

## Regular Expressions

- The set of words accepted by a finite automaton, F, forms a language,
denoted L(F). The transition diagram of the fa specifies, in precise detail,
that language. It is not, however, a specification that humans find intuitive.
For any fa, we can also describe its language using a notation called a `regular expression (re)`. The language described by an re is called a `regular
language`.

  To make this discussion concrete, consider some examples that occur in most
programming languages. Punctuation marks, such as colons, semicolons,
commas, and various brackets, can be represented by their character representations. Their res have the same “spelling” as the punctuation marks
themselves. Thus, the following res might occur in the lexical specification
for a programming language:
  ```
  : ; ? => ( ) { } [ ]
  ```
  Similarly, keywords have simple res.
  ```
  if while this integer instanceof
  ```
  So actually you can construct regular expression language by any symbols you just need to understand the logic behind it.

- `Formalizing the Notation` -- To work with regular expressions in a rigorous way, we must define them
more formally. An re describes a set of strings over the characters contained
in some alphabet, 6, augmented with a character ∈ that represents the empty
string. We call the set of strings a language. For a given re, r, we denote
the language that it specifies as L(r). An re is built up from three basic
operations:
  - 1 - `Alternation` -- The alternation, or union, of two sets of strings, R and S,
denoted R | S, is {x | x ∈ R or x ∈ S}.
  - 2 - `Concatenation` -- The concatenation oftwo sets R and S, denoted R S,
contains all strings formed by prepending an element of R onto one
from S, or {x y | x ∈ R and y ∈ S}.
  - 3 - `Closure` -- The Kleene closure of a set R, denoted R∗. This is
just the union of the concatenations of R with itself, zero or more times

- `REGULAR EXPRESSIONS IN VIRTUAL LIFE` --  Regular expressions are used in many applications to specify patterns in
character strings. Some of the early work on translating REs into code was
done to provide a flexible way of specifying strings in the "find" command
of a text editor. From that early genesis, the notation has crept into many
different applications

  Unix and other operating systems use the asterisk as a wildcard to match
substrings against file names. Here, `∗` is a shorthand for the RE `∈∗`
, specifying zero or more characters drawn from the entire alphabet of legal
characters. (Since few keyboards have a `∈` key, the shorthand has stayed
with us.) Many systems use `?` as a wildcard that matches a single character

  The `grep` family of tools, and their kin in non-Unix systems, implement
regular expression pattern matching. (In fact, grep is an acronym for global
regular-expression pattern match and print.)

  Regular expressions have found widespread use because they are easily
written and easily understood. They are one of the techniques of choice
when a program must recognize a fixed vocabulary
  - `r | s` -- is an re denoting the union, or alternation, of L(r) and L(s)
  - `rs` --is an re denoting the concatenation of L(r) and L(s)
  - `r∗` --is an re denoting the Kleene closure of L(r)
  
  To eliminate any ambiguity, parentheses have highest precedence, followed
by closure, concatenation, and alternation, in that order

- The goal of this chapter is to show how we can use formal techniques to
automate the construction of high-quality scanners and how we can encode
the microsyntax of programming languages into that formalism. 

- `Closure Properties of REs` -- Regular expressions and the languages that they generate have been the sub-ject of extensive study. They have many interesting and useful properties.
Some of these properties play a critical role in the constructions that build
recognizers from res.

  Regular expressions are closed under many operations—that is, if we apply
the operation to an re or a collection of res, the result is an re. Obvious
examples are concatenation, union, and closure. These closure properties play a critical role in the use of res to build scanners

  Closure under union implies that any finite language is a regular language.
We can construct an re for any finite collection of words by listing them
in a large alternation.

- `Section Review` -- Regular expressions are a concise and powerful notation for specifying
the microsyntax of programming languages. REs build on three basic
operations over finite alphabets: alternation, concatenation, and Kleene
closure. Other convenient operators, such as finite closures, positive
closure, and complement, derive from the three basic operations. Regular
expressions and finite automata are related; any RE can be realized in an
FA and the language accepted by any FA can be described with RE. The
next section formalizes that relationship.

## From Regular Expression to Scanner

- The goal of our work with finite automata is to automate the derivation
of executable scanners from a collection of res. This section develops the
constructions that transform an re into an fa that is suitable for direct implementation and an algorithm that derives an re for the language accepted by
an fa. To present these constructions, we must distinguish between deterministic
fas, or dfas, and nondeterministic fas, or nfas

- `Nondeterministic Finite Automata` -- Recall from the definition of an re that we designated the empty string, , as
an re. None of the fas that we built by hand included ∈, but some of the res
did. What role does ∈ play in an fa? We can use transitions on ∈ to combine
fas and form fas for more complex res.

- `Equivalence of NFAs and DFAs` -- nfas and dfas are equivalent in their expressive power. Any dfa is a special
case of an nfa. Thus, an nfa is at least as powerful as a dfa. Any nfa
can be simulated by a dfa—

- `Regular Expression to NFA:Thompson’s Construction` -- The first step in moving from an re to an implemented scanner must derive
an nfa from the re. Thompson’s construction accomplishes this goal in a
straightforward way. It has a template for building the nfa that corresponds
to a single-letter re, and a transformation on nfas that models the effect of
each basic re operator: concatenation, alternation, and closure.

- `DFA to Minimal DFA: Hopcroft’s Algorithm` -- As a final refinement to the re→dfa conversion, we can add an algorithm
to minimize the number of states in the dfa. The dfa that emerges from
the subset construction can have a large set of states. While this does not
increase the time needed to scan a string, it does increase the size of the
recognizer in memory

- `Section Review` -- Given a regular expression, we can derive a minimal DFA to recognize
the language specified by the RE using the following steps: (1) apply
Thompson’s construction to build an NFA for the RE; (2) use the subset
construction to derive a DFA that simulates the behavior of the RE; and
(3) use Hopcroft’s algorithm to identify equivalent states in the DFA and
construct a minimal DFA. This trio of constructions produces an efficient
recognizer for any language that can be specified with an RE.

  Both the subset construction and the DFA minimization algorithm are
fixed-point computations. They are characterized by repeated application of a monotone function to some set; the properties of the domain
play an important role in reasoning about the termination and complexity of these algorithms. We will see more fixed-point computations in
later chapters

## Implementing Scanners

- For most languages, the
compiler writer can produce an acceptably fast scanner directly from a set
of regular expressions. The compiler writer creates an re for each syntactic
category and gives the res as input to a scanner generator. The generator
constructs an nfa for each re, joins them with E-transitions, creates a corresponding dfa, and minimizes the dfa. At that point, the scanner generator
must convert the dfa into executable code

  This section discusses three implementation strategies for converting a dfa
into executable code: a table-driven scanner, a direct-coded scanner, and a
hand-coded scanner

  All of these scanners operate in the same manner, by
simulating the dfa. They repeatedly read the next character in the input and
simulate the dfa transition caused by that character. This process stops when
the dfa recognizes a word

  These three implementation strategies, table driven, direct coded, and hand
coded, differ in the details of their runtime costs. However, they all have
the same asymptotic complexity—constant cost per character, plus the cost
of roll back

- `Table-Driven Scanners` -- The table-driven approach uses a skeleton scanner for control and a set
of generated tables that encode language-specific knowledge. the compiler writer provides a set of lexical patterns, specified as regular expressions. The scanner generator then produces tables that drive
the skeleton scanner

  The skeleton scanner divides into four sections: initializations, a scanning
loop that models the dfa’s behavior, a roll back loop in case the dfa overshoots the end of the token, and a final section that interprets and reports the
results. The scanning loop repeats the two basic actions of a scanner: read
a character and simulate the dfa’s action.

  The skeleton scanner uses the variable state to hold the current state of
the simulated dfa. It updates state using a two-step, table-lookup process.
First, it classifies char into one of a small set of categories using the CharCat table. The scanner for r[0. . . 9]+ has three categories: Register, Digit, or
Other. Next, it uses the current state and the character category as indices
into the transition table

  __Avoiding Excess Roll Back__ -- 

- `Direct-Coded Scanners` --

- `Hand-Coded Scanners` --

- `Handling Keywords` --

## Advanced Topics

- ` DFA to Regular Expression` --

- `Another Approach to DFA Minimization` --

- `Closure-Free Regular Expressions` --

## Chapter Summary and Perspective

- `Chapter Notes` --

<br>
<Br>

