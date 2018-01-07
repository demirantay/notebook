//imports
import java.util.*;
import java.util.ArrayList;

public class Suitcase  {
  private double weightLimit;
  private ArrayList<Thing> suitcaseThings;
  private double weight;

  //consturctor
  public Suitcase(double limit) {
    this.weightLimit = limit;
    this.suitcaseThings = new ArrayList<Thing>();
    this.weight = 0;
  }

  //methods
  public void addThing(Thing thing) {

    if (this.weight >= this.weightLimit){
      System.out.println("cannot exceed the weight limit");
    }
    else if (this.weight < this.weightLimit) {
      this.suitcaseThings.add(thing);
      this.weight += thing.getWeight();
    }
  }

  public String toString()  {
    double items = 0;
    for (int i = 0; i < this.suitcaseThings.size(); i++) {
      items++;
    }
    return items+" things" + "(" + this.weight+" kg)";
  }
}
