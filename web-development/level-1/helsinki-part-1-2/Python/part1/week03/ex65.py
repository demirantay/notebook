#ex65 week3 part1
#the length of the string

#self funcs
def lengths(str):
    length_list = []
    length_list.append(str)
    return length_list

#main
my_array = []
my_array.append('waddup')
my_array.append('mi hombre es juan')
new_array = lengths(my_array)

print('new array', new_array)

modified = []
modified.append(1)
modified.append(2)
new_array += lengths(modified)

print('modified v.2: ',new_array )
