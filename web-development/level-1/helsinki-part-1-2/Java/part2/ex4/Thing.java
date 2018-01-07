public class Thing {
    private String name;
    private double weight;

    //constructors
    public Thing(String name, double weight)  {
      this.name = name;
      this.weight = weight;
    }

    //methods
    public String getName() {
      return this.name;
    }

    public double getWeight()  {
      return this.weight;
    }

    public String toString()  {
      return "name: "+this.name+", wight: "+this.weight;
    }
}
