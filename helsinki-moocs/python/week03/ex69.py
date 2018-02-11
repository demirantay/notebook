def reverse_text(text):
    return text[::-1]

def pallindrome(text):
    if text == reverse_text(text):
        return True
    else:
        return False

user_text = input('Type a text: ')

if pallindrome(user_text) == True:
    print('The word \'', user_text, '\' is pallindrome')
else:
    print('The word is not pallindrome')
