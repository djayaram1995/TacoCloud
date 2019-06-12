package com.shop.taco.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shop.taco.model.Taco;
import com.shop.taco.model.TacoIngredients;
import com.shop.taco.model.TacoIngredients.Type;
import com.shop.taco.repository.IngredientRepository;

@Controller
@RequestMapping("/design")
public class DesignTacoController {
	
	@Autowired
	private IngredientRepository sv;

	@GetMapping
	public String showDesignForm(Model model) {

		List<TacoIngredients> tacoIngredients = Arrays.asList(new TacoIngredients("FLTO", "Flour Tortilla", Type.WRAP),
				new TacoIngredients("COTO", "Corn Tortilla", Type.WRAP),
				new TacoIngredients("GRBF", "Ground Beef", Type.PROTEIN),
				new TacoIngredients("CARN", "Carnitas", Type.PROTEIN),
				new TacoIngredients("TMTO", "Diced Tomatoes", Type.VEGGIES),
				new TacoIngredients("LETC", "Lettuce", Type.VEGGIES),
				new TacoIngredients("CHED", "Cheddar", Type.CHEESE),
				new TacoIngredients("JACK", "Monterrey Jack", Type.CHEESE),
				new TacoIngredients("SLSA", "Salsa", Type.SAUCE),
				new TacoIngredients("SRCR", "Sour Cream", Type.SAUCE));
		Type[] types = TacoIngredients.Type.values();
		for (Type type : types) {
			model.addAttribute(type.toString().toLowerCase(), filterByType(tacoIngredients, type));
		}
		model.addAttribute("design", new Taco());
		return "design";
	}

	@PostMapping
	public String processDesign(@Valid Taco design, Errors errors, Model model) {
		if (errors.hasErrors()) {
			//TacoIngredients tc = sv.findOne("1");
			List<TacoIngredients> tcall = (List<TacoIngredients>) sv.findAll();
			//System.out.println("tc"+tc);
			System.out.println("tcall"+ tcall);
			model.addAttribute("error", errors.getAllErrors().get(0).getDefaultMessage());
			List<TacoIngredients> tacoIngredients = Arrays.asList(
					new TacoIngredients("FLTO", "Flour Tortilla", Type.WRAP),
					new TacoIngredients("COTO", "Corn Tortilla", Type.WRAP),
					new TacoIngredients("GRBF", "Ground Beef", Type.PROTEIN),
					new TacoIngredients("CARN", "Carnitas", Type.PROTEIN),
					new TacoIngredients("TMTO", "Diced Tomatoes", Type.VEGGIES),
					new TacoIngredients("LETC", "Lettuce", Type.VEGGIES),
					new TacoIngredients("CHED", "Cheddar", Type.CHEESE),
					new TacoIngredients("JACK", "Monterrey Jack", Type.CHEESE),
					new TacoIngredients("SLSA", "Salsa", Type.SAUCE),
					new TacoIngredients("SRCR", "Sour Cream", Type.SAUCE));
			Type[] types = TacoIngredients.Type.values();
			for (Type type : types) {
				model.addAttribute(type.toString().toLowerCase(), filterByType(tacoIngredients, type));
			}
			model.addAttribute("design", design);
			return "design";
		}
		// Save the taco design...
		// We'll do this in chapter 3
		System.out.println(design);
		return "redirect:/orders/current";
	}

	private List<TacoIngredients> filterByType(List<TacoIngredients> tacoIngredients, Type type) {
		List<TacoIngredients> tacoList = new ArrayList<TacoIngredients>();

		for (TacoIngredients taco : tacoIngredients) {
			if (taco.getType().equals(type)) {
				tacoList.add(taco);
			}
		}
		System.out.println(tacoList);
		return tacoList;
	}
}