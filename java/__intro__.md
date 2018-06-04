## Java

- This is how you write the famous "Hello, World!"
  ```java
  System.out.println("Hello, World!");
  ```   
<br/>

- If you want to execute your java programs you need to compile them first since java is not a interpreted language
  ```bash
  $ javac fileName.java  # Compiles the code

  $ java fileName  # Run the code
  ```

<br/>

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
  ```java
  import java.util.Scanner;

  public class Main {
    public static void main(Static[] args) {
      Scanner input = new Scanner(System.in);

      // To simply read text written next line
      System.out.println("Type a text: ");
      String user_input = input.nextLine();

      // Or you can read integers
      System.out.println("Type a number: ");
      int user_number = Integer.parseInt(input.nextLine());
    }
  }
  ```

<br/>

- You cannot compare string to each other with `==` as you would normally do with integers however you need to use `.equals(..)`
  ```java
  String text = "foo";
  String another_text = "bar";

  if (text.equals(another_text)) {
    System.out.println("They are equal!");
  } else {
    System.out.println("They are NOT equal!");
  }
  ```

<br/>

- While, For and For Each loops logic is same and you can write each in the following way
  ```Java
  // While
  while(true) {
    // ...
  }

  // For
  for (int i = 0; i < 10; i++) {
    // ...
  }

  // For Each
  String[] exmaplesList = {'foo', 'bar', 'baz'};
  for (String example : examplesList) {
    // ...
  }
  ```

<br/>

- You can write your own defined methods in the main.java file like this. If you give void method parameter to your self defined functions the function does not have to return anything. Yet, if you give anything other than void the function needs to return a value
  ```Java
  public class Main {

    // creates a void function
    public static void printLine() {
      System.out.println("hey");
    }

    // function that needs to return a integer
    public static int foo() {
      return 13;
    }

    public static void main(String[] args) {
      printLine(); // prints "hey"

      int number = foo(); // var contains 13;
    }
  }
  ```

<br>
