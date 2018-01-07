#ex 48 week 3 part 3
#First characters

#self defined funcs
def first_character(text):
    return text[0]

#main
def main():
    user_name = input('Type your name: ')
    first_char = first_character(user_name)
    print('first char is ', first_char)
main()
