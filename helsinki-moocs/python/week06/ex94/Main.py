from Person import Person

demir = Person('demir', '123123123')

print(demir.get_name())
print(demir.get_number())

demir.change_number('09090909')

print(demir.get_number())
