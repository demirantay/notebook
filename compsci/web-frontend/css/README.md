# CSS

- I already know most of the CSS so I am not going to note down every bit of detail like I usually do. If you want more information check out the docs: https://www.w3schools.com/css/css_intro.asp 

- CSS is used to control the style of a web document in a simple and easy way.CSS is the acronym for "Cascading Style Sheet". CSS handles the look and feel part of a web page. Using CSS, you can control the color of the text, the style of fonts, the spacing between paragraphs, how columns are sized and laid out, what background images or colors are used, layout designs,variations in display for different devices and screen sizes as well as a variety of other effects.

- You can write a basic css code for an html element like this:
  ```css
  h1 {
    color: red;
  }
  ```
  You can get all of the elementss with : `* {...}` asteristk instead of an html tag
  
- Suppose you want to apply a style rule to a particular element only when it lies inside a particular element. You can do this:
  ```css
  ul li {
    color: red;
  }
  ```

- Instead of typing every html tag in your style file, you can define a `class` or an `id` that can be modified once and used on whatever html tag you want:
  ```css
  .className {
    color: red;
  }
  
  #idName {
    color: yellow;
  }
  ```
  classes start with `.` and Id's start with `#`. Ids should represent sepficic objects while classes are for "one time styling and many time using"
  
- You can apply a style to many selectors if you like. Just separate the selectors with a comma, as given in the following example −
  ```css
  h1, h2, h3 {
   color: #36C;
   font-weight: normal;
  }
  ```
  
- As we talked erlier you can either write your css inside the `<element style="...">` attributes or inside the tags `<style></style>` or as like every other sensible developer outthere you use the `<link>` to link your html document to style sheets

<br>
<br>
<br>

# CSS Measurement Units

- These are the following measurment units in css with their example usage:
  - `%` - div { height: 100% }
  - `cm` - div {margin-bottom: 2cm }
  - `em` - div {height: 10em}
  - `ex` - p {line-height: 3ex}
  - `in` - div {height: 10in}
  - `mm` - div{ height: 10mm}
  - `pc` - p {font-size: 5pc}
  - `px` - p {font-size 15px}
  
<br>
<br>
<br>

# Quick Notes for CSS

### Colors

- Color styles are either written with `keywords: red` or `hex: #RRGGBB` or `rgba: rgb(0,0,255)`

### Backgrounds

- For most of the html elements you can set up background properties:
  - `background-color` -  property is used to set the background color of an element.
  - `background-image` -  property is used to set the background image of an element.
  - `background-repeat` -  property is used to control the repetition of an image in the background.
  - `background-position` -  property is used to control the position of an image in the background.
  - `background-attachment` -  property is used to control the scrolling of an image in the background.
  - `background` -  property is used as a shorthand to specify a number of other background properties.

### Fonts

- Lets view how to set `font` for html elements in css:
  - `font-family` -  property is used to change the face of a font
  - `font-style` -  property is used to make a font italic or oblique.
  - `font-variant` -  property is used to create a small-caps effect.
  - `font-weight` -  property is used to increase or decrease how bold or light a font appears.
  - `font-size` -  property is used to increase or decrease the size of a font.
  - `font` -  property is used as shorthand to specify a number of other font properties.
    ```css
    #foo {
      font-family: serif;
      font-style: italic;
      font-variant: small-caps;
      font-weight: 500;
      font-size: 15px;
      font: seif italic small-caps 500 15px;
    }
    ```
    
### Texts
    
- Lets view how to set `text` styles for html elements in css:
  - `color` -  property is used to set the color of a text.
  - `direction` - property is used to set the text direction
  - `letter-spacing` - property is used to add or subtract space between the letters that make up a word.
  - `word-spacing` - property is used to add or subtract space between the words of a sentence.
  - `text-indent` - property is used to indent the text of a paragraph.
  - `text-align` property is used to align the text of a document.
  - `text-decoration` - property is used to underline, overline, and strikethrough text.
  - `text-transform` -  property is used to capitalize text or convert text to uppercase or lowercase letters.
  - `white-space` - property is used to control the flow and formatting of text.
  - `text-shadow` - property is used to set the text shadow around a text.
    ```css
    #foo {
      color: red;
      direction: rtl;
      letter-spacing: 5px;
      word-spacing: 5px;
      text-indent: 5px;
      text-align: center;
      text-decoration: none;
      text-transform: uppercase;
    }
    ```
    
### Images

- Lets view how to set `img` styles for html elements in css:
  - `border` -  property is used to set the width of an image border
  - `height` - property is used to set the height of an image
  - `width` -  property is used to set the width of an image.
    ```css
    #img-id {
      border: 1px solid black;
      height: 100px;
      width: 100px;
    }
    ```
  
### Links

- Lets view how to set `link` styles for html elements in css:
  - `:link` - signifies unvisited hyperlinks.
  - `:visited` - signifies visited hyperlinks.
  - `:hover` - signifies an element that currently has the user's mouse pointer hovering over it.
  - `:active` - signifies an element on which the user is currently clicking.
  ```css
  #link-id:visited {
    color: red;
  }
  
  #link-id:hover {
    color: orange;
  }
  
  #link:active {
    color:green;
  }
  ```
  
- I am skipping `tables` for notetaking since I do not use them so oftenly. If I need it I can just fire up the documetnation

### Borders

- Lets view how to set `border` styles for html elements in css:
  - `border-color` - specifies the color of a borde
  - `border-style` - specifies whether a border should be solid, dashed line, double line, or one of the other possible values.
  - `border-width` - specifies the width of a border.
  ```css
  #element {
    border: 1px solid black;
    border-color: red;
    border-style: solid;
    border-width: 1px;
  }
  ```
  
### Margins
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  

