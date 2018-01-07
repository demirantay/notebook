#ex 61- 62week3 part1
#amount of items in a list

#self def funcs
def countItems(array):
    length = 0
    if array == []:
        return 'you need to put data in array'
    for i in array:
        length += 1
    return length

def remove_first(array):
    array.pop(0)

#main
def main():
    list = []
    list.append('hello')
    list.append('ciao')
    list.append('merhaba')

    print('There are this many items : ')
    print(countItems(list))

    remove_first(list)
    print(countItems(list))

main()
