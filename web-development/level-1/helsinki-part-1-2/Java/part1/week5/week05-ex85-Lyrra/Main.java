//week 5 uni of helsinki

import java.util.*;

public class Main   {
  public static void main(String[] args)  {

    LyrraCard first = new LyrraCard(10);

    CashRegister second = new CashRegister();

    double theChange = second.payEconomical(10);
    System.out.println("the change was" + theChange);

    theChange = second.payEconomical(5);
    System.out.println("the change was " + theChange);

    theChange = second.payGourmet(5);
    System.out.println("the change was " + theChange);

    System.out.println(second.toString());

  }
}
