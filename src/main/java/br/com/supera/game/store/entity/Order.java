package br.com.supera.game.store.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@JoinColumn(name = "product_id")
	private Product itemOrdered;
	
	private BigDecimal itemsTotal;
	
	private BigDecimal orderTotal;
	
	private Integer shipping;
	
	
	protected Order() {}

	public Order(long id, Product itemOrdered, BigDecimal itemsTotal, BigDecimal orderTotal, Integer shipping) {
		super();
		this.id = id;
		this.itemOrdered = itemOrdered;
		this.itemsTotal = itemsTotal;
		this.orderTotal = orderTotal;
		this.shipping = shipping;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public BigDecimal getItemsTotal() {
		return itemsTotal;
	}

	public void setItemsTotal(BigDecimal itemsTotal) {
		this.itemsTotal = itemsTotal;
	}

	public BigDecimal getOrderTotal() {
		return orderTotal;
	}

	public void setOrderTotal(BigDecimal orderTotal) {
		this.orderTotal = orderTotal;
	}

	public Integer getShipping() {
		return shipping;
	}

	public void setShipping(Integer shipping) {
		this.shipping = shipping;
	}

	public Product getItemsOrdered() {
		return itemOrdered;
	}

	public void setItemsOrdered(Product itemsOrdered) {
		this.itemOrdered = itemsOrdered;
	}
	

}
