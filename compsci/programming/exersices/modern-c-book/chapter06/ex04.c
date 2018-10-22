#include <stdio.h>

int main(void) {
  float n;
  float e = 1;

  printf("Enter a number: ");
  scanf("%f", &n);

  for (float i = 1; i <= n; i++) {
    float factorial = 1.0;
    for (float j = 1; j <= i; j++) {
      factorial *= j;
    }
    e += 1/factorial;
  }

  printf("e of (n) is : %.2f\n", e);

  return 0;
}
