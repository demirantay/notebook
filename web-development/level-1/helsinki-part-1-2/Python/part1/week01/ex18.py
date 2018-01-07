# grade and points

#ask for their grade
grade = int(input('what is your grade? '))

#give a mark
if grade > 0 and grade < 60:
    print('F')
elif grade < 70:
    print('D')
elif grade < 80:
    print('C')
elif grade < 90:
    print('B')
elif grade <= 100:
    print('A')
else:
    print('the number you typed is not in our systems.')
