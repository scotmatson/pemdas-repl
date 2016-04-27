/**
 * Custom implementation of a Stack data structure
 * 
 * @author Scot Matson
 * @version 0.00 Alpha
 * @since 04/27/2016
 * 
 * @param <T> A generic Type parameter
 */
public class Stack<T> 
{
	private Node<T> top;
	
	/**
	 * Constructor Method
	 */
	public Stack()
	{
		top = null;
	}
	
	/**
	 * Checks for existing nodes on the stack
	 * @return boolean value
	 */
	public boolean isEmpty()
	{
		return (top == null);
	}
	
	/**
	 * Pushes a node onto the stack
	 * @param newNode a Node
	 */
	public void push(Node<T> newNode)
	{
		if (top != null)
		{
			newNode.setPrevious(top);
			top = newNode;
		}
		else
		{
			top = newNode;
		}
	}
	
	/**
	 * Retrieves an element from the top of the stack
	 * @return The top of the stack
	 */
	public Node<T> pop()
	{
		if (!isEmpty())
		{
			Node<T> temp = top;
			top = top.getPrevious();
			return temp;
		}
		return null;
	}
	
	/**
	 * Looks at the element on the top of the stack
	 * @return The element at the top of the stack
	 */
	public Node<T> peek()
	{
		if (!isEmpty())
		{
			return top;
		}
		return null;
	}
}