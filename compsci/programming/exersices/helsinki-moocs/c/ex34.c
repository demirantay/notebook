#include <stdio.h>
#include <string.h>

int main(void) {
  int n = 0;
  int factorial = 1;

  // get user input
  printf("Type a number: ");
  scanf("%d", &n);

  // output the factorial of the user input
  for (int i = 1; i <= n; i++) {
    factorial *= i;
  }
  printf("Factorial: %d\n", factorial); 

  return 0;
}
