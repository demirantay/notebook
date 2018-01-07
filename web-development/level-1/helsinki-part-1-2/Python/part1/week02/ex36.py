#ex 36
#loops , ending and remembering

print('Type Numbers: ')

#global vars
sum = 0
numbers_typed = 0
nums_average = 0
even_numbers = 0
odd_numbers = 0

#program
while True:
    userNum = int(input())
    if userNum % 2 == 0:
        even_numbers += 1
    else:
        odd_numbers += 1
    sum += userNum
    numbers_typed += 1
    if userNum == -1:
        sum += 1
        numbers_typed -= 1
        odd_numbers -= 1
        break

nums_average = sum / numbers_typed

#output
print('Thank you and see you later!')
print('Sum is : ', sum)
print('Nubers typed: ', numbers_typed )
print('The average is: ', nums_average)
print('Even numbers: ', even_numbers)
print('Odd numbers: ', odd_numbers)
