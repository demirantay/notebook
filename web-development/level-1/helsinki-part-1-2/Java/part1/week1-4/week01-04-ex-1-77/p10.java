// university of hellinski week 3

//imports
import java.util.Scanner;
import java.util.Random;

//body of the program
public class p10  {

  //main method
  public static void main(String[] args)  {
    Scanner reader = new Scanner(System.in);
    //code below

    int answer = sum(1, 10, 43, 10);
    System.out.println("sum : " + answer);

    int leastOne = least(10, 30);
    System.out.println("Least one is : " + leastOne);

    int greatesOne = greatest(20, 30, 20);
    System.out.println("Greatest one is : " + greatesOne);

    double myAverage = average(90, 87, 40, 39);
    System.out.println("Average is : " + myAverage);

  }

  //self defined funcs

  public static int sum(int first, int second, int third, int fourth)  {
    return first + second + third + fourth;
  }

  public static int least(int num1, int num2) {
    if (num1 > num2 || num1 == num2)  {
      return num2;
    }
    else  {
      return num1;
    }
  }

  public static int greatest(int first, int second, int third)  {
    if (first > second && first > third) {
      return first;
    }
    else if (second > first && second > third) {
      return second;
    }
    else if (third > first && third > second) {
      return third;
    }
    else  {
      return first;
    }
  }

  public static double average(int num1, int num2, int num3, int num4) {
    int sum = num1 + num2 + num3 + num4;
    double average = sum / 4.0;
    return average;
  }

}//body ends
