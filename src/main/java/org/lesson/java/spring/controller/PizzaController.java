package org.lesson.java.spring.controller;

import java.util.List;

import org.lesson.java.spring.model.Pizza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	@GetMapping("/{id}")
	public String show(@PathVariable("id") Integer id , Model model) {
	model.addAttribute("pizza", repository.findById(id).get());
	return "/pizzas/show";
	}
	
	@GetMapping("/findByNome/{nome}")
	public String findByNome(@PathVariable("nome")  String nome , Model model) {
	model.addAttribute("list", repository.findByNomeStartsWith(nome));
	return "/pizzas/index";
	}


	@GetMapping("/create")
	public String create(Model model) {
		model.addAttribute("pizza", new Pizza());
		return "/pizzas/create";
	}
	
	@PostMapping("/create")
	public String store(@ModelAttribute("pizza") Pizza formPizza,
			BindingResult bindingResult,
			Model model){
		
		if(bindingResult.hasErrors()) {
			return "/pizzas/create";
		}
		
		repository.save(formPizza);
		
		return "redirect:/pizas";
	}
	

}
