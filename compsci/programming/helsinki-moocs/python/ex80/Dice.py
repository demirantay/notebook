from random import randint

class Dice:

    #constructor
    def __init__(self, number_of_sides):
        self.side_number = number_of_sides
        self.random_num = 0

    #behaviors

    #rolls the Dice
    def roll(self):
        self.random_num = randint(1, self.side_number)
        return self.random_num
