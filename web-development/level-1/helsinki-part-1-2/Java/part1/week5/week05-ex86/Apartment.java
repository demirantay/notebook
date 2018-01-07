public class Apartment {
  private int rooms;
  private int squareMeters;
  private int pricePerSquareMeter;

  //consturctors
  public Apartment(int initialRooms, int initialSquareMeters, int initialPricePerSquareMeter) {
    this.rooms = initialRooms;
    this.squareMeters = initialSquareMeters;
    this.pricePerSquareMeter = initialPricePerSquareMeter;
  }

  //methods
  public boolean larger(Apartment ortherApartement)  {
    if (this.squareMeters > ortherApartement.squareMeters)  {
      return true;
    }
    else  {
      return false;
    }
  }

  public int price()  {
    return this.squareMeters * this.pricePerSquareMeter;
  }

  public int priceDifference(Apartment firstApt)  {
    int priceDiff = this.price() - firstApt.price();
    return priceDiff;
  }

  public boolean moreExpensiveThan(Apartment otherApt)  {
    if (this.price() > otherApt.price())  {
      return true;
    }
    else {
      return false;
    }
  }


//object ends here
}
