/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comp139.lab6_2023;
import java.util.Stack;

/**
 * A utility class for checking the balance of parentheses in an expression.
 */
public class ParenthesisChecker {

    /**
     * Checks if the parentheses in the given expression are balanced.
     *
     * @param expression The expression to be checked.
     * @return True if the parentheses are balanced, false otherwise.
     * @throws Exception If there are errors during the checking process.
     */
    public static boolean areParenthesesBalanced(String expression) throws Exception {
        
        // Create a stack to keep track of opening parentheses
        LinkedStack stack = new LinkedStack();
        
        // Loop through each character in the expression
        for (char ch : expression.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{') {
                
                // Push opening parentheses onto the stack
                stack.push(ch);
                
            } else if (ch == ')' || ch == ']' || ch == '}') {
                
                // Check if pushing closing parenthese onto empty stack
                if (stack.isEmpty()) {
                    return false;
                }
                
                // Pop the last opening parenthesis
                char openingParen = (char) stack.pop(); 
                
                // Check if the closing parnthesis matches the corresponding opening parenthesis
                if ((ch == ')' && openingParen != '(' || ch == ']' && openingParen != '[' || ch == '}' && openingParen != '{')) {
                    return false;
                }
            }
        }
        
        // After checking all the characters, if the stack is empty, parentheses are balanced
        return stack.isEmpty();
    }
}
