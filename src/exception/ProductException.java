package exception;

public class ProductException extends Exception{

	private static final long serialVersionUID = 1L;

	public void getMassage(){
	        System.out.println("product is not exist!");
	    }
}
