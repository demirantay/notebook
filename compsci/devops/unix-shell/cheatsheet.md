# My Linux/Unix Command Line Cheatsheet

### Bash and Linux Command Line

- `Path` -- A description of where a file or directory is on the filesystem.
- `Absolute Path` -- One beginning from the root of the file system (eg. /etc/sysconfig )
- `Relative Path` -- One relative to where you currently are in the system (eg. Documents/music ).
- `~ (tilde)` -- Used in paths as a reference to your home directory (eg. ~/Documents ).
- `. (dot)` -- Used in paths as a reference to your current directory (eg. ./bin ).
- `.. (dot dot)` -- Used in paths as a reference to your current directories parent directory (eg. ../bin ).
- `file [path]` -- Find out what type of item a file or directory is.
- `Hidden files and directories` -- A name beginning with a . (dot) is considered hidden.

### Help and man pages

- `man <command>` -- View the man page for a command.
- `man -k <search term>` -- Search for man pages containing the search term.
- Press q to exit man pages

### Getting Information Commands

### Navigating through Directories

- `pwd` -- Where I am in the system
- `ls [path]` -- Perform a listing of the given path or your current directory.
  _Common options: -l, -h, -a_
- `cd [path]` -- Change into the given path or into your home directory.

### Piping and Redirection

- `>` -- Redirect STDOUT to a file.
- `>>` -- Append STDOUT to the end of a file.
- `2>` -- Redirect the STDERR to a file.
- `<` -- Pass the contents of a file to a program as STDIN.
- `|` -- Feed the STDOUT of the program on the left as STDIN to the program on the right.

### File Operations

- `mkdir <directory name>` -- Create a directory
- `rmdir <directory name>` -- Remove a directory (only if empty).
- `touch <file name>` -- Create a blank file.
- `cp <source> <destination>` -- Copy the source file to the destination.
- `mv <source> <destination>` -- Move the source file to the destination. May also be used to rename files or directories.
- `rm <path>` -- Remove a file or directory. _Common options: -r -f_

### Filters 

- `head` -- Show the first n lines.
- `tail` -- Show the last n lines.
- `sort` -- Sort lines in a given way.
- `wc` -- How many words, characters and lines.

### Grep

- `egrep or grep -E` -- Run grep with extended regular expressions.
- `-i` -- Ignore case (ie uppercase, lowercase letters).
- `-v` -- Return all lines which don't match the pattern.
- `-w` -- Select only matches that form whole words.
- `-c` -- Print a count of matching lines. Can be combined with the -v option to print a count of non matchine lines.
- `-l` -- Print the name of each file which contains a match. Normally used when grep is invoked with wildcards for the file argument.
- `-n` -- Print the line number before each line that matches.
- `-r` -- Recursive, read all files in given directory and subdirectories.
- grep can as easy as __egrep 'mellon' myfile.txt__ or as complex as __egrep '\b[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}\b' myfile.txt__

### File Move-Copy-Delete

### Directory Creation and Deletion

### File Compressions-Open-Archive

### Permissions

- _r (read) w (write) x (execute)_
- _Owner or User, Group and Others_
- `ls -l [path]` - View the permissions of a file or all items in a directory.
- `chmod <permissions> <path>` - Change permissions. Permissions can be either shorthand (eg. 754) or longhand (eg. g+x).

### User Operations

### Process Management

- `CTRL + C` -- Cancel the currently running process.
- `kill <process id>` -- Cancel the given process. Include the option -9 to kill a stubborn process.
- `top` -- Monitors all of the running processes in a nice, structured way.
- `ps` -- Obtain a listing of processes and their id's. Including the option aux will show all processes.
- `CTRL + Z` -- Pause the currently running process and put it in the background.
- `jobs` -- See a list of current processes in the background. 
- `fg <job number>` -- Move the given process from the background to the foreground.

### Disk Operations

### Runlevels-Services

### Symbolic/Strct Links

### Upgrading and installing programs

### Wildcards

- _May be used anywhere in any path._
- `*` -- Zero or more characters (eg. b*).
- `?` -- Single character (eg. file.???).
- `[]` -- Range (eg. b[aio]t).


### Sed and Awk

### Network Commands

### SSH Services

### WGET and File Downloading

### Scheduled Tasks

### LOG Files
