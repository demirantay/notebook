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
	```css
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
	
  
  


	
	
