public class Main {

  public static void main(String[] args) {
    int[] array = {5,2,4,3,1};
    System.out.println(sum(array));
  }

  public static int sum(int[] array)  {
    int total = 0;
    for (int i = 0; i < array.length; i++)  {
      total += array[i];
    }
    return total;
  }

//end of the class
}
