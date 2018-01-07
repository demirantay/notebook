#ex 83 week 4 part1
#game logic of hangman

#imports
from HangmanLogic import *

#main logic
first_word = HangmanLogic('demir')
print('Guessing a, b, c, d, e')

first_word.guess_letter('a')
first_word.guess_letter('b')
first_word.guess_letter('c')
first_word.guess_letter('d')
first_word.guess_letter('e')

print('guessed letters: ', first_word.get_guessed_letters())
