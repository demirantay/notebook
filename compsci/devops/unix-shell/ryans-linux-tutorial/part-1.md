# Ryan's Linux/Unix Tutorial

- The following pages are intended to give you a solid foundation in how to use the terminal, to get the computer to do useful work for you. You won't be a Unix guru at the end but you will be well on your way and armed with the right knowledge and skills to get you there if that's what you wan
  
  Unix likes to take the approach of giving you a set of building blocks and then letting you put them together. This allows us to build things to suit our needs. With a bit of creativity and logical thinking, mixed in with an appreciation of how the blocks work, we can assemble tools to do virtually anything we want. __The aim is to be lazy__. Why should we do anything we can get the computer to do for us?
  
- This Linux tutorial is divided into 14 sections:
  - 1 - The Command Line - What is it, how does it work and how do I get to one.
  - 2 - Basic Navigation - An introduction to the Linux directory system and how to get around it.
  - 3 - More About Files - Find out some interesting characteristics of files and directories in a Linux environment.
  - 4 - Manual Pages - Learn how to make the most of the Linux commands you are learning.
  - 5 - File Manipulation - How to make, remove, rename, copy and move files and directories.
  - 6 - Vi Text Editor - Discover a powerful Linux based text editor.
  - 7 - Wildcards - Also referred to as globbing, this is a means to refer to several files in one go.
  - 8 - Permissions - Learn to identify and change the permissions of files and directories and what the consequences of these are.
  - 9 - Filters - An introduction to various commands that allow us to mangle data in interesting and useful ways.
  - 10 - Grep and Regular Expressions - Master a powerful pattern matching language that is useful for analysing and processing data.
  - 11 - Piping and Redirection - Join commands together in powerful combinations.
  - 12 - Process Management - See what is currently running on your Linux system and what state the system is in, learn how to kill programs that have hung and put jobs in the background.
  - 13 - Scripting - Be happy. Get the computer to do tedious and repetitive tasks for you.
  - 14 - Cheat Sheet - A quick reference for the main points covered in this tutorial.
  
  
<br>
<br>

---

<br>
<br>

# The Command Line

- A command line, or terminal, is a text based interface to the operating system. You are able to enter commands by typing them on the keyboard and feedback will be given to you similarly as text.

- Within a terminal you have what is known as a shell. This is a part of the operating system that defines how the terminal will behave and looks after running (or executing) commands for you. There are various shells available but the most common one is called `bash` which stands for Bourne again shell.
  
  If you would like to know which shell you are using you may use a command called `echo` to display a system variable stating your current shell. echo is a command which is used to display messages.
  ```
  $ echo $SHELL
  /bin/bash
  ```
  
<br>
<br>

---

<br>
<br>

# Basic Navigation

- In this section, we'll learn the basics of moving around the system. Many tasks rely on being able to get to, or reference the correct location in the system. As such, this stuff really forms the foundation of being able to work effectively in Linux. Make sure you understand it well.

- The first command we are going to learn is `pwd` which stands for Print Working Directory. (You'll find that a lot of commands in linux are named as an abbreviation of a word or words describing them. This makes it easier to remember them.) The command does just that. It tells you what your current or present working directory is. Give it a try now.
  ```
  $ pwd
  /home/user
  ```
  
- It's one thing to know where we are. Next we'll want to know what is there. The command for this task is `ls`. It's short for list. Let's give it a go.
  ```
  $ ls
  home  photoso  file.py  file2.js
  ```
  We can do more with ls however. Below is an outline of its usage:
  ```
  ls [options] [location]
  ```
  In the above example, the square brackets ( [] ) mean that those items are optional, we may run the command with or without them. 
  
### Paths

- In the previous commands we started touching on something called a path. I would like to go into more detail on them now as they are important in being proficient with Linux. Whenever we refer to either a file or directory on the command line, we are in fact referring to a path. ie. A path is a means to get to a particular file or directory on the system.

- `Absolute and Relative Paths` -- There are 2 types of paths we can use, absolute and relative. Whenever we refer to a file or directory we are using one of these paths. Whenever we refer to a file or directory, we can, in fact, use either type of path (either way, the system will still be directed to the same location).

  To begin with, we have to understand that the file system under linux is a hierarchical structure. At the very top of the structure is what's called the root directory. It is denoted by a single slash ( / ). It has subdirectories, they have subdirectories and so on. Files may reside in any of these directories.
  
  Absolute paths specify a location (file or directory) in relation to the root directory. You can identify them easily as they always begin with a forward slash ( / ). Relative paths specify a location (file or directory) in relation to where we currently are in the system. They will not begin with a slash.
  
  Here's an example to illustrate:
  ```
  $ ls Desktop             # relative to the dir you are in now
  
  $ ls /home/user/Desktop  # absolute
  ```
  
- You'll find that a lot of stuff in Linux can be achieved in several different ways. Paths are no different. Here are some more building blocks you may use to help build your paths.
  - `~` (tilde) - This is a shortcut for your home directory. eg, if your home directory is /home/ryan then you could refer to the directory Documents with the path /home/ryan/Documents or ~/Documents
  - `.` (dot) - This is a reference to your current directory. eg in the example above we referred to Documents on line 4 with a relative path. It could also be written as ./Documents (Normally this extra bit is not required but in later sections we will see where it comes in handy).
  - `..` (dotdot)- This is a reference to the parent directory. You can use this several times in a path to keep going up the hierarchy. eg if you were in the path /home/ryan you could run the command ls ../../ and this would do a listing of the root directory.

### Moving Around

- In order to move around in the system we use a command called `cd` which stands for change directory. It works as follows:
  ```
  $ cd desktop
  ```
  Tip: If you run the command cd without any arguments then it will always take you back to your home directory.

<br>
<br>

---

<br>
<br>

# More About Files 
  
- Kinda boring but essential knowledge about the theory. Lets see the important tehories down below:

- `Everything is a File` -- Ok, the first thing we need to appreciate with linux is that under the hood, everything is actually a file. A text file is a file, a directory is a file, your keyboard is a file (one that the system reads from only), your monitor is a file (one that the system writes to only) etc. To begin with, this won't affect what we do too much but keep it in mind as it helps with understanding the behaviour of Linux as we manage files and directories.

- `Linux is an Extensionless System` -- This one can sometimes be hard to get your head around but as you work through the sections it will start to make more sense. A file extension is normally a set of 2 - 4 characters after a full stop at the end of a file, which denotes what type of file it is. The following are common extensions:
  - file.exe - an executable file, or program.
  - file.txt - a plain text file.
  - file.png, file.gif, file.jpg - an image.
  
  In other systems such as Windows the extension is important and the system uses it to determine what type of file it is. Under Linux the system actually ignores the extension and looks inside the file to determine what type of file it is. So for instance I could have a file myself.png which is a picture of me. I could rename the file to myself.txt or just myself and Linux would still happily treat the file as an image file. As such it can sometimes be hard to know for certain what type of file a particular file is. Luckily there is a command called file which we can use to find this out.
  ```
  $ file [path]
  ```
  
- `Linux is Case Sensetive` -- This is very important and a common source of problems for people new to Linux. Other systems such as Windows, Mac OS are case insensitive when it comes to referring to files. Linux is not like this. As such it is possible to have two or more files and directories with the same name but letters of different case.

- `Quotes` -- The first approach involves using quotes around the entire item. You may use either single or double quotes (later on we will see that there is a subtle difference between the two but for now that difference is not a problem). Anything inside quotes is considered a single item.
  ```
  $ cd 'Holiday Photos'
  $ pwd
  /home/ryan/Documents/Holiday Photos
  ```

- `Hidden Files and Directories` -- Linux actually has a very simple and elegant mechanism for specifying that a file or directory is hidden. If the file or directory's name begins with a `.` (full stop) then it is considered to be hidden. You don't even need a special command or action to make a file hidden.
  
  The command ls which we have seen in the previous section will not list hidden files and directories by default. We may modify it by including the command line option `-a` so that it does show hidden files and directories.
  ```
  $ ls -a
  ```

<br>
<br>

---

<br>
<br>

# Manual Pages

- The manual pages are a set of pages that explain every command available on your system including what they do, the specifics of how you run them and what command line arguments they accept. Some of them are a little hard to get your head around but they are fairly consistent in their structure so once you get the hang of it it's not too bad. You invoke the manual pages with the following command:
  ```
  man <command to look up>
  ```
  Lets see a real world example:
  ```
  $ man ls
  
  Name
      ls - list directory contents

  Synopsis
      ls [option] ... [file] ...

  Description
      List information about the FILEs (the current directory by default). Sort entries alphabetically if none of -cftuvSUX nor --sort is specified.

      Mandatory arguments to long options are mandatory for short options too.

      -a, --all
          do not ignore entries starting with .

      -A, --almost-all
          do not list implied . and ..

  ...
  ```
  - First it tells us the actual command followed by a simple one line description of it's function.
  -  synopsis. This is really just a quick overview of how the command should be run. Square brackets ( [ ] ) indicate that something is optional. (option on this line refers to the command line options listed below the description)
  - Description:  presents us with a more detailed description of the command. and all the command line options that are available for the command.
  
  __Tip:__ To exit the man pages press 'q' for quit.
  
### Searching

- It is possible to do a keyword search on the Manual pages. This can be helpful if you're not quite sure of what command you may want to use but you know what you want to achieve. To be effective with this approach, you may need a few goes. It is not uncommon to find that a particular word exists in many manual pages.
  ```
  $ man -k <search term>
  ```

### More on the Running Commands

- A lot of being proficient at Linux is knowing which command line options we should use to modify the behaviour of our commands to suit our needs. A lot of these have both a long hand and short hand version. eg. Above you will notice that to list all directory entries (including hidden files) we can use the option -a or --all (remember from last section what files and directories beginning with a . are?). The long hand is really just a more human readable form. You may use either, they both do the same thing. One advantage of using long hand is that it can be easier for you to remember what your commands are doing.
  ```
  $ ls -a
  $ ls --all
  ```
  As you can see, long hand command line options begin with two dashes ( -- ) and short hand options begin with a single dash ( - ). Remember that if you want to use the full command names
  
<br>
<br>

---

<br>
<br>

# File Manipulation

-  To begin with we'll learn to make some files and directories and move them around. Future sections will deal with putting content in them and more interesting manipulation.

### Making a Directory

- Creating a directory is pretty easy. The command we are after is mkdir which is short for Make Directory.
  ```
  mkdir [options] <Directory>
  ```
  Lets see a real world example:
  ```
  $ mkdir newFolder
  ```
  
- Remember that when we supply a directory in the above command we are actually supplying a path. Is the path we specified relative or absolute? Here are a few more examples of how we can supply a directory to be created
  - mkdir /home/ryan/foo
  - mkdir ./blah
  - mkdir ../dir1
  - mkdir ~/linuxtutorialwork/dir2

### Removing a Directory

- Creating a directory is pretty easy. Removing or deleting a directory is easy too. One thing to note, however, is that there is no undo when it comes to the command line on Linux (Linux GUI desktop environments typically do provide an undo feature but the command line does not). Just be careful with what you do. The command to remove a directory is rmdir, short for remove directory.
  ```
  rmdir [options] <Directory>
  ```
  Real world example
  ```
  $ rmdir fooDirName
  ```
  if youw wanna remove a dir you need to have it empty otherwise you will need to use the `-r` options on `rmdir` command.

### Creating a Blank File 

- A lot of commands that involve manipulating data within a file have the nice feature that they will create a file automatically if we refer to it and it does not exist. In fact we can make use of this very characteristic to create blank files using the command `touch`.
  ```
  $ touch filename.foo
  ```

### Copying a File or Directory

- There are many reasons why we may want to make a duplicate of a file or directory. Often before changing something, we may wish to create a duplicate so that if something goes wrong we can easily revert back to the original. The command we use for this is `cp` which stands for copy.
  ```
  cp [options] <source> <destination>
  ```
  Real world example:
  ```
  $ cp filename copyfilename
  ```
  You can copy directories ... etc. everything remember because in the end they are all the same, they are just files. But creating a directory copy requires options which is `-r`

### Moving / Re-naming a File or Directory 

- To move a file we use the command `mv` which is short for move. It operates in a similar way to cp. One slight advantage is that we can move directories without having to provide the -r option.
  ```
  mv [options] <source> <destination>
  ```
  Real World exmaple:
  ```
  $ mkdir foo
  $ touch file
  $ mv file foo/
  ```

- Now just as above with the command touch, we can use the basic behaviour of the command `mv` in a creative way to achieve a slighly different outcome. Normally `mv` will be used to move a file or directory into a new directory.  Now if we specify the destination to be the same directory as the source, but with a different name, then we have effectively used mv to rename a file or directory.
  ```
  $ ls
  foo 
  $ mv foo bar
  $ls
  bar
  ```
  
### Removing File/Directory

- As with rmdir, removing a file is an action that may not be undone so be careful. The command to remove or delete a file is `rm` which stands for remove.
  ```
  rm [options] <file>
  ```
  Real world exmaple:
  ```
  $ ls
  foo bar
  $ rm foo
  $ ls
  bar
  ```

- When rm is run with the `-r` option it allows us to remove directories and all files and directories contained within. The r option of rm is kinda like an OP move so use it very carefully
  ```
  $ rm -r dirName
  ```
  A good option to use in combination with `r` is `i` which stands for interactive. This option will prompt you before removing each file and directory and give you the option to cancel the command.


<br>
<br>


---

<br>
<br>

[Part 2](./part-2.md)
