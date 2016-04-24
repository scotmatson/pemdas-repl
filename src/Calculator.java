import java.util.Scanner;

public class Calculator {

	public static void main(String[] args) {
		
		// Initialization
		//Scanner in = new Scanner(System.in);
		Lexer lexer = new Lexer();
		//lexer.setParsable("5 + 5");
//		String expression = "1 * 2 + 3"; // PASS
//		String expression = "1 * 2^3 + 4"; // PASS
//		String expression = "1 * (2 + 3)"; // PASS
		
//		String expression = "(5 + 3) * 12 / 3"; // PASS
		// 53+12*3/
		String expression = "(5 + 3) * (12 / 3)"; // PASS
		// 53+123/*
		System.out.println(expression);
		

		
//		System.out.println("Original:");
//		System.out.println(expression);
		lexer.setParsable(expression);
		
//		System.out.println();
//		String[] validTokens = lexer.getTokens();		
//		System.out.println("** TOKENIZED **");
//		for (int i = 0; i < validTokens.length; i++)
//		{
//			System.out.print(validTokens[i]);
//		}
//		System.out.println("\n");
		
		// Working on parse tree.... gay.
		Postfixer postfixer = new Postfixer(lexer.getTokens());
		
		Queue<String> postfixTest = postfixer.getPostfixed();	
//		System.out.println("Reading postfixed notation");
//		while (!postfixTest.isEmpty())
//		{
//			Node<String> currentNode = postfixTest.dequeue();
//			System.out.print(currentNode.getValue());
//		}
//		System.out.println("Passing to the parser");
		Parser parser = new Parser(postfixTest);
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
