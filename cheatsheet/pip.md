## pip cheatsheet

- General Syntax and Usage of Pip:
  ```
  $ pip <command> [options]
  ```

### Virtual env

- `virtualenv <name>` -- creates a virtual enviroenment with <name>
- ` ` - activates the virtual envioronment 
- ` ` - deactivates the virtual enviroenment

### Listing

- `pip list` -- List packages
- `-o,--outdated` -- List outdated packages
- `-u,--uptodate` -- List current packages
- `-e,--editable` -- List editable items
- `-l,--local` -- List local virtualenv packages
- `--user` -- List user-site packages
- `--pre` -- Include developmental packages
- `-i URL,--index-url URL ` -- PyPI URL
- `--extra-index-url URL` --  Additional package repos
- `--no-index` -- Ignore package index
- `-f URL,--find-links URL` --  Search for archives at the URL
- `--allow-external PKG` -- Allow package installation
- `--allow-all-external` -- Allow externally hosted packages to be installed
- `--allow-unverified PKG` --  Install insecure package
- `--process-dependency-links` -- Process links for dependencies

### Show

- `pip show PKG` -- Display package info
- `-f, --files` -- List package's files

### Search

- `pip search KEYWORD` -- Search PyPI for keyword
- `--index URL` -- Repo to search

### Uninstall

- `pip uninstall PKG` -- Uninstall/remove package
- `-r FILE,--requirement FILE` -- Uninstall packages listed in requirements file
- `-y,--yes` -- Assume “yes” for questions

### Freeze

- `pip freeze` -- Generate requirements file
- `-r FILE,--requirement FILE` -- Use the order given in the file
- `-f URL,--find-links URL` -- URL for finding packages
- `-l,--local` -- Only list virtualenv packages
- `--user` -- Only list user-site packages

### Install

### General Parameters

- `-v,--verbose` -- Verbose mode (More output)
- `-q,--quiet` -- Quiet mode (Less output)
- `-h,--help` -- Help/Options
