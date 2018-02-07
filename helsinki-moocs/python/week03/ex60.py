def reverse_array(arr):
    return arr[::-1]

word_list = []

while True:
    user_word = input('Type a word: ')
    word_list.append(user_word)
    
    if user_word == '':
        break

for i in reverse_array(word_list):
    print(i)
