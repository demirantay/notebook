class Person:

    #consturctor
    def __init__(self, name, number):
        self.person_name = name
        self.person_number = number

    #behaviors

    def get_name(self):
        return self.person_name

    def get_number(self):
        return self.person_number

    def change_number(self, new_number):
        self.person_number = new_number
