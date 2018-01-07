public class Money   {

  private final int euros;
  private final int cents;

  //CONSTRUCTORS
  public Money(int euros, int cents)  {

    if(cents > 99)  {
      euros += cents / 100;
      cents %= 100;
    }

    this.euros = euros;
    this.cents = cents;
  }

  //METHODS
  public int euros()  {
    return euros;
  }

  public int cents()  {
    return cents;
  }

  public String toString()  {
    String zero = "";
    if (cents <= 10)  {
      zero = "0";
    }

    return euros + "." + zer + cenets + "e";
  }




//class ends here
}
