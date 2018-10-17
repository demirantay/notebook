#include <stdio.h>

int main(void) {
  int hour, minute;

  printf("Enter a 24 hour time: ");
  scanf("%d:%d", &hour, &minute);

  switch (hour) {
    case 24: case 1: case 2: case 3: case 4: case 5:
    case 6: case 7: case 8: case 9: case 10: case 11:
             printf("Equivlient 12-hour time: %d:%d AM\n", hour, minute);
             break;
    case 12: case 13: case 14: case 15: case 16: case 17:
    case 18: case 19: case 20: case 21: case 22: case 23:
             printf("Equivlient 12-hour time: %d:%d PM\n", hour, minute);
             break;
    default: printf("Invalid hour\n");
             break;
  }
  
  return 0;
}
