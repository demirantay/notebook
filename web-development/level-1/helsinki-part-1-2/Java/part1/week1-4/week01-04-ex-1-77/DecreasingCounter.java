public class DecreasingCounter  {
  //field
  private int value;
  private int initialNum;
  //constructor
  public DecreasingCounter(int initialNum)  {
    this.value = initialNum;
  }

  //behaviors
  public void printValue()  {
    System.out.println("This value: " + this.value);
  }

  public int decrease()  {
    if(this.value > 0)  {
      this.value--;
    }
    else if (this.value <= 0) {
      this.value = 0;
    }
    return this.value;
  }

  public void counterReset()  {
    this.value = 0;
  }

}
