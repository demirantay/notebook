class DecreasingCounter:

    #constructor
    def __init__(self, initial_value):
        self.value = initial_value
        self.initial_value = initial_value

    #behaviors
    def print_value(self):
        print('Value: ', self.value)

    def decrease(self):
        if self.value > 0:
            self.value -= 1
        else:
            print('cannot decrease below 0')

    def reset(self):
        self.value = 0

    def set_initial(self):
        self.value = self.initial_value
