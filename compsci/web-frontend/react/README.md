# React.js

- ReactJS is JavaScript library used for building reusable UI components. React is a front-end library developed by Facebook. It is used for handling the view layer for web and mobile apps. ReactJS allows us to create reusable UI components. It is currently one of the most popular JavaScript libraries and has a strong foundation and large community behind it.

- React features:
  - `JSX` − JSX is JavaScript syntax extension. It isn't necessary to use JSX in React development, but it is recommended.
  - `Components` − React is all about components. You need to think of everything as a component. This will help you maintain the code when working on larger scale projects.
  - `Unidirectional data flow and Flux` − React implements one-way data flow which makes it easy to reason about your app. Flux is a pattern that helps keeping your data unidirectional.
  
- React Advantages:
  - Uses virtual DOM which is a JavaScript object. This will improve apps performance, since JavaScript virtual DOM is faster than the regular DOM.
  - Can be used on client and server side as well as with other frameworks.
  - Component and data patterns improve readability, which helps to maintain larger apps.
  
- Limitations:
  - Covers only the view layer of the app, hence you still need to choose other technologies to get a complete tooling set for development such as django, laravel ..etc for your backend models controllers etc.
  
- First before development install react with npm:
  ```
  $ npm install react
  ```
  Also do not forget to install react dom
  ```
  $ npm install react-dom
  ```
  
<br>
<br>
<br>

# JSX

- Consider this variable declaration:
  ```js
  const element = <h1>Hello world</h1>;
  ```
