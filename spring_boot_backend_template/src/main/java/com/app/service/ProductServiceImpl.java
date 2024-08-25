package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.model.Product;

public interface ProductServiceImpl 
{
	 List<Product> getAllProducts();

	    Optional<Product> getProductById(Long id);

	    Product saveProduct(Product product);

	    void deleteProduct(Long id);
}
