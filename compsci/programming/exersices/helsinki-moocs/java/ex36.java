import java.util.Scanner;

public class ex36 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    int sum = 0;
    int count = 0;
    int average= 0;
    int even_nums = 0;
    int odd_nums = 0;

    while(true) {
      System.out.println("Type numbers: ");
      int user_input = Integer.parseInt(input.nextLine());

      sum += user_input;
      count++;
      if (user_input % 2 == 0) {
        even_nums++;
      } else  {
        odd_nums++;
      }

      if (user_input == -1) {
        System.out.println("Sum: "+ (sum +1));
        System.out.println("Count: "+ (count-1));
        System.out.println("Average: " + ((sum +1) / (count-1)));
        System.out.println("Even count: " + even_nums);
        System.out.println("Odd count: "+ (odd_nums-1));
        break;
      }
    }

  } // entry point
}
