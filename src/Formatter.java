
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Formatter {
	
	public static List<String[]> FormatStripper(String lineToFormat){
		String[] terms;		// these are the individual terms of the polynomial equation
		List<String[]> termList = new ArrayList<String[]>();
		String[] answer;
		try
		{
			
			// to simplfy splitting changed all negative to +-
			// [a-zA-Z]{1}[-]{1}|\\^{1}[-]{1}
			lineToFormat = lineToFormat.replaceAll("(?<!\\^)[-]", "+-");
			// split the polynomial expression into individual terms
			terms = lineToFormat.split("\\+"); // ** have to use the escape \\ to find + sign in regex
			
			for (int i = 0; i < terms.length; i++) {

				// checks for coefficients of the value +/- 1
				if (terms[i].matches("^[-+]?[a-zA-Z]+\\^?\\d*\\.?\\d*|^[-+]?[a-zA-Z]+"))
					terms[i] = terms[i].replaceFirst("[a-zA-Z]{1}", "1x");
				
				// checks for exponents of value 1
				if ( terms[i].matches("^[-+]?\\d*\\.?\\d*[a-zA-Z]+"))
					terms[i]+= "^1";				
				// checks for exponents of value 1
				else if ( terms[i].matches("^[-+]?\\d*\\.?\\d+"))
					terms[i] += "x^0";
				
				if (!terms[i].matches("^[-+]?\\d*\\.?\\d*[a-zA-Z]+\\^{1}\\(?[-+]?\\d*\\.?\\d+\\)?|^[a-zA-Z]+$|^\\d+$"))
					throw new NumberFormatException ("Line formating is corrupt, trying to decode "+terms[i]);
			}
			
			String[] temp = new String[2];
			for (int i = 0; i< terms.length ; i++){
				temp = terms[i].split("[a-zA-Z]+\\^?");
				termList.add(temp);
			}
			
			/*for (String str : terms){
				String[] temp;
				temp = str.split("[a-zA-Z]+\\^?");
				termList.addAll(Arrays.asList(temp));
			}*/
	
			/*int counter = 1;
			for (String x : node){
				System.out.print(x + "\t");
				if (counter%2 == 0)
					System.out.println();
				counter++;
			}*/
		}
		catch (NumberFormatException nfe)
		{
			return null;
		}
		return termList;
	}
}
