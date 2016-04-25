
public class Parser
{
	Queue<String> tokens;
	Stack<String> treeBuilder;
	
	public Parser(Queue<String> tokens)
	{
		this.tokens = tokens;
		treeBuilder = new Stack<String>();
		buildTree();
	}
	
	public void buildTree()
	{
		while (!tokens.isEmpty())
		{
			if (tokens.peek().getType() == Grammar.OPERAND)
			{
				Node<String> token = tokens.dequeue();
				//token.setNext(null);
				//token.setPrevious(null);
				//System.out.println("Push to Stack: " + token.getValue());
				treeBuilder.push(token);
			}
			else if (tokens.peek().getType() == Grammar.OPERATOR)
			{
				Node<String> token = tokens.dequeue();
				//token.setNext(null);
				//token.setPrevious(null);
				buildTree(token);
			}
		}
	}
	
	public void buildTree(Node<String> token)
	{
		// Remember * [previous = left] [next = right]
		Node<String> op1 = treeBuilder.pop();
		Node<String> op2 = treeBuilder.pop();
		//System.out.println("op1: " + op1.getValue());
		//System.out.println("op2: " + op2.getValue());
		token.setLeft(op1);
		token.setRight(op2);
		token.setType(Grammar.EXPRESSION);
		//System.out.println("Expression on stack: " + token.getValue());
		treeBuilder.push(token);
		// The stack is overriding this.. you are going to need to make
		// a tree data structure - for reals
	}
	
	public Node<String> getParseTree()
	{
		return treeBuilder.pop();
	}
}