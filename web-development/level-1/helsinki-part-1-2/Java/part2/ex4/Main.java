//started part 4 of the universirty of helsinki java
// Things suitcase and contianer

public class Main  {
  public static void main(String[] args)  {
    Thing nokia = new Thing("nokia3310", 2);
    Thing book = new Thing("factotum", 2);
    Thing brick = new Thing("brick", 5);

    Suitcase suitcase = new Suitcase(6);
    System.out.println(suitcase);

    suitcase.addThing(nokia);
    System.out.println(suitcase);

    suitcase.addThing(book);
    System.out.println(suitcase);

    suitcase.addThing(brick);
    System.out.println(suitcase);
  }
}
