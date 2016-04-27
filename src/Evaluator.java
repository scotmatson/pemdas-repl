import java.util.HashMap;

/**
 * Evaluates an arithmetic expression
 * 
 * <p>
 * The Evaluator class evaluates mathematical expressions and
 * stores the results in a locally defined class variable which
 * may explicitly be returned upon request. In this current
 * implementation, the expression must have been structured as
 * a syntax tree in order to be properly evaluated. 
 * 
 * @author Scot Matson
 * @version 0.00 Alpha
 * @since 04/27/2016
 *
 */
public class Evaluator {

	HashMap<String, Double> storage;
	Stack<String> stack;
	Node<String> node;
	Node<String> lastVisited;
	Double result;
	
	/**
	 * Constructor method.
	 * 
	 * @param parseTree The root node of a Syntax Tree
	 * @param storage Stored variables with associated values
	 */
	public Evaluator(Node<String> parseTree, HashMap<String, Double> storage)
	{
		this.storage = storage;
		this.node = parseTree;
		stack = new Stack<String>();
		computeExpression(node);
	}
	
	/**
	 * Computers an arithmetic expression using recursion
	 * 
	 * @param node The current node being evaluated
	 * @return the solution to the expression currently being evaluated
	 */
	public Double computeExpression(Node<String> node)
	{
		// Base case: leaf nodes, from here we may return from our
		// recursion
		if (node.getLeft() == null && node.getRight() == null)
		{
			if (node.getType() == Grammar.IDENTIFIER)
			{
				if (storage.get(node.getValue()) == null)
				{
					System.out.println("ERROR: Undefined variable!");
					
				}
				return storage.get((node.getValue()));
			}
			return Double.parseDouble(node.getValue());
		}
		
		// At this step we are isolating the values to be evaluated
		Double right = computeExpression(node.getLeft());
		Double left = computeExpression(node.getRight());
		switch(node.getValue())
		{
			case "^":
				result = Math.exponential(left, right);
				break;
			case "*":
				result = Math.multiply(left, right);
				break;
			case "/":
				result = Math.divide(left, right);
				break;
			case "+":
				result = Math.add(left, right);
				break;
			case "-":
				result = Math.subtract(left, right);
				break;
		}
		return result;
	}
	
	
	/**
	 * Gets the result of the expression
	 * @return The solution to the expression
	 */
	public Double getResult()
	{
		return this.result;
	}
}
