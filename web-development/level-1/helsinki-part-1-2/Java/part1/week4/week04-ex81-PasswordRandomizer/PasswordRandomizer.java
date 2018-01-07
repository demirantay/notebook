import java.util.Random;

public class PasswordRandomizer {
  private int passwordLength;
  private Random random = new Random();
  private String alphabet = "abcdefghijklmnopqrstuvwxyz";
  private String newPwd = "";

  //constructor
  public PasswordRandomizer(int passwordLength) {
    this.passwordLength = passwordLength;
  }

  public String createPassword()  {
    int i = 0;
    while (i < this.passwordLength) {
      int n = random.nextInt(25) + 1;
      char pwdSymbol = this.alphabet.charAt(n);
      this.newPwd = this.newPwd + pwdSymbol;
      i++;
    }
    return newPwd;
  }


}
