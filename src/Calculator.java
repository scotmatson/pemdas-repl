import java.util.HashMap;
import java.util.Scanner;

/**
 * Entry point for the REPL Calculator Application
 * 
 * <p>
 * This application was written to fulfill the PEMDAS REPL assignment
 * for SJSU's CS 152 - Programming Paradigms course. It incorporates
 * basic compiler design concepts including but not limited to, tokens,
 * lexers, parsers, syntax trees, and analyzers.
 * <p>
 * The Calculator class provides a simple terminal-based interface for user
 * interaction. Functionality includes basic arithmetic expression evaluation,
 * variable assignment, and a means to terminate the application.
 * 
 * @author Scot Matson
 * @version 0.00 Alpha
 * @since 04/27/2016
 *
 */
public class Calculator {

	/**
	 * The obligatory main method
	 * 
	 * @param args No user defined arguments are evaluated in this application
	 */
	public static void main(String[] args) {
		
		// TODO: Help Menu
		// TODO: Error checking.... so much error checking
		// ERROR: x = 3
		// Divide by zero is weird, returns MAXINT
		
		System.out.println("******************************");
		System.out.println("*       REPL Calculator      *");
		System.out.println("*            By              *");
		System.out.println("*        Scot Matson         *");
		System.out.println("*                            *");
		System.out.println("*       Version: 0.00        *");
		System.out.println("*       Alpha Release        *");
		System.out.println("*            ---             *");
		System.out.println("*       Copyright 2016       *");
		System.out.println("*                            *");
		System.out.println("******************************");
		
		new Calculator().run();
		System.out.println("Application terminated unexpectedly.");
	}
	
	/**
	 * Begins an infinite loop which 'runs' the application
	 */
	public void run()
	{
		System.out.println("Launching REPL Calculator");
		
		Scanner in = new Scanner(System.in);
		HashMap<String, Double> storage = new HashMap<String, Double>();
		while (true)
		{						
			System.out.println("Enter an expression to be evaluated or input (Q)uit to quit");
			System.out.print(">> ");
			String expression = in.nextLine();
			
			// Multiple ways to exit, because users are unreliable
			if (expression.compareTo("Q") == 0 ||
				expression.compareTo("q") == 0 ||
				expression.compareTo("Quit") == 0 ||
				expression.compareTo("quit") == 0)
			{
				exitApplication(in);
			}
			
			// Token analysis
			Lexer lexer = new Lexer();
			lexer.setParsable(expression);
			
			// Post-fix conversion
			// We could technically could integrate this into the parser but I find
			// this approach to be much cleaner
			Postfixer postfixer = new Postfixer(lexer.getTokens());
			Queue<String> postfixExpression = postfixer.getPostfixed();

			// Tree building
			Parser parser = new Parser(postfixExpression);
			Node<String> root = parser.getParseTree();

			// Evaluation
			System.out.println("Prepare to be evaluated!");
			Evaluator evaluator = new Evaluator(root, storage);
			
			// Handling the output from the evaluation
			double solution;
			// Store the expression
			if (parser.getStoreKey() != null)
			{
				System.out.println("I'm storing the expression!");
				storage.put(parser.getStoreKey(), evaluator.getResult());
				solution = storage.get(parser.getStoreKey());
				parser.resetStoreKey();
			}
			// Or simply output the solution
			else
			{
				solution = evaluator.getResult();
			}						
			
			// Output formatting for integer or doubles
			// Super hacky but it works. Never do this in production!
			// Attributed to user durron597 of the Stack Overflow community
			// https://stackoverflow.com/questions/31642352/how-do-i-read-input-that-could-be-an-int-or-a-double
			if (solution == java.lang.Math.floor(solution))
			{
				System.out.println((int) solution);
			}
			else
			{
				System.out.println(solution);
			}
		}
	} // End launchCalculator
	
	/**
	 * Controls the termination of the application
	 * 
	 * @param in A Scanner object which needs to be closed
	 */
	public void exitApplication(Scanner in)
	{
		in.close();
		System.out.println("\nProgram terminated successfully.");
		System.exit(1);
	}
}