## Java

- This is how you write the famous "Hello, World!"
  ```java
  System.out.println("Hello, World!");
  ```   
<br>

- Every piece of code in java must be written inside classes. The class name is the file name and you must have at least one `public static void main(..){..} ` function since the    language needs a entry point for the program.
  ```java
   public class Main {
     public static void main(String[] args) {
       System.out.println("foo");
     }
   }
   ```
<br/>

- You can define variables with their types as their prefix. For example if you would like to define a integer you need to define `int` as the prefix.
  ```java
  int months = 12;
  String text = "foo";
  double decimal_number = 3.1415;
  boolean isTrue = true;

  System.out.println("There are " + months + " in a year");
  ```

<br/>

- Except for few such as integer values to decimal variable data types are immutable
  ```java
  String text = "Foo";
  text = 42; // Does not work :(

  //but

  double decimal_number = 3.1415;
  decimal_number = 3; // Works! :)
  ```

<br/>

- You can get user *input* with the `Scanner` object. First you need to create the object and then you can simply use it for text and if you would like to read integers you simply need to parse it to `Integer(..)`
  ```Java
  import java.util.Scanner;

  public class Main {
    public static void main(Static[] args) {
      Scanner input = new Scanner(System.in);

      // To simply read text
      System.out.print("Type a text: ");
      String user_input = input.nextLine() 

      // Or you can read integers
      System.out.print("Type a number: ");
      int user_number = Integer.parseInt(input.nextLine())
    }
  }
  ```
