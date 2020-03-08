# Manipulating documents

> There is no need to note everything i see here, I will create a cheatsheet for myself for the DOM API

- When writing web pages and apps, one of the most common things you'll want to do is manipulate the document structure in some way. This is usually done by using the Document Object Model (DOM), a set of APIs for controlling HTML and styling information that makes heavy use of the `Document` object.

<br>
<br>

# The important parts of a web browser

- Web browsers are very complicated pieces of software with a lot of moving parts, many of which can't be controlled or manipulated by a web developer using JavaScript. You might think that such limitations are a bad thing, but browsers are locked down for good reasons, mostly centering around security. Imagine if a web site could get access to your stored passwords or other sensitive information, and log into websites as if it were you?

  Despite the limitations, Web APIs still give us access to a lot of functionality, There are a few really obvious bits (APIs) you'll reference regularly in your code:
    - `Window` -- The window is the browser tab that a web page is loaded into; this is represented in JavaScript by the `Window` object. 
    - `Navigator` -- The navigator represents the state and identity of the browser (i.e. the user-agent) as it exists on the web. In JavaScript, this is represented by the `Navigator` object.
    - `Document` -- The document (represented by the DOM in browsers) is the actual page loaded into the window, and is represented in JavaScript by the `Document` object.
a
<br>
<br>

---

<br>
<br>

# The document object model

- The document currently loaded in each one of your browser tabs is represented by a document object model. This is a "tree structure" representation created by the browser that enables the HTML structure to be easily accessed by programming languages — for example the browser itself uses it to apply styling and other information to the correct elements as it renders a page, and developers like you can manipulate the DOM with JavaScript after the page has been rendered.

  Each part (element) in the DOM tree is called a node and there are few termionoligies for you to familirize yourself with:
    - `element node` 
    - `root node` 
    - `child node`
    - `descendant node` 
    - `parent node` 
    - `sibling nodes` 
    - `text node`

<br>
<br>

---

<br>
<br>

# Active learning: Getting useful information from the Window object

<br>
<br>

---

<br>
<br>

# Active learning: A dynamic shopping list

