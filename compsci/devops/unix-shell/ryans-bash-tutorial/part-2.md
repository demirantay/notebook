[Part 1](./part-1.md)

---

<br>

# Loops & Arrays

- I am not going to note down the logic behind loops and arrays since I already know it. This is just noting the key poitns:

### Arrays

- You can create Arrays with square brackets but it is also possible to add a list of data in a single variable like we will use in the most example down below. But this section shows the square bracket syntax:
  ```sh
  arr[0]='Debian'
  arr[1]='Red hat'
  arr[2]='Ubuntu'
  arr[3]='Suse'

  echo ${arr[1]}
  ```

### While Loops

- You can write while loops in bash scripting such as this:
  ```sh
  counter=1
  while [ $counter -le 10 ]
  do
    echo $counter
    ((counter++))
  done
  ```

### Until Loops

- The until loop is fairly similar to the while loop. The difference is that it will execute the commands within it until the test becomes true. Where in loop we test until it becomes false:
  ```sh
  counter=1
  until [ $counter -gt 10 ]
  do
    echo $counter
    ((counter++))
  done
  ```

### For Loops

- You can write for loops in bash scripting such as this:
  ```sh
  names='Stan Kyle Cartman'
  for name in $names
  do
    echo $name
  done
  ```
  
- We can also process a series of numbers:
  ```sh
  for value in {1..5}
  do
    echo $value
  done
  ```

### Break and Continue

- `break` and `continue` commands are the same as any other languaege:
  ```sh
  if [ ... ]
  then
    continue
  else
    break
  fi
  ```

### Select

- The select mechanism allows you to create a simple menu system. It has the following format:
  ```sh
  names='Kyle Cartman Stan Quit'
  
  select name in $names
  do
    if [ $name == 'Quit' ]
    then
      break
    elif [$name == 'Kyle' ]
      ...
    fi
  done
  ```

<Br>
<Br>

---

<br>
<br>

# Functions

- Creating a function is fairly easy. They may be written in two different formats:
  ```
  function_name () {
  <commands>
  }
  ```
  or
  ```
  function function_name {
  <commands>
  }
  ```
  
- Lets see real world example:
  ```sh
  print_something () {
    echo Hello I am a function
  }
  
  print_something  #executes
  ```
  Lets see how to write with arguments too:
  ```sh
  print_something () {
    echo Hello $1
    return 6
  }

  print_something Mars
  ```

### Overriding Commands

- It is possible to name a function as the same name as a command you would normally use on the command line. This allows us to create a wrapper. eg. Maybe every time we call the command ls in our script, what we actually want is ls -lh. We could do the following:
  ```sh
  ls () {
  command ls -lh
  }
  
  ls
  ```
  and from now on within this file whenever we use `ls` the usage of it is changed

<br>
<br>

---

<br>
<br>

# User Interface

### TPut

### Supplying Data

### Presenting Data 

### Organising Your Code 
