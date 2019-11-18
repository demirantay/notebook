# Linux Advanced Command Line Cheatsheet

> Keep in mind some of them are Linux based and not Unix

### Bash and Linux Command Line

- `env` -- lists all the envorionment variables
- `echo $SHELL` -- Shows you which type of shell you are running
- `echo $HOME` -- Shows you where your home dir is located at
- `echo $<env_var_name>` -- You can echo any environment variable you choose
- `export <env_var_name>=new value` -- You can change the values of env variables with __export__
  > If you want this env value change to be perminent you need to save it into the .bashrc file
- `alt+F4` --

### Help and man pages

- `help` -- 
- `man <command>` --
- `whatis` --
- `apropos` --

### Getting Information Commands

- `lsb_release` --
- `etc/issue` --
- `uname` -- 
- `cal` --
- `date` --
- `hostname` --
- `who-whoami` --
- `uptime` --
- `whereis` --
- `which` --
- `locate` --
- `dmidecode` --
- `proc` --
- `fdisk -l` --
- `df` --
- `du` --
- `free` --
- `hdparm` --
- `modinfo` --
- `stat` --
- `vmstat` --
- `history` --

### Navigating through Directories

- `pwd` --
- `cd` --
- `pushd-popd` --
- `ls` --

### File Operations

- `touch` --
- `cat` --
- `echo` --
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
