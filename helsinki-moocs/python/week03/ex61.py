def count_items(array):
    amount = 0
    for i in range(0, len(array), 1):
        amount += 1
    return amount


new_list = []
new_list.append('halo')
new_list.append('ciao')
new_list.append('hello')

print('There are this amny items in the list', count_items(new_list))
