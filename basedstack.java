package ADT.Ass3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class basedstack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputPath = scanner.nextLine().trim();

        long startTime = System.nanoTime();

        Path filePath = Paths.get("D:\\InputFile\\" + inputPath);

        try {

            List<String> lines = Files.readAllLines(filePath);

            int count = 1;
            for (String infixExp : lines) {
                if (infixExp.trim().isEmpty()) {
                    break;
                }

                System.out.println("Expression " + count + ":");
                System.out.println("Infix exp: " + infixExp);
                System.out.println("Valid: " + check(infixExp));
                System.out.println("Postfix exp: " + infixToPostfix(infixExp));
                System.out.println();

                count++;
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        scanner.close();
    }

    public static String infixToPostfix(String infixExp) {
        StringBuilder postfix = new StringBuilder();
        Stack<String> stack = new Stack<>();
        StringTokenizer st = new StringTokenizer(infixExp, " ()+-*/", true);

        while (st.hasMoreTokens()) {
            String token = st.nextToken().trim();
            if (token.isEmpty())
                continue;

            if (isNumber(token)) {
                postfix.append(token).append(" ");
            } else if (token.equals("(")) {
                stack.push(token);
            } else if (token.equals(")")) {
                while (!stack.isEmpty() && !stack.peek().equals("(")) {
                    postfix.append(stack.pop()).append(" ");
                }
                stack.pop();
            } else if (isOperator(token)) {
                while (!stack.isEmpty() && getPrecedence(stack.peek()) >= getPrecedence(token)) {
                    postfix.append(stack.pop()).append(" ");
                }
                stack.push(token);
            }
        }

        while (!stack.isEmpty()) {
            postfix.append(stack.pop()).append(" ");
        }

        return postfix.toString().trim();
    }

    public static boolean check(String infixExp) {
        Stack<Character> stack = new Stack<>();

        for (char c : infixExp.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    public static boolean isOperator(String c) {
        return c.equals("+") || c.equals("-") || c.equals("*") || c.equals("/") || c.equals("^") ||
                c.equals("<") || c.equals("<=") || c.equals(">") || c.equals(">=") ||
                c.equals("==") || c.equals("!=") || c.equals("&&") || c.equals("||");
    }

    public static int getPrecedence(String op) {
        if (op.equals("^"))
            return 15;
        if (op.equals("*") || op.equals("/") || op.equals("%"))
            return 14;
        if (op.equals("+") || op.equals("-"))
            return 13;
        if (op.equals("<") || op.equals("<=") || op.equals(">") || op.equals(">="))
            return 12;
        if (op.equals("==") || op.equals("!="))
            return 11;
        if (op.equals("&&"))
            return 10;
        if (op.equals("||"))
            return 9;
        return -1;
    }

    public static boolean isSingleDigit(String c) {
        return c.matches("[0-9]");
    }

    public static boolean isNumber(String c) {
        return c.matches("[0-9]+");
    }
}
