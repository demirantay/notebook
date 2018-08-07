# JavaScript

I will not write any api related javascript like DOM , geolocation, ..etc. I will only note the vanilla js properties in this file.

### Printing

- This is how you write the famous hello world:
  ```js
  console.log("Hello, World!");
  ```
  
- You do not have to compile your code even though javascript is a compiled language the engine compiles your code on the fly and acts like a interpreted but compiled language. 

- You can define variables like this:
  ```js
  var foo = "foo";
  var bar = 3;
  var pi = 3.14159;
  ```
  If you write the following javascript will convert one type to another (it is a weird powerful and also very dangerous feature of the langauge it is called type conversion):
  ```js
  var x = 12 + "12";
  // this treats the var like this: "12" + "12" so this becomes a string concetatantion
  console.log(x);  // "1212" is the result that will be printed
  ```

### User Input

- There is no built in input prompt like other languages have such as `input(..)` for python or `scanf("..")` in C but we can use the DOM api to get information from the user for now:
  ```js
  prompt("Please enter a value: ");
  ```

### Conditional statements

- Writing conditional statements and control flow is fairly simple in javascript however the only thing you should definetly look out for is the type conversions so you would want to use `===`, `>==`, `<==`,  `!==`  instead of `==` .. etc. if you include one more `=` it makes the type comparison regulated and does not allow the javascript to convert types e.g. int to string because this can cause huge problems.
  ```js
  foo = 12;
  bar = 10;
  
  if (foo === bar ) {
    // ...
  } else if (foo > bar ) {
    // ...
  } else if (foo < bar ) {
    // ...
  } else {
    // ...
  }
  ```

### Loops

-

### Arrays

-

### Methods

- 

### Objects and Classes (OOP)

- 

### Scopes

- 

### Closures

-

### Hoisting

-

### this

-

### Prototypes

-

### Behavior Delegation

-

### Types

-

### Values

-

### Natives

-

### Coercion

-

### Grammar

-

### Asynchrony

-

### Callbacks

-

### Promises

-

### Generators

- 

### Benchmarking & Tuning

- 

### ES6

- 
