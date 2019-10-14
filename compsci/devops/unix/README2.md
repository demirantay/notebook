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




  
