#include <stdio.h>
int polynomial(int x);

int main(void) {
  int number, poly;

  printf("Type a number: ");
  scanf("%d", &number);

  poly = polynomial(number);

  printf("Polynomial of the number: %d\n", poly);

  return 0;
}

int polynomial(int x) {
  int number;
  number += (3 * (x*x*x*x*x)) + (2 + (x*x*x*x)) - (5 * (x*x*x)) - (x*x) + (7*x) - 6;
  return number;
}
a
