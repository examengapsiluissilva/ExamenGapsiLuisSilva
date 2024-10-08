package com.mx.model;

import java.math.BigDecimal;
 

import jakarta.persistence.*;

@Entity
public class Article {

    @Id
    @Column(length = 10, nullable = false, unique = true)
    private String id;

    @Column(length = 20, nullable = false)
    private String name;

    @Column(length = 200)
    private String description;

    @Column(precision = 10, scale = 2)
    private BigDecimal price;

    @Column(length = 10) 
    private String model;

    // Getters y Setters
 
    public Article() {} 

    public Article(String id, String name, String description, BigDecimal price, String model) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.model = model;
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

    // ... getters y setters ...
}