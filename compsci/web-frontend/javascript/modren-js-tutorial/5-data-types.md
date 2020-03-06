# Methods of Primitives

- JavaScript allows us to work with primitives (strings, numbers, etc.) as if they were objects. They also provide methods to call as such. We will study those soon, but first we’ll see how it works because, of course, primitives are not objects (and here we will make it even clearer).

  Let’s look at the key distinctions between primitives and objects. 
  
  A primitive:
    - Is a value of a primitive type.
    - There are 7 primitive types: `string`, `number`, `bigint`, `boolean`, `symbol`, `null` and `undefined`.
  
  An object:
    - Is capable of storing multiple values as properties.
    - Can be created with {}, for instance: {name: "John", age: 30}. There are other kinds of objects in JavaScript: functions, for example, are objects.

- To sum up:
  - Primitives except `null` and `undefined` provide many helpful methods. We will study those in the upcoming chapters.
  - Formally, these methods work via temporary objects, but JavaScript engines are well tuned to optimize that internally, so they are not expensive to call.

<br>
<br>

# Numbers

- In modern JavaScript, there are two types of numbers:
  - Regular numbers in JavaScript are stored in 64-bit format IEEE-754, also known as “double precision floating point numbers”. These are numbers that we’re using most of the time,
  - BigInt numbers, to represent integers of arbitrary length. They are sometimes needed, because a regular number can’t exceed 253 or be less than -253. As bigints are used in few special areas, we devote them a special chapter BigInt.
  
- To sum up:
  - To write numbers with many zeroes:
    - Append `"e"` with the zeroes count to the number. Like: `123e6` is the same as `123` with 6 zeroes `123000000`.
    - A negative number after `"e"` causes the number to be divided by 1 with given zeroes. E.g. `123e-6` means `0.000123` (`123` millionths).

  - For different numeral systems:
    - Can write numbers directly in hex (0x), octal (0o) and binary (0b) systems
    - `parseInt(str, base)` parses the string `str` into an integer in numeral system with given base, `2 ≤ base ≤ 36`. 
    - For converting values like 12pt and 100px to a number: For example `pareseInt(100$)` returns you a just int 100
    
  - For fractions:
    - Round using` Math.floor`, `Math.ceil`, `Math.trunc`, `Math.round` or `num.toFixed(precision)`.
    - Make sure to remember there’s a loss of precision when working with fractions. That can cause very big problems, always keep it in your mind.
    - See the Math object when you need them. The library is very small, but can cover basic needs.
  
<br>
<br>

# Strings

- In JavaScript, the textual data is stored as strings. There is no separate type for a single character. The internal format for strings is always UTF-16, it is not tied to the page encoding.

- Strings can be enclosed within either single quotes, double quotes or backticks:
  ```js
  let single = 'single-quoted';
  let double = "double-quoted";
  let backticks = `backticks`;
  ```
  Another advantage of using backticks is that they allow a string to span multiple lines:
  ```js
  let guestList = `Guests:
   * John
   * Pete
   * Mary
  `;
  ```
  
- To sum up:
  - There are 3 types of quotes. Backticks allow a string to span multiple lines and embed expressions `${…}`.
  - Strings in JavaScript are encoded using UTF-16.
  - We can use special characters like `\n` and insert letters by their unicode using `\u...`
  - To get a character, use: `str[index]`.
  - To get a substring, use: `slice` or `substring`
  - To lowercase/uppercase a string, use: `toLowerCase/toUpperCase`.
  - To look for a substring, use: `indexOf`, or `includes/startsWith/endsWith` for simple checks.
  - To compare strings according to the language, use: `localeCompare`, otherwise they are compared by character codes.

  There are several other helpful methods in strings:
  - `str.trim()` – removes (“trims”) spaces from the beginning and end of the string.
  - `str.repeat(n)` – repeats the string n times.
  
  > There are much more you can do with strings such as utilizing regular expressions with them ... etc. Check docs.

<br>
<br>

# Arrays

- There are two syntaxes for creating an empty array:
  ```js
  let arr = new Array();
  let arr = [];
  ```

- But for arrays there is another form of loop, for..of:
  ```js
  let fruits = ["Apple", "Orange", "Plum"];

  // iterates over array elements
  for (let fruit of fruits) {
    alert( fruit );
  }
  ```
  > dont use for ... in use `of` since it is extremly faster
  
  
- To sum up:
  - The `.length` property is the array length or, to be precise, its last numeric index plus one. It is auto-adjusted by array methods.
  - If we shorten `length` manually, the array is truncated.

  We can use an array as a deque with the following operations:
  - `push(...items)` adds i`tems` to the end.
  - `pop()` removes the element from the end and returns it.
  - `shift()` removes the element from the beginning and returns it.
  - `unshift(...items)` adds `items` to the beginning.
  
  To loop over the elements of the array:
  - `for (let i=0; i<arr.length; i++)` – works fastest, old-browser-compatible.
  - `for (let item of arr)` – the modern syntax for items only,
  - `for (let i in arr)` – never use. slow as fuck
  
  > There are a lot more things to cover in array methods check the official docs.

<br>
<br>

# Array Methods

- Arrays provide a lot of methods. To make things easier, in this chapter they are split into groups.

<br>
<br>

# Iterables

<br>
<br>

# Map and Set

<br>
<br>

# WeakMap and WeakSet

<br>
<br>

# Object.keys, values, entries

<br>
<br>

# Destructuring assignment

<br>
<br>

# Date and time

<br>
<br>

# JSON methods, toJSON
