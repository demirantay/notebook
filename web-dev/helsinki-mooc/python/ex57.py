word_list = []

while True:
    user_word = input('Type a word: ')
    word_list.append(user_word)

    if user_word == '':
        break

for i in word_list:
    print(i)
