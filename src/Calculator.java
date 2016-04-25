import java.util.Scanner;

public class Calculator {

	public static void main(String[] args) {
		
		// Initialization
		Scanner in = new Scanner(System.in);
		
		String expression = "";
		// Receive Input
		
		while (expression != "q" || expression != "Q")
		{
			expression = in.nextLine();
			// 53+123/*
			
			System.out.println("Expression: " + expression);
			
			// Token analysis
			Lexer lexer = new Lexer();
			lexer.setParsable(expression);
			
			// Parseable format
			Postfixer postfixer = new Postfixer(lexer.getTokens());
			Queue<String> postfixExpression = postfixer.getPostfixed();
				
			// Tree structure
			Parser parser = new Parser(postfixExpression);
			Node<String> root = parser.getParseTree();	
			
			// Evaluation
			Evaluator evaluator = new Evaluator(root);
			System.out.println(evaluator.getResult());
		}
		
		
		// TODO: Help menu
		// TODO: Exceptions.... so many exceptions
		// TODO: It would be helpful to refactor into packages
		// TODO: Unit Testing would be a good idea
		
		in.close();
		System.out.println("\nProgram terminated successfully.");
	}
}
