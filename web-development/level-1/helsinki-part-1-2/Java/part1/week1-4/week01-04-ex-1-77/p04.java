/*
practice 4 still in the first week of university of helllinski
*/

import java.util.Scanner;

public class p04 {
  public static void main(String[] args) {
    Scanner reader = new Scanner(System.in);
    //exersices below

    //exersice 1 - finding the circumfrence of a circle
    double pi = 3.14;
    double radius;

    System.out.print("What is the raidus:");
    radius = Integer.parseInt(reader.nextLine());

    System.out.println("The circumfrence is given by the radius is : " + (2 * pi * radius));

    //exersice 2
    //find which one is bigger

    int first;
    int second;

    System.out.println("What is the value of X?");
    first = Integer.parseInt(reader.nextLine());
    System.out.println("What is the value of y: ");
    second = Integer.parseInt(reader.nextLine());

    if (first > second) {
      System.out.println("x is bigger than y and the value is " + first);
    }
    else {
      System.out.println("y is bigger than x and the value is " + second);
    }

    //break in the terminal
    System.out.println(" ");

    //exersice 3
    //ask for their ages and sum up them

    String name;
    String name2;
    int age1;
    int age2;

    System.out.print("what is your name :");
    name = reader.nextLine();

    System.out.println("And what is your age: ");
    age1 = Integer.parseInt(reader.nextLine());

    System.out.println("well, what is your girlfiends(right hand) name: ");
    name2 = reader.nextLine();

    System.out.println("eheeheh aaaand her age? : ");
    age2 = Integer.parseInt(reader.nextLine());

    System.out.println("you (" + name + ") and your righthands (" + name2 + ") age sum is : " + (age1 + age2) );


    //LINE break
    System.out.println(" ");

    //exersice 4 - conditionals
    int numberGiven;

    System.out.println("please type a number below :");
    numberGiven = Integer.parseInt(reader.nextLine());

    if (numberGiven >= 0)  {
      System.out.println("The number is positive");
    }
    else  {
      System.out.println("the number is negative");
    }

  }
}
