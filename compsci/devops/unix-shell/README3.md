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
  
  Sometimes we want to know not only which lines matched but their line number as well. Use `n` option
  ```
  egrep -n 'mellon' mysampledata.txt
  ```

### Learning Regular Expressions

- I will dedicate another regex tutorial in a different directory but since we are dipping our toes in the water at the moment. You are 100% going to make mistakes while coding regexpressions. So here is a structured debugging strategy:
  - First off, check for typo's. If you're like me then you're prone to making them.
  - Maybe what you thought a particular operator did was slightly different to what it actually does and re reading you will notice a point you may have missed the first time.
  - Break your pattern down into individual components and test each of these individually. This will help you to get a feel for which parts of the pattern is right and which parts you need to adjust.
  - Examine your output. Your current pattern may not have worked the way you want but we can still learn from it. Looking at what we actually did match and using it to help understand what actually did happen will help us to work out what we should try changing to get closer to what we actually want.

### Regular Exxpressions Overview

- I will outline the basic building blocks of regex's below then follow on with a set of examples to demonstrate their usage.
  - `.` (dot) - a single character.
  - `?` - the preceding character matches 0 or 1 times only.
  - `*` - the preceding character matches 0 or more times.
  - `+` - the preceding character matches 1 or more times.
  - `{n}` - the preceding character matches exactly n times.
  - `{n,m}` - the preceding character matches at least n times and not more than m times.
  - `[agd]` - the character is one of those included within the square brackets. 
  - `[^agd]` - the character is not one of those included within the square brackets.
  - `[c-f]` - the dash within the square brackets operates as a range. In this case it means either the letters c, d, e or f.
  - `()` - allows us to group several characters to behave as one.
  - `|` (pipe symbol) - the logical OR operation
  - `^` - matches the beginning of the line.
  - `$` - matches the end of the line.
  
- Again as I said we will learn more abut regular expressions in a different note file this is just a summary. But lets see some exmaples:
  
  The number 2 as the last character on the line.
  ```
  $ egrep '2$' mysampledata.txt
  
  Mark watermellons 12
  Susy oranges 12
  Oliver rockmellons 2
  ```
  
  Maybe we wish to see orders for everyone who's name begins with A - K.
  ```
  $ egrep '^[A-K]' mysampledata.txt
 
  Fred apples 20
  Anne mangoes 7
  Greg pineapples 3
  Betty limes 14
  ```

<Br>
<br>

---

<br>
<br>

# Piping and Redirection

- In the previous two sections we looked at a collection of filters that would manipulate data for us. In this section we will see how we may join them together to do more powerful data manipulation.

### What are they ?

- Every program we run on the command line automatically has three data streams connected to it.
  - `STDIN (0)` - Standard input (data fed into the program)
  - `STDOUT (1)` - Standard output (data printed by the program, defaults to the terminal)
  - `STDERR (2)` - Standard error (for error messages, also defaults to the terminal)
  
  Piping and redirection is the means by which we may connect these streams between programs and files to direct data in interesting and useful ways.

### Redirecting to a File

- Normally, we will get our output on the screen, which is convenient most of the time, but sometimes we may wish to save it into a file to keep as a record, feed into another system, or send to someone else. The greater than operator ( > ) indicates to the command line that we wish the programs output (or whatever it sends to STDOUT) to be saved in a file instead of printed to the screen. Let's see an example.
  ```
  $ ls
  barry.txt bob example.png firstfile foo1 video.mpeg
  $ ls > myoutput
  $ ls
  barry.txt bob example.png firstfile foo1 myoutput video.mpeg
  $ cat myoutput
  barry.txt
  bob
  example.png
  firstfile
  foo1
  myoutput
  video.mpeg
  ```
  
- You'll notice that in the above example, the output saved in the file was one file per line instead of all across one line when printed to the screen. The reason for this is that the screen is a known width and the program can format its output to suit that. When we are redirecting, it may be to a file, or it could be somewhere else, so the safest option is to format it as one entry per line. This also allows us to easier manipulate that data later on

- __REMEMBER:__ If we redirect to a file which does not exist, it will be created automatically for us. If we save into a file which already exists, however, then it's contents will be cleared, then the new output saved to it.
  ```
  $ cat myoutput
  barry.txt
  bob
  example.png
  firstfile
  foo1
  myoutput
  video.mpeg
  $ wc -l barry.txt > myoutput
  $ cat myoutput
  7 barry.txt
  ```
  __BUT__ We can instead get the new data to be appended to the file by using the double greater than operator (` >> `).
  ```
  $ cat myoutput
  7 barry.txt
  $ ls >> myoutput
  $ cat myoutput
  7 barry.txt
  barry.txt
  bob
  example.png
  firstfile
  foo1
  myoutput
  video.mpeg
  ```
  
### Redirecting from a File

- If we use the less than operator ( < ) then we can send data the other way. We will read data from the file and feed it into the program via it's STDIN stream.

### Redirecting STDERR

- Now let's look at the third stream which is Standard Error or STDERR. The three streams actually have numbers associated with them (in brackets in the list at the top of the page). STDERR is stream number 2 and we may use these numbers to identify the streams. If we place a number before the > operator then it will redirect that stream (if we don't use a number, like we have been doing so far, then it defaults to stream 1).
  ```
  $ ls -l video.mpg blah.foo
  ls: cannot access blah.foo: No such file or directory
  -rwxr--r-- 1 ryan users 6 May 16 09:14 video.mpg
  $ ls -l video.mpg blah.foo 2> errors.txt
  -rwxr--r-- 1 ryan users 6 May 16 09:14 video.mpg
  $ cat errors.txt
  ls: cannot access blah.foo: No such file or directory
  ```

### Piping 

- So far we've dealt with sending data to and from __files__. Now we'll take a look at a mechanism for sending data from one __program__ to another. It's called piping and the operator we use is ( `|` ).  What this operator does is feed the output from the program on the left as input to the program on the right. In the example below we will list only the first 3 files in the directory.
  ```
  $ ls
  barry.txt bob example.png firstfile foo1 myoutput video.mpeg
  $ ls | head -3
  barry.txt
  bob
  example.png
  ```
  We may pipe as many programs together as we like. In the below example we have then piped the output to tail so as to get only the third file.
  ```
  ls | head -3 | tail -1
  example.png
  ```

- > I often find people try and write their pipes all out in one go and make a mistake somewhere along the line. They then         think it is in one point but in fact it is another point. They waste a lot of time trying to fix a problem that is not         there while not seeing the problem that is there. If you build your pipes up incrementally then you won't fall into this       trap. Run the first program and make sure it provides the output you were expecting. Then add the second program and           check again before adding the third and so on. This will save you a lot of frustration.

- You may combine pipes and redirection too. e.g.
  ```
  ls | head -3 | tail -1 > myoutput
  ```

<br>
<br>

---

<br>
<br>

# Process Management

- Linux in general is a fairly stable system. Occasionally, things do go wrong however and sometimes we also wish to tweak the running of the system to better suit our needs

### What are they ?

- A program is a series of instructions that tell the computer what to do. When we run a program, those instructions are copied into memory and space is allocated for variables and other stuff required to manage its execution. This running instance of a program is called a process and it's processes which we manage.

### What is Currently Running

- Linux, like most modern OS's is a multitasking operating system. This means that many processes can be running at the same time. As well as the processes we are running, there may be other users on the system also running stuff and the OS itself will usually also be running various processes which it uses to manage everything in general. If we would like to get a snapshot of what is currently happening on the system we may use a program called `top`.
  ```
  $ top
  ```
  Below is a simplified version of what you should see when you run this program.
  ```
  $ top
  Tasks: 174 total, 3 running, 171 sleeping, 0 stopped
  KiB Mem: 4050604 total, 3114428 used, 936176 free
  Kib Swap: 2104476 total, 18132 used, 2086344 free

   PID USER %CPU %MEM COMMAND
  6978 ryan 3.0  21.2 firefox
    11 root 0.3   0.0 rcu_preempt
  6601 ryan 2.0   2.4 kwin
  ```
  Let's break it down:
    - Tasks is just another name for processes. It's typical to have quite a few processes running on your system at any given time. Most of them will be system processes. Many of them will typically be sleeping. This is ok. It just means they are waiting until a particular event occurs, which they will then act upon.
    -  This is a breakdown of working memory (RAM). Don't worry if a large amount of your memory is used. Linux keeps recently used programs in memory to speed up performance if they are run again. If another process needs that memory, they can easily be cleared to accommodate this.
    - This is a breakdown of Virtual memory on your system. If a large amount of this is in use, you may want to consider increasing it's size. For most people with most modern systems having gigabytes of RAM you shouldn't experience any issues here.
    - Finally is a listing of the most resource intensive processes on the system (in order of resource usage). This list will update in real time and so is interesting to watch to get an idea of what is happening on your system. The two important columns to consider are memory and CPU usage. If either of these is high for a particular process over a period of time, it may be worth looking into why this is so.The USER column shows who owns the process and the PID column identifies a process's Process ID which is a unique identifier for that process.
    
    
- Top will give you a realtime view of the system and only show the number of processes which will fit on the screen. Another program to look at processes is called ps which stands for processes. In it's normal usage it will show you just the processes running in your current terminal (which is usually not very much). If we add the argument aux then it will show a complete system view which is a bit more helpful.
  ```
  $ ps [aux]
  ```
  It does give quite a bit of output so people usually pipe the output to `grep` to filter out just the data they are after. We will see in the next bit an example of this.
  
### Killing a Crashed Process

- It doesn't happen often, but when a program crashes, it can be quite annoying. Let's say we've got our browser running and all of a sudden it locks up. You try and close the window but nothing happens, it has become completely unresponsive. No worries, we can easily kill Firefox and then reopen it. To start off we need to identify the process id.
  ```
  kill [signal] <PID>
  ```
  Lets say we have an program running in the system and we want to kill it:
  ```
  $ kill 6978
  ```
  As said above you need to know the processes id with either `top` or `ps`

### Foreground and Background Jobs

- I am really tired and do not want to note this section. Se here you fucking go, read it from the source: 
  - https://ryanstutorials.net/linuxtutorial/processes.php#fgbg

<br>
<br>

---

<br>
<br>

- [Part 4](./README4.md)
