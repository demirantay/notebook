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
	$arr = [1, 2];
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



