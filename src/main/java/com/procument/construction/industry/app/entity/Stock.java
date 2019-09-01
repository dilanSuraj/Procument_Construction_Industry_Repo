package com.procument.construction.industry.app.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;

@Entity(name = "stock")
public class Stock {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long stockid;

    @Column(name = "name")
    private String name;

    @Column(name = "reorderlevel")
    private int reorderlevel;
    
    @Column(name = "quantity")
    private int quantity;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getReorderlevel() {
		return reorderlevel;
	}

	public void setReorderlevel(int reorderlevel) {
		this.reorderlevel = reorderlevel;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Long getStockid() {
		return stockid;
	}

	@Override
	public String toString() {
		return "Stock [stockid=" + stockid + ", name=" + name + ", reorderlevel=" + reorderlevel + ", quantity="
				+ quantity + "]";
	}
    
    

}
