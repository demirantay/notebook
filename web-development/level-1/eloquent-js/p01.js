//function chapter


//ex1

var min = function(number1, number2) {
  if (number1 < number2) {
    return number1;
  }
  else if (number2 < number1) {
    return number2;
  }
  else {
    return number1;
  }
}

//alert(min(10, 100));


//ex2

var countChar = function(counted_string, wanted_char) {
  count = 0;
  for (i = 0; i < counted_string.length; i++) {
    if (counted_string[i] === wanted_char) {
      count++;
    }
  }
  return count;
}

alert(countChar('kkk', 'k'));
