# UNIX / LINUX Tutorial

- Unix is a computer Operating System which is capable of handling activities from multiple users at the same time. The development of Unix started around 1969 at AT&T Bell Labs by Ken Thompson and Dennis Ritchie. 

<br>
<br>

# Getting Started 

- The Unix operating system is a set of programs that act as a link between the computer and the user. The computer programs that allocate the system resources and coordinate all the details of the computer's internals is called the `operating system` or the `kernel`.
  
- Users communicate with the kernel through a program known as the `shell`. The shell is a command line interpreter; it translates commands entered by the user and converts them into a language that is understood by the kernel.
  - There are various Unix variants available in the market. Solaris Unix, AIX, HP Unix and BSD are a few examples. Linux is also a flavor of Unix which is freely available.
  - Several people can use a Unix computer at the same time; hence Unix is called a multiuser system.
  - A user can also run multiple programs at the same time; hence Unix is a multitasking environment.
  
- The main concept that unites all the versions of Unix is the following four basics −
  - `Kernel` - The kernel is the heart of the operating system. It interacts with the hardware and most of the tasks like memory management, task scheduling and file management.
  - `Shell` - The shell is the utility that processes your requests. When you type in a command at your terminal, the shell interprets the command and calls the program that you want. The shell uses standard syntax for all commands. C Shell, Bourne Shell and Korn Shell are the most famous shells which are available with most of the Unix variants.
  - `Commands and Utilities` - There are various commands and utilities which you can make use of in your day to day activities. __cp__, __mv__, __cat__ and __grep__, etc. are few examples of commands and utilities. There are over 250 standard commands plus numerous others provided through 3rd party software. All the commands come along with various options.
  - `Files and Directories` - All the data of Unix is organized into files. All files are then organized into directories. These directories are further organized into a tree-like structure called the __filesystem__.
  
<br>
<br>

---

<br>
<br>

# File Management

- All data in Unix is organized into files. All files are organized into directories. These directories are organized into a tree-like structure called the filesystem.

  When you work with Unix, one way or another, you spend most of your time working with files. In Unix, there are three basic types of files −
  - `Ordinary Files` - An ordinary file is a file on the system that contains data, text, or program instructions.
  - `Directories` - Directories store both special and ordinary files. For users familiar with Windows or Mac OS, Unix directories are equivalent to folders.
  - `Special Files` - Some special files provide access to hardware such as hard drives, CD-ROM drives, modems, and Ethernet adapters. Other special files are similar to aliases or shortcuts and enable you to access a single file using different names.

- __`Listing Files`__ - To list the files and directories stored in the current directory, use the following command −
  ```
  $ls
  ```


### Meta-characters

- Metacharacters have a special meaning in Unix. For example, `*` and `?` are metacharacters. We use * to match 0 or more characters, a question mark (?) matches with a single character. For exmaple - 
  ```
  $ls ch*.doc
  ```
  Displays all the files, the names of which start with __ch__ and end with __.doc__ 
  ```
  ch01-1.doc   ch010.doc  ch02.doc    ch03-2.doc 
  ch04-1.doc   ch040.doc  ch05.doc    ch06-2.doc
  ch01-2.doc ch02-1.doc c
  ```
  Here, * works as meta character which matches with any character. If you want to display all the files ending with just .doc, then you can use the following command −
  ```
  $ls *.doc
  ```
  
### Hidden Files 

- An invisible file is one, the first character of which is the dot or the period character (.). Unix programs (including the shell) use most of these files to store configuration information. Some common examples of the hidden files include the files -
  - `.profile` − The Bourne shell ( sh) initialization script 
  - `.git` - stores git data of a repo
  
  To list the invisible files, specify the -a option to ls −
  ```
  $ls -a
  ```

### Creating and Opening Files

- You can basically create a file with `touch` command such as this:
  ```
  $ touch filename
  ```
  and you can open the file with the `open` command:
  ```
  $ open filename
  ```
  
- But editing , updating, deleting ... etc. stuff from the command line without a shell editor is cumbersome and to be honest a pain in the ass that is why we have vi, (vim if you want the fancy coloring etc.)/nano/emacs ...etc. We will learn how to use them in the later on chapters.

### File Commands

- You can use the `cat` command to see the content of a file:
  ```
  $ cat filename
  ```
  You can display the line numbers by using the `-b` option along with the cat command as follows −
  ```
  $ cat -b filename
  ```
 
- You can use the `wc` command to get a count of the total number of __lines__, __words__, and __characters__ contained in a file.
  ```
  $ wc filename
  2  19 103 filename
  ```
  - First Column − Represents the total number of lines in the file.
  - Second Column − Represents the total number of words in the file.
  - Third Column − Represents the total number of bytes in the file. This is the actual size of the file.
  - Fourth Column − Represents the file name.


- To make a copy of a file use the `cp` command. The basic syntax of the command is −
  ```
  cp filename copyname
  ```
  To change the name of a file, use the mv command. Following is the basic syntax −
  ```
  $ mv filename newname
  ```
  To delete an existing file, use the rm command.
  ```
  $ rm filename
  ```
  
<br>
<br>

---

<br>
<br>

# Directory Management 

- A directory is a file the solo job of which is to store the file names and the related information. All the files, whether ordinary, special, or directory, are contained in directories.

  Unix uses a hierarchical structure for organizing files and directories. This structure is often referred to as a directory tree. The tree has a single root node, the slash character (/), and all other directories are contained below it.
  
- `Home Directory` - The directory in which you find yourself when you first login is called your home directory. You will be doing much of your work in your home directory and subdirectories that you'll be creating to organize your files. You can go in your home directory anytime using the following command −
  ```
  $ cd
  
  or
  
  $ cd ~
  ```
  Here ~ indicates the home directory. Suppose you have to go in any other user's home directory, use the following command −
  ```
  $ cd ~username
  ```
  
- To go in your last directory, you can use the following command − or ..
  ```
  $ cd ..
  ```
  or 
  ```
  $ cd -
  ```
  
- To determine where you are within the filesystem hierarchy at any time, enter the command `pwd` to print the current working directory −
  ```
  $ pwd
  
  /user0/home/amrood
  ```
  
### Directory Commands

- We will now understand how to create directories. Directories are created by the following command −
  ```
  $mkdir dirname
  ```
  If you give more than one directory on the command line, mkdir creates each of the directories. For example, −
  `
  $mkdir dirname dirname2 dirname3
  ```
  
- You can remove directories with this:
  ```
  $ rmdir dirname
  ```
  Note − To remove a directory, make sure it is empty which means there should not be any file or sub-directory inside this directory. If it is empty you can add -R
  ```
  $ rm -R diranme
  ```
  
- You can use the `mv` command to rename the direcotries
  ```
  $ mv dirname newname
  ```
  
<bR>
<br>
  
---

<br>
<br>

# File Permissions

- In this chapter, we will discuss in detail about file permission and access modes in Unix. File ownership is an important component of Unix that provides a secure method for storing files. Every file in Unix has the following attributes −
  - `Owner permissions` − The owner's permissions determine what actions the owner of the file can perform on the file.
  - `Group permissions` − The group's permissions determine what actions a user, who is a member of the group that a file belongs to, can perform on the file.
  - `Other (world) permissions` − The permissions for others indicate what action all other users can perform on the file.
  
### Permission Indicators

### File Access Modes

- The permissions of a file are the first line of defense in the security of a Unix system. The basic building blocks of Unix permissions are the read, write, and execute permissions, which have been described below −
  - `read` - Grants the capability to read, i.e., view the contents of the file. 
  - `write` - Grants the capability to modify, or remove the content of the file.
  - `execute` - User with execute permissions can run a file as a program.
  
### Directory Access Modes

- Directory access modes are listed and organized in the same manner as any other file. There are a few differences that need to be mentioned −
  - `read` - Access to a directory means that the user can read the contents. The user can look at the filenames inside the directory.
  - `write` - Access means that the user can add or delete files from the directory.
  - `execute` -  Executing a directory doesn't really make sense, so think of this as a traverse permission. A user must have __execute access__ to the bin directory in order to execute the ls or the cd command.
  
  
### Changing Permissions

- To change the file or the directory permissions, you use the `chmod` (change mode) command. There are two ways to use chmod   the symbolic mode and the absolute mode.

- `Using chmod in Symbolic Mode`: The easiest way for a beginner to modify file or directory permissions is to use the symbolic mode. With symbolic permissions you can add, delete, or specify the permission set you want by using the operators in the following table.
  - `+` : Adds the designated permission(s) to a file or directory.
  - `-` : Removes the designated permission(s) from a file or directory
  - `=` : Sets the designated permission(s).
  
  Here's an example using testfile. Running ls -l on the testfile shows that the file's permissions are as follows −
  ```
  $ls -l testfile
  -rwxrwxr--  1 amrood   users 1024  Nov 2 00:10  testfile
  ```
  Then each example `chmod` command from the preceding table is run on the testfile, followed by `ls –l`, so you can see the permission changes −

__`... I stopped writing this tutorial for now`__

<br>

This is where I left of:
  - https://www.tutorialspoint.com/unix/unix-file-permission.htm
  - https://ryanstutorials.net/bash-scripting-tutorial/
  - http://www.tldp.org/LDP/Bash-Beginners-Guide/html/Bash-Beginners-Guide.html
  - http://www.tldp.org/LDP/abs/html/index.html
  - https://github.com/jlevy/the-art-of-command-line#meta

