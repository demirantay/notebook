 # Module Configuration
 
 > I am not gonna note down all of the directive lists because i will write a seperate cheatsheet for it. It takes too much space in here.
 
 - The true richness of Nginx lies within its modules. The entire application is built on a modular system, and each module can be enabled or disabled at compile time.
 
 - `Rewrite module` -- This module, in particular, brings much more functionality to Nginx than a simple set of directives. It defines a whole new level of request processing that will be explained all along this section.
 
   Initially, the purpose of this module (as the name suggests) is to perform URL rewriting. This mechanism allows you to get rid of ugly URLs containing
multiple parameters, for instance, http://example.com/article. php?id=1234&comment=32—such URLs being particularly uninformative and meaningless for a regular visitor. Instead, links to your website will contain useful information that indicate the nature of the page you are about to visit. The URL given in the example becomes http://website.com/article-1234-32-US- economy-strengthens.html.

  URL rewriting is a key element to Search Engine Optimization (SEO).
 
 - `Reminder on regular expressions` -- First and foremost, this module requires a certain understanding of regular expressions, also known as regexes or regexps. 
 
 - `Purpose` -- The first question we must answer is: What's the purpose of regular expressions? To put it simply, the main purpose is to verify that a string matches a pattern.
  - `hello ^hello$` -- Matches: yes -- The string begins by character h (^h), followed by e, l, l, and then finishes by o (o$).
  - `hell ^hello$` -- Matches: no -- The string begins by character h (^h), followed by e, l, l but does not finish by o.
  - `Hello ^hello$` -- Matches: Depends -- If the engine performing the match is case- sensitive, the string doesn't match the pattern.
  
    This concept becomes a lot more interesting when complex patterns are employed, such as one that validate an e-mail addresses: ^[A-Z0-9._%+-]+@[A-Z0-9.-]+\. [A-Z]{2,4}$. Validating the well-forming of an e-mail address programmatically would require a great deal of code, while all of the work can be done with a single regular expression pattern matching.
 
 - `PCRE syntax` -- The syntax that Nginx employs originates from the Perl Compatible Regular Expression (PCRE) library,
 
    You probably noticed that we employed the characters [ and ]. These are called metacharacters and have a special effect on the pattern. There are a total of 11 metacharacters, 
  - `^` -- The entity after this character must be found at the beginning. Beginning Example pattern: ^h
  - `$` -- The entity before this character must be found at the end. End Example pattern: e$
  - `.` -- Matches any character. Any Example pattern: hell
  - `[ ]` -- Matches any character within the specified set.
  - `Set` -- Syntax: [a-z] for a range, [abcd] for a set, and [a-z0-9] for two ranges
  - `[^ ]` -- Matches any character that is not within the specified set.
Example pattern: hell[^a-np-z0-9]
  - `|` -- Matches the entity placed either before or after the |.
Example pattern: hello|welcome
  - `( )` -- Groups a set of entities, often to be used in conjunction with |.
  - `\` -- Allows you to escape special characters.
 
 - `Quantifiers` --  ... 
 
 - `Captures` -- One last feature of the regular expression mechanism is the ability to capture sub-expressions. Whatever text is placed between parentheses ( ) is captured and can be used after the matching process. Here are a couple of examples to illustrate the principle:
  - `^(hello|hi) (sir|mister)$` -- `Captured $1 = hello`
 
 - `Internal requests` -- Nginx differentiates external and internal requests. External requests directly originate from the client; the URI is then matched against possible location blocks:
 
  internal requests are triggered by Nginx via specific directives. In default Nginx modules, there are several directives capable of producing internal requests: error_page, index, rewrite, try_files, add_before_body, add_after_ body (from the Addition module), the include SSI command, and more.
  
  There are two different kinds of internal requests:
  - Internal redirects Nginx redirects the client requests internally. The URI is changed, and the request may therefore match another location 
  - The most common case of internal redirects is when using the Rewrite directive, which allows you to rewrite the request URI.
  - Sub-requests: Additional requests that are triggered internally to generate content that is complementary to the main request. The SSI module also makes use of sub-requests to insert content with the include command.
 
 - `Rewrite` --
 
 - `Infinite loops` --
 
 - `Server Side Includes (SSI)` --
 
 - `Conditional structure` --
 
 - `Directives` --
 
 - `Common rewrite rules` --
 
 - `Performing a search` --
 
 - `User profile page` --
 
 - `Wikipedia-like` --
 
 ### Rewrite module
 
 ### SSI module
 
 ### Additional modules
 
 <br>
 <br>
 
 ---
 
 <br>
 <br>
 
 # PHP and Python with Nginx
 
 ### Introduction to FastCGI
 
 ### Python and Nginx
