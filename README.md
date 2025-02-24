# Expression Evaluation Program

## Author
**Name:** Wasinpat Yanin  
**ID:** 672115043  

## Description
This program reads mathematical expressions from an input file, validates their syntax, and converts them from infix notation to postfix notation. It processes each line as a separate expression until an empty line is encountered.

## Features
- Reads expressions from a file.
- Validates whether the expressions have balanced parentheses.
- Converts valid infix expressions to postfix notation.
- Displays the results, including the expression number, infix expression, validity check, and corresponding postfix expression.

## Input File Format
- The input file should contain one mathematical expression per line.
- Expressions must use valid operators: `+`, `-`, `*`, `/`, `^`, `<`, `<=`, `>`, `>=`, `==`, `!=`, `&&`, `||`.
- An empty line signifies the end of input.

## Example Input File (input1.csv)
```
(5 + 3) * (2 - (8 / 4))
((7 + 6) * (5 - 2)) / (4 + 1)
15 - ((3 * 8) / (2 + 2))
(9 + (3 - 1) * 4) / (6 - 2)
(12 / (4 + 2)) + ((6 - 3) * 2)
```

## Example Output
```
Expression 1:
Infix exp: (5 + 3) * (2 - (8 / 4))
Valid: true
Postfix exp: 5 3 + 2 8 4 / - *

Expression 2:
Infix exp: ((7 + 6) * (5 - 2)) / (4 + 1)
Valid: true
Postfix exp: 7 6 + 5 2 - * 4 1 + /

Expression 3:
Infix exp: 15 - ((3 * 8) / (2 + 2))
Valid: true
Postfix exp: 15 3 8 * 2 2 + / -
```

## How to Run
1. Compile and run the Java program.
2. Enter the file name when prompted.
3. The program reads expressions from the specified file.
4. It processes and outputs each expression's validation status and postfix notation.

## Requirements
- Java Development Kit (JDK) installed.
- An input file with valid expressions.

## Notes
- Ensure the input file is correctly formatted and located in the specified directory (`D:\InputFile\`).
- If the program encounters an unbalanced expression, it will mark it as invalid.
- Logical and relational operators are supported.

## License
This project is for educational purposes only.

