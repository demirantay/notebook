#ex 47 week 3 part 1
#The length of a name

#sel def funcs
def calculateCharacters(text):
    return len(text)

#main
def main():
    user_text = input('Type a word: ')
    text_length = calculateCharacters(user_text)
    print('number of characters :', text_length)
main()
