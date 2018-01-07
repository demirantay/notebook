#ex 76 week 04 part1
#menu

#imports
from Menu import *

#main logic
menu = Menu()
menu.menu_add('corba')
menu.menu_add('kelle paca')
menu.menu_add('doner')

menu.print_meals()

menu.clear_menu()
menu.print_meals()

print('')

menu.menu_add('kofte')
menu.print_meals()
