# Computer Architecture 

A computer consists of four main components

- 1 - Input
- 2 - Output
- 3 - Central Processing Unit(CPU).
- 4 - Memory Unit.

<br>
<br>

# Input 

- The Computer accepts Coded information through input unit by the user. It is a device that is used to give required information to the computer. e.g., keyboard, mouse, etc.

<br>
<br>

# Output

- THe output sends the processed results to the user. It is Mainly used to display the desired results to the user. It is mainly used to display the desired result to the user as per input instruction. e.g , video monitor, printer and plotter, etc.

<br>
<br>

# CPU (Central Processing Unit)

- THe central processing unit consists set of register, arithmetic and control circuits, which together interpret and execute instructions in assembly language. The primary functions of the CPU are
  - The CPU transfers instructions and input data from main memory to registers. ie., internal memory.
  - The CPU executes the instructions in the stored sequence.
  - When necessary, CPU transfers output data from registers to main memory.
  
- Central Processing Unit (CPU) is often called the brain of computer. The CPU is fabricated as a single Integrated Circuit(IC) chip and is also known as Microprocessor . A CPU controls all the internal and external devices and performs arithmetic and logic operations. The CPU consists of three main subsystems; Arithmetic Logic Unit (ALU), Controls Unit(CU) and registers.

### ALU (Arithmetic Logic Unit)

- The arithmetic logic unit contains the electronic circuitry that executes all arithmetic and logical operations on the available data. It is used to perform all arithmetic calculations (addition, subtraction, multiplication and division) and logical calculation (<,>.+, AND, OR, etc). Logical unit performs comparison of numbers, letters and special characters. ALU uses registers to hold the data that is being processed. *The number and sizes of registers vary from processor to processor.*

### Registers

- Registers are special purpose and high speed temporary memory units. Registers are not referenced by their address, but are directly accessed and manipulated by the CPU during execution. Essentially, they hold the information that the CPU is currently working on. Registers store data, instructions, address and intermediate results of processing.

### Control Unit (CU)

- Control Unit coordinates with the input and output devices of a computer. It directs the computer to carry out stored program instructions by communicating with the ALU and the registers. It organises the processing of data and instructions.

  To maintain the proper sequence of processing data, the control unit uses clock inputs. The basic function of control unit is to fetch the instruction stored in the devices involved in it and accordingly generate control signals.

### Micro Processor

- The microprocessor is the controlling element in a computer system and is sometimes referred to as the chip. Microprocessor is main hardware that drives the computer.

  It is a targe Printed Circuit Board (PCB), Which is used in all electronic systems such as computer, calculator, digital system etc. The speed of CPU depends upon the type of microprocessor used.
  - Intel 40004 was the first microprocessor to contain all of the components of a CPU on a single chip with a 4-bit bus width.
  - Some of the popular microprocessors are intel, Dual core, Pentium IV, etc.
  
### Little Infos

- `Buffer` - is a temporary storage where register holds the data for further execution.
- `Accumulator` - is a register in a CPU in which intermediate arithmetic and logic results are stored.
- `Reduced instruction Set Computer (RISC)` and `Complex Instruction Set Computer(CISC)` -  are the two kinds of microprocessors classified on the basis of instruction set.
- The performance of computer is affected by the size of registers, size of RAM, speed of system clock and size of cache memory.
- The speed of processor is measured in millions of cycles per second or megahertz (MHz).


<br>
<Br>
<br>
<br>

# Memory Unit

- Memory is that part of the computer, WHich holds data and instructions, Memory is an integral component of the CPU. The memory unit consists of Primary memory and Secondary.

### Primary Memory

- Primary memory or main memory of the computer is used to store the data and instructions during
execution of the instructions. The primary memory is of two types; Random Access memory(RAM) and Read Only Memory (ROM).

- `RAM (Random Access Memory)` - It directly provides the required information to the processor. RAM is a volatile memory. It provides temporary storage for data and instructions. RAM is classified into two categories.
  - 1 - Static Random Access Memory (SRAM).
  - 2 - Dynamic Random Access Memory(DRAM).
  
- `ROM (Read Only Memory)` - It is used for storing standard processing Programs that permanently reside in the computer. Generally, designers program ROM chips at the time of manufacturing circuits. ROM is a non-volatile memory. It can only be read not written. ROM is classified into three categories
  - 1 - Programmable ROM(PROM).
  - 2 - Erasable Programmable ROM(EPROM).
  - 3 - Electrically Erasable Programmable ROM (EEPROM).

### Seconday Memory

- Secondary memory, also known as secondary storage or auxiliary memory, is used for storage data and instructions permanently e.g. hard disks, SSD,  CDs, DVDs, etc.


<br>
<Br>
<br>
<br>


# Connection of Units

- CPU sends data, instructions and information to the components inside the computer as well as to the peripherals and devices attached to it. Bus is a set of electronic signal pathways that allows information and signals to travel between components inside or outside of a computer.

- The features and functionality of a bus are as follows
  - A bus is a set of wires used for interconnection, where each wire can carry one bit of data.
  - A computer bus can be divided into two types; internal bus and external bus.
  - The internal bus connects components inside the motherboard like, CPU and system memory. It is also called the system bus.
  - The external bus connects the different external devices; peripherals, expansion slots, I/O ports and drive connections to the rest of computer. It is also referred to as the expansion bus.
  - The command to access the memory or the I/O device is carried by the control bus.
  - The address of I/O device or memory is carried by the address bus. The data to be transferred is carried by the data bus.

### Motherboard

- The main circuit board contained in any computer is called a motherboard it is also known as the mainboard or logic board or system board or planar board. The biggest piece of silicon housed in the system unit of a computer is motherboard.
  
  All the other electronic devices and circuits of computer system are attached to this board like, CPU, ROM. RAM expansion slots, PCI slots and USB ports it also includes controllers for devices like the hard drive, DVD drive, keyboard and mouse. In other words, motherboard makes everything in a computer work together.

### Instruction Cycle

- The instruction cycle represents the sequence of events that takes place as an instruction is read from memory and executed. A simple instruction cycle consists of the following steps
  - Fetching the instruction from the memory.
  - Decoding the instruction for operation.
  - Executing the instruction.
  - Storing in memory.

### Instructions Format

- Computer understands instructions only in terms of 0s and 1s, which is called the machine language. A computer program is a set of instructions that describe the steps to be performed for carrying out a computational task. The processor must have two inputs; instructions and data

- The instructions tell the processor what actions are needed to be performed on the data. An instruction is divided into two parts; operation (op-code) and operand. The op-code represents action that the processor must execute and the operand defines the parameters of the action and depends on the operation.


### Small Infos

- `Machine cycle` - is defined by the time, it takes to fetch two operands from registers. It performs the ALU operation and stores the result in a register.
- `Pipelining` - improves execution speed by putting the execution steps of several instructions into parallel it is also called instruction prefetch.
- `Sockets` - are the connecting points of chip on the motherboard.
- Generally, word computer refers to the central processing unit plus extemal memory.
- `Load instruction` is used for loading data into CPU accumulator register from memory.
- The box that comes along with your desktop computer in which all the electronic components of your computer are contained is called system unit.

<br>
<Br>
<br>

# Other Parts to be Included

I will note these down later on ...

### GPU

- Renders 3D Graphics, and does parallel computing but mainly 3D rendering ... I will note more in the future 

### Sound Card

- Decodes sound better than your CPU gives high quality sound

### Power Supply

- Battery, powers the comptuer. You can use just plain voltage if you want to die :)

### Network Card

- Network card used for using internet with your computer 

