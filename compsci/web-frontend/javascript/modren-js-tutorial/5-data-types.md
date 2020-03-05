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

<br>
<br>

# Strings

<br>
<br>

# Arrays

<br>
<br>

# Array Methods

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
