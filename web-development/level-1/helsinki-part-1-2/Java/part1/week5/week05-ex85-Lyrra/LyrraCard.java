public class LyrraCard  {
  //fields
  private double balance;

  //consturctors
  public LyrraCard(double balance)  {
    this.balance = balance;
  }

  //behaviors
  public double getBalance()  {
    return this.balance;
  }

  public void loadMoney(double amount) {
    this.balance += amount;
  }

  public boolean pay(double amount) {
    if (this.balance < amount) {
      return false;
    }
    this.balance -= amount;
    return true;
  }

//class ends here
}
