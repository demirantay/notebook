#include <stdio.h>
#include <stdlib.h>
int generate_random_number();

int main(void) {

  // create the matrix for the game
  int matrix[10][10] = {
    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
  };

  // generate random numbers on the matrix
  for (int i = 0; i < 25; i++) {
    int random_row = rand() % 11;      //generates a num between 0 - 20
    int random_column = rand() % 11;   //generates a num between 0 - 20
    int random_number = rand() % 10;
    matrix[random_column][random_row] = random_number;
  }

  // prints the whole matrix
  for (int i = 0; i < 10; i++) {
    for (int j = 0; j < 10; j++) {
      printf(" %d", matrix[i][j]);
    }
    printf("\n");
  }

  return 0;
}
