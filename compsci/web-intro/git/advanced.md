# Advanced Git

- After you complete reading the README.md file on this directory. You should read this file in order to advance your understanding of `git`

- ***There are many more things to read about Git see this very well covered tutorial for more https://www.atlassian.com/git/tutorials/what-is-version-control***

<br>
<br>
<br>

# Configuration: git config

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
  
- You can give alises for your git commands and you can configure your alises in git config. For exmaple you can change the `git status` --> `git st` ... etc. I am not really going to go into detail however there is a good post about this: https://www.atlassian.com/git/tutorials/git-alias
  
- Typically, you’ll only need to configure a Git installation the first time you start working on a new development machine, and for virtually all cases, you'll want to use the --global flag. One important exception is to override the author email address. You may wish to set your personal email address for personal and open source repositories, and your professional email address for work-related repositories.


  There are many things to do with git configuration like edit ui-colors, set-editor ... etc. you can view most of them in this nice resouce (or go to the official docs) : https://www.atlassian.com/git/tutorials/setting-up-a-repository/git-config

<br>
<br>
<br>

# Git stash

- git stash temporarily shelves (or stashes) changes you've made to your working copy so you can work on something else, and then come back and re-apply them later on. Stashing is handy if you need to quickly switch context and work on something else, but you're mid-way through a code change and aren't quite ready to commit. 

- I am going to note about the common stash commands here but there are many things to learn about git stashes this document covers nearly all of it: https://www.atlassian.com/git/tutorials/saving-changes/git-stash 

- The `git stash` command takes your uncommitted changes (both staged and unstaged), saves them away for later use, and then reverts them from your working copy. For example:
  ```
  $ git status
  On branch master
  Changes to be committed:
  new file: style.css
  Changes not staged for commit:
  modified: index.html
  
  $ git stash
  Saved working directory and index state WIP on master: 5002d47 our new homepage
  HEAD is now at 5002d47 our new homepage
  
  $ git status
  On branch master
  nothing to commit, working tree clean
  ```
  At this point you're free to make changes, create new commits, switch branches, and perform any other Git operations; then come back and re-apply your stash when you're ready. Note that the stash is local to your Git repository; stashes are not transferred to the server when you push.
  
- You can reapply previously stashed changes with `git stash pop`:
  ```
  $ git status
  On branch master
  nothing to commit, working tree clean
  
  $ git stash pop
  On branch master
  Changes to be committed:
  new file: style.css
  Changes not staged for commit:
  ```
  Popping your stash removes the changes from your stash and reapplies them to your working copy.
  
- If you decide you no longer need your stashes, you can delete it with git stash drop:
  ```
   git stash clear
  ```
  Or you can delete a particular one of your stashes with:
  ```
  $ git stash drop stash@{1}
  Dropped stash@{1} (17e2697fd8251 ...
  ```

<br>
<br>
<br>

# Git log

- The `git log `command displays committed snapshots. It lets you list the project history, filter it, and search for specific changes. While `git status` lets you inspect the working directory and the staging area, `git log` only operates on the committed history.

- Log output can be customized in several ways, from simply filtering commits to displaying them in a completely user-defined format. Some of the most common configurations of `git log` are presented below.

- Lets look at the common commands
  ```
  git log
  ```
  Display the entire commit history using the default formatting. If the output takes up more than one screen, you can use `Space` to scroll and `q` to exit.
  ```
  git log -n <limit>
  ```
  Limit the number of commits by `<limit>` For example, git log -n 3 will display only 3 commits.
  ```
  git log --oneline
  ```
  Condense each commit to a single line. This is useful for getting a high-level overview of the project history.
  ```
  git log --stat
  ```
  Along with the ordinary git log information, include which files were altered and the relative number of lines that were added or deleted from each of them.
  ```
  git log --author="<name>"
  ```
  Search for commits with a commit message that matches "name", which can be a plain string or a regular expression.
  ```
  git log <file>
  ```
  Only display commits that include the specified file. This is an easy way to see the history of a particular file.

- There are more to learn for `git log`s however you can check the rest from different resources or official documentation.

<br>
<br>
<br>

# Git tag

- This document will discuss the Git concept of tagging and the git tag command. Tags are ref's that point to specific points in Git history. Tagging is generally used to capture a point in history that is used for a marked version release (i.e. v1.0.1). A tag is like a branch that doesn’t change. Unlike branches, tags, after being created, have no further history of commits.

- So basically tags are the backup and snapshots of each version so if something fucks up on the next version it is very easty roll back and fix the project.


