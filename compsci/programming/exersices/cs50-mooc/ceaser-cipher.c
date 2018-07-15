#include <stdio.h>
#include <string.h>

int main(void) {
  char user_input[80];

  // get the user input to cipher
  printf("plaintext: ");
  scanf("%s", &user_input);

  // print the ciphered text
  printf("cipher-text: ");
  for (int i = 0; i < strlen(user_input); i++) {
    printf("%c", ((int) user_input[i] + 1));
  }
  printf("\n");

  return 0;
}
