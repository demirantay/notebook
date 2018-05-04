class LyrraCard:

    #constructor
    def __init__(self, balance):
        self.balance = balance

    #behaviors

    #gets the balance
    def balance(self):
        return self.balance

    #loads money
    def load_money(self, amount):
        self.balance += amount

    #paying system
    def pay(self, amount):
        if self.balance > amount and self.balance > 0:
            self.balance -= amount
        else:
            print('Not enough balance : ', self.balance)
