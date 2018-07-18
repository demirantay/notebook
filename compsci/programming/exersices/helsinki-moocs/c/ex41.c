#include <stdio.h>
#include <stdlib.h>
#include <string.h>
int generate_random_num();

//main program
int main(void) {  
    srand(time(NULL));
    int random_num = generate_random_num();
    int times_guessed = 0;
    
    while(1 > 0) {
        printf("Guess a number between 100-0: ");
        int user_guess;
        scanf("%d", &user_guess);
        times_guessed++;
        
        if (user_guess == random_num) {
            break;
        }
        else if (user_guess < random_num) {
            printf("Your guess is too low | times guessed: %d\n", times_guessed);
        }else  {
            printf("Your guess is too high | times guessed: %d\n", times_guessed);
        }
        
    }
    
    printf("Congrats you have won! times guessed : %d\n", times_guessed);
    
    return 0;
}

// generates random int
int generate_random_num() {
    return rand() % 101;
}