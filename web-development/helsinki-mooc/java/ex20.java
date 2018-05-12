import java.util.Scanner;

public class ex20 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    String db_username = "demir";
    int db_age = 19;
    String db_password = "asd";

    System.out.print("Username: ");
    String username = input.nextLine();

    System.out.print("Age: ");
    int age = Integer.parseInt(input.nextLine());

    System.out.print("Password: ");
    String password = input.nextLine();

    if (username.equals(db_username) && age == db_age && password.equals(db_password)) {
      System.out.println("Logged in");
    } else {
      System.out.println("Invalid credits");
    }

  }// main entry func
}
