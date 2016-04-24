
public class Parser
{
	Language language;
	Queue<String> tokens;
	Stack<String> treeBuilder; // I think we need a new data structure here
	
	public Parser(Queue tokens)
	{
		this.language = new Language();
		this.tokens = tokens;
		
		while (!tokens.isEmpty())
		{
			System.out.print(tokens.dequeue().getValue());
		}
	}
	
	
	
	public void buildTree()
	{
		while (!tokens.isEmpty()) {
			
			// If we have an operator, just toss it on the stack
			if (tokens.peekType() == Grammar.OPERAND)
			{
				treeBuilder.push(tokens.dequeue());
			}
			// If we have an operand, we need to package an expression and then put it back on the stack
			else if (tokens.peekType() == Grammar.OPERATOR)
			{
				// This is where a tree structure would be important.
				// How do we point both both nodes to the parent
				// So stack will only manipulate 'previous', we can explicitly create
				// an association with next right here, despite that being somewhat of a hack
			}
		}
	}
}
