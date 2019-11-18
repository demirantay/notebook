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

### Getting Information Commands

- `lsb_release -a` -- Get the information about the linux distro you are using
- `uname -a` -- Prints the version of Kernel that is being used 
- `cal [options]` -- Prints you out a calender 
- `date` -- Prints out you the date
- `hostname` -- Prints out you the host name
- `w-who-whoami` -- Prints out the users currently logged in, last login dates ... etc.
- `uptime` -- Prints out how long the system have been open
- `dmidecode -t <hardware>` --  Shows you the information about the hardware. 
- `fdisk -l` -- Shows you the disk information of your system
- `df -h` -- Shows you a detailed information of disk space usage. Without the -h option it looks really bad
- `du` -- shows you the disk usage of the subdirectories of the dir where this command is ran
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
- `more` --
- `less` --
- `head` --
- `tail` --
- `tee` --
- `tac` --
- `rev` --
- `sort` --
- `wc` --
- `nl` --
- `pr` --
- `paste` --
- `grep` --
- `cut` --
- `tr` --
- `cmp` --
- `diff` --
- `find` --
- `exec` --
- `xargs` --

### File Move-Copy-Delete

- `cp` --
- `mv` --
- `rm` --
- `shred` --

### Directory Creation and Deletion

- `mkdir` --
- `rmdir` --
- `rm -r <dirname>` --

### File Compressions-Open-Archive

- `tar` --
- `gzip-bzip2-gunzip-bunzip2` --
- `zcat-zgrep-bzcat-bzgrep` --
- `unrar-unzip` --

### Permissions

- ...
- suid ?
- `unmask` --
- `chattr` --

### User Operations

- `shadow` --
- `passwd` --
- ...

### Process Management

- `process` --
- `ps` --
- `pstree` --
- `top` --
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
