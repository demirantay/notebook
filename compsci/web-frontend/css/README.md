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

- Color styles are either written with `keywords: red` or `hex: #RRGGBB` or `rgba: rgb(0,0,255)`














