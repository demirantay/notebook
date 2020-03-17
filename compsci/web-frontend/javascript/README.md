# JavaScript

- JavaScript is a dynamic computer programming language. It is lightweight and most commonly used as a part of web pages, whose implementations allow client-side script to interact with the user and make dynamic pages. It is an interpreted programming language with object-oriented capabilities.

- `Client Side Javascript` -- Client-side JavaScript is the most common form of the language. The script should be included in or referenced by an HTML document for the code to be interpreted by the browser.

  The JavaScript client-side mechanism provides many advantages over traditional CGI server-side scripts. For example, you might use JavaScript to check if the user has entered a valid e-mail address in a form field.
  
  The JavaScript code is executed when the user submits the form, and only if all the entries are valid, they would be submitted to the Web Server.
  
- `Advantages of Javascript` -- 
  - Less server interaction
  - Immediate feedback to the visitors
  - Increased interactivity
  - Richer interfaces
  
- `Limitations of Javascript` -- 
  - Client-side JavaScript does not allow the reading or writing of files. This has been kept for security reason.
  - JavaScript doesn't have any multi-threading or multiprocessor capabilities.  
  
<br>
<br>

---

<br>
<br>

# Syntax

- JavaScript can be implemented using JavaScript statements that are placed within the `<script>... </script>` HTML tags in a web page.

- It is good practice to include your js scripts at the end of your html file because in that way the scripts will make sure that the HTML content is loaded before they get executed. 

- IF you do not want to write js on your html file you can simply include a `module.js` file in your html with adding the `src` attribute to the script element:
  ```html
  <script src="/path/to/your/file.js" type="text/javascript" language="javascript" ></script>
  ```
  
<br>
<br>

---

<br>
<bR>
  
# Variables

- JavaScript allows you to work with four primitive data types −
  - `Numbers`, eg. 123, 120.50 etc.
  - `Strings` of text e.g. "This text string" etc.
  - `Boolean` e.g. true or false.
  - `null` or `undefined`
  
  > Note − JavaScript does not make a distinction between integer values and floating-point values. All numbers in JavaScript are represented as floating-point values.
  
- Instead of the old `var` use `let`:
  ```js
  let foo = 10;
  let bar = "hello";
  let baz = true;
  ```

<br>
<br>

---

<br>
<br>

# Conditionals

- I am not noting down what conditional statements are. I will just note down the syntax:
  ```js
            let book = "maths";
            
            if( book == "history" ) {
               document.write("<b>History Book</b>");
            } else if( book == "maths" ) {
               document.write("<b>Maths Book</b>");
            } else if( book == "economics" ) {
               document.write("<b>Economics Book</b>");
            } else {
               document.write("<b>Unknown Book</b>");
            }
  ```
  
- You can also write switch case like this:
  ```js
        let grade = 'A';
  
        switch (grade) {
               case 'A': document.write("Good job<br />");
               break;
            
               case 'B': document.write("Pretty good<br />");
               break;
            
               case 'C': document.write("Passed<br />");
               break;
            
               case 'D': document.write("Not so good<br />");
               break;
            
               case 'F': document.write("Failed<br />");
               break;
            
               default:  document.write("Unknown grade<br />")
            }
  ```
  
<br>
<br>

---

<br>
<br>

# Loops

- I am not going to note down the logic of the loops, just their javascript syntax:

- while loops -- 
  ```js
  let count = 0;
  
  while (count < 10) {...}
  ```

- do ... while --
  ```js
  do {
    ...
  } while (count < 10);
  ```

- for loop --
  ```js
  for (let i = 0; i < 10; i++) {...}
  ```

- for ... of --
  ```js
    const digits = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9];

  for (const digit of digits) {
    console.log(digit);
  }
  ```

- loop control -- `break` and `continue` are valid in js. with those respective keywords.

<br>
<br>

---

<br>
<br>

# Functions

- I am not going to note down the logic of the functions, just their javascript syntax:
  ```js
  function sayHello(name, age) {
      document.write (name + " is " + age + " years old.");
      return false;
  }
  ```
  
<br>
<br>

---

<br>
<br>

# Event

- JavaScript's interaction with HTML is handled through events that occur when the user or the browser manipulates a page. Lets see the most basic `click` event:
  ```js
  function sayHello() {
      alert("Hello World")
  }
  
  document.getElementById("button").onclick = sayHello();
  ```
  
- check the reference for most used event types. or google.
  
<br>
<br>
  
---

<br>
<br>

# Cookies

- You can store cookies using DOM 

<br>
<br>

---

<br>
<br>

# Number

- Useful number functions built in javascript:
  - `toExponential()` -- Forces a number to display in exponential notation, even if the number is in the range in which JavaScript normally uses standard notation.
  - `toFixed()` -- Formats a number with a specific number of digits to the right of the decimal.
  - `toLocaleString()` -- Returns a string value version of the current number in a format that may vary according to a browser's local settings.
  - `toPrecision()` -- Defines how many total digits (including digits to the left and right of the decimal) to display of a number.
  - `toString()` -- Returns the string representation of the number's value.
  - `valueOf()` -- Returns the number's value.

<br>
<br>

---

<br>
<br>

# Boolean

- Useful boolean functions built in javascript:
  - `toSource()` -- Returns a string containing the source of the Boolean object; you can use this string to create an equivalent object.
  - `toString()` -- Returns a string of either "true" or "false" depending upon the value of the object.
  - `valueOf()` -- Returns the primitive value of the Boolean object.

<br>
<br>

---

<br>
<br>

# Strings

- Useful string functions built in javascript:
  - `charAt()` -- Returns the character at the specified index.
  - `charCodeAt()` -- Returns a number indicating the Unicode value of the character at the given index.
  - `concat()` -- Combines the text of two strings and returns a new string.
  - `indexOf()` -- Returns the index within the calling String object of the first occurrence of the specified value, or -1 if not found.
  - `lastIndexOf()` -- Returns the index within the calling String object of the last occurrence of the specified value, or -1 if not found.
  - `localeCompare()` -- Returns a number indicating whether a reference string comes before or after or is the same as the given string in sort order.
  - `match()` -- Used to match a regular expression against a string.
  - `replace()` -- Used to find a match between a regular expression and a string, and to replace the matched substring with a new substring.
  - `search()` -- Executes the search for a match between a regular expression and a specified string.
  - `slice()` -- Extracts a section of a string and returns a new string.
  - `split()` -- Splits a String object into an array of strings by separating the string into substrings.
  - `substr()` -- Returns the characters in a string beginning at the specified location through the specified number of characters.
  - `substring()` -- Returns the characters in a string between two indexes into the string.
  - `toLocaleLowerCase()` -- The characters within a string are converted to lower case while respecting the current locale.
  - `toLocaleUpperCase()` -- The characters within a string are converted to upper case while respecting the current locale.
  - `toLowerCase()` -- Returns the calling string value converted to lower case. 
  - `toString()` -- Returns a string representing the specified object.
  - `toUpperCase()` -- Returns the calling string value converted to uppercase.
  - `valueOf()` -- Returns the primitive value of the specified object.

<br>
<br>

---

<br>
<br>

# Array

- Useful string functions built in Array:
  - `concat()` -- Returns a new array comprised of this array joined with other array(s) and/or value(s).
  - `every()` -- Returns true if every element in this array satisfies the provided testing function.
  - `filter()` -- Creates a new array with all of the elements of this array for which the provided filtering function returns true.
  - `forEach()` -- Calls a function for each element in the array.
  - `indexOf()` -- Returns the first (least) index of an element within the array equal to the specified value, or -1 if none is found.
  - `join()` -- Joins all elements of an array into a string.
  - `lastIndexOf()` -- Returns the last (greatest) index of an element within the array equal to the specified value, or -1 if none is found.
  - `map()` -- Creates a new array with the results of calling a provided function on every element in this array.
  - `pop()` -- Removes the last element from an array and returns that element.
  - `push()` -- Adds one or more elements to the end of an array and returns the new length of the array.
  - `reduce()` -- Apply a function simultaneously against two values of the array (from left-to-right) as to reduce it to a single value.
  - `reduceRight()` -- Apply a function simultaneously against two values of the array (from right-to-left) as to reduce it to a single value
  - `reverse()` -- Reverses the order of the elements of an array -- the first becomes the last, and the last becomes the first.
  - `shift()` -- Removes the first element from an array and returns that element.
  - `slice()` -- Extracts a section of an array and returns a new array.
  - `some()` -- Returns true if at least one element in this array satisfies the provided testing function.
  - `toSource()` -- Represents the source code of an object
  - `sort()` -- Sorts the elements of an array
  - `splice()` -- Adds and/or removes elements from an array.
  - `toString()` -- Returns a string representing the array and its elements.
  - `unshift()` -- Adds one or more elements to the front of an array and returns the new length of the array.

<br>
<br>

---

<br>
<br>

# Math

- Here is the useful math methods:
  - `abs()` -- Returns the absolute value of a number.
  - `acos()` -- Returns the arccosine (in radians) of a number.
  - `asin()` -- Returns the arcsine (in radians) of a number.
  - `atan()` -- Returns the arctangent (in radians) of a number.
  - `atan2()` -- Returns the arctangent of the quotient of its arguments.
  - `ceil()` -- Returns the smallest integer greater than or equal to a number.
  - `cos()` -- Returns the cosine of a number.
  - `exp()` -- Returns EN, where N is the argument, and E is Euler's constant, the base of the natural logarithm.
  - `floor()` -- Returns the largest integer less than or equal to a number.
  - `log()` -- Returns the natural logarithm (base E) of a number.
  - `max()` -- Returns the largest of zero or more numbers.
  - `min()` -- Returns the smallest of zero or more numbers.
  - `pow()` -- Returns base to the exponent power, that is, base exponent.
  - `random()` -- Returns a pseudo-random number between 0 and 1.
  - `round()` -- Returns the value of a number rounded to the nearest integer.
  - `sin()` -- Returns the sine of a number.
  - `sqrt()` -- Returns the square root of a number.
  - `tan()` -- Returns the tangent of a number.
  - `toSource()` -- Returns the string "Math".

<br>
<br>

---

<br>
<br>
