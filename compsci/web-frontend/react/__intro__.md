# React.js

## Installation

- You can install react with lots of toolchains however if you are just starting out as a react developer you may not need that fanciness and you can easily add react as a plain <script> text like this:
  ```html
  
  ```
  And you can download them with CDNs
  ```html
  
  ```
  
- Or you can use the following toolchain to add react-app to your web app:
  ```
  $ npx create react-app app-name
  $ cd app-name
  $ npm start
  ```
  Note that npx is not a typo it is a package runner tool that comes with npm
  
## Intorduction to JSX
  
- Consider this varialbe declaration:
  ```js
  const element = <h1>Hello World</h1>;
  ```
  This sytax is neither html or javascript string. This is called the `JSX`. It is reccomended to be used with react to describe what the UI should look like. JSX is not a template langauge it comes with the full power of javascript. Remember JSX is not a necessary towork with React but it makes it so easy for developing UI why shouldnt you use it.
  
  You can also embed different javascript variables into your html markup in the jsx like the following:
  ```js
  const name = 'john';
  const element = <h1>Hi {name}</h1>;
  ```
  You can put any valid javascript expression into curly bracekts and embed them into your html elements use ifs, for loops and all kind of things:
  ```js
  const element = <img src={user.avatarUrl}></img>
  
  // or your element can contain children 
  
  const element = (
  <div>
    <h1>Hello!</h1>
    <h2>Good to see you here.</h2>
  </div>
  );
  ```
  while writing JSX it is neither javascript nor html so you have to use its own syntax with its html/js/markup code dont worry it is not that comlicated you just tweak things here and there. For example you have to put camelcCased letters for attributes and put `Name` as a suffix (after) the attribute, see the following code:
  ```js
  const element = <h1 className="foo">lorem ipsum</h1>;
  ```
 
 - JSX represents react objects so this fancy word means to these two snippets are actually the same:
   ```js
   // jsx version
   const element = (
      <h1 className='foo'>Hello world</h1>
   );
   ```
   is as same as:
   ```js
   // react without jsx
   const element = React.createElement(
    'h1',
    {className: 'foo'},
    'Hello World',
   );
   ```
   Now do you see why using jsx is way much more simpler to use and visualize in your head what the UI is gonna look like!
   
 ## Rendering Elements
 
 - Elements are the smallest building blocks of React Apps. Dont worry React DOM handles the connection between the broswer DOM API. Do not confuse the `elements` with `compnonents` they are different things, components are made up of elements.
 
- To simply render a react elemenet you can do the following lets say you have a div element that has a id of foo
  ```html
  <div id='foo'></div> 
  ```
  and it is empty becase react will render its content from jsx code but in order to fill the element we need to use reacts `.redner()` function:
  ```js
  const element = <h1>Hello World</h1>
  ReactDOM.render(element, document.getElementById('foo');
  ```
  
  
 
  
