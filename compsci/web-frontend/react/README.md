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
  
<br>
<br>
<br>

# Installation

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
<br>

# JSX

- Consider this variable declaration:
  ```js
  const element = <h1>Hello world</h1>;
  ```
  This funny tag syntax is neither a string nor HTML. It is called JSX, and it is a syntax extension to JavaScript. We recommend using it with React to describe what the UI should look like. JSX may remind you of a template language, but it comes with the full power of JavaScript.
  
  React doesn’t require using JSX, but most people find it helpful as a visual aid when working with UI inside the JavaScript code. It also allows React to show more useful error and warning messages.
  
### Embedding Expressions in JSX

- In the example below, we declare a variable called name and then use it inside JSX by wrapping it in curly braces:
  ```js
  const name = "john";
  const element = <h1>Hello, {name}</h1>
  ```
  You can put any valid JavaScript expression inside the curly braces in JSX. For example, `2 + 2`, `user.firstName`, or `formatName(user)` are all valid JavaScript expressions.
  
- You can also use JSX inside of if statements and for loops, assign it to variables, accept it as arguments, and return it from functions:
  ```js
  function getGreeting(user) {
    if (user) {
      return <h1>Hello, {user.name}</h1>;
    }
    return <h1>Hello, Stranger.</h1>;
  }
  ```
  
### Specifiying Attributes with JSX

- You may use quotes to specify string literals as attributes:
  ```js
  const element = <div tabIndex="0"></div>;
  ```
  You may also use curly braces to embed a JavaScript expression in an attribute:
  ```js
  const element = <img src={user.avatarUrl}></img>;
  ```
  Don’t put quotes around curly braces when embedding a JavaScript expression in an attribute. You should either use quotes (for string values) or curly braces (for expressions), but not both in the same attribute.
  
- SX tags may contain children:
  ```js
  const element = (
    <div>
      <h1>Hello!</h1>
      <h2>Good to see you here.</h2>
    </div>
  );
  ```
  
> Note: Since JSX is closer to JavaScript than to HTML, React DOM uses `camelCase` property naming convention instead of HTML     attribute names. For example, `class` becomes `className` in JSX, and `tabindex` becomes `tabIndex`.
  
<br>
<br>
<br>
<br>

# Rendering Elements

- Elements are the smallest building blocks of React apps. An element describes what you want to see on the screen:
  ```js
  const element = <h1>Hello, world</h1>;
  ```
  Unlike browser DOM elements, React elements are plain objects, and are cheap to create. React DOM takes care of updating the DOM to match the React elements.
  
  Note: One might confuse elements with a more widely known concept of “components”. We will introduce components in the next section. Elements are what components are “made of”, 
  
### Rendering and Element into the DOM

- Let’s say there is a <div> somewhere in your HTML file:
  ```js
  <div id="root"></div>
  ```
  We call this a “root” DOM node because everything inside it will be managed by React DOM. Applications built with just React usually have a single root DOM node. If you are integrating React into an existing app, you may have as many isolated root DOM nodes as you like.
  
- To render a React element into a root DOM node, pass both to `ReactDOM.render()`:
  ```js
  const element = <h1>Hello, world</h1>;
  ReactDOM.render(element, document.getElementById('root'));
  ```
  
- React elements are `immutable`. Once you create an element, you can’t change its children or attributes. An element is like a single frame in a movie: it represents the UI at a certain point in time. With our knowledge so far, the only way to update the UI is to create a new element, and pass it to ReactDOM.render().

  Note: In practice, most React apps only call ReactDOM.render() once. In the next sections we will learn how such code gets encapsulated into stateful components.
  
<br>
<br>
<br>
<br>

# Components and Props

- Components let you split the UI into independent, reusable pieces, and think about each piece in isolation. This page provides an introduction to the idea of components. You can find a detailed component [API reference here](https://reactjs.org/docs/react-component.html).
  
  Conceptually, components are like JavaScript functions. They accept arbitrary inputs (called “props”) and return React elements describing what should appear on the screen.
  
- The simplest way to define a component is to write a JavaScript function:
  ```js
  function Welcome(props) {
    return <h1>Hello, {props.name}</h1>;
  }
  ```
  This function is a valid React component because it accepts a single “props” (which stands for properties) object argument with data and returns a React element. We call such components “function components” because they are literally JavaScript functions.

- Elements can also represent user-defined components. Lets use the function component we defined above in our code:
  ```js
  const element = <Welcome name="Sara" />;
  ```
  
- You can also write components with ES6 Classes:
  ```js
  class Welcome extends React.Component {
    render() {
      return <h1>Hello, {this.props.name}</h1>;
    }
  }
  ```
  The good rule of thumb is if you have a stateless simple reusable small chunk use `functional components` if you have much logic like states, control statements etc. use `class componoents`.

### Composing Components

- Components can refer to other components in their output. This lets us use the same component abstraction for any level of detail. A button, a form, a dialog, a screen: in React apps, all those are commonly expressed as components.

  For example, we can create an `form` component that renders `input` many times:
  ```js
  function Input(type) {
    return <input ...>;
  }

  function Form() {
    return (
      <div>
        <Input type="..." />
        <Input type="..." />
        <Input type="..." />
      </div>
    );
  }
  
  function App() {
    return <Form />
  }
  
  ReactDOM.render(
    <App />,
    document.getElementById('root')
  );
  ```
  Typically, new React apps have a single `App` component at the very top. However, if you integrate React into an existing app, you might start bottom-up with a small component like `Button` and gradually work your way to the top of the view hierarchy.
 
### Props are Read-Only

- Whether you declare a component as a function or a class, it must never modify its own props. Consider this sum function:
  ```js
  function sum(a, b) {
    return a + b;
  }
  ```
  Such functions are called `“pure”` because they do not attempt to change their inputs, and always return the same result for the same inputs
  
  In contrast, this function is impure because it changes its own input:
  ```js
  function withdraw(account, amount) {
    account.total -= amount;
  }
  ```
  React is pretty flexible but it has a single strict rule:

  **All React components must act like pure functions with respect to their props.**
  
<br>
<br>
<br>
<br>

# State and Lifecycle

- I HAVENT UNDERSTOOD THIS SECTION QUITE CLEARLY READ AGAIN [TUTORIAL](https://reactjs.org/docs/state-and-lifecycle.html) OR FIND A BETTER DOCUMENT

- Here is a good explanation from stackoverflow:
  > Before someone upvoted your question, you can imagine your question or think it as question component had `vote state = 0`    and after that it became 1 and so on. So interactivity with the application changed something in the application. That        changed something/ value can be called state.
  > State in application/ component can change due to interactivity(event) or during time.
  > As time you can imagine this Post or `Post Component` before 30 minutes/ some time ago had no answer i.e `answer state =      0`. And now it has some (3) answers. So answer `state = 0` changed to `answer state = 3`.
  
- Note: I need to revisit states and lifecycles

<br>
<br>
<br>
<br>

# Handling Events

- Handling events with React elements is very similar to handling events on DOM elements. There are some syntactic differences:
  - React events are named using camelCase, rather than lowercase
  - With JSX you pass a function as the event handler, rather than a string.
  
- For example, the HTML:
  ```html
  <button onclick="activateLasers()">
    Activate Lasers
  </button>
  ```
  is slightly different in React:
  ```js
  <button onClick={activateLasers}>
    Activate Lasers
  </button>
  ```
  
- I DID NOT FULLY UNDERSTAND THIS PART ON THE DOCUMENTATION I WILL NEED TO RESTUDY THIS FROM A DIFFERENT RESOURCE

<br>
<br>
<br>
<br>

# Conditional Rendering
  
- In React, you can create distinct components that encapsulate behavior you need. Then, you can render only some of them, depending on the state of your application.

  Conditional rendering in React works the same way conditions work in JavaScript. Use JavaScript operators like `if` or the conditional operator to create elements representing the current state, and let React update the UI to match them

- Consider these two components:
  ```js
  function UserGreeting(props) {
    return <h1>Welcome back!</h1>;
  }

  function GuestGreeting(props) {
    return <h1>Please sign up.</h1>;
  }
  ```
  We’ll create a `Greeting` component that displays either of these components depending on whether a user is logged in:
  ```js
  unction Greeting(props) {
  const isLoggedIn = props.isLoggedIn;
  if (isLoggedIn) {
      return <UserGreeting />;
    }
    return <GuestGreeting />;
  }

  ReactDOM.render(
    // Try changing to isLoggedIn={true}:
    <Greeting isLoggedIn={false} />,
    document.getElementById('root')
  );
  ```
  
- You can write all sorts of control statements inside React. Here is another example of inline `condition ? true : false.`:
  ```js
  render() {
    const isLoggedIn = this.state.isLoggedIn;
    return (
      <div>
        The user is <b>{isLoggedIn ? 'currently' : 'not'}</b> logged in.
      </div>
    );
  }
  ```
  
<br>
<br>
<br>
<br>

# List and Keys

- You can build collections of elements and include them in JSX using curly braces `{}`

  Below, we loop through the `numbers` array using the JavaScript `map()` function. We return a `<li>` element for each item. Finally, we assign the resulting array of elements to `listItems`:
  ```js
  const numbers = [1, 2, 3, 4, 5];
  const listItems = numbers.map((number) =>
    <li>{number}</li>
  );
  ```
  We include the entire `listItems` array inside a `<ul>` element, and render it to the DOM:
  ```js
  ReactDOM.render(
    <ul>{listItems}</ul>,
    document.getElementById('root')
  );
  ```
  
- A with everything in react we usually should write Lists in Components but there is a catch in react if you want to use lists in components you would need to assign `key`s to it.  A “key” is a special string attribute you need to include when creating lists of elements. 

  Let’s assign a key to our list items inside numbers.map() and fix the missing key issue.
  ```js
  
  ```


  
  
  
  
