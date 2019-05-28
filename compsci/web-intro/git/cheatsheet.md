# GIT Notes For Myself

- [Official Docs Cheat Sheet](https://git-scm.com/docs)
- [Githubs Cheat Sheet](https://github.github.com/training-kit/downloads/github-git-cheat-sheet.pdf)

## Vocabulary

*Directory*: A folder used for storing multiple files.

*Repository*: A directory where Git has been initialized to start version controlling your files.

*Staging Area*: A place where we can group files together before we "commit" them to Git repository.

## Cheat-Sheet

### terminal

`ESC:wq` -> Exits any textbox shown in the terminal

`cd` -> change directory

`ls` -> list directories

### Git

`git init` -> Initializes a empty new repository to the directory.

`git status` -> shows the status of our current selected project.

`git add <filename>/ -A / .` -> either add a specific file to the tracking list of git or add all of your files in your repo                                   by using '-A' or '.'

`git reset <filename>` -> Removes the file. Exactly reverse of the 'add' func.

`git commit -m"the message"` -> Commits all of the files in the staging area to the Git repo.

`git log` -> Journal that remembers all the changes we have commited so far, in the order we commited them.
            **Advice** You can use `git log --summary` to see more information in each commit.

`git remote add origin URL` ->connects the URL of the repo in the github to our local repository. Use this in the parent directory of your project repository that you are working on. You can copy the SSH from the repo in github.com

`git clone URL` -> clones a github repo(with .git) to your local machine. You can copy the SSH from the repo in github.com

`git push -u origin master` -> pushes our local changes to our origin repo (on GitHub). You do not have to use -u origin master but it is a good use if you want to push your code in a different branch or remote.

`git pull origin master` -> pulls the latest code on the github repo. Again, you do not have to use the origin or master.

`git stash` -> Sometimes when you go to pull you may have changes you don't want to commit just yet. One option you have, other than commiting, is to stash the changes.
Use the command `git stash` to stash your changes, and `git stash apply` to re-apply your changes after your pull.

### Advanced Git

`git diff` -> If we want to see what was changed latest you can use this func.
            **git diff HEAD** to see the latest changes
            **git diff --staged** to see the latest changes you just staged (it is like a advanced git status with featuring past present and future)

`git checkout --<filename>` -->  Files can be changed back to how they were at the last commit by using the command:  git checkout -- <target>.

`git branch <branch name>` -->Creates a 'branch'. Working on a feature or bug you often create a copy (aka. branch) of their code they can make separate commits to. Then when they're done they can merge this branch back into their main  master branch.

`git branch`-> Shows the branches of your repository.

`git checkout <branch name>` -> Switch between branches.

`git rm '*.txt'/ -r <folder name/filename>` -> Terminates the given parameter, its like a garbage truck removes everything you give to the param of func. The files folders staged files even the disk it is up to you.

`git merge <branch name>` -> merges the given branch in the parameter with the branch you are inside at the moment of the function is exucuted.

`git branch -d <branch name>` -> deletes the given branch.

//will add the merge conflicts and all other advanced stuff later it is beyond my scope for now.
