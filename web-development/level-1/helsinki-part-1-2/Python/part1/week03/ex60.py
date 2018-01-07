#ex60 week3 part1
#words in alphebetical order

#self funcs

#main
def main():

    word_list = []

    while True:
        typed_word = input('Type a words: ')

        if typed_word == '':
            print('')
            break
        else:
            word_list.append(typed_word)

    word_list.sort()

    print('In alphabetical order :')
    for i in word_list:
        print(i)

main()
