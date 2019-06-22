# Semantic HTML

- “Semantic HTML” refers to the idea that all your HTML markup should convey the underlying meaning of your content—not its appearance. We’ve already been writing semantic HTML (e.g., using `<strong>` instead of `<b>`), but there’s a whole set of elements designed for the sole purpose of adding more meaning to the overall layout of a web page.

- Using these as an alternative to `<div>` elements is an important aspect of modern web development because it makes it easier for search engines, screen readers, and other machines to identify the different parts of your website. It also helps you as a developer keep your site organized, which, in turn, makes it easier to maintain. Think of sectioning elements as `<div>`’s, but with meaning.

- Defining graphical styles with CSS is how we convey the structure of a web page to humans. By marking it up with `<header>`, `<article>`, `<figure>`, and other HTML sectioning elements, we’re able to represent those visual styles to machines, as well.

- Machine readers used to have to make sense of all the above `<div>`’s and more. The new semantic HTML elements we learned in this chapter are like standardized versions of these class names. Now, they can simply look for a `<header>` element. We can still add whatever class name we want to it for styling purposes, but search engines and screen readers now have a predictable way to identify headers across every HTML5 website on the Internet.

- The list of all semantic tags in HTML5:
  - `<article>` - Article
  - `<aside>` - Aside 
  - `<details>` - Details of the page
  - `<footer>`- Footer at the bottom
  - `<header>` - Header Banner section
  - `<nav>` - Navigation
  - `<section>` - For segregading content
  - `<abbr>` - Abbreviation
  - `<blockquote>` - Long quotation
  - `<dfn>` - Definition
  - `<address>` - Address for author(s) of the document
  - `<cite>` - Code reference
  - `<tt>` - Teletype text
  - `<div>` - Logical division
  - `<span>` - Generic inline style container
  - `<del>` - Deleted text
  - `<ins>` - inserted text
  - `<em>` - Emphasis
  - `<strong>` - Strong/bold emphasis
  - `<h1>` - `<h6>` - Leveled headlines
  - `<hr>` - Thematic break
  - `<kbd>` - Text to be entered by the user
  - `<pre>` - Pre-formatted text
  - `<q>` - Short inline quotation
  - `<samp>` - Sample output
  - `<sub>` - Subscript
  - `<sup>` - Superscript
  - `<var>` - Variable or user defined text
  
  ... There are many more tags for semantic html however for now these are enough for a basic html application. If you want to check out more visit the official documentation or other resources
  
  
