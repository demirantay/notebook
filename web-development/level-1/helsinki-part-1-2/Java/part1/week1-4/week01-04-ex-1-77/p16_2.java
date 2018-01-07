public class p16_2 {
  //object states
  private String name;
  private int amount;
  private int price;

  //constuctor
  public p16_2(String initialName, int initialAmount, int initialprice)  {
    this.name = initialName;
    this.amount = initialAmount;
    this.price = initialprice;
  }

  //methods
  public void printProduct() {
    System.out.println(" Product Name: " + this.name + ", amount : " + this.amount + ", price : " + this.price);
  }

  public void becomeOlder() {
    this.amount++;
  }

  public int getAge() {
    return this.amount;
  }

//class ends here
}
