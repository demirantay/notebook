#include <stdio.h>
int power(int power, int number);

int main(void) {
  int x;

  printf("x: ");
  scanf("%d", &x);

  int polynomial = 3 * power(5, x) + 2 * power(4, x) - 5 * power(3, x)
                   - power(2, x) + 7 * x - 6;

  printf("Answer: %d\n", polynomial);

  return 0;
}

int power(int power, int number) {
  int result = 1;
  for (int i = 0; i < power; i++) {
    result *= number;
  }
  return result;
}
