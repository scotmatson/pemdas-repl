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
		Queue<String> postfixTest = postfixer.getPostfixed();	
		
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
