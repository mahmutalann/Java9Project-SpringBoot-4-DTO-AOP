package codingio.northwind.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data //This provides that lombok.
@Entity //It says Product class called database object. This is annotation method. It shows to which class belongs to the layer. Also, annotation is that to collect data of class or function at the execution time.
@Table(name = "products")
@AllArgsConstructor //It creates a constructor using fields via Lombok. 
@NoArgsConstructor //It creates a single constructor via Lombok. 
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Creating id value method with increment.
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
	

	
}