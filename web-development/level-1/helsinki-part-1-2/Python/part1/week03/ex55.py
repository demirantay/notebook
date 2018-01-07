#ex 55 week3 part1
#a word inside a word

class main:
    #self def funcs

    #main
    def main():
        #ask user input
        first_input = input('Type a word: ')
        second_input = input('Another one : ')

        #Check if the second exist within the first
        if second_input in first_input:
            print('the word', second_input, 'exists in', first_input)
        else:
            print('the secon word', second_input, 'does not exsit in', first_input)
    main()
