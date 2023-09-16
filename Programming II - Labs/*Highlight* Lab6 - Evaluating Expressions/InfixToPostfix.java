/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comp139.lab6_2023;

import java.util.StringTokenizer;

/**
 * Converts an infix expression to a postfix expression.
 */
public class InfixToPostfix {

    public boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    public int getPrecedence(char operator) {
        return switch (operator) {
            case '*', '/' -> 2;
            case '+', '-' -> 1;
            default -> 0;
        };
    }

    public String convertToPostfix(String infixExpression) throws Exception {
        StringBuilder postfix = new StringBuilder();
        LinkedStack operatorStack = new LinkedStack();
        StringTokenizer tokenizer = new StringTokenizer(infixExpression, "+-*/() ", true);

        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken().trim();

            if (token.isEmpty()) {
                continue;
            }

            char c = token.charAt(0);

            if (Character.isLetterOrDigit(c)) {
                postfix.append(token).append(" ");
            } else if (c == '(') {
                operatorStack.push(c);
            } else if (c == ')') {
                while (!operatorStack.isEmpty() && (char) operatorStack.peek() != '(') {
                    postfix.append(operatorStack.pop()).append(" ");
                }
                if (!operatorStack.isEmpty() && (char) operatorStack.peek() == '(') {
                    operatorStack.pop();
                } else {
                    throw new Exception("Unbalanced parentheses");
                }
            } else if (isOperator(c)) {
                while (!operatorStack.isEmpty() && (char) operatorStack.peek() != '('
                        && getPrecedence(c) <= getPrecedence((char) operatorStack.peek())) {
                    postfix.append(operatorStack.pop()).append(" ");
                }
                operatorStack.push(c);
            }
        }

        while (!operatorStack.isEmpty()) {
            char op = (char) operatorStack.pop();
            if (op == '(') {
                throw new Exception("Unbalanced parentheses");
            }
            postfix.append(op).append(" ");
        }

        return postfix.toString().trim();
    }
}
