public class CashRegister {
  private double cashInRegister; //amount of cash in the register
  private int economicalSold; //amount of economical lunches sold
  private int gourmetSold; //amount of gourmet linches sold

  //constructor
  public CashRegister() {
    this.cashInRegister = 1000;
  }

  public double payEconomical(double cashGiven) {
    double economicPrice = 2.50;
    if (cashGiven >= economicPrice)  {
      this.cashInRegister += economicPrice;
      this.economicalSold++;
      cashGiven -= economicPrice;
      return cashGiven;
    }
    else  {
      System.out.print("The money is not enough :");
      return cashGiven;
    }
  }

  public double payGourmet(double cashGiven)  {
    double gourmetPrice = 4.00;
    if (cashGiven >= gourmetPrice)  {
      this.cashInRegister += gourmetPrice;
      this.gourmetSold++;
      cashGiven -= gourmetPrice;
      return cashGiven;
    }
    else  {
      System.out.print("The money is not enough: ");
      return cashGiven;
    }
  }


  public String toString()  {
    return "money in register "+this.cashInRegister+" economical lunches sold:"+this.economicalSold+" gourmet lunches sold: "+this.gourmetSold;
  }

  

//class ends heres
}
