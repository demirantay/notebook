#ex 46 week 3 part1
#average of given numbers

#global vars

#self def funcs
def average(num1, num2, num3, num4):
    sum = num1 + num2 + num3 + num4
    average = sum / 4
    return average


# main
def main():
    myGrade = average(90, 80, 80, 80)
    print('My grade ', myGrade)

main()
