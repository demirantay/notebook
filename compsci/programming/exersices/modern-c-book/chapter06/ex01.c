#include <stdio.h>

int main(void) {
  float largest_n = 0.0;

  while(1) {
    float number;

    printf("Enter a number: ");
    scanf("%f", &number);

    if (number > largest_n) {
      largest_n = number;
    }else if (number == 0.0) {
      break;
    }
  }

  printf("Largest number is: %f\n", largest_n);

  return 0;
}
