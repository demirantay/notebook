#usernames

#shittiest database ever
#user1
username1 = 'alex'
userpwd1 = '123'
#user2
username2 = 'demir'
userpwd2 = 'password'

#shittiest login system
username = input('Username: ')
password = input('Password: ')

if username1 == username and userpwd1 == password:
    print('hello alex, you are logged in')
elif username2 == username and userpwd2 == password:
    print('hello demir you are logged in')
else:
    print('you need to register')
