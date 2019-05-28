# Git 

- Before we start here is a [cheat sheet](https://github.github.com/training-kit/downloads/github-git-cheat-sheet.pdf) if you just came in for that.

- This note file is for the basics of git and to introduce the very basic and mainstream workflow for your git projects. I will note the advanced git parts in a different file.

<br>
<br>

## What is a Version Control System

- A version control system, or VCS, tracks the history of changes as people and teams collaborate on projects together. As the project evolves, teams can run tests, fix bugs, and contribute new code with the confidence that any version can be recovered at any time. Developers can review project history to find out:
  - Which changes were made?
  - Who made the changes?
  - When were the changes made?
  - Why were changes needed?
  
<br>
<br>

## What’s a distributed version control system?

- Git is an example of a distributed version control system (DVCS) commonly used for open source and commercial software development. DVCSs allow full access to every file, branch, and iteration of a project, and allows every user access to a full and self-contained history of all changes. Unlike once popular centralized version control systems, DVCSs like Git don’t need a constant connection to a central repository and avoids the single point failure possibilty where centerilzed vcs had. Developers can work anywhere and collaborate asynchronously from any time zone.

- Without version control, team members are subject to redundant tasks, slower timelines, and multiple copies of a single project. To eliminate unnecessary work, Git and other VCSs give each contributor a unified and consistent view of a project, surfacing work that’s already in progress

<br>
<br>

## Basic Commands and Terminology

- `Repository` - Basically, a folder which has git initliasied in it is a repository, or Git project. It encompasses the entire collection of files and folders associated with a project, along with each file’s revision history. The file history appears as snapshots in time called commits, and the commits exist as a linked-list relationship, and can be organized into multiple lines of development called branches.

- `git init` - initializes a brand new Git repository and begins tracking an existing directory. It adds a hidden subfolder within the existing directory that houses the internal data structure required for version control.

- `git clone` - creates a local copy of a project that already exists remotely. The clone includes all the project’s files, history, and branches.

- `git add` - stages a change. Git tracks changes to a developer’s codebase, but it’s necessary to stage and take a snapshot of the changes to include them in the project’s history. This command performs staging, the first part of that two-step process. Any changes that are staged will become a part of the next snapshot and a part of the project’s history. Staging and committing separately gives developers complete control over the history of their project 

- `git commit` - aves the snapshot to the project history and completes the change-tracking process. In short, a commit functions like taking a photo. Anything that’s been staged with `git add` will become a part of the snapshot with `git commit`.

- `git status` - git status shows the status of changes as untracked, modified, or staged.

- `git branch` - hows the branches being worked on locally

- `git branch [name]` - Creates a new branch

- `git merge` - merges lines of development together. This command is typically used to combine changes made on two distinct branches. For example, a developer would merge when they want to combine changes from a feature branch into the master branch for deployment.

- `git pull` - pdates the local line of development with updates from its remote counterpart. Developers use this command if a teammate has made commits to a branch on a remote, and they would like to reflect those changes in their local environment.

- `git push` - pdates the remote repository with any commits made locally to a branch.

There are many more commands for git however these above are roughly enough for your day to day development for more reference you:
  - [Official Docs](https://git-scm.com/docs)
  - [Cheat Sheet](https://github.github.com/training-kit/downloads/github-git-cheat-sheet.pdf)
