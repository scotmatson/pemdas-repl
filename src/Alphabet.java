
public class Alphabet {	
	
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