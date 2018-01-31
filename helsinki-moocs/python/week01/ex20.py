database_username = 'demir'
database_pwd = 'qwerty'

user_username = input('Username: ')
user_pwd = input('Password: ')

if user_pwd == database_pwd and user_username == database_username:
    print('Hello demir')
else:
    print('you are not a valid user')
