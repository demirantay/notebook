# Gate Logic

## Boolean Logic and Expressions

- Boolean Logic and Algebra was invented by a mathematichian named George Boole. The main idea is that the bianry values has two sets of types one is `1` which is true, on and `0` which is false, off

- Boolean operations 
  `(x AND y)` is equal to :
  
  |x|y|AND|        
  |-|-|--|         
  |0|0|0|
  |0|1|0|
  |1|0|0|
  |1|1|1|

  and `(x OR y)` is equal to:
  
  |x|y|OR|
  |-|-|--|
  |0|0|0|
  |0|1|1|
  |1|0|1|
  |1|1|1|
  
  and `NOT(x)` is equal to:
  
  |x|NOT|
  |-|-|
  |1|0|
  |0|1|
 
- After knowing the boolean operations you can now solve some boolean expressions:
  lets see this question:   NOT(0 OR (1 AND 1)) == 0
  
- A `nand` is basically NOT AND so what ever the result of your and is just convert it and you have a nand value.
  
## Logic Gates

Logic gates are very small chips that are specifaclly created for uniqe tasks and logic gates seperate to two:

- `Elementary` : which are the simple chips for Nand, And, Or, Not, ...)
-  `Composite` : which are the chips that are created from gathering elementary logic gates such as (Mux, Adder, ...)

## Hardware Description Language 

While writing chips you do not have to define it's specifications, ins, outputs .. etc. This is because as a computer science your job is not to desing chips there are professions just for that.

Lets write a exmaplry `Foo Gate` chip design in HDL (hardware description language)
```
/** Foo Gate: out = (a AND NOT(b)) OR (NOT(a) and b)) */

Chip Foo {
  IN a, b;
  OUT out;
  
  PARTS:
    // implemantation missing
}
```
