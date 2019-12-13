# Coding Style

- Our code must be as clean and easy to read as possible. 

  That is actually the art of programming – to take a complex task and code it in a way that is both correct and human-readable. A good code style greatly assists in that.

### Cheatsheet

- Here is a cheat sheet with some suggested rules (see below for more details):

  No space between the function name and parentheses between the parentheses and the parameter and A space between parameters:
  ```js
  function power(x, n) { ... }
  ```
  Spaces around a nested calls
  ```js
  alert( power(x, n) );
  ```
  
- Nothing is set in stone here. These are style preferences, not religious dogmas. For example every langauge has their own standart preferences like there is PEP8 for python ... etc. But since javascript is less organizational and every company has their own taste you can check github for popular javascript style guides:
  - [google's js guide](https://google.github.io/styleguide/javascriptguide.xml)
  - [airbnb's js guide](https://github.com/airbnb/javascript)
  - etc ...


### Automated Linters

- Linters are tools that can automatically check the style of your code and make improving suggestions.

  The great thing about them is that style-checking can also find some bugs, like typos in variable or function names. Because of this feature, using a linter is recommended even if you don’t want to stick to one particular “code style”.
  
  Here are some well-known linting tools:
  - JSLint – one of the first linters.
  - JSHint – more settings than JSLint.
  - ESLint – probably the newest one.

<br>
<br>

# Comments

- `Comment This` -
  - Overall architecture, high-level view.
  - Function usage.
  - Important solutions, especially when not immediately obvious.

  `Avoid comments` -
  - That tell “how code works” and “what it does”.
  - Put them in only if it’s impossible to make the code so simple and self-descriptive that it doesn’t require them.
  
<br>
<br>

# Polyfills

- The JavaScript language steadily evolves. New proposals to the language appear regularly, they are analyzed and, if considered worthy, are appended to the list at https://tc39.github.io/ecma262/ and then progress to the specification.

  Teams behind JavaScript engines have their own ideas about what to implement first. They may decide to implement proposals that are in draft and postpone things that are already in the spec, because they are less interesting or just harder to do.

  So it’s quite common for an engine to implement only the part of the standard.
  
### Babel

- When we use modern features of the language, some engines may fail to support such code. Just as said, not all features are implemented everywhere.

  Here Babel comes to the rescue.

  Babel is a transpiler. It rewrites modern JavaScript code into the previous standard. 
  
- First, the transpiler program, which rewrites the code. The developer runs it on their own computer. It rewrites the code into the older standard. And then the code is delivered to the website for users. Modern project build systems like webpack provide means to run transpiler automatically on every code change, so that it’s very easy to integrate into development process.

  Second, the polyfill. A script that updates/adds new functions is called “polyfill”. It “fills in” the gap and adds missing implementations.

