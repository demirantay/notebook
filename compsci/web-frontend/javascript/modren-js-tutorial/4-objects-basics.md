# Objects

- As we know from the chapter Data types, there are seven data types in JavaScript. Six of them are called “primitive”, because their values contain only a single thing (be it a string or a number or whatever).

  In contrast, objects are used to store keyed collections of various data and more complex entities. In JavaScript, objects penetrate almost every aspect of the language. So we must understand them first before going in-depth anywhere else.

  An object can be created with figure brackets `{…}` with an optional list of properties. A property is a “key: value” pair, where key is a string (also called a “property name”), and value can be anything.
  ```js
  let user = new Object(); // "object constructor" syntax
  let user = {};  // "object literal" syntax
  ```
  
- Lets see a simple object with properties:
  ```js
  let user = {     // an object
    name: "John",  // by key "name" store value "John"
    age: 30        // by key "age" store value 30
  };
  ```
  Property values are accessible using the dot notation:
  ```js
  alert( user.name ); // John
  alert( user.age ); // 30
  ```
  We can also use multiword property names, but then they must be quoted:
  ```js
  "likes birds": true  // For multiword properties, the dot access doesn’t work:
  ```
  For multiword properties, the dot access doesn’t work:



- Objects are associative arrays with several special features. They store properties (key-value pairs), where:
  - Property keys must be strings or symbols (usually strings).
  - Values can be of any type.
- To access a property, we can use:
  - The dot notation: `obj.property`.
  - Square brackets notation `obj["property"]`. Square brackets allow to take the key from a variable, like `obj[varWithKey]`.
- Additional operators:
  - To delete a property: `delete obj.prop`.
  - To check if a property with the given key exists: `"key" in obj`.
  - To iterate over an object: `for (let key in obj) loop`.
- Objects are assigned and copied by reference. In other words, a variable stores not the “object value”, but a “reference” (address in memory) for the value. So copying such a variable or passing it as a function argument copies that reference, not the object. All operations via copied references (like adding/removing properties) are performed on the same single object.
- To make a “real copy” (a clone) we can use Object.assign
- What we’ve studied in this chapter is called a “plain object”, or just Object. There are many other kinds of objects in JavaScript:
  - `Array` to store ordered data collections,
  - `Date` to store the information about the date and time,
  - `Error` to store the information about an error.
  
  Objects in JavaScript are very powerful. Here we’ve just scratched the surface of a topic that is really huge. We’ll be closely working with objects and learning more about them in further parts of the tutorial.
  
<br>
<bR>

# Garbage Collection

<br>
<Br>

# Symbol type

<br>
<br>

# Object methods: "this"

<br>
<Br>

# Object to primitive conversion

<br>
<br>

# Constructor, operator "new"
