# DOM (Document Object Model)

- Every web page resides inside a browser window which can be considered as an object. A Document object represents the HTML document that is displayed in that window. The Document object has various properties that refer to other objects which allow access to and modification of document content.

- The way a document content is accessed and modified is called the `Document Object Model`, or `DOM`. The Objects are organized in a hierarchy. This hierarchical structure applies to the organization of objects in a Web document

- Lets see the hierarchy:
  - `Window object` - Top of the hierarchy. It is the outmost element of the object hierarchy.
  - `Document object` - Each HTML document that gets loaded into a window becomes a document object. The document contains the contents of the page.
  - `Form object` - Everything enclosed in the <form>...</form> tags sets the form object.
  - `Form control elements` - The form object contains all the elements defined for that object such as text fields, buttons, radio buttons, and checkboxes.
  
- There are several DOMs in existence:
  - The Leagcy DOM
  - The W3C DOM
  - The IE4 DOM
  
  However only one you have to worry about is W3C DOM since the others are old and even toguh they are supported the W3C is the standart for all modern browsers
  
### The W3C DOM

- This document object model allows access and modification of all document content and is standardized by the World Wide Web Consortium (W3C). This model is supported by almost all the modern browsers.

- Lets first see a little bit of tutorial and than after that we will get a full (commonly used) list of Document Properties and Methods:

<br>
<br>
<br>

# Tutorial 1: Accessing the DOM

### getElementById

- Finding a node on a page is the most fundamental task when working with the DOM from JavaScript. The most useful function is `document.getElementById('elementId')`. This function takes a string and returns the DOM element with that ID. Lets see our html element:
  ```html
  <h1 id="foo">This is a title</h1>
  ```
  Now lets change the inner content of the element with javascript:
  ```javscript
  document.getElementById("foo").innerHTML = "NEW INNER HTML";
 
  ```
  
### childNodes

- Sometimes the node you want to manipulate does not have an ID. This is particularly true of text nodes, which can't have IDs. But there may still be ways to find a node that doesn't have an ID. Each node has a `childNodes` property that contains an ordered array of all its children. One can index into this array. Lets see out html children:
  ```html
  <span id="foo">
    <h1> this is first </h1>
    <h1> this is second </h1>
  </span>
  ```
  Now lets manipulate the first element of the child array with javascript and change its innerHTML:
  ```javascript
  document.getElementById('foo').childNodes[0].innerHTML = "huehuehuehue";
  ```
  
### firstChild & lastChild

- There's a shortcut for finding the first and last child nodes, `firstChild` and `lastChild`. Lets see our html element first:
  ```html
  <span id="foo">
    <p>Helo</p>
    
    <span>
      <h1> change this </h1>
    <span>
  </span>
  ```
  Now in order to accsess with javascript and shortuts we can use this:
  ```javascript
  document.getElementById('foo').lastChild.firstChild.innerHTML = "hueheuheu";
  ```
  
### previousSibling & nextSibling

Nodes also have `previousSibling` and `nextSibling` properties that allow one to slide sideways on the DOM tree. Again lets see our html first:
  ```html
  <span>
    <h1> first </h1>
    <h1> second </h1>
    <h1 id="foo"> third </h1>
  <span>
  ```
  Now lets add our javascript code:
  ```javascript
  document.getElementById("foo").previousSibling.previousSibling.innerHTML = "huehuehue";
  ```
  
### parentNode

- You can also hop on to the `parentNode`. It is self explanatory lets see the html first:
  ```html
  <span>
    <h1 id='foo'> hello </h1>
  <span>
  ```
  the code below gets your the `span` element:
  ```
  document.getElementById('foo').parentNode;
  ```
	
--- 

- *Note: you can find the rest of the DOM manipulations like: `innerHTML` below of this note page. However keep in mind innerHTML is a very dangerous and not safe manipulation try to avoid it*
  
<br>
<br>
<br>

# Tutorial 2: DOM Evnets

- This tutorial will teach you how to handle events in the DOM from JavaScript, lets first see the traditional Model

### Traditional Model

The simplest way to make an element on a web page respond to an event is to set the element's `.onclick` property to a function. When the element is clicked, the function is executed
	```html
	<button id="foo">Execute</button>
	```
	We can find the button with getElementById an than use that give the id an event:
	```javascript
	document.getElementById('foo').onclick = function() {
		alert('hello');
	}
	```
	
### WC3 Event Model
  
  
  
  
  
  
  
  
  
  
  
  
  
  
