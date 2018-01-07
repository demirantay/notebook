//still hellinski

//imports
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

//program body
public class p14  {

  //main func
  public static void main(String[] args)  {
    //for inputs
    Scanner getInput = new Scanner(System.in);
    //array list
    ArrayList<String> teachers = new ArrayList<String>();

    while(true) {
      System.out.print("Please enter a teacher name: ");
      String teacherName = getInput.nextLine();

      Collections.sort(teachers);

      teachers.add(teacherName);

      if (teacherName.equals("")) {
        System.out.println("You typed these names : ");

        for (int i = 0; i < teachers.size(); i++) {
          System.out.println(teachers.get(i));
        }

        break;
      }

    }
  }
  //main func ends here

}
//ody ends here
