## pip cheatsheet

- General Syntax and Usage of Pip:
  ```
  $ pip <command> [options]
  ```

### Virtual env

- `virtualenv <name>` -- creates a virtual enviroenment with <name>
- `source venv/bin/activate` - activates the virtual envioronment 
- `deactivate` - deactivates the virtual enviroenment

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

- `pip install PKG` -- Install package
- `pip install PKG==1.0` -- Install specific version
- `pip install 'PKG>=1.0'` -- At least, install version X
- `-r FILE,--requirement FILE` -- Install listed packages in the requirements file
- `-b DIR,--build DIR` -- Directory for building packages
- `-t DIR,--target DIR` -- Install in directory
- `-d DIR, --download DIR` -- Download only
- `-U,--upgrade` -- Update listed packages
- `--force-reinstall` -- Re-install packages when updating
- `-I,--ignore-installed` -- Re-install
- `--no-deps` -- Do not install dependencies
- `--egg` -- Install as an Egg
- `--compile` -- Compile *.py to *.pyc
- `--no-compile` -- Do not compile
- `--no-use-wheel` -- Do not use wheels
- `--pre` -- Include developmental versions
- `--no-clean` -- Do not clean build directories
- `-i URL,--index-url URL` -- PyPI URL
- `--extra-index-url URL` -- Additional URLs
- `--no-index` -- Only use --find-links URLs
- `-f URL,--find-links URL` -- Parse links for archives
- `--process-dependency-links` -- Process links for dependencies
- `--allow-external PKG` -- Install 3rd-party package
- `--allow-all-external` -- Install 3rd-party packages
- `--allow-unverified PKG` -- Install unverified package

### General Parameters

- `-v,--verbose` -- Verbose mode (More output)
- `-q,--quiet` -- Quiet mode (Less output)
- `-h,--help` -- Help/Options
- `-V,--version` -- Display version info
- `--isolated` -- Ignore environment variables and user configuration
- `--log PATH` -- Log file
- `--proxy PROXY` -- USER:PSWD@SERVER:PORT
- `--retries X` -- Retry connection X times
- `--timeout SECONDS` -- Try for X seconds before retry
- `--cache-dir DIR` -- Cache directory
- `--no-cache-dir` -- Disable cache
- `--disable-pip-version-check` -- Do not check Pip version
- `--cert PATH` -- Path to secondary CA bundle
- `--client-cert CERT` -- Path to SSL certificate
- `--trusted-host HOSTNAME` -- Consider the host trusted
