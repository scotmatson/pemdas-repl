//import java.util.Arrays;

/**
 * 
 * @author Scot Matson
 *
 */
public class Lexer {

	private String expression;
	private Queue<String> tokenizer;
	
	/**
	 *   Constructor method 
	 */
	Lexer () {
		this.expression = null;
		tokenizer = new Queue<String>();
	}
	
	/**
	 * Constructor method
	 * @param a String
	 */
	Lexer (String expression) {
		this.expression = expression.trim();
		tokenize();
	}
	
	/**
	 * Sets value to be parsed
	 * @param parsableInput
	 */
	public void setParsable(String expression)
	{
		this.expression = expression.trim();
		tokenize();
	}
	
	public Queue<String> getTokens()
	{
		return tokenizer;
	}
	
	/**
	 * Transforms parsable string into Queue
	 *   These nodes will be the building blocks for everything else
	 * and strips out invalid symbols.
	 */
	private void tokenize()
	{
		for(int i = 0; i < expression.length(); i++)
		{
			if (Alphabet.hasSymbol(expression.charAt(i)))
			{
				StringBuilder builder = new StringBuilder();
				Grammar type = null;
				// Is it a variable?
				if (Character.isAlphabetic(expression.charAt(i)))
				{
					type = Grammar.IDENTIFIER;
					while (i < expression.length() && Character.isAlphabetic(expression.charAt(i)))
					{
						builder.append(expression.charAt(i));
						i++;
					}
					i--; // Calibrate
				}
				else if (isAssignment(expression.charAt(i)))
				{
					type = Grammar.ASSIGNMENT;
					builder.append(expression.charAt(i));
				}
				else if (isLeftParen(expression.charAt(i)) ||
						 isRightParen(expression.charAt(i)) ||
						 isOperator(expression.charAt(i)))
				{
					type = Grammar.OPERATOR;
					builder.append(expression.charAt(i));
				}
				else if (Character.isDigit(expression.charAt(i)))
				{
					type = Grammar.OPERAND;
					while (i < expression.length() && Character.isDigit(expression.charAt(i)))
					{
						builder.append(expression.charAt(i));
						i++;
					}
					i--; // Calibrate
				}
				else 
				{
					System.out.println("The symbol '" + expression.charAt(i) + "' has not yet been implemented.");
				}
				Node<String> token = new Node<String>(type, builder.toString());
				tokenizer.enqueue(token);
			}
		}
	}
	
	/**
	 * 
	 * @param symbol
	 * @return
	 */
	public boolean isLeftParen(String symbol)
	{
		if (symbol != null)
		{	
			if (symbol.compareTo("(") == 0)
			{
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 
	 * @param symbol
	 * @return
	 */
	public boolean isLeftParen(char symbol)
	{
		if (symbol == '(')
		{
			return true;
		}
		return false;
	}
	
	/**
	 * 
	 * @param symbol
	 * @return
	 */
	public boolean isRightParen(String symbol)
	{
		if (symbol != null)
		{
			if (symbol.compareTo(")") == 0)
			{
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 
	 * @param symbol
	 * @return
	 */
	public boolean isRightParen(char symbol)
	{
		if (symbol == ')')
		{
			return true;
		}
		return false;
	}
	
	/**
	 * 
	 * @param symbol
	 * @return
	 */
	public boolean isAssignment(String symbol)
	{
		if (symbol != null)
		{
			if (symbol.compareTo("=") == 0)
			{
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 
	 * @param symbol
	 * @return
	 */
	public boolean isAssignment(char symbol)
	{
		if (symbol == '=')
		{
			return true;
		}
		return false;
	}
	
	/**
	 * 
	 * @param symbol
	 * @return
	 */
	public boolean isOperator(String symbol)
	{
		if (symbol != null && symbol.length() == 1) {
			switch (symbol.charAt(0))
			{
				case '^':
				case '*':
				case '/':
				case '+':
				case '-':
					return true;
			}	
		}

		return false;
	}
	
	/**
	 * 
	 * @param symbol
	 * @return
	 */
	public boolean isOperator(char symbol)
	{
		switch (symbol)
		{
			case '^':
			case '*':
			case '/':
			case '+':
			case '-':
				return true;
		}	

		return false;
	}
	
	public int getPrescedence(char symbol)
	{
		switch (symbol)
		{
//			case '(':
//				return Pemdas.LEFT_PAREN.getPrescedenceValue();
//			case ')':
//				return Pemdas.RIGHT_PAREN.getPrescedenceValue();
			case '^':
				return Pemdas.EXPONENT.getPrescedenceValue();
			case '*':
				return Pemdas.MULTIPLY.getPrescedenceValue();
			case '/':
				return Pemdas.DIVIDE.getPrescedenceValue();
			case '+':
				return Pemdas.ADD.getPrescedenceValue();
			case '-':
				return Pemdas.SUBTRACT.getPrescedenceValue();
		}
		return -1;
	}
	
	public int getPrescedence(String symbol)
	{
		if (symbol != null && symbol.length() == 1)
		{
			switch (symbol.charAt(0))
			{
				case '^':
					return Pemdas.EXPONENT.getPrescedenceValue();
				case '*':
					return Pemdas.MULTIPLY.getPrescedenceValue();
				case '/':
					return Pemdas.DIVIDE.getPrescedenceValue();
				case '+':
					return Pemdas.ADD.getPrescedenceValue();
				case '-':
					return Pemdas.SUBTRACT.getPrescedenceValue();
			}
		}
		return -1;
	}
	
	/**
	 * 
	 * @param s
	 * @return
	 */
	public boolean isOperand(String s)
	{
		for (int i = 0; i < s.length(); i++)
		{
			if (!Character.isDigit(s.charAt(i)))
			{
				return false;
			}
		}
		return true;
	}
}