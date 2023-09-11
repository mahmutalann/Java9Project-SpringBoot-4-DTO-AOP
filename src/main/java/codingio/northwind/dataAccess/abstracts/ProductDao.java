package codingio.northwind.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import codingio.northwind.entities.concretes.Product;
import codingio.northwind.entities.dtos.ProductWithCategoryDto;

public interface ProductDao extends JpaRepository<Product, Integer>{ //Interfaces are connected to each other with extends. //JpaRepository creates a new spring class according to <Product, Integer>. Also It works as a generic structure. JpaRepostory will bring data. JpaRepository provides saves, updates and findAll methods in the Database.
	Product getByProductName(String productName);
	
	Product getByProductNameAndCategory_CategoryId(String productName, int categoryId);
	
	List<Product> getByProductNameOrCategory_CategoryId(String productName, int categoryId);

	List<Product> getByCategoryIn(List<Integer> categories);
	
	List<Product> getByProductNameContains(String productName);

	List<Product> getByProductNameStartsWith(String productName);
	
	@Query("From Product where productName =: productName and category.categoryId =: categoryId")
	List<Product> getByNameAndCategory(String productName, int categoryId);
	
	@Query("Select new codingio.northwind.entities.dtos.ProductWithCategoryDto(p.id, p.productName, c.categoryName) From Category c Inner Join c.products p")
	List <ProductWithCategoryDto> getProductWithCategoryDetails();
}