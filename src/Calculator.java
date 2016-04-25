import java.util.Scanner;

public class Calculator {

	public static void main(String[] args) {
		
		// TODO: Help Menu
		// TODO: Support stored values
		// TODO: Support doubles
		// TODO: Error checking
		
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
	
	public void run()
	{
		while (true) 
		{
			System.out.println("Please select an option from the menu below:");
			System.out.println("1: Launch Calculator");
			System.out.println("2: Help Menu");
			System.out.println("3: Exit");

			System.out.print(">> ");
			Scanner in = new Scanner(System.in);
			switch(in.nextLine())
			{
				case "1":
					launchCalculator(in);
					break;
				case "2":
					printHelp();
					break;
				case "3":
					exitApplication(in);
				default:
					System.out.println("WARNING: Unknown input received.\n");
			}
		}		
	} // End menu
	
	public void launchCalculator(Scanner in)
	{
		System.out.println("Launching REPL Calculator");
		System.out.println("At any time, input (M)enu to return to the main menu, or (Q)uit to quit");
		while (true)
		{						
			System.out.print(">> ");
			String expression = in.nextLine();
			if (expression.compareTo("M") ==0 ||
				expression.compareTo("m") ==0 ||
				expression.compareTo("Menu") ==0 ||
				expression.compareTo("menu")==0)
			{
				return;
			}
			else if (expression.compareTo("Q") ==0 ||
					 expression.compareTo("q") ==0 ||
					 expression.compareTo("Quit") ==0 ||
					 expression.compareTo("quit") ==0)
			{
				exitApplication(in);
			}
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
	} // End launchCalculator
	
	public void printHelp()
	{
		System.out.println("-- Help --");
	} // End printHelp
	
	public void exitApplication(Scanner in)
	{
		in.close();
		System.out.println("\nProgram terminated successfully.");
		System.exit(1);
	}
}
