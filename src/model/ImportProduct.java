package model;

public class ImportProduct extends Product{
	   private String importPrice;
	    private String importCity;
	    private String tax;
	    public ImportProduct() {
	    	
	    }
	    public ImportProduct(int id, String productCode, String productName, String price, String numberOfProduct,
				String company,String importPrice,String importCity,String tax) {
			super(id,  productCode,  productName,  price,  numberOfProduct, company);
			this.importPrice = importPrice;
			this.importCity = importCity;
			this.tax = tax;
		}
		public String getImportPrice() {
			return importPrice;
		}
		public void setImportPrice(String importPrice) {
			this.importPrice = importPrice;
		}
		public String getImportCity() {
			return importCity;
		}
		public void setImportCity(String importCity) {
			this.importCity = importCity;
		}
		public String getTax() {
			return tax;
		}
		public void setTax(String tax) {
			this.tax = tax;
		}
		@Override
		public String toString() {
			return 	"Id: " + this.getId() 
					+ "ProductCode: " + this.getProductCode()
					+ "ProductName: " + this.getProductName() 
					+ "Price:" + this.getPrice()
					+ "Number Of Product:" + this.getNumberOfProduct() 
					+ "Company: " + this.getCompany() 
					+"Import Price: "+this.importPrice
					+"Import City:"+this.getImportCity()
					+"Tax: "+this.tax;
		}
		
	    
}
