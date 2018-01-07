//university of hellinski

//imports
import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;

public class DecreasingCounterMain  {
  public static void main(String[] args)  {

    DecreasingCounter counter = new DecreasingCounter(10);

    counter.printValue();
    counter.decrease();
    counter.printValue();
    counter.decrease();

    counter.counterReset();
    counter.printValue();

    counter.setInitial();
    counter.printValue();

  }
}
