/**
 * Custom Math class
 * 
 * <p>
 * A custom math class that will definitely conflict with
 * java.lang.Math, but I am okay with that. Used to carry
 * out mathematical operations defined by yours truly.
 * 
 * @author Scot Matson
 * @version 0.00 Alpha
 * @since 04/27/2016
 *
 */
public class Math {
	
	/**
	 * Performs the addition operation
	 * 
	 * @param op1 An operand
	 * @param op2 An operand
	 * @return The sum of two operands
	 */
	public static double add(double op1, double op2)
	{
		return op1 + op2;
	}
	
	/**
	 * Performs the subtraction operation
	 * 
	 * @param op1 An operand
	 * @param op2 An operand
	 * @return The difference of two operands
	 */
	public static double subtract(double op1, double op2)
	{
		return op1 - op2;
	}
	
	/**
	 * Performs the mulitiplication operation
	 * 
	 * @param op1 An operand
	 * @param op2 An operand
	 * @return The product of two operands
	 */
	public static double multiply(double op1, double op2)
	{
		return op1 * op2;
	}
	
	/**
	 * Performs the division operation
	 * 
	 * @param op1 An operand
	 * @param op2 An operand
	 * @return The quotient of two operands
	 */
	public static double divide(double op1, double op2) //throws ArithmeticException
	{		
		return op1 / op2;	
	}
	
	/**
	 * Performs exponential evaluation
	 * 
	 * @param op1 An operand
	 * @param op2 An operand
	 * @return The product of exponentiation
	 */
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