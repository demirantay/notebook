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

- `Injecting into Different Statement Types ` -- The most com- mon types of SQL statements and their uses are described here.
	- SELECT statements are used to retrieve information from the database. 
	- INSERT statements are used to create a new row of data within a table.
	- UPDATE statements are used to modify one or more existing rows of data within a table
	- DELETE statements are used to delete one or more rows of data within a table

- `Finding SQL Injection Bugs ` -- In the most obvious cases, a SQL injection flaw may be discovered and conclu- sively verified by supplying a single item of unexpected input to the application. In other cases, bugs may be extremely subtle and may be difficult to distinguish from other categories of vulnerability or from benign anomalies that do not present a security threat. Nevertheless, you can carry out various steps in an ordered way to reliably verify the majority of SQL injection flaws.

	When user-supplied string data is incorporated into a SQL query, it is encap- sulated within single quotation marks. To exploit any SQL injection flaw, you need to break out of these quotation marks.
	
	If user-supplied data is being inserted into the structure of the SQL query itself, rather than an item of data within the query, exploiting SQL injection simply involves directly supplying valid SQL syntax. No “escaping” is required to break out of any data context.

- `Fingerprinting the Database ` -- Most of the techniques described so far are effective against all the common database platforms, and any divergences have been accommodated through minor adjustments to syntax. However, as we begin to look at more advanced exploitation techniques, the differences between platforms become more signifi- cant, and you will increasingly need to know which type of back-end database you are dealing with. Fingerprinting is called when you use different syntax of each different database platform to decide which one is used within the site that you are attacking. 

- `The UNION Operator ` -- The UNION operator is used in SQL to combine the results of two or more SELECT statements into a single result set. When a web application contains a SQL injec- tion vulnerability that occurs in a SELECT statement, you can often employ the UNION operator to perform a second, entirely separate query, and combine its results with those of the first.

	When the results of two queries are combined using the UNION operator, the two result sets must have the same structure. In other words, they must contain the same number of columns, which have the same or compatible data types, appearing in the same order To inject a second query that will return interesting results, the attacker needs to know the name of the database table that he wants to target, and the names of its relevant columns.

- `Extracting Useful Data ` -- To extract useful data from the database, normally you need to know the names of the tables and columns containing the data you want to access. The main enterprise DBMSs contain a rich amount of database metadata that you can query to discover the names of every table and column within the database.

- `Bypassing Filters ` -- In some situations, an application that is vulnerable to SQL injection may imple- ment various input filters that prevent you from exploiting the flaw without restrictions. For example, the application may remove or sanitize certain characters or may block common SQL keywords. Filters of this kind are often vulnerable to bypasses, so you should try numerous tricks in this situation.

	Some input validation routines employ a simple blacklist and either block or remove any supplied data that appears on this list. In this instance, you should try the standard attacks, looking for common defects in validation and canoni- calization mechanisms, as described in Chapter 2. For example, if the SELECT keyword is being blocked or removed, you can try the following bypasses: SeLecT %00SELECT ... etc.

- `Second-Order SQL Injection ` -- A particularly interesting type of filter bypass arises in connection with second- order SQL injection. Many applications handle data safely when it is first inserted into the database. Once data is stored in the database, it may later be processed in unsafe ways, either by the application itself or by other back-end processes. You can attack that too.

- `Beyond SQL Injection: Escalating the Database Attack ` -- A successful exploit of a SQL injection vulnerability often results in total com- promise of all application data. Most applications employ a single account for all database access and rely on application-layer controls to enforce segregation of access between different users. Gaining unrestricted use of the application’s database account results in access to all its data.

	Attacking databases is a huge topic that is beyond the scope of this book. This section points you toward a few key ways in which vulnerabilities and function- ality within the main database types can be leveraged to escalate your attack.

- `Using SQL Exploitation Tools`  -- Many of the techniques we have described for exploiting SQL injection vulner- abilities involve performing large numbers of requests to extract small amounts of data at a time. Fortunately, numerous tools are available that automate much of this process and that are aware of the database-specific syntax required to deliver successful attacks.

	Most of the currently available tools use the following approach to exploit SQL injection vulnerabilities
	- Brute-force all parameters in the target request to locate SQL injection points
	- Determine the location of the vulnerable field within the back-end SQL query by appending various characters such as closing brackets, comment characters, and SQL keywords.
	- Attempt to perform a UNION attack by brute-forcing the number of required columns 
	- Inject custom queries to retrieve arbitrary data 
	- If results cannot be retrieved using UNION, inject Boolean conditions (AND 1=1,AND 1=2,andsoon)intothequerytodeterminewhetherconditional responses can be used to retrieve data.
	- If results cannot be retrieved by injecting conditional expressions, try using conditional time delays to retrieve data.
	
	These tools are primarily exploitation tools, best suited to extracting data from the database by exploiting an injection point that you have already identified and understood. They are not a magic bullet for finding and exploit- ing SQL injection flaws. In practice, it is often necessary to provide some additional SQL syntax before and/or after the data injected by the tool for the tool’s hard-coded attacks to work.
 
- `SQL Syntax and Error Reference` -- We have described numerous techniques that enable you to probe for and exploit SQL injection vulnerabilities in web applications. In many cases, there are minor differences between the syntax that you need to employ against different back-end database platforms. Furthermore, every database produces different error messages whose meaning you need to understand both when probing for flaws and when attempting to craft an effective exploit

- `Preventing SQL Injection ` -- Despite all its different manifestations, and the complexities that can arise in its exploitation, SQL injection is in general one of the easier vulnerabilities to prevent.

	__Partially Effective Measures__ -- Because of the prominence of the single quotation mark in the standard expla- nations of SQL injection flaws, a common approach to preventing attacks is to escape any single quotation marks within user input by doubling them
	
	Another countermeasure that is often cited is the use of stored procedures for all database access. There is no doubt that custom stored procedures can provide security and performance benefits. However, they are not guaranteed to prevent SQL injection vulnerabilities.

	__Parameterized Queries__ -- Most databases and application development platforms provide APIs for handling untrusted input in a secure way, which prevents SQL injection vulnerabilities from arising. If parameterized queries are to be an effective solution against SQL injection,
you need to keep in mind several important provisos:
	- They should be used for every database query. 
	- Every item of data inserted into the query should be properly parameterized.
	- Parameter placeholders cannot be used to specify the table and column names used in the query

	__Defense in Depth__ -- As always, a robust approach to security should employ defense-in-depth measures to provide additional protection in the event that frontline defenses fail for any reason.
	- The application should use the lowest possible level of privileges when accessing the database. It usually only needs to read and write its own data. If this approach is enforced throughout the application, any residual SQL injection flaws that may exist are likely to have their impact significantly reduced.
	- Many enterprise databases include a huge amount of default functional- ity that can be leveraged by an attacker who gains the ability to execute arbitrary SQL statements. Wherever possible, unnecessary functions should be removed or disabled
	- All vendor-issued security patches should be evaluated, tested, and applied in a timely way to fix known vulnerabilities within the database software itself

### Summary

- We have examined a range of vulnerabilities that allow you to inject into web application data stores. These vulnerabilities may allow you to read or modify sensitive application data, perform other unauthorized actions, or subvert appli- cation logic to achieve an objective.

	As serious as these attacks are, they are only part of a wider range of attacks that involve injecting into interpreted contexts. Other attacks in this category may allow you to execute commands on the server’s operating system, retrieve arbitrary files, and interfere with other back-end components. The next chapter examines these attacks and others. It looks at how vulnerabilities within a web application can lead to compromise of key parts of the wider infrastructure that supports the application

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

