package br.com.supera.game.store.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.supera.game.store.entity.Order;
import br.com.supera.game.store.entity.Product;
import br.com.supera.game.store.repository.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository orderRepo;
	
	public void addNewProduct(Integer id) {
		orderRepo.addProductById(id);
	}
	
	public List<Product> itemsOrdered(Order order){
		List<Product> productsOrdered = orderRepo.findProductOrderedById(order.getItemsOrdered());
		return productsOrdered;
	}
	
	public Order updateOrder(Order order) {
		BigDecimal freeShipping = new BigDecimal(250);
		
		if((order.getItemsTotal().compareTo(freeShipping) == 0 )
				|| (order.getItemsTotal().compareTo(freeShipping)) == 1){
			
			order.setShipping(0);
			return orderRepo.save(order);
			
		}else {
			int totalItems = itemsOrdered(order).size();
			order.setShipping(totalItems*10);
			return orderRepo.save(order);
		}
		
	}
	
	public void deleteProduct(Integer id) {
		orderRepo.deleteById(id);
	}
}
