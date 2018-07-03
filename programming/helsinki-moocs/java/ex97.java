public class ex97 {
  public static void printElegantly(int[] array) {
    for(int i = 0; i < array.length; i++) {
      System.out.print(array[i] +", ");
    }
    System.out.println("");
  }

  public static void main(String[] args) {
    int[] numbers = {1, 5, 5, 8, 2};
    printElegantly(numbers);
  }
}
