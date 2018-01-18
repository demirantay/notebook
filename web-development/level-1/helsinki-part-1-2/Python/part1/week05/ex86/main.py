#lyrra card
#ex 86 part1 week 5

#imports
from lyrra import *

#self funcs

#main
card_of_demir = lyrra(10)

print('money on the card', card_of_demir.balance )
paying_8 = card_of_demir.pay(8)
print('money taken : ', paying_8)
print('money on the card: ', card_of_demir.balance )

paying_4 = card_of_demir.pay(4)
print('money taken: ', paying_4)
print('money on the card', card_of_demir.balance )
