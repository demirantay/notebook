import java.util.Scanner;

public class ex34 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    System.out.print("Factorial n: ");
    int n = Integer.parseInt(input.nextLine());

    int sum = 1;
    int i = 1;
    while(i <= n) {
      sum *= i;
      i++;
    }

    System.out.println("Factorial: "+ sum);


  }// entry point
}
