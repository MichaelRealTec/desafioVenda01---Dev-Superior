package entities;

public class Sale {
	// Atributo
	private Integer month;
	private Integer year;
	private String seller;
	private Integer items;
	private Double total;
	
	// Método Getter e Setter
	public void setMonth(Integer month) {
		this.month = month;
	}
	
	public Integer getMonth() {
		return month;
	}
	
	public void setYear(Integer year) {
		this.year = year;
	}
	
	public Integer getYear() {
		return year;
	}
	
	public void setSeller(String seller){
		this.seller = seller;
	}
	
	public String getSeller() {
		return seller;
	}
	
	public void setItems(Integer items) {
		this.items = items;
	}
	
	public Integer getItems() {
		return items;
	}
	
	public void setTotal(Double total) {
		this.total = total;
	}
	
	public Double getTotal() {
		return total;
	}
	
	// Método Construtor
	public Sale(Integer month, Integer year, String seller, Integer items, Double total) {
		this.month = month;
		this.year = year;
		this.seller = seller;
		this.items = items;
		this.total = total;
	}
	
	// Método
	public Double averagePrice() {
		return total / items;
	}
	
	@Override
	public String toString() {
		return month +
				"/" + year
				+", " + seller
				+", " + items
				+", " + String.format("%.2f", total)
				+", pm = " + String.format("%.2f", averagePrice());
	}
}
