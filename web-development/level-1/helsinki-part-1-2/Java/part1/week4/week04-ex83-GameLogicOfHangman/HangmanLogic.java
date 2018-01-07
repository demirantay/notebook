public class HangmanLogic {

  //fields
  private String word;
  private String guessedLetters;
  private int numberOfFaults;

  //constructor
  public HangmanLogic(String word) {
    this.word = word.toUpperCase();
    this.guessedLetters = "";
    this.numberOfFaults = 0;
  }

  //behaviors
  public int numberOfFaults() {
    return this.numberOfFaults;
  }

  public String guessedLetters() {
    return this.guessedLetters;
  }

  public int losingFaultAmount()  {
    return 12;
  }

  public void guessLetter(String letter) {
       // program here the functionality for making a guess
       // if the letter has already been guessed, nothing happens
       if (this.word.contains(letter.toUpperCase()))  {
       }
       // it the word does not contains the guessed letter, the number of faults increases
       if (!this.word.contains(letter.toUpperCase())) {
         this.numberOfFaults++;
       }
       // the letter is added among the already guessed letters
       this.guessedLetters = this.guessedLetters + letter;
   }

}
