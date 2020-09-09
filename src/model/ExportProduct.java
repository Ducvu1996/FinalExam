package model;

public class ExportProduct extends Product{
	private String exportPrice; 
	private String country;
	public ExportProduct() {
	    	
    }
    public ExportProduct(int id, String productCode, String productName, String price, String numberOfProduct,
			String company,String exportPrice,String country) {
		super(id,  productCode,  productName,  price,  numberOfProduct, company);
		this.exportPrice = exportPrice;
		this.country = country;
		
	}
    
    public String getExportPrice() {
		return exportPrice;
	}
	public void setExportPrice(String exportPrice) {
		this.exportPrice = exportPrice;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@Override

	public String toString() {
		return 	"Id: " + this.getId() 
				+ "ProductCode: " + this.getProductCode()
				+ "ProductName: " + this.getProductName() 
				+ "Price:" + this.getPrice()
				+ "Number Of Product:" + this.getNumberOfProduct() 
				+ "Company: " + this.getCompany() 
				+ "Export Price: "+this.getExportPrice()
				+ "Country:"+this.getCountry()
			;
	}
	
}
