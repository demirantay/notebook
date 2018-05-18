import java.util.Scanner;

public class ex51 {

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    System.out.print("Type your name: ");
    String name = input.nextLine();

    for (int i = 0; i < name.length(); i++) {
      System.out.println((i+1) + ". character: " + name.charAt(i));
    }
  }

}
