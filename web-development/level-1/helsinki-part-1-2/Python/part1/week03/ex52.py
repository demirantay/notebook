#ex52 week3 part 1
#Reversing a string

#self def funcs

#main
def main():
    #ask user name
    user_name = input('What is your name: ')

    print('In reverse order')
    for i in range(len(user_name)):
        print(user_name[len(user_name) - i - 1], end='')
    print('')

main()
