#exerice 31 week 2
#Lower limit and upper limit

lowerLimit = int(input('lowerLimit: '))
upperLimit = int(input('upperLimit: '))

print('for loop')
for i in range(lowerLimit, upperLimit + 1):
    if lowerLimit > upperLimit:
        print('lower limit cannot be higher than upper limit')
        break
    print(i)



print('while loop')
while lowerLimit <= upperLimit:
    if lowerLimit > upperLimit:
        print('lower limit cannot be higher than upper limit')
        break
    print(lowerLimit)
    lowerLimit += 1
