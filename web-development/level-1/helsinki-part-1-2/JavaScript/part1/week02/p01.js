/*
// exersice 25

var exersice_25 = function() {

  var sum = 0;

  for (i = 0; i < 3 ; i++){
    var input_number = parseInt(prompt('Type a number: '));
    sum += input_number;
  }

  alert('Sum is :'+ sum);
}
exersice_25();

//------------------------------

//exersice 26

var sum = 0;

while (true) {
  var number = parseInt(prompt('Type a number: '));

  if (number === 0) {
    alert('sum in the end is '+ sum);
    break;
  }

  sum += number;

  alert('The sum is now: '+ sum);
}

//---------------------------------

//exersice 27

for (i = 0; i < 101; i++) {
  console.log(i);
}


///--------------------------------

//exersice 28

for (i = 100; i > -1; i--) {
  alert(i);
}
*/

//--------------------------------

//exersice 29

for (i = 0; i < 101; i += 2) {
  console.log(i);
}
