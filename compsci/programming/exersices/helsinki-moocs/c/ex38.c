#include <stdio.h>
#include <string.h>
// my methods
void print_text();

int main(void) {
  int n;
  printf("How many times: ");
  scanf("%d", &n);

  for (int i = 0; i <= n; i++) {
    print_text();
  }

  return 0;
}

void print_text() {
  printf("WADDDDDUAPDUASPDASUD wADDDDUPP\n");
}
