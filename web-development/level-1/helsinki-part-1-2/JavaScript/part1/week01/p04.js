//exersice 21

/*
var year = parseInt(prompt('Type the year: '));

if (year % 4 === 0 && year % 100 === 0) {
  alert('It is a leap year');
}
else {
  alert('It is NOT a leap year');
}

*/

// ================================

//exersice 22
var secret_message = 'Hi';
var password = 'abc'

while (true) {
  var input_password = prompt('Type password ');

  if (input_password === password) {
    alert(secret_message)
    break;
  }
}
