#ex69 week03 part1
#pallindrome

#self def funcs
def reverse(text):
    return text[::-1]

def palindrome(text):
    if reverse(text) == text:
        return True
    else:
        return False

#main
user_word = input('Type a word: ')

if palindrome(user_word):
    print('It is palindrome')
else:
    print('It is not pallindrome')
