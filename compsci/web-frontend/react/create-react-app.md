# Create React App

- This note file is about the `create-react-app` command of `React.js`. The are lots of things that I did not note on this subjet if you want a full overview of the program [read the official docs here](https://facebook.github.io/create-react-app/docs/documentation-intro)

<br>
<br>

# Getting Started

- Create React App is an officially supported way to create single-page React applications. It offers a modern build setup with no configuration.

  Quick Start:
  ```
  $ npx create-react-app my-app
  $ cd my-app
  $ npm start
  ```
  (npx comes with npm 5.2+ and higher)
  
  Then open http://localhost:3000/ to see your app.
  
- Note: You **don’t** need to install or configure tools like Webpack or Babel. They are preconfigured and hidden so that you can focus on the code. Just create a project, and you’re good to go.

- Inside the newly created project, you can run some built-in commands:
  - `npm start` - Runs the app in development mode. Open http://localhost:3000
  - `npm test` - Runs the test watcher in an interactive mode. By default, runs tests related to files changed since the last commit.
  - `npm run build` - Builds the app for production to the build folder. It correctly bundles React in production mode and optimizes the build for the best performance. Your app is ready to be deployed.

### Folder Structure

- After creation, your project should look like this:
  ```
  my-app/
    README.md
    node_modules/
    package.json
    public/
      index.html
      favicon.ico
    src/
      App.css
      App.js
      App.test.js
      index.css
      index.js
      logo.svg
  ```
  For the project to build, these files must exist with exact filenames:
    - `public/index.html` is the page template
    - `src/index.js` is the JavaScript entry point.
    
    You can delete or rename the other files except for the two above. <br> Note:  You need to put any JS and CSS files inside src, otherwise Webpack won’t see them.
  
<br>
<br>

---

<br>
<br>

# Development 

- Usually, in an app, you have a lot of UI components, and each of them has many different states. For an example, a simple button component could have the following states:
  - In a regular state, with a text label.
  - In the disabled mode.
  - In a loading state.
  
### Analyzing bundle size

- I do not understand this part now I will get back to it later ... doc link: https://facebook.github.io/create-react-app/docs/analyzing-the-bundle-size

### Using HTTPS in Development

- I do not understand this part now I will get back to it later ... doc link: https://facebook.github.io/create-react-app/docs/using-https-in-development

<br>
<br>

---

<br>
<br>

# Adding a Stylesheet

...

Re read the documentation and do it all again. 

