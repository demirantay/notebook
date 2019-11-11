- [Part 2](./README2.md)

---

<br>

# Grep and Regular Expressions

- In the previous section we looked at a collection of filters that would manipulate data for us. In this section we will look at another filter which is quite powerful when combined with a concept called regular expressions or re's for short. Re's can be a little hard to get your head around at first so don't worry if this stuff is a little confusing.

  I will create another dir and note files dedicated just for regular expressions

### What are they ?

- Regular expressions are similar to the wildcards that we looked at in section 7. They allow us to create a pattern. They are a bit more powerful however. Re's are typically used to identify and manipulate specific pieces of data. eg. we may wish to identify every line which contains an email address or a url in a set of data.

  They are basically more powerful wildcards on steroids
  
- > The characters used in regular expressions are the same as those used in wildcards. Their behaviour is slightly different     however. A common mistake is to forget this and get their functions mixed up.

### grep

- egrep is a program which will search a given set of data and print every line which contains a given pattern. It is an extension of a program called grep. It's name is odd but based upon a command which did a similar function, in a text editor called ed. It has many command line options which modify it's behaviour so it's worth checking out it's man page. ie the -v option tells grep to instead print every line which does not match the pattern.
  ```
  egrep [command line options] <pattern> [path]
  ```
  
  Lets use the `mysampledata.txt` file defined in the perivious part and use its inner data for grep:
  ```
  $ egrep 'mellon' mysampledata.txt
  
  Mark watermellons 12
  Oliver rockmellons 2
  ```
  The basic behaviour of egrep is that it will print the entire line for every line which contains a string of characters matching the given pattern. This is important to note, we are not searching for a word but a string of characters.

### Learning Regular Expressions

### Regular Exxpressions Overview

<Br>
<br>

---

<br>
<br>

# Piping and Redirection
