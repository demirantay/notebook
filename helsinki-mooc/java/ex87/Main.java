public class Main {
  public static void main(String[] args) {

    Apartment studioManhattan = new Apartment(1, 16, 5500);
    Apartment twoRoomsBrooklyn = new Apartment(2, 38, 4200);
    Apartment fourAndKitchenBronx = new Apartment(3, 78, 2500);

    System.out.println(studioManhattan.larger(twoRoomsBrooklyn));
    System.out.println(fourAndKitchenBronx.larger(twoRoomsBrooklyn) );

    System.out.println(studioManhattan.price_difference(twoRoomsBrooklyn));
    System.out.println(fourAndKitchenBronx.price_difference(twoRoomsBrooklyn));

    System.out.println(studioManhattan.expensive(twoRoomsBrooklyn));       
    System.out.println(fourAndKitchenBronx.expensive(twoRoomsBrooklyn));

  }
}
