#include <stdio.h>
#include <string.h>

int main(void) {
  int sum = 0;
  int user_number;

  // main program
  while (0 < 1) {
    printf("Type a number: ");
    scanf("%d", &user_number);
    sum += user_number;

    printf("\nThe sum now: %d\n", sum);

    if (user_number == 0) {
      break;
    }
  }

  return 0;
}
