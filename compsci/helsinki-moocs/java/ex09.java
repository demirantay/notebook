import java.util.Scanner;

public class ex09 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    double PI = 3.1415;

    System.out.print("Type the radius: ");
    int user_input = Integer.parseInt(input.nextLine());

    System.out.println("The circumfrence: " + (PI * 2 * user_input));
  }
}
