public class Product {
  //private vars
  private String name;
  private int amount;
  private int price;

  //constructor
  public Product(String initial_name, int inital_amount, int initial_price ) {
    this.name = initial_name;
    this.amount = inital_amount;
    this.price = initial_price;
  }

  //methods
  public void print_product() {
    System.out.println(
        "Name: "+this.name+" | Amount: "+this.amount+" | Price: "+this.price+"$"
      );
  }
}
