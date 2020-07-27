# Chapter 9 Attacking Data Stores

- Nearly all applications rely on a data store to manage data that is processed within the application. In many cases this data drives the core application logic, holding user accounts, permissions, application configuration settings, and more. Data stores have evolved to become significantly more than passive containers for data. Most hold data in a structured format, accessed using a predefined query format or language, and contain internal logic to help manage that data.

	If an attacker can interfere with the application’s interaction with the data store, to make it retrieve or modify different data, he can usually bypass any controls over data access that are imposed at the application layer. By far the most common data stores are SQL databases, XML- based repositories, and LDAP directories. Practical examples seen elsewhere are also covered.

### Injecting into Interpreted Contexts

- Because of how interpreted languages are executed, a family of vulnerabilities known as code injection arises. In any useful application, user-supplied data is received, manipulated, and acted on. Therefore, the code that the interpreter processes is a mix of the instructions written by the programmer and the data supplied by the user. In some situations, an attacker can supply crafted input that breaks out of the data context, usually by supplying some syntax that has a special significance within the grammar of the interpreted language being used.

- `Bypassing a Login` -- The web application functions as a discretionary access control to the data store, constructing queries to retrieve, add, or modify data in the data store based on the user’s account and type. A successful injection attack that modifies a query (and not merely the data within the query) can bypass the application’s discretionary access controls and gain unauthorized access.

	For example, if an attacker knows that the username of the application administrator is admin, he can log in as that user by supplying any password and the following username: (`'admin'--`
		````sql	
		SELECT * FROM users WHERE username = ‘admin’--’ AND password = ‘foo’
		```
		Note that the comment sequence (--) causes the remainder of the query to
	be ignored, and so the password check is bypassed.

		> Injection into interpreted languages is a broad topic, encompassing many different kinds of vulnerabilities and potentially affecting every component of a web application’s supporting infrastructure.

### Injecting into SQL 

- SQL is an interpreted language, and web applications commonly construct SQL statements that incorporate user-supplied data. If this is done in an unsafe way, the application may be vulnerable to SQL injection. This flaw is one of the most notorious vulnerabilities to have afflicted web applications. In the most serious cases, SQL injection can enable an anonymous attacker to read and modify all data stored within the database, and even take full control of the server on which the database is running. As awareness of web application security has evolved, SQL injection vulner- abilities have become gradually less widespread and more difficult to detect and exploit.

	In many situations, you will find it extremely useful to have access to
a local installation of the same database that is being used by the applica- tion you are targeting. You will often find that you need to tweak a piece of syntax, or consult a built-in table or function, to achieve your objectives. The responses you receive from the target application will often be incomplete or cryptic, requiring some detective work to understand. All of this is much easier if you can cross-reference with a fully transparent working version of the database in question.

- `Injecting into Different Statement Types ` --

- `Finding SQL Injection Bugs ` --

- `Fingerprinting the Database ` --

- `The UNION Operator ` --

- `Extracting Useful Data ` --

- `Extracting Data with UNION` --

- `Bypassing Filters ` --

- `Second-Order SQL Injection ` --

- `Advanced Exploitation ` --

- `Beyond SQL Injection: Escalating the ` --

- `Using SQL Exploitation Tools`  --

- `SQL Syntax and Error Reference` --

- `Preventing SQL Injection ` --

### Injecting into NoSQL

- `Injecting into MongoDB ` --

### Injecting into XPath 

- `Subverting Application Logic ` --

- `Informed XPath Injection ` --

- `Blind XPath Injection` --

- `Finding XPath Injection Flaws ` --

- `Preventing XPath Injection ` --

### Injecting into LDAP

- `Exploiting LDAP Injection` --

- `Finding LDAP Injection Flaws` --

- `Preventing LDAP Injection ` --

### Summary

<br>
<br>

---

<br>
<br>

# Chapter 10 Attacking Back-End Components 
 
### Injecting OS Commands

- `Example 1: Injecting Via Perl ` --

- `Example 2: Injecting Via ASP` --

- `Injecting Through Dynamic Execution ` --

- `Finding OS Command Injection Flaws ` --

- `Finding Dynamic Execution Vulnerabilities ` --

- `Preventing OS Command Injection ` --

- `Preventing Script Injection Vulnerabilities ` --

### Manipulating File Paths 

- `Path Traversal Vulnerabilities ` --

- `File Inclusion Vulnerabilities ` --

### Injecting into XML Interpreters

- `Injecting XML External Entities` --

- `Injecting into SOAP Services ` --

- `Finding and Exploiting SOAP Injection ` --

- `Preventing SOAP Injection` --

### Injecting into Back-end HTTP Requests 

- `Server-side HTTP Redirection ` --

- `HTTP Parameter Injection` --

### Injecting into Mail Services 

- `E-mail Header Manipulation ` --

- `SMTP Command Injection` --

- `Finding SMTP Injection Flaws ` --

- `Preventing SMTP Injection` --

### Summary

<br>
<br>

---

<br>
<br>

