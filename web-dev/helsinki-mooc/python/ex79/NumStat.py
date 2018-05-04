class NumStat:

    #consturcotr
    def __init__(self):
        self.sum_of_numbers = 0
        self.amount_of_numbers = 0
        self.average_of_nums = 0

    #behaviors
    def add_number(self, added_number):
        self.sum_of_numbers += added_number
        self.amount_of_numbers += 1

    def amount_of_numbers(self):
        return self.amount_of_numbers

    def sum_of_numbers(self):
        return self.sum_of_numbers

    def average(self):
        self.average_of_nums = (self.sum_of_numbers) / (self.amount_of_numbers)
        return self.average_of_nums
