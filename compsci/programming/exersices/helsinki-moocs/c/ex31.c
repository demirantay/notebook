#include <stdio.h>
#include <string.h>

int main(void) {
  int first, last;

  //get first and last limit
  printf("First: ");
  scanf("%d", &first);
  printf("Last: ");
  scanf("%d", &last);

  // print out the numbers in between
  for (int i = first; i <= last; i++) {
    printf("%d\n", i);
  }

  return 0;
}
