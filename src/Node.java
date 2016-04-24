
public class Node<T>
{
	private Node<T> previous;
	private Node<T> next;
	Grammar G;
	private T value;
	
	public Node(Grammar G, T value)
	{
		this.G = G;
		this.value = value;
		this.previous = null;
		this.next = null;
	}
	
	public T getValue()
	{
		return this.value;
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