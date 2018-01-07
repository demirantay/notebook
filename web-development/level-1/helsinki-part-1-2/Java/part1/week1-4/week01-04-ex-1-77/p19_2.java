//class multiplier

public class p19_2  {
  //fields
  private int number = 0;
  //behaviors
  public int multiply(int otherNumber) {
    otherNumber = otherNumber * this.number;
    return otherNumber;
  }
  //constructor
  public p19_2(int numberInitiliazed)  {
    this.number = numberInitiliazed;
  }
}
