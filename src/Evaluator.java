
public class Evaluator {

	Stack<String> stack;
	Node<String> node;
	Node<String> lastVisited;
	int result;
	
	public Evaluator(Node<String> parseTree)
	{
		this.node = parseTree;
		stack = new Stack<String>();
		computeExpression(node);
	}
	
	public int computeExpression(Node<String> node)
	{
		if (node.getLeft() == null && node.getRight() == null)	// We have a leaf node
		{
			return Integer.parseInt(node.getValue());
		}
		
		int right = computeExpression(node.getLeft());
		int left = computeExpression(node.getRight());
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
	
	public int getResult()
	{
		return this.result;
	}
	
}
