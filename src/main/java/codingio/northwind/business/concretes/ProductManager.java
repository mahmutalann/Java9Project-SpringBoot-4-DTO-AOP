package codingio.northwind.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired; //beans = project class   factory = dependency injection runs factory design pattern in the background so it is instance. 
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import codingio.northwind.business.abstracts.ProductService;
import codingio.northwind.core.utilities.results.DataResult;
import codingio.northwind.core.utilities.results.Result;
import codingio.northwind.core.utilities.results.SuccessDataResult;
import codingio.northwind.core.utilities.results.SuccessResult;
import codingio.northwind.dataAccess.abstracts.ProductDao;
import codingio.northwind.entities.concretes.Product;

@Service //It gives information to Spring that the class runs as a service duty.
public class ProductManager implements ProductService{
	
	private ProductDao productDao;
	@Autowired //Spring will create a class corresponding to the instances of ProductDao in the background. It is so common. It usually creates dependency. @Autowired(injection)  finds the class corresponding to the stated interface of all projects.
	public ProductManager(ProductDao productDao) {
		super();
		this.productDao = productDao;
	}

	@Override
	public DataResult<List<Product>> getAll() {

		return new SuccessDataResult<List<Product>>(this.productDao.findAll(), "Data Listed.");
	}

	@Override
	public Result add(Product product) {
		this.productDao.save(product);
		return new SuccessResult("Product added");
	}

	@Override
	public DataResult<Product> getByProductName(String productName) {
		//Business Codes
		return new SuccessDataResult<Product>(this.productDao.getByProductName(productName), "Data Listed.");
	}

	@Override
	public DataResult<Product> getByProductNameAndCategoryId(String productName, int categoryId) {
		return new SuccessDataResult<Product>(this.productDao.getByProductNameAndCategory_CategoryId(productName, categoryId), "Data Listed.");
	}

	@Override
	public DataResult<List<Product>> getByProductNameOrCategoryId(String productName, int categoryId) {
		return new SuccessDataResult<List<Product>>(this.productDao.getByProductNameOrCategory_CategoryId(productName, categoryId), "Data Listed.");
	}

	@Override
	public DataResult<List<Product>> getByCategoryIdIn(List<Integer> categories) {
		return new SuccessDataResult<List<Product>>(this.productDao.getByCategoryIn(categories), "Data Listed.");
	}

	@Override
	public DataResult<List<Product>> getByProductNameContains(String productName) {
		return new SuccessDataResult<List<Product>>(this.productDao.getByProductNameContains(productName), "Data Listed.");
	}

	@Override
	public DataResult<List<Product>> getByProductNameStartsWith(String productName) {
		return new SuccessDataResult<List<Product>>(this.productDao.getByProductNameStartsWith(productName), "Data Listed.");
	}

	@Override
	public DataResult<List<Product>> getByNameAndCategory(String productName, int categoryId) {
		return new SuccessDataResult<List<Product>>(this.productDao.getByNameAndCategory(productName, categoryId), "Data Listed.");
	}

	@Override
	public DataResult<List<Product>> getAll(int pageNo, int pageSize) {
	Pageable pageable = PageRequest.of(pageNo -1, pageSize);
		return new SuccessDataResult<List<Product>> (this.productDao.findAll(pageable).getContent());
	}

	@Override
	public DataResult<List<Product>> getAllSorted() {
	Sort sort = Sort.by(Sort.Direction.DESC, "productName");
			return new SuccessDataResult<List<Product>> (this.productDao.findAll(sort), "Success");
	}

}