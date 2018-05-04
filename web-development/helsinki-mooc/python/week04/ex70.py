def combine(arr1, arr2):
    arr1 += arr2
    return arr1

list1 = [1, 2, 3]
list2 = [4, 5, 6]

combine(list1, list2)

print('Combination is: ', list1)
print(list2)
