public class Person {

  private String name;
  private String phoneNum;

  //constructors
  public Person(String name, String phoneNum) {
    this.name = name;
    this.phoneNum = phoneNum;
  }

  //behaviors methods
  public String getName() {
    return this.name;
  }

  public String getNumber() {
    return this.phoneNum;
  }

  public String toString()  {
    return this.name + ", phone no: "+ this.phoneNum;
  }

  public String changeNum(String newNumber) {
    return this.phoneNum = newNumber;
  }






//class ends here
}
