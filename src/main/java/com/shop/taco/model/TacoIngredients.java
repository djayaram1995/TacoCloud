package com.shop.taco.model;

import org.springframework.stereotype.Repository;

public class TacoIngredients {
	private String id;
	private String name;
	private Type type;

	public static enum Type {
		WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
	}

	public TacoIngredients(String id, String name, Type type) {
		this.id = id;
		this.name = name;
		this.type = type;
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

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "TacoIngredients [id=" + id + ", name=" + name + ", type=" + type + "]";
	}
	
}