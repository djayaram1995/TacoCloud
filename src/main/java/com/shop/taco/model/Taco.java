package com.shop.taco.model;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class Taco {
	@NotBlank(message = "No Blank")
	private String name;
	@Size(min = 5, message = "more size needed")
	private List<TacoIngredients> ingredients;
	private Long id;
	private Date createdAt;

	public List<TacoIngredients> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<TacoIngredients> ingredients) {
		this.ingredients = ingredients;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Taco [name=" + name + ", ingredients=" + ingredients + "]";
	}

}
