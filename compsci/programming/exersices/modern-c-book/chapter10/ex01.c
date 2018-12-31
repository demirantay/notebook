#include <stdio.h>
#include <stdlib.h>

int main(void) {
  int game_number = rand() % 101;
  int user_number;

  printf("Guess a number between 0 - 100 : \n");
  while(1) {
    scanf("%d", &user_number);

    if(user_number > game_number) {
      printf("Too damn HIGH\n");
    }
    else if (user_number < game_number) {
      printf("Too damn LOW\n");
    }
    else if (user_number == game_number) {
      printf("You WON!!!\n");
      break;
    }
  }

  return 0;
}
