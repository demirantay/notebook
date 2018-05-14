import java.util.Scanner;

public class ex26 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    int sum = 0;

    while(true) {
      System.out.print("Number: ");
      int user_input = Integer.parseInt(input.nextLine());
      sum += user_input;
      System.out.println("Sum now: "+ sum);

      if (user_input == 0) {
        System.out.println("Sum in the end: "+ sum);
        break;
      }
    }

  }// main entry func
}
