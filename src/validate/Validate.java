package validate;

import java.util.Scanner;

public class Validate {
	private static final String INTEGER_NUMBER_REGEX = "\\d+";
	private static final String FLOAT_NUMBER_REGEX = "\\d+(\\.\\d+)?";
	public static Scanner scanner = new Scanner(System.in);
	public static boolean checkIntergerNumber(String input) {
		return input.matches(INTEGER_NUMBER_REGEX);
	  }

    public static boolean checkFloatNumber(String nhap) {
        return nhap.matches(FLOAT_NUMBER_REGEX);
    }
	public static String validateNumber(String infor) {
		String input;
		do {
		    System.out.print("input " + infor + " : ");
		    input = scanner.nextLine();
            if (checkFloatNumber(input) && Float.parseFloat(input) > 0) break;
            else System.out.println("Invalid entry!");
            		
		}while(true);
		
		return input;
	}

    public static String validateString(String infor){
    	String input;
        do {
        	   System.out.print("input " + infor + " : ");
        	   input = scanner.nextLine();
            if (input.equals("")) System.out.println("Information cannot be left blank !");
            else break;
        } while (true);
        return input;
    }
}
