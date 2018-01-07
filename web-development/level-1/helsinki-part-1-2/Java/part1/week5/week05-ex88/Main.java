//university of helsinki week 05

import java.util.*;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
  public static void main(String[] args)  {

    Scanner userInput = new Scanner(System.in);
    ArrayList<Student> studentList = new ArrayList<Student>();

    while(true){
      //get inputs
      System.out.print("Student name : ");
      String inputName = userInput.nextLine();
      System.out.print("Student number: ");
      String inputNum = userInput.nextLine();

      //adding them to the ArrayList
      studentList.add(new Student(inputName, inputNum));

      //print everything and break if pinputs are empty
      if (inputName.equals("") && inputNum.equals(""))  {
        for (int i = 0; i < studentList.size() - 1; i++)  {
          System.out.println(studentList.get(i));
        }
        break;
      }
    }
  //main method ends here
  }

}
