class Menu:

    #constructor
    def __init__(self):
        self.meals = [] # a list of strings


    #methods

    #adding meals to the menu
    def menu_add(self, meal):
        if meal not in self.meals:
            self.meals.append(meal)
        else:
            print('You ve already added that meal')

    #printing the meals on the secreen
    def print_meals(self):
        for i in range(0, len(self.meals), 1):
            print(i + 1,' . meal: ', self.meals[i])

    #clearing the menu
    def clear_menu(self):
        self.meals = [] #cleared string list
