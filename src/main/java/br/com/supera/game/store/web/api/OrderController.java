package br.com.supera.game.store.web.api;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.supera.game.store.entity.Order;
import br.com.supera.game.store.entity.Product;
import br.com.supera.game.store.service.OrderService;

@RestController
@RequestMapping("/api/carrinho")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@PostMapping("/{id}")
	public void addNewProduct(@PathVariable Integer id) {
		orderService.addNewProduct(id);
	}
	
	@GetMapping
	public List<Product> itemsOrdered(@RequestBody Order order){
		return orderService.itemsOrdered(order);
	}
	
	@PutMapping
	public Order updateOrder(Order order) {
		return orderService.updateOrder(order);
	}
	
	@DeleteMapping("/{id}")
	public void deleteProduct(Integer id) {
		orderService.deleteProduct(id);
	}

}
