# exersice 32 week02
#the sum of a set of numbers

untilN = int(input('Until what? '))
sumNums = 0

i = 1
while i <= untilN:
    sumNums += i
    if i >= untilN:
        print('Sum of all : ',sumNums)
        break
    i += 1
