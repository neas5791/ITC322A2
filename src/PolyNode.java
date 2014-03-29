
public class PolyNode {
	
	private double coeff;
	private double exp;
	private PolyNode link;
	
	
	/**
	 * Constructor initializes object with coefficient and exponent values
	 * @param co is the coefficient of the polynomial term
	 * @param ex is the exponent factor of the polynomial term
	 * @param next is the next term in the polynomial equation
	 * 
	 * @postcondition the object is 
	 */
	public PolyNode(double co, double ex, PolyNode next){
		coeff = co; 
		exp = ex;
		link = next;
	}
	
	/**
	 * Inserts a new polynomial term before current term
	 * @param co is the coefficient of the polynomial term
	 * @param ex is the exponent factor of the polynomial term
	 * @postcondition the list is increased in size and the new node is placed before the current node
	 */
	protected void addBefore(double co, double ex){
		link = new PolyNode(coeff, exp, link);
		coeff = co;
		exp = ex;
	}
	
	/**
	 * Inserts a new polynomial term after current term
	 * @param co is the coefficient of the polynomial term
	 * @param ex is the exponent factor of the polynomial term
	 * @postcondition the list is increased in size and the new term is placed after the current term
	 */
	protected void addAfter(double co, double ex){
		link = new PolyNode(co, ex, link);
	}
	
	
	/**
	 * Extends the current list by adding the polynomial term in order of exponent (from largest to smallest)
	 * @param co is the coefficient of the polynomial term
	 * @param ex is the exponent factor of the polynomial term
	 * @postcondition the list is increased in size and the new term is placed ascending order of exponent magnitude.
	 */
	public void add(double co, double ex){

		if (exp == ex) {
			coeff += co;
			return;
		}
		
		if (exp > ex){
			if (link == null)
				addAfter(co,ex);
			else
				link.add(co,ex);
		}
		else
			addBefore(co,ex);
	}
	
	/**
	 * Get the coefficient value of this polynomial term
	 * @return the coefficient value for this polynomial term.
	 */
	public double getCoeff(){
		return coeff;
	}
	
	/**
	 * Get the exponent value of this polynomial term
	 * @return the exponent value of this polynomial term
	 */
	public double getExp(){
		return exp;
	}
	
	/**
	 * Get the next referenced term in the list
	 * @return a reference to the next term in the list
	 */
	public PolyNode getLink(){
		return link;
	}
	
	/**
	 * Determines if the polynomial term has a larger exponent value, used to determine ordered place in list
	 * @param term is a polynomial term for comparison
	 * @return true if the term has a greater polynomial value than
	 */
	public boolean isGreater(PolyNode term){
		//trap null values being passed in
		if (term == null)
			return false;
		
		if (this.exp < term.exp)
			return true;
		return false;
	}
}
