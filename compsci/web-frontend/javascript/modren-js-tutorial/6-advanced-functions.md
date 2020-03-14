## Rest parameters and spread syntax

- Many JavaScript built-in functions support an arbitrary number of arguments.
  
  For instance:
  - `Math.max(arg1, arg2, ..., argN)` – returns the greatest of the arguments.
  - `Object.assign(dest, src1, ..., srcN)` – copies properties from `src1..N` into `dest`.
  - …and so on.

- To sum up:
  
  When we see `"..."` in the code, it is either rest parameters or the spread syntax.
  
  There’s an easy way to distinguish between them:
  - When `...` is at the end of function parameters, it’s “rest parameters” and gathers the rest of the list of arguments into an array.
  - When `...` occurs in a function call or alike, it’s called a “spread syntax” and expands an array into a list.
  
  Use patterns:
  - Rest parameters are used to create functions that accept any number of arguments.
  - The spread syntax is used to pass an array to functions that normally require a list of many arguments.

- Lets see some example:
  ```js
  function sumAll(...args) { // args is the name for the array
    let sum = 0;

    for (let arg of args) sum += arg;

    return sum;
  }

  alert( sumAll(1) ); // 1
  alert( sumAll(1, 2) ); // 3
  alert( sumAll(1, 2, 3) ); // 6
  ```

- https://javascript.info/rest-parameters-spread

<br>
<br>

## The old "var"

- There are two main differences of `var` compared to `let/const`:
  - 1 - `var` variables have no block scope, they are visible minimum at the function level.
  - 2 - `var` declarations are processed at function start (script start for globals).

  These differences make `var` worse than `let` most of the time. Block-level variables is such a great thing. That’s why let was introduced in the standard long ago, and is now a major way (along with `const`) to declare a variable.
  

<br>
<br>

## Global object

- The global object provides variables and functions that are available anywhere. By default, those that are built into the language or the environment.

- To sum up:
  - The global object holds variables that should be available everywhere.
  - That includes JavaScript built-ins, such as `Array` and environment-specific values, such as `window.innerHeight` – the window height in the browser
  - The global object has a universal name `globalThis`.
    
    …But more often is referred by “old-school” environment-specific names, such as `window` (browser) and `global` (Node.js). As `globalThis` is a recent proposal, it’s not supported in non-Chromium Edge (but can be polyfilled).
  - We should store values in the global object only if they’re truly global for our project. And keep their number at minimum.
  - In-browser, unless we’re using modules, global functions and variables declared with var become a property of the global object.
  - To make our code future-proof and easier to understand, we should access properties of the global object directly, as `window.x`.

<br>
<br>

## Function object, NFE

- As we already know, a function in JavaScript is a value. Every value in JavaScript has a type. What type is a function? In JavaScript, functions are objects. A good way to imagine functions is as callable “action objects”. We can not only call them, but also treat them as objects: add/remove properties, pass by reference etc.

- Function objects have their own methods as most of the primitive data types (objects) does. Lets talk about a few:
  - `name` – the function name. Usually taken from the function definition, but if there’s none, JavaScript tries to guess it from the context (e.g. an assignment).
  - `length` – the number of arguments in the function definition. Rest parameters are not counted.
  
  If the function is declared as a Function Expression (not in the main code flow), and it carries the name, then it is called a Named Function Expression. The name can be used inside to reference itself, for recursive calls or such.
  
  Also, functions may carry additional properties. Many well-known JavaScript libraries make great use of this feature.

  They create a “main” function and attach many other “helper” functions to it. For instance, the jQuery library creates a function named `$`. The lodash library creates a function `_`, and then adds `_.clone`, `_.keyBy` and other properties to it (see the docs when you want learn more about them). Actually, they do it to lessen their pollution of the global space, so that a single library gives only one global variable. That reduces the possibility of naming conflicts.
  
  So, a function can do a useful job by itself and also carry a bunch of other functionality in properties.

<br>
<br>

## The "new Function" syntax

- There’s one more way to create a function. It’s rarely used, but sometimes there’s no alternative.
  ```js
  let func = new Function ([arg1, arg2, ...argN], functionBody);
  ```
  For historical reasons, arguments can also be given as a comma-separated list.
  
  These three declarations mean the same:
  ```js
  new Function('a', 'b', 'return a + b'); // basic syntax
  new Function('a,b', 'return a + b'); // comma-separated
  new Function('a , b', 'return a + b'); // comma-separated with spaces
  ```
  Functions created with `new Function`, have `[[Environment]]` referencing the global Lexical Environment, not the outer one. Hence, they cannot use outer variables. But that’s actually good, because it insures us from errors. Passing parameters explicitly is a much better method architecturally and causes no problems with minifiers.

<br>
<br>

## Scheduling: setTimeout and setInterval

- We may decide to execute a function not right now, but at a certain time later. That’s called “scheduling a call”.

  There are two methods for it:
  - `setTimeout` allows us to run a function once after the interval of time.
  - `setInterval` allows us to run a function repeatedly, starting after the interval of time, then repeating continuously at that interval.
  
- To sum up:
  - Methods `setTimeout(func, delay, ...args)` and `setInterval(func, delay, ...args)` allow us to run the `func` once/regularly after `delay` milliseconds.
  - To cancel the execution, we should call `clearTimeout/clearInterval` with the value returned by `setTimeout/setInterval`.
  - Nested `setTimeout` calls are a more flexible alternative to `setInterval`, allowing us to set the time between executions more precisely.
  - Zero delay scheduling with `setTimeout(func, 0)` (the same as setTimeout(func)) is used to schedule the call “as soon as possible, but after the current script is complete”.
  - The browser limits the minimal delay for five or more nested call of `setTimeout` or for `setInterval` (after 5th call) to 4ms. That’s for historical reasons.
  
  Please note that all scheduling methods do not guarantee the exact delay. For example, the in-browser timer may slow down for a lot of reasons:
  - The CPU is overloaded.
  - The browser tab is in the background mode.
  - The laptop is on battery.
  
  All that may increase the minimal timer resolution (the minimal delay) to 300ms or even 1000ms depending on the browser and OS-level performance settings.

<br>
<br>

## Decorators and forwarding, call/apply

- Decorator is a wrapper around a function that alters its behavior. The main job is still carried out by the function.

  Decorators can be seen as “features” or “aspects” that can be added to a function. We can add one or add many. And all this without changing its code!
  
  The generic call forwarding is usually done with `apply`:
  ```js
  let wrapper = function() {
    return original.apply(this, arguments);
  };
  ```

<bR>
<br>
  
## Function binding

- When passing object methods as `callbacks,` for instance to `setTimeout`, there’s a known problem: "losing `this`".

  Method `func.bind(context, ...args)` returns a “bound variant” of function `func` that fixes the context `this` and first arguments if given. 
  
  Usually we apply `bind` to fix `this` for an object method, so that we can pass it somewhere. For example, to setTimeout.

  When we fix some arguments of an existing function, the resulting (less universal) function is called partially applied or partial.
  
  Partials are convenient when we don’t want to repeat the same argument over and over again. Like if we have a `send(from, to)` function, and `from` should always be the same for our task, we can get a partial and go on with it.

<bR>
<br>
  
## Arrow functions revisited

- Arrow functions are not just a “shorthand” for writing small stuff. They have some very specific and useful features.
  
- To sum up:
  - Do not have `this`
  - Do not have `arguments`
  - Can’t be called with `new`
  - They also don’t have `super`
