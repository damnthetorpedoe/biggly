package comparable_comparator_demo.model;

public class Dildo implements Comparable<Dildo> {

	private int id;
	private float size;
	private float price;
	private String material;
	private float rating;
	public boolean availability;
	
	public Dildo() {
		
	}
	
	
	public Dildo(int id, float size, float price, String material, float rating, boolean availability) {
		super();
		this.id = id;
		this.size = size;
		this.price = price;
		this.material = material;
		this.rating = rating;
		this.availability = availability;
	}


	




	

	public float getSize() {
		return size;
	}





	public void setSize(float size) {
		this.size = size;
	}





	public float getPrice() {
		return price;
	}





	public void setPrice(float price) {
		this.price = price;
	}





	public String getMaterial() {
		return material;
	}





	public void setMaterial(String material) {
		this.material = material;
	}





	public float getRating() {
		return rating;
	}





	public void setRating(float rating) {
		this.rating = rating;
	}





	public boolean isAvailability() {
		return availability;
	}





	public void setAvailability(boolean availability) {
		this.availability = availability;
	}


	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}


	@Override
	public int compareTo(Dildo o) {
		Float i1=this.price;
		Float i2=o.price;
		return 0;
	}


	@Override
	public String toString() {
		return "Dildo [id=" + id + ", size=" + size + ", price=" + price + ", material=" + material + ", rating="
				+ rating + ", availability=" + availability + "]";
	}
	
	
}
