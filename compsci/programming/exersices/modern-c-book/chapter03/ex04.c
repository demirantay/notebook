#include <stdio.h>

int main(void) {
  int _1, _2, _3, _4, _5, _6, _7, _8, _9, _10, _11, _12, _13, _14, _15, _16;

  printf("Enter numbers from 1 to 16 in any order: \n");
  scanf("%d %d %d %d %d %d %d %d %d %d %d %d %d %d %d %d", &_1, &_2, &_3, &_4,
      &_5, &_6, &_7, &_8, &_9, &_10, &_11, &_12, &_13, &_14, &_15, &_16);

  printf("%d %d %d %d\n", _1, _2, _3, _4);
  printf("%d %d %d %d\n", _5, _6, _7, _8);
  printf("%d %d %d %d\n", _9, _10, _11, _12);
  printf("%d %d %d %d\n", _13, _14, _15, _16);

  int row_1 = _1 + _2 + _3 + _4;
  int row_2 = _5 + _6 + _7 + _8;
  int row_3 = _9 + _10 + _11 + _12;
  int row_4 = _13 + _14 + _15 + _16;

  printf("Rows sums: %d %d %d %d\n", row_1, row_2, row_3, row_4);

  int col_1 = _1 + _5 + _9 + _13;
  int col_2 = _2 + _6 + _10 + _14;
  int col_3 = _3 + _7 + _11 + _15;
  int col_4 = _4 + _8 + _12 + _16;

  printf("Col sums: %d %d %d %d\n", col_1, col_2, col_3, col_4);

  int diagonal = _1 + _6 + _11 + _16;

  printf("Diagonal sum: %d\n", diagonal);

  return 0;
}
