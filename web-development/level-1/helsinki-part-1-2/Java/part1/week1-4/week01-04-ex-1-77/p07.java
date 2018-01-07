//doing exersices on university of hellinski

import java.util.Scanner;

public class p07  {
  public static void main(String[] args) {
    Scanner reader = new Scanner(System.in);
    //exersices below

    //exersice 1
    int ex1Num = 0;

    while(ex1Num < 101) {
      System.out.println(ex1Num);
      ex1Num++;
    }

    //line break
    System.out.println(" ");

    //exersice 2
    int ex2numMax;
    int ex2numMin;

    System.out.print("Please enter a number: ");
    ex2numMax = Integer.parseInt(reader.nextLine());

    System.out.print("Please enter a lesser valued number : ");
    ex2numMin = Integer.parseInt(reader.nextLine());

    while (ex2numMax > ex2numMin) {
      System.out.println(ex2numMax);
      ex2numMax--;
    }
  

  }
}
