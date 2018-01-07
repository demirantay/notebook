class NumberStatistics:

    #consturctor
    def __init__(self):
        self.amount = 0
        self.value = 0

    #methods

    #adding a new number to statistic
    def add_number(self, number):
        self.value += number
        self.amount += 1

    #shows us how many numbers have been added
    def amount_of_numbers(self):
        return self.amount

    #returns the sum of added numbers
    def sum(self):
        return self.value

    #returns the average
    def average(self):
        return self.value / self.amount
