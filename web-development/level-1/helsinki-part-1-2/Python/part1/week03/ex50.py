# ex 50 week 3 part 1
#Seperating first characters

#slf funcs

#main
def main():
    #user input
    user_name = input('What is your name? ')

    if len(user_name) < 3:
        print('Cannot give a name less then 3 chars')
    else:
        print('First character : ', user_name[0])
        print('Second character : ', user_name[1])
        print('Third character : ', user_name[2])
main()
