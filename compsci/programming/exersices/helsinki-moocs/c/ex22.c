#include <stdio.h>
#include <string.h>

int main(void) {
  char password[7] = "qwerty";

  while (1) {
    printf("Password: ");
    char user_input[80];
    scanf("%s", &user_input);

    if (strcmp(user_input, password) == 0) {
      break;
    }
  }
  
  return 0;
}
