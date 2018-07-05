## Java

### Printing

- This is how you write the famous "Hello, World!"
  ```java
  System.out.println("Hello, World!");
  ```   

- If you want to execute your java programs you need to compile them first since java is not a interpreted language
  ```bash
  $ javac fileName.java  # Compiles the code

  $ java fileName  # Run the code
  ```

- Every piece of code in java must be written inside classes. The class name is the file name and you must have at least one `public static void main(..){..} ` function since the    language needs a entry point for the program.
  ```java
   public class Main {
     public static void main(String[] args) {
       System.out.println("foo");
     }
   }
   ```

- You can define variables with their types as their prefix. For example if you would like to define a integer you need to define `int` as the prefix.
  ```java
  int months = 12;
  String text = "foo";
  double decimal_number = 3.1415;
  boolean isTrue = true;

  System.out.println("There are " + months + " in a year");
  ```

- Except for few such as integer values to decimal variable data types are immutable
  ```java
  String text = "Foo";
  text = 42; // Does not work :(

  //but

  double decimal_number = 3.1415;
  decimal_number = 3; // Works! :)
  ```

### User Input

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

### Conditional Statements

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
### Loops

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

### Methods

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

- You can get make various kind of functions on functions that comes shipped with java itself. Such as you can do `.length()` to get the lnegth or `.charAt()` th get the character. You can find many more such as index of, substring and other things in the documentation.
  ```java
  String foo = "Foo";

  System.out.println(foo.length()) // prints 3
  System.out.println(foo.charAt(0)) // gets  `F`
  ```

### ArrayList

- Once you have too many objects that are in the same context instead of creating too many variables it is more logical to use lists(Arrays) you can use many self defined functions for ArrayList's too see them all open the official docs there are many more useful methods such as `.sort(..)`, `.reverse(..)` etc.
  ```java
  import java.util.ArrayList;

  public class Main {
    public static void main(String[] args) {

      ArrayList<String> name_list = new ArrayList<String>();

      name_list.add("demir");
      name_list.add("Anthony");

      System.out.println("The size is, " + name_list.size());

      System.out.println("First name: " + name_list.get(0));

      name_list.remove("demir");

      for (String name : name_list) {
        System.out.println(name); // prints only `Anthony`
      }
    }
  }
  ```

### Objects and Classes

- You can define objects very easily by their classes. Every data type is a object. You dont have to define primitive object(data) types like this because they already come shipped with java. Lets examine the `Scanner` object
  ```java
  Scanner input = new Scanner(..);
  // type is objects name & you create a new instance of the
  // class with `new Scanner()`
  ```
  You can create your primitive types like this too but since you have a shortcut there is no need to
  ```java
  String text =  new String("foo"); // this is too long

  String text = "foo"; // better
  ```
  So you may ask "okay, so how can we define classes" it is very simple. Create a new file.java and name the file name same as the class name. After you create a class you will need to give it some object variables that will be private to the object. You are not done, you will need to define a `constructor` that is always called when the object instance is crated and lastly you can have methods(behaviors) of the object. Lets create a persons class for example. :
  ```java
  class Person {
    // private object vars
    private String name;
    private int age;

    // constructor
    public Person(initial_name, initial_age) {
      this.name = initial_name;
      this.age = initial_age;
    }

    // behaviors
    public String get_name() {
      return this.name;
    }

    public int get_age() {
      return this.age;
    }

    public void become_older() {
      this.age++;
    }

    public String toString() {
      return "Name: " + this.name + "Age: " + this.age;
    }
  }
  ```
  In order to use this object in our main file we can simply create it like the ones we we have created earlier:
  ```java
  public class Main {
    public static void main(String[] args) {

      Person james = new Person("James", 20);

      System.out.println(james); // returns toString
    }
  }
  ```
- You can define multiple constructors in a object. It is used when we do not knowhow many parameters will the user give to the object instance when it is created for the first time, lets extend our `Person` class above :
  ```java
  public class Person {
    private String name;
    private int age;

    # constructors
    public Person() {
      this.name = "blank";
      this.age = 0;
    }

    public Person(String initial_name) {
      this.name = initial_name;
      this.age = 0;
    }

    public Person(String initial_name, int initial_age) {
      this.name = initial_name;
      this.age = initial_age;
    }

    ...
  }
  ```

### Arrays

- You can create `Arrays` like the following in the snippet however be sure that Arrays and ArrayLists are not the same thing. Most of the time ArrayLists are better off because it comes shipped with built in functions like add, sort ..etc. and  Unlike with ArrayLists, the size of the array (the amount of cells in an array) cannot be changed, growing an array always requires creating a new array and copying the cells of the old array to the new one.
  ```java
  int[] integerNumberArray = {100, 1, 42};                                     
  String[] characterStringArray = {"Matti P.", "Matti V."};
  double[] floatingNumberArray = {1.20, 3.14, 100.0, 0.01};
  ```
  You can change the indexes of arrays like the following code :
  ```java
  int[] numbers = {100,1,42};

  numbers[0] = 1;    // setting value 1 to index 0
  numbers[1] = 101;  // setting value 101 to index 1

  // the numbers array now looks like {1,101,42}
  ```
- The size of an array object can be found out by typing array.length into the code, notice that you don't use parentheses with this one. array.length() does not work!
  ```java
  int[] numbers = {1, 8, 10, 3, 5};

  int i = 0;
  while (i < numbers.length ) {
      System.out.println(numbers[i]);
      i++;
  }
  ```

- You can define the size of an array with the following code:
  ```java
  int[] array = new int[100];  // creates a `100 cell` sized array
  ```

- Even though I said earlier that Arrays do not have as many native built in java libraries like the ArrayLists does it is not true. The lovely smart poeple who use java actually coded :
  ```java
  import java.util.Arrays;
  ```
  Library and it actually has much more stuff than arraylists. But arraylists are always more convienent to use. Example code from the library:
  ```java
  int[] values = {-3, -111, 7, 42};
  Arrays.sort(values);
  for(int value: values) {
      System.out.println(value);
  }
  ```


Left it at week 7 on helsinki moocs ... will come back later.
