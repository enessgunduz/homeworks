//Muhammed Enes Gündüz - 150120038
public class Product {
	private String productName;
	private java.util.Calendar saleDate;
	private double price;
	
	public Product(String sName, java.util.Calendar sDate, double price) {
		productName = sName;
		saleDate = sDate;
		this.price = price;
	}
	
	public String toString() {
		return "[Product [productName="+productName+", transactionDate="+saleDate.get(5)+"/"+saleDate.get(2)+"/"+saleDate.get(1)+", price="+price+"]";
	}
	
	public String getProductName() {
		return productName;
	}
	
	public double getPrice() {
		return price;
	}
}
