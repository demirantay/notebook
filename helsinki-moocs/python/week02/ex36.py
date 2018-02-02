print('Type numbers:')

numbers_sum = 0
amount_of_numbers = 0
even_numbers = 0
odd_numbers = 0

while True:
    number = int(input(''))
    numbers_sum += number
    amount_of_numbers += 1
    if number % 2 == 0:
        even_numbers += 1
    else:
        odd_numbers += 1

    if number == -1:
        print('Thank you and see you later!')
        print('The sum is :', numbers_sum + 1)
        print('How many numbers :', amount_of_numbers - 1)
        print('Average : ', (numbers_sum + 1) / (amount_of_numbers - 1))
        print('Even numbers :', even_numbers)
        print('Odd numbers : ', odd_numbers - 1)
        break
    else:
        continue
