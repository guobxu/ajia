package ajia.domain;

public class Product {

	private Integer id;
	private String name;
	private String sku;
	
	public Product(Integer id, String name, String sku) {
		this.id = id;
		this.name = name;
		this.sku = sku;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSku() {
		return sku;
	}
	
	public void setSku(String sku) {
		this.sku = sku;
	}
	
	
	
}
