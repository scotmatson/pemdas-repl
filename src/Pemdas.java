/**
 * 
 * @author Scot Matson
 *
 */
public enum Pemdas {
	LEFT_PAREN(5),
	RIGHT_PAREN(5),
	EXPONENT(4),
	MULTIPLY(3),
	DIVIDE(2),
	ADD(1),
	SUBTRACT(0);
	
	private int value;
	
	Pemdas(int value)
	{
		this.value = value;
	}
	
	public int getPrescedenceValue()
	{
		return value;
	}
}