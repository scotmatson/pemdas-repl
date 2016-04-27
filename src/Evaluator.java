import java.util.HashMap;

public class Evaluator {

	HashMap<String, Double> storage;
	Stack<String> stack;
	Node<String> node;
	Node<String> lastVisited;
	Double result;
	
	public Evaluator(Node<String> parseTree, HashMap<String, Double> storage)
	{
		this.storage = storage;
		this.node = parseTree;
		stack = new Stack<String>();
		computeExpression(node);
	}
	
	public Double computeExpression(Node<String> node)
	{
		
		if (node.getLeft() == null && node.getRight() == null)	// We have a leaf node
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
	
	
	
	public Double getResult()
	{
		return this.result;
	}
	
}
