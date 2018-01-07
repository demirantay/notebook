public class Student  {
  private String name;
  private String studentNumber;

  //CONSTURCTORS
  public Student(String name, String studentNumber) {
    this.name = name;
    this.studentNumber = studentNumber;
  }

  //METHODS
  public String getName() {
    return this.name;
  }

  public String getStudentNumber()  {
    return this.studentNumber;
  }

  public String toString()  {
    return this.name+", student num: "+this.studentNumber;
  }


}
