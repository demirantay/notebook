class LyyraCard:

    #constructor
    def __init__(self, initial_balance):
        self.balance = initial_balance

    #behaviors
    def print_card(self):
        print('Card balance: ', self.balance, ' $')

    def pay_economical(self):
        self.balance -= 2.50

    def pay_gourmet(self):
        self.balance -= 4.00
