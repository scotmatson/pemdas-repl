
public class Stack<T> 
{
	Node<T> top;
	
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
	
	public T peek()
	{
		if (!isEmpty())
		{
			return top.getValue();
		}
		return null;
	}
}