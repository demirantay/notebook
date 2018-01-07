# age check
#checking if the age is reasonable

age = int(input('What is your age? '))

if age > 0 and age < 120:
    print('You are OK')
elif age < 0:
    print('Imporssible to have negative age dafuq')
elif age > 120:
    print('Did you forget to die')
