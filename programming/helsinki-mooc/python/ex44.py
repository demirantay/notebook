def least(number1, number2):
    if number1 > number2 or number1 == number2 :
        return number2
    else:
        return number1


answer = least(2, 7)
print('Least: ', answer)
