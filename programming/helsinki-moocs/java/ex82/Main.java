import java.util.ArrayList;

public class Main {
  public static void main(String[] args) {
    Lottery lott_nums = new Lottery();
    ArrayList<Integer> numbers = lott_nums.get_numbers();

    for (int number : numbers) {
      System.out.print(number + " ");
    }

    System.out.println(" ");
  }
}
