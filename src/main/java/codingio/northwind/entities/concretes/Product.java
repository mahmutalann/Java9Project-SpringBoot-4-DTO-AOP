package codingio.northwind.entities.concretes;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Column;
import jakarta.persistence.Entity; //This will use to jpa infrastructure.
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Table;
import lombok.Data;

@Data //This provides that lombok.
@Entity //It says Product class called database object. This is annotation method. It shows to which class belongs to the layer. Also, annotation is that to collect data of class or function at the execution time.
@Table(name = "products")
public class Product {
	@Id
	@GeneratedValue //Creating id value method
	@Column(name = "product_id")
	private int id;
	
	@Column(name = "category_id")
	private int categoryId;
	
	@Column(name = "product_name")
	private String productName;
	
	@Column(name = "unit_price")
	private double unitPrice;
	
	@Column(name = "units_in_stock")
	private short unitsInStock;
	
	@Column(name = "quantity_per_unit")
	private String quantityPerUnit;
	
	public Product() {
		
	}
	
	public Product(int id, int categoryId, String productName, double unitPrice, short unitsInStock,
			String quantityPerUnit) {
		super();
		this.id = id;
		this.categoryId = categoryId;
		this.productName = productName;
		this.unitPrice = unitPrice;
		this.unitsInStock = unitsInStock;
		this.quantityPerUnit = quantityPerUnit;
	}
	
}