#ex58 week3 part1
#Reccuring a words

#self def- funcs

#main
def main():

    word_list = []

    #ask for user input
    while True:
        typed_word = input('Type a word: ')
        if typed_word in word_list:
            print('you gave the word: \' ', typed_word, ' \' twice \n' )
            break
        else:
            word_list.append(typed_word)

    print('the words you entered')
    for i in word_list:
        print(i)
        
#main func ends here
main()
