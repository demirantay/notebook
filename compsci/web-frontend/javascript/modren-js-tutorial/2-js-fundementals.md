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
  
<br>
<br>

# Operators

- The basic operators are the same in javascript such as `+`, `-`, `*`, `/`, `%` however there are more operators built in to the language that needs their notes taken.

<br>
<br>

# Comparisons 

<br>
<br>


# Interaction: alert, prompt, confirm

<br>
<br>

# Conditional Operators

<br>
<br>

# Logical Operators

<br>
<br>


# Loops

<br>
<br>

# Switch statement

<br>
<br>

# Functions

<br>
<br>

# Function Expressions 

<br>
<br>

# Arrow Functions

<br>
<br>

# JavaScript Specials
