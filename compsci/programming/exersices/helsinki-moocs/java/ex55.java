import java.util.Scanner;

public class ex55 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    System.out.print("Type first word: ");
    String first_word = input.nextLine();

    System.out.print("Type second word: ");
    String second_word = input.nextLine();

    if (first_word.contains(second_word)) {
      System.out.println(second_word + ", found in the word, " + first_word);
    }
    else {
      System.out.println("Two words are not connected");
    }
  }
}
