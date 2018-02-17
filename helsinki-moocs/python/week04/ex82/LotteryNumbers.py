from random import randint

class LotteryNumbers:

    #consturctor
    def __init__(self):
        self.numbers = []
        self.draw_numbers()

    #behaviors

    #getting the numbers
    def get_numbers(self):
        return self.numbers

    #drawing numbers from the bell glass
    def draw_numbers(self):
        for i in range(7):
            random_num = randint(1, 59)
            self.numbers.append(random_num)
