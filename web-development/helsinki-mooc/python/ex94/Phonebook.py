from Person import Person

class Phonebook:

    #consturctor
    def __init__(self):
        self.phonebook_array = []

    #behaviors
    def add(self, Person):
        self.phonebook_array.append(Person)
