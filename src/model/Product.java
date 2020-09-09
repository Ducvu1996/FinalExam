package model;

public abstract class Product {
	private int id;
	private String productCode;
	private String productName;
	private String price;
	private String numberOfProduct;
	private String company;
	public Product() {
		
	}
	public Product(int id, String productCode, String productName, String price, String numberOfProduct,
			String company) {
		this.id = id;
		this.productCode = productCode;
		this.productName = productName;
		this.price = price;
		this.numberOfProduct = numberOfProduct;
		this.company = company;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getNumberOfProduct() {
		return numberOfProduct;
	}
	public void setNumberOfProduct(String numberOfProduct) {
		this.numberOfProduct = numberOfProduct;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	@Override
	public abstract String toString(); 
	
	
}
