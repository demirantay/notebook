#include <stdio.h>
void sort( int length, int arr[length]);


int main(void) {
  int numbers[10];

  // ask for numbers from the user
  printf("Write 10 numbers: ");
  for (int i = 0; i < 10; i++) {
    scanf("%d", &numbers[i]);
  }

  // sort the array and than print it
  //

  return 0;
}


void sort(int length, int arr[length]) {
  int number = 0;
  int number_holder;

  for (int i = 0; i < 10; i++) {
    if (number < arr[i]) {
      number = arr[i];
    }
  }

}


// well i failed to implement a sorting algorith with recrusive stuff feels bad man
