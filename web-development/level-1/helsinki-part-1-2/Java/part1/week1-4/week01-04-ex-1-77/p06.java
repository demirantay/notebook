//doing exersices from the mooc of university of helllinski

import java.util.Scanner;

public class p06  {
  public static void main(String[] args)  {
    Scanner reader = new Scanner(System.in);

    //exersice 1
    //logical operators && ||
    int num;
    System.out.print("Please enter your age: ");
    num = Integer.parseInt(reader.nextLine());

    if (num > 0 && num < 120) {
      System.out.println("OK");
    }
    else  {
      System.out.println("Impossible");
    }

    //line break
    System.out.println(" ");

    //exersice 2
    //basic login system

    String username;
    String password;

    System.out.print("Username : ");
    username = reader.nextLine();

    System.out.print("Password : ");
    password = reader.nextLine();

    if (username.equals("demir") && password.equals("123")) {
      System.out.println("Logged in");
    }
    else if(username.equals("alex") && password.equals("12345"))  {
      System.out.println("Logeed in");
    }
    else {
      System.out.println("Wrong password or username");
    }

    //line break
    System.out.println(" ");

    //exersice 3
    while(true) {
      System.out.println("Enter a number: ");
      int numEntered = Integer.parseInt(reader.nextLine());

      if(numEntered == 0) {
        break;
      }

      int sum = numEntered + numEntered;

      System.out.println("The sum is " + sum);
    }

    //exersice 4
    double dividingNum = 1000.0;

    while (dividingNum > 1 )  {
      System.out.println(dividingNum);
      dividingNum =  dividingNum / 2.0 ;
    }




  }
}
