/**
 * A parser that turns tokens into a Syntax Tree
 * 
 * <p>
 * Current version requires post-fixed ordering of a
 * tokenized String. From the tokens a Tree is 
 * constructed from the bottom-up.
 * 
 * @author Scot Matson
 * @version 0.00 Alpha
 * @since 04/27/2016
 *
 */
public class Parser
{
	private Queue<String> tokens;
	private Stack<String> treeBuilder;
	private String storeKey;
	
	/**
	 * Constructor method
	 * 
	 * @param tokens A post-fixed tokenized Queue of Strings
	 */
	public Parser(Queue<String> tokens)
	{
		this.tokens = tokens;
		storeKey = null;
		treeBuilder = new Stack<String>();
		buildTree();
	}
	
	/**
	 * Builds a Syntax tree utilizing PEMDAS ordering for arithmetic evaluation
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
	 *  Creates branch associations for a
	 *  Syntax Tree
	 * 
	 * @param token A parent node
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
	 * Returns the root node from the parse tree,
	 * this is the only one that matters.
	 * 
	 * @return The root node
	 */
	public Node<String> getParseTree()
	{
		return treeBuilder.pop();
	}
	
	/**
	 * Returns variables for assigned
	 * expressions.
	 * 
	 * @return An Identifier String
	 */
	public String getStoreKey()
	{
		return storeKey;
	}
	
	/**
	 * Resets the locally stored value.
	 */
	public void resetStoreKey()
	{
		storeKey = null;
	}
}