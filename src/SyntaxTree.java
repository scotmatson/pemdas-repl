
public class SyntaxTree 
{
	// Root is technically just the top of the stack.
	// Since we have referencing to nodes through the root,
	// all we need to do is return the top and we should have 
	// the entire tree available
	
	// These names no longer work and just look stupid
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
	 * I think we can just do this inside the parse class
	 * this answer is operand[exp] operand[exp] operator, the sequence will always be the same
	 * @param food
	 */
	private void growTree(Node<String> food)
	{
		// Remember * [previous = left] [next = right]
		// I don't think we need to worry about the root node,
		// this should just build itself out naturally, the final node will be the root
		Node<String> op1 = fertilizer.pop();
		Node<String> op2 = fertilizer.pop();
		root.setPrevious(op1);
		root.setNext(op2);
		root.setType(Grammar.EXPRESSION);
		fertilizer.push(root);
	}
}