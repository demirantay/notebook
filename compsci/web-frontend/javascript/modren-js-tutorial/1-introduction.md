# `1.1` Introduction to JavaScript

- Let’s see what’s so special about JavaScript, what we can achieve with it, and which other technologies play well with it.

### What is Javascript

- JavaScript was initially created to “make web pages alive”. The programs in this language are called scripts. They can be written right in a web page’s HTML and run automatically as the page loads. No need for compalation.

- Today, JavaScript can execute not only in the browser, but also on the server, or actually on any device that has a special program called the JavaScript engine.

- Different engines have different “codenames”. For example:
  - V8 – in Chrome and Opera.
  - SpiderMonkey – in Firefox.
  - SquirrelFish - for Safari, etc.
 
- `How do Engines Work?` -- Engines are complicated. But the basics are easy.
  - The engine (embedded if it’s a browser) reads (“parses”) the script.
  - Then it converts (“compiles”) the script to the machine language.
  - And then the machine code runs, pretty fast.
  
  The engine applies optimizations at each step of the process. It even watches the compiled script as it runs, analyzes the data that flows through it, and further optimizes the machine code based on that knowledge.

### What can in-browser javascript do 

- In-browser JavaScript can do everything related to webpage manipulation, interaction with the user, and the webserver. For instance, in-browser JavaScript is able to:
  - Add new HTML to the page, change the existing content, modify styles.
  - React to user actions, run on mouse clicks, pointer movements, key presses.
  - Send requests over the network to remote servers, download and upload files (so-called AJAX and COMET technologies).
  - Get and set cookies, ask questions to the visitor, show messages.
  - Remember the data on the client-side (“local storage”).

### What CAN'T in-browser javascript do 

- JavaScript’s abilities in the browser are limited for the sake of the user’s safety. The aim is to prevent an evil webpage from accessing private information or harming the user’s data.

  Examples of such restrictions include:
  - JavaScript on a webpage may not read/write arbitrary files on the hard disk, copy them or execute programs. It has no direct access to OS system functions. Modern browsers allow it to work with files, but the access is limited and only provided if the user does certain actions, like “dropping” a file into a browser window or selecting it via an <input> tag.
  - JavaScript can easily communicate over the net to the server where the current page came from. But its ability to receive data from other sites/domains is crippled. Though possible, it requires explicit agreement (expressed in HTTP headers) from the remote side. Once again, that’s a safety limitation.
  - etc ...

### Langauges over javascript

- The syntax of JavaScript does not suit everyone’s needs. Different people want different features.

  That’s to be expected, because projects and requirements are different for everyone.

  So recently a plethora of new languages appeared, which are transpiled (converted) to JavaScript before they run in the browser. Most common ones are:
  - `CoffeeScript` -- CoffeeScript is a “syntactic sugar” for JavaScript. It introduces shorter syntax, allowing us to write clearer and more precise code. Usually, Ruby devs like it.
  - `TypeScript` -- is concentrated on adding “strict data typing” to simplify the development and support of complex systems. It is developed by Microsoft.
  - `Flow` --  also adds data typing, but in a different way. Developed by Facebook.
  - `Dart` -- is a standalone language that has its own engine that runs in non-browser environments (like mobile apps), but also can be transpiled to JavaScript. Developed by Google.
  
<br>
<br>

---

<br>
<br>

# `1.2` Manuals and Specifications

### Specification

### Manuals

### Compatibility Tables

<br>
<br>

---

<br>
<br>

# `1.3` Code Editors


<br>
<br>

---

<br>
<Br>

# `1.4` Developer Console
