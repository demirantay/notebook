#imports
import random

#class
class PasswordRandomizer:

    #constructor
    def __init__(self, pwd_length):
        self.pwd_length = pwd_length
        self.new_password = ''

    #methods to the class
    def create_password(self):
        for i in range(self.pwd_length):
            j = random.randint(65, 96)
            self.new_password += chr(j)
        return self.new_password
