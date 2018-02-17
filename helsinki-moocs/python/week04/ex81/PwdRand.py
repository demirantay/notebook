from random import randint

class PwdRand:

    #consturctor
    def __init__(self, pwd_length):
        self.password_length = pwd_length

    #behaviors
    def create_password(self):
        random_password = ''
        symbol = 'asdfghjklzxcvbnmqwertyuiop'
        for i in range(self.password_length):
            random_num = randint(1, self.password_length)
            random_symbol = symbol[random_num]
            random_password += random_symbol
        return random_password
