import java.util.Scanner;
import java.util.ArrayList;

public class ex61 {

  public static void print_list(ArrayList<String> list) {
    for (String word : list) {
      System.out.println(word);
    }
  }

  public static void remove_last(ArrayList<String> list) {
    list.remove(list.size() - 1);
  }

  // entry point
  public static void main(String[] args) {
    ArrayList<String> languages = new ArrayList<String>();

    languages.add("C++");
    languages.add("Java");
    languages.add("Python");
    languages.add("Rust");
    languages.add("Clojure");

    print_list(languages);

    remove_last(languages);
    System.out.println("");

    print_list(languages);

  }
}
