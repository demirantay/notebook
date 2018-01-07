public class Counter  {

  //fields
  private int value;
  private boolean check;

  //constructors
  public Counter(int startingValue, boolean check)  {
    //creates a new counter with the given value. The check is on if the parameter given to check was true.
    this.value = startingValue;
    if (check == true)  {
      this.check = true;
    }
  }

  public Counter(int startingValue)  {
    //creates a new counter with the given value. The check on the new counter should be off.
    this.value = startingValue;
    this.check = false;
  }

  public Counter(boolean check) {
    //creates a new counter with the starting value 0. The check is on if the parameter given to check was true.
    this.value = 0;
    if (check == true)  {
      this.check = true;
    }
  }

  public Counter()  {
    //creates a new counter with the starting value of 0 and with checking off.
    this.value = 0;
    this.check = false;
  }

  //behaviors
  public int value()  {
    return this.value;
  }

  public void increase()  {
    this.value++;
  }

  public void decrease()  {
    //decreases the value but cannot go below 0 if check is on
    if (this.value == 0 && this.check == true)  {
      this.value = 0;
    }
    else if (this.value > 0)  {
      this.value--;
    }
  }



}
