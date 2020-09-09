package controller;

import java.util.List;
import java.util.Scanner;

import model.ExportProduct;
import model.ImportProduct;
import model.Product;
import validate.Validate;

public class AddController {
    public static Scanner scanner = new Scanner(System.in);

    public static int updateCount() {
        int countId;
        List<Product> list = FileController.readFile();
        if (list.isEmpty()) countId = 1;
        else {
            int id = list.get(list.size() - 1).getId();
            countId = id + 1;
        }
        return countId;
    }
	public static void addImport() {
		 int id =updateCount(); 
		 String productCode = Validate.validateString("product code");
		 String productName= Validate.validateString("product name");
		 String price = Validate.validateNumber("price");
		 String numberOfProduct=Validate.validateNumber("number of product");
		 String company=Validate.validateString("company");
		 String importPrice=Validate.validateNumber("import price");
	     String importCity=Validate.validateString("import city");
	     String tax=Validate.validateString("tax");
	     Product product = new ImportProduct( id,  productCode,  productName,  price,  numberOfProduct,
					 company, importPrice, importCity, tax);
	     FileController.writeFile(product,"insert");
	     System.out.println("add import product completely !");
		
	}

	public static void addExport() {
		 int id =updateCount(); 
		 String productCode = Validate.validateString("product code");
		 String productName= Validate.validateString("product name");
		 String price = Validate.validateNumber("price");
		 String numberOfProduct=Validate.validateNumber("number of product");
		 String company=Validate.validateString("company");
		 String exportPrice=Validate.validateNumber("export price"); 
		 String country=Validate.validateString("country");;
	     Product product = new ExportProduct( id,  productCode,  productName,  price,  numberOfProduct,
					 company, exportPrice, country);
	        FileController.writeFile(product,"insert");
	        System.out.println("add export product completely !");
		
		
	}

}
