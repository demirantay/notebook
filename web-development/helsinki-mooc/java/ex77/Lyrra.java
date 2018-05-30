public class Lyrra {
  private double balance;

  public Lyrra(double initial_balance) {
    this.balance = initial_balance;
  }

  public String toString() {
    return "Balance: " + this.balance;
  }

  public void pay_economical() {
    if (this.balance < 2.50) {
      System.out.println("NOT enough balance");
    } else {
      this.balance -= 2.50;
    }
  }

  public void pay_gourmet() {
    if (this.balance < 4.00) {
      System.out.println("NOT enough balance");
    } else {
      this.balance -= 4.00;
    }
  }

  public void load_money(double money) {
    if (money >= 0) {
      this.balance += money;
    } else {
      System.out.println("You cannot load a negative amount");
    }

  }

}
