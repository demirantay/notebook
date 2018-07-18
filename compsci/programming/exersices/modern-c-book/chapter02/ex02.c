#include <stdio.h>

int main(void) {
  float radius;

  printf("Enter radius: ");
  scanf("%f", &radius);

  printf("Volume: %f\n", 4/3 * 3.1415 * (radius * radius * radius));

  return 0;
}
