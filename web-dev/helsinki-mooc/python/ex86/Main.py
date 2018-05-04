from LyrraCard import *
from CashRegister import *

cafe_register = CashRegister()

change = cafe_register.pay_economical(10.00)
print('The change was, ', change)

change = cafe_register.pay_economical(5.00)
print('The change was, ', change)

change = cafe_register.pay_gourmet(3.00)
print('The change was, ', change)

print(cafe_register.register_info())
