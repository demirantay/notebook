//ex 85 week 5 uni of helsinki

public class Main  {
  public static void main(String[] args)  {
    Apartment manhattanApt = new Apartment(2, 1000, 5500);
    Apartment istanbulApt = new Apartment(3, 2000, 2000);

    System.out.println(istanbulApt.larger(manhattanApt));
    System.out.println(manhattanApt.price());
    System.out.println(istanbulApt.price());
    System.out.println(manhattanApt.priceDifference(istanbulApt));
    System.out.println(istanbulApt.moreExpensiveThan(manhattanApt));
  }
}
