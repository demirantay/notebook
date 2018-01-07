//week 3 university of hellinski practice 11

import java.util.Scanner;
import java.util.Random;

//body of the program
public class p11  {

  //main func
  public static void main(String[] args)  {
    Scanner reader = new Scanner(System.in);
    //code below
    //exersice 1
    System.out.print("Please type a string : ");
    String text = reader.nextLine();

    int lengthText = howManyChars(text);
    char charText = firstChar(text);
    char lastCharText = lastChar(text);

    System.out.println("You typed " + text + " and its length is : " + lengthText);
    System.out.println("First character of what you typed : " + charText );
    System.out.println("Last character is : " + lastCharText + "\n");

  
  }//main func ends here

  //written-funcs

  public static int howManyChars(String text) {
    return text.length();
  }

  public static char firstChar(String text) {
    return text.charAt(0);
  }

  public static char lastChar(String text)  {
    return text.charAt( text.length() - 1 );
  }



}//body ends here
