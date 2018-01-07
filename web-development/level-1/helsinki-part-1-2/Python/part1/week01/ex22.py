#exerice 22 week 01 -- Password

password = 'sentinel'

while(True):
    askPwd = input('Password: ')
    if askPwd != password:
        print('it is not true')
    elif askPwd == password:
        print('secret message is: "zl ohggpenpx uhegf" ')
        break
