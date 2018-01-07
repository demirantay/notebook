//university of helsinki week4 clockcounter exersice 78

//imports
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
  public static void main(String[] args) {
    Scanner userInput = new Scanner(System.in);

    BoundedCounter minutes = new BoundedCounter(59);
    BoundedCounter hours = new BoundedCounter(23);

    for (int i = 0; i < 121; i++) {
      if (minutes.equals(0))  {
        hours.next();
        minutes.next();
      }
      else  {
        minutes.next();
      }
      System.out.println("Time : " + hours + ":" + minutes);
    }


  }
}
