# n (Node Package Manager)

- npm is the world’s largest software registry. Open source developers from every continent use npm to share and borrow packages, and many organizations use npm to manage private development as well.

  npm consists of three distinct components:
    - the website
    - the Command Line Interface(CLI)
    - the registry
    
  Use the website to discover packages, set up profiles, and manage other aspects of your npm experience. For example, you can set up Orgs (organizations) to manage access to public or private packages.
  
  The CLI runs from a terminal, and is how most developers interact with npm.
  
  npm registry is a large database consisting of more than half a million packages. Developers download packages from the npm registry and publish their packages to the registry.
  
- Use `npm` to:
  - Adapt packages of code for your apps, or incorporate packages as they are.
  - Download standalone tools you can use right away.
  - Run packages without downloading using npx.
  - Share code with any npm user, anywhere.
  - Restrict code to specific developers.
  - Create Orgs (organizations) to coordinate package maintenance, coding, and developers.
  - Form virtual teams by using Orgs.
  - Manage multiple versions of code and code dependencies.
  - Update applications easily when underlying code is updated.
  - Discover multiple ways to solve the same puzzle.
  - Find other developers who are working on similar problems and projects.
  
<br>
<br>
<br>

# package.json

- This file can contain a lot of meta-data about your project. But mostly it will be used for two things:
  - Managing dependencies of your project
  - Scripts, that helps in generating builds, running tests and other stuff in regards to your project

- In order to create a `pckg.json` file firstly head over to your project folder. You can create package.json from the command:
  ```
  $ npm init 
  ```
  It asks you for some data like author name, description etc. You can just press enter for defaults. To quickly create a package.json file without typing the cli prompts. You can use command:
  ```
  $ npm init -y 
  ```
  The initial content of that file would look something like this:
  ```json
  {
    "name": "npm-example",
    "version": "1.0.0",
    "description": "",
    "main": "index.js",
    "scripts": {
      "test": "echo \"Error: no test specified\" && exit 1"
    },
    "author": "",
    "license": "ISC"
  }
  ```
  
- What is inside a pkg.json:
  - `name` - The name of the project/module that this package.json file is describing
  - `version` - Denotes the current version of your module.
  - `license` - Describes the license of your project.
  - `description` - Contains a human readable description about the project.
  - `keywords` - A collection of keywords that helps identifying the project. These are similar to tags.
  - `main` - It describes the entry point to the application.
  - `repository` - It defines where the source for this application/module is located. Mostly it will be github in case of open source projects. 
  - `scripts` - The scripts properties takes a list of key-value pairs. Each `key` specifies the name of the tasks the script will perform and the `value` will contain the command to invoke the task. The scripts can be invoked by `npm run <task-name>`. Scripts are mostly used for testing, building and defining some of the commands to work with your module/application
  - `dependencies` - A list of modules that this project depends upon are defined here.
  - `devDependencies` - The modules that assist you in creating a build, testing your code, deploying your code and other development level modules.
  - ... etc.
  
  The final version of our package.json file will look like this:
  ```json
  {
    "name": "npm-example",
    "version": "1.0.0",
    "license": "MIT",
    "description": "This project describes the package.json file in detail and explains what goes inside it.",
    "keywords": ["npm", "package.json", "node.js"],
    "main": "index.js",
    "repository": {
      "type": "git",
      "url": "https://github.com/skyshader/example.git"
    },
    "scripts": {
      "build": "node index.js",
      "test": "node index.test.js"
    },
    "dependencies": {
      "react": "16.2.0",
      "react-dom": "16.2.0",
      "react-redux": "5.0.7",
      "axios": "0.17.1"
    },
    "devDependencies": {
      "webpack": "4.1.1",
      "babel": "v7.0.0-beta.40",
      "jest": "22.4.2"
    }
  }
  ```
  There are much more you can learn about package.json file. Go the official documentation for more info.
  
  
<br>
<br>
<br>

# Basic npm Commands

### Installing Packages

- `Locally` : A locally installed package can be accessed only on the folder you’ve downloaded it.
  ```
  $ npm install <package name>
  ```
  After installing local package, your project folder will have node_modules inside it.
  
  You can also install packages as a developer dependency i.e., these packages are only needed for development. For example, they can be any package for testing the project. To install packages as a developer dependency use the command:
  ```
  npm install <package_name> --save-dev
  ```
  
- `Globally` : A globally installed packages works anywhere on the machine. To install global packages you’ve to use -g flag.
  ```
  $ npm install -g <package_name>
  ```
  Generally, any packages you use in your project have to be installed locally. And packages you use in the command line are to be installed globally.
  
- To install either major, minor, patch (or) exact version, you can use the command
  ```
  $ npm install <package_name>@x.y.z
  ```
  
### Updating Packages

- Since we have installed packages sometimes we need to update our packages to get new features. To do that, you’ve to use
  ```
  $ npm update <package_name>
  ```
  The above is for a specific package (or) just do this for updating all:
  ```
  npm update
  ```
  
- For global packages, you’ve to use -g.
  ```
  $ npm update <package_name> -g
  ```

### Uninstalling Packages

- Sometimes you don’t need a particular package and you want to remove it. It’s not a good idea to manually remove the package from the node_modules folder as it can be a dependency for the other packages. So, to safely remove a package you’ve to use the command:
  ```
  $ npm uninstall <package_name>
  ```
  For global packages,
  ```
  $ npm uninstall <package_name> -g
  ```
  
--- 

- Once you download a package use this command to install all of the dependincies of the project:
  ```
  $ npm install
  ```

- To get the list of installed packages, use the command:
  ```
  $ npm list
  ```
  This will list all the packages including its dependencies of all packages. The packages installed by you will be in the depth 0. Its dependencies will be in the depth 1 and further dependencies will be in the depth 2 and so on. To get packages of a certain depth, use the command
  ```
  $ npm list depth <number>
  ```
  
- This is enough for now if you want more go visit official docst at:
  - https://docs.npmjs.com/
  

  
  
  
  








