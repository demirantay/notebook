class Menu:

    #constructor
    def __init__(self):
        self.meals = []

    #behaviors
    def add_meal(self, meal):
        if meal not in self.meals:
            self.meals.append(meal)
        else:
            print('This meal already exists')

    def print_menu(self):
        for meal in self.meals:
            print(meal)
