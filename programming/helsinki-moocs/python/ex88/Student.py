class Student:

    #constructor
    def __init__(self, name, number):
        self.student_name = name
        self.student_number = number


    # behaviors
    def get_name(self):
        return self.student_name

    def get_number(self):
        return self.student_number
