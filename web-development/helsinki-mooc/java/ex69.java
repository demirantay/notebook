import java.util.Scanner;
import java.util.ArrayList;

public class ex69 {

  public static boolean is_pallindrome(String word) {
    String reversed_word = "";
    for (int i = word.length()-1; i > 0; i--) {
      reversed_word += word.charAt(i);
    }
    if (reversed_word == word) {
      return true;
    } else {
      return false;
    }
  }

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    System.out.println("Type a word: ");
    String word = input.nextLine();

    if (is_pallindrome(word)) {
      System.out.println("The word is pallindrome !");
    } else {
      System.out.println("The word is NOT pallindrome !");
    }
  }

}
