// practice 02 doing the exersices from the university of hellinski week 1

public class p02 {
  public static void main(String[] args) {
    //exersice 1
    int chickens = 3;
    double baconKg = 5.5;
    String tractorCount = "There is none";

    chickens = 9000;
    baconKg = 0.1;
    tractorCount = "There is 1";

    System.out.print("chikens :" + chickens + "\nBacon amount in kg: " + baconKg + "\ntactaor count: " + tractorCount + "\n");

    //exersice 2
    //basic operations
    int a =10;
    int b = 9;
    int sum =a + b;
    System.out.println(sum);

    // exersce 3
    int result = 3;
    int result2 = 2;

    double quotient  = result / result2 * 1.0;
    System.out.println(quotient);

    //exersice 4
    //calculate how many seconds are in a 365 day year
    int secondsInHour = 60 * 60 ;
    int secondsInDay = secondsInHour * 24;
    int secondsInYear = secondsInDay * 365;
    System.out.println("There are " + secondsInHour + " seconds in a hour");
    System.out.println("There are " + secondsInDay + " seconds in a day");
    System.out.println("There are " + secondsInYear + " seconds in a year");

  }
}
