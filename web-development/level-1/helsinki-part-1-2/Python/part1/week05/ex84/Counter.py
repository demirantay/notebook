class Counter:

    #constructors
    def __init__(self, starting_value):
        self.value = starting_value

    #behaviors

    #gets the value
    def get_value(self):
        return self.value

    #increase the counter value by one
    def increase(self):
        self.value += 1

    #decreases the counter value by one but cannot go below 0
    def decrease(self):
        if self.value > 0:
            self.value -= 1
        elif self.value == 0:
            print('Cannot go below 0')
