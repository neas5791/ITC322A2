import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class PolyBag {
	
	// Invariant of the LinkedBag<E> class:
	//   1. The elements in the bag are stored on a linked list.
	//   2. The head reference of the list is in the instance variable 
	//      head.
	//   3. The total number of elements in the list is in the instance 
	//      variable manyNodes.
	
	private PolyNode head;
	private int manyNodes;
	
	/**
	 * Initialize an bag with first polynomial term.
	 * @param coeff
	 * @param exp
	 * @postcondition bag is initialized with first term of polynomial expression
	 */
	public PolyBag(String equation)
	{
		manyNodes = 0;
		BuildPolynomial(equation, this.head);
	}
	
	public PolyBag(FileReader fileName){
		List<String[]> lines = new ArrayList<String[]>();
		
		try {
			//FileReader file = new FileReader(fileName);
			BufferedReader buffer = new BufferedReader(fileName);
			String str_line;

			while ((str_line = buffer.readLine()) != null)
			{
				str_line = str_line.trim();
				// makes sure the string isn't an empty line
				if ((str_line.length())!=0){
					List<String[]> tempLine = Formatter.FormatStripper(str_line);
					if (tempLine != null)
						lines.addAll(tempLine);
				}
			}
			buffer.close();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
	}
		   
	/**
	 * Builds the polynomial link list at a given location
	 * @param equation the polynomial to represent as a linked list
	 * @param nodeHead the location to add the list at
	 * @postcondition the PolyBag has additional polynomial equation added
	 */
	public void BuildPolynomial(String equation, PolyNode nodeHead)
	{
		List<String []> polynomial = Formatter.FormatStripper(equation);
		for (String[] x : polynomial)
			if (nodeHead == null) {
				nodeHead = new PolyNode (Double.parseDouble(x[0]), Double.parseDouble(x[1]), nodeHead);
				manyNodes++;
			}
			else
				nodeHead.insert(Double.parseDouble(x[0]), Double.parseDouble(x[1]));

	}
	    
	public void insertPolynomial(String equation){
		
	}
	    
	
}
