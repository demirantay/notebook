public class Main {
  public static void main(String[] args) {

    Person demir = new Person("Demir", 1999);
    Person tugrul = new Person("Tugrul", 1995);

    System.out.println(demir);
    System.out.println(tugrul);

    if (demir.isOlder(tugrul)) {
      System.out.println("Demir is older");
    } else {
      System.out.println("Demir is not older");
    }


  }
}
