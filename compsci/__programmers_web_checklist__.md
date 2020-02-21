# The technical details a programmer of a web application should consider before making the site public

> What things should a programmer implementing the technical details of a web application consider before making the site public? If Jeff Atwood can forget about HttpOnly cookies, sitemaps, and cross-site request forgeries all in the same site, what important thing could I be forgetting as well?

<bR>
<br>

## Interface and User Experience

- Be aware that browsers implement standards inconsistently and make sure your site works reasonably well across all major browsers. At a minimum test against a recent [Gecko](https://en.wikipedia.org/wiki/Gecko_%28layout_engine%29) engine ([Firefox](https://www.mozilla.org/en-US/firefox/new/?redirect_source=firefox-com)), a WebKit engine ([Safari](https://www.apple.com/safari/) and some mobile browsers), [Chrome](https://www.google.com/chrome/), your supported IE browsers (take advantage of the Application Compatibility VPC Images), and Opera. Also consider how browsers [render your site in different operating systems](http://browsershots.org/).

- Consider how people might use the site other than from the major browsers: cell phones, screen readers and search engines, for example. — Some accessibility info: [WAI](https://www.w3.org/WAI/) and [Section508](), Mobile development: [MobiForge](https://mobiforge.com/).

- Staging: How to deploy updates without affecting your users. Have one or more test or staging environments available to implement changes to architecture, code or sweeping content and ensure that they can be deployed in a controlled way without breaking anything. Have an automated way of then deploying approved changes to the live site. This is most effectively implemented in conjunction with the use of a version control system (git, Subversion, etc.) and an automated build mechanism (Ant, NAnt, etc.).

- Don't display unfriendly errors directly to the user.

- Don't put users' email addresses in plain text as they will get spammed to death.

- Add the attribute rel="nofollow" to user-generated links to avoid spam.

- [Build well-considered limits into your site](https://blog.codinghorror.com/rate-limiting-and-velocity-checking/) - This also belongs under Security.

- Learn how to do [progressive enhancement](https://en.wikipedia.org/wiki/Progressive_enhancement).

- Redirect after a POST if that POST was successful, to prevent a refresh from submitting again.

- Don't forget to take accessibility into account. It's always a good idea and in certain circumstances it's a [legal requirement](). [WAI-ARIA](https://www.w3.org/WAI/standards-guidelines/aria/) and [WCAG 2](https://www.w3.org/TR/WCAG20/) are good resources in this area.

- Read [Don't Make Me Think](http://www.sensible.com/dmmt.html)

<br>

## Security


<br>

## Performance

<br>

## SEO (Search Engine Optimization)


<br>

## Technology

<br>

## Bug fixing

<br>

## Other
