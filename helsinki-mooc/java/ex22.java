import java.util.Scanner;

public class ex22 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    String password = "demir";

    while(true){
      System.out.print("Password: ");
      String user_input = input.nextLine();

      if (user_input.equals(password)) {
        System.out.println("Hi, demir");
        break;
      } else {
        System.out.println("Wrong!");
      }
    }
  }// main entry func
}
