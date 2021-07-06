package br.com.supera.game.store.web.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.supera.game.store.entity.Product;
import br.com.supera.game.store.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	
	@Autowired
	private ProductService proService;
	
	@PostMapping
	public void addProduct(@RequestBody Product product) {
		proService.addProduct(product);
	}
	
	@DeleteMapping("/{id}")
	public void deleteProduct(@PathVariable Integer id) {
		proService.deleteProduct(id);
	}
	
	@GetMapping
	public List<Product> orderByAlphabetical(){
		return proService.orderByAlphabetical();
	}
	
	@GetMapping
	public List<Product> orderByPrice(){
		return proService.orderByPrice();
	}

}
