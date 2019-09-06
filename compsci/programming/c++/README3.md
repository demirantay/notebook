[Part 2](./README2.md)

---

<br>

# Files and Streams

- So far, we have been using the `iostream` standard library, which provides `cin` and `cout` methods for reading from standard input and writing to standard output respectively.

- This tutorial will teach you how to read and write from a file. This requires another standard C++ library called `fstream`, which defines three new data types −
  - `ofstream` - This data type represents the output file stream and is used to create files and to write information to files.
  - `ifstream` - This data type represents the input file stream and is used to read information from files.
  - `fstream` - This data type represents the file stream generally, and has the capabilities of both ofstream and ifstream which means it can create files, write information to files, and read information from files
  
### Opening a File

- A file must be opened before you can read from it or write to it. Either `ofstream` or `fstream` object may be used to open a file for writing. And ifstream object is used to open a file for reading purpose only.

  Following is the standard syntax for open() function, which is a member of fstream, ifstream, and ofstream objects.
  ```
  void open(const char *filename, ios::openmode mode);
  ```
  Here, the first argument specifies the name and location of the file to be opened and the second argument of the `open()` member function defines the mode in which the file should be opened.
  
- Lets see which modes that the file can be opened in:
  - `ios::app` - Append mode. All output to that file to be appended to the end.
  - `ios::ate` - Open a file for output and move the read/write control to the end of the file.
  - `ios::in` - Open a file for reading.
  - `ios::out` - Open a file for writing.
  - `ios::trunc` - If the file already exists, its contents will be truncated before opening the file.

  You can combine two or more of these values by ORing them together. For example if you want to open a file in write mode and want to truncate it in case that already exists, following will be the syntax −
  ```cpp
  ofstream outfile;
  outfile.open("foo.txt", ios::out | ios::trunc );
  ```
  
### Closing a File

- When a C++ program terminates it automatically flushes all the streams, release all the allocated memory and close all the opened files. But it is always a good practice that a programmer should close all the opened files before program termination.

  Following is the standard syntax for close() function, which is a member of fstream, ifstream, and ofstream objects.
  ```cpp
  void close();
  ```

### Writing to a File

- While doing C++ programming, you write information to a file from your program using the stream insertion operator (<<) just as you use that operator to output information to the screen. The only difference is that you use an `ofstream` or `fstream `object instead of the `cout` object.


### Reading from a File

- You read information from a file into your program using the stream extraction operator (>>) just as you use that operator to input information from the keyboard. The only difference is that you use an `ifstream` or `fstream` object instead of the `cin` object.

### Read and Write Example

- Following is the C++ program which opens a file in reading and writing mode. After writing information entered by the user to a file named afile.dat, the program reads information from the file and outputs it onto the screen −
  ```cpp
  #include <fstream>
  #include <iostream>
  using namespace std;

  int main () {
     char data[100];

     // open a file in write mode.
     ofstream outfile;
     outfile.open("afile.dat");

     cout << "Writing to the file" << endl;
     cout << "Enter your name: "; 
     cin.getline(data, 100);

     // write inputted data into the file.
     outfile << data << endl;

     cout << "Enter your age: "; 
     cin >> data;
     cin.ignore();

     // again write inputted data into the file.
     outfile << data << endl;

     // close the opened file.
     outfile.close();

     // open a file in read mode.
     ifstream infile; 
     infile.open("afile.dat"); 

     cout << "Reading from the file" << endl; 
     infile >> data; 

     // write the data at the screen.
     cout << data << endl;

     // again read the data from the file and display it.
     infile >> data; 
     cout << data << endl; 

     // close the opened file.
     infile.close();

     return 0;
  }
  ```

<br>
<br>
<br>

# Exception Handling


<br>
<Br>
<br>

# Dynamic Memory


<br>
<br>
<br>

# Namespaces 


<br>
<bR>
<br>

# Templates
