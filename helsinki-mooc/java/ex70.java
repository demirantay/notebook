
import java.util.Scanner;
import java.util.ArrayList;

public class ex70 {

  public static void combine(ArrayList<Integer> arr_1, ArrayList<Integer>arr_2) {
    arr_1.addAll(arr_2);
  }

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    ArrayList<Integer> list_1 = new ArrayList<Integer>();
    ArrayList<Integer> list_2 = new ArrayList<Integer>();

    list_1.add(1);
    list_1.add(2);

    list_2.add(3);
    list_2.add(4);

    combine(list_1, list_2);

    System.out.println(list_1);
    System.out.println(list_2);
  }
}
