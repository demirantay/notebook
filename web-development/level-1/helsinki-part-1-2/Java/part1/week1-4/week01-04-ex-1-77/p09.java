//number guessing game

//imports
import java.util.Scanner;
import java.util.Random;

//body of the program
public class p09  {

  //main function
  public static void main(String[] args)  {
    Scanner reader = new Scanner(System.in);
    Random rand = new Random();

    //random num
    int number = rand.nextInt(100) + 1;

    int guess = 0;
    int timesGuessed = 0;
    //guessing
    while(number != guess)  {

      System.out.print("Guess the number : ");
      guess = Integer.parseInt(reader.nextLine());

      timesGuessed++;
      System.out.println(timesGuessed + " : many times gueesed");

      if (number > guess)  {
        System.out.println("Your number is too low");
      }
      else if (number < guess)  {
        System.out.println("Your number is too high");
      }
      else if (number == guess) {
        break;
      }

      System.out.println("");
    }
    System.out.println("hooray you guessed it");
  }//main func ends here


}
