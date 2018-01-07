//still doing university of hellinski

//imports
import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

//program body
public class p13  {

  //main func
  public static void main(String[] args)  {
    Scanner reader = new Scanner(System.in);
    //code below
    //exersice1
    ArrayList<String> words = new ArrayList<String>();

    while(true) {

      System.out.print("Enter a word: ");
      String wordEntered = reader.nextLine();
      words.add(wordEntered);

      if (wordEntered.equals("")) {
        System.out.println("You typed the following words : ");
        for (int i = 0; i < words.size(); i++)  {
          System.out.println(words.get(i));
        }
        break;
      }
    }
  }
  //main func end

  //self written funcs

}
//body ends here
