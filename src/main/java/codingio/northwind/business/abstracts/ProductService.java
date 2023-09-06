package codingio.northwind.business.abstracts;

import java.util.List;

import codingio.northwind.entities.concretes.Product;

public interface ProductService {
	List<Product> getAll();
}