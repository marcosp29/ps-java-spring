package br.com.supera.game.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.supera.game.store.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

	Product findById(long id);

}
