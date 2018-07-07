#include <stdio.h>

int main(void) {
  int x, y;

  printf("x: ");
  scanf("%d", &x);

  printf("y: ");
  scanf("%d", &y);

  printf("%d + %d added : %d\n", x, y, x + y);
  printf("%d * %d multiplied : %d\n", x, y, x * y);
  printf("%d - %d subtract : %d\n", x, y, x - y);
  printf("%d / %d divided : %d\n", x, y, x / y);

  if (x > y) {
    printf("%d is bigger than %d\n", x, y);
  }
  else if (y > x) {
    printf("%d is bigger than %d\n", y, x);
  }
  else {
    printf("x and y are equals : %d\n", x);
  }

  printf(
    "If the radius is x:%d then the circumfrence is %f\n", x, x * 2 * 3.14
  );

  return 0;
}
