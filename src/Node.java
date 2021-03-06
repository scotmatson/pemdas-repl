/**
 * A heavily overused node class
 * 
 * <p>
 * This node class is designed to accommodate any 
 * data structure thrown at it. It is more of a 
 * convenience implementation to avoid heavy
 * reliance on the Java Libraries.
 * 
 * @author Scot Matson
 * @version 0.00 Alpha
 * @since 04/27/2016
 *
 * @param <T> A generic Type parameter
 */
public class Node<T>
{
	// For stacks and queues
	private Node<T> previous;
	private Node<T> next;
	
	// For trees
	private Node<T> left;
	private Node<T> right;
	
	// Properties
	Grammar type;
	private T value;
	
	public Node(Grammar type, T value)
	{
		this.type = type;
		this.value = value;
		this.previous = null;
		this.next = null;
		this.left = null;
		this.right = null;
	}
	
	public T getValue()
	{
		return this.value;
	}
	
	public Grammar getType()
	{
		return this.type;
	}
	
	public void setType(Grammar type)
	{
		this.type = type;
	}
	
	public Node<T> getPrevious()
	{
		return this.previous;
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
	
	public Node<T> getLeft()
	{
		return this.left;
	}
	
	public void setLeft(Node<T> left)
	{
		this.left = left;
	}
	
	public Node<T> getRight()
	{
		return this.right;
	}
	
	public void setRight(Node<T> right)
	{
		this.right = right;
	}
}