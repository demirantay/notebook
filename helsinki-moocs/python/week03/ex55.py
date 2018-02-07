word_1 = input('Type the first word: ')
word_2 = input('Type the seconds word: ')

if word_2 in word_1:
    print('The word \'', word_2, '\' is found in the word \'', word_1, '\'')
else:
    print('The word \'', word_2, '\' is NOT found in the word \'', word_1, '\'')
