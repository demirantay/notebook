import java.util.ArrayList;

public class Menu {

  //vars
  private ArrayList<String> meals = new ArrayList<String>();

  //constructors
  public Menu() {
    this.meals = meals;
  }

  //methods
  public void add_meal(String meal) {
    this.meals.add(meal);
  }

  public void print_menu() {
    for(String n : meals) {
      System.out.println(n);
    }
  }

}
