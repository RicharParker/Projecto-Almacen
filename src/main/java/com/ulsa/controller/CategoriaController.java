package com.ulsa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ulsa.entity.Categoria;
import com.ulsa.repository.CategoriaRepository;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
@Controller
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
	public String addCategoria(@Validated Categoria categoria, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "categorias/add-categoria";
		}
		categoriaRepository.save(categoria);
		model.addAttribute("categorias", categoriaRepository.findAll());
		return "categorias/index-categorias";
	}
	
	@GetMapping("/newCategoria")
	public String showSignUpFormCategoria(Categoria categoria) {
		System.out.println("&&&&& showSignUpForm &&&&&&");
		return "categorias/add-categoria";
	}
	
	@GetMapping("/editCategoria/{id}")
	public String showUpdateFormCategoria(@PathVariable("id") long id, Model model) {
		Categoria categoria =
				categoriaRepository
				.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid categoria Id:" + id));
		model.addAttribute("categoria", categoria);
		return "categorias/update-categoria";
	}
	
	@GetMapping("/deleteCategoria/{id}")
	public String deleteCategoria(@PathVariable("id") long id, Model model) {
		Categoria categoria =
			categoriaRepository
				.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid categoria Id:" + id));
		categoriaRepository.delete(categoria);
		model.addAttribute("categorias", categoriaRepository.findAll());
		return "categorias/index-categorias";
	}
	
	@PostMapping("/updateCategoria/{id}")
	public String updateCategoria(@PathVariable("id") long id, @Validated Categoria categoria,
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
