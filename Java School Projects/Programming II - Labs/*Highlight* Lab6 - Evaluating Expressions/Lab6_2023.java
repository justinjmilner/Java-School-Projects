 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package comp139.lab6_2023;


/**
 *
 * @author C0030622
 */
public class Lab6_2023 {

        public static void main(String[] args) throws Exception {
        test("3 + 4 * 2 - 6 / 2");       // Valid
        test("2 * 3 + 4 - / 1");         // Invalid
    }

    public static void test(String expression) {
        try {
            if (ParenthesisChecker.areParenthesesBalanced(expression)) {
                
                InfixToPostfix infixToPostfix = new InfixToPostfix();
                Evaluate evaluator = new Evaluate();
                String postfixExpr = infixToPostfix.convertToPostfix(expression);
                
                LinkedTree tree = new LinkedTree(postfixExpr);
                
                String postfixExpression = tree.getPostfixExpression();
                String infixExpression = tree.getInfixExpression();
                String prefixExpression = tree.getPrefixExpression();
                int result = evaluator.evaluatePostfix(postfixExpr);  

                System.out.println("Testing Expression: " + expression);
                System.out.println("Infix Expression: " + infixExpression);
                System.out.println("Postfix Expression: " + postfixExpression);
                System.out.println("Prefix Expression: " + prefixExpression);
                System.out.println("Evaluated Result: " + result);
                System.out.println("Valid Expression");
                System.out.println();
            } else {
                System.out.println("Testing Expression: " + expression);
                System.out.println("Invalid Expression (Unbalanced Parentheses): " + expression);
                System.out.println();
            }
        } catch (Exception e) {
            System.out.println("Testing Expression: " + expression);
            System.out.println("Invalid Expression: " + expression);
            System.out.println("Error: " + e.getMessage());
            System.out.println();
        }
    }
}
 
