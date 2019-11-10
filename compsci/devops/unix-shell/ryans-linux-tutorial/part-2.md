- [Part 1](./part-1.md)

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

### Change Permissions

### Shorthand

### Directories

### The Root User

### Basic Security


<br>
<Br>
  
---

<br>
<br>

# Filters

