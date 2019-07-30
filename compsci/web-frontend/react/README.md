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
  
- After installing react inside the npm modules we have to start the react app. There are two ways of including this javascript library into our code. First is using the npx start app command or just including inside your html file just like you include a jquery or bootstrap.

  First lets see how to use jsx:
  ```
  $ npx create-react-app my-app
  $ cd my-app
  $ npm start
  ```
  Create React App doesn’t handle backend logic or databases; it just creates a frontend build pipeline, so you can use it with any backend you want. Under the hood, it uses Babel and webpack, but you don’t need to know anything about them.
  
- Well we saw how to install react with `create-react-app` command so now lets see another way and learn how to include the library inside the html. First, open the HTML page you want to edit. Add an empty <div> tag to mark the spot where you want to display something with React. For example:
  ```html
  <!-- ... existing HTML ... -->

  <div id="react_goes_here"></div>

  <!-- ... existing HTML ... -->
  ```
  And then next, add three <script> tags to the HTML page right before the closing </body> tag:
  ```html
    <!-- ... other HTML ... -->

    <!-- Load React. -->
    <!-- Note: when deploying, replace "development.js" with "production.min.js". -->
    <script src="https://unpkg.com/react@16/umd/react.development.js" crossorigin></script>
    <script src="https://unpkg.com/react-dom@16/umd/react-dom.development.js" crossorigin></script>

    <!-- Load our React component. -->
    <script src="react_goes_here.js"></script>

  </body>
  ```
  The first two tags load React. The third one will load your component code. After doing the above create a file called `react_goes_here.js` next to your HTML page and add :
  ```js
  // ... react code ...
  
  const domContainer = document.querySelector('#react_code_goes_here');
  ReactDOM.render(e(reactCode), domContainer);
  ```
  
  Note: I did not really understand how to add react into html. I will comeback to this later on ...
  
<br>
<br>
<br>

# JSX

- Consider this variable declaration:
  ```js
  const element = <h1>Hello world</h1>;
  ```
