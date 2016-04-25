
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
	
	public Node<T> peek()
	{
		if (!isEmpty())
		{
			return first;
		}
		return null;
	}
}