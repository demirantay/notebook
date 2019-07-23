# PHP

- The PHP Hypertext Preprocessor (PHP) is a programming language that allows web developers to create dynamic content that interacts with databases. PHP is basically used for developing web based software applications

  PHP is a server side scripting language that is embedded in HTML. It is used to manage dynamic content, databases, session tracking, even build entire e-commerce sites.
  
- Common uses of php:
  - PHP performs system functions, i.e. from files on a system it can create, open, read, write, and close them.
  - PHP can handle forms, i.e. gather data from files, save data to a file, through email you can send data, return data to the user.
  - You add, delete, modify elements within your database through PHP.
  - Access cookies variables and set cookies.
  - Using PHP, you can restrict users to access some pages of your website.
  - It can encrypt data.
  
- Note: while writing PHP that is present in the Web page, it is processed and stripped from the page; the only thing returned to the client from the Web server is pure HTML output.

<br>
<br>
<br>

# Environment Setup

- In order to develop and run PHP Web pages three vital components need to be installed on your computer system:
  - `Web Server` - PHP will work with virtually all Web Server software, including Microsoft's Internet Information Server (IIS) but then most often used is freely available Apache Server, XAMP, Nginx etc.
  - `Database` - PHP will work with virtually all database software, including Oracle and Sybase but most commonly used is freely available MySQL database.
  - `PHP Parser` -  In order to process PHP script instructions a parser must be installed to generate HTML output that can be sent to the Web Browser.
  
- The PHP parsing engine needs a way to differentiate PHP code from other elements in the page. The mechanism for doing so is known as 'escaping to PHP'. There are four ways to do this:
  - `Most used one` - <?php ... ?>
  - `Short open` - <? ... ?>
  - `ASP style` - <% ... %>
  - `HTML` - <script language="PHP"> ... </script>
  
 - You can comment in php like this:
   ```php
   # foo
   
   // bar
   
   /*
      Multi line
      comment
   */
   ```
   
 - You can run your php from the command line. Lets say that we have this:
   ```php
	 <?php
	 	echo "hello world";
	 ?>
	 ```
	 You run this with:
	 ```
	 $ php filename.php
	 ```
	 
- If you are using XAMPP for local development just open its folders and create a new project(directory) inside the `htdocs` and than start the server. You can accsess the admin interface typing `localhost/phpmyadmin` in your url tab while running your server.
	 
<br>
<br>
<br>

# Variables

- Here are the most important things to know about variables in PHP:
	- All variables in PHP are denoted with a leading dollar sign ($).
	- Variables in PHP do not have intrinsic types - a variable does not know in advance whether it will be used to store a number or a string of characters.
	
- PHP has a total of eight data types which we use to construct our variables −
	- `Integers` − are whole numbers, without a decimal point, like 4195.
	- `Doubles` − are floating-point numbers, like 3.14159 or 49.1.
	- `Booleans` − have only two possible values either true or false.
	- `NULL` − is a special type that only has one value: NULL.
	- `Strings` − are sequences of characters, like 'PHP supports string operations.'
	- `Arrays` − are named and indexed collections of other values.
	- `Objects` − are instances of programmer-defined classes, which can package up both other kinds of values and functions that are specific to the class.
	- `Resources` − are special variables that hold references to resources external to PHP (such as database connections).
	
	You can write each of them like this:
	```php
	$int = 15;
	$double = 3.1415;
	$bool = TRUE;
	$nada = NULL;
	$str = "hello";
	$arr = array(1, 2);
	...
	```
	
- You can declare constants like this. Only scalar data (boolean, integer, float and string) can be contained in constants.:
	```php
	define(PI, 3.14159);
	```
	no need for dollar sign in constants
	
- While printing remember if you want to concatenete and make it into str you can do it like it is in python with `,`:
	```php
	echo "number: , 5231923
	```
	or you can include vars in strings:
	```
	"number: $int_var"
	```
	Note: this method will not work with single quoted strings
	
	Btw if you want to concatenete two strings you can use the `,` like in python but php community actually likes more if you use `.` dots:
	```php
	$str1.$str2."\n";
	```
	
- You can get the length of a string with:
	```php
	strlen($str);
	```
	There are much more things you can do. PHP docs are really well documented you can check out for more ...
	
<br>
<br>
<br>

# Decision Making

- I am not going to note the logic behind control flow since I have done it many times in other programming language files. Here is how write them in php:
	```php
	if ($foo > $bar) {
		...
	}
	else if ($foo < $bar) {
		...
	}
	else {
		...
	}
	```

- There is also switch statement but I am not going to note it down since I do not use it very oftenly

<br>
<br>
<br>

# Loops

- For loop:
  ```php
  for ($i = 0; $i < 10; $i++) { ... }
  ```
  
- While Loop
  ```php
  while ($i < 10) {...}
  ```
  
- Do ... While loop:
	```php
	do {
		...
	} while($i < 10)
	```
	
- Foreach loop:
	```php
	foreach ($element as $array) {...}
	```
	
- There are `break` and `continue` control statements in loops while using php

<br>
<br>
<br>

# Arrays

- Normal Arrays:
	```php
	$numbers = array(1, 2, 3, 4, 5);
	```
	You accsess values like this:
	```php
	$numbers[0];
	```
	
- Associative Arrays: ( Associative array will have their index as string so that you can establish a strong association between key and values.)
	```php
	$salaries = array("john" => 2000, "beck" => 3400);
	```
	You access values like this:
	```php
	$salaries['john'];
	```
	
- Multidimensional array:
	```php
	$multidim = array(
		"foo" => array(
				"a" => 10
		),
		
		"bar" => array(
				"b" => 30
		)
	);
	```
	You can access the elements with this:
	```php
	$multidim["foo"]["a"];
	```

<br>
<br>
<br>

# File Inclusion

- You can include the content of a PHP file into another PHP file before the server executes it. There are two PHP functions which can be used to included one PHP file into another PHP file:
	- The include() Function
	- The require() Function
	
	This is a strong point of PHP which helps in creating functions, headers, footers, or elements that can be reused on multiple pages. This will help developers to make it easy to change the layout of complete website with minimal effort. If there is any change required then instead of changing thousand of files just change included file.
	
- `include()` -  The include() function takes all the text in a specified file and copies it into the file that uses the include function. If there is any problem in loading a file then the include() function generates a warning but the script will continue execution.


	```php
	<html>
		 <body>

				<?php include("menu.php"); ?>
				<p>This is an example to show how to include PHP file!</p>

		 </body>
	</html>
	```
	
- `require()` - function takes all the text in a specified file and copies it into the file that uses the include function. If there is any problem in loading a file then the require() function generates a fatal error and halt the execution of the script.
	
	So there is no difference in require() and include() except they handle error conditions. It is recommended to use the require() function instead of include(), because scripts should not continue executing if files are missing or misnamed.
	```php
	<html>
		 <body>

				 <?php require("xxmenu.php"); ?>
				 <p>This is an example to show how to include wrong PHP file!</p>

		 </body>
	</html>
	```
	
<br>
<br>
<br>

# Functions

- I am not going to into details about the logics in functions since I have done it many times in other programming language files. You can write them like this:
	```php
	function squared ($n) {
		return $n * $n;
	}
	```
	
- You can set default values to your function parameters in php like this:
	```php
	function foo ($num=10) {...}
	```
	
- It is also possible to assign function names as strings to variables and then treat these variables exactly as you would the function name itself. Following example depicts this behaviour.
	```php
	function sayHello() {
  	echo "Hello<br />";
  }
         
  $function_holder = "sayHello";
  $function_holder();
	```

<br>
<br>
<br>

# GET & POST Methods

- There are two ways the browser client can send information to the web server:
	- The GET Method
	- The POST Method
	
- I am not going to note it down since this note file is getting too large. You can view it from the following resources or go to the official documentation:
	- TutorialPoint - https://www.tutorialspoint.com/php/php_get_post.htm
	- Video: https://www.youtube.com/watch?v=pkxqlfLioCk&list=PL0eyrZgxdwhwBToawjm9faF1ixePexft-&index=26

...

<br>
<br>
<br>

# Cookies 

- There are three steps involved in identifying returning users −
	- Server script sends a set of cookies to the browser. For example name, age, or identification number etc.
	- Browser stores this information on local machine for future use.
	- When next time browser sends any request to web server then it sends those cookies information to the server and server uses that information to identify the user.
	
- I am not going to note it down since this note file is getting too large. You can view it from the following resources or go to the official documentation:
	- TutorialPoint - https://www.tutorialspoint.com/php/php_cookies.htm
	- Video: https://www.youtube.com/watch?v=jort8_4U-88&list=PL0eyrZgxdwhwBToawjm9faF1ixePexft-&index=27

<br>
<br>
<br>

# Files & I/O

- Since php is a programming language you can do:
	- Opening a file
	- Reading a file
	- Writing a file
	- Closing a file
	
- Since this note file is getting too large I am not going to note this down you can visit these links for a starting point:
	- TutorialPoint - https://www.tutorialspoint.com/php/php_files.htm
	- Video - 

<br>
<br>
<br>

# Sessions

- An alternative way to make data accessible across the various pages of an entire website is to use a PHP Session. A session creates a file in a temporary directory on the server where registered session variables and their values are stored. This data will be available to all pages on the site during that visit.

- - Since this note file is getting too large I am not going to note this down you can visit these links for a starting point:
	- TutorialPoint - https://www.tutorialspoint.com/php/php_sessions.htm
	- Video - https://www.youtube.com/watch?v=3CS-eQdcMLU&list=PL0eyrZgxdwhwBToawjm9faF1ixePexft-&index=28

<br>
<br>
<br>

# Sending Emails

- You can send emails using php however as I satated above this note file is getting too large just visit the links below or read the official documentation:
	- TutorialPoint: https://www.tutorialspoint.com/php/php_sending_emails.htm
	- Vide - 
	
<br>
<br>
<br>

# File Uploading

- A PHP script can be used with a HTML form to allow users to upload files to the server. Initially files are uploaded into a temporary directory and then relocated to a target destination by a PHP script.

- 
- - Since this note file is getting too large I am not going to note this down you can visit these links for a starting point:
	- TutorialPoint - https://www.tutorialspoint.com/php/php_file_uploading.htm
	- Video - 
	
<br>
<br>
<br>

# Predefined Variables

- PHP provides a large number of predefined variables to any script which it runs. PHP provides an additional set of predefined arrays containing variables from the web server the environment, and user input. These new arrays are called superglobals −

- You can a neatly listed version of predefined variables at this link:
	- https://www.tutorialspoint.com/php/php_predefined_variables.htm
	
<br>
<br>
<br>

# Error Handling

- Error handling is the process of catching errors raised by your program and then taking appropriate action. If you would handle errors properly then it may lead to many unforeseen consequences. This file is getting too large instead of noting it here you can visit the following links as a starter point to the part of the technollogy:
	- TutorialsPoint - https://www.tutorialspoint.com/php/php_error_handling.htm
	- Vide:
	
<br>
<br>
<br>
	


  
  
  
  
  
  
  
  
  



