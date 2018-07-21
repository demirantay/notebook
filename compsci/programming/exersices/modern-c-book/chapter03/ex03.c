#include <stdio.h>

int main(void) {
  int country, gsm, identifier;

  printf("Enter a phone num : [ (xxx) xxx-xxxx ] : ");
  scanf("%d %d %d", &country, &gsm, &identifier);

  printf("(%d) %d-%d\n", country, gsm, identifier);

  return 0;
}
