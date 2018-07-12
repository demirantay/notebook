public class Person {
  private String name;
  private int age;

  // Constructors
  public Person(String name) {
    this.name = name;
    this.age = 0;
  }

  public Person(String name, int birthYear) {
    this.name = name;
    this.age = 2018 - birthYear;
  }

  // methods
  public String toString() {
    return "Name: " + this.name + " | Age: " + this.age;
  }

  public boolean isOlder(Person comparedPerson) {
    if (this.age > comparedPerson.age) {
      return true;
    } else {
      return false;
    }
  }

}
