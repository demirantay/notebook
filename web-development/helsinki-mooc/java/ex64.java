import java.util.Scanner;
import java.util.ArrayList;

public class ex64 {

  public static double average(ArrayList<Integer> list) {
    double sum = 0;
    double count = 0;
    for (int i = 0; i < list.size(); i++) {
      sum += list.get(i);
      count++;
    }
    return sum / count;
  }

  public static void main(String[] args) {
    ArrayList<Integer> list = new ArrayList<Integer>();

    list.add(3);
    list.add(2);
    list.add(7);
    list.add(2);

    System.out.println("Average: " + average(list));
  }

}
