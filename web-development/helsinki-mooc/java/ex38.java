import java.util.Scanner;

public class ex38 {

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    System.out.print("How many times: ");
    int user_input = Integer.parseInt(input.nextLine());

    for (int i = 0; i < user_input; i++) {
      print();
    }
  }  // entry point

  public static void print() {
    System.out.println("Hello in the begning there was Java");
  }

}
