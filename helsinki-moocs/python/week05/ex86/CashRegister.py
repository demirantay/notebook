class CashRegister:

    #constructor
    def __init__(self):
        self.cash_in_register = 1000.00
        self.economical_sold = 0
        self.gourmet_sold = 0

    #behaviors

    #pays economically 2.50 $
    def pay_economical(self, cash_given):
        if cash_given >= 2.50:
            self.cash_in_register += 2.50
            self.economical_sold += 1
            return 'Cash: $', cash_given - 2.50
        else:
            return 'Cash given is not enough : $',cash_given

    #pays gourmet 4.00 $
    def pay_gourmet(self, cash_given):
        if cash_given >= 4.00:
            self.cash_in_register += 4.00
            self.gourmet_sold += 1
            return 'Cash: $', cash_given - 4.00
        else:
            return 'Cash given is note enough: $',cash_given

    #returns a toString method of the register
    def register_info(self):
        return 'Money in register: $', self.cash_in_register, '\
        economical sold: ', self.economical_sold, '\
        gourmet sold: ', self.gourmet_sold
