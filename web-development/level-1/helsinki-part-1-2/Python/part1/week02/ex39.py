#ex 39 week02 part1
#Printing stars

#methods
def printStars(amount):
    print('*' * amount)

def printSquare(side_size):
    for i in range(side_size):
        print('***')

def printRect(width, height):
    for i in range(height):
        print('*' * width)

def printTriangle(size):
    for i in range(size):
        printStars(i)


#Main
printStars(9)
print('')
printSquare(3)
print('')
printRect(10, 5)
print('')
printTriangle(10)
