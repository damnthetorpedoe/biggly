
public class ProductInfo {

	private int id;
	private String name;
	private double rating;
	private double price;
	private String color;
	
	public ProductInfo() {
	}

	public ProductInfo(int id, String name, double rating) {
		this.id = id;
		this.name = name;
		this.rating = rating;
	}
	
	public ProductInfo(int id, String name, double rating, double price, String color) {
		this(id, name, rating);
		this.price = price;
		this.color = color;
		}
	
	public String toString() {
		return "Product info [id=" + id + ", name=" + name + ", rating=" + rating + ", price=" + price + ", color=" + color + "]";
	}
}
