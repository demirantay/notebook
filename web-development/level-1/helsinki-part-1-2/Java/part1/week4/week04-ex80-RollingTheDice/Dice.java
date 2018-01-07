//dice class
import java.util.Random;

public class Dice {
  private Random random;
  private int numberOfSides;

  //constructor
  public Dice(int numberOfSides) {
    this.numberOfSides = numberOfSides;
    random = new Random();
  }

  public int roll() {
    return random.nextInt(6) + 1;
  }

  
}
