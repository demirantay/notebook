#include <stdio.h>
#include <string.h>

int main(void) {
  char secret_key[6] = "qwerty";

  printf("secret password: ");
  char user_input[80] = "";
  scanf("%s", &user_input);

  if (strcmp(secret_key, user_input) == 0) {
    printf("You have accsess\n");
  }
  else {
    printf("move along stranger\n");
  }

  return 0;
}
