package com.sample.snippets;

import java.util.Stack;

/**
 * Revese Polish Numbers
 *
 */
public class App 
{
    public static void main(String[] args){
        int value;

        String[] tes1 = {"2","2","1","+","*"};
        value = returnComputedValue(tes1);
        System.out.println("Result for Test 1:"+value);

        String[] tes2 = {"2","2","+","1","/"};
        value = returnComputedValue(tes2);
        System.out.println("Result for Test 2:"+value);

        String[] tes3 = {"2","2","1","-","+","3","*"};
        value = returnComputedValue(tes3);
        System.out.println("Result for Test3:"+value);
    }

    /**
     * Evaluates an integer Reverse Polish Notation expression.
     * Supported operators: +, -, *, / (integer division).
     *
     * @param args tokens of the RPN expression (e.g. {"2","1","+","3","*"})
     * @return computed integer result
     * @throws IllegalArgumentException if input is null/empty or expression is invalid
     * @throws ArithmeticException for division by zero
     * @throws NumberFormatException if a token is not an operator nor a valid integer
     */
    public static int returnComputedValue(String[] args) {
        if (args == null || args.length == 0) {
            throw new IllegalArgumentException("Input tokens must not be null or empty");
        }

        Stack<Integer> stack = new Stack<>();

        for (String token : args) {
            if (token == null || token.trim().isEmpty()) {
                continue;
            }

            switch (token) {
                case "+" : {
                    requireOperands(stack, token);
                    int b = stack.pop();
                    int a = stack.pop();
                    System.out.println(b+a);
                    stack.push(a + b);
                    break;
                }
                case "-" : {
                    requireOperands(stack, token);
                    int b = stack.pop();
                    int a = stack.pop();
                    stack.push(a - b);
                    break;
                }
                case "*" : {
                    requireOperands(stack, token);
                    int b = stack.pop();
                    int a = stack.pop();
                    System.out.println("A: "+a+" B: "+b);
                    stack.push(a * b);
                    break;
                }
                case "/" : {
                    requireOperands(stack, token);
                    int b = stack.pop();
                    int a = stack.pop();
                    if (b == 0) {
                        throw new ArithmeticException("Division by zero");
                    }
                    stack.push(a / b); // integer division
                    break;
                }
                default:
                    // parse integer (may throw NumberFormatException)
                    stack.push(Integer.parseInt(token));
                    break;
            }
        }

        if (stack.size() != 1) {
            throw new IllegalArgumentException("Invalid RPN expression: leftover stack size = " + stack.size());
        }

        return stack.pop();
    }

    private static void requireOperands(Stack<Integer> stack, String op) {
        if (stack.size() < 2) {
            throw new IllegalArgumentException("Insufficient operands for operator '" + op + "'");
        }
    }
}
