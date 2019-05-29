# Advanced Git

- After you complete reading the README.md file on this directory. You should read this file in order to advance your understanding of `git`

<br>

# Getting Started

- This part of the notes are going to cover :
  - Initializing a new Git repo
  - Cloning an existing Git repo
  - Committing a modified version of a file to the repo
  - Configuring a Git repo for remote collaboration
  - Common Git version control commands

### Initializing a New Git Repo

- To create a new repo, you'll use the `git init` command. `git init` is a one-time command you use during the initial setup of a new repo. Executing this command will create a new `.git` subdirectory in your current working directory. This will also create a new master branch. 

- Lets see an real worlds example:
  ```
  cd sourcecode_folder
  git init
  ```
  
- Et volia you have git now. You can [see more](https://www.atlassian.com/git/tutorials/setting-up-a-repository/git-init) from this document about `git init`

### Cloning an Existing Repository

- If a project has already been set up in a central repository, the clone command is the most common way for users to obtain a local development clone. Like `git ini`t, cloning is generally a one-time operation. Once a developer has obtained a working copy, all version control operations are managed through their local repository.
  ```
  git clone <repo url>
  ```
  
- Git uses two methods of user authentication for cloning: 1 - SSH, 2 - User login. You can easily login while cloning a project or pushing a project. However if you are suing a public internet never enter your creditentials in that wifi. NEVER!. So it is very logicical to use SSH key cryption which is a very easy way to setup while going through the user authentication.
  - SSH Setup Resource: https://help.github.com/en/articles/connecting-to-github-with-ssh

### Saving Changes to the Repository: add & commit

- Now that you have a repository cloned or initialized, you can commit file version changes to it. When you make a modification in your file you simply follow this flow:
  ```
  cd source_code
  git add <modfied file name>
  git commit -m"message for team"
  ```
  After executing this example, your repo will now have `<modified file name>` added to the history and will track future updates to the file. We have covered `add` and `commit` in the first README. if there is no explanation to the commands it is because this note file expects you to already know them.
  
### Repo to Repo Collabaration: push

- It’s important to understand that Git’s idea of a “working copy” is very different from the working copy you get by checking out source code from an SVN repository. Unlike SVN, Git makes no distinction between the working copies and the central repository—they're all full-fledged Git repositories.

- If you used `git clone` in the previous "Initializing a new Repository" section to set up your local repository, your repository is already configured for remote collaboration. `git clone` will automatically configure your repo with a remote pointed to the Git URL you cloned it from. This means that once you make changes to a file and commit them, you can `git push` those changes to the remote repository.

- If you used `git init` to make a fresh repo, you'll have no remote repo to push changes to. A common pattern when initializing a new repo is to go to a hosted Git service like github and create a repo there. The service will provide a `Git URL` that you can then add to your local Git repository and `git push` to the hosted repo.

### Configuration: git config

