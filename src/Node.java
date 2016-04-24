
public class Node<T>
{
	private Node<T> previous;
	private Node<T> next;
	Grammar type;
	private T value;
	
	public Node(Grammar type, T value)
	{
		this.type = type;
		this.value = value;
		this.previous = null; // Left  for tree
		this.next = null;     // Right for tree
	}
	
	public T getValue()
	{
		return this.value;
	}
	
	public Grammar getType()
	{
		return this.type;
	}
	
	public Node<T> getPrevious()
	{
		return previous;
	}
	
	public void setPrevious(Node<T> previous)
	{
		this.previous = previous;
	}
	
	public void setNext(Node<T> next)
	{
		this.next = next;
	}
	
	public Node<T> getNext()
	{
		return this.next;
	}
}