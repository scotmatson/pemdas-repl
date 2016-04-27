/**
 * The symbols that make up the language of the application
 * 
 * <p>
 * This class provides an understanding for the rest of the application.
 * If a symbol is not defined in the Alphabet then we do not consider its
 * application in the program as it is an invalid character input
 * by the user.
 * 
 * @author Scot Matson
 * @version 0.00 Alpha
 * @since 04/27/2016
 *
 */
public class Alphabet {	
	
	/**
	 * Evaluates a symbol to determine it is a member of the alphabet
	 * @param symbol A char to be evaluated
	 * @return True if the symbol is a member of the Alphabet
	 */
	public static boolean hasSymbol(char symbol)
	{
		if (Character.isDigit(symbol) || Character.isAlphabetic(symbol))
		{
			return true;
		}
		else
		{
			switch (symbol)
			{
				case '(':
				case ')':
				case '^':
				case '*':
				case '/':
				case '+':
				case '-':
				case '=':
				case '.':
					return true;
			}
		}
		return false;
	}
}