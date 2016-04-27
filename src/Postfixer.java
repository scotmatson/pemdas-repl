/**
 * Translates an infixed artihmetic expression into a postfix expression
 * using the Shunting Yard Algorithm.
 * 
 * Pseudocode can be found at https://en.wikipedia.org/wiki/Shunting-yard_algorithm
 * Runtime complexity is O(n) - Pimpin'
 * @author Scot Matson
 */
public class Postfixer 
{
	private Lexer lexer;
	private Queue<String> output;
	private Stack<String> operators;
	private Queue<String> tokens;
	
	public Postfixer(Queue<String> tokens)
	{
		lexer = new Lexer();
		output = new Queue<String>();
		operators = new Stack<String>();
		this.tokens = tokens;
		processTokens();
	}
	
	private void processTokens()
	{
		while (!tokens.isEmpty())
		{
			if (tokens.peek().getType() == Grammar.OPERAND ||
				tokens.peek().getType() == Grammar.IDENTIFIER ||
				tokens.peek().getType() == Grammar.ASSIGNMENT) // Right place for this?
			{
				output.enqueue(tokens.dequeue());
			}
			// If there is an operator o1
			else if (tokens.peek().getType() == Grammar.OPERATOR)
			{
				// If token is left parenthesis, push it onto the stack
				if(lexer.isLeftParen(tokens.peek().getValue()))
				{
					operators.push(tokens.dequeue());
				}
				// If token is a right parenthesis...
				else if(lexer.isRightParen(tokens.peek().getValue()))
				{
					// Discard the right parenthesis
					tokens.dequeue();
					// Until top of operator stack is the left parenthesis, pop operators onto operands
					while (!operators.isEmpty() && !lexer.isLeftParen(operators.peek().getValue()))
					{

						output.enqueue(operators.pop());
						// TODO: Throws MismatchedParenthesisError
					}
					// Discard the left parenthesis
					operators.pop();
				}
				else
				{
					// While there is an operator o2 on the stack (left associativity)
					while (!operators.isEmpty() && 
						   lexer.getPrescedence(tokens.peek().getValue()) <= lexer.getPrescedence(operators.peek().getValue()))
					{
						// Move the higher order operator to the output queue
						output.enqueue(operators.pop());
					}
					// Push new operator onto operator stack
					operators.push(tokens.dequeue());
				}
			}
		}
		
		while (!operators.isEmpty())
		{
			// Throws MismatchedParenthesisError
			output.enqueue(operators.pop());
		}
	}
	
	/**
	 * 
	 * @return
	 */
	public Queue<String> getPostfixed()
	{
		return output;
	}
}