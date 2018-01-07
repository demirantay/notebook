# ex50 week 03 part1
# words in reverse order

# self def funcs

# main


def main():

    word_list = []

    while True:
        typed_word = input('Type a words: ')
        if typed_word == '':
            break
        else:
            word_list.append(typed_word)

    print('')
    print('You typed the words (in reverse order)')

    for i in range(len( word_list)):
        print(word_list[len(word_list) - i - 1 ])

main()
