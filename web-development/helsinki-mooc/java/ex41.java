import java.util.Scanner;
import java.util.Random;

public class ex41 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    Random random = new Random();

    // Random Number
    int num = random.nextInt(100)+0;
    int guess_made = 0;

    // Game
    while(true) {
      System.out.print("Guess a number: ");
      int user_guess = Integer.parseInt(input.nextLine());
      guess_made++;

      if (user_guess == num) {
        System.out.println("You won! the number was, " + num);
        break;
      }
      else if (user_guess > num) {
        System.out.println("Your guess is too big | Guesses made: " + guess_made);
      }
      else if (user_guess < num) {
        System.out.println("Your guess is too small | Guesses made: " + guess_made);
      }
      else {
        System.out.println("You have entered something wrong!");
      }
    } // game end


  } // entry point
}
