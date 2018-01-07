class HangmanLogic:

    #consturctor
    def __init__(self, word):
        self.word = word
        self.guessed_letters = []
        self.number_of_faults = 0

    #behaviors

    #gets the nubmer of faults
    def get_number_of_faults(self):
        return self.number_of_faults

    #gets the guessed letters
    def get_guessed_letters(self):
        return self.guessed_letters

    #limit for the wrong guesses
    def losing_fault_amount(self):
        return 12

    #guessing a letter
    def guess_letter(self, letter):
        # add to the guesses
        self.guessed_letters += letter
        # if letter is already been guessed nothing happens
        if letter in self.guessed_letters:
            print('You have already guessed this letter: ', letter)
        #checking if the letter is wrong
        if letter not in self.word:
            self.number_of_faults += 1

    #hiding the word
    def hidden_word(self):
        for i in self.word:
            print('_')
