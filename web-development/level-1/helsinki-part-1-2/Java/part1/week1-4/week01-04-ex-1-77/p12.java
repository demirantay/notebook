//still on week 3 of university of hellinski

//imports
import java.util.Scanner;
import java.util.Random;

//program body
public class p12  {

  //main method
  public static void main(String[] args)  {
    Scanner reader = new Scanner(System.in);
    //code below

    //exersice 1
    System.out.print("Please type a word: ");
    String word = reader.nextLine();

    System.out.print("Length of the first part: ");
    int firstPart = Integer.parseInt(reader.nextLine());

    String result = word.substring(firstPart);
    System.out.println("Result : " + result + "\n");

    //exersice 2
    System.out.print("type a text : ");
    String text = reader.nextLine();
    int index = word.indexOf(text);

    System.out.println(word.substring(index));


  }
  //main method ends here

  //self written methods

}
//body ends here
