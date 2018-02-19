class Product :

    def __init__(self, name, amount):
        self.name = name
        self.product_amount = amount

    def print_product(self):
        print('Name: ', self.name,)
        print('Amount: ', self.product_amount)
