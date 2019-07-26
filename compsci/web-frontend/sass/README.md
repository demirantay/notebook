# Sass

- SASS (Syntactically Awesome Stylesheet) is a CSS pre-processor, which helps to reduce repetition with CSS and saves time. It is more stable and powerful CSS extension language that describes the style of document structurally. 

- Why use SASS ?
	- It is a pre-processing language which provides indented syntax (its own syntax) for CSS.
	- It provides some features, which are used for creating stylesheets that allows writing code more efficiently and is easy to maintain.
	- It is a super set of CSS, which means it contains all the features of CSS and is an open source pre-processor, coded in Ruby.
	- It provides the document style in a good, structured format than flat CSS. It uses re-usable methods, logic statements and some of the built-in functions such as color manipulation, mathematics and parameter lists.
	
- Features of SASS:
	- It is more stable, powerful, and compatible with versions of CSS.
	- It is a super set of CSS and is based on JavaScript.		- It is known as syntactic sugar for CSS, which means it makes easier way for user to read or express the things more clearly.
	- It uses its own syntax and compiles to readable CSS.
	- You can easily write CSS in less code within less time.
	- It is an open source pre-processor, which is interpreted into CSS.
		
- Disadvantages of SASS:
	- It takes time for a developer to learn new features present in this pre-processor.
	- If many people are working on the same site, then should use the same preprocessor. Some people use Sass and some people use CSS to edit the files directly. Therefore, it becomes difficult to work on the site.
	- There are chances of losing benefits of browser's built-in element inspector.
	
<br>
<br>
<br>

# Compiling Sass

- Once you start tinkering with Sass, it will take your preprocessed Sass file and compile it as a normal CSS file that you can use in your website. 

  The most direct way to make this happen is in your terminal. Once Sass is installed, you can compile your Sass to CSS using the `sass` command. You'll need to tell Sass which file to build from, and where to output CSS to. For example, running:
  ```
  $ sass input.scss output.css
  ```
  from your terminal would take a single Sass file, `input.scss`, and compile that file to `output.css`.
  
- You can also watch individual files or directories with the --watch flag. The watch flag tells Sass to watch your source files for changes, and re-compile CSS each time you save your Sass. If you wanted to watch (instead of manually build) your input.scss file, you'd just add the watch flag to your command, like so:
  ```
  $ sass --watch input.scss output.css
  ```
  You can watch and output to directories by using folder paths as your input and output, and separating them with a colon. In this example:
  ```
  $ sass --watch app/sass:public/stylesheets
  ```
  
<br>
<br>
<br>

# Nested Rules

- Nesting you css code isniside different element blocks is actually called CSS Exention's however for simplicty I noted it as nesting rules.

- `Nested Selectors`: Nesting is combining of different logic structures. Using SASS, we can combine multiple CSS rules within one another. If you are using multiple selectors, then you can use one selector inside another to create compound selectors. For example instead of writing your css code like this:
	```css
	#conainer h1 {...}
	
	#container p {...}
	
	#container p a {...}
	```
	You can nest them in each other in SASS like this:
	```
	#container {
	  p {...}
		
	  p a {...}
	}
	```
	
- You can also save repetition by using nesting properties. Lets just say that you have the following css code:
	```css
		p {
			font-family: Lucida Sans Unicode;
			font-size: 20px;
			font-weight: bold;
		}
	```
	You can use the nested properties in SASS like this:
	```
		p {
			font: {
				family: Lucida Sans Unicode;
				size:20px;
				weight: bold;
			}
		}
	```
	
- You can view more about CSS Extensions here: https://www.tutorialspoint.com/sass/sass_css_extensions.htm

<br>
<br>
<br>

# Comments

- People who use css always tend to use:
	```
	/* this type of comments */
	```
	However with sass you can also use singline line:
	```
	// language like comments
	```
	
<br>
<br>
<br>

# Variables

- You can use variables inside sass files. This is such a reief since you have to write so many repeating code in css. For example you can add colors to a single variable and when you want to change the theme of the site you will not have to update every goddamn css property in the file. You can simply just update a single variable. See how to write variables:
	```
	$theme_color: red;
	
	body { color: $theme_color; }
	```
	
- You can set the default values for variables by adding !default flag to the end of the variable value. It will not re-assign the value, if it is already assigned to the variable.
	```css
	$foo: 50px !default;
	```
	
- Just like any other vraiable scripts you can do in other programming langauges, you can do them in sass as well. For example while you are defining your variables you can add different `data types` and do various kind of `operations` on them (you can even add two colors together). See the following links for info:
	- Data Types: https://www.tutorialspoint.com/sass/datatypes.htm
	- Operations: https://www.tutorialspoint.com/sass/operations.htm
	
- You can also write functions inside css files with sass. You can visit the official docs for more info.:
	- https://sass-lang.com/documentation/at-rules/function
	
	

<br>
<br>
<br>

# Interpolation

- Yes, you can concatenete strings but if you do not want to do that you can write logic inside data types with interpolation. You simply put the specific logic inside #{} curly braces. lets see an example:
	```css
	p {
		content: "I have #{6+2+2} books on SASS";
	}
	```
	This sass file will create a css file like this:
	```css
	p {
		content: "I have 10 books on SASS";
	}
	```
	
<br>
<br>
<br>

# @import 

- Import directives, imports the SASS or SCSS files. It directly takes the filename to import. All the files which are imported in SASS will get combined in a single CSS file. There are few things that are compiled to a CSS when we use @import rule. You can import in 4 ways:
	```css
	@import "style.css";
	@import "http://tutorialspoint.com/bar";
	@import url(style);
	@import "style" screen;
	```
	
- For example lets say that we have a file named `colors.scss` :
	```css
	$main: red;
	$hover: pink;
	$content: green;
	```
	We can import these in a different css file and use its code:
	```css
	@import "colors";
	
	body {
		background-color: $main;
		color: $content;
	}
	```

<br>
<br>
<br>

# @media

- This selector is actually very important even for css responsivness. At the moment I am skipping it because I will write a single notefile just for it

<br>
<br>
<br>

# @extend

- The @extend directive is used to share rules and relationships between selectors. It can extend all another class styles in one class and can also apply its own specific styles. There are many ways to extend classes but the most common and easiest one is the following:
	```css
	h2 {
		 font-size: 40px;
	}

	.container{
		 @extend h2
	}
	```
	The sass content above would be compiled into this CSS code:
	```css
	h2, .container {
		 font-size: 40px;
	}
	```

<br>
<br>
<br>

# errors, debuggins ... etc.

- You can catch errors, debug your errors and throw fully customizable warning message to your users.  I am not going to note on each @rules instead you can read the following links to have a good starting point for all ofthe directives listed above:
	- `@error` - https://www.tutorialspoint.com/sass/directives_error.htm
	- `@debug` - https://www.tutorialspoint.com/sass/directives_debug.htm
	- `@warn` - https://www.tutorialspoint.com/sass/directives_warn.htm
	
<br>
<br>
<br>

# Control Directives and Expressions

- I am not going to expalain the logic behind control flows and loops since I have noted them many times in perivious note files. Just learn how to write them in SASS:

- The `@if` directive is used to selectively execute the code statements based on the result of evaluating an expression. The `@if` statements can be followed by several `@else if` statements"
	```css
	$type: audi;
	
	p {
		 @if $type == benz {
				color: red;
		 } @else if $type == mahindra {
				color: blue;
		 } @else if $type == audi {
				color: green;
		 } @else {
				color: black;
		 }
	}
	```
	
- The `@for` directive allows you to generate styles in a loop. The counter variable is used to set the output for each iteration:
	```css
	@for $i from 1 to 4 {
		 .p#{$i} { padding-left : $i * 10px; }
	}
	```
	
- You can write `@while` loos inside sass:
	```css
	$i: 50;
	@while $i > 0 {
		 .paddding-#{$i} { padding-left: 1px * $i; }
		 $i: $i - 10;
	}
	```
	This simple sass code would help you writing tons of css repetable code like the following:
	```css
	.paddding-50 {
   	padding-left: 50px;
	}

	.paddding-40 {
		 padding-left: 40px; 
	}

	.paddding-30 {
		 padding-left: 30px; 
	}

	.paddding-20 {
		 padding-left: 20px; 
	}

	.paddding-10 {
		 padding-left: 10px; 
	}
	```
	
	
- There is also `@each` directive for selection queries but I did not get it at the moment. Im leaving the link where I  left reading at:
	- https://www.tutorialspoint.com/sass/each_directive.htm

<br>
<br>
<br>

# Mixins

- Mixins allow creating a group of styles, which are reusable throughout your stylesheet without any need to recreation of non-semantic classes. In CSS, the mixins can store multiple values or parameters and call function; it helps to avoid writing repetitive codes.

- `Defining a Mixin` - The @mixin directive is used to define the mixins. It includes optionally the variables and argument after the name of the mixin:
	```css
	@mixin style {
		 .cont{
				color: #77C1EF;
		 }
	}
	
	@include style;
	```
	After compliing this sass code, the css code would only have this class at the top nothing more:
	```css
	.cont {
		color: #77C1EF;
	}
	```
	Note: The @include directive is used to include the mixin in the document. The name of mixin is taken and optional arguments are passed into it. The styles defined by the mixin can be included into the current rule.

- `Arguments` - The SassScript values can be taken as arguments in mixins, which are passed when mixin is included and are available as variable within the mixin. The argument is a name of a variable, which is separated by comma while defining a mixin. There are two types of arguments such as −
	- Keyword Arguments
	- Variable Arguments
	
	You can write and use keyword arguments like in the following snippet:
	```css
	@mixin bordered($color, $width: 2px) {
		 color: #77C1EF;
		 border: $width solid black;
		 width: 450px;
	}

	.style  {
		 @include bordered($color:#77C1EF, $width: 2px);
	}
	```
	
	You can also pass as much as arguments you want without specifiyng their declaration in the definition by using variable arguments but I am too lazy to note them down so instead read this:  https://www.tutorialspoint.com/sass/arguments.htm
	
<br>
<br>
<br>

# Function Directives 

  
  


	
	
