#ex 49 week 03 part1
#Last characters

#self def funcs
def last_character(text):
    return text[len(text) - 1]

#main
def main():
    #ask usser input
    user_name = input('Type your name: ')
    last_char = last_character(user_name)

    print('Last character: ', last_char)

main()
