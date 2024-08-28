package org.lesson.java.spring.controller;

import java.util.List;

import org.lesson.java.spring.model.Pizza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pizzas")
public class PizzaController {
	
	@Autowired
	private PizzaRepository repository;
	
	@GetMapping
	public String index(Model model) {
	List<Pizza> result = repository.findAll();
	model.addAttribute("list", result);
	return "/pizzas/index";
	}
	
	@GetMapping("/show/{id}")
	public String show(@PathVariable("id") Integer id , Model model) {
	model.addAttribute("pizza", repository.findById(id).get());
	return "/pizzas/show";
	}
	

}
