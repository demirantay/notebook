//uni hellinski java

//imports
import java.util.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

//body

public class p15  {

  //main method
  public static void main(String[] args)  {
    Scanner getInput = new Scanner(System.in);

    ArrayList<Integer> numbers = new ArrayList<Integer>();

    //get input of numbers from the user and add them than average them

    while(true) {
      System.out.print("Please enter a number: ");
      int num = Integer.parseInt(getInput.nextLine());

      numbers.add(num);

      if (num == -1) {
        break;
      }
    }

    System.out.println("The sum is : " + sum(numbers));

    numbers.add(10);

    System.out.println("The average is : " + average(numbers));
  }

  //self written methods
  public static int sum(ArrayList<Integer> numbers) {
    int sum = 0;
    for (int i = 0; i < numbers.size(); i++)  {
      sum += numbers.get(i);
    }
    return sum;
  }

  public static int average(ArrayList<Integer> numbers) {
    int average = 0;
    int sumOfNumbers = sum(numbers);
    average = sumOfNumbers / numbers.size();
    return average;
  }


//body ends here
}
