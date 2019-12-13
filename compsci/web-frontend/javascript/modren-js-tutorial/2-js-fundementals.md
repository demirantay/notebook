# Hello World!

- This part of the tutorial is about core JavaScript, the language itself.

### "script" tag

- JavaScript programs can be inserted into any part of an HTML document with the help of the <script> tag. For instance:
  ```html
  <body>
    <p>Before the script...</p>

    <script>
      alert( 'Hello, world!' );
    </script>

    <p>...After the script.</p>
  </body>
  ```

### Moren markup

- The <script> tag has a few attributes that are rarely used nowadays but can still be found in old code: `The type attribute: <script type=…>` The old HTML standard, HTML4, required a script to have a type. Usually it was type="text/javascript". It’s not required anymore

### External scripts

- If we have a lot of JavaScript code, we can put it into a separate file. Script files are attached to HTML with the src attribute:
  ```html
  <script src="/path/to/script.js"></script>
  ```
  
  > As a rule, only the simplest scripts are put into HTML. More complex ones reside in separate files.
    The benefit of a separate file is that the browser will download it and store it in its cache.
    Other pages that reference the same script will take it from the cache instead of downloading it, so the file is actually downloaded only once.
    That reduces traffic and makes pages faster.

<br>
<br>

# Code Structure

- We recommend putting semicolons between statements even if they are separated by newlines. This rule is widely adopted by the community. Let’s note once again – it is possible to leave out semicolons most of the time. But it’s safer to use them. 

<br>
<br>


# The modern mode, "use strict"

- For a long time, JavaScript evolved without compatibility issues. New features were added to the language while old functionality didn’t change.

  This was the case until 2009 when ECMAScript 5 (ES5) appeared. It added new features to the language and modified some of the existing ones. To keep the old code working, most such modifications are off by default. You need to explicitly enable them with a special directive: `"use strict"`.
  
### "use strict"

- The directive looks like a string: "use strict" or 'use strict'. When it is located at the top of a script, the whole script works the “modern” way. For example:
  ```js
  "use strict";

  // this code works the modern way
  ...
  ```
  We will learn functions (a way to group commands) soon. Looking ahead, let’s note that "use strict" can be put at the beginning of the function body instead of the whole script. Doing that enables strict mode in that function only. But usually, people use it for the whole script.
  
`! CAUTION !` -- There is no directive like "no use strict" that reverts the engine to old behavior. Once we enter strict mode, there’s no going back.

> Always "use strict" it is the modern way of doing things, it is usually a very specific tasks that require default js.

<br>
<Br>

# Variables 

### Variables

- To create a variable in JavaScript, use the `let` keyword.
  ```js
  let foo = 15;
  ```
  
  > In older scripts, you may also find another keyword: var instead of let: The var keyword is almost the same as let. It also declares a variable, but in a slightly different, “old-school” way.
  
### Constants

- To declare a constant (unchanging) variable, use `const` instead of `let`:
  ```js
  const myBirthday = '18.04.1982';
  ```
  There is a widespread practice to use constants as aliases for difficult-to-remember values that are known prior to execution and write them with UPPERCASE.
  ```js
  const COLOR_RED = "#F00";
  const COLOR_GREEN = "#0F0";
  const COLOR_BLUE = "#00F";
  const COLOR_ORANGE = "#FF7F00";
  ```

<br>
<br>

# Type Conversions

- In javascript Most of the time, operators and functions automatically convert the values given to them to the right type. For example, alert automatically converts any value to a string to show it. Mathematical operations convert values to numbers. There are also cases when we need to explicitly convert a value to the expected type. 
  ```js
  console.log("12" + "15")  // strigns are converted to int
  
  let a = 15;
  
  String(a)  // converts it into a string
  Boolean(a) // converts it into a boolean 
  Number(a)  // converts it into a integer
  ```
  
  Also if you see the first line above wehen strings are converted to int its not always the case. if there is one string and one integer they are converted to strings and it may cause you some un expected errors. That is why it is important to explicit your types in javascript if you are just starting out with the language.
  ```js
  console.log("12" + "15")  // prints 27
  console.log("1" + 2)      // prints 12
  console.log(1 + 4 + "2")  // prints 52 not 142
  ```
  And also note that these string concatenetion on type conversions coded above are specific for `+` operator. It does not work on other ones, such as:
  ```js
  console.log("2" - 1)  // prints 1
  ```

<br>
<br>

# Comparisons 

- While comparing things with operators such as `==` , `>=` ... etc. Remember type conversions can be powerful tool and also it can shoot you in the leg. If you use the normal comparison operators, by default the langauge uses type conversions but if you want to strictly check if you are comparing two same types you can use these:
  ```
  ===
  <==
  >==
  ```
  Always use strict type comparisons if you are not using the specific type conversions

<br>
<br>

# Interaction: alert, prompt, confirm

- In this part of the tutorial we cover JavaScript language “as is”, without environment-specific tweaks.

  But we’ll still be using the browser as our demo environment, so we should know at least a few of its user-interface functions. In this chapter, we’ll get familiar with the browser functions alert, prompt and confirm.
  
### alert

- The syntax:
  ```
  alert(message);
  ```
  This shows a message and pauses script execution until the user presses “OK”.
  
  For example:
  ```js
  alert("Hello");
  ```

### prompt

- The syntax:
  ```
  prompt(title, [default]);
  ```
  It shows a modal window with a text message, an input field for the visitor, and the buttons OK/Cancel.
  ```js
  let age = prompt('How old are you?', 100);
  ```
  Default value is optional but it is good practice to have it, even if it is an empty string '', for older browsers.

### confirm 

- The syntax:
  ```
  confirm(question);
  ```
  The function confirm shows a modal window with a question and two buttons: OK and Cancel. The result is true if OK is pressed and false otherwise.
  ```js
  let isBoss = confirm("Are you the boss?");
  ```

<br>
<br>

# Conditional Operators

- You can write conditional statements in javascript like this:
  ```js
  if (year < 2015) {
    alert( 'Too early...' );
  } else if (year > 2015) {
    alert( 'Too late' );
  } else {
    alert( 'Exactly!' );
  }
  ```
  
- And also we can compress these conditionals into a single statement with `?` operators such as this. The syntax is:
  ```
  let result = condition ? value1 : value2;
  ```
  The condition is evaluated: if it’s truthy then value1 is returned, otherwise – value2.
  ```js
  let accessAllowed = (age > 18) ? alert("right") : alret("wrong");
  ```

<br>
<br>

# Loops

- You can write loops in javascript with the following syntax:

  `while loops` --
  ```js
  let i = 0;
  while (i < 3) { // shows 0, then 1, then 2
    alert( i );
    i++;
  }
  ```
  
  `do...while` -- 
  ```js
  let i = 0;
  do {
    alert( i );
    i++;
  } while (i < 3);
  ```
  
  `for loops` --
  ```js
  for (let i = 0; i < 3; i++) { 
    alert(i);
  }
  ```
  
- Javascript uses tha common `break`, `continue` loop control directives.

<br>
<br>

# Switch statement

- I am not going to note down siwtch because I do not use it that much but the javascript syntax is this:
  ```js
  let a = 2 + 2;

  switch (a) {
    case 3:
      alert( 'Too small' );
      break;
    case 4:
      alert( 'Exactly!' );
      break;
    case 5:
      alert( 'Too large' );
      break;
    default:
      alert( "I don't know such values" );
  }
  ```

<br>
<br>

# Functions

- The syntax of writing functions in javascript is:
  ```js
  function name(parameters) {
    return ...
  }
  ```

- Remember in javascript if an parameter is defined in the functions declaration and it is not provided during it's execution, javascript passes a `undefined` value to that parameter. It wont throw you an compile error. So it is good practice to set default values to your paramters to avoid them being undefined:
  ```js
  function name(pram="default_value) {...}
  ```
  
  > Old editions of JavaScript did not support default parameters. So there are alternative ways to support them, that you can find mostly in the old scripts. For instance, an explicit check for being undefined:
    ```js
    function showMessage(text) {
      if (text === undefined) {
        text = 'no text given';
      }

      alert(text );
    }
    ```

### Function Expressions 

- There is another syntax for creating a function that is called a Function Expression. It passes anonymous functions to variables

  It looks like this:
  ```js
  let sayHi = function() {
    alert( "Hello" );
  };
  
  sayHi()
  ```

- As a rule of thumb, when we need to declare a function, the first to consider is Function Declaration syntax. It gives more freedom in how to organize our code, because we can call such functions before they are declared.

  But if a Function Declaration does not suit us for some reason, or we need a conditional declaration (we’ve just seen an example), then Function Expression should be used.

### Arrow Functions

- There’s another very simple and concise syntax for creating functions, that’s often better than Function Expressions. It’s called “arrow functions”, because it looks like this:
  ```js
  let func = (arg1, arg2, ...argN) => expression
  ```
  In other words, it’s the shorter version of:
  ```js
  let func = function(arg1, arg2, ...argN) {
    return expression;
  };
  ```
  Let’s see a concrete example:
  ```js
  let sum = (a, b) => a + b;
  ```
  
- You can use arrow functions for more than one liners and use them as normal function declarations with this:
  ```js
  let sum = (a, b) => {  // the curly brace opens a multiline function
    let result = a + b;
    return result; // if we use curly braces, then we need an explicit "return"
  };
  ```
  But why would you want to use this when you can use thetraditional one, right?

