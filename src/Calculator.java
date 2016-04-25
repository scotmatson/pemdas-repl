import java.util.Scanner;

public class Calculator {

	public static void main(String[] args) {
		
		// Initialization
		//Scanner in = new Scanner(System.in);
		String expression = "(5 + 3) * (12 / 3)"; // PASS
		// 53+123/*
		Lexer lexer = new Lexer();
		lexer.setParsable(expression);
		
		Postfixer postfixer = new Postfixer(lexer.getTokens());	
		Queue<String> postfixExpression = postfixer.getPostfixed();	
		
		System.out.println("Expression: " + expression);
		System.out.println("Postfix: 53+123/*");
		Parser parser = new Parser(postfixExpression);
		Node<String> root = parser.getParseTree();
		System.out.println("Root: " + root.getValue());
		System.out.println("Type: " + root.getType());
		
		Node<String> leftChild = root.getPrevious();
		Node<String> rightChild = root.getNext();
		
		System.out.println("Left Value: " + leftChild.getValue());
		System.out.println("Left Type: " + leftChild.getType());
		
		Node<String> leftLeftChild = leftChild.getPrevious();
		
		System.out.println("LeftLeft Value: " + leftLeftChild.getValue());
		System.out.println("LeftLeft Type: " + leftLeftChild.getType());
		
		System.out.println("Right Value: " + rightChild.getValue());
		System.out.println("Right Type: " + rightChild.getType());
		
		
		// TODO: Pass postfixedQueue into a TreeBuilder
		// TODO: A tree needs to be created and parsed, TreeBuilder & TreeParser? TreeBuilder should be able to handle postfixing
		// TODO: Something needs to perform the mathematical operations
		// TODO: Help menu
		// TODO: Exceptions.... so many exceptions
		// TODO: It would be helpful to refactor into packages
		// TODO: Unit Testing would be a good idea
		System.out.println("\nProgram terminated successfully.");
	}
}
