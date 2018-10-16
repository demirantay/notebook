#include <stdio.h>

int main(void) {

  int number;

  printf("Type positive a number: ");
  scanf("%d", &number);

  if (number < 10) {
    printf("The %d has 1 digits\n", number);
  }
  else if (number < 100) {
    printf("The %d has 2 digits\n", number);
  }
  else if (number < 1000) {
    printf("The %d has 3 digits\n", number);
  }
  else if (number < 10000) {
    printf("The %d has 4 digits\n", number);
  }
  else {
    printf("The number you entered is invalid\n");
  }

  return 0;
}
