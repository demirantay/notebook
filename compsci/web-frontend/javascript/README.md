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


  

