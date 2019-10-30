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



