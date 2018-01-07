import java.util.*;
import java.util.ArrayList;

public class Phonebook  {
  private ArrayList<Person> phoneBook;

  //constructor
  public Phonebook()  {

  }

  //methods
  public void add(String name, String number) {
    this.phoneBook = new Phonebook();
    this.phoneBook.add(name, number);
  }

  public void printAll()  {
    for (int i = 0; i < phoneBook.size(); i++)  {
      println(phoneBook.get(i));
    }
  }
}
