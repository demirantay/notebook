# Javascript

- JavaScript is a dynamic computer programming language. It is lightweight and most commonly used as a part of web pages, whose implementations allow client-side script to interact with the user and make dynamic pages. It is an interpreted programming language with object-oriented capabilities.

- Advantages of JavaScript:
  - `Less server interaction` -  You can validate user input before sending the page off to the server. This saves server traffic, which means less load on your server.
  - `Immediate feedback to the visitors` - They don't have to wait for a page reload to see if they have forgotten to enter something.
  - `Increased interactivity` - You can create interfaces that react when the user hovers over them with a mouse or activates them via the keyboard.
  - `Richer interfaces` - You can use JavaScript to include such items as drag-and-drop components and sliders to give a Rich Interface to your site visitors.
  
- Limitations of JavaScript:
  - Client-side JavaScript does not allow the reading or writing of files. This has been kept for security reason.
  - JavaScript cannot be used for networking applications because there is no such support available.
  - JavaScript doesn't have any multi-threading or multiprocessor capabilities.

<br>
<br>
<br>

# Language Overview

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

 - Most of the loops are written same in javascript:	
  ```js	
  for (var i = 0; i < 10; i++) {	
    // ...	
  }	
  	
  var i = 0;	
  while (i < 10) {	
    // ...	
    i++;	
  }	
  ```	

 ### Arrays	

 - You can define arrays very easily, there are many built in functions for arrays and strings like sort, substr and etc. you can read them from reference:	
  ```js	
  var array = ["hey", "aa", "basd"];	
  	
  array[0] // "hey"	
  ```	

 ### Methods	

 - You can define functions very easily or you can define anonomys functions and assing them to a variable which is also easy:	
  ```js	
  function normal_func (param1, param2) {	
    return param1 + param2;	
  }	
  normal_func(1,2);	
  	
  	
  var anon_func = function (x, y) {	
    return x - y;	
  }	
  anon_func(1,2);	
  ```	

 ### Scopes	

 - In javascript there are two types of scopes 1:local scope, 2:global scope and javascript creates scopes within blocks of code and most of the time the blocks come with functions or loops. The main idea is that the variable defined inside a block is not accsessible from the outside of the block but the variable defined outside of the block is accessible from the inside of the block. Confusing ? Lets see the code snippet:	
  ```js	
  var foo = 3;	
  	
  function baz() {	
    var hop = 123.123123;	
    console.log(foo);  // this is correct you can assess foo	
  }	
  	
  console.log(hop)  // you cannot do this since `hop` is defined in baz() function	
  	
  ```	

 ### Hoisting	

 - Hoisting is the default behaviour of javascript that moves declerations to the top of the file. To see what we are trying to understand first lets see these two code snippets:	
  ```js	
  x = 5;  // no `var` decleration	
  	
  consoloe.log(x) // 5	
  	
  var x;  // declares x	
  ```	
  And the code above actually is code below:	
  ```js	
  var x;	
  x = 5;	
  	
  console.log(x); //5	
  ```	
  So to understand why this is happening first we have to understand what hoisting is. You should understand that assignin a value to a variable is not same as declaring a variable. For example lets view this code `var x = 5;` the only declaration in this code is `var x` so only a undefined value of `x` will be hoisted at the top of the page and the value 5 will be assigned to it on the line the code is written in.	

 - A good number of thumb is that if you are not as comfortable with hoisting as much you should try to define your varialbes at the top of your file becuase hoisting is a overlooked feature of the language and may cause really unexpected problems.	

 ### this	

 - `this` keyword is the same in java and `self` is the same thing used in python. It simply lets you accssess the ./objects properties for example lets view the following javascript object and the use of `this` keyword:	
  ```js	
  var person = {	
    firstName: "John",	
    lastName: "Doe",	
    id:1,	
    toString: function() {	
      return this.firstName + this.lastName;	
    }	
  }	
  ```	
  It is simple and same with java.	


 ### Reference	

 - [W3Schools have exellent reference for js](https://www.w3schools.com/jS/default.asp)














