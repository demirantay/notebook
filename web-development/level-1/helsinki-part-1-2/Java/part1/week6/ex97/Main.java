//week 6 ex 97
//elegant printing of an array

public class Main  {
  //main method
  public static void main(String[] args)  {
    int[] array = {5, 2, 4 ,1, 2};
    printElegently(array);
  }

  //other methods
  public static void printElegently(int[] array) {
    String elegant = "";

    for (int i = 0; i < array.length; i++)  {
      elegant += array[i]+", ";
    }

    System.out.println(elegant);

  }

//class ends here
}
