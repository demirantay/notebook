import java.util.Scanner;
import java.util.ArrayList;

public class ex58 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    ArrayList<String> word_list = new ArrayList<String>();

    while(true) {
      System.out.print("Type a word: ");
      String word = input.nextLine();

      if (word_list.contains(word)) {
        System.out.println("You have the " + word + " twice");
        break;
      } else {
        word_list.add(word);
      }
    }
  }// entry point
}
