# HTML Cheatsheet

### Main Root

- `<html> … </html>` --  The HTML <html> element represents the root (top-level element) of an HTML document, so it
is also referred to as the root element
- `<!-- -->` -- Defines a comment
- `<!DOCTYPE>` -- Defines the document type

### Document Metadata

- `<head> … </head>` -- The HTML <head> element contains machine-readable information (metadata) about the
document
- `<link>` -- The HTML External Resource Link element (<link>) specifies relationships between the current
document and an external resource
- `<meta>` -- The HTML <meta> element represents metadata that cannot be represented by other HTML
meta-related elements
- `<style> … </style>` -- The HTML <style> element contains style information for a document, or part of a document
- `<title> … </title>` -- The HTML Title element (<title>) defines the document's title that is shown in a browser's title

### Sectioning Root

- `<body> … </body>` -- The HTML <body> Element represents the content of an HTML document. There can be only one <body> element in a document.

### Content Sectioning

- `<address> … </address>` -- element indicates that the enclosed HTML provides contact information for a person or people
- `<article> … </article>` -- represents a self-contained composition in a document, page, application, or site, which is intended to be independently distributable or reusable 
- `<aside> … </aside>` -- t represents a portion of a document whose content is only indirectly
related to the document's main content.
- `<footer> … </footer>` -- t represents a footer for its nearest sectioning content or sectioning
root element. A footer typically contains information about the author of the section, copyright
data or links to related documents
- `<header> … </header>` -- t represents introductory content, typically a group of introductory
or navigational aids. It may contain some heading elements but also a logo, a search form, an
author name, and other elements
- `<h1> to <h6> … </h6>` -- elements represent six levels of section headings. `<h1>` is the highest
section level and `<h6>` is the lowest.
- `<main> … </main>` -- element represents the dominant content of the <body> of a document. The
main content area consists of content that is directly related to or expands upon the central
topic of a document, or the central functionality of an application.
- `<nav> … </nav>` --  purpose is to provide navigation links, either within the current document or to other documents
- `<section> … </section>` --  represents a standalone section — which doesn't have a more
specific semantic element to represent it

### Text Content

- `<blockquote> … </blockquote>` -- indicates that the enclosed text is an extended quotatio
- `<dd> … </dd>` -- element provides the description, definition, or value for the preceding term.
- `<div> … </div>` -- is the generic container for flow content. It has no
effect on the content or layout until styled using CSS.
- `<dl> … </dl>` -- element represents a description list
- `<dt> … </dt>` -- element specifies a term in a description or definition list, and as such must be
used inside a `<dl>` element
- `<figcaption> … </figcaption>` -- Figure Caption element represents a caption or legend describing
the rest of the contents of its parent -figure- element
- `<figure> … </figure>` -- element represents self-contained content,
potentially with an optional caption
- `<hr>` -- > element represents a thematic break between paragraph-level elements
- `<li> … </li>` -- element is used to represent an item in a list.
- `<ol> … </ol>` -- > element represents an ordered list of items, typically rendered as a numbered list
- `<ul> … </ul>` -- > element represents an unordered list of items, typically rendered as a bulleted
list
- `<p> … </p>` -- > element represents a paragraph.
- `<pre> … </pre>` -- element represents preformatted text which is to be presented exactly as
written in the HTML file


### Inline Text Scemantics

- `<a> … </a>` -- , with its href attribute, creates a hyperlink to web
pages, files, email addresses, locations in the same page, or anything else a URL can address.
- `<abbr> … </abbr>` -- represents an abbreviation or acronym; the optional
title attribute can provide an expansion or description for the abbreviation.
- `<br>` -- element produces a line break in text
- `<cite> … </cite>` --  is used to describe a reference to a cited creative work, and
must include the title of that work
- `<code> … </code>` -- > element displays its contents styled in a fashion intended to indicate that the
text is a short fragment of computer code.
- `<em> … </em>` -- > element marks text that has stress emphasis.
- `<mark> … </mark>` -- ) represents text which is marked or highlighted for
reference or notation purposes
- `<small> … </small>` -- > element represents side-comments and small print, like copyright and legal
text, independent of its styled presentation.
- `<span> … </span>` -- element is a generic inline container for phrasing content, which does not
inherently represent anything
- `<strong> … </strong>` -- indicates that its contents have strong
importance, seriousness, or urgency. Browsers typically render the contents in bold type
- `<time> … </time>` -- element represents a specific period in time

### Image and Multimedia

- `<audio> … </audio>` -- element is used to embed sound content in documents. It may contain one
or more audio sources, represented using the src attribute or the <source> element
- `<img>` -- element embeds an image into the document.
- `<track>` -- element is used as a child of the media elements <audio> and <video>. It
lets you specify timed text tracks (or time-based data),
- `<video> … </video>` -- embeds a media player which supports video playback into
the document. 

### Scripting 

- `<script> … </script>` -- > element is used to embed or reference executable code; this is typically
used to embed or refer to JavaScript code.

### Demarcating Edits 

- `<del> … </del>` -- > element represents a range of text that has been deleted from a document.
- `<ins> … </ins>` -- > element represents a range of text that has been added to a document.

### Table Content

- `<caption> … </caption>` -- specifies the caption (or title) of a table, and if
used is always the first child of a `<table>`.
- `<table> … </table>` -- element represents tabular data —
- `<tbody> … </tbody>` -- ) encapsulates a set of table rows
- `<td> … </td>` -- element defines a cell of a table that contains data. It participates in the table
model.
- `<tfoot> … </tfoot>` -- element defines a set of rows summarizing the columns of the table
- `<th> … </th>` -- element defines a cell as header of a group of table cells
- `<thead> … </thead>` -- element defines a set of rows defining the head of the columns of the table
- `<tr> … </tr>` -- element defines a row of cells in a table. The row's cells can then be established
using a mix of `<td>` (data cell) and `<th>` (header cell) elements.

### Forms

- `<button> … </button>` -- element represents a clickable button
- `<datalist> … </datalist>` -- element contains a set of `<option>` elements that represent the values
available for other controls.
- `<fieldset> … </fieldset>` -- > element is used to group several controls as well as labels (`<label>`)
within a web form.
- `<form> … </form>` -- element represents a document section that contains interactive controls for
submitting information to a web server
- `<input>` -- element is used to create interactive controls for web-based forms in order
to accept data from the user; a wide variety of types of input data and control widgets are
available, depending on the device and user agent
- `<label> … </label>` -- element represents a caption for an item in a user interface
- `<legend> … </legend>` -- element represents a caption for the content of its parent `<fieldset>`.
- `<optgroup> … </optgroup>` -- > element creates a grouping of options within a `<select>` element.
- `<option> … </option>` -- element is used to define an item contained in a `<select>`, an `<optgroup>`,
or a `<datalist>` element.
- `<progress> … </progress>` -- > element displays an indicator showing the completion progress of a
task, typically displayed as a progress bar
- `<select> … </select>` -- element represents a control that provides a menu of options
- `<textarea> … </textarea>` -- element represents a multi-line plain-text editing control, useful when
you want to allow users to enter a sizeable amount of free-form text, for example a comment
on a review or feedback form.

### Interactive Elements 

- `<details> … </details>` -- creates a disclosure widget in which information is
visible only when the widget is toggled into an "open" state.
- `<summary> … </summary>` -- element specifies a summary, caption, or
legend for a <details> element's disclosure box.
