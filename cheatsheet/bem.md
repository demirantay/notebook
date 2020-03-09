# BEM Methodology Cheatsheet

This is how you would write the css part 
```css
/* Block component */
.btn {}

/* Element that depends upon the block (2 underscores) */ 
.btn__price {}

/* Modifier that changes the style of the block */
.btn--orange {} 
.btn--big {}
```

This is the html part of the code above
```html
<a class="btn btn--big btn--orange" href="http://css-tricks.com">
  <span class="btn__price">$9.99</span>
  <span class="btn__text">Subscribe</span>
</a>
```
