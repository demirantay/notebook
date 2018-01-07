public class p18_2  {

  //fields
  private String name;
  private int price;
  private int amount;

  //behavior
  public void printProduct() {
    System.out.println(this.name + "price: " + this.price+ "amount: " +this.amount);
  }

  public void increaseAmount()  {
    this.amount++;
  }


  //constructor
  public p18_2(String initialname, int initialAmount, int initialPrice) {
    this.price = initialPrice;
    this.name = initialname;
    this.amount = initialAmount;
  }

}
