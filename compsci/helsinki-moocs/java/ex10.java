import java.util.Scanner;

public class ex10 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    System.out.print("Number: ");
    int num_1 = Integer.parseInt(input.nextLine());

    System.out.print("Number : ");
    int num_2 = Integer.parseInt(input.nextLine());

    if (num_1 > num_2) {
      System.out.println("num "+ num_1 +" is bigger");
    }
    else if (num_2 > num_1) {
      System.out.println("num "+ num_2 +" is bigger");
    }
    else {
      System.out.println("They are equal !");
    }
  } // Main entry func
} //Main class
