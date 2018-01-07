#ex41 week02 part1
#number guessing game

#imports
import random

#global vars
random_number = random.randint(0, 100)


#self methods
#...

#Main program
def main():
    guessed_time = 0

    while True:
        user_guess = int(input('Guess a number: '))
        guessed_time += 1

        if user_guess > random_number:
            print('The number is lesser, times guessed: ', guessed_time)
        elif user_guess < random_number:
            print('The number is greater, times guessed: ', guessed_time)
        elif user_guess == random_number:
            print('You found it, times guessed: ', guessed_time)
            break
        else:
            continue

main()
