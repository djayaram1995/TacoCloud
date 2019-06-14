package com.shop.taco.repository;

import com.shop.taco.model.TacoIngredients;

public interface IngredientRepository {
	Iterable<TacoIngredients> findAll();

	TacoIngredients findOne(String id);

	TacoIngredients save(TacoIngredients ingredient);

	TacoIngredients findOneJdbc(String id);
}