#check if the number is even

userNum = int(input('put a number: '))
remainder = userNum % 2

if remainder == 0:
    print('even')
else:
    print('odd')
