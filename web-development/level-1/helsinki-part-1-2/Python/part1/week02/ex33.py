#ex 33
#the sum between the two numbers

lowerLim = int(input('Lower limit : '))
upperLim = int(input('Upper limit : '))
numsSum = 0

while lowerLim <= upperLim:
    numsSum += lowerLim
    if lowerLim >= upperLim:
        print('The sum: ', numsSum)
        break
    lowerLim += 1
