//university of helsinki week 06
//ex 98 - Reversing and copying of an array


import java.util.*;
import java.util.Arrays;


public class Main {

  //main method
  public static void main(String[] args)  {
    int[] original = {1, 2, 3, 4};
    int[] copied = copy(original);
    int[] reverse = reverseCopy(copied);

    //change the compied
    copied[0] = 99;

    System.out.println(Arrays.toString(original));
    System.out.println(Arrays.toString(copied));
    System.out.println(Arrays.toString(reverse));
  }

  //other methods
  public static int[] copy(int[] original) {
    int[] copied = new int[original.length];

    for (int i = 0; i < original.length; i++) {
      copied[i] = original[i];
    }
    return copied;
  }

  public static int[] reverseCopy(int[] copy) {
    int[] reverse = new int[copy.length];

    int j = 0;
    for (int i = copy.length; i > 0; i--) {
      reverse[j] = copy[i - 1];
      j++;
    }

    return reverse;
  }


//class ends here
}
