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



