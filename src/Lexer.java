/**
 * Tokenizes a mathematical expression
 * 
 * <p>
 * Using the Alphabet, the lexer class accepts string input
 * from a user and evaluates each symbol in efforts to understand
 * the meaning of its constituents.
 * 
 * @author Scot Matson
 * @version 0.00 Alpha
 * @since 04/27/2016
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
	 * Assigns an expression to the lexer to be tokenized
	 * @param parsableInput
	 */
	public void setParsable(String expression)
	{
		this.expression = expression.trim();
		tokenize();
	}
	
	/**
	 * Returns a tokenized version of the String expression
	 * @return A tokenized expression
	 */
	public Queue<String> getTokens()
	{
		return tokenizer;
	}
	
	/**
	 * Tokenizes valid symbols, ignores whitespace, and
	 * notifies user of symbols unrecognized by the Alphabet
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
					while (i < expression.length() && Character.isDigit(expression.charAt(i)) ||
						   i < expression.length() && isDecimal(expression.charAt(i)))
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
	 * Evaluates if a symbol is a left parenthesis
	 * 
	 * @param symbol A String symbol
	 * @return True if the symbol is a left parenthesis
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
	 * Evaluates if a symbol is a left parenthesis
	 * 
	 * @param symbol A char symbol
	 * @return True if the symbol is a parenthesis
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
	 * Evaluates if a symbol is a right parenthesis
	 * 
	 * @param symbol A String symbol
	 * @return True if the symbol is a right parenthesis
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
	 * Evaluates if a symbol is a right parenthesis
	 * 
	 * @param symbol A char symbol
	 * @return True if the symbol is a right parenthesis
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
	 * Evaluates if a symbol is an assignment operator
	 * 
	 * @param symbol A String symbol
	 * @return True if the symbol is an assignment operator
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
	 * Evaluates if a symbol is an assignment operator
	 * 
	 * @param symbol A char symbol
	 * @return True if the symbol is an assignment operator
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
	 * Evaluates if a symbol is a decimal
	 * 
	 * @param symbol A char symbol
	 * @return True if the symbol is a decimal
	 */
	public boolean isDecimal(char symbol)
	{
		if (symbol == '.')
		{
			return true;
		}
		return false;
	}
	
	/**
	 * Evaluates if a symbol is an operator
	 * 
	 * @param symbol A String symbol
	 * @return True if the symbol is an operator
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
	 * Evaluates if a symbol is an operator
	 * 
	 * @param symbol A char symbol
	 * @return True if the symbol is an operator
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
	
	/**
	 * Gets the prescedence of an operator
	 * 
	 * @param symbol A String symbol
	 * @return An operators prescedence
	 */
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
	 * Evaluates if a symbol is an operand
	 * 
	 * @param symbol A String symbol
	 * @return True if the symbol is an operand
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