# Ryan's Bash Scripting Tutorial

- The following pages are intended to give you a solid foundation in how to write Bash scripts, to get the computer to do complex, repetitive tasks for you. You won't be a bash guru at the end but you will be well on your way and armed with the right knowledge and skills to get you there if that's what you want
  
  Bash scripts are used by Systems Administrators, Programmers, Network Engineers, Scientists and just about anyone else who uses a Linux/ Unix system regularly. No matter what you do or what your general level of computer proficiency is, you can generally find a way to use Bash scripting to make your life easier. Bash is a command line language. The name stands for Bourne Again SHell. It is an open source version of the Bourne Shell and was first released in 1989.
  
- This Bash scripting tutorial is divided into 8 sections:
  - 1 - What is a Bash Script - What are they, how do they work and how to run them.
  - 2 - Variables - Store data temporarily for later use.
  - 3 - Input - Different ways to supply data and directions to your Bash script.
  - 4 - Arithmetic - Perform various arithmetic operations in your Bash script.
  - 5 - If Statements - How to make decisions within your Bash script.
  - 6 - Loops - A variety of ways to perform repetitive tasks.
  - 7 - Functions - Reuse code to make life easier.
  - 8 - User Interface - Make your scripts user friendly.
 
  
<br>
<br>

---

<br>
<br>

# What is a Bash Script

- This page is mostly foundation information. It's kinda boring but essential stuff that will help you to appreciate why and how certian things behave the way they do once we start playing about with the fun stuff

### So what exactly are they ?

-  In the context of Bash scripts we are telling the Bash shell what it should do. A Bash script is a plain text file which contains a series of commands. These commands are a mixture of commands we would normally type ouselves on the command line (such as ls or cp for example) and commands we could type on the command line but generally wouldn't 

  An important point to remember though is: __Anything you can run normally on the command line can be put into a script and it will do exactly the same thing. Similarly, anything you can put into a script can also be run normally on the command line and it will do exactly the same thing.__
  
- Linux is an extensionless system so a script doesn't necessarily have to have this characteristic in order to work. But never the less It is convention to give files that are Bash scripts an extension of `.sh`

### How do they work ?

- In the realm of Linux (and computers in general) we have the concept of programs and processes. A program is a blob of binary data consisting of a series of instructions for the CPU and possibly other resources (images, sound files and such) organised into a package and typically stored on your hard disk. When we say we are running a program we are not really running the program but a copy of it which is called a process. What we do is copy those instructions and resources from the hard disk into working memory (or RAM). We also allocate a bit of space in RAM for the process to store variables (to hold temporary working data) and a few flags to allow the operating system (OS) to manage and track the process during it's execution. `Essentially a process is a running instance of a program.`

  When we are at the terminal we have a Bash process running in order to give us the Bash shell. If we start a script running it doesn't actually run in that process but instead starts a new process to run inside.

### How do we run them ? 

-  Before we can execute a script it must have the execute permission set (for safety reasons this permission is generally not set by default)
    ```
    $ chmod +x file.sh
    ```
    and than  run it with:
    ```
    $ ./file.sh
    ```

- Do you want to know why we run it with `./` ? click here to read more: https://ryanstutorials.net/bash-scripting-tutorial/bash-script.php#running

### The Shebang(#!)

- Every bash file starts with this:
  ```
  #!/bin/bash
  ```
  This is the first line of the script above. The hash exclamation mark ( #! ) character sequence is referred to as the Shebang. Following it is the path to the interpreter (or program) that should be used to run (or interpret) the rest of the lines in the text file. (For Bash scripts it will be the path to Bash, but there are many other types of scripts and they each have their own interpreter.)
  
  Formatting is important here. The shebang must be on the very first line of the file (line 2 won't do, even if the first line is blank). There must also be no spaces before the # or between the ! and the path to the interpreter.
  
  Whilst you could use a relative path for the interpreter, most of the time you are going to want to use an absolute path. You will probably be running the script from a variety of locations so absolute is the safest
  
- It is possible to leave out the line with the shebang and still run the script but it is unwise. Plus it is good practice to add shebang to most of your scripts not just bash. You can use python too :
  ```
  #!/bin/python
  ```
  This makes it executable like bash with `./` but it is the other way around too, if you do not want to use shebang with bash you can run it like you runa python, ruby, js script:
  ```
  bash filename.sh
  ```

### Formatting 

- As we saw above, formatting for the shebang was important (ie no spaces, must be on first line). There are many areas in Bash scripts where formatting is important. Typically it involves spaces and either the presence or absence of a space can be the difference between the command working or not.

<br>
<br>

---

<Br>
<Br>
  
# Variables 

- I am not going to note about the logic behind variables, since i already know it. This is just the pinpoints of how to write them in bash.

- Here are a few quick points on syntax. They will be elaborated on and demonstrated as we go into more detail below:
  - When referring to or reading a variable we place a `$` sign before the variable name.
  - When setting a variable we leave out the `$` sign.
  - Some people like to always write variable names in uppercase so they stand out. It's your preference however. They can be all uppercase, all lowercase, or a mixture.
  - A variable may be placed anywhere in a script (or on the command line for that matter) and, when run, Bash will replace it with the value of the variable. This is made possible as the substitution is done before the command is run.
  
### Command Line Variables

- You can use all of the command line blocks inside a sciprt such as:
  ```sh
  #!/bin/bash
  
  cd desktop
  touch file1.txt
  ```

### Other Special Variables

- There are a few other variables that the system sets for you to use as well.
  - `$0` - The name of the Bash script.
  - `$1 - $9` - The first 9 arguments to the Bash script. (We will see usage of them in Input.)
  - `$#` - How many arguments were passed to the Bash script.
  - `$@` - All the arguments supplied to the Bash script.
  - `$?` - The exit status of the most recently run process.
  - `$$` - The process ID of the current script.
  - `$USER` - The username of the user running the script.
  - `$HOSTNAME` - The hostname of the machine the script is running on.
  - `$SECONDS` - The number of seconds since the script was started.
  - `$RANDOM` - Returns a different random number each time is it referred to.
  - `$LINENO` - Returns the current line number in the Bash script.

  __Note:__ If you type the command `env` on the command line you will see a listing of other variables which you may also refer to.

### Setting Our Own Variables

- This is one of those areas where formatting is important. Note there is no space on either side of the equals ( = ) sign. We also leave off the $ sign from the beginning of the variable name when setting it.
  ```
  foo=Hello
  bar=Fred
  
  echo $foo $bar
  
  dirname=/Users/demir/desktop
  
  ls $dirname
  ```
  As you can see you can do houdini shit with files directories and paths.

### Quotes

- Usage of strings is tricky if you are useing dirnames ... etc. you do not have to use quotes (strings) but it is good ractice to use them and anything more than a single word, it requires the data of the variable to be a string:
  ```sh
  $ myvar='Hello World'
  $ echo $myvar
  Hello World
  $ newvar="More $myvar"
  $ echo $newvar
  More Hello World
  ```

### Command Substition

- Command substitution allows us to take the output of a command or program (what would normally be printed to the screen) and save it as the value of a variable. To do this we place it within brackets, preceded by a $ sign.
  ```sh
  myvar=$( ls /etc | wc -l )
  echo There are $myvar entries in the directory /etc
  ```

- `Remember`: Command substitution is nice and simple if the output of the command is a single word or line. If the output goes over several lines then the newlines are simply removed and all the output ends up on a single line.
  
### Exporting Variables

- Remember how in the previous section we talked about scripts being run in their own process? This introduces a phenomenon known as scope which affects variables amongst other things. The idea is that variables are limited to the process they were created in. Normaly this isn't an issue but sometimes, for instance, a script may run another script as one of its commands. If we want the variable to be available to the second script then we need to export the variable.

  The exapmle to note from the tutorial is kinda long so re-read it if you want to : https://ryanstutorials.net/bash-scripting-tutorial/bash-variables.php#exporting Remember how in the previous section we talked about scripts being run in their own process? This introduces a phenomenon known as scope which affects variables amongst other things. The idea is that variables are limited to the process they were created in. Normaly this isn't an issue but sometimes, for instance, a script may run another script as one of its commands. If we want the variable to be available to the second script then we need to export the variable.


<br>
<br>

---

<br>
<br>

# Input

### Ask User for Input

- If we would like to ask the user for input then we use a command called read. This command takes the input and will save it into a variable.
  ```sh
  read var1
  ```
  Real life usage
  ```sh 
  echo Hello, who am I talking to?
  read varname
  echo It\'s nice to meet you $varname
  ```
  
- You are able to alter the behaviour of read with a variety of command line options. (See the man page for read to see all of them.) Two commonly used options however are `-p` which allows you to specify a prompt and `-s` which makes the input silent. This can make it easy to ask for a username and password combination like the example below:
  ```sh
  read -p 'Username: ' uservar
  read -sp 'Password: ' passvar
  echo "\n"
  echo Thankyou $uservar we now have your login details
  ```

- `More Variables` : So far we have looked at a single word as input. We can do more than that however:
  ```sh
  echo What cars do you like?
  
  read car1 car2 car3
  
  echo Your first car was: $car1
  echo Your second car was: $car2
  echo Your third car was: $car3
  ```
  
### Command Line Arguments (inputs)

- Do you remember that `$1 - $9 - The first 9 arguments to the Bash script` was mentioned above. Now we will use them to to use the functionality of command line arguments.
  ```sh
  echo Output: $1 , $2 , $3
  ```
  Lets run it:
  ```
  $ file.sh hello mon ami
  Output: hello mon ami 
  ```

### Reading from STDIN

- It's common in Linux to pipe a series of simple, single purpose commands together to create a larger solution tailored to our exact needs. The ability to do this is one of the real strenghs of Linux. It turns out that we can easily accommodate this mechanism with our scripts also. By doing so we can create scripts that act as filters to modify data in specific ways for us.

 I understood the linux part but I did no neccessairly get how to use the bash part of the STDIN< STDOUT and STDERR. Re-read: 
  - https://ryanstutorials.net/bash-scripting-tutorial/bash-input.php#stdin

<br>
<Br>
  
---

<br>
<Br>
  
# Arithmetic

- There are several ways to go about arithmetic in Bash scripting. We'll cover them for completeness but the recommended approach is arithmetic expansion (covered last).

### Let

- let is a builtin function of Bash that allows us to do simple arithmetic. It follows the basic format:
  ```
  let <arithmetic expression>
  ```
  Let's look at a simple example:
  ```sh
  let a=5+4*6/5/2
  
  # or
  let a++
  let a--
  
  #or 
  let $var1 + $var2
  ```

### Expr

- `expr` is similar to let except instead of saving the result to a variable it instead prints the answer. Unlike let you don't need to enclose the expression in quotes. You also must have spaces between the items of the expression. It is also common to use expr within command substitution to save the output to a variable.
  ```sh
  expr 5 + 4
  
  # or subtite the command
  
  a=$( expr 10 - 3 )
  echo $a
  ```

### Double Parantheses

- In the section on Variables we saw that we could save the output of a command easily to a variable. It turns out that this mechanism is also able to do basic arithmetic for us if we tweak the syntax a little. We do so by using double brackets like so:
  ```sh
  a=$(( 4 + 5 ))
  echo $a # 9
  ```
  Because if you look close the first parantheses actually adds 4 and 5 and then the output 9 gets enclosed inside var $a. which we echo it later on.

### Length of a Variable

- This isn't really arithmetic but it can be quite useful. If you want to find out the lengh of a variable (how many characters) you can do the following:
  ```
  ${#variable}
  ```
  Here's an example:
  ```sh
  a='Hello World'
  echo ${#a} # 11
  ```

<br>
<br>

---

<bR>
<br>
  
# If Statements

- I am not going to note down the logic of if statements since I know them already these are the notes that i should know about.

### If, Elif and Else

- You can write if and else statements in bash scrips like this (There aren't any rules regarding indenting in Bash so you may indent or not indent however you like and your scripts will still run exactly the same, but indent nevertheless and always pay attention to the syntax of your scripts)
  ```sh
  a=1
  b=2
  
  if [ $a -gt $b ]
  then
    echo "a is greater than b"
  elif [ $a == $b ]
  then
    echo "a is equal to b"
  else:
    echo "b is greater than a"
  fi
  ```

### Comparison Operators

### Boolean Operations

<br>
<br>

---

<br>
<Br>
  
# Loops 
