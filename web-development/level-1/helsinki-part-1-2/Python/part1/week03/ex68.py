#ex68 week03 par1
#is the number more than once in the list

#self def funcs
def more_than_once(array):
    for i in array:
        if array[i] in array:
            return True
    return False


#main
my_list = []
my_list.append(3)
my_list.append(2)
my_list.append(7)
my_list.append(3)

number_input = int(input('Type a number: '))
if more_than_once(array):
    print('there are two same leements')
else:
    print('everytinhg is unique')
