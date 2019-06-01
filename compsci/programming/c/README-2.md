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
  ```
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

