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

# Basics

- JavaScript can be implemented using JavaScript statements that are placed within the <script>... </script> HTML tags in a web page. You can place the <script> tags, containing your JavaScript, anywhere within your web page, but it is normally recommended that you should keep it within the <head> tags.
  
- The script tag takes two important attributes −
  - `Language` - This attribute specifies what scripting language you are using. Typically, its value will be javascript
  - `Type` − This attribute is what is now recommended to indicate the scripting language in use and its value should be set to "text/javascript".
    ```html
    <script language="javascript" type="text/javascript">...</script>
    ```
    But it is good practice to move your javascript to another module and link it from your html with `src` like this:
    ```html
    <script type="text/javascript" src="path/to/your/module.js"> ... </script>
    ```
  
 - You can omit the `;` semicolon if you want however it is good practice that you dont
 
<br>
<br>
<br>

# Variables

- JavaScript allows you to work with 3 primitive data types −
  - `Numbers` - eg. 123, 120.50 etc.
  - `Strings` - of text e.g. "This text string" etc.
  - `Boolean` -  e.g. true or false.
  
  *Note − JavaScript does not make a distinction between integer values and floating-point values. All numbers in JavaScript are represented as floating-point values*
  
  Javascript also includes `null`, `undefined` and `objects` however they are not primitive and I will discuss them later, on different headers.
  ```javascript
  var number = 10;
  var string = "hello";
  var boolean = true;
  ```
  Unlike many other languages, you don't have to tell JavaScript during variable declaration what type of value the variable will hold.
  
### Variable Scopes

- The scope of a variable is the region of your program in which it is defined. JavaScript variables have only two scopes:
  - `Global Variables` − A global variable has global scope which means it can be defined anywhere in your JavaScript code.
  - `Local Variables` − A local variable will be visible only within a function where it is defined. Function parameters are always local to that function.
  
  Within the body of a function, a local variable takes precedence over a global variable with the same name. If you declare a local variable or function parameter with the same name as a global variable, you effectively hide the global variable.
  
### Operators

- Nearly all of the javascript operators are the same however plase do note that insetad of using `==` comparison use `===` this since this strictly checks weeather the values are equal the `==` double equal sign doesnt strictly checks the values and may cause problematic bugs

<br>
<br>
<br>

# Control Flow

- Lets first see how to write if and else statments in javascript:
  ```javascript
  var foo = 10;
  
  if (foo === 20) {
    ...
  } 
  else if (foo === 10) {
    ...
  }
  else {
    ...
  }
  ```
  
 - You can also write switch statements for control flow, but I am not going to note it right now since I do not use it very oftern.
 
 <br>
 <br>
 <br>
 
 # Loops
 
 - I am not going to note down what the logic is behind the loops because I have done it many times in other language files.
 
 - Lets see some examples of loops:
  ```javascript
  // while loop
  var foo = 10;
  while (foo < 20) { ... }
  
  // do..while loop
  do {
    ...
  } while (foo < 20)
  
  // for loop
  for (int i = 0; i < 10; i++) { ... }
  
  // for .. in loop
  for (element in array) { ... }
  ```
  
- You can also do `loop control` with the following keywords: `break`, `continue`

<br>
<br>
<br>

# Functions

- I am not going to note the logic behind the functions, since I have defined them many times in perivous programming language files. Lets just see how to write them in javascript:
  ```javascript
  function name(parameters) {
    return foo
  }
  ```
  In order to call your function you need to use DOM API (`onclick=func()`)
  
 <br>
 <br>
 <br>
 
 # Events
 
 - JavaScript's interaction with HTML is handled through events that occur when the user or the browser manipulates a page. When the page loads, it is called an event. When the user clicks a button, that click too is an event. Other examples include events like pressing any key, closing a window, resizing a window, etc.
 
  Events are a part of the Document Object Model (DOM) Level 3 and every HTML element contains a set of events which can trigger JavaScript Code.
  
  
-We will see the DOM API more deeply on a differnet subject however lets see the most commonly used ones:
  - `onclick` - This is the most frequently used event type which occurs when a user clicks the left button of his mouse. You can put your validation, warning etc., against this event type:
  - `onsubmit` - onsubmit is an event that occurs when you try to submit a form. You can put your form validation against this event type:
  - `onmouseover`/`onmouseout` - These two event types will help you create nice effects with images or even with text as well. The onmouseover event triggers when you bring your mouse over any element and the onmouseout triggers when you move your mouse out from that element. (with css3 you can dow it with `:hover` effect
  
  There are many more evenets just visit th w3, mdn or other documentatio for viewing the full list
  
<br>
<br>
<br>

# Cookies

- Web Browsers and Servers use HTTP protocol to communicate and HTTP is a stateless protocol. But for a commercial website, it is required to maintain session information among different pages. For example, one user registration ends after completing many pages. But how to maintain users' session information across all the web pages.

  In many situations, using cookies is the most efficient method of remembering and tracking preferences, purchases, commissions, and other information required for better visitor experience or site statistics

- You can mainpulate create read write delete cookies with javascript however since it is a long note and I want to keep this intro file short i am not going to note down everything

<br>
<br>
<br>

# Page Redirection

- You can also redirect pages with javascript however, you can also redirect with a backend language and since I am more concerned with the backend I will skip noting this part

<br>
<br>
<br>

# Dialog Boxes

- JavaScript supports three important types of dialog boxes. These dialog boxes can be used to raise and alert, or to get confirmation on any input or to have a kind of input from the users. 

### Alert Box

- An alert dialog box is mostly used to give a warning message to the users. Nonetheless, an alert box can still be used for friendlier messages. Alert box gives only one button "OK":
  ```javascript
  alert("Whatch out!");
  ```
  
### Confirmation Box

- A confirmation dialog box is mostly used to take user's consent on any option. It displays a dialog box with two buttons: OK and Cancel. If the user clicks on the OK button, the window method confirm() will return true. If the user clicks on the Cancel button, then confirm() returns false. You can use a confirmation dialog box as follows.
  ```javascript
  var value = confirm("do you want to proceed?");
  
  if (value === true) { 
    ...
  }
  else {
    ...
  } 
  ```

# Prmopt Box

- The prompt dialog box is very useful when you want to pop-up a text box to get user input. Thus, it enables you to interact with the user. The user needs to fill in the field and then click OK.
  ```javascript
  var value = prompt("your name");
  
  document.write("your anme is : " + value);
  ```

<br>
<br>
<br>

# Objects Overview

- JavaScript is an Object Oriented Programming (OOP) language. Objects are composed of attributes. If an attribute contains a function, it is considered to be a method of the object, otherwise the attribute is considered a property.

### Object Properties

- Object properties are usually variables that are used internally in the object's methods, but can also be globally visible variables that are used throughout the page. Lets see an example:
  ```javascript
  var str = document.title;
  ```
  
### Object Methods

- Methods are the functions that let the object do something or let something be done to it. There is a small difference between a function and a method – at a function is a standalone unit of statements and a method is attached to an object and can be referenced by the this keyword. Lets see an example:
  ```javascript
  document.write("This is test");
  ```
  
### User Defined Objects

- All user-defined objects and built-in objects are descendants of an object called Object. The new operator is used to create an instance of an object. To create an object, the new operator is followed by the constructor method. Lets see an example:
  ```javascript
  var employee = new Object();
  var books = new Array("C++", "Perl", "Java");
  var day = new Date("August 15, 1947");
  ```
  
- I will discuss OOP in javascript in a different file so this is enough for an introduction

<br>
<br>
<br>
















