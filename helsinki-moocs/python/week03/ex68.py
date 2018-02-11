new_list = [1, 2, 3, 4, 5, 6]

user_input = int(input('Type a number: '))

if user_input in new_list:
    print('The list already contains the number you input')
    print(new_list)
else:
    new_list.append(user_input)
    print(new_list)
