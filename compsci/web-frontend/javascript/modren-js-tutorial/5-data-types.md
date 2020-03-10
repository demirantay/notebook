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

- Arrays provide a lot of methods. I am not going to note every one of them in this file since it would get too big. Lets just review the most commonly used ones:
  
  To add/remove elements:
  - `push(...items)` – adds items to the end,
  - `pop()` – extracts an item from the end,
  - `shift()` – extracts an item from the beginning
  - `unshift(...items)` --  adds items to the beginning.
  - `splice(pos, deleteCount, ...items)` -- at `inde`x pos delete `deleteCount` elements and insert items.
  - `slice(start, end)` -– creates a new array, copies elements from position `start` till `end` (not inclusive) into it.
  - `concat(...items)` -– returns a new array: copies all members of the current one and adds items to it. If any of items is an array, then its elements are taken.
  
  To search among elements:
  - `indexOf/lastIndexOf(item, pos)` --  look for `item` starting from position `po`s, return the index or `-1` if not found.
  - `includes(value)` – returns `true` if the array has `value`, otherwise `false`.
  - `find/filter(func)` -- filter elements through the function, return first/all values that make it return true.
  - `findIndex` -- is like `find`, but returns the index instead of a value.
  
  To iterate over elements:
  - `forEach(func)` -- calls `func` for every element, does not return anything.

  To transform the array:
  - `map(func)` – creates a new array from results of calling `func` for every element.
  - `sort(func) `– sorts the array in-place, then returns it.
  - `reverse()` – reverses the array in-place, then returns it.
  - `split/join` – convert a string to array and back.
  - `reduce(func, initial)`– calculate a single value over the array by calling func for each element and passing an intermediate result between the calls.

  Additionally:
  - `Array.isArray(arr)` -- checks arr for being an array.

  > These methods are the most used ones, they cover 99% of use cases. But there are few others: Check the documentation

<br>
<br>

# Iterables

- Iterable objects is a generalization of arrays. That’s a concept that allows us to make any object useable in a `for..of` loop.

  Of course, Arrays are iterable. But there are many other built-in objects, that are iterable as well. For instance, strings are also iterable.

  If an object isn’t technically an array, but represents a collection (list, set) of something, then `for..of` is a great syntax to loop over it, so let’s see how to make it work.
  
- To sum up:
  - Objects that can be used in for..of are called iterable.
  - Technically, iterables must implement the method named Symbol.iterator.
    - The result of obj[Symbol.iterator] is called an iterator. It handles the further iteration process.
    - An iterator must have the method named next() that returns an object {done: Boolean, value: any}, here done:true denotes the end of the iteration process, otherwise the value is the next value.
  - The Symbol.iterator method is called automatically by for..of, but we also can do it directly.
  - Built-in iterables like strings or arrays, also implement Symbol.iterator.
  - String iterator knows about surrogate pairs.

<br>
<br>

# Map and Set

- Now we’ve learned about the following complex data structures:
  - Objects for storing keyed collections.
  - Arrays for storing ordered collections.

  But that’s not enough for real life. That’s why `Map` and `Set` also exist.
  
  `Map` -- is a collection of keyed data items, just like an Object. But the main difference is that Map allows keys of any type. (Hash Table bascially)
  
  `Set` --  is a special type collection – “set of values” (without keys), where each value may occur only once.

- To sum up:
  
  Map – is a collection of keyed values:
  - `new Map([iterable])` – creates the map, with optional `iterable` (e.g. array) of `[key,value]` pairs for initialization.
  - `map.set(key, value)` – stores the value by the key.
  - `map.get(key)` – returns the value by the `key`, undefined if key doesn’t exist in map.
  - `map.has(key)` – returns true if the key exists, false otherwise.
  - `map.delete(key)` – removes the value by the key.
  - `map.clear()` – removes everything from the map
  - `map.size` – returns the current element count.
  
  The differences from a regular Object:
  - Any keys, objects can be keys.
  - Additional convenient methods, the size property.
  
  Set – is a collection of unique values.
  - `new Set([iterable])` – creates the set, with optional iterable (e.g. array) of values for initialization.
  - `set.add(value)` – adds a value (does nothing if value exists), returns the set itself.
  - `set.delete(value)` – removes the value, returns true if value existed at the moment of the call, otherwise false.
  - `set.has(value)` – returns true if the value exists in the set, otherwise false.
  - `set.clear()` – removes everything from the set.
  - `set.size` – is the elements count.
  
<br>
<br>

# WeakMap and WeakSet

To sum up:
  - `WeakMap` is Map-like collection that allows only objects as keys and removes them together with associated value once they become inaccessible by other means.
  - `WeakSet` is Set-like collection that stores only objects and removes them once they become inaccessible by other means.
  - Both of them do not support methods and properties that refer to all keys or their count. Only individual operations are allowed.
  - WeakMap and WeakSet are used as “secondary” data structures in addition to the “main” object storage. Once the object is removed from the main storage, if it is only found as the key of WeakMap or in a WeakSet, it will be cleaned up automatically.


<br>
<br>

# Object.keys, values, entries

-  Let’s step away from the individual data structures and talk about the iterations over them.

  In the previous chapter we saw methods `map.keys()`, `map.values()`, `map.entries()`.
  
  These methods are generic, there is a common agreement to use them for data structures. If we ever create a data structure of our own, we should implement them too. They are supported for:
  - `Map`
  - `Set`
  - `Array`
  
- Plain objects also support similar methods, but the syntax is a bit different. For plain objects, the following methods are available:
  - `Object.keys(obj)` – returns an array of keys.
  - `Object.values(obj)` – returns an array of values.
  - `Object.entries(obj)` – returns an array of [key, value] pairs.

<br>
<br>

# Destructuring assignment

- The two most used data structures in JavaScript are Object and Array.

  Objects allow us to create a single entity that stores data items by key, and arrays allow us to gather data items into an ordered collection.
  
  But when we pass those to a function, it may need not an object/array as a whole, but rather individual pieces.

  Destructuring assignment is a special syntax that allows us to “unpack” arrays or objects into a bunch of variables, as sometimes that’s more convenient. Destructuring also works great with complex functions that have a lot of parameters, default values, and so on.
  
- To sum up:
  - Destructuring assignment allows for instantly mapping an object or array onto many variables.
  - The full object syntax:
    ```js
    let {prop : varName = default, ...rest} = object
    ```
    This means that property `prop` should go into the variable `varName` and, if no such property exists, then the `default` value should be used. Object properties that have no mapping are copied to the `rest` object.
  - The full array syntax:
    ```js
    let [item1 = default, item2, ...rest] = array
    ```
    The first item goes to `item1`; the second goes into `item2`, all the rest makes the array `rest`.
  - It’s possible to extract data from nested arrays/objects, for that the left side must have the same structure as the right one.

<br>
<br>

# Date and time

- Let’s meet a new built-in object: `Date`. It stores the date, time and provides methods for date/time management. 

  For instance, we can use it to store creation/modification times, to measure time, or just to print out the current date.

- To sum up:
  - Date and time in JavaScript are represented with the Date object. We can’t create “only date” or “only time”: `Date` objects always carry both.
  - Months are counted from zero (yes, January is a zero month).
  - Days of week in `getDay()` are also counted from zero (that’s Sunday).
  - `Date` auto-corrects itself when out-of-range components are set. Good for adding/subtracting days/months/hours.
  - Dates can be subtracted, giving their difference in milliseconds. That’s because a `Date` becomes the timestamp when converted to a number.
  - Use `Date.now()` to get the current timestamp fast.
  - Note that unlike many other systems, timestamps in JavaScript are in milliseconds, not in seconds.

<br>
<br>

# JSON methods, toJSON

- Let’s say we have a complex object, and we’d like to convert it into a string, to send it over a network, or just to output it for logging purposes.

  Naturally, such a string should include all important properties. We could implement the conversion like this:
  ```js
  let user = {
    name: "John",
    age: 30,

    toString() {
      return `{name: "${this.name}", age: ${this.age}}`;
    }
  };

  alert(user); // {name: "John", age: 30}
  ```
  …But in the process of development, new properties are added, old properties are renamed and removed. Updating such `toString` every time can become a pain. We could try to loop over properties in it, but what if the object is complex and has nested objects in properties? We’d need to implement their conversion as well.

  Luckily, there’s no need to write the code to handle all this. The task has been solved already.

### JSON.stringify

- The JSON (JavaScript Object Notation) is a general format to represent values and objects. It is described as in RFC 4627 standard. Initially it was made for JavaScript, but many other languages have libraries to handle it as well. So it’s easy to use JSON for data exchange when the client uses JavaScript and the server is written on Ruby/PHP/Java/Whatever.

  JavaScript provides methods:
  - `JSON.stringify` to convert objects into JSON.
  - `JSON.parse` to convert JSON back into an object.
  
- To sum up:
  - JSON is a data format that has its own independent standard and libraries for most programming languages.
  - JSON supports plain objects, arrays, strings, numbers, booleans, and null.
  - JavaScript provides methods `JSON.stringify` to serialize into JSON and `JSON.parse` to read from JSON.
  - Both methods support transformer functions for smart reading/writing.
  - If an object has `toJSON`, then it is called by `JSON.stringify`.
