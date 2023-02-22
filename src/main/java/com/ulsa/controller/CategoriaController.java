package com.ulsa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ulsa.entity.Categoria;
import com.ulsa.repository.CategoriaRepository;

public class CategoriaController {
private final CategoriaRepository categoriaRepository;
	
	//categoriaRepository = new CategoriaRepository;
	
	@Autowired
	public CategoriaController(CategoriaRepository categoriaRepository) {
		this.categoriaRepository = categoriaRepository; 
	}
	
	@GetMapping("/categorias")
	public String indexCategorias(Model model) {
		System.out.println("&&&&& indexCategorias &&&&&&");
		model.addAttribute("categorias", categoriaRepository.findAll());
		return "categorias/index-categorias";
		
	}
	
	@PostMapping("/addcategoria")
	public String addUser(@Validated Categoria categoria, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "categorias/add-categoria";
		}
		categoriaRepository.save(categoria);
		model.addAttribute("categorias", categoriaRepository.findAll());
		return "categorias/index-categorias";
	}
	
	@GetMapping("/new")
	public String showSignUpForm(Categoria categoria) {
		System.out.println("&&&&& showSignUpForm &&&&&&");
		return "categorias/add-categoria";
	}
	
	@GetMapping("/edit/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
		Categoria categoria =
				categoriaRepository
				.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid categoria Id:" + id));
		model.addAttribute("categoria", categoria);
		return "categorias/update-categoria";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteUser(@PathVariable("id") long id, Model model) {
		Categoria categoria =
			categoriaRepository
				.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid categoria Id:" + id));
		categoriaRepository.delete(categoria);
		model.addAttribute("categorias", categoriaRepository.findAll());
		return "categorias/index-categorias";
	}
	
	@PostMapping("/update/{id}")
	public String updateUser(@PathVariable("id") long id, @Validated Categoria categoria,
			BindingResult result, Model model) {
		if(result.hasErrors()) {
			categoria.setId_categoria(id);
			return "categorias/update-categoria";
		}
		categoriaRepository.save(categoria);
		model.addAttribute("categorias", categoriaRepository.findAll());
		return "categorias/index-categorias";
	}

}
