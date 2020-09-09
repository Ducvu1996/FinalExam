package controller;


import java.util.List;
import java.util.Scanner;

import exception.ProductException;

import model.Product;



public class MainController {
	public static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args){
		String choice;
		boolean exit = false;
		displayMainMenu();
		while(true) {
			System.out.println("input a choice");
			choice= scanner.nextLine();
			switch(choice) {
				case "1":
					addProduct();
					break;
				case "2":
					deleteProduct();
					break;
				case "3":
					showProduct();
					break;
				case "4": 
					searchProduct();
					break;
				case "5": 
					System.out.println("exited!");
					exit = true;
	                break;
				 default:
		                System.out.println("invalid! please choose action in below menu:");
		                break;
		            }
		         if (exit) {
		              break;
		          }
		        displayMainMenu();  
			}	
		
	}

	private static void searchProduct() {
		List<Product> listProduct = FileController.readFile();
	
        if (!listProduct.isEmpty()) {
        	System.out.print("Input name of product or code of product to find :");
            String inputInfor = scanner.nextLine();
            boolean check = false;
            if(inputInfor.equals("")) {
            	System.out.println("you input nothing so we found nothing");
            	return;
            }
            for (Product product : listProduct) {
                if (product.getProductName().contains(inputInfor) || product.getProductCode().contains(inputInfor)) {
                    check = true;
                    System.out.println(product);
                    break;
                }
            }
            if (check==false) {
            	System.out.println("can't find your product !");
            }
        } else { 
        	System.out.println("file is null!");
        }
	}
	private static void showProduct() {
		List<Product> listProduct = FileController.readFile();
		if (!listProduct.isEmpty()) {
	        int count = 1;
	        System.out.println("List of product :");
	        for (Product product : listProduct) {
	            System.out.println("product " + count+":" + product);
	            count++;
	        }
	    } else { 
	    	System.out.println("there is no product !");
	    }
	}
	private static void deleteProduct() {
		List<Product> listProduct = FileController.readFile();
		if (!listProduct.isEmpty()) {
			do {
	            try {
	                System.out.print("Input product code that you wanna delete: \n ");     
	                String input= scanner.nextLine();
	                for (int i = 0; i < listProduct.size();i++) {
	                    if(input.equals(listProduct.get(i).getProductCode())) {
	                   
	                            System.out.println("\r\n" + 
	                            		"Do you really want to remove this product ?!\n"
	                            		+ "\n1. Yes" +
	                                    "\n2. No"
	                                    + "\ninput your choice:");
	                            String choice = scanner.nextLine();
	                            if (choice.equals("1")) {
	                            	listProduct.remove(i);
	                            	FileController.updateFile(listProduct);
	                            	showProduct();
	                                return;
	                            }
	                            if (choice.equals("2")) { 
	                            	return;
	                            }
	                    }else {
	                    	System.out.println("product is not exist");
	                    	return;
	                    }
	                    
	                }
	               throw new ProductException();
	            } catch (ProductException n) {
	                n.getMassage();
	                System.out.println("Press Enter to back");
	                String luaChon = scanner.nextLine();
	                if (luaChon.equals("")) return;
	            }
			} while (true);
        } else System.out.println("File is null !");
		
	}
	private static void addProduct() {
		String choice;
	
        System.out.println("================================== "
        		+ "\n1. Add import product"
        		+ "\n2. Add export product"
        		+ "\n3. Back to manu"
        		+ "\n4. Exit\n==================================");
        System.out.print("input a add action : ");
        choice = scanner.nextLine();
      
        	
            switch (choice) {
                case "1":
                	AddController.addImport();
                    break;
                case "2":
                	AddController.addExport();
                    break;
                case "3":
                    break;
                case "4":
                    System.exit(0);
                default:
                    System.out.println("invalid! please choose action again!");
            }

		
	}
	public static void displayMainMenu() {
		System.out.println("1.	 Add new product\r\n" + 
				"2.	Delete product\r\n" + 
				"3.	Show all product\r\n" + 
				"4.	Search \r\n" + 
				"5.	Update \r\n" + 
				"6.	Exit\r\n" + 
				"======================================");
	}
}
