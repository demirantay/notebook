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

- Memory management in JavaScript is performed automatically and invisibly to us. We create primitives, objects, functions… All that takes memory. The main concept of memory management in JavaScript is `reachability`.

- There’s a base set of inherently reachable values, that cannot be deleted for obvious reasons.These values are called roots. For instance:
  - Local variables and parameters of the current function.
  - Variables and parameters for other functions on the current chain of nested calls.
  - Global variables.
  - (there are some other, internal ones as well)
- Any other value is considered reachable if it’s reachable from a root by a reference or by a chain of references.

  There’s a background process in the JavaScript engine that is called `garbage collector`. It monitors all objects and removes those that have become unreachable.
  
  > The basic garbage collection algorithm is called “mark-and-sweep”.
  
- The main things to know:
  - Garbage collection is performed automatically. We cannot force or prevent it.
  - Objects are retained in memory while they are reachable.
  - Being referenced is not the same as being reachable (from a root): a pack of interlinked objects can become unreachable as a whole.
  
  Modern engines implement advanced algorithms of garbage collection.
  
  A general book “The Garbage Collection Handbook: The Art of Automatic Memory Management” (R. Jones et al) covers some of them.
  
  If you are familiar with low-level programming, the more detailed information about V8 garbage collector is in the article A tour of [V8: Garbage Collection.](http://jayconrod.com/posts/55/a-tour-of-v8-garbage-collection)
  
  In-depth knowledge of engines is good when you need low-level optimizations. It would be wise to plan that as the next step after you’re familiar with the language.
  
<br>
<Br>

# Symbol type

- By specification, object property keys may be either of string type, or of symbol type. Not numbers, not booleans, only strings or symbols, these two types.

- A “symbol” represents a unique identifier. A value of this type can be created using Symbol(): 
  ```js
  // id is a new symbol
  let id = Symbol();
  ```
  Symbols are guaranteed to be unique. Even if we create many symbols with the same description, they are different values. The description is just a label that doesn’t affect anything. For instance, here are two symbols with the same description – they are not equal:
  ```js
  let id1 = Symbol("id");
  let id2 = Symbol("id");

  alert(id1 == id2); // false
  ```
  
- The main things to know:
  - `Symbol` is a primitive type for unique identifiers.

  - Symbols are created with `Symbol()` call with an optional description (name).

  - Symbols are always different values, even if they have the same name. If we want same-named symbols to be equal, then we should use the global registry
  
  - Symbols have two main use cases:  
    - 1 - “Hidden” object properties. If we want to add a property into an object that “belongs” to another script or a library, we can create a symbol and use it as a property key. A symbolic property does not appear in for..in, so it won’t be accidentally processed together with other properties. Also it won’t be accessed directly, because another script does not have our symbol. So the property will be protected from accidental use or overwrite. So we can “covertly” hide something into objects that we need, but others should not see, using symbolic properties.
    
    - 2 - There are many system symbols used by JavaScript which are accessible as Symbol.*. We can use them to alter some built-in behaviors. For instance, later in the tutorial we’ll use Symbol.iterator for iterables, Symbol.toPrimitive to setup object-to-primitive conversion and so on.
  
  - Technically, symbols are not 100% hidden. There is a built-in method Object.getOwnPropertySymbols(obj) that allows us to get all symbols. Also there is a method named Reflect.ownKeys(obj) that returns all keys of an object including symbolic ones. So they are not really hidden. But most libraries, built-in functions and syntax constructs don’t use these methods.
  
  
<br>
<br>

# Object methods: "this"

<br>
<Br>

# Object to primitive conversion

<br>
<br>

# Constructor, operator "new"
