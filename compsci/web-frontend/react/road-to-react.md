# Book: Road to React

These are my notes on the book: Road to React

- React was released by Facebook’s web development team in 2013 as a view library, which makes it the ‘V’ in the MVC33 (model view controller). As a view, it allows you to render components as viewable elements in a browser, while its ecosystem lets us build single page applications. While the first generation of frameworks tried to solve many things at once, React is only used to build your view layer; specifically, it is a library wherein the view is a hierarchy of composable components.

<br>
<br>
<br>

# Installation & Configuration

- I am not going to note down how to install react because I have done it numerous times in other note files. However remember that if you download react using `npm` rather than `npx` you have to setup the babel and webpack yourself so remember that but in any case most recommended configuration free waay to install react is using the `create-react-app` command

- As I said above I am not going to note about `create-react-app` command since I already wrote another note file simply dedicated for it.

<br>
<br>
<br>

# ES6 const and let

- JavaScript ES6 comes with two more ways to declare variables: const and let. In JavaScript ES6, you will rarely find var anymore. A variable declared with const cannot be re-assigned or re-declared, and cannot be changed or modified. Once the variable is assigned, you cannot change it:
  ```js
  const PI = 3.1415;        // cannot be modified
  let hello = "local var";  // can be modified
  ```
  There are varying opinions about when to use const and when to use let. I would recommend using const whenever possible to show the intent of keeping your data structures immutable, so you only have to worry about the values contained in objects and arrays. Immutability is embraced in the React ecosystem, so const should be your default choice when you define a variable, though it’s not really about immutability, but about assigning variables only once. It shows the intent of not changing (re-assigning) the variable even though its content can be changed.

<br>
<br>
<br>

# ReactDOM

- Rememer the `App` component should be located in your entry point to the React world: the src/index.js file:
  ```javascript
  import React from 'react';
  import ReactDOM from 'react-dom';
  import App from './App';
  import './index.css';
  
  ReactDom.render(
    <App />
    document.getelementById('root')
  );
  ```
  `ReactDOM.render()` uses a DOM node in your HTML to replace it with JSX. It’s a way to integrate React in any foreign application easily, and you can use `ReactDOM.render()` multiple times across your application. You can use it to bootstrap simple JSX syntax, a React component, multiple React components, or an entire application. In a plain React application, you would only use it once to bootstrap the component tree.
  
  `ReactDOM.render()` expects two arguments. The first argument is for rendering the JSX. The second argument specifies the place where the React application hooks into your HTML. It expects an element with an id='root', found in the public/index.html file.
  
  <br>
  <br>
  <br>
  
# Hot Module Replacement

