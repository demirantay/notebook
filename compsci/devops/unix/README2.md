- [Part 1](./README.md)

---

<Br>

# Unix/Linux Shell Scripting 

- A shell script is a computer program designed to be run by the Unix/Linux shell which could be one of the following:
  - The Bourne Shell
  - The C Shell
  - The Korn Shell
  - The GNU Bourne-Again Shell
  
  A shell is a command-line interpreter and typical operations performed by shell scripts include file manipulation, program execution, and printing text.
  
- The shell scripts are, after all, a real programming language, complete with variables, control structures, and so forth. No matter how complicated a script gets, it is still just a list of commands executed sequentially.

  The following script uses the read command which takes the input from the keyboard and assigns it as the value of the variable PERSON and finally prints it on STDOUT.
  ```sh
  #!/bin/sh
  
  # Author: Zara Ali
  # SCript is below here:
  
  echo "What is your name?"
  read PERSON
  echo "Hello, $PERSON"
  ```
  and you run this script with the following:
  ```
  $ ./filename.sh
  What is your name?
  Foo
  Hello, Foo
  ```

<br>
<br>

---

<br>
<br>

# What is the Shell

- A `Shell` provides you with an interface to the Unix system. It gathers input from you and executes programs based on that input. When a program finishes executing, it displays that program's output.
  
  Shell is an environment in which we can run our commands, programs, and shell scripts. There are different flavors of a shell, just as there are different flavors of operating systems. Each flavor of shell has its own set of recognized commands and functions.
  
### Shell Prompt

- The prompt, `$`, which is called the `command prompt`, is issued by the shell. While the prompt is displayed, you can type a command.
  
  Shell reads your input after you press `Enter`. It determines the command you want executed by looking at the first word of your input. A word is an unbroken set of characters. Spaces and tabs separate words.
  
### Shell Types

- In Unix, there are two major types of shells −
  - `Bourne shell` − If you are using a Bourne-type shell, the $ character is the default prompt
  - `C shell` − If you are using a C-type shell, the % character is the default promp
  
  Bourne shell was the first shell to appear on Unix systems, thus it is referred to as "the shell". But C shell is not worse than bourne shell just different characteristics.
  
### Script Info

- Remember: Shell scripts and functions are both interpreted. This means they are not compiled. 

- Note all the scripts would have the `.sh` extension. Before you add anything else to your script, you need to alert the system that a shell script is being started. This is done using the `shebang` construct. For example −
  ```sh
  #!/bin/sh
  ```
  This tells the system that the commands that follow are to be executed by the Bourne shell. It's called a shebang because the # symbol is called a hash, and the ! symbol is called a bang.
  
  To create a simple exmpalry script containing these commands, you put the shebang line first and then add the commands −
  ```sh
  #!/bin/bash
  pwd
  ls
  ```
  Save the above content and make the script executable −
  ```
  $ chmod +x text.sh
  ```
  The shell script is now ready to be executed
  ```
  $ ./test.sh
  ```
  
<br>
<br>

---

<br>
<br>

# Shell Variables

- I am not going to note down the logic about variables since I have done that for numerous times in different files, I am just going to show to how to write shell vaariables:

  But remember: By convention, Unix shell variables will have their names in UPPERCASE.
  ```sh
  VAR1="Zara Ali"
  VAR2=100
  ```
  To access the value stored in a variable, prefix its name with the dollar sign `($)` −
  ```
  echo $VAR1
  echo $VAR2
  ```

### Read-only Variables

- Shell provides a way to mark variables as read-only by using the read-only command. After a variable is marked read-only, its value cannot be changed. (It is basically a way to create `constant` variables:
  ```sh
  #!/bin/sh
  
  NAME="foo"
  readonly NAME
  NAME="new value"  #<- This creates an error
  ```

### Unsetting Variables

- Unsetting or deleting a variable directs the shell to remove the variable from the list of variables that it tracks. Once you unset a variable, you cannot access the stored value in the variable.
  ```sh
  NAME="foo"
  unsertNAME
  echo $NAME   #<-- prints nothing
  ```
  You cannot use the unset command to unset variables that are marked readonly.
  
### Variable Types

- When a shell is running, three main types of variables are present −
  - `Local Variables` − A local variable is a variable that is present within the current instance of the shell. It is not available to programs that are started by the shell. They are set at the command prompt.
  - `Environment Variables` − An environment variable is available to any child process of the shell. Some programs need environment variables in order to function correctly. Usually, a shell script defines only those environment variables that are needed by the programs that it runs.
  - `Shell Variables` − A shell variable is a special variable that is set by the shell and is required by the shell in order to function correctly. Some of these variables are environment variables whereas others are local variables.
  
<br>
<br>

---

<br>
<br>

# Special Variables 

- In this chapter, we will discuss in detail about special variable in Unix. In one of our previous chapters, we understood how to be careful when we use certain nonalphanumeric characters in variable names. This is because those characters are used in the names of special Unix variables. These variables are reserved for specific functions.

  The following table shows a number of special variables that you can use in your shell scripts −
  - 1 - `$0` : The filename of the current script.
  - 2 - `$n` : These variables correspond to the arguments with which a script was invoked
  - 3 - `$#` : The number of arguments supplied to a script.
  - 4 - `$*` : All the arguments are double quoted. If a script receives two arguments, $* is equivalent to $1 $2.
  - 5 - `$@` : All the arguments are individually double quoted. If a script receives two arguments, $@ is equivalent to $1 $2.
  - 6 - `$?` : The exit status of the last command executed.
  - 7 - `$$` : The process number of the current shell. For shell scripts, this is the process ID under which they are executing.
  - 8 - `$!` : The process number of the last background command.

### Command-Line Arguments

- The command-line arguments $1, $2, $3, ...$9 are positional parameters, with $0 pointing to the actual command, program, shell script, or function and $1, $2, $3, ...$9 as the arguments to the command.

  Following script uses various special variables related to the command line −
  ```sh
  #!/bin/sh

  echo "File Name: $0"
  echo "First Parameter : $1"
  echo "Second Parameter : $2"
  echo "Quoted Values: $@"
  echo "Quoted Values: $*"
  echo "Total Number of Parameters : $#"
  ```
  Here is a sample run for the above script −
  ```
  $./test.sh Zara Ali
  File Name : ./test.sh
  First Parameter : Zara
  Second Parameter : Ali
  Quoted Values: Zara Ali
  Quoted Values: Zara Ali
  Total Number of Parameters : 2
  ```
  
### Difference Between $* vs $@

- There are special parameters that allow accessing all the command-line arguments at once. $* and $@ both will act the same unless they are enclosed in double quotes, "".

  Both the parameters specify the command-line arguments. However, the "$*" special parameter takes the entire list as one argument with spaces between and the "$@" special parameter takes the entire list and separates it into separate arguments.
  
  Lets see an exmaple:
  ```sh
  #!/bin/sh

  for TOKEN in $*
  do
     echo $TOKEN
  done
  ```
  Here is a sample run for the above script −
  ```
  $./test.sh Zara Ali 10 Years Old
  Zara
  Ali
  10
  Years
  Old
  ```
  
<br>
<br>

---

<br>
<br>

# Shell Arrays

- I am not going to note down the logic of the arrays, I am just going to note down about how to write arrays in shell scripts. You can write arrays in the following matter:
  ```sh
  NAME[0]="Zara"
  NAME[1]="Qadir"
  NAME[2]="Mahnaz"
  NAME[3]="Ayan"
  NAME[4]="Daisy"
  ```

- After you have set any array variable, you access it as follows:
  ```
  ${array_name[index]}
  ```
  Let's see a real world example:
  ```sh
  #!/bin/sh

  NAME[0]="Zara"
  NAME[1]="Qadir"
  
  echo "First Index: ${NAME[0]}"
  ```
  You can access all the items in an array in one of the following ways −
  ```sh
  ${array_name[*]}
  ${array_name[@]}
  ```
  
<br>
<br>

---

<br>
<br>

# Shell Control Statements and Shell Operators

- I am not going to note down the logic behind if statments. I am just going to note down how to write them in a .sh fashion:
  ```sh
  #!/bin/sh
  a=10
  b=20
  
  # if statement
  if [ $a == $b ]
  then 
    echo "a is equal to b"
  elif [ $a -gt $b ]
  then 
    echo "a is greater than b"
  elif [ $a -lt $b ]
  then
    echo "a is less than b"
  else
    echo "none of the condition is met"
  fi
  ```
  
- As you can se .sh does can use normal operators such as `>`, `<` ... etc. Lets see the usual operators of shell scripts:
  - `-eq` is equivelent of `==`
  - `-ne` is equievelent of `!=`
  - `-gt` is equivelent of `>`
  - `-lt` is equeivelent of `<`
  - `-ge` is equievelent of `>=`
  - `-le` is equievelent of `<=`
  
<br>
<br>

---

<br>
<br>

# Shell Loops and Loop Control
  
- I am not going to note down about the logic behind loops in programming, I am just going to note how to write them in bash scripting langauge:
  
  while loop:
  ```sh
  while [ $foo -lt 10 ]
  do 
    exho $foo
    foo=`expr $foo + 1`
  done
  ```
  
  for loop:
  ```sh
  for var in 0 1 2 3 4 5 6 7 8 9
  do 
    echo $var
  done 
  ```
  
  until loop:
  ```sh
  until [ ! $foo -lt 1 ]
  do 
    exho $foo
    foo=`expr $foo + 1`
  done
  ```
  (unitl loop is a negative while loop like (e.g. != instead of ==)
  
  select loop:
  (I am gonna note a select example but I do not use it on a day to day basis, so it is here just for a refresher)
  ```sh
  #!/bin/ksh

  select DRINK in tea cofee water juice appe all none
  do
     case $DRINK in
        tea|cofee|water|all) 
           echo "Go to canteen"
           ;;
        juice|appe)
           echo "Available at home"
        ;;
        none) 
           break 
        ;;
        *) echo "ERROR: Invalid selection" 
        ;;
     esac
  done
  ```
  
- You can also use loop controls:
  - break
  - continue
  
  lets see a real world example:
  ```sh
  a=0
  
  while [ $a -lt 10 ]
  do 
    if [ $a -eq 5 ]
    then
      break
    fi
    a=`expr $a + 1`
  done
  ```
  
<br>
<br>

---

<br>
<br>

# Shell Substitutions

There are variable subtitions too, but I am too lazy to note this section at the moment. This is where I left of: https://www.tutorialspoint.com/unix/unix-shell-substitutions.htm

<br>
<br>

---

<br>
<br>

# Shell Quoting Mechanisms

- Unix Shell provides various metacharacters which have special meaning while using them in any Shell Script and causes termination of a word unless quoted.

  For example, `?` matches with a single character while listing files in a directory and an `*` matches more than one character. Here is a list of most of the shell special characters (also called metacharacters) −
  ```
  * ? [ ] ' " \ $ ; & ( ) | ^ < > new-line space tab
  ```
  
  For example let's see a real world usage of metacharacters
  ```sh
  echo Hello; Word  # this will cause an error
  ```
  but lets try with a escape metacharacter
  ```sh
  echo Hello\; Word  # corects because now it can output the ;
  ```
  
  ... `continue`

<br>
<br>

---

<br>
<br>

# Shell Input/Output Redirections

- In this chapter, we will discuss in detail about the Shell input/output redirections. Most Unix system commands take input from your terminal and send the resulting output back to your terminal. A command normally reads its input from the standard input, which happens to be your terminal by default. Similarly, a command normally writes its output to standard output, which is again your terminal by default.

### Output Redirection




<br>
<br>

---

<br>
<br>

# Shell Functions

- I am not going to write about the logic of the shell functions, I m just going to note down how to write it in .sh -
  ```sh
  # define your function here
  hello () {
    echo "hello world"
  } 
  
  # invoke your function
  hello
  ```
  
- Writing functions with Parameters is little bit funky but not hard see this:
  ```sh
  #definition
  Hello() {
    echo "Hello world $param1 $param2"
  }
  
  #invoke
  Hello Foo Bar
  ```

<br>
<br>

---

<br>
<br>

# Shell Manpage Help

- All the Unix commands come with a number of optional and mandatory options. It is very common to forget the complete syntax of these commands.

  Because no one can possibly remember every Unix command and all its options, we have online help available to mitigate this right from when Unix was at its development stage.
  
  Unix's version of Help files are called man pages. If there is a command name and you are not sure how to use it, then Man Pages help you out with every step.
  
- Here is the simple command that helps you get the detail of any Unix command while working with the system −
  ```
  $man command
  ```
  Lets see a real world example:
  ```
  $man ls
  ```
  
- But i keep a list of useful commands that i like to use on my own cheatsheet

<br>
<br>

---

<br>
<br>

- [Part 3](./README3.md)
  
  

  
