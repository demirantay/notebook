import java.util.Arrays;

public class ex104 {
  public static int smallest(int[] array) {
    int smallest_num = array[0];
    for(int num : array) {
      if (num < smallest_num) {
        smallest_num = num;
      }
    }
    return smallest_num;
  }

  public static int indexOfTheSmallest(int[] array) {
    int index = 0;
    int smallest_num = array[0];
    for(int i = 0; i < array.length; i++) {
      if (array[i] < smallest_num) {
        smallest_num = array[i];
        index = i;
      }
    }
    return index;
  }

  public static void swap(int[] array, int number1, int number2) {
    int number1_index = 0;
    for (int i = 0; i < array.length; i++) {
      if (number1 == array[i]) {
        number1_index = i;
      }
    }
    int number2_index = 0;
    for (int i = 0; i < array.length; i++) {
      if (number2 == array[i]) {
        number2_index= i;
      }
    }
    array[number1_index] = number2;
    array[number2_index] = number1;
  }

  public static void sort(int[] array) {
    for (int i =0; i < array.length; i++) {
      if (array[0] > array[i]) {
        swap(array, array[i], array[0]);
      }
    }
    for (int num = array) {
      
    }
  }

  // Main
  public static void main(String[] args) {
    int[] values = {6, 5, 8, 7, 11, 1, 3};

    System.out.println(Arrays.toString(values));
    swap(values, 6, 11);
    System.out.println(Arrays.toString(values));
  }
}
