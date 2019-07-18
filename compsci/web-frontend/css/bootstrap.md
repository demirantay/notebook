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
    
 
- Grid systems are used for creating page layouts through a series of rows and columns that house your content. Here's how the Bootstrap grid system works −
  - Rows must be placed within a `.container` class for proper alignment and padding.
  - Use rows to create horizontal groups of columns.
  - Content should be placed within the columns, and only columns may be the immediate children of rows.
  - Predefined grid classes like `.row` and `.col-xs-4` are available for quickly making grid layouts.
  - Columns create gutters (gaps between column content) via padding. That padding is offset in rows for the first and the last column via negative margin on `.rows`
  - Grid columns are created by specifying the number of twelve available columns you wish to span. For example, three equal columns would use three `.col-xs-4`
  
  
  
  
  
