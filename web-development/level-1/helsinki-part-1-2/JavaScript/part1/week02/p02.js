//ex 30

/*
var limit = parseInt(prompt('Type the limit: '));

for (var i = 1; i <= limit; i++) {
  console.log(i);
}


//ex 31

var starting_point = parseInt(prompt('Type the starting point: '));
var ending_point = parseInt(prompt('Type the ending point: '));

for (var i = starting_point; i <= ending_point; i++) {
  console.log(i);
}

//ex 32
var sum = 0;
var number = parseInt(prompt('Until What: '))

for (var i = 0; i <= number; i++) {
  sum += i;
}

console.log(sum);


//ex 33

var sum = 0;
var lower_limit = parseInt(prompt('lower limit: '));
var upper_limit = parseInt(prompt('upper limit: '));

for (var i = lower_limit; i <= upper_limit; i++) {
  sum += i;
}

console.log(sum);


*/

//ex 34

var factorial = 1;
var factorial_number = parseInt(prompt('Type a number: '));

for (var i = 1; i <= factorial_number; i++) {
  factorial *= i;
}

console.log(factorial);
