user_input = input('Type random characters')
number_of_vowels = 0

for i in range(0, len(user_input), 1):
    if user_input[i] == 'a' or user_input[i] == 'e' or user_input[i] == 'i' or \
    user_input[i] == 'o' or user_input[i] == 'u':
        number_of_vowels += 1

print('Number of voewls: ', number_of_vowels)
