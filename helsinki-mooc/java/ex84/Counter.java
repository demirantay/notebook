public class Counter {
  private int value;
  private boolean check;

  // Consturctors
  public Counter(int initial_value) {
    this.value = initial_value;
  }

  public Counter(int initial_value, boolean init_check) {
    this.value = initial_value;
    if (init_check == true) {
      this.check = true;
    } else {
      this.check = false;
    }
  }

  // behaviours
  public String toString() {
    return "Value: " + this.value + " | Check: " + this.check;
  }

  public int value() {
    return this.value;
  }

  public void increase() {
    this.value++;
  }

  public void decrease() {
    if (this.value < 1) {
      // do nothing
    } else {
      this.value--;
    }
  }

}
