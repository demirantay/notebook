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
 
- To generate its HTML output, Pelican uses the Jinja templating engine due to its flexibility and straightforward syntax.  you can define `THEME` in your settings to point to the location of your preferred theme.
 
### Structure
 
- To make your own theme, you must follow the following structure:
  ```
  ├── static
  │   ├── css
  │   └── images
  └── templates
      ├── archives.html         // to display archives
      ├── period_archives.html  // to display time-period archives
      ├── article.html          // processed for each article
      ├── author.html           // processed for each author
      ├── authors.html          // must list all the authors
      ├── categories.html       // must list all the categories
      ├── category.html         // processed for each category
      ├── index.html            // the index (list all the articles)
      ├── page.html             // processed for each page
      ├── tag.html              // processed for each tag
      └── tags.html             // must list all the tags. Can be a tag cloud.
  ```
  static contains all the static assets, which will be copied to the output theme folder. The above filesystem layout includes CSS and image folders, but those are just examples. Put what you need here.
  
  templates contains all the templates that will be used to generate the content. The template files listed above are mandatory; you can add your own templates if it helps you keep things organized while creating your theme.
  
- All templates will receive the variables defined in your settings file, as long as they are in all-caps. You can access them directly.All of these settings will be available to all templates:
  - `output_file` - The name of the file currently being generated. For instance, when Pelican is rendering the home page, output_file will be “index.html”.
  - `articles` - The list of articles, ordered descending by date. All the elements are Article objects, so you can access their attributes (e.g. title, summary, author etc.). Sometimes this is shadowed (for instance in the tags page). You will then find info about it in the all_articles variable.
  - `dates` - The same list of articles, but ordered by date, ascending.
  - `drafts` - The list of draft articles
  - `authors` - A list of (author, articles) tuples, containing all the authors and corresponding articles (values)
  - `categories` - A list of (category, articles) tuples, containing all the categories and corresponding articles (values)
  - `tags` - A list of (tag, articles) tuples, containing all the tags and corresponding articles (values)
  - `pages` - 	The list of pages
  - `hidde_pages` - The list of hidden pages
  - `draft_pages` - The list of draft pages
  
- You can use the following metadata while writing the header(metadata) section of an article:
  - `author` - The Author of this article.
  - `category` - 	The Category of this article.
  - `content` - The rendered content of the article.
  - `date` - Datetime object representing the article date.
  - `date_format` - Either default date format or locale date format.
  - `default_template` - Default template name. 
  - `in_default_lang` - Boolean representing if the article is written in the default language.
  - `lang` - Language of the article.
  - `locale_date` - Date formatted by the date_format.
  - `metadata` - 	Article header metadata dict.
  - `save_as` - Location to save the article page.
  - `slug` - Page slug
  - `source_path` - Full system path of the article source file.
  - `status` - The article status, can be any of ‘published’ or ‘draft’.
  - `summary` - Rendered summary content.
  - `tags` - List of Tag objects.
  - `title` - Title of the article
  
  ... and much more

 
<br>
<br>
<br>

# Tips
 
 
 
 
 
  
  
  
  
