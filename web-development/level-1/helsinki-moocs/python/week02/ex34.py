factorial_num = int(input('Type a number: '))

factorial_result = 1

for i in range(1, factorial_num+1):
    factorial_result = factorial_result * i

print('Factorial is ', factorial_result)
