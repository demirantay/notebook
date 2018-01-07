#leap a year

year = int(input('Type a year: '))

if year % 4 == 0 and year % 100 == 0 and year % 400 == 0:
    print('it is a leap year')
else:
    print('it is NOT a leap')
