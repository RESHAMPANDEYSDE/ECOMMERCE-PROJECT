package com.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.Product;
import com.app.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController 
{
	 @Autowired
	    private ProductService productService;

	    @GetMapping
	    public List<Product> getAllProducts() {
	        return productService.getAllProducts();
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
	        Optional<Product> product = productService.getProductById(id);
	        return product.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	    }

	    @PostMapping
	    public Product createProduct(@RequestBody Product product) {
	        return productService.saveProduct(product);
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product) {
	        if (productService.getProductById(id).isPresent()) {
	            product.setId(id);
	            return ResponseEntity.ok(productService.saveProduct(product));
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
	        if (productService.getProductById(id).isPresent()) {
	            productService.deleteProduct(id);
	            return ResponseEntity.noContent().build();
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }
}
