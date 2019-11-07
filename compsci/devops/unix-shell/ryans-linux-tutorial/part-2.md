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

### Deleting Content

### Undoing 


<Br>
<br>

----

<br>
<br>

# Wildcards 
