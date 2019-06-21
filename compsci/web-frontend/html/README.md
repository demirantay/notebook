# HTML

- This note file is just a oversimplified summary of the most used html tags. For more info visit the documentation: https://www.w3schools.com/html/

- HTML stands for Hyper Text Markup Language, which is the most widely used language on Web to develop web pages. HTML was created by Berners-Lee in late 1991 but "HTML 2.0" was the first standard HTML specification which was published in 1995. 

- In its simplest form, following is an example of an HTML document −
  ```html
  <!DOCTYPE html>
  <html>

     <head>
        <title>This is document title</title>
     </head>

     <body>
        <h1>This is a heading</h1>
        <p>Document content goes here.....</p>
     </body>

  </html>
  ```

- As told earlier, HTML is a markup language and makes use of various tags to format the content. These tags are enclosed within angle braces `<Tag Name>`. Except few tags, most of the tags have their corresponding closing tags. For example, `<html> ` has its closing tag `</html>` and `<body>` tag has its closing tag `</body>` tag etc.
  
  To learn HTML, you will need to study various tags and understand how they behave, while formatting a textual document.
  
- The `<!DOCTYPE>` declaration tag is used by the web browser to understand the version of the HTML used in the document. Current version of HTML is 5 and it makes use of the following declaration −

<br>
<br>
<br>

# Tags, Attributes Summary 

- Since HTML tags and their attributes are a huge topic and wwould not fit intoa single file I will write a basic overviewed summary of it.

- Lets give a list of the most commonly used html tags:
  - `<h1>` - This is a header tag which makes the text big and bold, you can give h1, h2, ... h6 for giving the preference for your headers in your file
  - `<p>` - this is a paragraph text that states that the text between these tags are normal paragraph text
  - `<br/>` - This tag creates a linebreak inside paragraphs or any other text tag
  - `<hr/>` - This tag creates a horizontal line. 
  - `<pre>` - Will let your text to follow the exact format of how it is written in the HTML document
  - `<i>` - Makes the text italic
  - `<u>` - Makes the text underlined
  - `<b>` - Makes the code bold
  - `<code>` - Lets you enter programming code inside an html file. Like in markdown language
  - `<img>` - Lets you embed an image into your file
  - `<table>` - Lets you create a table inside your file
  - `<ul>` - Creates an unordered list
  
- You can also add attributes and names to your tags such as this:
  ```html
  <p id="foo" style="color:red;"> Hello World </p>
  ```
  As you can see above we have given the `p` a new `id` (name) and a new `attribute` (color:red). You will learn more about why we use these in the CSS and styling section I do not want to lose space in this part.
  
- You can write comments in html like this:
  ```html
  <!-- This is a comment that wont be seen on the page -->
  ```
  
---

- There are a lot more for to learn. Please visit the official documentation. This note is just a very basic summary.
  
<br>
<br>
<br>

# Links, Embedding Summary

### Links

- A webpage can contain various links that take you directly to other pages and even specific parts of a given page. These links are known as hyperlinks.

- You can simply link your pages with the tag `a` lets see it in action:
  ```html
  <a href="www.google.com"> Link to Google </a>
  ```
  You can also add a `target` attribute to your links to give more functionality:
  ```html
  <a href="..." target="_blank"> ... </a>
  ```
  For example this target: Opens the linked document in a new window or tab. There are many more targets and functionality for your links view the official documentation.
  
  You can put nearly everything inside links, you can put images, paragraphs, buttons, headers ... you name it!

### Embedding

- Embedding multimedia to your file sucj as videos, songs ... etc. are done in the same way we put images into the file. but instead of a `<img>` tag you use `<embed>` tag:
  ```html
  <embed src="path to your multimedia" width= ...> ... </embed>
  ```

- As I said before Links and Embedding are a huge topic this isnt even a summary. Check the official documentation.

<br>
<br>
<br>

# Layout 

- All the HTML elements can be categorized into two categories (a) Block Level Elements (b)Inline Elements.

### Block Elements

- Block elements appear on the screen as if they have a line break before and after them. For example, the `<p>`, `<h1>`, `<h2>`, `<h3>`, `<h4>`, `<h5>`, `<h6>`, `<ul>`, `<ol>`, `<dl>`, `<pre>`, `<hr />`, `<blockquote>`, and `<address>` elements are all block level elements. They all start on their own new line, and anything that follows them appears on its own new line.

### Inline Elements

- Inline elements, on the other hand, can appear within sentences and do not have to appear on a new line of their own. The `<b>`, `<i>`, `<u>`, `<em>`, `<strong>`, `<sup>`, `<sub>`, `<big>`, `<small>`, `<li>`, `<ins>`, `<del>`, `<code>`, `<cite>`, `<dfn>`, `<kbd>`, and `<var>` elements are all inline elements.

### Grouping HTML Elements

- There are two important tags which we use very frequently to group various other HTML tags (i) `<div>` tag and (ii) `<span>` tag

- These two let us divide and conquer each seperate part on their own these are one of the most important pieces of tags because these make it so much eaiser to work with html while using css. They are very important while desinging  a layout. I am not going to note the logic behind it since I already know it but if you want to check it out go research it in the official documentation.

<br>
<br>
<br>

# Forms

- There are lots of things to learn with forms I am not even going to try to note down a oversmiplified summary version. Just go with these links:
  - Official Doc: https://www.w3schools.com/html/html_forms.asp
  - Tutorials Point: https://www.tutorialspoint.com/html/html_forms.htm

<br>
<br>
<br>

# Headers and Metadata

- Well the body of a html document gets the visible parts of the document such as texts, paragraphs, images, multimedia, links and such. However the part we do not see and the part that contains the under-hood commands is the `header` section

- First lets start with the `title`:
  ```html
  <title>This is a title </title>
  ```
  This lets you change the title of the html document. In most of the browsers you can see the title on the tab at top.

### `<meta>` Tag

- The HTML <meta> tag is used to provide metadata about the HTML document which includes information about page expiry, page author, list of keywords, page description etc.
































