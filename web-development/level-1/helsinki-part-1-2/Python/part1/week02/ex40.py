#ex 40 week02 part1
#printing like a boss

#methods

def print_spaces(amount):
    print(' ' * amount, end='')

def printStars(amount):
    print('*' * amount)

def printTriangle(size):
    for i in range(size):
        print_spaces(size - i)
        printStars(i)

#main
printTriangle(10)
