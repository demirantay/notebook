'use strict';

/*
//exersice 16

var number = parseInt(prompt('type a number'));

if (number % 2 === 0) {
  alert('number is even');
} else {
  alert('number is odd');
}

//=============================================

//exersice 17
//passing this exersice because I have already done it earlier

//===========================================

//exersice 18

var grade = parseInt(prompt('type your grade: '));

if (grade >= 90) {
  alert('A');
} else if (grade >= 80) {
  alert('B');
} else if (grade >= 70) {
  alert('C');
} else if (grade >= 60) {
  alert('D');
} else {
  alert('F');
}
*/

//===========================================

//exersice 19

var age = parseInt(prompt('What is your age ? '));

if (age > 0 && age < 120) {
  alert('OK');
}
else {
  alert('It is impossible');
}

//=============================================

//exersice 20

var username = 'demir';
var password = 123456;

var input_username = prompt('Username: ');
var input_password = parseInt(prompt('Password: '));

if (username === input_username && input_password === password) {
  alert('Hello Demir...');
}
else {
  alert('Wrong password or username');
}

//=============================================
