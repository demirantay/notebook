import java.util.Scanner;

public class ex16 {
    public static void main(String[] args) {
      Scanner input = new Scanner(System.in);

      System.out.print("Type a number: ");
      int num = Integer.parseInt(input.nextLine());

      if (num % 2 == 0) {
        System.out.println(num + " is even!");
      } else if (num % 2 != 0) {
        System.out.println(num + " is odd!");
      } else {
        System.out.println("Ooooops! something went wrong.");
      }

    }// main entry func
}
