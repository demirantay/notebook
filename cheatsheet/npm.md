# NPM cheatsheet

### Setup

`npm init` -- initiliases the npm pacakge.json

### Package Management

- `npm install` -- Install everything in package.json
- `npm i` -- Alias for npm install
- `npm install --production` -- Install everything in package.json, except devDependecies
- `npm install <pckg_name>` -- Install a package
- `npm install -g <pckg_name>` -- Install a package globally (not just in a local folder)
- `npm install --save-dev <pck_name>` -- Install as devDependency
- `npm install --save-exact <pckg_name>` -- Install with exact

### Listing

- `npm list` -- sts the installed versions of all dependencies in this software
- `npm list -g --depth 0` -- lists the installed versions of all globally installed packages
- `npm view` -- Lists the latest versions of all dependencies in this software
- `npm outdated` -- Lists only the dependencies in this software which are outdated

### Updating

- `npm update` -- Update production packages
- `npm update --dev` -- Update dev packages
- `npm update -g` -- Update global packages
- `npm update <pckg_name>` -- Update a package

### Misc Features

- `npm owner add USERNAME PACKAGENAME` -- Add someone as an owner
- `npm ls` -- list packages
- `npm deprecate PACKAGE@"< 0.2.0" "critical bug fixed in v0.2.0"` -- Adds warning to those that install a package of old versions
- `npm update [-g] PACKAGE` -- update all packages, or selected packages
- `npm outdated [PACKAGE]` -- Check for outdated packages

### Install Names

- `npm i PACKAGE` -- installing NPM package with its normal name and laterst verison
- `npm i PACKAGE@latest` -- Specify tag latest
- `npm i PACKAGE@3.0.0` -- Specify version 3.0.0
- `npm i PACKAGE@">=1 <2.0"` -- Specify version range
- `npm i @org/PACKAGE` -- Scoped NPM package
- `npm i user/repo` -- GitHub ?
- `npm i user/repo#master` -- GitHub ?
- `npm i github:user/repo` -- Github ?
- `npm i gitlab:user/repo` -- Gitlab ? 
- `npm i /path/to/repo` -- Absolute path
- `npm i ./archive.tgz` -- Tarball
- `npm i https://site.com/archive.tgz` -- Tarball via HTTP




