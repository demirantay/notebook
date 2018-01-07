public class LyrraCard  {
  private double balance;

  //constructor
  public LyrraCard(int initialBalance)  {
    this.balance = initialBalance;
  }
  //toString printing method
  public String toString()  {
    return "The card has "+ this.balance+" euors";
  }

  public void payEconomical() {
    if (this.balance > 2.50)  {
      this.balance = this.balance - 2.50;
    }
    else  {
      System.out.println("Not enough balance");
    }
  }

  public void payGourmet()  {
    if (this.balance > 4) {
      this.balance = this.balance - 4;
    }
    else {
      System.out.println("Not enough balance");
    }
  }




}
