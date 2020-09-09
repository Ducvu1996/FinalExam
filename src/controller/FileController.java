package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import model.ExportProduct;
import model.ImportProduct;
import model.Product;

public class FileController {
	private static final String COMMA = ",";
	private static final String ENTER = "\n";
	public static List<Product> readFile(){

	    List<Product> listProduct = new ArrayList<>();
	    File file = new File("C:\\Users\\USER\\eclipse-workspace\\FinalExam\\src\\data\\product.csv");
	    
	    if(file.isFile()) {
	    	try {
				
				FileReader fileReader = new FileReader(file);
				BufferedReader buffRead = new BufferedReader(fileReader);
				//System.out.println("hello");
				String line;
		        String[] temp;
		        Product product;
		        while ((line = buffRead.readLine()) != null) {
		            temp = line.split(COMMA);
		            if(temp.length==9) {
		            	product= new ImportProduct(Integer.parseInt(temp[0]), temp[1], temp[2], temp[3], temp[4], temp[5], temp[6], temp[7],
                                temp[8]);
		            	listProduct.add(product);
		            }else {
		            	product= new ExportProduct(Integer.parseInt(temp[0]), temp[1], temp[2], temp[3], temp[4], temp[5], temp[6], temp[7]);
		            	listProduct.add(product);
		            }
		        }
	        
		       
		        buffRead.close();
		     
			} catch (FileNotFoundException e) {
				 System.out.println(e.getMessage());
			}catch (IOException e) {
		        e.printStackTrace();
		    }	
	    }else {
	    	System.out.println("File is empty");
	    }
	    return listProduct;
	}
	public static void writeFile(Product product,String option) {
		 File file = new File("C:\\Users\\USER\\eclipse-workspace\\FinalExam\\src\\data\\product.csv");
		 FileWriter fileWriter=null;
		 try {
			 if(option.equals("insert"))  fileWriter= new FileWriter(file, true);
			 
			 if(option.equals("update"))  fileWriter= new FileWriter(file);
			
			 BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			 StringBuilder stringBuilder = new StringBuilder();
			 if(product instanceof ImportProduct) {
				 stringBuilder.append(product.getId()).append(COMMA);
				 stringBuilder.append(product.getProductCode()).append(COMMA);
				 stringBuilder.append(product.getProductName()).append(COMMA);
				 stringBuilder.append(product.getPrice()).append(COMMA);
				 stringBuilder.append(product.getNumberOfProduct()).append(COMMA);
				 stringBuilder.append(product.getCompany()).append(COMMA);
				 stringBuilder.append(product.getCompany()).append(COMMA);
				 stringBuilder.append(((ImportProduct) product).getImportPrice()).append(COMMA);
				 stringBuilder.append(((ImportProduct) product).getImportCity()).append(COMMA);
				 stringBuilder.append(((ImportProduct) product).getTax());
				 
				 
			 }else {
				 stringBuilder.append(product.getId()).append(COMMA);
				 stringBuilder.append(product.getProductCode()).append(COMMA);
				 stringBuilder.append(product.getProductName()).append(COMMA);
				 stringBuilder.append(product.getPrice()).append(COMMA);
				 stringBuilder.append(product.getNumberOfProduct()).append(COMMA);
				 stringBuilder.append(product.getCompany()).append(COMMA);
				 stringBuilder.append(product.getCompany()).append(COMMA);
				 stringBuilder.append(((ExportProduct) product).getExportPrice()).append(COMMA);
				 stringBuilder.append(((ExportProduct) product).getCountry());
			 }
			 
			 bufferedWriter.write(stringBuilder.toString());
			 bufferedWriter.append(ENTER);
			 bufferedWriter.flush();
			 bufferedWriter.close();
			 
		 } catch (FileNotFoundException f) {
	            System.out.println(f.getMessage());
	      }catch(Exception e) {
			 e.printStackTrace();
		 }
	}
	public static void updateFile(List<Product> listProduct) {
		for(Product product: listProduct) {
			writeFile(product, "update");
		}
		
	}
}
