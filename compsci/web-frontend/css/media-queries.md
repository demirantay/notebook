# Media Queries

- `@media` queries (decorators) were added to css in 2.0 It is implemented so that we can view the site on different sized screens without breaking the html element structure which is basically called **Responsive Design**

- The sytanx is very very simple lets examine the following css code:
  ```css
  body {
    background-color: blue;
  }
  
  @media screen and (max-width: 480px) {
    body {
      background-color: red;
    }
  }
  ```
  So initially when the site is fired up the background color is `blue` however when ever the browser that is displaying our page get shrinked from the sides and its width goes below or equal to `480px` then the background color changes to red;
  
  Well do not ask how chaing the color of a element help me with the element sturcture instead of using background-colors you can use and fix the height and width of the elements when they are shrinked to a certian pixel from the sides.
