#include <stdio.h>

int main(void) {
  int x;

  printf("Type a number: ");
  scanf("%d", &x);

  if (x >= 0) {
    printf("The number %d is positive\n", x);
  }
  else {
    printf("The number %d is negative\n", x);
  }

  if (x % 2 == 0) {
    printf("And the number is EVEN\n");
  }
  else {
    printf("And the number is ODD\n");
  }

  return 0;
}
