# Bootstrap

- Twitter Bootstrap is the most popular front end framework in the recent time. It is sleek, intuitive, and powerful mobile first front-end framework for faster and easier web development. It uses HTML, CSS and Javascript.

- You do not need to download bootstrap to your envorienment (even if you can) it is recommended to use CDN and fetch the code directly from twitters bootstrap servers. Just go to their [CDN page](https://www.bootstrapcdn.com/)(you may need to update the cdn's since at the time of writing this the frameowkr will probably imporve its version) and isert the tags like this:
  ```html
  <head>
    ...
    <!-- Bootstrap CSS cdn -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
  </head>
  
  <body>
    ...
    <!-- Bootstrap JS cdns -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js></script>
  </body>
  ```
  
  - What Bootstrap pacakages include:
    - `Scaffolding` − Bootstrap provides a basic structure with Grid System, link styles, and background.
    - `CSS` − Bootstrap comes with the feature of global CSS settings, fundamental HTML elements styled and enhanced with extensible classes, and an advanced grid system.
    - `Components` − Bootstrap contains over a dozen reusable components built to provide iconography, dropdowns, navigation, alerts, pop-overs, and much more.
    - `JavaScript Plugins` − Bootstrap contains over a dozen custom jQuery plugins. You can easily include them all, or one by one.
    - `Customize` − You can customize Bootstrap's components, LESS variables, and jQuery plugins to get your very own version.
    
    
 <br>
 <br>
 <br>
 
 # Grid System
 
 - To put in simple words, grids in web design organise and structure content, makes the websites easy to scan and reduces the cognitive load on users.
 
 - As put by the official documentation of Bootstrap for grid system −
    > Bootstrap includes a responsive, mobile first fluid grid system that appropriately scales up to 12 columns as the device       or viewport size increases. It includes predefined classes for easy layout options, as well as powerful mixins for             generating    more semantic layouts.
    
    Let us understand the above statement. Bootstrap 3 is mobile first in the sense that the code for Bootstrap now starts by targeting smaller screens like mobile devices, tablets, and then “expands” components and grids for larger screens such as laptops, desktops.
    
 - Mobile First Strategy :
 
   - Content:
      - Determine what is most important.
   - Layout:
      - Design to smaller widths first.
      - Base CSS address mobile device first; media queries address for tablet, desktops.
   - Progressive Enchantment:
      - Add elements as screen size increases.
      
- For above layout you can base yourself with the following pixels:
  - Extra small devices (phones, less than 768px)  -- (max column width: Auto / divided into 12 col)
  - Small devices (tablets, 768px and up) -- (max column width:  60px / divided into 12 col)
  - Medium devices (desktops, 992px and up) -- (max column width: 78px / divided into 12 col)
  - Large devices (large desktops, 1200px and up) -- (max column width: 95px / divided into 12 col)
  
  Note: Remember try not give more than 15px of padding inside the columns.
    
 
- Grid systems are used for creating page layouts through a series of rows and columns that house your content. Here's how the Bootstrap grid system works −
  - Rows must be placed within a `.container` class for proper alignment and padding.
  - Use rows to create horizontal groups of columns.
  - Content should be placed within the columns, and only columns may be the immediate children of rows.
  - Predefined grid classes like `.row` and `.col-xs-4` are available for quickly making grid layouts.
  - Columns create gutters (gaps between column content) via padding. That padding is offset in rows for the first and the last column via negative margin on `.rows`
  - Grid columns are created by specifying the number of twelve available columns you wish to span. For example, three equal columns would use three `.col-xs-4`
  
- Lets see a basic structure of the bootstrap grid:
  ```html
  <div class="container">
  
    <div class="row">
      <div class="col-xs-6">
      <div class="col-xs-6>
    </div>
  
    <div class="row">...</div>
  
  </div>
  ```
  While developing for multiple screens remember you can give column multiple size classes like this:
  ```html
  <div class="col-xs-1 col-sm-3 col-md-6 col-lg-8"> ...
  ```
  
- While developing bootstrap you will sometimes run into bugs in overlapping not sizing properly problems inside your grid system, before you attempt anything just write this simple code in between the columns that has the problem:
  ```html
  <div class="col-**"> ... </div>
   
  <div class = "clearfix visible-xs"></div>
      
  <div class="col-**"> ... </div>
  ```
  If this does not work then try debugging it on your own
  
- You can nest columns inside a column like this:
  ```html
  <div class="row">
    <div class="col-md-12">
      <div class="row">
        <div class="col-md-6">...</div>
        <div class="col-md-6">...</div>
      </div>
    </div>
  </div>
  ```
  
- There are much more to learn about the grid system in bootstrap. Go figure it, the link below is just a good starting point:
  - https://www.tutorialspoint.com/bootstrap/bootstrap_grid_system.htm
  
<br>
<br>
<br>
<br>

# CSS Overview

- Bootstrap makes use of certain HTML elements and CSS properties that require the use of the HTML5 doctype. Do not ferget to include it at the top of your webpage:
  ```html
  <!DOCTYPE html>
  ...
  ```
  
- Since Bootstrap 3 has been launched, Bootstrap has become mobile first. It means 'mobile first' styles can be found throughout the entire library instead of them in separate files. You need to add the viewport meta tag to the <head> element, to ensure proper rendering and touch zooming on mobile devices.
  ```html
  <meta name = "viewport" content = "width = device-width, initial-scale = 1.0">
  ```
  Add user-scalable = no to the content attribute to disable zooming capabilities on mobile devices as shown below. Users are only able to scroll and not zoom with this change, and results in your site feeling a bit more like a native application. So the code will be actually (note bootstrap does not recomment this attribute):
  ```html
  <meta name = "viewport" content = "width = device-width, initial-scale = 1.0, maximum-scale = 1.0, user-scalable = no">
  ```
  
<br>
<br>
<br>

# Typography

- There are many things you can do with the typagrahy in bootstrap. The most commonly used ones that come to my minde are:
  ```html
  class="text-center"
  class="text-warning"
  class="text-info"
  class="list-inline"
  ...
  ```
  
- You can check out most of the typography stuff from the documentation but before doing that definelty read this first:
  - https://www.tutorialspoint.com/bootstrap/bootstrap_typography.htm
  
<br>
<br>
<br>

# Buttons

- You can easily create buttons with bootstrap and give them colors by assagning warning, succsess, info ...etc.
  ```html
  <a href=".." class="btn btn-success">
  ```
  You can change the buttons size with:
  ```html
  <a href=".." class="btn btn-lg">
  ```
  
- There are much more you can do check out the official docs. But before you do it you can start by reading this awsome tutorial:
  - https://www.tutorialspoint.com/bootstrap/bootstrap_buttons.htm
  
<br>
<br>
<br>

# Images 

- Bootstrap provides you 3 types of image classes and they are self explanatory from their class names:
  ```html
  <img class = "img-rounded">
  <img class = "img-circle">
  <img class = "img-thumbnail">
  ```

<br>
<br>

---

# Other Bootstrap CSS Pointers

As I said many times there are lot of things in bootstrap that cannot be covered in a single note file. For more info on Bootstraps `CSS` check out the documentation plus you can start reading these awsome tutorials:
  - `Code` - https://www.tutorialspoint.com/bootstrap/bootstrap_code.htm
  - `Tables` - https://www.tutorialspoint.com/bootstrap/bootstrap_tables.htm
  - `Forms` - https://www.tutorialspoint.com/bootstrap/bootstrap_forms.htm
  - `Helpers` - https://www.tutorialspoint.com/bootstrap/bootstrap_helper_classes.htm
  - `Responsivness` -  https://www.tutorialspoint.com/bootstrap/bootstrap_responsive_utilities.htm
  
<br>
<br>
<br>
<br>

# Bootstrap Layout Components

- I cannot note all of these components in a single or two note files. These are just references to what you can with each og the component, instead of noting everything I am just going to provide pointer to the relative tutorials for future use.

- Layout Components:
  - `Glyphicons` - You can add icons to your links, buttons, paragraphs ... etc. [Click here for more info](https://www.tutorialspoint.com/bootstrap/bootstrap_glyphicons.htm)
  - `Drop Downs` - This will help you create a drop down menu without having to deal with javascripts display on and off. It is just a one simple class [Click here for more info](https://www.tutorialspoint.com/bootstrap/bootstrap_dropdowns.htm)
  - `Button Groups` - Button groups allow multiple buttons to be stacked together on a single line.  [Click here for more info](https://www.tutorialspoint.com/bootstrap/bootstrap_button_groups.htm)
  - `Button Dropdowns` - These classes let you have a drop down menu for your buttons. [Click here for more info]
  - `Input Groups` - You can edit your inputs with these calsses. [Click here for more info](https://www.tutorialspoint.com/bootstrap/bootstrap_input_groups.htm)
  - `Navigation Elements` - You can edit the navigation elements esaily. [Click here for more info](https://www.tutorialspoint.com/bootstrap/bootstrap_navigation_elements.htm)
  - `Navbar` - Instead of the navs elements you can edit the nav iteslf too. [Click here for more info](https://www.tutorialspoint.com/bootstrap/bootstrap_navbar.htm)
  - `Pagination` - pagination is mostly adding links to your pages down below. [Click here for more info](https://www.tutorialspoint.com/bootstrap/bootstrap_pagination.htm) 
  - `Label` - styling labels help us understand what is info, danger, warning etc. [Click here for more info](https://www.tutorialspoint.com/bootstrap/bootstrap_labels.htm)
  - `Badges` - You can create badges like notifications alert, message numbers etc. [Click here for more info](https://www.tutorialspoint.com/bootstrap/bootstrap_badges.htm)
  - `Jumbotron` -  This is used mostly for welcome banners at the top of the page. [Click here for more info](https://www.tutorialspoint.com/bootstrap/bootstrap_jumbotron.htm)
  - `Thumbnail` - A lot of sites need a way to lay out images, videos, text, etc, in a grid. [Click here for more info](https://www.tutorialspoint.com/bootstrap/bootstrap_thumbnails.htm)
  - `Alerts` - Alerts provide a way to style messages to the user. [Click here for more info](https://www.tutorialspoint.com/bootstrap/bootstrap_alerts.htm)
  - `Progress Bars` - The purpose of progress bars is to show that assets are loading, in progress. [Click here for more info](https://www.tutorialspoint.com/bootstrap/bootstrap_progress_bars.htm)
  - `Media Object` - These are abstract object styles for building various types of components (like blog comments, Tweets, etc.) that feature a left-aligned or right-aligned image alongside the textual content. [Click here for more info](https://www.tutorialspoint.com/bootstrap/bootstrap_media_object.htm)
  - `List Group` -  The purpose of list group component is to render complex and customized content in lists. To get a basic list group. [Click here for more info](https://www.tutorialspoint.com/bootstrap/bootstrap_list_group.htm)

<br>
<br>
<br>

# Plugins Overview

- The components discussed in the previous chapters under Layout Components are just the beginning. Bootstrap comes bundled with 12 jQuery plugins that extend the features and can add more interaction to your site.

- All plugins depend on jQuery. So jQuery must be included before the plugin files. Check bower.json to see which versions of jQuery are supported.

- All of the Bootstrap plugins are accessible using the included Data API. Hence, you don’t need to include a single line of JavaScript to invoke any of the plugin features.
  
  In some situations it may be desirable to turn this functionality of Data API off. If you need to turn off the Data API, you can unbind the attributes by adding the following line of JavaScript −
  ```js
  $(document).off('.data-api')
  ```
  To turn off a specific/single plugin, just include the plugin's name as a namespace along with the data-api namespace like this −
  ```js
  $(document).off('.alert.data-api')
  ```
  
- There are many plugins so it is not possible to note them all down in a single file. Instead like I did above I will list them with their respective headers and links to tutorials that teach it better:
  - `Transition Plugin` - The transition plugin provides a simple transition effects. [Click here for more info](https://www.tutorialspoint.com/bootstrap/bootstrap_transition_plugin.htm)
  - `Modal Plugin` - A modal is a child window that is layered over its parent window. Typically, the purpose is to display content from a separate source that can have some interaction without leaving the parent window. Child windows can provide information, interaction, or more. [Click here for more info](https://www.tutorialspoint.com/bootstrap/bootstrap_modal_plugin.htm)
  - `Dropdown Plugin` - Using Dropdown plugin you can add dropdown menus to any components like navbars, tabs, pills and buttons. [Click here for more info](https://www.tutorialspoint.com/bootstrap/bootstrap_dropdown_plugin.htm)
  - `Scrollspy Plugin` - The Scroll spy (auto updating nav) plugin allows you to target sections of the page based on the scroll position. [Click here for more info](https://www.tutorialspoint.com/bootstrap/bootstrap_scrollspy_plugin.htm)
  - `Tab Plugin` - Tabs were introduced in the chapter Bootstrap Navigation Elements. By combining a few data attributes, you can easily create a tabbed interface. With this plug-in you can transition through panes of local content in tabs or pills, even via drop down menus. [Click here for more info](https://www.tutorialspoint.com/bootstrap/bootstrap_tab_plugin.htm)
  - `Tooltip Plugin` - Tooltips are useful when you need to describe a link. [Click here for more info](https://www.tutorialspoint.com/bootstrap/bootstrap_tooltip_plugin.htm)
  - `Popover Plugin` - The popover is similar to tooltip, offering an extended view complete with a heading. For the popover to activate, a user just needs to hover the cursor over the element. [Click here for more info](https://www.tutorialspoint.com/bootstrap/bootstrap_popover_plugin.htm)
  - `Alert Plugin` - Alert messages are mostly used to display information such as warning or confirmation messages to the end users. [Click for more info](https://www.tutorialspoint.com/bootstrap/bootstrap_alert_plugin.htm)
  - `Button Plugin` - With this plugin you can add in some interaction such as control button states or create groups of buttons for more components like toolbars. [Click here for more info](https://www.tutorialspoint.com/bootstrap/bootstrap_button_plugin.htm)
  - `Collapse Plugin` - The collapse plugin makes it easy to make collapsing divisions of the page. Whether you use it to build an accordion navigation or content boxes, it allows for a lot of content options. [Click here for more info](https://www.tutorialspoint.com/bootstrap/bootstrap_collapse_plugin.htm)
  - `Carousel Plugin` - The Bootstrap carousel is a flexible, responsive way to add a slider to your site. In addition to being responsive, the content is flexible enough to allow images, iframes, videos, or just about any type of content that you might want. [Click here for more info](https://www.tutorialspoint.com/bootstrap/bootstrap_carousel_plugin.htm)
  - `Affix Plugin` - The affix plugin allows a <div> to become affixed to a location on the page. You can also toggle it's pinning on and off using this plugin. A common example of this are social icons. They will start in a location, but as the page hits a certain mark, the <div> will be locked in place and will stop scrolling with the rest of the page. [Click here for more info](https://www.tutorialspoint.com/bootstrap/bootstrap_affix_plugin.htm)
  

  
  
