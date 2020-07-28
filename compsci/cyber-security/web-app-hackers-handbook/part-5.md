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

- Web applications are increasingly complex offerings. They frequently function as the Internet-facing interface to a variety of business-critical resources on the back end, including networked resources such as web services, back-end web servers, mail servers, and local resources such as filesystems and interfaces to the operating system. Frequently, the application server also acts as a discretionary access control layer for these back-end components. Any successful attack that could perform arbitrary interaction with a back-end component could potentially violate the entire access control model applied by the web application, allowing unauthorized access to sensitive data and functionality.
 
### Injecting OS Commands

- Most web server platforms have evolved to the point where built-in APIs exist to perform practically any required interaction with the server’s operating system. Properly used, these APIs can enable developers to access the filesys- tem, interface with other processes, and carry out network communications in a safe manner.  Nevertheless, there are many situations in which developers elect to use the more heavyweight technique of issuing operating system com- mands directly to the server However, if the application passes user-supplied input to operating system commands, it may be vulnerable to command injection, enabling an attacker to submit crafted input that modifies the commands that the developers intended to perform.

- `Injecting Through Dynamic Execution ` -- Many web scripting languages support the dynamic execution of code that is generated at runtime. This feature enables developers to create applications that dynamically modify their own code in response to various data and conditions. If user input is incorporated into code that is dynamically executed, an attacker may be able to supply crafted input that breaks out of the intended data context and specifies commands that are executed on the server in the same way as if they had been written by the original developer. The first target of an attacker at this point typically is to inject an API that runs OS commands.

- `Finding OS Command Injection Flaws ` -- In your application mapping exercises (see Chapter 4), you should have identi- fied any instances where the web application appears to be interacting with the underlying operating system by calling external processes or accessing the filesystem. You should probe all these functions, looking for command injection flaws.

- `Finding Dynamic Execution Vulnerabilities ` -- Dynamic execution vulnerabilities most commonly arise in languages such as PHP and Perl. But in principle, any type of application platform may pass user-supplied input to a script-based interpreter, sometimes on a different back-end server.

- `Preventing OS Command Injection ` -- In general, the best way to prevent OS command injection flaws from arising is to avoid calling out directly to operating system commands. Virtually any conceivable task that a web application may need to carry out can be achieved using built-in APIs that cannot be manipulated to perform commands other than the one intended.

	If it is considered unavoidable to embed user-supplied data into command strings that are passed to an operating system command interpreter, the appli- cation should enforce rigorous defenses to prevent a vulnerability from arising. If possible, a whitelist should be used to restrict user input to a specific set of expected values. Alternatively, the input should be restricted to a very narrow character set, such as alphanumeric characters only.

- `Preventing Script Injection Vulnerabilities ` -- In general, the best way to avoid script injection vulnerabilities is to not pass user-supplied input, or data derived from it, into any dynamic execution or include functions. If this is considered unavoidable for some reason, the rel- evant input should be strictly validated to prevent any attack from occurring. If possible, use a whitelist of known good values that the application expects, and reject any input that does not appear on this list.

### Manipulating File Paths 

- Many types of functionality commonly found in web applications involve pro- cessing user-supplied input as a file or directory name. Typically, the input is passed to an API that accepts a file path, such as in the retrieval of a file from the local filesystem. The application processes the result of the API call within its response to the user’s request. If the user-supplied input is improperly validated, this behavior can lead to various security vulnerabilities.

- `Path Traversal Vulnerabilities ` -- Path traversal vulnerabilities arise when the application uses user-controllable data to access files and directories on the application server or another back- end filesystem in an unsafe way. By submitting crafted input, an attacker may be able to cause arbitrary content to be read from, or written to, anywhere on the filesystem being accessed.

	__Finding and Exploiting Path Traversal Vulnerabilities__ --  Known as path traversal vulnerabilities, such defects may enable the attacker to read sensitive data including passwords and appli- cation logs, or to overwrite security-critical items such as configuration files and software binaries.
	
	__Locating Targets for Attack__ --  During your initial mapping of the application, you should already have identified any obvious areas of attack surface in relation to path traversal vulnerabilities. Any functionality whose explicit purpose is uploading or downloading files should be thoroughly tested. This functionality is often found in work flow applications where users can share documents, in blogging and auction appli- cations where users can upload images, and in informational applications where users can retrieve documents such as ebooks, technical manuals, and company reports.
	
	Having identified the various potential targets for path traversal testing, you need to test every instance individually to determine whether user-controllable data is being passed to relevant filesystem operations in an unsafe manner. For each user-supplied parameter being tested, determine whether traversal sequences are being blocked by the application or whether they work as expected.
	
	If you find any instances where submitting traversal sequences without step- ping above the starting directory does not affect the application’s behavior, the next test is to attempt to traverse out of the starting directory and access files from elsewhere on the server filesystem. 
	
	__Circumventing Obstacles to Traversal Attacks__ -- If your initial attempts to perform a traversal attack (as just described) are unsuccessful, this does not mean that the application is not vulnerable. Many application developers are aware of path traversal vulnerabilities and implement various kinds of input validation checks in an attempt to prevent them. However, those defenses are often flawed and can be bypassed by a skilled attacker. For example an applicaiton might block text such as `.` (dot) however you can easily put its ascii encoding `%2e` isntead of putting it and this bypasses the text filters ... etc. 
	
	__Exploiting Traversal Vulnerabilities__  -- Having identified a path traversal vulnerability that provides read or write access to arbitrary files on the server’s filesystem, what kind of attacks can you carry out by exploiting these? In most cases, you will find that you have the same level of read/write access to the filesystem as the web server process does.
	
	__Preventing Path Traversal Vulnerabilities__ -- By far the most effective means of eliminating path traversal vulnerabilities is to avoid passing user-submitted data to any filesystem API. In many cases, includ- ing the original example GetFile.ashx?filename=keira.jpg, it is unnecessary for an application to do this. Most files that are not subject to any access control can simply be placed within the web root and accessed via a direct URL. If this is not possible, the application can maintain a hard-coded list of image files that may be served by the page.
	
	Here are some examples of defenses that may be used; ideally, as many of these as possible should be implemented together:
	- After performing all relevant decoding and canonicalization of the user- submitted filename, the application should check whether it contains either of the path traversal sequences (using backslashes or forward slashes) or any null bytes
	- The application should use a hard-coded list of permissible file types and reject any request for a different type
	- After performing all its filtering on the user-supplied filename, the appli- cation should use suitable filesystem APIs to verify that nothing is amiss

- `File Inclusion Vulnerabilities ` -- Many scripting languages support the use of include files. This facility enables developers to place reusable code components into separate files and to include these within function-specific code files as and when they are needed
	 
	__Finding File Inclusion Vulnerabilities__ -- File inclusion vulnerabilities may arise in relation to any item of user-supplied data. They are particularly common in request parameters that specify a lan- guage or location. They also often arise when the name of a server-side file is passed explicitly as a parameter.

### Injecting into Mail Services 

- Many applications contain a facility for users to submit messages via the appli- cation, such as to report a problem to support personnel or provide feedback about the website. This facility is usually implemented by interfacing with a mail (or SMTP) server. Typically, user-supplied input is inserted into the SMTP conversation that the application server conducts with the mail server. If an attacker can submit suitable crafted input that is not filtered or sanitized, he may be able to inject arbitrary STMP commands into this conversation.

	SMTP injection vulnerabilities are often exploited by spammers who scan the Internet for vulnerable mail forms and use these to generate large volumes of nuisance e-mail.

- `Preventing SMTP Injection` -- SMTP injection vulnerabilities usually can be prevented by implementing rig- orous validation of any user-supplied data that is passed to an e-mail function or used in an SMTP conversation. Each item should be validated as strictly as possible given the purpose for which it is being used:
	- E-mail addresses should be checked against a suitable regular expression
	- The message subject should not contain any newline characters, and it may be limited to a suitable length.
	- If the contents of a message are being used directly in an SMTP conversa- tion, lines containing just a single dot should be disallowed.

### Summary

- Many real-world vulnerabilities can be discovered within the first few seconds of interacting with an application. For example, you could enter some unexpected syntax into a search box. In other cases, these vulnerabilities may be highly subtle, manifesting themselves in scarcely detectable differences in the application’s behavior, or reachable only through a multistage process of submitting and manipulating crafted input.



