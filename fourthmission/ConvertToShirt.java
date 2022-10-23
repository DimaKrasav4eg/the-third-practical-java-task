package fourthmission;

import java.util.InputMismatchException;

public class ConvertToShirt{

	public static void main(String[] args) {
		
		String[] shirts = new String[11];
		
		shirts[0]  = "S001,Black Polo Shirt,Black,XL";
		shirts[1]  = "S002,Black Polo Shirt,Black,L";
		shirts[2]  = "S003,Blue Polo Shirt,Blue,XL";
		shirts[3]  = "S004,Blue Polo Shirt,Blue,M";
		shirts[4]  = "S005,Tan Polo Shirt,Tan,XL";
		shirts[5]  = "S006,Black T-Shirt,Black,XL";
		shirts[6]  = "S007,White T-Shirt,White,XL";
		shirts[7]  = "S008,White T-Shirt,White,L";
		shirts[8]  = "S009,Green T-Shirt,Green,S";
		shirts[9]  = "S010,Orange T-Shirt,Orange,S";
		shirts[10] = "S011,Maroon Polo Shirt,Maroon,S";
		
		
		Shirt[] shir = new Shirt[11];
		for (int i = 0; i < shirts.length; ++i) {
			String[] oneShirt = shirts[i].split(DILIMITER);
			if (oneShirt.length != 4) {
				throw new InputMismatchException();
			}
			shir[i] = new Shirt(oneShirt[0], oneShirt[1], oneShirt[2], oneShirt[3]);
		}
		
		for (int i = 0; i < shir.length; ++i) {
			System.out.println(shir[i].toString());
		}
	}
	
	private final static String DILIMITER = ",";
}
