lower_limit = int(input('First: '))
upper_limit = int(input('Last: '))

for i in range(lower_limit, upper_limit+1, 1):
    if lower_limit > upper_limit:
        print('First cannot be greater than the seconds')
    else:
        print(i)
