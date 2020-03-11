# Javascript API Cheatsheet

- XMLHttpRequest Quick Snippet:
  ```js
  let requestURL = 'https://mdn.github.io/learning-area/javascript/oojs/json/superheroes.json';
  let request = new XMLHttpRequest();
  request.open('GET', requestURL);
  request.responseType = 'json';
  request.send();

  request.onload = function() {
    const superHeroes = request.response;
    populateHeader(superHeroes);
    showHeroes(superHeroes);
  }
  ```

- Fetch API quick snippet:
  ```js
  fetch(url).then(function(result) {
    return result.json();
  }).then(function(json) {
    displayResults(json);
  });
  ```

- General Steps for API Usage:
  - 1 - Find the documentation
  - 2 - Get a developer key
  - 3 - Connect the API to your app
  - 4 - Requesting data from the API
  - 5 - Displaying the data
