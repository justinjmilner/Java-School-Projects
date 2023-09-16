package comp139.lab6_2023;

import java.util.StringTokenizer;

/**
 * Represents a binary expression tree constructed from a postfix expression.
 */
public class LinkedTree {

    private Node root;

    public LinkedTree(String postfixExpression) throws Exception {
        buildTreeFromPostfix(postfixExpression);
    }

    private void buildTreeFromPostfix(String postfixExpression) throws Exception {
        LinkedStack nodeStack = new LinkedStack();
        StringTokenizer tokenizer = new StringTokenizer(postfixExpression, " ");

        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();

            if (Character.isLetterOrDigit(token.charAt(0))) {
                Node operandNode = new Node(token);
                nodeStack.push(operandNode);
            } else if (isOperator(token.charAt(0))) {
                Node rightOperandNode = (Node) nodeStack.pop();
                Node leftOperandNode = (Node) nodeStack.pop();
                Node operatorNode = new Node(token);
                operatorNode.setLeft(leftOperandNode);
                operatorNode.setRight(rightOperandNode);
                nodeStack.push(operatorNode);
            }
        }

        if (!nodeStack.isEmpty()) {
            root = (Node) nodeStack.pop();
        }
    }


    private boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    public Node getRoot() {
        return root;
    }

    public String getInfixExpression() {
        return getInfix(root).trim();
    }

    public String getPrefixExpression() {
        return getPrefix(root).trim(); 
    }

    public String getPostfixExpression() {
        return getPostfix(root).trim(); 
    }

    private String getInfix(Node node) {
    if (node != null) {
        StringBuilder expression = new StringBuilder();

        if (isOperator(node.getData().toString().charAt(0))) {
            expression.append("(");
        }

        expression.append(getInfix(node.getLeft()));
        expression.append(node.getData());
        expression.append(getInfix(node.getRight()));

        if (isOperator(node.getData().toString().charAt(0))) {
            expression.append(")");
        }

        return expression.toString();
    }
    return "";
}

    private String getPrefix(Node node) {
        if (node != null) {
            StringBuilder expression = new StringBuilder();

            expression.append(node.getData());
            expression.append(" ");
            expression.append(getPrefix(node.getLeft()));
            expression.append(getPrefix(node.getRight()));

            return expression.toString();
        }
        return "";
    }

    private String getPostfix(Node node) {
        if (node != null) {
            StringBuilder expression = new StringBuilder();

            expression.append(getPostfix(node.getLeft()));
            expression.append(getPostfix(node.getRight()));
            expression.append(node.getData());
            expression.append(" ");

            return expression.toString();
        }
        return "";
    }

    public void inOrderTraversal() {
        inOrderTraversal(root);
        System.out.println(); // Add a new line after traversal
    }

    private void inOrderTraversal(Node node) {
        if (node != null) {
            inOrderTraversal(node.getLeft());
            System.out.print(node.getData() + " ");
            inOrderTraversal(node.getRight());
        }
    }

    public void preOrderTraversal() {
        preOrderTraversal(root);
        System.out.println(); // Add a new line after traversal
    }

    private void preOrderTraversal(Node node) {
        if (node != null) {
            System.out.print(node.getData() + " ");
            preOrderTraversal(node.getLeft());
            preOrderTraversal(node.getRight());
        }
    }

    public void postOrderTraversal() {
        postOrderTraversal(root);
        System.out.println(); // Add a new line after traversal
    }

    private void postOrderTraversal(Node node) {
        if (node != null) {
            postOrderTraversal(node.getLeft());
            postOrderTraversal(node.getRight());
            System.out.print(node.getData() + " ");
        }
    }

}
