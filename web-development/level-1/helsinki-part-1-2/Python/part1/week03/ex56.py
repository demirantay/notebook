#ex56 week3 part1
#Reversing a string

#self def funcs
def reversing(text):
    return text[::-1]

#main
def main():
    #ask for user input
    user_word = input('Type a word: ')
    reversed_word = reversing(user_word)
    print('In reverse order', reversed_word)

main()
