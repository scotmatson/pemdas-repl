
public class Math {
	
	public static double add(double op1, double op2)
	{
		return op1 + op2;
	}
	
	public static double subtract(double op1, double op2)
	{
		return op1 - op2;
	}
	
	public static double multiply(double op1, double op2)
	{
		return op1 * op2;
	}
	
	public static double divide(double op1, double op2) //throws ArithmeticException
	{		
		return op1 / op2;	
	}
	
	public static double exponential(double op1, double op2)
	{
		int product = 1;
		for (int i = 0; i < op2; i++)
		{
			product *= op1;
		}
		return product;
	}
}