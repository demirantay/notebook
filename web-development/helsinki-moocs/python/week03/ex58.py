word_list = []

while True:
    user_word = input('Type a word: ')
    if user_word in word_list:
        print('You gave the word ', user_word, ' twice')
        break
    else:    
        word_list.append(user_word)
