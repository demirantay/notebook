#ex 34
#Factorial

print('Facotring')

inputNum = int(input('Type a number: '))
sumNum = 1

if inputNum == 0:
    print('Sum is : 1')

i = 1
while i <= inputNum:
    sumNum *= i
    if i >= inputNum:
        print('Sum is : ', sumNum )
        break
    i += 1
