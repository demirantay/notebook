class Card:

    #constructor
    def __init__(self, starting_balance):
        self.balance = starting_balance


    #mehods

    #prints the info about the card
    def print_info(self):
        print('The card has ', self.balance, '$$')

    #paying methods echonomical and gourmet
    def pay_gourmet(self):
        if self.balance > 4:
            self.balance -= 4
        else:
            print('Not enough credit')

    def pay_economical(self):
        if self.balance > 2.50:
            self.balance -= 2.50
        else:
            print('Not enough credit')

    #Load money to the cards
    def load_money(self, amount):
        if amount < 0:
            print('cannot add a negative')
        else:
            self.balance += amount
