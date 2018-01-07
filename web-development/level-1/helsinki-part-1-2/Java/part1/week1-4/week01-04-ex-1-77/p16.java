//university of hellinski

//imports
import java.util.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

//program body class
public class p16  {
  //main func
  public static void main(String[] args)  {
    Scanner getInput = new Scanner(System.in);

    p16_2 banana = new p16_2("banana", 10, 3);
    p16_2 strawberry = new p16_2("strawberry", 40, 1);

    banana.printProduct();
    strawberry.printProduct();

    System.out.println("");

    banana.becomeOlder();
    strawberry.becomeOlder();

    banana.printProduct();
    strawberry.printProduct();
  }


}//body class ends here
