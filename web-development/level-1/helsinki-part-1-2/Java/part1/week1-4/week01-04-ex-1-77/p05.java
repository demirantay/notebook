//still on the 1st week of university of helllinski
//imports

import java.util.Scanner;

public class p05  {
  public static void main(String[] args)  {
    Scanner reader = new Scanner(System.in);
    //code below

    //exersice 1 check if the users age checks out
    int age;
    System.out.print("What is your age ? :");
    age = Integer.parseInt(reader.nextLine());

    if (age >= 18)  {
      System.out.println("You are legal");
    }
    else {
      System.out.println("You are too young");
    }

    //line break
    System.out.println(" ");

    //exersice 2 check if the number is divisible by 2;
    int divisibleNum;
    System.out.println("Please enter a number below: ");
    divisibleNum = Integer.parseInt(reader.nextLine());
    if (divisibleNum % 2 == 0)  {
      System.out.println("The number is even");
    }
    else  {
      System.out.println("The number is odd");
    }

    //line break
    System.out.println(" ");

    //exersice 3 checks if it is equal
    int a;
    int b;

    System.out.print("Please enter a number : ");
    a = Integer.parseInt(reader.nextLine());

    System.out.print("Please enter a nother one : ");
    b = Integer.parseInt(reader.nextLine());

    if (a == b) {
      System.out.println("Both numbers are same");
    }
    else if (a > b) {
      System.out.println("First entered number is greater than the other one");
    }
    else if ( a < b)  {
      System.out.println("Second entered number is grater than the first one");
    }
    else  {
      System.out.println("The variables are null");
    }

    //exersice 4
    //grading System

    int grade;

    System.out.print("Please enter your grade : ");
    grade = Integer.parseInt(reader.nextLine());

    if (grade < 60) {
      System.out.println("F");
    }
    else if (grade < 70) {
      System.out.println("D");
    }
    else if (grade < 80)  {
      System.out.println("C");
    }
    else if (grade < 90)  {
      System.out.println("B");
    }
    else if (grade <= 100)  {
      System.out.println("A");
    }

  }
}
