# ex64 week 3 part1
#Average of numbers
def average(array):
    total_sum = 0
    arr_length = 0
    for i in range(len(array)):
        total_sum += array[i]
        arr_length += 1
    average = total_sum / arr_length
    return average

#main
my_list = [3, 2, 7, 2]
print('average is ', average(my_list))
