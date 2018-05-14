import java.util.Scanner;

public class ex31 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    System.out.print("Minimum: ");
    int minimum = Integer.parseInt(input.nextLine());

    System.out.print("Maximum: ");
    int maximum = Integer.parseInt(input.nextLine());

    for (int i = minimum; i <= maximum; i++) {
      System.out.println(i);
    }

  } // main entry func
}
