
public class Math {

	public static int add(int op1, int op2)
	{
		return op1 + op2;
	}
	
	public static double add(int op1, double op2)
	{
		return op1 + op2;
	}
	
	public static double add(double op1, int op2)
	{
		return op1 + op2;
	}
	
	public static double add(double op1, double op2)
	{
		return op1 + op2;
	}
	
	public static int subtract(int op1, int op2)
	{
		return op1 - op2;
	}
	
	public static double subtract(int op1, double op2)
	{
		return op1 - op2;
	}
	
	public static double subtract(double op1, int op2)
	{
		return op1 - op2;
	}
	
	public static double subtract(double op1, double op2)
	{
		return op1 - op2;
	}
	
	public static int multiply(int op1, int op2)
	{
		return op1 * op2;
	}
	
	public static double multiply(int op1, double op2)
	{
		return op1 * op2;
	}
	
	public static double multiply(double op1, int op2)
	{
		return op1 * op2;
	}
	
	public static double multiply(double op1, double op2)
	{
		return op1 * op2;
	}
	
	public static int divide(int op1, int op2)
	{
		if (op2 == 0)
		{
			System.out.println("Divide by zero.");
			System.exit(1);
		}
		
		return op1 / op2;
	}
	
	public static double divide(int op1, double op2)
	{
		if (op2 == 0)
		{
			System.out.println("Divide by zero.");
			System.exit(1);
		}
		
		return op1 / op2;	}
	
	public static double divide(double op1, int op2)
	{
		if (op2 == 0)
		{
			System.out.println("Divide by zero.");
			System.exit(1);
		}
		
		return op1 / op2;	}
	
	public static double divide(double op1, double op2)
	{
		if (op2 == 0)
		{
			System.out.println("Divide by zero.");
			System.exit(1);
		}
		
		return op1 / op2;	
	}
	
	public static int exponential(int op1, int op2)
	{
		int product = 1;
		for (int i = 0; i < op2; i++)
		{
			product *= op1;
		}
		return product;
	}
	
	public static double exponential(double op1, double op2)
	{
		return 0.0;
	}
}