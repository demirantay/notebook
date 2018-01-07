class Product:
    #constructor
    def __init__(self, inital_name, initial_price, initial_amount):
        self.name = inital_name
        self.price = initial_price
        self.amount = initial_amount

    def print_product(self):
        return print('name: ', self.name,' price: ',self.price, 'amount: ',self.amount)
