## Browser environment, specs

- The JavaScript language was initially created for web browsers. Since then it has evolved and become a language with many uses and platforms.

  A platform may be a browser, or a web-server or another host, even a coffee machine. Each of them provides platform-specific functionality. The JavaScript specification calls that a host environment.
  
  A host environment provides own objects and functions additional to the language core. Web browsers give a means to control web pages. Node.js provides server-side features, and so on.

<br>
<br>

## DOM Tree

- Summary:
  - An HTML/XML document is represented inside the browser as the DOM tree.
  - Tags become element nodes and form the structure.
  - Text becomes text nodes.
  - …etc, everything in HTML has its place in DOM, even comments.

<br>
<Br>
  
# Walking the DOM

- Summary:
  - Given a DOM node, we can go to its immediate neighbors using navigation properties. There are two main sets of them:
  - For all nodes: `parentNode`, `childNodes`, `firstChild`, `lastChild`, `previousSibling`, `nextSibling`.
  - For element nodes only: `parentElement`, `children`, `firstElementChild`, `lastElementChild`, `previousElementSibling`, `nextElementSibling`.
  - Some types of DOM elements, e.g. tables, provide additional properties and collections to access their content.

<br>
<Br>
  
## Searching: getElement*, querySelector*

- There are 6 main methods to search for nodes in DOM:
  - 1 - `querySelector` -- searches by: CSS-selector	
  - 2 - `querySelectorAll` -- searches by: CSS-selector
  - 3 - `getElementById` -- searches by: `ID`
  - 4 - `getElementsByName` -- searches by: name
  - 5 - `getElementsByTagName` -- tag or '*'
  - 6 - `getElementsByClassName` -- class
  
  By far the most used are `querySelector` and `querySelectorAl`l, but `getElementBy*` can be sporadically helpful or found in the old scripts.

  Besides that:
  - There is `elem.matches(css`) to check if `elem` matches the given CSS selector.
  - There is `elem.closest(css)` to look for the nearest ancestor that matches the given CSS-selector. The `elem` itself is also checked.
  - `elemA.contains(elemB)` returns true if `elemB` is inside `elemA` (a descendant of `elemA`) or when `elemA==elemB`.
  
<br>
<br>

## Node Properties:type, tag, contents

- Each DOM node belongs to a certain class. The classes form a hierarchy. The full set of properties and methods come as the result of inheritance.

  Main DOM node properties are:
  - `nodeType` -- We can use it to see if a node is a text or an element node. It has a numeric value: `1` for elements,`3` for text nodes, and a few others for other node types. Read-only.
  - `nodeName/tagName` -- For elements, tag name (uppercased unless XML-mode). For non-element nodes `nodeName` describes what it is. Read-only.
  - `innerHTML` -- The HTML content of the element. Can be modified.
  - `outerHTML` -- The full HTML of the element. A write operation into elem.outerHTML does not touch elem itself. Instead it gets replaced with the new HTML in the outer context.
  - `nodeValue/data` -- The content of a non-element node (text, comment). These two are almost the same, usually we use data. Can be modified.
  - `textContent` -- The text inside the element: HTML minus all <tags>. Writing into it puts the text inside the element, with all special characters and tags treated exactly as text. Can safely insert user-generated text and protect from unwanted HTML insertions.
  - `hidden` -- When set to true, does the same as CSS display:none.
  
  > However, HTML attributes and DOM properties are not always the same, as we’ll see in the next chapter.

<br>
<br>

## Attributes and properties

- Attributes – is what’s written in HTML.
- Properties – is what’s in DOM objects.
- Methods to work with attributes are:
  - `elem.hasAttribute(name)` – to check for existence.
  - `elem.getAttribute(name)` – to get the value.
  - `elem.setAttribute(name, value)` – to set the value.
  - `elem.removeAttribute(name)` – to remove the attribute.
  - `elem.attributes` - is a collection of all attributes.
- For most situations using DOM properties is preferable. We should refer to attributes only when DOM properties do not suit us, when we need exactly attributes, for instance:
  - We need a non-standard attribute. But if it starts with `data-`, then we should use `dataset`.
  - We want to read the value “as written” in HTML. The value of the DOM property may be different, for instance the href property is always a full URL, and we may want to get the “original” value.

<br>
<br>

## Modifying the document

- Methods to create new nodes:
  - `document.createElement(tag)` – creates an element with the given tag,
  - `document.createTextNode(value)` – creates a text node (rarely used),
  - `elem.cloneNode(deep)` – clones the element, if deep==true then with all descendants.
  - `node.append(...nodes or strings)` – insert into node, at the end,
  - `node.prepend(...nodes or strings)` – insert into node, at the beginning,
  - `node.before(...nodes or strings` –- insert right before node,
  - `node.after(...nodes or strings)` –- insert right after node,
  - `node.replaceWith(...nodes or strings)` –- replace node.
  - `node.remove()` –- remove the node.
- Insertion and removal:
  -
- There are also “old school” methods:
  - `parent.appendChild(node)`
  - `parent.insertBefore(node, nextSibling)` 
  - `parent.removeChild(node)` 
  - `parent.replaceChild(newElem, node)` 
- Given some HTML in html, elem.insertAdjacentHTML(where, html) inserts it depending on the value of where:
  - `"beforebegin"` – insert html right before elem,
  - `"afterbegin"` – insert html into elem, at the beginning,
  - `"beforeend"` – insert html into elem, at the end,
  - `"afterend"` – insert html right after elem.
- To append HTML to the page before it has finished loading:
  - `document.write(html)`
  
<br>
<Br>
  
## Styles and classes

- To manage classes, there are two DOM properties:
  - `className` – the string value, good to manage the whole set of classes.
  - `classList` – the object with methods add/remove/toggle/contains, good for individual classes.
  
  To change the styles:
  - The `style` property is an object with camelCased styles. Reading and writing to it has the same meaning as modifying individual properties in the `"style"` attribute. To see how to apply `important` and other rare stuff – there’s a list of methods at MDN.
  - The `style.cssText` property corresponds to the whole "style" attribute, the full string of styles.
  - The `getComputedStyle(elem, [pseudo])` returns the style-like object with them. Read-only.

<br>
<br>

## Element size and scrolling

- Elements have the following geometry properties:
  - `offsetParent` – is the nearest positioned ancestor or td, th, table, body.
  - `offsetLeft/offsetTop` – coordinates relative to the upper-left edge of offsetParent.
  - `offsetWidth/offsetHeight` – “outer” width/height of an element including borders.
  - `clientLeft/clientTop` – the distances from the upper-left outer corner to the upper-left inner (content + padding) corner. For left-to-right OS they are always the widths of left/top borders. For right-to-left OS the vertical scrollbar is on the left so clientLeft includes its width too.
  - `clientWidth/clientHeight` – the width/height of the content including paddings, but without the scrollbar.
  - `scrollWidth/scrollHeight` – the width/height of the content, just like clientWidth/clientHeight, but also include scrolled-out, invisible part of the element.
  - `scrollLeft/scrollTop` – width/height of the scrolled out upper part of the element, starting from its upper-left corner.
<br>
<br>

## Window sizes and scrolling

- Geometry:
  - Width/height of the visible part of the document (content area width/height): `document.documentElement.clientWidth/Height`
  - Width/height of the whole document, with the scrolled out part:
    ```js
    let scrollHeight = Math.max(
      document.body.scrollHeight, document.documentElement.scrollHeight,
      document.body.offsetHeight, document.documentElement.offsetHeight,
      document.body.clientHeight, document.documentElement.clientHeight
    );
    ```
- Scrolling:
  - Read the current scroll: `window.pageYOffset/pageXOffset`.
  - Change the current scroll:
    - `window.scrollTo(pageX,pageY)` – absolute coordinates,
    - `window.scrollBy(x,y)` – scroll relative the current place,
    - `elem.scrollIntoView(top)` – scroll to make elem visible (align with the top/bottom of the window).

<br>
<br>

## Coordinates

- Any point on the page has coordinates:
  - Relative to the window – `elem.getBoundingClientRect()`.
  - Relative to the document – `elem.getBoundingClientRect()` plus the current page scroll.
  
  Window coordinates are great to use with position:fixed, and document coordinates do well with position:absolute.
  
  Both coordinate systems have their pros and cons; there are times we need one or the other one, just like CSS position absolute and fixed.
