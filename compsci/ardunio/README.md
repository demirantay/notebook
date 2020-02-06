> Where I left of:
  - https://www.tutorialspoint.com/arduino/arduino_installation.htm
  - https://www.tutorialspoint.com/arduino/arduino_strings.htm
  
  ---
  
> Read These:
  - https://realpython.com/micropython/#micropython-hardware
  - https://realpython.com/arduino-python/

# Ardunio 

- Arduino is a prototype platform (open-source) based on an easy-to-use hardware and software. It consists of a circuit board, which can be programed (referred to as a microcontroller) and a ready-made software called Arduino IDE (Integrated Development Environment), which is used to write and upload the computer code to the physical board.

- The key features are −
  - Arduino boards are able to read analog or digital input signals from different sensors and turn it into an output such as activating a motor, turning LED on/off, connect to the cloud and many other actions.
  - You can control your board functions by sending a set of instructions to the microcontroller on the board via Arduino IDE (referred to as uploading software).
  - Unlike most previous programmable circuit boards, Arduino does not need an extra piece of hardware (called a programmer) in order to load a new code onto the board. You can simply use a USB cable.
  - Additionally, the Arduino IDE uses a simplified version of C++, making it easier to learn to program.
  - Finally, Arduino provides a standard form factor that breaks the functions of the micro-controller into a more accessible package.
  
- **`Board Types`** - Various kinds of Arduino boards are available depending on different microcontrollers used. However, all Arduino boards have one thing in common: they are programed through the Arduino IDE.

  The differences are based on the number of inputs and outputs (the number of sensors, LEDs, and buttons you can use on a single board), speed, operating voltage, form factor etc. Some boards are designed to be embedded and have no programming interface (hardware), which you would need to buy separately. Some can run directly from a 3.7V battery, others need at least 5V.
  
<Br>
<br>
<br>

# Board Description

- n this chapter, we will learn about the different components on the Arduino board. We will study the Arduino UNO board because it is the most popular board in the Arduino board family. In addition, it is the best board to get started with electronics and coding. Some boards look a bit different from the one given below, but most Arduinos have majority of these components in common. You can see the image here: 
  - https://www.tutorialspoint.com/arduino/images/board_description.jpg
  
- Definition of parts:
  - `1` -- Power USB :: Arduino board can be powered by using the USB cable from your computer. All you need to do is connect the USB cable to the USB connection (1).
  - `2` -- Power (barrel jack) :: Arduino boards can be powered directly from the AC mains power supply by connecting it to the Barrel Jack (2).
  - `3` -- Voltage REgulator :: The function of the voltage regulator is to control the voltage given to the Arduino board and stabilize the DC voltages used by the processor and other elements.
  - `4` -- Crystal Oscillator :: The crystal oscillator helps Arduino in dealing with time issues. How does Arduino calculate time? The answer is, by using the crystal oscillator. The number printed on top of the Arduino crystal is 16.000H9H. It tells us that the frequency is 16,000,000 Hertz or 16 MHz.
  - `5`, `17` -- Ardunio Reset :: You can reset your Arduino board, i.e., start your program from the beginning. You can reset the UNO board in two ways. First, by using the reset button (17) on the board. Second, you can connect an external reset button to the Arduino pin labelled RESET (5).
  - `6`, `7`, `8`, `9` -- Pins (3.3, 5, GND, Vin) :: 
    - 3.3V (6) − Supply 3.3 output volt
    - 5V (7) − Supply 5 output volt
    - Most of the components used with Arduino board works fine with 3.3 volt and 5 volt.
    - GND (8)(Ground) − There are several GND pins on the Arduino, any of which can be used to ground your circuit.
    - Vin (9) − This pin also can be used to power the Arduino board from an external power source, like AC mains power supply.
  - `10` -- Analog Pins :: The Arduino UNO board has six analog input pins A0 through A5. These pins can read the signal from an analog sensor like the humidity sensor or temperature sensor and convert it into a digital value that can be read by the microprocessor.
  - `11` -- Main Controller :: Each Arduino board has its own microcontroller (11). You can assume it as the brain of your board. The main IC (integrated circuit) on the Arduino is slightly different from board to board. The microcontrollers are usually of the ATMEL Company. You must know what IC your board has before loading up a new program from the Arduino IDE. This information is available on the top of the IC. For more details about the IC construction and functions, you can refer to the data sheet.
  - `12` -- ICSP pin :: Mostly, ICSP (12) is an AVR, a tiny programming header for the Arduino consisting of MOSI, MISO, SCK, RESET, VCC, and GND. It is often referred to as an SPI (Serial Peripheral Interface), which could be considered as an "expansion" of the output. Actually, you are slaving the output device to the master of the SPI bus.
  - `13` -- Power LED indicator :: This LED should light up when you plug your Arduino into a power source to indicate that your board is powered up correctly. If this light does not turn on, then there is something wrong with the connection.
  - `14` -- TX and RX LEDs :: On your board, you will find two labels: TX (transmit) and RX (receive). They appear in two places on the Arduino UNO board. First, at the digital pins 0 and 1, to indicate the pins responsible for serial communication. Second, the TX and RX led (13). The TX led flashes with different speed while sending the serial data. The speed of flashing depends on the baud rate used by the board. RX flashes during the receiving process.
  - `15` -- Digital I/O :: The Arduino UNO board has 14 digital I/O pins (15) (of which 6 provide PWM (Pulse Width Modulation) output. These pins can be configured to work as input digital pins to read logic values (0 or 1) or as digital output pins to drive different modules like LEDs, relays, etc. The pins labeled “~” can be used to generate PWM.
  - `16` -- Aref :: AREF stands for Analog Reference. It is sometimes, used to set an external reference voltage (between 0 and 5 Volts) as the upper limit for the analog input pins.
  
<br>
<br>
<br>
<bR>

# Program Structure 

- Sketch − The first new terminology is the Arduino program called “sketch”.

- Arduino programs can be divided in three main parts:
  - `Structure`
  - `Values` (variables and constants)
  - `Functions`. 

- Let us start with the `Structure`. Software structure consist of two main functions −
  - `Setup( ) function ` -- The setup() function is called when a sketch starts. Use it to initialize the variables, pin modes, start using libraries, etc. The setup function will only run once, after each power up or reset of the Arduino board.
  - `Loop( ) function` -- After creating a setup() function, which initializes and sets the initial values, the loop() function does precisely what its name suggests, and loops consecutively, allowing your program to change and respond. Use it to actively control the Arduino board.

<br>
<Br>
<br>

# Programming with Ardunio

- Ardunio uses C/C++ so all of the data types are same. I am just going to note which ones are included and note give too much info on each one since I have written notes about them in different note files

- Data Types that are included: `void`, `boolean`, `char`, `unsigned char`, `byte`, `int`, `unsigned int`, `word`, `long`, `unsigned long`, `short`, `float`, `double`, `array`, `string-char array`, `string-object`

- I mean since the language of Ardunio is a simplified c/c++ I am not going to note down vars, control statements, loops, functions, strings, arrays, strings and other programming key topics. You can find more info on programming in the "programming" note folder in the parent directory of this directory.

- But remember :: The Arduino IDE uses C++ but of course the physical environment is limited so not all C/C++ features can be used and the Arduino environment has helper functions to enable you to use the hardware easily and the Serial monitor for input/output.

<br>
<br>
<br>

# Strings

- There are two types of strings in Arduino programming −
  - Arrays of characters, which are the same as the strings used in C programming.
  - The Arduino String, which lets us use a string object in a sketch.


  
