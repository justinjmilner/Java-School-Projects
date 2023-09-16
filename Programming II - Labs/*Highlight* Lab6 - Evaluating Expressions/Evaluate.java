/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comp139.lab6_2023;
import java.util.StringTokenizer;

/**
 * A class for evaluating postfix expressions.
 */
public class Evaluate {

    /**
     * Evaluates a postfix expression and returns the result.
     *
     * @param postfixExpression The postfix expression to be evaluated.
     * @return The result of evaluating the postfix expression.
     * @throws Exception If there are errors during the evaluation process.
     */
    public int evaluatePostfix(String postfixExpression) throws Exception {
        LinkedStack operandStack = new LinkedStack(); // Stack to hold operands
        StringTokenizer tokenizer = new StringTokenizer(postfixExpression);

        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();

            if (Character.isDigit(token.charAt(0))) {
                int operand = Integer.parseInt(token);
                operandStack.push(operand);
            } else if (isOperator(token.charAt(0))) {
                int rightOperand = (int) operandStack.pop();
                int leftOperand = (int) operandStack.pop();
                int result = applyOperator(token, leftOperand, rightOperand);
                operandStack.push(result);
            } else {
                throw new Exception("Invalid token: " + token);
            }
        }

        return (int) operandStack.pop(); // Final result after all operations
    }

    /**
     * Applies a given operator to two operands and returns the result.
     *
     * @param operator     The operator to be applied (one of "+", "-", "*", or "/").
     * @param leftOperand  The left operand.
     * @param rightOperand The right operand.
     * @return The result of applying the operator to the operands.
     * @throws IllegalArgumentException If an invalid operator is provided.
     */
    public int applyOperator(String operator, int leftOperand, int rightOperand) {
        switch (operator) {
            case "+":
                return leftOperand + rightOperand;
            case "-":
                return leftOperand - rightOperand;
            case "*":
                return leftOperand * rightOperand;
            case "/":
                if (rightOperand == 0) {
                    throw new ArithmeticException("Division by zero.");
                }
                return leftOperand / rightOperand;
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }

    private boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }
}

