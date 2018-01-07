/*
practice 3 still on the first week of univeristy of hellinski
I do not understand the importing structures in java but i probably will as i go along but uni of
hellinski does not explain it in the first week
*/

import java.util.Scanner;

public class p03 {
  public static void main(String[] args){
    Scanner reader = new Scanner(System.in);
    //code below

      //exersice 1 - concetenation
      int num1 = 1000;
      int num2 = 5000;
      System.out.println("wrong concatination " + num1 + num2);
      System.out.println("proper concatination " + (num1 + num2) );
      //other operations
      System.out.println("multiplication concatination " + num1 * num2);

      //exersice 2 - user input
      System.out.println("What is your name : ");
      String name = reader.nextLine(); //reads a line of input from the user and assings it to the var name

      System.out.println("Hello , " + name);

      //a line break for the new exersices
      System.out.println(" ");

      //exersice 3
      //basic sum calcualtor
      int x;
      int y;

      System.out.print("type the value of x : ");
      x = Integer.parseInt(reader.nextLine());

      System.out.print("and the value of y : ");
      y = Integer.parseInt(reader.nextLine());

      System.out.println("Their total sum is : " + (x + y));

      //line break
      System.out.println(" ");

      //exersice 4
      //basic division of double point converting calcualtor
      int a;
      int b;

      System.out.println("a : ");
      a = Integer.parseInt(reader.nextLine());

      System.out.println("b : ");
      b = Integer.parseInt(reader.nextLine());

      System.out.println("a divided by b is : " + (double)a / b);


  }
}
