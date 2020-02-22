# Brainfuck Interpreter (Java) + Multiplication algorithm

## Brainfuck

This esoteric language has a limited set of one character instructions, but it is Turing complete, even if it is incredibly painful to program with.

### Interpreter

The Interpreter was written in Java. This implementation is based on a 150 byte array for performance reasons, but it can be extended. 

It also features an optional boolean argument for printing this byte array on every iteration.

### Brainfuck multiplication machine

Probably the last time I will use this.
```
++++++++++[>+++++<-]>[-<+>]<-- //Loading 48 to the first pointer (48 char ascii)
[>+>+<<-] //Getting that 48 in two different pointers
>>>,>,<<<[->>>-<<<] //Ask for values and substracts 48 to each one (gets the real numeric value)
>[->-<]
>[-<<<+>>>]>[-<<<+>>>]<<< 
[-
<[->>+>+<<<]>>>[-<<<+>>>]<< //Iterative multiplication
]
<[-]
>>[-<<+>>]<< //We translate the result to be on the first pointer
```
