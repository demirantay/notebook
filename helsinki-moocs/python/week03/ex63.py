def sum_list(array):
    items_sum = 0
    for i in range(0, len(array), 1):
        items_sum += array[i]
    return items_sum

my_list = [0, 3, 5, 2]

print('The sum: ', sum_list(my_list))

my_list.append(10)

print('The sum: ', sum_list(my_list))
