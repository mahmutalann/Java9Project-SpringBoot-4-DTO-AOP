package codingio.northwind.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import codingio.northwind.entities.concretes.Product;

public interface ProductDao extends JpaRepository<Product, Integer>{ //Interfaces are connected to each other with extends. //JpaRepository creates a new spring class according to <Product, Integer>. Also It works as a generic structure. JpaRepostory will bring data.

}