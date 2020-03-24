# I/O Hardware

- One of the important jobs of an Operating System is to manage various I/O devices including mouse, keyboards, touch pad, disk drives, display adapters, USB devices, Bit-mapped screen, LED, Analog-to-digital converter, On/off switch, network connections, audio I/O, printers etc. An I/O system is required to take an application I/O request and send it to the physical device.

### Device Controllers

- `Device drivers` are software modules that can be plugged into an OS to handle a particular device. Operating System takes help from device drivers to handle all I/O devices.

  The Device Controller works like an interface between a device and a device driver. I/O units (Keyboard, mouse, printer, etc.) typically consist of a mechanical component and an electronic component where electronic component is called the device controller.
  
  Any device connected to the computer is connected by a plug and socket, and the socket is connected to a device controller. Following is a model for connecting the CPU, memory, controllers, and I/O devices where CPU and device controllers all use a common bus for communication.

### Communication to I/O Devices

- The CPU must have a way to pass information to and from an I/O device. There are three approaches available to communicate with the CPU and Device.
  - Special Instruction I/O
  - Memory-mapped I/O
  - Direct memory access (DMA)
  
- `special instruction i/o` -- This uses CPU instructions that are specifically made for controlling I/O devices. These instructions typically allow data to be sent to an I/O device or read from an I/O device.

- `memory mapped i/o` -- When using memory-mapped I/O, the same address space is shared by memory and I/O devices. The device is connected directly to certain main memory locations so that I/O device can transfer block of data to/from memory without going through CPU.

- `direct memory access (dma)` -- Slow devices like keyboards will generate an interrupt to the main CPU after each byte is transferred. If a fast device such as a disk generated an interrupt for each byte, the operating system would spend most of its time handling these interrupts. So a typical computer uses direct memory access (DMA) hardware to reduce this overhead.

  Direct Memory Access (DMA) means CPU grants I/O module authority to read from or write to memory without involvement. DMA module itself controls exchange of data between main memory and the I/O device. CPU is only involved at the beginning and end of the transfer and interrupted only after entire block has been transferred.

### Polling vs Interrupts I/O

- A computer must have a way of detecting the arrival of any type of input. There are two ways that this can happen, known as polling and interrupts. Both of these techniques allow the processor to deal with events that can happen at any time and that are not related to the process it is currently running.

- `polling` -- Polling is the simplest way for an I/O device to communicate with the processor. The process of periodically checking status of the device to see if it is time for the next I/O operation, is called polling. The I/O device simply puts the information in a Status register, and the processor must come and get the information.

- `interrupts i/o` -- An alternative scheme for dealing with I/O is the interrupt-driven method. An interrupt is a signal to the microprocessor from a device that requires attention.

<br>
<br>

---

<br>
<br>

# I/O Software 

- I/O software is often organized in the following layers 
   - `User Level Libraries` − This provides simple interface to the user program to perform input and output. For example, stdio is a library provided by C and C++ programming languages.      
   - `Kernel Level Modules` − This provides device driver to interact with the device controller and device independent I/O modules used by the device drivers.
   - `Hardware` − This layer includes actual hardware and hardware controller which interact with the device drivers and makes hardware alive.
   
   A key concept in the design of I/O software is that it should be device independent where it should be possible to write programs that can access any I/O device without having to specify the device in advance

### Device Drivers

- Device drivers are software modules that can be plugged into an OS to handle a particular device. Operating System takes help from device drivers to handle all I/O devices. Device driver, is generally written by the device's manufacturer and delivered along with the device on a CD-ROM.

### Interrupt handlers

- An interrupt handler, also known as an interrupt service routine or ISR, is a piece of software or more specifically a callback function in an operating system or more specifically in a device driver, whose execution is triggered by the reception of an interrupt.

### Device-Independent I/O Software

- The basic function of the device-independent software is to perform the I/O functions that are common to all devices and to provide a uniform interface to the user-level software. 

### User-Space I/O Software

- These are the libraries which provide richer and simplified interface to access the functionality of the kernel or ultimately interactive with the device drivers

  I/O Libraries (e.g., stdio) are in user-space to provide an interface to the OS resident device-independent I/O SW. For example putchar(), getchar(), printf() and scanf() are example of user level I/O library stdio available in C programming.

<br>
<br>

---

<br>
<br>

# File System

- A file is a named collection of related information that is recorded on secondary storage such as magnetic disks, magnetic tapes and optical disks. In general, a file is a sequence of bits, bytes, lines or records whose meaning is defined by the files creator and user.

### File Type

- File type refers to the ability of the operating system to distinguish different types of file such as text files source files and binary files etc. Many operating systems support many types of files. Operating system like MS-DOS and UNIX have the following types of files −
  - `ordinary files` -- These may have text, databases or executable program.
  - `Directory files` -- These files contain list of file names and other information related to these files.
  - `Special files` -- These files represent physical device like disks, terminals, printers, networks, tape drive etc.

### File Access Mechanisms

- File access mechanism refers to the manner in which the records of a file may be accessed. There are several ways to access files −
  - `Sequential access` -- A sequential access is that in which the records are accessed in some sequence
  - `Direct/Random access` -- Random access file organization provides, accessing the records directly.
  - `Indexed sequential access` -- Index is searched sequentially and its pointer is used to access the file directly.

### Space Allocation

- Files are allocated disk spaces by operating system. Operating systems deploy following three main ways to allocate disk space to files.
  - `Contiguous Allocation`
  -` Linked Allocation`
  - `Indexed Allocation`

<br>
<br>

---

<br>
<br>

# Linux

- Linux is one of popular version of UNIX operating System. It is open source as its source code is freely available. It is free to use.

### Components of Linux System

- Linux Operating System has primarily three components
  - `Kernel` − Kernel is the core part of Linux. It is responsible for all major activities of this operating system. It consists of various modules and it interacts directly with the underlying hardware. Kernel provides the required abstraction to hide low level hardware details to system or application programs.
  - `System Library` − System libraries are special functions or programs using which application programs or system utilities accesses Kernel's features. These libraries implement most of the functionalities of the operating system and do not requires kernel module's code access rights.
  - `System Utility` − System Utility programs are responsible to do specialized, individual level tasks.

### Kernel Mode vs User Mode

- Kernel component code executes in a special privileged mode called kernel mode with full access to all resources of the computer. This code represents a single process, executes in single address space and do not require any context switch and hence is very efficient and fast. Kernel runs each processes and provides system services to processes, provides protected access to hardware to processes.

### Architecture

- The architecture of a Linux System consists of the following layers −
  - `Hardware layer` − Hardware consists of all peripheral devices (RAM/ HDD/ CPU etc).
  - `Kernel` − It is the core component of Operating System, interacts directly with hardware, provides low level services to upper layer components.
  - `Shell` − An interface to kernel, hiding complexity of kernel's functions from users. The shell takes commands from the user and executes kernel's functions.
  - `Utilities` − Utility programs that provide the user most of the functionalities of an operating systems.
