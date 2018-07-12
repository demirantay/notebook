class Money:

    #constructor
    def __init__(self, initial_euros, initial_cents):
        self.euros = initial_euros
        self.cents = initial_cents


    #behaviors
    def euros(self):
        return self.euros

    def cents(self):
        return self.cents

    #to string
    def __str__(self):
        return 'Balance: ' + str(self.euros) + '.' + str(self.cents) + 'E'

    def plus(self, class_instance):
        self.euros += class_instance.euros
        self.cents += class_instance.cents
