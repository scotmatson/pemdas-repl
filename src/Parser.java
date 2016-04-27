/**
 * 
 * @author Scot
 *
 */
public class Parser
{
	private Queue<String> tokens;
	private Stack<String> treeBuilder;
	private String storeKey;
	
	/**
	 * 
	 * @param tokens
	 */
	public Parser(Queue<String> tokens)
	{
		this.tokens = tokens;
		storeKey = null;
		treeBuilder = new Stack<String>();
		buildTree();
	}
	
	/**
	 * 
	 */
	public void buildTree()
	{
		while (!tokens.isEmpty())
		{
			if (tokens.peek().getType() == Grammar.OPERAND ||
				tokens.peek().getType() == Grammar.IDENTIFIER)
			{
				Node<String> token = tokens.dequeue();
				treeBuilder.push(token);
			}
			else if (tokens.peek().getType() == Grammar.OPERATOR)
			{
				Node<String> token = tokens.dequeue();
				buildTree(token);
			}
			else if (tokens.peek().getType() == Grammar.ASSIGNMENT)
			{
				// Burn the assignment operator
				tokens.dequeue();
				// Take the IDENTIFER for a key
				// Make sure this is in fact the first element on the stack
				if (treeBuilder.peek().getPrevious() == null)
				{
					storeKey = treeBuilder.pop().getValue();
				}
			}
		}
	}
	
	/**
	 * 
	 * @param token
	 */
	public void buildTree(Node<String> token)
	{
		Node<String> op1 = treeBuilder.pop();
		System.out.println(op1);
		Node<String> op2 = treeBuilder.pop();
		System.out.println(op2);
		token.setLeft(op1);
		token.setRight(op2);
		treeBuilder.push(token);
	}
	
	/**
	 * 
	 * @return
	 */
	public Node<String> getParseTree()
	{
		return treeBuilder.pop();
	}
	
	public String getStoreKey()
	{
		return storeKey;
	}
	
	public void resetStoreKey()
	{
		storeKey = null;
	}
}