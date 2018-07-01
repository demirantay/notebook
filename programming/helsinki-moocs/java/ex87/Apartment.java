public class Apartment {
  private int rooms;
  private int square_meters;
  private int price_per_square;

  // constructor
  public Apartment(int init_rooms, int square_m, int price_per_square_m) {
    this.rooms = init_rooms;
    this.square_meters = square_m;
    this.price_per_square = price_per_square_m;
  }

  // behaviours
  public boolean larger(Apartment apartment) {
    if (this.square_meters > apartment.square_meters) {
      return true;
    } else if (this.square_meters <= apartment.square_meters) {
      return false;
    }
  }

  public int price_difference(Apartment apt) {
    int this_apt_price = this.square_meters * this.price_per_square;
    int other_apt_price = apt.square_meters * apt.price_per_square;
    int price_difference = this_apt_price - other_apt_price;
    return price_difference;
  }

  public boolean expensive(Apartment apt) {
    int this_apt_price = this.square_meters * this.price_per_square;
    int other_apt_price = apt.square_meters * apt.price_per_square;
    if (this_apt_price > other_apt_price) {
      return true;
    } else {
      return false;
    }
  }

}
