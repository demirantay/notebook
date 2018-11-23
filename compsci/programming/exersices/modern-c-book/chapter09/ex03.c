#include <stdio.h>
#include <stdlib.h>

#define true 1;
#define false 0;
typedef int bool;

int roll();

// main function
int main(void) {
  bool game_is_won = false;

  // main game loop
  do {
    int dice_1 = roll();
    int dice_2 = roll();
    int sum = dice_1 + dice_2;

    if (sum == 7 || sum == 11) {
      game_is_won = true;
    }
    else if (sum == 9) {
      game_is_won = false;
    }

  }while (true)

  return 0;
}

int roll() {
  return rand() * 7;
}


/////////IM BORED AINT GONNA DO THIS EXERSICE NO MO'//////////////////
