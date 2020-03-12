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

## Variable scope


<br>
<br>

## The old "var"


<br>
<br>

## Global object

<br>
<br>

## Function object, NFE

<br>
<br>

## The "new Function" syntax

<br>
<br>

## Scheduling: setTimeout and setInterval

<br>
<br>

## Decorators and forwarding, call/apply

<bR>
<br>
  
## Function binding

<bR>
<br>
  
## Arrow functions revisited
