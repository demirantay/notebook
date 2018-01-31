nums_sum = 0

while True:
    user_number = int(input('type a num: '))
    nums_sum += user_number

    if user_number == 0:
        print('sum in the end: ', nums_sum)
        break
    else:
        print('sum now: ', nums_sum)
