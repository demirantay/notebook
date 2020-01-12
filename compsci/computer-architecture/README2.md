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

### What are gates ?

### AND Gate

### OR Gate

### NOT(Inverter) Gate

### NAND Gate

### NOR Gate

### Exclusive-OR Gate

### Exclusive-NOR Gate

<Br>
<br>
  
---

<br>
<br> 

# Registers 
