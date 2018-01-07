#ex57 week3 part1
#Words

#self -def funcs

#main
def main():
    words = []

    while True:
        word_input = input('Type a word: ')
        if word_input == '':
            break
        else:
            words.append(word_input)

    print('You have typed the following words')

    for i in words:
        print(i)

main()
