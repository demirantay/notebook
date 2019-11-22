# Linux Advanced Command Line Cheatsheet

> Keep in mind some of them are Linux based and not Unix

### Linux Command Line Intro

- `env` -- lists all the envorionment variables
- `echo $SHELL` -- Shows you which type of shell you are running
- `echo $HOME` -- Shows you where your home dir is located at
- `echo $<env_var_name>` -- You can echo any environment variable you choose
- `export <env_var_name>=new value` -- You can change the values of env variables with __export__
  > If you want this env value change to be perminent you need to save it into the .bashrc file

### Bash Shell Shortcuts

- `ctrl+A` -- Moves the cursor to the start of the line
- `ctrl+E` -- Moves the cursor to the end of the line
- `ctrl+L` -- clears the terminal
- `ctrl+C` -- kills the process
- `ctrl+Z` -- Moves the current running process to the background
- `ctrl+D` -- same as exit. terminates the terminal
  > /bin/bash  |  /etc/profile  |  /.bashrc   -> These three files are bash shell config files

### Help and man pages

- `<command> --help` -- Prints the help page for that specific command , usage, exmaples ... etc. 
- `man <command>` -- Prints manual page for a command, usage, options, description ... etc.
- `whatis <command>` -- Prints a summirised versions of manual (help) pages. usually single line.
- `apropos` -- Lets you search the manual page names and descriptions

### Getting Information Commands

- `lsb_release -a` -- Get the information about the linux distro you are using
- `uname -a` -- Prints the version of Kernel that is being used 
- `cal [options]` -- Prints you out a calender 
- `date` -- Prints out you the date
- `hostname` -- Prints out you the host name
- `w-who-whoami` -- Prints out the users currently logged in, last login dates ... etc.
- `uptime` -- Prints out how long the system have been open
- `whereis` -- locate the binary, source, and manual page files for a command
- `which` -- locate a command
- `locate` -- list files in databases that match a pattern
- `dmidecode -t <hardware>` --  Shows you the information about the hardware. 
- `fdisk -l` -- Shows you the disk information of your system
- `df -h` -- Shows you a detailed information of disk space usage. Without the -h option it looks really bad
- `du` -- shows you the disk usage of the subdirectories of the dir where this command is ran
- `free` -- Display amount of free and used memory in the system
- `hdparm <disk>` -- Shows you information about the targeted disk e.g. `sda` ... etc.
- `modinfo lsmod` -- Lists you the kernel modules
- `modinfo <module>` -- Shows you information about a single module of the kernel
- `stat <dirname>` -- Shows you information about the targeted directory 
- `vmstat [-options]` -- Shows the general information about the system 
- `history` -- Shows you the history of commands ran in that terminal process

### Navigating through Directories

- `pwd` -- Shows you where you currently are in the path 
- `cd` -- Changes directories
- `ls` -- List files and directories

### File Operations

- `touch <filename>` -- creates an empty file 
- `cat <file>` -- lets you viewvthe content of a file 
- `echo` -- There are much more things to do with echo than just printing out stuff but I mostly use it for printing.
- `more <filename>` -- This lets you view the file inside the terminal just like cat. Uses space for scrolling down and end for escaping
- `less <filename>` -- This lets you view the file in a more structured way for long files. This is like "cat"
- `head <filename>` -- lets you view the first 10 lines of a file. You can give options to specifiy more than 10 lines
- `tail <filename>` -- lets you view the last 10 lines of a file. You can give options to specify more than 10 lines.
- `tee` -- read from standard input and write to standard output and files
- `tac <file>` -- reverse of cat. lets you view a file from bottom to top. 
- `rev` -- reverse lines of a file or files
- `sort <file>` -- Alphabetically sorts the content of a file
- `wc <file>` -- Shows you the character and line count
- `nl <file>` -- Same as "cat" with -n operator. Shows the lines of and lets you view the file
- `pr` -- lets you view the file again but makes it more readable and sperates the different files. Very useful if you want to get something printed out.
- `grep` -- print lines matching a pattern
- `cut` -- remove sections from each line of files
- `cmp <file> <file2>` -- Compares two files and prints out their differences.
- `diff <file> <file2>` -- Just like cmp it compares two files and prints out their differences
- `find` -- lets you find files or directories. It is too big to note in a single sentence. 
- `exec` -- execute commands and open, close, or copy file descriptors
- `xargs` -- build and execute command lines from standard input

### File Move-Copy-Delete

- `cp <file> <copyfile>` -- Copies an file to another newly created file. 
- `mv <file> <dirname>` -- Moves a file to a new path, if the path does not exists instead of moving the dirname becomes the new nameof the file.
- `rm <file>` -- Used for deleting a file. IF it is stubborn use `-r` option

### Directory Creation and Deletion

- `mkdir <dirname>` -- Creates a directory
- `rmdir <dirname>` -- Removes a directory, only works if the directory is empty
- `rm -r <dirname>` -- Removes a directory even if it is not empty.

### File Compressions-Open-Archive

- `tar` -- The GNU version of the tar archiving utility
- `gzip-bzip2-gunzip-bunzip2` -- compress or expand files
- `zcat-zgrep-bzcat-bzgrep` -- compress or expand files
- `unrar-unzip` -- extract files from rar archives

### Process Management

- `ps` -- report a snapshot of the current processes. `aux` option is very useful for readability
- `pstree` -- Lets you see the processes in a hierarchical way. 
- `top` -- Lets you see all of the proecss in a monitor way. Just like the actviity monitor app in the GUI
- `pgrep` --
- `kill` --
- `kilall` --
- `xkill` --
- `fg-bg` --

### Disk Operations

- `fdisk` --
- `cfdisk` --
- `badblocks` --
- `fsck` --
- `parted` --
- `mkfs` --
- `mount` --
- `unmount` --
- `dd`
- `cpio` --

### Runlevels-Services

- ...
- `service` --
- `reboot` --
- `halt` --

### Symbolic/Strict Links

- `inode` --
- ...

### Upgrading and installing programs

- `dpkg` --
- `apt-get` --
- ...
- `aptitude` --
- `tasksel` --

### Wildcards

- ...

### Regex

- ...

### Vim 

- ...

### Sed and Awk

- `sed` --
- `awk` --

### Network Commands

- `ifconfig` --
- `ip` --
- `route` --
- `ping` --
- `traceroute` --
- `netstat` --
- `nslookup` --
- `whois` --
- `host` --
- `dig` --
- `arp` --
- `tcpdump` --
- `dns` --
- `hosts/` --

### SSH Services

- ...
- `scp` --
- `authorized_keys` --
- `putty` --
- `sftp` --
- `filezilla` --

### WGET and File Downloading

- `wetget` --

### Scheduled Tasks

- `cron` --
- `crontab` --

### LOG Files

- ...
- `tail` --
- `dmesg` --
- `last` --
- `btmp` --
- `lastlog` --
- `utmp-wtmp` --
- `lsof` --
