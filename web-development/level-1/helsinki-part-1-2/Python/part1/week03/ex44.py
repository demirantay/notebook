#ex 44 - 45 week 3 part 1
#Least

#global vars

#self def funcs
def least(number1, number2):
    if number1 > number2:
        return number2
    elif number1 < number2:
        return number1
    else:
        return number1

def greatest(num1, num2):
    if num1 > num2:
        return num1
    elif num1 < num2:
        return num2
    else:
        return num2


#MAIN
def main():
    first_input = int(input('Type a number: '))
    second_input = int(input('And another: '))

    leastNum = least(first_input, second_input)
    greatestNum = greatest(first_input, second_input)

    print('lesser number is :', leastNum)
    print('greater number is: ', greatestNum)



main()
