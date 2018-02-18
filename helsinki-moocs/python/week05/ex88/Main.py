from Student import *

students = []

while True:
    user_name = input('Student name: ')
    user_number = input('Student number: ')
    new_user = Student(user_name, user_number)
    students.append(new_user)
    if user_name == '' and user_number == '':
        break

for i in range(0, len(students), 1):
    student = students[i].info()
    print(student)
