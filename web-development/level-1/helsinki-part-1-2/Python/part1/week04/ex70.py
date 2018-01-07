#ex70 week 4 part1
#Combining array lists

#self def funcs
def combine(first_arr, second_arr):
    second_arr += first_arr

# main
firts_list = [1, 2, 3, 4]
second_list = [5, 6, 7, 8, 9]

combine(second_list, firts_list)

print('first list: ', firts_list)
print('second list: ', second_list)
