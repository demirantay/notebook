# Static Site Generation Using Pelican

- I will note some of the few things that I think worth noting down from the documentataion of [Pelican](https://docs.getpelican.com/en/stable/index.html) everything is not included. [Visit the official documentation](https://docs.getpelican.com/en/stable/index.html) for more info 

<br>
<br>
<br>

# Quickstart

- First install pelican (and markdown) with:
  ```
  $ pip install pelican markdown
  ```
  and after that `cd` into your project and use the following:
  ```
  $ pelican-quickstart
  ```
  After answering the prompts you cannot run pelican without some content. Create this in your content folder:
  ```md
  Title: My First Review
  Date: 2010-12-03 10:20
  Category: Review

  Following is a review of my favorite mechanical keyboard.
  ```
  Than generate your site:
  ```
  $ pelican content
  ```
  Finally you can view your pelican website with pelicans webserver:
  ```
  $ pelican --listen
  ```

<br>
<br>
<br>

# Writing Content

- After creating an article or a page you should run `pelican content` command in order to generate the new outputs.

- Pelican considers “`articles`” to be chronological content, such as posts on a blog, and thus associated with a date.

  The idea behind “`pages`” is that they are usually not temporal in nature and are used for content that does not change very often (e.g., “About” or “Contact” pages).
  
- Metadata syntax for Markdown posts should follow this pattern:
  ```md
  Title: My super title
  Date: 2010-12-03 10:20
  Modified: 2010-12-05 19:30
  Category: Python
  Tags: pelican, publishing
  Slug: my-super-post
  Authors: Alexis Metaireau, Conan Doyle
  Summary: Short version for index and feeds

  This is the content of my super blog post.
  ```
  You can also have your own metadata keys (so long as they don’t conflict with reserved metadata keywords) for use in your python templates. The following is the list of reserved metadata keywords: `Title`, `Tags`, `Date`, `Modified`, `Status`, `Category`, `Author`, `Authors`, `Slug`, `Summary`, `Template`, `Save_as`, `Url`
  
### Pages

- If you create a folder named `pages` inside the content folder, all the files in it will be used to generate static pages, such as About or Contact pages. (See example filesystem layout below.)

  You can use the `DISPLAY_PAGES_ON_MENU` setting to control whether all those pages are displayed in the primary navigation menu. (Default is `True`.)
  
- If you want to exclude any pages from being linked to or listed in the menu then add a `status: hidden` attribute to its metadata. This is useful for things like making error pages that fit the generated theme of your site.

### Linking

- Yes, pelican uses markdown and all of the syntax is normally writtne but in order to link things inside the directory you use a slightly modified syntax:
  ```md
  [a link relative to the content root]({filename}/category/article1.rst)
  ```
  
- 
  
  
  
  
 
 
<br>
<br>
<br>

 # Publishing you site
 
 <br>
 <br>
 <br>
 
 # Settings 
 
 <br>
 <br>
 <br>
 
 # Creating Themes
 
<br>
<br>
<br>

# Tips
 
 
 
 
 
  
  
  
  
