//last exersice in week 04 of univeristy of helsinki

//imports
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.*;

public class Main   {
  public static void main(String[] args) {

    HangmanLogic first = new HangmanLogic("demir");
    System.out.println("Guessing the numbers : a b c d e");
    first.guessLetter("A");
    first.guessLetter("B");
    first.guessLetter("C");
    first.guessLetter("D");
    first.guessLetter("E");
    System.out.println("guessed letters : " + first.guessedLetters());
    System.out.println("number of faults: "+ first.numberOfFaults());

  }
}
