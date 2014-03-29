
public class Testing {

	public static void main(String[] args) {
		
		PolyNode p1 = new PolyNode(1,3,null);
		
		p1.add(3, 2);
		p1.add(3, 3);
		p1.add(2, 4);
		
		for (PolyNode cursor = p1; cursor != null; cursor = cursor.getLink())
			System.out.printf("%s\t%s\n", (int) cursor.getCoeff(), (int)cursor.getExp());
			
		
		

	}

}
