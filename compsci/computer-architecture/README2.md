# Random Access Memory (RAM)

- In random-access memory(RAM) the memory cells can be accessed for information transfer from any desired random location. That is, the process of locating a word in memory is the same and requires an equal amount of time no matter where the cells are located physically in memory.

  Communication between a memory and its environment is achieved through data input and output lines, address selection lines, and control lines that specify the direction of transfer.

### RAM: Write and Read Operations

- The two operations that a random access memory can perform are the write and read operations. The write signal specifies a transfer-in operation and the read signal specifies a transfer-out operation. On accepting one of these control signals. The internal circuits inside the memory provide the desired function.

<br>
<bR>

---

<br>
<br>

# Read Only Memory (ROM)

- As the name implies, a read-only memory(ROM) is a memory unit that performs the read operation only; it does not have a write capability. This implies that the binary information stored in a ROM is made permanent during the hardware production of the unit and cannot be altered by writing different words into it.

  Whereas a RAM is a general-purpose device whose contents can be altered during the computational process, a ROM is restricted to reading words that are permanently stored within the uni

### ROM: Different Types of ROM

- The ROM does not need a read-control line since at any given time, the output lines automatically provide the n bits of the word selected by the address value. Because the outputs are a function of only the present inputs (the address lines), a ROM is classified as a combinational circuit. In fact, a ROM is constructed internally with decoders and a set of OR gates. There is no need for providing storage capabilities as in RAM, since the values of the bits in the ROM are permanently fixed.

- The required paths in a ROM may be programmed in three different ways.
  - The first, mask programming, is done by the semiconductor company during the last fabrication process of the unit. This procedure is costly because the vendor charges the customer a special fee for custom masking the particular ROM. For this reason, mask programming is economical only if a large quantity of the same ROM configuration is to be ordered.
  - For small quantities it is more economical to use a second type of ROM called a Programmable Read Only Memory(PROM). The hardware procedure for programming ROMs or PROMs is irreversible, and once programmed, the fixed pattern is permanent and cannot be altered. Once a bit pattern has been established, the unit must be discarded if the bit pattern is to be changed.
  - Third type of ROM available is called Erasable PROM or EPROM. The EPROM can be restructured to the initial value even though its fuses have been blown previously. Certain PROMs can be erased with electrical signals instead of ultraviolet light. These PROMs are called Electrically Erasable PROM or EEPROM. Flash memory is a form of EEPROM in which a block of bytes can be erased in a very short duration.
  
<br>
<br>

---

<br>
<br>

# Architecture of Computer System

- Computer is an electronic machine that makes performing any task very easy. In computer, the CPU executes each instruction provided to it, in a series of steps, this series of steps is called Machine Cycle, and is repeated for each instruction. One machine cycle involves fetching of instruction, decoding the instruction, transferring the data, executing the instruction.

  Computer system has five basic units that help the computer to perform operations, which are given below:
  - 1 - Input Unit
  - 2 - Output Unit 
  - 3 - Storage Unit
  - 4 - Artihmetic Logic 
  - 5 - Control Unit

### Input

- Input unit connects the external environment with internal computer system. It provides data and instructions to the computer system. Commonly used input devices are keyboard, mouse, magnetic tape etc.

### Output

- It connects the internal system of a computer to the external environment. It provides the results of any computation, or instructions to the outside world. Some output devices are printers, monitor etc.

### Storage Unit 

- This unit holds the data and instructions. It also stores the intermediate results before these are sent to the output devices. It also stores the data for later use.

  The storage unit of a computer system can be divided into two categories:
  - `Primary Storage` -- This memory is used to store the data which is being currently executed. It is used for temporary storage of data. The data is lost, when the computer is switched off. RAM is used as primary storage memory.
  - `Secondary Storage` -- The secondary memory is slower and cheaper than primary memory. It is used for permanent storage of data. Commonly used secondary memory devices are hard disk, CD etc.

### Arithmetic Logic Unit

- All the calculations are performed in ALU of the computer system. The ALU can perform basic operations such as addition, subtraction, division, multiplication etc. Whenever calculations are required, the control unit transfers the data from storage unit to ALU. When the operations are done, the result is transferred back to the storage unit.

### Control Unit

- It controls all other units of the computer. It controls the flow of data and instructions to and from the storage unit to ALU. Thus it is also known as central nervous system of the computer.

### CPU

- It is Central Processing Unit of the computer. The control unit and ALU are together known as CPU. CPU is the brain of computer system. It performs following tasks:
  - It performs all operations.
  - It takes all decisions.
  - It controls all the units of computer.

<Br>
<br>
  
---

<Br>
<bR>
  
# Logic gates

- Binary information is represented in digital computers by physical quantities called signals. Electrical signals such as voltages exist throughout the computer in either one of the two recognizable states. The two states represent a binary variable that can be equal to 1 or 0.

  For example, a particular digital computer may employ a signal of 3 volts to represent binary 1 and 0.5 volt to represent binary 0. Now the input terminals of digital circuits will accept binary signals of only 3 and 0.5 volts to represent binary input and output corresponding to 1 and 0, respectively.
  
  So now we know, that at core level, computer communicates in the form of 0 and 1, which is nothing but low and high voltage signals.
  
  But how are different operations performed on these signals? That is done using different logic Gates.

### What are gates ?

- Gates are blocks of hardware that produce graphic symbol and its operation can be described by means of an algebraic expression. The input-output relationship of the binary variables for each gate can be represented in tabular form by a truth-table.

  The most basic logic gates are AND and inclusive OR with multiple inputs and NOT with a single input. And you can build other gates from combining different basic gates such as XOR ...etc.
  
  The various logical gates are:
  - AND
  - OR
  - NOT
  - NAND
  - NOR
  - XOR
  - XNOR

### AND Gate

- The AND gate produces the AND logic function, that is, the output is 1 if input A and input B are both equal to 1; otherwise the output is 0.

### OR Gate

- The OR gate produces the inclusive-OR function; that is, the output is 1 if input A or input B or both inputs are 1; otherwise, the output is 0.

### NOT(Inverter) Gate

- The inverter circuit inverts the logic sense of a binary signal. It produces the NOT, or complement, function. So if you input 1 it becomes 0 and vice versa

### NAND Gate

- The NAND function is the complement of the AND function, as indicated by the graphic symbol, which consists of an AND graphic symbol followed by a small circle. So it is esentially (NOT-invert(AND))

### NOR Gate

- The NOR gate is the complement of the OR gate and uses an OR graphic symbol followed by a small circle. So it is essentially (NOT-invert(OR))

### Exclusive-OR Gate

- The exclusive-OR gate has a graphic symbol similar to the OR gate except for the additional curved line on the input side.

  The output of the gate is 1 if any input is 1 but excludes the combination when both inputs are 1. It is similar to an odd function; that is, its output is 1 if an odd number of inputs are 1.

### Exclusive-NOR Gate

-   The exclusive-NOR is the complement of the exclusive-OR, as indicated by the small circle in the graphic symbol.

  The output of this gate is 1 only if both the inputs are equal to 1 or both inputs are equal to 0.

<Br>
<br>
  
---

<br>
<br> 

# Registers 

- Register is a very fast computer memory, used to store data/instruction in-execution. A Register is a group of flip-flops with each flip-flop capable of storing one bit of information. An n-bit register has a group of n flip-flops and is capable of storing binary information of n-bits.

  A register consists of a group of flip-flops and gates. The flip-flops hold the binary information and gates control when and how new information is transferred into a register. Various types of registers are available commercially. The simplest register is one that consists of only flip-flops with no external gates.
  
### Loading the Registers

- The transfer of new information into a register is referred to as loading the register. If all the bits of register are loaded simultaneously with a common clock pulse than the loading is said to be done in parallel.

### Register Transfer Language

- The symbolic notation used to describe the micro-operation transfers amongst registers is called `Register transfer language`.

  The term `register transfer` means the availability of `hardware logic circuits` that can perform a stated micro-operation and transfer the result of the operation to the same or another register.
  
  The word `language` is borrowed from programmers who apply this term to programming languages. This programming language is a procedure for writing symbols to specify a given computational process
  
  Following are some commonly used registers:
  - 1 - `Accumulator`: This is the most common register, used to store data taken out from the memory. 
  - 2 - `General Purpose Registers`: This is used to store data intermediate results during program execution. It can be accessed via assembly programming.
  - 3 - `Special Purpose Registers`: Users do not access these registers. These registers are for Computer system,
    - `MAR`: Memory Address Register are those registers that holds the address for memory unit.
    - `MBR`: Memory Buffer Register stores instruction and data received from the memory and sent from the memory.
    - `PC`: Program Counter points to the next instruction to be executed.
    - `IR`: Instruction Register holds the instruction to be executed.

### Arithmetic Logical Unit

- Instead of having individual registers performing the micro-operations, computer system provides a number of registers connected to a common unit called as Arithmetic Logical Unit (ALU). ALU is the main and one of the most important unit inisde CPU of computer. All the logical and mathematical operations of computer are performed here. The contents of specific register is placed in the in the input of ALU. ALU performs the given operation and then transfer it to the destination register.

<br>
<br>

---

<br>
<br>

# Computer Architecture: Instruction Codes

- While a Program, as we all know, is, A set of instructions that specify the operations, operands, and the sequence by which processing has to occur. An instruction code is a group of bits that tells the computer to perform a specific operation part.

### Instruction Code: Operation Code

- The operation code of an instruction is a group of bits that define operations such as add, subtract, multiply, shift and compliment. The number of bits required for the operation code depends upon the total number of operations available on the computer

### Instruction Code: Register Part

- The operation must be performed on the data stored in registers. An instruction code therefore specifies not only operations to be performed but also the registers where the operands(data) will be found as well as the registers where the result has to be stored.

- `Stored Program Organisation` -- The simplest way to organize a computer is to have `Processor Register` and instruction code with two parts. The first part specifies the operation to be performed and second specifies an address. The memory address tells where the operand in memory will be found.

- `Common Bus System` -- The basic computer has 8 registers, a memory unit and a control unit. Paths must be provided to transfer data from one register to another. An efficient method for transferring data in a system is to use a Common Bus System. The output of registers and memory are connected to the common bus.


