//university of hellinski week 2

import java.util.Scanner;

public class p08 {
  //main function
  public static void main(String[] args)  {
    Scanner reader = new Scanner(System.in);
    //code below
    System.out.print("How big xmas tree do you want? : ");
    int x = Integer.parseInt(reader.nextLine());
    xmasTree(x);
  }

  //self written - methods (functions ) go here

  public static void printStars(int amount) {
    for (int i = 0; i < amount; i++)  {
      System.out.print("*");
    }
    System.out.println("");
  }

  public static void printWhitespaces() {
    System.out.print("    ");
  }

  public static void printSquare(int height)  {
    for (int i =0; i < height; i++) {
      printStars(4);
    }
  }

  public static void printRectangle(int width, int height)  {
    for (int i =0; i < height; i++) {
      printStars(width);
    }
  }

  public static void printTriangle(int size)  {
    for (int i = 0; i < size; i++)  {
      printStars(i + 1);
    }
  }

  public static void xmasTree(int height) {
    for (int i = 0; i < height; i++)  {
      printTriangle(height);
    }
    printRectangle(3, 2);
  }


}//body of the program ends here
