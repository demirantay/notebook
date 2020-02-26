# CSS Cheatsheet

### Element selectors

- `h2 { ... }` -- selects all h2 elements on the page
- `h1, h2, h3 { ... }` -- selects all h1, h2 and h3 elements on the page

### Class and ID selectors

- `.foo { }` -- gets the class of an html element
- `#foo { }` -- selects the element with 'baz' id attribute value

### Contextual selectors

- `#foo p {...}` -- selects all __p__ elements within the infinite-level hierarchy of element #foo descendants
- `h2 + p {...}` -- selects the sibling element p that is immediately next to h2 element
- `#foo > p {...}` -- selects all p elements that are immediate children of #foo element
- `h2 ~ p {...}` -- selects all elements p that are siblings to the h2 element

### Pseudo-class selectors

- `a:link {...}` -- applies to link elements that have not been visited
- `a:visited {...}` -- applies to link elements that have been visited
- `.foo:focus {...}` -- applies to selected .foo element that is ready for input
- `.foo:hover {...}` -- applies when mouse pointer is over the .foo element
- `.foo:active {...}` -- applies when .foo element is in process of being clicked

### Pseudo-class selectors that apply to siblings

- `.foo:first-child {...}` -- selects the specified .foo element when it is the first child of its parent
- `.foo:last-child {...}` -- selects the specified .foo element when it is the last child of its parent
- `.foo:only-child {...}` -- selects the specified .foo element when it is the only child of its parent
- `h2:first-of-type {...}` -- elects the h2 element when it is the first element of its type within its parent element
- `h2:last-of-type {...}` -- selects the h2 element when it is the last element of its type within its parent element
- `h2:only-of-type {...}` -- selects the h2 element when it is the only element of its type within its parent element
- `.foo:nth-child(n) {...}` -- selects the nth .foo child element
- `.foo:nth-last-child(n) {...}` -- selects the nth .foo child element counting backwards
- `h2:nth-of-type(n) {...}` -- selects the nth h2 child element of its type
- `h2:nth-last-of-type(n) {..}` -- selects the nth h2 child element of its type counting backwards

### Pseudo-element selectors

- `.foo::first-letter {..}` -- First letter -- selects the first letter of the specified .foo element, commonly used with :first-child to target first paragraph
- `.foo::first-line {..}` -- First line -- selects the first line of the specified .foo element, commonly used with :first-child to target first paragraph
- `.foo::before {..}` -- adds generated content before the .foo element when used with content property
- `.foo::after {..}` -- adds generated content after the .foo element when used with content property

### Attribute selectors

- `.foo[bar] {..}` -- selects .foo elements with bar attribute present, regardless of its value
- `.foo[bar="fum"] {..}` -- selects .foo elements where the bar attribute has the exact value of fum
- `.foo[bar~="fum"] {..}` -- Whitespace separated -- selects .foo elements with bar attribute values contain specified partial value of fum (whitespace separated)
- `.foo[bar|="fum"] {..}` -- Hyphen separated -- selects .foo elements with bar attribute values contain specified partial value of fum immediately followed by hyphen (-) character
- `.foo[bar^="fum"] {..}` -- selects .foo elements where the bar attribute begins with fum
- `.foo[bar$="fum"] {..}` -- selects .foo elements where the bar attribute ends with fum
- `.foo[bar*="fum"] {..}` -- Containts -- selects .foo elements where the bar attribute contains string fum followed and preceded by any number of other characters

### Misc selectors

- `.foo:not(.bar) {..}` -- selects .foo elements that are NOT .bar elements
- `:root {..}` --  selects the highest level parent element in the DOM
- `.foo:empty {..}` -- selects .foo elements that have no children or whitespace inside
- `.foo:in-range {..}` -- selects .foo elements that have values in or out of range
- `.foo:out-of-range {..}` -- selects .foo elements that have values in or out of range

> Credit: https://gist.github.com/magicznyleszek/809a69dd05e1d5f12d01
