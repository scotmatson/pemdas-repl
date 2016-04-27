/**
 * Custom implementation of a Queue data structure
 * 
 * @author Scot Matson
 * @version 0.00 Alpha
 * @since 04/27/2016
 * 
 * @param <T> A generic Type parameter
 */
public class Queue<T>
{
	Node<T> first;
	Node<T> last;
	
	/**
	 * Constructor Method
	 */
	public Queue()
	{
		first = null;
	}
	
	/**
	 * Checks for existing nodes on the stack
	 * @return boolean value
	 */
	public boolean isEmpty()
	{
		return (first == null);
	}
	
	/**
	 * Pushes a node onto the stack
	 * @param newNode a Node
	 */
	public void enqueue(Node<T> newNode)
	{
		if (first != null)
		{
			if (last != null)
			{
				last.setNext(newNode);
				last = newNode;
			}
			else 
			{
				last = newNode;
				first.setNext(last);
			}
		}
		else
		{
			first = newNode;
		}
	}
	
	/**
	 * Removes the first element from the queue
	 * @return The first element in the queue
	 */
	public Node<T> dequeue()
	{
		if (!isEmpty())
		{
			Node<T> temp = first;
			first = first.getNext();
			// Sever connections
			temp.setNext(null);
			temp.setPrevious(null);
			return temp;
		}
		return null;
	}
	
	/**
	 * Looks at the first element in the queue
	 * @return The first element in the queue
	 */
	public Node<T> peek()
	{
		if (!isEmpty())
		{
			return first;
		}
		return null;
	}
}