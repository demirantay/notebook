// university of helsinki week 4

//imports

import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
  public static void main(String[] args) {

    PasswordRandomizer demir = new PasswordRandomizer(20);

    String demirsPwd = demir.createPassword();

    System.out.println(demirsPwd);
  }
}
