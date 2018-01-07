#sum of many numbers

sum = 0

while True:
    num = int(input('Type a number: '))
    if num == 0:
        break
    sum += num
    print('sum now : ', sum)

print('sum in the end: ', sum)
