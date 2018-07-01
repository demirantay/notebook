import java.util.Random;
import java.util.ArrayList;

public class Lottery {
  private ArrayList<Integer> numbers = new ArrayList<Integer>();

  public Lottery() {
    this.numbers = numbers;
    this.draw_numbers();
  }

  public ArrayList<Integer> get_numbers() {
    return this.numbers;
  }

  public void draw_numbers() {
    Random random = new Random();
    for (int i = 0; i < 7; i++) {
      int number = random.nextInt(99) + 1;
      this.numbers.add(number);
    }
  }

}
