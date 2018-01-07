#ex 62 week 3 part 1
#sum of the numbers

#methods
def sum(array):
    sum = 0
    for i in range(0, len(array)):
        sum += array[i]
    return sum



def main():
    num_list = [1, 2, 3, 4, 5]
    sum_of_list = sum(num_list)

    print('The sum of numbers in the list are', sum_of_list)

    num_list.append(10)
    sum_of_list = sum(num_list)

    print('again: ', sum_of_list )

main()
