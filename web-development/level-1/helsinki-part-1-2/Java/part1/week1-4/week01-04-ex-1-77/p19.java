// university of hellinski

//imports
import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;
import java.util.*;

//main class
public class p19  {

  public static void main(String[] args)  {
      Scanner getInput = new Scanner(System.in);

      p19_2 multiplyby4 = new p19_2(4);
      p19_2 multiplyby5 = new p19_2(5);

      int num1 = multiplyby4.multiply(10);
      int num2 = multiplyby5.multiply(10);

      System.out.println(num1);
      System.out.println(num2);
  }

}
