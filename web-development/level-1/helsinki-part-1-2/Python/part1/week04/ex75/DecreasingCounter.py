class DecreasingCounter:
    #constructor
    def __init__(self, initial_value):
        self.value = initial_value


    #methods
    #print statement of the object
    def printValue(self):
        print('value: ', self.value)

    #decreasing the counter by 1 and cannot go lower than 0
    def decrease(self):
        if self.value > 0:
            self.value -= 1
        else:
            print('Cannot decrease lower than 0')

    #reseting the counter to 0
    def reset(self):
        self.value = 0
