
public class Testing {

	public static void main(String[] args) {
		
		PolyNode p1 = new PolyNode(1,3,null);
		
		// test sorting of polynomial term
		p1.add(3, 2);
		p1.add(3, 3);
		p1.add(-4, 3);		
		p1.add(2, 4);
		p1.add(-3, 1);

		
		for (PolyNode cursor = p1; cursor != null; cursor = cursor.getLink())
			System.out.printf("%s\t%s\n", (int) cursor.getCoeff(), (int)cursor.getExp());
			
		for (PolyNode cursor = p1; cursor != null; cursor = cursor.getLink())
			System.out.printf("%s", cursor.toString());
		
		PolyNode cursor = p1;
		boolean test = true;
		System.out.println();
		while (cursor != null)
		{
			if (test)
				System.out.printf("%s", cursor.toString());
			else if (cursor.getCoeff() > 0)
				System.out.printf("+%s", cursor.toString());
			else
				System.out.printf("%s", cursor.toString());
			test = false;
			cursor = cursor.getLink();
		}

	}

}
