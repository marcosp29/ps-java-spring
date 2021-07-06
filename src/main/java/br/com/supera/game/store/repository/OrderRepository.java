package br.com.supera.game.store.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.supera.game.store.entity.Order;
import br.com.supera.game.store.entity.Product;

public interface OrderRepository extends JpaRepository<Order, Integer>{
	
	Order addProductById(long id);

	List<Product> findProductOrderedById(Product product);
}
