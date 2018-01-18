#lyrra card
#ex 86 part1 week 5

class Reform:

    #constructos
    def __init__(self, initial_balance):
        self.balance = initial_balance;

    #behaviors

    #returns the balance
    def balance(self):
        return self.balance

    # loads money to the card
    def load_money(self, amount):
        self.balance += amount

    #paying money
    def pay(self):
        
