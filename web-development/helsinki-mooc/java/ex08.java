import java.util.Scanner;

public class ex08 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    System.out.println("Number: ");
    int num1 = Integer.parseInt(input.nextLine());

    System.out.println("Number: ");
    int num2 = Integer.parseInt(input.nextLine());

    System.out.println("SUM: " + (num1+num2));
  }
}
