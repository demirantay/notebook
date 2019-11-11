- [Part 1](./README.md)

<br>

---

<br>

# Vi Text Editor

- Vi is a text editor that is most likely very different to any editor you have used before. Vi/m is its successor with better more readable and fancy colors for modern use. Vi is a very powerful tool. In this section my aim is not to cover everything that Vi can do but to get you up and running with the basics.

### A Command Line Editor

- Vi is a command line text editor. As you would be quite aware now, the command line is quite a different environment to your GUI. It's a single window with text input and output only. Vi has been designed to work within these limitations and many would argue, is actually quite powerful as a result

  As a result you have to ditch the mouse. Everything in Vi is done via the keyboard.
  
- There are two modes in Vi. `Insert` (or Input) mode and `Edit` mode. In input mode you may input or enter content into the file. In edit mode you can move around the file, perform actions such as deleting, copying, search and replace, saving etc. A common mistake is to start entering commands without first going back into edit mode or to start typing input without first going into insert mode. If you do either of these it is generally easy to recover so don't worry too much.

- When we run vi we normally issue it with a single command line argument which is the file you would like to edit.
  ```
  $ vi filename.txt
  ```
  If you forget to specify a file then there is a way to open a file within vi but it is easiest to just quit vi and have another go
  
- When you first open the Vi editor You always start off in `edit` mode so the first thing we are going to do is switch to insert mode by pressing `i`. You can tell when you are in insert mode as the bottom left corner will tell you. and if you want to switch back to edit mode you simply press `Esc` key.
  
### Saving and Exiting

- There are a few ways to go about doing this. They all do essentially the same thing so pick whichever way you prefer. For all of these, make sure you are in `edit` mode first.

  > Tip: If you are unsure if you are in edit mode or not you can look at the bottom left corner. As long as it doesn't say       INSERT you are fine. Alternatively you can just press Esc to be sure. If you are already in edit mode, pressing Esc does       nothing so you won't do any harm.
  
  - `ZZ` (Note: capitals) - Save and exit
  - `:q!` - discard all changes, since the last save, and exit
  - `:w` - save file but don't exit
  - `:wq` - again, save and exit

### Ways to View Content

- vi allows us to edit files. If we wanted, we could use it to view files as well, but there are two other commands which are a bit more convenient for that purpose. The first one is `cat` which actually stands for concatenate. It's main purpose is to join files together but in it's most basic form it is useful for just viewing files.
  ```
  cat filename
  ```
  
- This command is nice when we have a small file to view but if the file is large then most of the content will fly across the screen and we'll only see the last page of content. For larger files there is a better suited command which is `less`
  ```
  less filename
  ```

### Navigating a File

- In insert mode you may use the arrow keys to move the cursor around. Below are some of the many commands you may enter to move around the file:
  - `Arrow keys` - move the cursor around
  - `j, k, h, l` - move the cursor down, up, left and right (similar to the arrow keys)
  - `^ (caret)` - move cursor to beginning of current line
  - `$` - move cursor to end of the current line
  - `nG` - move to the nth line (eg 5G moves to 5th line)
  - `G` - move to the last line
  - `w` - move to the beginning of the next word
  - `nw` - move forward n word (eg 2w moves two words forwards)
  - `b` - move to the beginning of the previous word
  - `nb` - move back n word
  - `{` - move backward one paragraph
  - `}` - move forward one paragraph
  
- > If you type :set nu in edit mode within vi it will enable line numbers. I find that turning line numbers on makes working   with files a lot easier.

### Deleting Content

- Below are some of the many ways in which we may delete content within vi.
  - `x` - delete a single character
  - `nx` - delete n characters (eg 5x deletes five characters)
  - `dd` - delete the current line
  - `dn` - d followed by a movement command. Delete to where the movement command would have taken you. (eg d5w means delete 5 words)

### Undoing 

- Undoing changes in vi is fairly easy. It is the character `u`.
  - `u` - Undo the last action (you may keep pressing u to keep undoing)
  - `U` (Note: capital) - Undo all changes to the current line
  
- `Note`: Vi-Vim is extremly complex to just note it in a single section. I will dedicate a note dir for just vi/vim later on.
  
<Br>
<br>

----

<br>
<br>

# Wildcards 

- In the section on File Manipulation we learnt about a few commands to do interesting things. The problem was that they all operated on a single file at a time, not very efficient. Now I'm going to introduce a means to play about with a set of files at once.

### What are they ?

- Wildcards are a set of building blocks that allow you to create a pattern defining a set of files or directories. As you would remember, whenever we refer to a file or directory on the command line we are actually referring to a path. Whenever we refer to a path we may also use wildcards in that path to turn it into a set of files or directories.

- Here is the basic set of wildcards:
  - `*` - represents zero or more characters
  - `?` - represents a single character
  - `[]` - represents a range of characters
  
  Lets see an quick example:
  ```
  $ pwd
  /home/ryan/linuxtutorialwork
  $ ls
  barry.txt blah.txt bob example.png firstfile foo1 foo2
  foo3 frog.png secondfile thirdfile video.mpeg
  $ ls b*
  barry.txt blah.txt bob
  ```
  
### Examples

- Remember the wildards use bash scripting under the hood so you can even write your own wildcards for different commands. So usage of wildcards are limitless in a terminal's scope and limiatiotons. However lets see some examples, but as I said remember there are tons of wildcards usages other than these:
  
   For all the examples below, assume we are in the directory linuxtutorialwork and that it contains the files as listed above
   
- Every file with an extension of txt at the end. In this example we have used an absolute path. Wildcards work just the same if the path is absolute or relative.
  ```
  $ ls /home/ryan/linuxtutorialwork/*.txt
  /home/ryan/linuxtutorialwork/barry.txt     /home/ryan/linuxtutorialwork/blah.txt
  ```
  
- Now let's introduce the ? operator. In this example we are looking for each file whose second letter is i. As you can see, the pattern can be built up using several wildcards.
  ```
  $ ls ?i*
  firstfile video.mpeg
  ```

- Or how about every file with a three letter extension. Note that video.mpeg is not matched as the path name must match the given pattern exactly.
  ```
  $ ls *.???
  barry.txt blah.txt example.png frog.png
  ```
  
- And finally the range operator ( [ ] ). Unlike the previous 2 wildcards which specified any character, the range operator allows you to limit to a subset of characters. In this example we are looking for every file whose name either begins with a s or v.
  ```
  $ ls [sv]*
  secondfile video.mpeg
  ```
 
- Note: the exampples above may not mean muhc because they are not real world exmaples but as I said wildcards are limitless and usually are specific to personal usage. But lets see a common method of moving files from a real world example: (Move all files of type either jpg or png (image files) into another directory.)
  ```
  $ mv public_html/*.??g public_html/images/
  ```

<br>
<br>

---

<Br>
<br>
  
# Permissions

- In this section we'll learn about how to set Linux permissions on files and directories. Permissions specify what a particular person may or may not do with respect to a file or directory. As such, permissions are important in creating a secure environment. For instance you don't want other people to be changing your files and you also want system files to be safe from damage

### What are they ?

- Linux permissions dictate 3 things you may do with a file, read, write and execute. They are referred to in Linux by a single letter each.
  - `r` read - you may view the contents of the file.
  - `w` write - you may change the contents of the file.
  - `x` execute - you may execute or run the file if it is a program or script.
  
- For every file we define 3 sets of people for whom we may specify permissions.
  - `owner` - a single person who owns the file. (typically the person who created the file but ownership may be granted to some one else by certain users)
  - `group` - every file belongs to a single group.
  - `others` - everyone else who is not in the group or the owner.
  
  Three persmissions and three groups of people. That's about all there is to permissions really. Now let's see how we can view and change them.

### View Permissions

- To view permissions for a file we use the long listing option for the command ls.
  ```
  ls -l [path]
  ```
  Lets see a real world example:
  ```
  $ ls -l /home/ryan/linuxtutorialwork/frog.png
  -rwxr----x 1 harry users 2.7K Jan 4 07:32 /home/ryan/linuxtutorialwork/frog.png
  ```
  - The first character identifies the file type. If it is a dash ( - ) then it is a normal file. If it is a d then it is a directory.
  - The following 3 characters represent the permissions for the owner. A letter represents the presence of a permission and a dash ( - ) represents the absence of a permission. In this example the owner has all permissions (read, write and execute).
  - The following 3 characters represent the permissions for the group. In this example the group has the ability to read but not write or execute. Note that the order of permissions is always read, then write then execute.
  - Finally the last 3 characters represent the permissions for others (or everyone else). In this example they have the execute permission and nothing else

### Change Permissions

- To change permissions on a file or directory we use a command called chmod It stands for change file mode bits which is a bit of a mouthfull but think of the mode bits as the permission indicators.
  ```
  chmod [permissions] [path]
  ```
  chmod has permission arguments that are made up of 3 components
    - Who are we changing the permission for? `[ugoa]` - user (or owner), group, others, all
    - Are we granting or revoking the permission - indicated with either a plus ( + ) or minus ( - )
    - Which permission are we setting? - read ( r ), write ( w ) or execute ( x )
    
- Now lets see a real world example: Grant the execute permission to the group. Then remove the write permission for the owner --
  ```
  $ ls -l frog.png
  -rwxr----x 1 harry users 2.7K Jan 4 07:32 frog.png
  $ chmod g+x frog.png
  $ ls -l frog.png
  -rwxr-x--x 1 harry users 2.7K Jan 4 07:32 frog.png
  $ chmod u-w frog.png
  $ ls -l frog.png
  -r-xr-x--x 1 harry users 2.7K Jan 4 07:32 frog.png
  ```
  Don't want to assign permissions individually? We can assign multiple permissions at once.
  ```
  $ chmod g+wx frog.png
  or
  $ chmod go-x frog.png
  ```
  It may seem odd that as the owner of a file we can remove our ability to read, write and execute that file but there are valid reasons we may wish to do this. Maybe we have a file with data in it we wish not to accidentally change for instance.

### Shorthand

- The method outlined above is not too hard for setting permissions but it can be a little tedious if we have a specific set of permissions we would like to apply regularly to certain files (scripts for instance that we'll see in section 13). Luckily, there is a shorthand way to specify permissions that makes this easy. 

  I am skipping this for now since I am not that familiar with boolean algebra and bianry. You can revisit it here:
    - https://ryanstutorials.net/linuxtutorial/permissions.php#shorthand

### Directories

- The same series of permissions may be used for directories but they have a slightly different behaviour.
  - `r` - you have the ability to read the contents of the directory (ie do an ls)
  - `w` - you have the ability to write into the directory (ie create files and directories)
  - `x` - you have the ability to enter that directory (ie cd)

### The Root User

- On a Linux system there are only 2 people usually who may change the permissions of a file or directory. The owner of the file or directory and the root user. The root user is a superuser who is allowed to do anything and everything on the system. Typically the administrators of a system would be the only ones who have access to the root account and would use it to maintain the system. Typically normal users would mostly only have access to files and directories in their home directory and maybe a few others for the purposes of sharing and collaborating on work and this helps to maintain the security and stability of the system.

### Basic Security

- Most users would give themselves full read, write and execute permissions for their home directory and no permissions for the group or others however some people for various reasons may have a slighly different set up.

  Normally, for optimal security, you should not give either the group or others write access to your home directory, but execute without read can come in handy sometimes. This allows people to get into your home directory but not allow them to see what is there. An example of when this is used is for personal web pages.

<br>
<Br>
  
---

<br>
<br>

# Filters

- One of the underlying principles of Linux is that every item should do one thing and one thing only and that we can easily join these items together. Think of it like a set of building blocks that we may put together however we like to build anything we want. In this section and the next we will learn about a few of these building blocks.

### So what are they ?

- A filter, in the context of the Linux command line, is a program that accepts textual data and then transforms it in a particular way. Filters are a way to take raw data, either produced by another program, or stored in a file, and manipulate it to be displayed in a way more suited to what we are after.

  These filters often have various command line options that will modify their behaviour so it is always good to check out the man page for a filter to see what is available.

  Let's dive in and introduce you to some of them. (remember, the examples here will only give you a taste of what is possible with these commands. Make sure you explore and use your creativity to see what else you may do with them.)
  
- For each of the demonstrations below I will be using the following file as an example. This example file contains a list of content purely to make the examples a bit easier to understand but realise that they will work the same with absolutely any other textual data. Also, remember that the file is actually specified as a path and so you may use absolute and relative paths and also wildcards.
  ```
  $ cat mysampledata.txt
  
  Fred apples 20
  Susy oranges 5
  Mark watermellons 12
  Robert pears 4
  Terry oranges 9
  Lisa peaches 7
  Susy oranges 12
  Mark grapes 39
  Anne mangoes 7
  Greg pineapples 3
  Oliver rockmellons 2
  Betty limes 14
  ```

### head

- Head is a program that prints the first so many lines of it's input. By default it will print the first 10 lines but we may modify this with a command line argument.
  ```
  head [-number of lines to print] [path]
  ```
  
  Lets see a real world example but instead of default 10 lets limit it to 4:
  ```
  $ head -4 mysampledata.txt
  
  Fred apples 20
  Susy oranges 5
  Mark watermellons 12
  Robert pears 4
  ```

### tail

- Tail is the opposite of head. Tail is a program that prints the last so many lines of it's input. By default it will print the last 10 lines but we may modify this with a command line argument.
  ```
  tail [-number of lines to print] [path]
  ```
  
  Lets see a real world example but instead of default 10 lets limit it to 3:
  ```
  $ tail -3 mysampledata.txt
  Greg pineapples 3
  Oliver rockmellons 2
  Betty limes 14
  ```

### sort

- Sort will sort it's input, nice and simple. By default it will sort alphabetically but there are many options available to modify the sorting mechanism. Be sure to check out the man page to see everything it may do.
  ```
  sort [-options] [path]
  ```
  
  Lets see a example:
  ```
  $ sort mysampledata.txt
  
  Anne mangoes 7
  Betty limes 14
  Fred apples 20
  Greg pineapples 3
  Lisa peaches 7
  Mark grapes 39
  Mark watermellons 12
  Oliver rockmellons 2
  Robert pears 4
  Susy oranges 12
  Susy oranges 5
  Terry oranges 9
  ```

### nl

- nl stands for number lines and it does just that.
  ```
  nl [-options] [path]
  ```
  
  Lets see an example:
  ```
  $ nl mysampledata.txt

  1 Fred apples 20
  2 Susy oranges 5
  3 Mark watermellons 12
  4 Robert pears 4
  5 Terry oranges 9
  6 Lisa peaches 7
  7 Susy oranges 12
  8 Mark grapes 39
  9 Anne mangoes 7
  10 Greg pineapples 3
  11 Oliver rockmellons 2
  12 Betty limes 14
  ```

### wc

- wc stands for word count and it does just that (as well as characters and lines). By default it will give a count of all 3 but using command line options we may limit it to just what we are after.
  ```
  wc [-options] [path]
  ```
  
  Real world example:
  ```
  $ wc mysampledata.txt
  12 36 195 mysampledata.txt
  ```

### cut

- I didn't fucking get how to use it from this part of the tutorial. If you want to revisit it again : https://ryanstutorials.net/linuxtutorial/filters.php#cut

### sed

- sed stands for Stream Editor and it effectively allows us to do a search and replace on our data. It is quite a powerful command but we will use it here in it's basic format.
  ```
  sed <expression> [path]
  ```
  A basic expression is of the following format: `s/search/replace/g`. Lets see a real world example, Say we ran out of oranges and wanted to instead give those people bananas.
  ```
  $ sed 's/oranges/bananas/g' mysampledata.txt
  
  Fred apples 20
  Susy bananas 5
  Mark watermellons 12
  Robert pears 4
  Terry bananas 9
  Lisa peaches 7
  Susy bananas 12
  Mark grapes 39
  Anne mangoes 7
  Greg pineapples 3
  Oliver rockmellons 2
  Betty limes 14
  ```
  It's important to note that sed does not identify words but strings of characters


### uniq

- uniq stands for unique and it's job is to remove duplicate lines from the data. One limitation however is that those lines must be adjacent (ie, one after the other). (sometimes this is not the case but we'll see one way we can fix this in Section 11 Piping and Redirection).
  ```
  uniq [options] [path]
  ```
  
  Lets say that our file above got corrupted and has duplicates of data such as this:
  ```
  $ cat mysampledata.txt
  Fred apples 20
  Susy oranges 5
  Susy oranges 5
  Susy oranges 5
  ...
  ```
  Lets fix it with uniq
  ```
  $ uniq mysampledata.txt
  Fred apples 20
  Susy oranges 5
  ...
  ```

### tac

- Linux guys are known for having a funny sense of humor. The program tac is actually cat in reverse. It was named this as it does the opposite of cat. Given data it will print the last line first, through to the first line.
  ```
  tac [path]
  ```
  
  Maybe our sample file is generated by writing each new order to the end of the file. As a result, the most recent orders are at the end of the file. We would like it the other way so that the most recent orders are always at the top.
  ```
  $ tac mysampledata.txt
  
  Betty limes 14
  Oliver rockmellons 2
  Greg pineapples 3
  Anne mangoes 7
  Mark grapes 39
  Susy oranges 12
  Lisa peaches 7
  Terry oranges 9
  Robert pears 4
  Mark watermellons 12
  Susy oranges 5
  Fred apples 20
  ```

### Others

- Here are two other programs that are worth investigating if you want to take your knowledge even further. They are a quite powerfull but also more complex than the programs listed above
  - awk 
  - diff
  


<br>
<br>

---

<br>
<br>

- [Part 3](./README3.md)
