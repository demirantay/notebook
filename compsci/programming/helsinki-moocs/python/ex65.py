def greatest(array):
    greatest = 0
    for i in range(0, len(array), 1):
        if array[i] > greatest:
            greatest = array[i]
        else:
            continue
    return greatest

my_list = [1, 2, 3, 3, 4, 5, 6]

print('Greatest value in my list: ', greatest(my_list))
