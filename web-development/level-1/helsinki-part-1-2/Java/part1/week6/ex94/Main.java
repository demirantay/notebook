//started week06 of MOOCs provided by the university of helsinki

public class Main {
  public static void main(String[] args)  {

    Person demir = new Person("demir", "1234567890");

    System.out.println(demir.getName());
    System.out.println(demir.getNumber());

    System.out.println(demir);
    demir.changeNum("0987654321");
    System.out.println(demir);
  }
}
