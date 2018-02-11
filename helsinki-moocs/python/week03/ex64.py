def average(array):
    array_items_sum = 0

    for i in range(0, len(array), 1):
        array_items_sum += array[i]

    average = array_items_sum / len(array)

    return average



number_list = [3, 2, 7, 2]

print('The average is: ', average(number_list))
