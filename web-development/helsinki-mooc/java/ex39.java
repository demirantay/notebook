import java.util.Scanner;

public class ex39 {

  public static void main(String[] args) {
    print_rect(10,3);
  } // entry point

  public static void printStars(int number) {
    for (int i = 0; i < number; i++) {
      System.out.print('*');
    }
    System.out.println("");
  }

  public static void print_square(int side_size) {
    for (int i = 0; i < side_size;  i++) {
      printStars(side_size);
    }
  }

  public static void print_rect(int width, int height) {
    for (int i = 0; i < height; i++) {
      printStars(width);
    }
  }
}
