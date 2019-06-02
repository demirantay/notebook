### [Part 1](./README.md)

---

## Structures

- Arrays allow to define type of variables that can hold several data items of the same kind. Similarly structure is another user defined data type available in C that allows to combine data items of different kinds. (like `dict` in python)

- Lets see how you can define a structure :
  ```c
  struct Books {
    char title[50];
    char author[50];
    char subject[100];
    int book_id;
  };
  ```
  To access any member of a structure, we use the member access operator (.). The member access operator is coded as a period between the structure variable name and the structure member that we wish to access. Lets try to acsess the structure we defined above:
  ```c
  #include <stdio.h>
  #include <string.h>
  
  struct Books {
    ...
  };
  
  int main() {
    
    struct Book foo;  // <-- book struct decleration
  
    /* Struct 1 specification */
    strcpy(foo.title, "Macbeth");
    strcpy(foo.author, "Shakespeare");
    strcpy(foo.subject, "Novel");
    foo.book_id = 123;
    
    /* Acsessing values */
    printf("%s", foo.title);
  
    return 0;
  }
  ```

- You can pass any structure to any function the same way you pass other variable types:
  ```c
  void function_name (struct Books book) {...}
  ```
  
- You can define pointers to structures in the same way as you define pointer to any other variable −
  ```c
  struct Books *pointer;
  
  pointer = &struct_instance;
  ```
  To access the members of a structure using a pointer to that structure, you must use the `→` operator as follows −
  ```c
  pointer->title;
  ```
  
<br>
<br>
<br>

## Unions

- A union is a special data type available in C that allows to store different data types in the same memory location. You can define a union with many members, but only one member can contain a value at any given time. 

- To define a union, you must use the union statement in the same way as you did while defining a structure. The denifition of unions are very similar to structures:
  ```c
    union Data {
     int i;
     float f;
     char str[20];
  };
  ```
  Now, a variable of `Data` type can store an integer, a floating-point number, or a string of characters. It means a single variable, i.e., same memory location, can be used to store multiple types of data. You can use any built-in or user defined data types inside a union based on your requirement.
  
- To access any member of a union, we use the `member access operator (.)` Lets try to acsess the union defined above:
  ```c
  #include <stdio.h>
  #include <string.h>
  
  union Data { ... }
  
  int main() {
    
    union Data foo;
    
    foo.i = 10;
    data.f = 220.5;
    strcpy( data.str, "C Programming");

    printf( "data.i : %d\n", data.i);
    printf( "data.f : %f\n", data.f);
    printf( "data.str : %s\n", data.str);
    
    return 0;
  }
  ```
  When the above code is compiled and executed, it produces the following result −
  ```
  data.i : 1917853763
  data.f : 4122360580327794860452759994368.000000
  data.str : C Programming
  ```
  Here, we can see that the values of `i` and `f` members of union got corrupted because the final value assigned to the variable has occupied the memory location and this is the reason that the value of `str` member is getting printed very well.
  
<br>
<br>
<br>

## Bit Fields

- I am not going to note too much about bit fields at the moment. IF you want to you can revisit: https://www.tutorialspoint.com/cprogramming/c_bit_fields.htm this link for more information.

- Basically bit fields are used to declare how much bytes are given to a particular variable in order to save some space in the memory. Lets see an example stucture:
  ```c
  struct Foo {
   unsigned int age : 3;  /* the last 3 is the allowed byte size */
  }
  ```
  
<br>
<br>
<br>

## Typedef

- The C programming language provides a keyword called typedef, which you can use to give a type a new name. And after giving it a new name we can declare variabes with its new name. Lets see an exmaple:
  ```c
  typedef int Bool;
  
  Bool true = 1;
  Bool false = 0;
  ```
  its case sensetive so `Bool` and `bool` is not same.
  
### Typedef VS #define

- `#define` is a C-directive which is also used to define the aliases for various data types similar to `typedef` but with the following differences −
  - `typedef` is limited to giving symbolic names to types only where as `#define` can be used to define alias for values as well, q., you can define 1 as ONE etc.
   ```c
   typedef int bool;
   bool true = 1;
   
   // is equal to
   
   #define TRUE 1
   ```

<br>
<br>
<br>

## Input and Output

- There are maany ways to get an input and give an output in C programming language. Lets see each one and their usage.

### fgets() and outs()

- In the standart library you can use `gets()` and `puts()` function to get an input and output one. Note: `gets` function is now deprecated in the standart library, the functions name is `fgets` now:
  ```c
  #include <stdio.h>
  int main() {
    
    char foo[100];
    
    printf("Your input: ");
    fgets( foo );
    
    printf("Your output: ");
    outs( foo );
    
    return 0;
  }
  ```
  
### printf() and scanf()

- These functions are the most used built in input and output functions because there are lots of options for formatiing. The format can be a simple  string, but you can specify %s, %d, %c, %f, etc., to print or read strings, integer, character or float respectively. There are many other formatting options available which can be used based on requirements.

- Scanf uses memory adresess to `&` to assign values its gets from the keyboard to the targeted variables. Lets see an example:
  ```c
  int main() {
    
    int foo, baz;
    
    printf("Enter your values: ");
    scanf("%d %d", &foo, &baz);
    
    pritnf("Your values are %d and %d", foo, baz);
    
    return 0;
  }
  ```
  
<br>
<br>
<br>

## File I/O

- The last chapter explained the standard input and output devices handled by C programming language. This chapter cover how C programmers can create, open, close text or binary files for their data storage. A file represents a sequence of bytes, regardless of it being a text file or a binary file. C programming language provides access on high level functions as well as low level (OS level) calls to handle file on your storage devices. 

### Opening a file

- You can use the `fopen( )` function to create a new file or to open an existing file. This call will initialize an object of the type `FILE`, which contains all the information necessary to control the stream. The prototype of this function call is as follows −
  ```
  FILE *fopen( const char * filename, const char * mode );
  ```
  Here, `filename` is a string literal, which you will use to name your file, and access `mode` can have one of the following values −
  - `r`  : Opens an existing text file for reading purpose.
  - `w`  : Opens a text file for writing. If it does not exist, then a new file is created.
  - `a`  : Opens a text file for writing in appending mode. If it does not exist, then a new file is created. 
  - `r+` : Opens a text file for both reading and writing.
  - `w+` : Opens a text file for both reading and writing. It first truncates the file to zero length if it exists, otherwise creates a file if it does not exist.
  - `a+` : Opens a text file for both reading and writing. It creates the file if it does not exist. The reading will start from the beginning but writing can only be appended.
  
### Closing a file

- To close a file, use the fclose( ) function. The prototype of this function is −
  ```
  int fclose( FILE *fp );
  ```
  The `fclose()` function returns zero on success, or EOF if there is an error in closing the file.

### Writing a file

- Following is the simplest function to write individual characters to a stream −
  ```
  int fputc( int c, FILE *fp );
  ```
  You can use the following functions to write a null-terminated string to a stream −
  ```
  int fputs( const char *s, FILE *fp );
  ```

- Lets see an real example with the code above: (Make sure you have /tmp directory available. If it is not, then before proceeding, you must create this directory on your machine.)
  ```c
  #include <stdio.h>
  
  main() {
     FILE *fp;

     fp = fopen("/tmp/test.txt", "w+");
     fputs("This is testing for fputs...\n", fp);
     fclose(fp);
  }
  ```
  When the above code is compiled and executed, it creates a new file test.txt in /tmp directory and writes two lines using two different functions. Let us read this file in the next section.
  
### Reading a file

- Given below is the simplest function to read a single character from a file −
  ```
  int fgetc( FILE * fp );
  ```
  The following function allows to read a string from a stream −
  ```
  char *fgets( char *buf, int n, FILE *fp );
  ```
  
<br>
<br>
<br>

## Preprocessors

- All preprocessor commands begin with a hash symbol (#). It must be the first nonblank character, and for readability. The following section lists down all the important preprocessor directives −
  - `#define` - 
