# Cheatsheet for Simulation tools

- If you do not want to run your chips using the hardware simulation tool you can use test scripts. The way you use them is this. Lets say I have a defined XOR chip written like this in hdl language:
  ```hdl
  CHIP Xor {
    In a, b;
    OUT out;
    
    PARTS:
    Not (in=a, out=nota);
    Not (in=b, out=notb);
    And (a=a, b=notb, out=aAndNotb);
    And (a=nota, b=b, out=NotaAndb);
    Or  (a=aAndNotb, b=notaAndb, out=out);
  }
  ```
  You can run this chipset and test it with a testing script that the course provides us. The syntax for testing is thhe following: (You need to name it as `Xor.tst`:
  ```
  load Xor.hdl;
  set a 0, set b 0, eval;
  set a 0, set b 1, eval;
  set a 1, set b 0, eval;
  set a 1, set b 1, eval;
  ```
  See! we ran four tests for our Xor chip values 
