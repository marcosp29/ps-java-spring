package br.com.supera.game.store;

import java.math.BigDecimal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RestController;

import br.com.supera.game.store.service.ProductService;


@SpringBootApplication
@RestController
public class GameStoreApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(GameStoreApplication.class, args);
		
		ProductService productService = context.getBean(ProductService.class);
		productService.addProduct(
				312, 
				"Super Mario Odyssey",
				new BigDecimal("197.88"),
				(short) 100,
				"super-mario-odyssey.png"
				);
	}

}
