lower_limit = int(input('lower limit: '))
upper_limit = int(input('upper limit: '))

limits_sum = 0

for i in range(lower_limit-1, upper_limit+1, 1):
    limits_sum += lower_limit

print('The sum is ', limits_sum)
