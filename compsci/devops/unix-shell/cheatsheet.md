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

### File Move-Copy-Delete

### Directory Creation and Deletion

### File Compressions-Open-Archive

### File and Directory Access Permissions

### User Operations

### Processes

### Disk Operations

### Runlevels-Services

### Symbolic/Strct Links

### Upgrading and installing programs

### Wildcards

### Regular Expressions

### Sed and Awk

### Vim 

### Network Commands

### SSH Services

### WGET and File Downloading

### Scheduled Tasks

### LOG Files
