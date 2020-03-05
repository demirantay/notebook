# JSON API development with JavaScript

- For quick code snippet reference:
  ```js
  var request = new XMLHttpRequest()

  request.open('GET', 'https://ghibliapi.herokuapp.com/films', true)
  
  request.send()
  
  request.onload = function() {
    // Begin accessing JSON data here
    var data = JSON.parse(this.response)

    if (request.status >= 200 && request.status < 400) {
      data.forEach(movie => {
        console.log(movie.title)
      })
    } else {
      console.log('error')
    }
  }
  ```
  OR FETCH API CUZ THIS IS DEPRECATED
