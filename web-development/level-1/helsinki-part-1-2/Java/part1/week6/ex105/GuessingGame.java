import java.util.Scanner;
import java.util.*;

public class GuessingGame {

  private Scanner userInput;

  //constructors
  public GuessingGame() {
    this.userInput = new Scanner(System.in);
  }

  //methods
  public void play(int lowerLimit, int upperLimit)  {
    instructions(lowerLimit, upperLimit);

    //code the game logic here
    System.out.println("")
  }

  public void instructions(int lowerLimit, int upperLimit)  {
    int maxQuestions = howManyTimesHalvable(upperLimit - lowerLimit);

    System.out.println("Think of a number between " + lowerLimit+"..."+upperLimit+ ".");

    System.out.println("I promise you that I can guess the number you are thinking of with "
    + maxQuestions +" questions.");
    System.out.println(" ");
    System.out.println("Next I will present you with a series of questions, answer them honestly");
    System.out.println(" ");
  }

  //helper method:
  public static int howManyTimesHalvable(int number)  {
      return (int) (Math.log(number) / Math.log(2)) + 1;
  }


}
