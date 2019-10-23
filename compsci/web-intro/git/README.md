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

- `git push --tags` - Updates the tags on commits of the repositroy

There are many more commands for git however these above are roughly enough for your day to day development for more reference you:
  - [Official Docs](https://git-scm.com/docs)
  - [Cheat Sheet](https://github.github.com/training-kit/downloads/github-git-cheat-sheet.pdf)

<br>
<br>
<br>

## Git Workflow

- So, basically every comapny, open-source ... any project that uses git follows a workflow. A workflow is bascially a set of rules for using git within the company so that every body does not use their own preference and fuck up the project. I will note a very basic standart one in this note file:

### Step 1: Create a Branch

- When you're working on a project, you're going to have a bunch of different features or ideas in progress at any given time , some of which are ready to go, and others which are not. Branching exists to help you manage this workflow.

- When you create a branch in your project, you're creating an environment where you can try out new ideas. Changes you make on a branch don't affect the master branch, so you're free to experiment and commit changes, safe in the knowledge that your branch won't be merged until it's ready to be reviewed by someone you're collaborating with.

- **Pro Tip :** Branching is a core concept in Git, and the entire GitHub flow is based upon it. There's only one rule: anything in the `master` branch is always deployable.

  Because of this, it's extremely important that your new branch is created off of master when working on a feature or a fix. Your branch name should be descriptive (e.g., `refactor-authentication`, `user-content-cache-key`, `make-retina-avatars`), so that others can see what is being worked on.

### Step 2: Add & Commits

- Once your branch has been created, it's time to start making changes. Whenever you add, edit, or delete a file, you're making a commit, and adding them to your branch. This process of adding commits keeps track of your progress as you work on a feature branch.
  
- Commits also create a transparent history of your work that others can follow to understand what you've done and why. Each commit has an associated commit message, which is a description explaining why a particular change was made. Furthermore, each commit is considered a separate unit of change. This lets you roll back changes if a bug is found, or if you decide to head in a different direction.

- **Pro Tip :** Commit messages are important, especially since Git tracks your changes and then displays them as commits once they're pushed to the server. By writing clear commit messages, you can make it easier for other people to follow along and provide feedback.

### Open a Pull Request

- Pull Requests initiate discussion about your commits. Because they're tightly integrated with the underlying Git repository, anyone can see exactly what changes would be merged if they accept your request

- You can open a Pull Request at any point during the development process: when you have little or no code but want to share some screenshots or general ideas, when you're stuck and need help or advice, or when you're ready for someone to review your work. By using GitHub's @mention system in your Pull Request message, you can ask for feedback from specific people or teams, whether they're down the hall or ten time zones away.

- **Pro Tip :** Pull Requests are useful for contributing to open source projects and for managing changes to shared repositories. If you're using a Fork & Pull Model, Pull Requests provide a way to notify project maintainers about the changes you'd like them to consider. If you're using a Shared Repository Model, Pull Requests help start code review and conversation about proposed changes before they're merged into the master branch.

### Discuss and Review Your Code

- Once a Pull Request has been opened, the person or team reviewing your changes may have questions or comments. Perhaps the coding style doesn't match project guidelines, the change is missing unit tests, or maybe everything looks great and props are in order. Pull Requests are designed to encourage and capture this type of conversation.

- You can also continue to push to your branch in light of discussion and feedback about your commits. If someone comments that you forgot to do something or if there is a bug in the code, you can fix it in your branch and push up the change. GitHub will show your new commits and any additional feedback you may receive in the unified Pull Request view.

- **Pro Tip :** Pull Request comments are written in Markdown, so you can embed images and emoji, use pre-formatted text blocks, and other lightweight formatting.

### Deploy

- With GitHub, you can deploy from a branch for final testing in production before merging to master.

- Once your pull request has been reviewed and the branch passes your tests, you can deploy your changes to verify them in production. If your branch causes issues, you can roll it back by deploying the existing master into production.

### Merge

- Now that your changes have been verified in production, it is time to merge your code into the master branch.

- Once merged, Pull Requests preserve a record of the historical changes to your code. Because they're searchable, they let anyone go back in time to understand why and how a decision was made.

- **Pro Tip :** By incorporating certain keywords into the text of your Pull Request, you can associate issues with code. When your Pull Request is merged, the related issues are also closed. For example, entering the phrase Closes #32 would close issue number 32 in the repository. For more information, check out githubs help [article](https://help.github.com/en/articles/closing-issues-using-keywords)


