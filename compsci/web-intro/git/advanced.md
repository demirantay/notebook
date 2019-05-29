# Advanced Git

- After you complete reading the README.md file on this directory. You should read this file in order to advance your understanding of `git`

- You can read https://www.atlassian.com/git/tutorials/what-is-version-control this file for the full version of this note file. Be aware it is a huge read.

<br>
<br>

### Configuration: git config

- Once you have a remote repo setup, you will need to add a remote repo url to your local git config, and set an upstream branch for your local branches. The git remote command offers such utility.
  ```
  git remote add <remote_name> <remote_repo_url>
  ```
  Once you have mapped the remote repo you can push local branches to it.
  ```
  git push -u <remote_name> <local_branch_name>
  ```
  his command will push the local repo branch under <local_branc_name> to the remote repo at <remote_name>.
  
- In addition to configuring a remote repo URL, you may also need to set global Git configuration options such as username, or email. The git config command lets you configure your Git installation (or an individual repository) from the command line. This command can define everything from user info, to preferences, to the behavior of a repository
  
  Git stores configuration options in three separate files, which lets you scope options to individual repositories (local), user (Global), or the entire system (system):
  
  Define the author name to be used for all commits in the current repository. Typically, you’ll want to use the --global flag to set configuration options for the current user.
  ```
  git config --global user.name <name>
  ```
  
  Adding the --local option or not passing a config level option at all, will set the user.name for the current local repository.
  ```
  git config --local user.email <email>
  ```
  
  You can see all of your configration list with this:
  ```
  git config --list
  ```
  
- Typically, you’ll only need to configure a Git installation the first time you start working on a new development machine, and for virtually all cases, you'll want to use the --global flag. One important exception is to override the author email address. You may wish to set your personal email address for personal and open source repositories, and your professional email address for work-related repositories.


  There are many things to do with git configuration like edit ui-colors, set-editor ... etc. you can view most of them in this nice resouce (or go to the official docs) : https://www.atlassian.com/git/tutorials/setting-up-a-repository/git-config

<br>
<br>
<br>

