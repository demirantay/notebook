//ex 35

/*
var sum = 1;

var power = parseInt(prompt('Type a number: '));

for (var i = 1; i <= power; i++) {
  sum += Math.pow(2, i);
}

console.log(sum);
*/

//ex 36

/*
var sum = 0;
var number_count = 0
var average;

while(true) {
  var number = parseInt(prompt('Type numbers: '));
  number_count++;
  sum += number;
  if (number === -1) {
    console.log('Thank you and see you later');
    console.log('The sum is : ' + (sum + 1));
    console.log('You typed this many number: ' + (number_count - 1));
    break;
  }
}

console.log('Average : ' + (sum + 1 / number_count - 1));


//ex 37

var print_text= function(amount) {
  for (i = 0; i < amount; i++) {
    alert('In the begining there was swamp, joe and javascript');
  }
}

var amount = parseInt(prompt('How many times: '));
print_text(amount);


*/


//ex 39

var print_stars = function(amount) {
  var stars = '';
  for (let i = 0; i < amount; i++) {
    stars += '*';
  }
  document.write(stars + '<br>');
}

var print_square = function(side_size) {
  for (var i = 0; i < side_size; i++) {
    print_stars(4);
  }
}

var print_rectangle = function(width, height) {
  for (var i = 0; i < height; i++) {
    print_stars(width);
  }
}

print_triangle(5);
