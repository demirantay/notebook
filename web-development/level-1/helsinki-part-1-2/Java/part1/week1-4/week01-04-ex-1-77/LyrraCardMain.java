//uni of helsinki exersices

import java.util.Scanner;

public class LyrraCardMain  {
  public static void main(String[] args)  {

    LyrraCard demirsCard = new LyrraCard(10);

    System.out.println(demirsCard);
    demirsCard.payGourmet();
    System.out.println(demirsCard);
    demirsCard.payGourmet();
    System.out.println(demirsCard);
    demirsCard.payEconomical();
    System.out.println(demirsCard);
  }
}
