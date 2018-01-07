public class BoundedCounter {
  private int value;
  private int upperLimit;

  //consturctor
  public BoundedCounter(int upperLimit) {
    this.value = 0;
    this.upperLimit = upperLimit;

  }

  public void next()  {
    if (value >= upperLimit) {
      this.value = 0;
    }
    else  {
      this.value++;
    }
  }

  public String toString()  {
    return " " + this.value;
  }

  public int getValue() {
    return this.value;
  }
}
