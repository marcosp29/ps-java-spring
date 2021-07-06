package br.com.supera.game.store.service;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import br.com.supera.game.store.entity.Product;
import br.com.supera.game.store.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository proRepo;
	
	public void addProduct(int id, String name, BigDecimal price, short score, String image) {
		Product product = new Product();
		product.setId(id); 
	    product.setName(name);
	    product.setPrice(price); 
	    product.setScore(score);
	    product.setImage(image);

		proRepo.save(product);
	}
	
	public Product updateProduct(Product product) {
		Product newProduct = proRepo.findById(product.getId());
		return proRepo.save(newProduct);
	}
	
	public void deleteProduct(Product product) {
		proRepo.delete(product);
	}
	
	public List<Product> orderByAlphabetical(){
		List<Product> listProducts = proRepo.findAll();
		Collections.sort(listProducts);
		return listProducts;
	}
	
	public List<Product> orderByPrice(){
		List<Product> listProducts = proRepo.findAll();
		
		Collections.sort(listProducts, new Comparator<Product>() {
	        
			@Override
			public int compare(Product o1, Product o2) {
				return o1.getPrice().compareTo(o2.getPrice());
			}
	    });
		
		return listProducts;
	}
}
