#ex 35
#Sum of the powers

print('Sum of Powers')

num = int(input('type a nubmer: '))
sum = 0

i = 0
while i < num:
    sum = sum + (num ** i)
    i += 1

print('Total sum: ', sum)
