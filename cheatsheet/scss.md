# Scss Cheatsheet

> This is just a basic cheatsheet, there are much more ...

### Setup

- `apt-get sass` -- Install on Linux (ubuntu)
- `sudo gem install sass` -- Install on OS X

### CLI Usage

- `sass -v` -- Version info
- `sass input.scss output.css` -- Compile
- `sass --watch input.scss:output.css` -- Auto-Compile for single files
- `sass --watch .` -- Auto-Compile for folders

### Variables

- Declaring and accessing variables:
  ```scss
  $product_dark_blue: #324e85;
  
  .element {
    color: $product_dark_blue;
  }
  ```

### Nesting

- SCSS allows you to nest CSS rules:
  ```scss
  // vanilla CSS
  .container {}
  .container h1 {}
  .container p {}
    
  // Sass
  .container {
    width: 100px;
    
    h1 {
      color: red;
    }
    
    p {
      color: blue;
    }
  }
  ```

### Inheritance 

- `@extends` helps you inherit the properties of another class:
  ```scss
  .header {
    color: grey;
  }

  .sub-header {
    @extend .header;
    font-size: 40px;
  }
  ```
  
- Mixin is another way SCSS implement inheritance using `@mixin`
  ```scss
  @mixin grey-color{
    color: grey;
  }

  .header{
    @include grey-color;  /* add mixin */
  }
  ```
  
- There is one thing though `@mixin` can do that `@extend` cannot, That is pass parameters and use it. @mixin can also take default values for the parameter:
  ```scss
  @mixin fontSize ($params: 10px){
    font-size: $params;
  }
  
  .header{
    @include fontSize(20px);
  }
  ```
 
### Imports

- SCSS allow you to import other SCSS stylesheet into a SCSS file using `@import`:
  ```scss
  @import “button.scss” /* or */ @import “button”
  ```

### Partials

- Partials are SCSS files you don’t what to be compiled to CSS but you want to import them(using `@import`) into another file. To create a partial you just need to add an underscore to the beginning of the file name `_font.scss`
  ```
  filename: _partialButtons.scss, _partialColors
  ```

### Operators

- Arithmetic operators like `+`, `-`, `/`, `*` :
  ```scss
  width: -100px + 15px * 25px;
  ```
  
  > Note that arithmetic operators only work when both values use the same unit i.e rem, em, px
  
  > They also support comparison operators like ==, !=, <, >, >=, <= and logical operators and, or, not.

### Color Functions

- Scss provides some function that can be used to manipulate colors. Some of them include:
  - `mix(blue, grey, 30%)` -- results 30% blue and 70% grey
  - `lighten(#ff0000, 30 )` -- results #ff9999
  - `darken(#ff0000, 30 )` -- results #660000

### Other Functions

- `str-length($string)`: This function returns the number of characters in a string.
- `percentage($number)`: This function converts number without unit to a percentage.
- `round($number)`: This function rounds a number to the nearest whole number.
- `min($number1, $number2, $number3, …..)`: this function returns the minimum value from a set of numbers.
- `random()`: This returns a random number and takes no arguments.
- `quote($string)`: This function adds quotes to a string.
- `unquote($string)`: This function removes quotes from a string.
- `to-lower-case($string)`: This function converts a string to lowercase.
- `to-upper-case($string)`: This function converts a string to uppercase.

### Loops

- We can use for loops in our css thanks again to Scss. 
  ```scss
  @for $x from 1 through 70 {
    .font-size-#{$x} {
      font-size: 0px + $x;
    }
  }
  ```
  So I can easily have a class of font-size-20 if I need that on an element.

### Conditionals

- Another awesome feature of scss is the ability to use If/else statements in css. 
  ```scss
  $bg: pink;
  $bg-mobile: red;

  p {
    @if $bg == pink {
      color: blue;
    } @else if $bg-mobile == red {
      color: green;
    } @else {
      color: grey;
    }
  }
  ```
