import java.util.Scanner;

public class ex32 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    int sum = 0;
    int i = 0;

    System.out.print("n = ");
    int n = Integer.parseInt(input.nextLine());

    while(i <= n) {
      sum += i;
      i++;
    }
    System.out.println("Sum: " + sum);
  } // entry point
}
