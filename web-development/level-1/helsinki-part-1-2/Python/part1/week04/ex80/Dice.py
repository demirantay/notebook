#imports for generating a random num
from random import randint

class Dice:

    #constructor
    def __init__(self, number_of_sides):
        self.side_number = number_of_sides

    #methods = behaviors
    def roll(self):
        return randint(1, self.side_number)
