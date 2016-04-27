/**
 * A static implementation of operations and their
 * associated values
 * 
 * @author Scot Matson
 * @version 0.00 Alpha
 * @since 04/27/2016 *
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
	
	/**
	 * Constructor method
	 * 
	 * @param value Value to be assigned
	 */
	Pemdas(int value)
	{
		this.value = value;
	}
	
	/**
	 * Gets the prescedence of an operation
	 * @return
	 */
	public int getPrescedenceValue()
	{
		return value;
	}
}