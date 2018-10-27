#include <stdio.h>

int main(void) {
  char text;
  int number;

  printf("Type your name: ");
  while(1) {
    scanf("%c", &text);
    number += text;
    if (text == '\n') {
      break;
    }
  }

 /*** FUCK CHAPTER 7 ***/
  return 0;
}
