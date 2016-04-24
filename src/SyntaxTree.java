
public class SyntaxTree 
{
	private Node<String> root; // Root is always an operator
	private Stack<String> fertilizer; // Stores building materials
	
	
	// So what about holding? we need to address the int int int op situation
	// int int op is a block
	// exp int op is a block
	// int exp op is a block
	
	/**
	 * Constructor method
	 */
	public SyntaxTree()
	{
		fertilizer = new Stack<String>();
	}
	
	/**
	 * Filters incoming nodes
	 * @param food
	 */
	public void feedTree(Node<String> food)
	{
		if (food.getType() == Grammar.OPERAND)
		{
			fertilizer.push(food);
		}
		else if (food.getType() == Grammar.OPERATOR)
		{
			// Here is where we actually do some building
			growTree(food);
		}
	}
	
	/**
	 * Builds the tree
	 * @param food
	 */
	public void growTree(Node<String> food)
	{
		if (this.root != null)
		{
			// This part will be a bit harder.
			// Remember * [previous = left] [next = right]
			
		}
		else
		{
			plantTree(food);
		}		
	}
	
	private void plantTree(Node<String> seed)
	{
		this.root = seed;
	}
}