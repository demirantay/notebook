# Computer Architecture

- Today’s world is an information-rich world and it has become a necessity for everyone to know about computers. A computer is an electronic data processing device, which accepts and stores data input, processes the data input, and generates the output in a required format.

- If we look at it in a very broad sense, any digital computer carries out the following five functions −
  - Step 1 − Takes data as input.
  - Step 2 − Stores the data/instructions in its memory and uses them as required.
  - Step 3 − Processes the data and converts it into useful information.
  - Step 4 − Generates the output.
  - Step 5 − Controls all the above four steps.
  
<br/>
<br/>
<br/>

# Components

- All types of computers follow the same basic logical structure and perform the following five basic operations for converting raw input data into information useful to their users.
  - 1- `Take Input` : The process of entering data and instructions into the computer system.
  - 2- `Store Data` : Saving data and instructions so that they are available for processing as and when required.
  - 3- `Processing Data` : Performing arithmetic, and logical operations on data in order to convert them into useful information.
  - 4- `Output Information` : The process of producing useful information or results for the user, such as a printed report or visual display.
  - 5- `Control the Worklof` : Directs the manner and sequence in which all of the above operations are performed.
  
### Input Unit

- This unit contains devices with the help of which we enter data into the computer. This unit creates a link between the user and the computer. The input devices translate the information into a form understandable by the computer.

### CPU (Central Processing Unit)

- CPU is considered as the brain of the computer. CPU performs all types of data processing operations. It stores data, intermediate results, and instructions (program). It controls the operation of all parts of the computer. CPU itself has the following three components −
  - ALU (Arithmetic Logic Unit)
  - Memory Unit
  - Control Unit
  
### Output Unit

- The output unit consists of devices with the help of which we get the information from the computer. This unit is a link between the computer and the users. Output devices translate the computer's output into a form understandable by the users.

<br/>
<br/>
<br/>

# CPU (Control Processing Unit)

- Central Processing Unit (CPU) consists of the following features −
  - CPU is considered as the brain of the computer.
  - CPU performs all types of data processing operations.
  - It stores data, intermediate results, and instructions (program).
  - It controls the operation of all parts of the computer.
  
- CPU itself has following three components.
  - Memory or Storage Unit
  - Control Unit
  - ALU(Arithmetic Logic Unit)
  
### Memory (Storage Unit)

- This unit can store instructions, data, and intermediate results. This unit supplies information to other units of the computer when needed. It is also known as internal storage unit or the main memory or the primary storage or Random Access Memory (RAM).

- Its size affects speed, power, and capability. Primary memory and secondary memory are two types of memories in the computer. Functions of the memory unit are −
  - It stores all the data and the instructions required for processing.
  - It stores intermediate results of processing.
  - It stores the final results of processing before these results are released to an output device.
  - All inputs and outputs are transmitted through the main memory.

### Control Unit

- This unit controls the operations of all parts of the computer but does not carry out any actual data processing operations. Functions of this unit are −
  - It is responsible for controlling the transfer of data and instructions among other units of a computer.
  - It manages and coordinates all the units of the computer.
  - It obtains the instructions from the memory, interprets them, and directs the operation of the computer.
  - It communicates with Input/Output devices for transfer of data or results from storage.
  - It does not process or store data.
  
### ALU (Arithmetic Logic Unit)

- This unit consists of two subsections namely 1) Arithmetic Section, 2) Logic Section
  - `Arithmetic Section`: Function of arithmetic section is to perform arithmetic operations like addition, subtraction, multiplication, and division. All complex operations are done by making repetitive use of the above operations.
  - `Logic Section`: Function of logic section is to perform logic operations such as comparing, selecting, matching, and merging of data.
  
<br/>
<br/>
<br/>

# Input & Output Devices 

- Following are some of the important input devices which are used in a computer − - Keyboard Mouse, Joy Stick , Light pen, Track Ball, Scanner, Graphic Tablet, Microphone, Magnetic Ink Card Reader(MICR), Optical Character Reader(OCR), Bar Code Reader, Optical Mark Reader(OMR)

- Following are some of the important output devices used in a computer. - - Monitors, Graphic Plotter, Printer

<br/>
<br/>
<br/>

# Memory 

- A memory is just like a human brain. It is used to store data and instructions. Computer memory is the storage space in the computer, where data is to be processed and instructions required for processing are stored. Memory is primarily of three types −
  - Cache Memory
  - Primary Memory/Main Memory
  - Secondary Memory
  
### Cache Memory

- Cache memory is a very high speed semiconductor memory which can speed up the CPU. It acts as a buffer between the CPU and the main memory. It is used to hold those parts of data and program which are most frequently used by the CPU. The parts of data and programs are transferred from the disk to cache memory by the operating system, from where the CPU can access them.

- Tha advantages of the cache memory: Cache memory is faster than main memory. It consumes less access time as compared to main memory. It stores the program that can be executed within a short period of time. It stores data for temporary use.

- The disadvantages of the cache memory: Cache memory has limited capacity. It is very expensive.

### Primary Memory

- Primary memory holds only those data and instructions on which the computer is currently working. It has a limited capacity and data is lost when power is switched off. It is generally made up of semiconductor device. These memories are not as fast as registers. The data and instruction required to be processed resides in the main memory. It is divided into two subcategories RAM and ROM.

- Characteristics of Main Memory: These are semiconductor memories. It is known as the main memory. Usually volatile memory. Data is lost in case power is switched off. It is the working memory of the computer. Faster than secondary memories. A computer cannot run without the primary memory.

### Secondary Memory 

- This type of memory is also known as external memory or non-volatile. It is slower than the main memory. These are used for storing data/information permanently. CPU directly does not access these memories, instead they are accessed via input-output routines. The contents of secondary memories are first transferred to the main memory, and then the CPU can access it. For example, disk, CD-ROM, DVD, etc.

- The Characteristics of a Secondary Memory: These are magnetic and optical memories. It is known as the backup memory. It is a non-volatile memory. Data is permanently stored even if power is switched off. It is used for storage of data in a computer. Computer may run without the secondary memory. Slower than primary memories.

<br/>
<br/>
<br/>

# RAM (Random Accsess Memory)

- RAM (Random Access Memory) is the internal memory of the CPU for storing data, program, and program result. It is a read/write memory which stores data until the machine is working. As soon as the machine is switched off, data is erased.

- RAM is volatile, i.e. data stored in it is lost when we switch off the computer or if there is a power failure. Hence, a backup Uninterruptible Power System (UPS) is often used with computers. RAM is small, both in terms of its physical size and in the amount of data it can hold.

- RAM is of two types − 1 ) StaticRAM (SRAM) , 2) DynamicRAM (DRAM)

### Static RAM (SRAM)

- The word static indicates that the memory retains its contents as long as power is being supplied. However, data is lost when the power gets down due to volatile nature. SRAM chips use a matrix of 6-transistors and no capacitors. Transistors do not require power to prevent leakage, so SRAM need not be refreshed on a regular basis.

- There is extra space in the matrix, hence SRAM uses more chips than DRAM for the same amount of storage space, making the manufacturing costs higher. SRAM is thus used as cache memory and has very fast access.

- Characteristics of SRAM - Long Life, No need to refresh, Faster, Used as cache memory, Larger size, Expensive, High power consumption

### Dynamic RAM (DRAM)

- DRAM, unlike SRAM, must be continually refreshed in order to maintain the data. This is done by placing the memory on a refresh circuit that rewrites the data several hundred times per second. DRAM is used for most system memory as it is cheap and small. All DRAMs are made up of memory cells, which are composed of one capacitor and one transistor.

- Characteristics of DRAM - Short data lifetime, Needs to be refreshed continuously, Slower as compared to SRAM, Used as RAM, Smaller in size, Less expensive, Less power consumption

<br/>
<br/>
<br/>

# ROM (Read Only Memory) 

- ROM stands for Read Only Memory. The memory from which we can only read but cannot write on it. This type of memory is non-volatile. The information is stored permanently in such memories during manufacture. A ROM stores such instructions that are required to start a computer. This operation is referred to as bootstrap. ROM chips are not only used in the computer but also in other electronic items like washing machine and microwave oven.

- There are various types of ROMS: 
  - `MROM`: inexpensive, has pre programmed data types inside it
  - `PROM`: this can be modified only once and than it is unearasable
  - `EPROM`: can be programmed via electronic stuff (unsure about this)
  - `EEPROM`: this can be modified about ten thousand times
  
- Characteristics of ROM: Non-volatile in nature, Cannot be accidentally changed, Cheaper than RAMs, Easy to test, More reliable than RAMs, Static and do not require refreshing, Contents are always known and can be verified

<br/>
<br/>
<br/>

# Motherboard

- The motherboard serves as a single platform to connect all of the parts of a computer together. It connects the CPU, memory, hard drives, optical drives, video card, sound card, and other ports and expansion cards directly or via cables. It can be considered as the backbone of a computer.

- A motherboard comes with the following features : 
  - Motherboard varies greatly in supporting various types of components.
  - Motherboard supports a single type of CPU and few types of memories.
  - Video cards, hard disks, sound cards have to be compatible with the motherboard to function properly.
  - Motherboards, cases, and power supplies must be compatible to work properly together.
  
- The motherboard is mounted inside the case and is securely attached via small screws through pre-drilled holes. Motherboard contains ports to connect all of the internal components. It provides a single socket for CPU, whereas for memory, normally one or more slots are available. Motherboards provide ports to attach the floppy drive, hard drive, and optical drives via ribbon cables. Motherboard carries fans and a special port designed for power supply.

- There is a peripheral card slot in front of the motherboard using which video cards, sound cards, and other expansion cards can be connected to the motherboard.

- On the left side, motherboards carry a number of ports to connect the monitor, printer, mouse, keyboard, speaker, and network cables. Motherboards also provide USB ports, which allow compatible devices to be connected in plug-in/plug-out fashion. For example, pen drive, digital cameras, etc.

<br/>
<br/>
<br/>

# Memory Units


