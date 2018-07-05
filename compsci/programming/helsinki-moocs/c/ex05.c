#include <stdio.h>

int main(void) {
  // figure out how mand days are in a year
  int days = 365;
  int hours = 24 * days;
  int minutes = 60 * hours;
  int seconds = 60 * minutes;

  printf("There are %d seconds in a year", seconds);

  return 0;
}
