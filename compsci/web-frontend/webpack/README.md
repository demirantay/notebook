# Webpack 

- Reddit explanation:
  > ### 1
  > From a high level, webpack is used to minify and then bundle all your JS files together so your end users only need to download a single minified bundle.js file.
    
  > Not sure how familiar you are with NPM, but that is also a key part of the modern workflow. You'll use NPM to grab packages / libraries of code. In your JS, you'll use import statements to bring in those packages for use (such as jQuery).

  > You'll then have a webpack config file setup to look at your JS folder (wherever it might be) and it will take everything in there and bundle it appropriately. The webpack config uses "loaders" to determine how to minify and bundle js, css, etc. You'll also specify what folders to read and where to output everything.
  
  > Using NPM as a task runner, you can have webpack auto building your code, so anytime you make a change and save one of your JS files, it will auto rebuild and reload your page. This saves you a ton of time during development.
  
