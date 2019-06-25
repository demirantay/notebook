# CSS 3

- This note file is just for summarized quick notes. It gives nowhere complete information. If you want a full documentation of css 3 look at the official docs: https://www.w3schools.com/css/

- Cascading Style Sheets (CSS) is a style sheet language used for describing the look and formatting of a document written in a markup language. CSS3 is a latest standard of css earlier versions(CSS2). The main difference between css2 and css3 is follows −
  - Media Queries
  - Namespaces
  - Selectors Level 3
  - Color
  
  Lets view new differneces in their own headers:
  
  <br>
  <br>
  <br>
  
  # Rounded Corners
  
  - CSS3 Rounded corners are used to add special colored corner to body or text by using the border-radius property.A simple syntax of rounded corners is as follows −
    ```css
    #element {
      border-radius: 10px;
    }
    ```
    You can specify the specific corner to be rounded via `border-top-right-radius` ... etc.
    
 <br>
 <br>
 <br>
 
 # Border Images 
 
 - CSS Border image property is used to add image border to some elements.you don't need to use any HTML code to call border image.A sample syntax of border image is as follows −
  ```css
  #element {
    border: 10px solid transaprent;
    border-image-source: foo.jpg
  }
  ```
  
- There are other important value properties for border-images such as:
    - `border-image-source` - Used to set the image path
    - `border-image-slice` - Used to slice the boarder image
    - `border-image-width` - Used to set the boarder image width
    - `border-image-repeat` - Used to set the boarder image as rounded, repeated and stretched
    
<br>
<br>
<br>

# Multi Background
    
- CSS Multi background property is used to add one or more images at a time without HTML code, We can add images as per our requirement.A sample syntax of multi background images is as follows 
  ```css
  #multibackground {
     background-image: url(/css/images/logo.png), url(/css/images/border.png);
     background-position: left top, left top;
     background-repeat: no-repeat, repeat;
     padding: 75px;
  }
  ```
  The most commonly used values are shown below:
    - `background` - Used to setting all the background image properties in one section
    - `background-clip` - Used to declare the painting area of the background
    - `background-image` - Used to specify the background image
    - `background-origin` - Used to specify position of the background images
    - `background-size` - Used to specify size of the background images
    
<br>
<br>
<br>

# Color

- CSS3 started supportinga additional color properties as follows:
  - RGBA colors
  - HSL colors
  - HSLA colors
  - Opacity
  ```css
  #d1 { color: rgba(255, 0, 0, 0.5) }
  #d2 { color: hsl(120, 100%, 50%) }
  #d3 { color: hsla(120, 100%, 50%, 0.3) }
  #d4 { opacity: 0.5 }
  ```
  
<br>
<br>
<br>
  
# Gradient

- Gradients displays the combination of two or more colors as shown below − Adding a gradient is easy. All gradients are read from a gradients.json file. Simply add your gradient details to it and submit a pull request.
  ```css
  #foo {
    background: -webkit-linear-gradient(pink,green);
    background: -o-linear-gradient(pink,green);
    background: -moz-linear-gradient(pink,green); 
    background: linear-gradient(pink,green); 
  }
  ```
  You can try different color combinations. Just use commonly used graident hex colors fromt the internet. Selecting colors just takes too much time with gradients.
  
<br>
<br>
<br>

# Shadow

- CSS3 supported to add shadow to text or elements.Shadow property has divided as follows −
  - Text Shadow
  - Box Shadow
  
### Text shadow

- CSS3 supported to add shadow effects to text. Following is the example to add shadow effects to text −
  ```css
  h1 {
    text-shadow: 2px 2px grey;
  }
  ```
  There are more to add on the values however since I do not use it very much I am skipping it you can check out the official documentation.
  
### Box Shadow

- Used to add shadow effects to elements, Following is the example to add shadow effects to elements:
  ```css
  div {
    width: 100px;
    height: 100px;
    box-shadow: 10px 10px;
  }
  ```
  As said above there much more you can do with the shadows and boxes. If you want more information visit the official documentation.

<br>
<br>
<br>

# Text

- CSS3 contained several extra features, which is added later on.
  - `text-overflow` - used to determines how overflowed content that is not displayed is signaled to users
  - `word-wrap` -  Used to break the line and wrap onto next line
  - `word-break` -  Used to break the line based on word
  
<br>
<br>
<br>

# 2D  Transforms

- 2D transforms are used to re-change the element structure as translate, rotate, scale, and skew.
  
  The following table has contained common values which are used in 2D transforms −
  - `matrix(n, n, n, n, n, n)` - Used to defines matrix transforms with six values
  - `translate(x, y)` - Used to transforms the element along with x-axis and y-axis
  - `translateX(n)` - Used to transforms the element along with x-axis
  - `translateY(n)` - Used to transforms the element along with y-axis
  - `scale(x,y)` - Used to change the width and height of element
  - `scaleX(n)` - Used to change the width of element
  - `scaleY(n)` - Used to change the height of element
  - `rotate(angle)` - Used to rotate the element based on an angle
  - `skewX(angle)` - Used to defines skew transforms along with x axis
  - `skewY(angle)` - Used to defines skew transforms along with y axis

- You can also do `3D Transforms`, I do not wanna note tham at the moment since I do not use them much but if you are interested go check out the official documentation

<br>
<br>
<br>

# Animation

- Animation is process of making shape changes and creating motions with elements. You can use animations with `@keyframes` Keyframes will control the intermediate animation steps in CSS3. Lets see an example:
  ```css
  @keyframes animation {
    from {background-color: pink }
    to {background-color: green }
  }
  
  div {
    background-color: red;
    animation-name: animation;
    animation-duration: 5s;
  }
  ```
  Making animations dont stress itout if you take animations out from -moz -webkit animation codes

---

<br>

- As I said this file does not tell everything there is to know about css3. If you want a full overview visit the offciial docuemntation.

<br>
<br>












  


  
  
  
  
  
  
