#bigger number
#ask for two numbers prints the bigger one

firstNum = int(input('number 1: '))
secondsNum = int(input('number 2 : '))

if firstNum > secondsNum:
    print('num1: ', firstNum, ' is bigger')
elif secondsNum > firstNum:
    print('num2: ', secondsNum, ' is bigger')
elif firstNum == secondsNum:
    print('numbers are equal')
else:
    print('you did something wrong')
