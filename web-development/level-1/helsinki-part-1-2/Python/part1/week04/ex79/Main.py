#ex 79 week4 part 1
#Number NumberStatistics

#imports
from NumberStatistics import *

#main program
stats = NumberStatistics()

stats.add_number(1)
stats.add_number(2)
stats.add_number(3)
stats.add_number(4)

amount = stats.amount_of_numbers()
sum_of_nums = stats.sum()
average_of_stats = stats.average()

print('Amount : ', amount)
print('Sum: ', sum_of_nums)
print('average : ', average_of_stats)
