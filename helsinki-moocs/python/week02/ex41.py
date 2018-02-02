import random

random_number = random.randint(1, 1000)
guesses_made = 0

while True:
    guess = int(input('Guess a number: (1-1000)'))
    guesses_made += 1

    if guess == random_number:
        print('Congrats, your guess is correct!')
        break
    elif guess > random_number:
        print('your guess is too BIG')
        print('number of guesses: ', guesses_made)
    elif guess < random_number:
        print('your guess is too SMALL')
        print('number of guesses', guesses_made)
    else:
        continue
