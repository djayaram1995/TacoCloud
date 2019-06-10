package com.shop.taco.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shop.taco.model.Order;

@Controller
@RequestMapping("/orders")
public class OrderController {
	@GetMapping("/current")
	public String order(Model model) {
		model.addAttribute("order", new Order());
		return "order";
		
	}
	@PostMapping
	public String processOrder(@Valid Order order, Errors errors) {
	 if (errors.hasErrors()) {
	 return "order";
	 }
	 
	 return "redirect:/";
	}
}
